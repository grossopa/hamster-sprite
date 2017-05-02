import { connect } from 'react-redux'
import ApplicationDetails from './ApplicationDetails.js'

import { fetchApplication, fetchAccounts, fetchPasswordReveal, openAccountDialog, closeAccountDialog } from '../../actions.js'

const mapStateToProps = (state, ownProps) => {
  return {
    applicationId : state.routerReducer.applicationId,
    application : state.applications.application,
    accounts : state.applications.accounts,
    plainPassword : state.applications.plainPassword,
    accountDialogOpen : state.applications.accountDialogOpen,
    selectedAccountId : state.applications.selectedAccountId,
    selectedAccountName : state.applications.selectedAccountName
  }
}

const mapDispatchToProps = (dispatch, ownProps) => {
  return {
    onReloadHandler : (applicationId) => {
      dispatch(fetchApplication(applicationId))
      dispatch(fetchAccounts(applicationId))
    },
    onRevealPasswordHandler : (accountId) => {
      dispatch(fetchPasswordReveal(accountId))
    },
    onAccountClickHandler : (accountId, accountName) => {
      dispatch(openAccountDialog(accountId, accountName))
    },
    onAccountDialogCloseClickHandler : () => {
      dispatch(closeAccountDialog())
    }
  }
}

const ApplicationDetailsRedux = connect(mapStateToProps, mapDispatchToProps)(ApplicationDetails)
export default ApplicationDetailsRedux
