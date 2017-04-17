import React, {Component} from 'react';

class LayoutHome extends Component {

  // available modules
  modules : [];

  constructor(props) {
    super(props);
    
    this.modules = props.modules;
  }

  render() {

    return (<section className="main-content">
      {this.props.children}
    </section>);
  }
}

export default LayoutHome;