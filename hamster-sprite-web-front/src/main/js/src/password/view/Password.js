import React, {Component} from 'react'
import { Route } from 'react-router-dom'
import FlatButton from 'material-ui/FlatButton'

import ApplicationList from './component/ApplicationListRedux.js'
import ApplicationDetails from './component/ApplicationDetailsRedux.js'

export default class Password extends Component {

  componentDidMount() {
    this.props.updateAppBarHandler("Password Manager", null, <FlatButton label="Add"  />)
  }

  render() {
    return (
      <section>
        <Route path="/password/applications" component={ApplicationList} exact={true}  />
        <Route path="/password/application/:applicationId" component={ApplicationDetails} />
      </section>);
  }
}
