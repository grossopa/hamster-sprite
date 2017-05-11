import React, { Component } from 'react';
import AppBar from 'material-ui/AppBar';

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
      iconElementLeft={this.props.iconElementLeft}
      iconElementRight={this.props.iconElementRight}
    />);
  }
}

export default LayoutHeader;
