import { createStore, applyMiddleware, combineReducers } from 'redux'
import { routerMiddleware, routerReducer } from 'react-router-redux'
import thunkMiddleware from 'redux-thunk'
import { createLogger } from 'redux-logger'
import * as passwordReducers from '../password/reducers.js'
import * as appReducers from '../app/reducers.js'

export default function configureStore(preloadedState, history) {
  const loggerMiddleware = createLogger()

  const routerMiddleware1 = routerMiddleware(history)

  var reducers = Object.assign({routing: routerReducer}, passwordReducers)
  Object.assign(reducers, appReducers)

  var rootReducer = combineReducers(reducers)

  return createStore(
    rootReducer,
    preloadedState,
    applyMiddleware(
      thunkMiddleware,
      routerMiddleware1,
      loggerMiddleware
    )
  )
}
