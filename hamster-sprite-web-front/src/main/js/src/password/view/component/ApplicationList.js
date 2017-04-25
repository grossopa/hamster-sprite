import React, { Component } from 'react'
import {List, ListItem } from 'material-ui/List'
import Subheader from 'material-ui/Subheader'
import Avatar from 'material-ui/Avatar'
import ActionInfo from 'material-ui/svg-icons/action/info'
import FileFolder from 'material-ui/svg-icons/file/folder'
import Moment from 'react-moment'

import appConfig from '../../../config/AppConfig.js'

class ApplicationList extends Component {

  componentDidMount() {
    this.props.onComponentDidMountHandler();
  }

  render() {
    var _this = this;
    return (<List>
      <Subheader inset={true}>Applications</Subheader>
      {this.props.applications && this.props.applications.map(function(item) {
          return (<ListItem key={item.id} style={{cursor : 'pointer'}}
            leftAvatar={<Avatar icon={<FileFolder />} />}
            rightIcon={<ActionInfo />}
            primaryText={item.name}
            secondaryText={item.url}
            onTouchTap={() => _this.props.onRowClickHandler(item.id)} />)
        })
      }
    </List>)
  }
}

export default ApplicationList
