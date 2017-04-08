import React, { Component } from 'react';
import AppBar from 'material-ui/AppBar';
import IconButton from 'material-ui/IconButton';
import NavigationMenu from 'material-ui/svg-icons/navigation/menu';
import FlatButton from 'material-ui/FlatButton';

/**
 * This example uses an [IconButton](/#/components/icon-button) on the left, has a clickable `title`
 * through the `onTouchTap` property, and a [FlatButton](/#/components/flat-button) on the right.
 */
class LayoutHeader extends Component {

  handleTouchTap() {
    alert('onTouchTap triggered on the title component');
  }
 
  render() {
    return (<AppBar
      title={<span>{this.props.title}</span>}
      onTitleTouchTap={(this.handleTouchTap)}
      iconElementLeft={<IconButton><NavigationMenu /></IconButton>}
      iconElementRight={<FlatButton label="Save" />}
      />);
  }
}

export default LayoutHeader;