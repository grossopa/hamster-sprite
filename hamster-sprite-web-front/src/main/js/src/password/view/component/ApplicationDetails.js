import React, { Component } from 'react'
import Paper from 'material-ui/Paper'
import RaisedButton from 'material-ui/RaisedButton'
import FlatButton from 'material-ui/FlatButton'
import Dialog from 'material-ui/Dialog'
import {List, ListItem, makeSelectable } from 'material-ui/List'
import Subheader from 'material-ui/Subheader'
import Moment from 'react-moment'
import ContentInbox from 'material-ui/svg-icons/content/inbox'
import Clipboard from 'clipboard'

import './ApplicationDetails.css'

let SelectableList = makeSelectable(List)

function wrapState(ComposedComponent) {
  return class SelectableList extends Component {
    componentWillMount() {
      this.setState({
        selectedIndex: this.props.defaultValue,
      })
    }

    handleRequestChange = (event, index) => {
      this.setState({
        selectedIndex: index,
      })
    }

    render() {
      return (<ComposedComponent
          value={this.state.selectedIndex}
          onChange={this.handleRequestChange}>
          {this.props.children}
        </ComposedComponent>
      );
    }
  }
}

SelectableList = wrapState(SelectableList);

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

  onAccountRequestPasswordClick(accountId) {
    this.props.onRevealPasswordHandler(accountId)
  }

  onAccountDialogRequestPasswordClick() {
    this.props.onRevealPasswordHandler(this.props.selectedAccountId)
  }

  onNextedListToggle(listItem, accountId) {
    const {open} = listItem.state
    if (open) {
      this.props.onRevealPasswordHandler(accountId)
    }
  }

  onCopyClick(accountId) {
    const clipboard = new Clipboard(`#password_copy_${accountId}`)
  }

  render() {
    const _this = this

    const application = this.props.application
    const accounts = this.props.accounts ? this.props.accounts : []

    // const actions = ([<ListItem>
    //   <FlatButton key="update_btn" label="Update" secondary={true} style={{float : 'left'}}/>
    //   {!plainPassword
    //   ? <FlatButton key="request_password_btn" label="Request Password" primary={true} onTouchTap={() => this.onAccountDialogRequestPasswordClick()}/>
    //   : <FlatButton key="password_copy_btn" id="password_copy_btn" label="Copy" primary={true}  data-clipboard-text={plainPassword} onTouchTap={() => this.onCopyClick()} />}
    // </ListItem>])

    return (<section>
      {application && <div>
      <Paper style={this.paperStyle}>
        <h3>{application.name}</h3>
        <h4>{application.url}</h4>
        <Subheader>Last Modified : {application.updatedBy} on <Moment date={application.updatedOn} /> </Subheader>
      </Paper>
      <Paper style={this.paperStyle}>
        <h3>Accounts</h3>
          {accounts.map((account) => {
            return (<ListItem key={account.id} primaryText={account.accountName} leftIcon={<ContentInbox />}
              initiallyOpen={false} primaryTogglesNestedList={true}
              onTouchTap={() => {}}
              onNestedListToggle={(listItem) => {_this.onNextedListToggle(listItem, account.id)}}
                nestedItems={[<ListItem key={`pwd_${account.id}`}
                  onTouchTap={() => this.onCopyClick(account.id)}>
                <h4>{account.plainPassword}</h4>
              </ListItem>]} />)
          })}
      </Paper></div>}
    </section>)
  }
}

export default ApplicationDetails
