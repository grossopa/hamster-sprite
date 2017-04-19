import * as Consts from './consts.js'

const LOCATION_CHANGE = '@@router/LOCATION_CHANGE'

const initialState = {
  locationBeforeTransitions: null,
}

const applicationsRouterHandler = (state, pathname) => {
  console.log(state);
  console.log(pathname);
  return state;
}

const routerHandlers = [
  { pattern : /\/password$/, callback : applicationsRouterHandler }
]

export function routerReducer(state = initialState, { type, payload } = {}) {
  var resultState = state
  if (type === LOCATION_CHANGE) {
    routerHandlers.forEach((handler, index) => {
      const pathname = payload.pathname;
      const matches = handler.pattern.exec(pathname);
      if (matches && matches.length > 0) {
        resultState = handler.callback.apply(this, [state].concat(matches));
        return false;
      }
    })
  }

  return resultState;
}



export function applications(state = {
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
}
