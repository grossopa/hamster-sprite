import * as Consts from './consts.js'

const defaultIconElementLeft = <IconButton><NavigationMenu /></IconButton>
const defaultIconElementRight= null

export const app = (state = {
  title : 'Home',
  iconElementLeft  : defaultIconElementLeft,
  iconElementRight : defaultIconElementRight
}, action) => {
  if (action.type === Consts.UPDATE_APP_BAR) {
    return Object.assign({}, state, {
      title : action.title,
      iconElementLeft : iconElementLeft,
      iconElementRight : iconElementRight
    })
  }

  return state
}
