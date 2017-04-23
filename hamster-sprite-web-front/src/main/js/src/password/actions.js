import fetch from 'isomorphic-fetch';
import { push } from 'react-router-redux'

import appConfig from '../config/AppConfig.js';

import * as Urls from '../config/Urls.js';
import * as Consts from './consts.js';

/////////////////
// Navigations //
/////////////////
export const navigateApplication = (applicationId) => {
  return push(`/password/application/${applicationId}`)
}

export const requestApplications = () => {
  return {
    type : Consts.PWD_REQUEST_APPLICATIONS
  }
}

export const receiveApplications = (json) => {
  return {
    type: Consts.PWD_RECEIVE_APPLICATIONS,
    applications: json.data
  }
}

export const fetchApplications = () => {
  return dispatch => {
    dispatch(requestApplications());
    return fetch(appConfig.url(Urls.PASSWORD_APPLICATION_LIST))
      .then((response) => {
        if (response.status >= 400) {
    			throw new Error("Bad response from server");
    		}
        return response.json();
      })
      .then(json => dispatch(receiveApplications(json)))
  }
}

export const requestApplication = (applicationId) => {
  return {
    type : Consts.PWD_REQUEST_APPLICATION,
    applicationId : applicationId
  }
}

export const receiveApplication = (applicationId, json) => {
  return {
    type: Consts.PWD_RECEIVE_APPLICATION,
    applicationId : applicationId,
    application : json.data
  }
}

export const fetchApplication = (applicationId) => {
  return dispatch => {
    dispatch(requestApplication(applicationId))
    return fetch(appConfig.url(`/password/application/${applicationId}.json`))
      .then((response) => {
        if (response.status >= 400) {
    			throw new Error("Bad response from server");
    		}
        return response.json();
      })
      .then(json => dispatch(receiveApplication(applicationId, json)))
  }
}
