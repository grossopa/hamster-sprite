import { connect } from 'react-redux'
import ApplicationDetails from './ApplicationDetails.js'

import { fetchApplication, fetchAccounts, fetchPasswordReveal, openAccountDialog, closeAccountDialog } from '../../actions.js'

const mapStateToProps = (state, ownProps) => {
  const nextProps = {
    applicationId : state.routerReducer.applicationId,
    application : state.applications.application,
    accounts : state.applications.accounts,
    accountDialogOpen : state.applications.accountDialogOpen,
  }

  const {accountId, plainPassword} = state.applications
  if (plainPassword) {
    console.log(nextProps.accounts)
    nextProps.accounts.forEach((account) => {
      if (account.id == accountId) {
        account.plainPassword = plainPassword
      }
    })
  }

  return nextProps
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
