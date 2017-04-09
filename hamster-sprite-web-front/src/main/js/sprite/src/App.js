import React, { Component } from 'react';
import lightBaseTheme from 'material-ui/styles/baseThemes/lightBaseTheme';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import getMuiTheme from 'material-ui/styles/getMuiTheme';
import injectTapEventPlugin from 'react-tap-event-plugin';
import './App.css';
import appConfig from './config/AppConfig.js';
import LayoutHeader from './layout/LayoutHeader.js';
import LayoutHome from './layout/LayoutHome.js';
import { BrowserRouter, Route, Link } from 'react-router-dom';
import Home from './view/Home.js';
import Password from './view/Password.js';

class App extends Component {
  constructor(props) {
    super(props);

    // Needed for onTouchTap
    // http://stackoverflow.com/a/34015469/988941
    injectTapEventPlugin();

    // initialize the configuration from window.CONFIG (could be set from backend)
    appConfig.initialize(window.CONFIG);

  }
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

class MainRouter extends Component {
  render() {
    return (<BrowserRouter>
      <App>
        <Route path="/" component={Home} />
        <Route path="password" component={Password} />
      </App>
    </BrowserRouter>);
  }
}


export default MainRouter;