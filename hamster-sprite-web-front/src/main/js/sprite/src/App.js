import React, { Component } from 'react';
import './App.css';
import appConfig from './config/AppConfig.js';
import LayoutHeader from './layout/LayoutHeader.js';



class App extends Component {
  constructor(props) {
    super(props);

    appConfig.initialize(window.CONFIG);
    
  }
  render() {
    return (
      <LayoutHeader title="Hamster Sprite" />
    );
  }
}

export default App;
