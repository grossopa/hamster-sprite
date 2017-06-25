import React, {Component} from 'react'
import { Route } from 'react-router-dom'
import FlatButton from 'material-ui/FlatButton'

import ApplicationList from './component/ApplicationListRedux.js'
import ApplicationDetails from './component/ApplicationDetailsRedux.js'
import ApplicationManagement from './component/ApplicationManagementRedux.js'

export default class Password extends Component {

  componentDidMount() {
    this.props.updateAppBarHandler("Password Manager", null, <FlatButton label="Add" onTouchTap={this.props.navigateApplicationManagementHandler} />)
  }

  render() {
    return (
      <section>
        <Route path="/password" component={ApplicationList} exact={true}  />
        <Route path="/password/application/:applicationId" component={ApplicationDetails} />
        <Route path="/password/management" component={ApplicationManagement} />
      </section>);
  }
}
