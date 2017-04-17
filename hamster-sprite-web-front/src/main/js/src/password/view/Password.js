import React, {Component} from 'react';
import { connect } from 'react-redux'

import { fetchApplications } from '../actions';


class Password extends Component {
  constructor(props) {
    super(props);
  }

  componentDidMount() {
    const { dispatch } = this.props;
    console.log('dispatch fetchApplications' + fetchApplications);
    dispatch(fetchApplications());
  }

  render() {
    return (<div>hello Password</div>);
  }
}

function mapStateToProps(state) {
  console.log(state)
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
