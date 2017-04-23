import React, {Component} from 'react';
import { connect } from 'react-redux'

import { fetchApplications } from '../actions';
import ApplicationList from './component/ApplicationListRedux.js'


class Password extends Component {
  componentDidMount() {
    const { dispatch } = this.props;
    dispatch(fetchApplications());
  }

  render() {
    return (<section><ApplicationList></ApplicationList></section>);
  }
}

function mapStateToProps(state) {
  const {
    isFetching,
    items: applications
  } = {
    isFetching: true,
    items: []
  }

  return {
    applications,
    isFetching
  }
}

export default connect(mapStateToProps)(Password);
