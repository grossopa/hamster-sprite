import React, { Component } from 'react'
import SelectField from 'material-ui/SelectField'
import RaisedButton from 'material-ui/RaisedButton'
import TextField from 'material-ui/TextField'
import MenuItem from 'material-ui/MenuItem'
import { RadioButton, RadioButtonGroup } from 'material-ui/RadioButton'

class AddApplication extends Component {

  NEW_ACCOUNT_VALUE = "new_account"

  constructor(props) {
    super(props)
    this.state = { selectedApplication : null }

    this.handleApplicationSelectChange = this.handleApplicationSelectChange.bind(this)
    this.handleAccountSelectChange = this.handleAccountSelectChange.bind(this)
    this.onGeneratePasswordClick = this.onGeneratePasswordClick.bind(this)
    this.onUpdateButtonClick = this.onUpdateButtonClick.bind(this)
    this.onCreateButtonClick = this.onCreateButtonClick.bind(this)
  }

  componentDidMount() {
    this.props.onComponentDidMountHandler()
  }

  handleApplicationSelectChange(event, index, value) {
    this.setState({selectedApplication : value, selectedAccount : null})
    this.props.onApplicationSelectHandler(value)
  }

  handleAccountSelectChange(event, value) {
    this.setState({selectedAccount : value})
    this.props.emptyPlainPasswordHandler()
    if (value != this.NEW_ACCOUNT_VALUE) {
      this.props.onAccountSelectHandler(value)
    }
  }

  onGeneratePasswordClick() {
    this.props.onGeneratePasswordHandler('default')
  }

  onUpdateButtonClick(accountId, plainPassword) {
    this.props.onUpdateClickHandler(accountId, plainPassword)
  }

  onCreateButtonClick(applicationId, accountId, plainPassword) {
    this.props.onCreateAccountHandler(applicationId, accountId, plainPassword)
  }

  render() {
    const applications = this.props.applications || []
    const applicationId = this.props.applicationId
    const accounts = this.props.accounts || []
    const plainPassword = this.props.plainPassword

    const selectedApplication = this.state.selectedApplication
    const selectedAccount = this.state.selectedAccount

    return (<div>
      <SelectField
      floatingLabelText="Applications"
      value={selectedApplication}
      onChange={this.handleApplicationSelectChange}>
      {applications.map((application) => {
        return (<MenuItem key={application.id} value={application.id} primaryText={application.name} />)
      })}
      </SelectField>

      <RadioButtonGroup name="existingAccountsGroup" style={{display : selectedApplication ? 'block' : 'none'}}
        onChange={this.handleAccountSelectChange}>
      {accounts.map((account) => {
        return (<RadioButton
          key={account.id}
          value={account.id}
          label={account.accountName}
          />)
        }).concat([
          <RadioButton key="newAccount" label="New Account" value={this.NEW_ACCOUNT_VALUE} />
        ])}
      </RadioButtonGroup>

      <TextField hintText="New account name" style={{display : selectedAccount == this.NEW_ACCOUNT_VALUE ? 'block' : 'none'}} />
      <div style={{display : selectedAccount ? 'block' : 'none'}} >
        <RaisedButton label="Generate password" secondary={true} onTouchTap={this.onGeneratePasswordClick} />
        <label>{plainPassword}</label>
      </div>

      <RaisedButton label="Update" style={{display : selectedAccount && selectedAccount != this.NEW_ACCOUNT_VALUE ? 'block' : 'none'}}
        primary={true} fullWidth={true}
        onTouchTap={this.onUpdateButtonClick} />

      <RaisedButton label="Create" style={{display : selectedAccount == this.NEW_ACCOUNT_VALUE ? 'block' : 'none'}}
        primary={true} fullWidth={true}
        onTouchTap={this.onCreateButtonClick} />
      </div>)
  }
}

export default AddApplication
