// libs
import React, { Component } from 'react'
import { Provider } from 'react-redux'
import { syncHistoryWithStore, routerReducer } from 'react-router-redux'
import { BrowserRouter, Route } from 'react-router-dom';
import injectTapEventPlugin from 'react-tap-event-plugin';

import configureStore from './config/configureStore.js'

// global configuration
import appConfig from './config/AppConfig.js';

// views
import Layout from './view/layout/Layout.js';
import Home from './view/Home.js';
import Password from './password/view/Password.js';

const store = configureStore();

injectTapEventPlugin();

// initialize the configuration from window.CONFIG (could be set from backend)
appConfig.initialize(window.CONFIG);

class App extends Component {
  render() {
    return (<Provider store={store}>
      <BrowserRouter>
      <Layout>
        <Route exact={true} path="/" component={Home} />
        <Route path="/password" component={Password} />
      </Layout>
    </BrowserRouter>
    </Provider>);
  }
}

/* main application entrance */
export default App;
