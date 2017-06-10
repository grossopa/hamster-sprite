import { connect } from 'react-redux'
import AddApplication from './AddApplication.js'

import { fetchApplications } from '../../actions.js'

const mapStateToProps = (state, ownProps) => {
  return {
    applications : state.applications.applications
  }
}

const mapDispatchToProps = (dispatch) => {
  return {
    onComponentDidMountHandler : () => {
      dispatch(fetchApplications())
    }
  }
}

const AddApplicationRedux = connect(mapStateToProps, mapDispatchToProps)(AddApplication)
export default AddApplicationRedux
