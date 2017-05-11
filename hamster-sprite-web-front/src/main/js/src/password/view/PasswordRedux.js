import { connect } from 'react-redux'
import Password from './Password.js'

import { updateAppBar } from '../../app/actions.js'

const mapStateToProps = (state) => {
  return state
}

const mapDispatchToProps = (dispatch, ownProps) => {
  return {
    updateAppBarHandler : (title, iconElementLeft, iconElementRight) => {
      dispatch(updateAppBar(title, iconElementLeft, iconElementRight))
    }
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(Password);
