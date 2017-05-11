import * as Consts from './consts.js'

export const updateAppBar = (title, iconElementLeft, iconElementRight) => {
  return {
    type : Consts.UPDATE_APP_BAR,
    title : title,
    iconElementLeft : iconElementLeft,
    iconElementRight : iconElementRight
  }
}
