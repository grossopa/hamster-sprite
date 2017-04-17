import { createStore, applyMiddleware, combineReducers } from 'redux'
import { routerMiddleware, push } from 'react-router-redux'
import thunkMiddleware from 'redux-thunk'
import { createLogger } from 'redux-logger'
import passwordReducers from '../password/reducers.js'

export default function configureStore(preloadedState) {
  const loggerMiddleware = createLogger();

  const rootReducer = combineReducers(
    passwordReducers);

  return createStore(
    rootReducer,
    preloadedState,
    applyMiddleware(
      thunkMiddleware,
      routerMiddleware,
      loggerMiddleware
    )
  )
}
