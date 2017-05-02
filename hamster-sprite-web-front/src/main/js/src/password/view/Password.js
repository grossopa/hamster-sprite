import React, {Component} from 'react'
import { Route } from 'react-router-dom'
import { connect } from 'react-redux'

import ApplicationList from './component/ApplicationListRedux.js'
import ApplicationDetails from './component/ApplicationDetailsRedux.js'


class Password extends Component {
  render() {
    return (
      <section>
        <Route path="/password/applications" component={ApplicationList} exact={true}  />
        <Route path="/password/application/:applicationId" component={ApplicationDetails} />
      </section>);
  }
}

function mapStateToProps(state) {
  return state
}

export default connect(mapStateToProps)(Password);
