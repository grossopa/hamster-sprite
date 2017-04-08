import React, { Component } from 'react';
import appConfig from '../config/AppConfig.js';

class LayoutHeader extends Component {
  render() {
    return (
    <header>
      <h1>{this.props.title}</h1>
      <h3>{appConfig.env}</h3>

      <div>
        <span></span>
        <span></span>
      </div>
    </header>);
  }
}

export default LayoutHeader;