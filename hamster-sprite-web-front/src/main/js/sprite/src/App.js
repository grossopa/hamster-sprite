import React, { Component } from 'react';
import lightBaseTheme from 'material-ui/styles/baseThemes/lightBaseTheme';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import getMuiTheme from 'material-ui/styles/getMuiTheme';
import injectTapEventPlugin from 'react-tap-event-plugin';
import './App.css';
import appConfig from './config/AppConfig.js';
import LayoutHeader from './layout/LayoutHeader.js';

class App extends Component {
  constructor(props) {
    super(props);
    // Needed for onTouchTap
    // http://stackoverflow.com/a/34015469/988941
    injectTapEventPlugin();
    appConfig.initialize(window.CONFIG);

  }
  render() {
    return (
      <MuiThemeProvider muiTheme={getMuiTheme(lightBaseTheme)}>
      <div>
        <LayoutHeader title="Hamster Sprite"/>
      </div>
      </MuiThemeProvider>
      );
  }
}

export default App;