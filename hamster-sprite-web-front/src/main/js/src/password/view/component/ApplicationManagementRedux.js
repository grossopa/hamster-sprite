import { connect } from 'react-redux'
import ApplicationManagement from './ApplicationManagement.js'

import { fetchApplications, fetchAccounts, fetchPasswordReveal, emptyPlainPassword, generatePassword, updatePassword, createAccount } from '../../actions.js'

const mapStateToProps = (state, ownProps) => {
  return {
    applications : state.applications.applications,
    applicationId : state.applications.applicationId,
    accounts : state.applications.accounts,
    plainPassword : state.applications.plainPassword
  }
}

const mapDispatchToProps = (dispatch) => {
  return {
    onComponentDidMountHandler : () => {
      dispatch(fetchApplications())
    },
    onApplicationSelectHandler : (applicationId) => {
      dispatch(fetchAccounts(applicationId))
    },
    onAccountSelectHandler : (accountId) => {
      dispatch(fetchPasswordReveal(accountId))
    },
    emptyPlainPasswordHandler : () => {
      dispatch(emptyPlainPassword())
    },
    onGeneratePasswordHandler : (rule) => {
      dispatch(generatePassword(rule))
    },
    onUpdateClickHandler : (accountId, plainPassword) => {
      dispatch(updatePassword(accountId, plainPassword))
    },
    onCreateAccountHandler : (applicationId, accountId, plainPassword) => {
      dispatch(createAccount(applicationId, accountId, plainPassword))
    }

  }
}

const ApplicationManagementRedux = connect(mapStateToProps, mapDispatchToProps)(ApplicationManagement)
export default ApplicationManagementRedux
