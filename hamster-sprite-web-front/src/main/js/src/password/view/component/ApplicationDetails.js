import React, { Component } from 'react'
import Paper from 'material-ui/Paper'
import RaisedButton from 'material-ui/RaisedButton'
import FlatButton from 'material-ui/FlatButton'
import Dialog from 'material-ui/Dialog'
import {List, ListItem } from 'material-ui/List'
import Subheader from 'material-ui/Subheader'
import Moment from 'react-moment'
import ContentInbox from 'material-ui/svg-icons/content/inbox'
import Clipboard from 'clipboard'

import './ApplicationDetails.css'

class ApplicationDetails extends Component {
  state : {
    accountDialogOpen : false
  }

  paperStyle = {
    width : '100%',
    marginTop : 5,
    padding : 5
  }

  constructor(props) {
    super(props)

    this.onAccountClick = this.onAccountClick.bind(this)
    this.onAccountDialogCloseClick = this.onAccountDialogCloseClick.bind(this)
    this.onAccountDialogRequestPasswordClick = this.onAccountDialogRequestPasswordClick.bind(this)
    this.onCopyClick = this.onCopyClick.bind(this)
  }

  componentWillMount() {
    if (this.props.applicationId && !this.props.application) {
      this.props.onReloadHandler(this.props.applicationId)
    }
  }

  onAccountClick(accountId, accountName) {
    this.props.onAccountClickHandler(accountId, accountName);
  }

  onAccountDialogCloseClick() {
    this.props.onAccountDialogCloseClickHandler()
  }

  onAccountDialogRequestPasswordClick() {
    this.props.onRevealPasswordHandler(this.props.selectedAccountId)
  }

  onCopyClick() {
    const clipboard = new Clipboard('#password_copy_btn')
  }

  render() {
    const application = this.props.application
    const accounts = this.props.accounts ? this.props.accounts : []
    const plainPassword = this.props.plainPassword
    const accountDialogOpen = this.props.accountDialogOpen
    const selectedAccountName = this.props.selectedAccountName
    const selectedAccountId = this.props.selectedAccountId

    const actions = [
      <FlatButton label="Update" secondary={true} style={{float : 'left'}}/>,
      !plainPassword
      ? <FlatButton label="Request Password" primary={true} keyboardFocused={true} onTouchTap={() => this.onAccountDialogRequestPasswordClick()}/>
      : <FlatButton id="password_copy_btn" label="Copy" primary={true}  data-clipboard-text={plainPassword} onTouchTap={() => this.onCopyClick()} />
    ];

    return (<section>
      {application && <div>
      <Paper style={this.paperStyle}>
        <h3>{application.name}</h3>
        <h4>{application.url}</h4>
        <Subheader>Last Modified : {application.updatedBy} on <Moment date={application.updatedOn} /> </Subheader>
      </Paper>
      <Paper style={this.paperStyle}>
        <h3>Accounts</h3>
        <List>
          {accounts.map((account) => {
            return (<ListItem key={account.id} primaryText={account.accountName} leftIcon={<ContentInbox />}
              onTouchTap={() => this.onAccountClick(account.id, account.accountName)} />)
          })}
        </List>
      </Paper></div>}
      {accountDialogOpen && <Dialog
          title={`${selectedAccountName}`}
          modal={false}
          actions={actions}
          onRequestClose={this.onAccountDialogCloseClick}
          open={accountDialogOpen}>
          {plainPassword && <div>
            <h5>Password</h5>
            <label style={{wordWrap : 'break-word'}}>${plainPassword}</label>
          </div>}
        </Dialog>}
    </section>)
  }
}

export default ApplicationDetails
