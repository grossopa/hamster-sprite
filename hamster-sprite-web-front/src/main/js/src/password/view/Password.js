import React, {Component} from 'react';
import { connect } from 'react-redux'

import { fetchApplications } from '../actions';
import ApplicationList from './component/ApplicationListRedux.js'
import ApplicationDetails from './component/ApplicationDetailsRedux.js'


class Password extends Component {
  render() {
    return (<section>
        <ApplicationList></ApplicationList>
        <ApplicationDetails></ApplicationDetails>
      </section>);
  }
}

function mapStateToProps(state) {
  return state
}

export default connect(mapStateToProps)(Password);
