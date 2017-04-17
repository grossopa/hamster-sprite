import * as Consts from './consts.js';

function applications(state = {
  isFetching: false,
  items: []
}, action) {
  switch (action.type) {
    case Consts.PWD_REQUEST_APPLICATIONS:
      return Object.assign({}, state, {
        isFetching: true
      })
    case Consts.PWD_RECEIVE_APPLICATIONS:
      return Object.assign({}, state, {
        isFetching: false,
        applications: action.applications
      })
    default:
      return state
  }
};

const reducers = {
  applications
};

export default reducers;
