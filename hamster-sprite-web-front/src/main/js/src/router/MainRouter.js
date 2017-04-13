import React, { Component } from 'react';
import { Router, Route, Link } from 'react-router';

import Home from '../view/Home.js';
import Password from '../view/Password.js';

class MajorRouter extends Component {
  render() {
    return (<Router>
      <Route path="/" component={App}>
        <IndexRoute component={Home} />
        <Route path="password" component={Password} />
      </Route>
    </Router>);
  }
}