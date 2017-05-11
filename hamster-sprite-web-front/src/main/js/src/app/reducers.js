import React, {Component} from 'react'
import IconButton from 'material-ui/IconButton'
import NavigationMenu from 'material-ui/svg-icons/navigation/menu'

import * as Consts from './consts.js'

const defaultIconElementLeft = <IconButton><NavigationMenu /></IconButton>
const defaultIconElementRight = null

export const apps = (state = {
  title : 'Home',
  iconElementLeft  : defaultIconElementLeft,
  iconElementRight : defaultIconElementRight
}, action) => {
  console.log(action)
  if (action.type === Consts.UPDATE_APP_BAR) {
    return Object.assign({}, state, {
      title : action.title,
      iconElementLeft : action.iconElementLeft,
      iconElementRight : action.iconElementRight
    })
  }

  return state
}
