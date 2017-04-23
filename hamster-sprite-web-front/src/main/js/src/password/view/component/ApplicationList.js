import React, { Component } from 'react'
import {Table, TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn} from 'material-ui/Table';
import Moment from 'react-moment'

import appConfig from '../../../config/AppConfig.js'

class ApplicationList extends Component {

  componentDidMount() {
    this.props.onComponentDidMountHandler();
  }

  render() { return (<Table selectable={false}
    onCellClick={(rowNumber, columnId) => this.props.onRowClickHandler(this.props.applications[rowNumber], rowNumber)}>
    <TableHeader
      displaySelectAll={false}
      adjustForCheckbox={false}>
      <TableRow>
        <TableHeaderColumn>Application</TableHeaderColumn>
        <TableHeaderColumn>URL</TableHeaderColumn>
        <TableHeaderColumn>Audit</TableHeaderColumn>
      </TableRow>
    </TableHeader>
    <TableBody
      displayRowCheckbox={false}>
      {this.props.applications && this.props.applications.map(function(item) {
          return (<TableRow key={item.id} selected={item.selected} style={{cursor : 'pointer'}}>
             <TableRowColumn>{item.name}</TableRowColumn>
             <TableRowColumn>{item.url}</TableRowColumn>
             <TableRowColumn>
                <span>Last Updated by {item.updatedBy} on&nbsp;
                  <Moment format={appConfig.dateTimeFormat}>{item.updatedOn}</Moment>
                </span>
             </TableRowColumn>
           </TableRow>)
        })
      }
    </TableBody>
  </Table>)}
}

export default ApplicationList
