import { connect } from 'react-redux'
import ApplicationList from './ApplicationList.js'

import { fetchApplications } from '../../actions.js'

const mapStateToProps = (state, ownProps) => {

  return {
    applications : state.applications.applications
  }
}

const mapDispatchToProps = (dispatch) => {
  return {
    onComponentDidMountHandler :  () => {
      fetchApplications()
    }
  }
}

const ApplicationListRedux = connect(mapStateToProps, mapDispatchToProps)(ApplicationList)
export default ApplicationListRedux
