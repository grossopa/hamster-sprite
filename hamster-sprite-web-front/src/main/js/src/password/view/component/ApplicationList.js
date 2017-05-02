import React, { Component } from 'react'
import {List, ListItem } from 'material-ui/List'
import Subheader from 'material-ui/Subheader'
import Avatar from 'material-ui/Avatar'
import ActionInfo from 'material-ui/svg-icons/action/info'
import FileFolder from 'material-ui/svg-icons/file/folder'

class ApplicationList extends Component {

  componentDidMount() {
    this.props.onComponentDidMountHandler();
  }

  render() {
    var _this = this;
    const applications = this.props.applications ? this.props.applications : [];
    return (<List>
      <Subheader inset={true}>Applications</Subheader>
      {applications.map((item) => {
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
