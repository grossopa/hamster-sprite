// libs
import React, { Component } from 'react'
import { Provider } from 'react-redux'
import createHistory from 'history/createBrowserHistory'
import { Route } from 'react-router-dom';
import { ConnectedRouter } from 'react-router-redux'
import injectTapEventPlugin from 'react-tap-event-plugin';

import configureStore from './config/configureStore.js'

// global configuration
import appConfig from './config/AppConfig.js';

// views
import Layout from './view/layout/Layout.js';
import Home from './view/Home.js';
import Password from './password/view/Password.js';

const history = createHistory();
const store = configureStore({}, history);

import * as Util from './util'

injectTapEventPlugin();

// initialize the configuration from window.CONFIG (could be set from backend)
appConfig.initialize(window.CONFIG);

class App extends Component {

  render() {
    return (<Provider store={store}>
      <ConnectedRouter history={history}>
      <Layout>
        <Route exact={true} path="/" component={Home} />
        <Route path="/password" component={Password} />
      </Layout>
    </ConnectedRouter>
    </Provider>);
  }
}

/* main application entrance */
export default App;
