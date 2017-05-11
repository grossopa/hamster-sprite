import React, {Component} from 'react';
import lightBaseTheme from 'material-ui/styles/baseThemes/lightBaseTheme';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import getMuiTheme from 'material-ui/styles/getMuiTheme';

// layouts
import LayoutHeader from './LayoutHeaderRedux.js';
import LayoutHome from './LayoutHome.js';

class Layout extends Component {
  render() {
    return (<MuiThemeProvider muiTheme={getMuiTheme(lightBaseTheme)}>
      <div>
        <LayoutHeader title="Hamster Sprite"/>
        <LayoutHome>
          {this.props.children}
        </LayoutHome>
      </div>
      </MuiThemeProvider>);
  }
}

export default Layout;
