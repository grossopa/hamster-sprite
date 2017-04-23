import { connect } from 'react-redux'
import ApplicationDetails from './ApplicationDetails.js'

import { fetchApplication } from '../../actions.js'

const mapStateToProps = (state, ownProps) => {
  return {
    applicationId : state.routerReducer.applicationId,
    application : state.applications.application
  }
}

const mapDispatchToProps = (dispatch, ownProps) => {
  return {
    onReloadHandler : (applicationId) => {
      dispatch(fetchApplication(applicationId))
    }
  }
}

const ApplicationDetailsRedux = connect(mapStateToProps, mapDispatchToProps)(ApplicationDetails)
export default ApplicationDetailsRedux
