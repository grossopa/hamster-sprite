import * as Consts from './consts.js'

const LOCATION_CHANGE = '@@router/LOCATION_CHANGE'

const applicationsRouterHandler = (state, pathname) => {
  console.log(state);
  console.log(pathname);
  return state;
}

const applicationRouterHandler = (state, pathname, applicationId) => {
  return Object.assign(state, {
    applicationId : applicationId,
    selectedAccountId : null,
    selectedAccountName : null,
    plainPassword : null
  })
}

const routerHandlers = [
  { pattern : /\/password\/?$/, callback : applicationsRouterHandler },
  { pattern : /\/password\/application\/([0-9]+)/, callback : applicationRouterHandler }
]

export function routerReducer(state = {}, { type, payload } = {}) {
  var resultState = state
  if (type === LOCATION_CHANGE) {
    routerHandlers.forEach((handler, index) => {
      const pathname = payload.pathname
      const matches = handler.pattern.exec(pathname)
      if (matches && matches.length > 0) {
        resultState = handler.callback.apply(this, [state].concat(matches))
        return false
      }
    })
  }
  return resultState
}

export function applications(state = {isFetching : false}, action) {
  switch (action.type) {
    case Consts.PWD_REQUEST_APPLICATIONS:
    case Consts.PWD_REQUEST_APPLICATION:
    case Consts.PWD_REQUEST_ACCOUNTS:
    case Consts.PWD_REQUEST_PASSWORD_REVEAL:
      return Object.assign({}, state, {
        isFetching: true
      })
    case Consts.PWD_RECEIVE_APPLICATIONS:
      return Object.assign({}, state, {
        isFetching: false,
        applications: action.applications
      })
    case Consts.PWD_RECEIVE_APPLICATION:
      return Object.assign({}, state, {
        isFetching : false,
        applicationId : action.applicationId,
        application : action.application
      })
    case Consts.PWD_RECEIVE_ACCOUNTS:
      return Object.assign({}, state, {
        isFetching : false,
        applicationId : action.applicationId,
        accounts : action.accounts
      })
    case Consts.PWD_RECEIVE_PASSWORD_REVEAL:
      return Object.assign({}, state, {
        isFetching : false,
        accountId : action.accountId,
        plainPassword : action.plainPassword
      })
    case Consts.PWD_OPEN_ACCOUNT_DIALOG:
    case Consts.PWD_CLOSE_ACCOUNT_DIALOG:
      return Object.assign({}, state, {
        accountDialogOpen : action.accountDialogOpen,
        selectedAccountName : action.selectedAccountName,
        selectedAccountId : action.selectedAccountId,
        plainPassword : action.plainPassword
      })
    default:
      return state
  }
}
