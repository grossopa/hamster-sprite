import * as Consts from './consts.js'

const LOCATION_CHANGE = '@@router/LOCATION_CHANGE'

const applicationsRouterHandler = (state, pathname) => {
  console.log(state);
  console.log(pathname);
  return state;
}

const applicationRouterHandler = (state, pathname, applicationId) => {
  return Object.assign(state, {
    applicationId : applicationId
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
    default:
      return state
  }
}
