import React, {Component} from 'react';

import {GridList/*, GridTile*/} from 'material-ui/GridList';
import ModuleCardAccount from './component/ModuleCardAccount.js';
import ModuleCardPassword from './component/ModuleCardPassword.js';

class Home extends Component {

  render() {
    const styles = {
      gridList: {
        width: '90%',
        height: '100%',
        overflowY: 'auto',
        marginLeft : '5%'
      }
    };

    return (<GridList
      cellHeight="auto"
      style={styles.gridList}>
      <ModuleCardPassword />
      <ModuleCardAccount />
    </GridList>);
  }
}

export default Home;
