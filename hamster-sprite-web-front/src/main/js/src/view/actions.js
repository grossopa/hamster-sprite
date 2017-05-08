import * as Consts from './consts.js'

export const updateAppBar = (title, leftElements, rightElements) => {
  return {
    title : title,
    leftElements : leftElements,
    rightElements : rightElements
  }
}
