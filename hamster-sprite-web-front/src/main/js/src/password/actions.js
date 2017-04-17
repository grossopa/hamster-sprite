import fetch from 'isomorphic-fetch';

import appConfig from '../config/AppConfig.js';

import * as Urls from '../config/Urls.js';
import * as Consts from './consts.js';

export function requestApplications() {
  console.log(Consts.PWD_REQUEST_APPLICATIONS);
  return {
    type : Consts.PWD_REQUEST_APPLICATIONS
  };
}

export function receiveApplications(json) {
  console.log(Consts.PWD_RECEIVE_APPLICATIONS);
  return {
    type: Consts.PWD_RECEIVE_APPLICATIONS,
    applications: json.data
  };
}

export function fetchApplications() {
  return (dispatch, getState) => {
    return dispatch(doFetchApplications(dispatch));
  };
}

function doFetchApplications(dispatch) {
  return dispatch => {
    dispatch(requestApplications());
    return fetch(appConfig.url(Urls.PASSWORD_APPLICATION_LIST))
      .then(function(response) {
        console.log('fetch Done');
        if (response.status >= 400) {
    			throw new Error("Bad response from server");
    		}
        return response.json();
      })
      .then(json => dispatch(receiveApplications(json)))
  };
}
