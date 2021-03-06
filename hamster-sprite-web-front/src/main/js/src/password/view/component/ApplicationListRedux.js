import { connect } from 'react-redux'
import ApplicationList from './ApplicationList.js'

import { fetchApplications, navigateApplication } from '../../actions.js'

const mapStateToProps = (state, ownProps) => {
  return {
    applications : state.applications.applications
  }
}

const mapDispatchToProps = (dispatch) => {
  return {
    onComponentDidMountHandler : () => {
      dispatch(fetchApplications())
    },
    onRowClickHandler : (id) => {
      dispatch(navigateApplication(id))
    }
  }
}

const ApplicationListRedux = connect(mapStateToProps, mapDispatchToProps)(ApplicationList)
export default ApplicationListRedux
