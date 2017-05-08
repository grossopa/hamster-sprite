import { connect } from 'react-redux'
import LayoutHeader from './LayoutHeader.js'

const mapStateToProps = (state, ownProps) => {
  return {
    title : state.apps.title,
    iconElementLeft : state.apps.iconElementLeft,
    iconElementRight : state.apps.iconElementRight
  }
}

const mapDispatchToProps = (dispatch, ownProps) => {
  return {
    onReloadHandler : () => {

    }
  }
}

const LayoutHeaderRedux = connect(mapStateToProps, mapDispatchToProps)(LayoutHeader)
export default LayoutHeaderRedux
