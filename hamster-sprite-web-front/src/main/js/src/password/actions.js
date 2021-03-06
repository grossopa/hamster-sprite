import { push } from 'react-router-redux'

import appConfig from '../config/AppConfig.js';

import fetch from '../util/Fetch.js';
import * as Urls from '../config/Urls.js';
import * as Consts from './consts.js';

/////////////////
// Navigations //
/////////////////
export const navigateApplication = (applicationId) => {
  return push(`/password/application/${applicationId}`)
}

export const navigateApplicationManagement = () => {
  return push(`/password/management`)
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

export const requestAccounts = (applicationId) => {
  return {
    type : Consts.PWD_REQUEST_ACCOUNTS,
    applicationId : applicationId
  }
}

export const receiveAccounts = (applicationId, json) => {
  return {
    type : Consts.PWD_RECEIVE_ACCOUNTS,
    applicationId : applicationId,
    accounts : json.data
  }
}

export const fetchAccounts = (applicationId) => {
  return dispatch => {
    dispatch(requestAccounts(applicationId))
    return fetch(appConfig.url(`/password/account/list.json`), {
      queryParams : {
        applicationId : applicationId
      }
    })
      .then((response) => {
        if (response.status >= 400) {
          throw new Error("Bad response from server");
        }
        return response.json();
      })
      .then(json => dispatch(receiveAccounts(applicationId, json)))
  }
}


export const requestPasswordReveal = (accountId) => {
  return {
    type : Consts.PWD_REQUEST_PASSWORD_REVEAL,
    accountId : accountId
  }
}

export const receivePasswordReveal = (accountId, json) => {
  return {
    type : Consts.PWD_RECEIVE_PASSWORD_REVEAL,
    accountId : accountId,
    plainPassword : json.data.plainPassword
  }
}

export const fetchPasswordReveal = (accountId) => {
  return dispatch => {
    dispatch(requestPasswordReveal(accountId))
    return fetch(appConfig.url('/password/password/reveal.json', {
      accountId : accountId
    }))
      .then((response) => {
        if (response.status >= 400) {
          throw new Error("Bad response from server");
        }
        return response.json();
      })
      .then(json => dispatch(receivePasswordReveal(accountId, json)))
  }
}

export const emptyPlainPassword = () => {
  return {
    type : Consts.PWD_EMPTY_PLAIN_PASSWORD,
    plainPassword : null
  }
}

export const requestGeneratePassword = (rule) => {
  return {
    type : Consts.PWD_REQUEST_GENERATE_PASSWORD,
    rule : rule
  }
}

export const receiveGeneratePassword = (rule, json) => {
  return {
    type : Consts.PWD_RECEIVE_GENERATE_PASSWORD,
    rule : rule,
    plainPassword : json.data.plainPassword
  }
}

export const generatePassword = (rule) => {
  return dispatch => {
    dispatch(requestGeneratePassword(rule))
    return fetch(appConfig.url(`/password/password/generate.json`), {
      queryParams : {
        rule : rule
      }
    })
      .then((response) => {
        if (response.status >= 400) {
          throw new Error("Bad response from server");
        }
        return response.json();
      })
      .then(json => dispatch(receiveGeneratePassword(rule, json)))
  }
}

export const requestUpdatePassword = (accountId, plainPassword) => {
  return {
    type : Consts.PWD_REQUEST_UPDATE_PASSWORD,
    accountId : accountId,
    plainPassword : plainPassword
  }
}

export const receiveUpdatePassword = (json, accountId, plainPassword) => {
  return {
    type : Consts.PWD_RECEIVE_UPDATE_PASSWORD,
    accountId : accountId,
    plainPassword : plainPassword,
    message : json.message
  }
}

export const updatePassword = (accountId, plainPassword) => {
  return dispatch => {
    dispatch(requestUpdatePassword(accountId, plainPassword))
    return fetch(appConfig.url(`/password/password/update.json`), {
      queryParams : {
        accountId : accountId,
        plainPassword : plainPassword
      }
    })
      .then((response) => {
        if (response.status >= 400) {
          throw new Error("Bad response from server");
        }
        return response.json();
      })
      .then(json => dispatch(receiveUpdatePassword(json, accountId, plainPassword)))
  }
}

export const requestCreateAccount = (applicationId, accountId, plainPassword) => {
  return {
    type : Consts.PWD_REQUEST_CREATE_ACCOUNT,
    applicationId : applicationId,
    accountId : accountId,
    plainPassword : plainPassword
  }
}

export const receiveCreateAccount = (json, applicationId, accountId, plainPassword) => {
  return {
    type : Consts.PWD_RECEIVE_CREATE_ACCOUNT,
    applicationId : applicationId,
    accountId : accountId,
    plainPassword : plainPassword,
    message : json.message
  }
}

export const createAccount = (applicationId, accountId, plainPassword) => {
  return dispatch => {
    dispatch(requestCreateAccount(applicationId, accountId, plainPassword))
    return fetch(appConfig.url(`/password/account/create.json`), {
      queryParams : {
        applicationId : applicationId,
        accountId : accountId,
        plainPassword : plainPassword
      }
    })
      .then((response) => {
        if (response.status >= 400) {
          throw new Error("Bad response from server");
        }
        return response.json();
      })
      .then(json => dispatch(receiveCreateAccount(json, applicationId, accountId, plainPassword)))
  }
}


export const openAccountDialog = (accountId, accountName) => {
  return {
    type : Consts.PWD_OPEN_ACCOUNT_DIALOG,
    accountDialogOpen : true,
    selectedAccountName : accountName,
    selectedAccountId : accountId,
    plainPassword : null
  }
}

export const closeAccountDialog = () => {
  return {
    type : Consts.PWD_CLOSE_ACCOUNT_DIALOG,
    accountDialogOpen : false,
    selectedAccountName : null,
    selectedAccountId : null,
    plainPassword : null
  }
}
