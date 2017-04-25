import React, { Component } from 'react'
import {List, ListItem } from 'material-ui/List'
import Subheader from 'material-ui/Subheader'

import './ApplicationDetails.css'

class ApplicationDetails extends Component {
  constructor(props) {
    props = props || {}
    super(props)
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.applicationId !== this.props.applicationId) {
      this.props.onReloadHandler(nextProps.applicationId)
    }
  }

  render() {
    return (<section>{
      this.props.applicationId && this.props.application &&
          <List>
            <ListItem><Subheader>{this.props.application.name}</Subheader></ListItem>
          </List>}
    </section>)
  }
}

export default ApplicationDetails
