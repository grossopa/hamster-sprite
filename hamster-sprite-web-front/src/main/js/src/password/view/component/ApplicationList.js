import React, { Component } from 'react'
import {Table, TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn} from 'material-ui/Table';

class ApplicationList extends Component {

  componentDidMount() {
    this.props.onComponentDidMountHandler();
  }

  render() {return (<Table>
    <TableHeader>
      <TableRow>
        <TableHeaderColumn>Application</TableHeaderColumn>
        <TableHeaderColumn>URL</TableHeaderColumn>
        <TableHeaderColumn>Audit</TableHeaderColumn>
      </TableRow>
    </TableHeader>
    <TableBody>
      {this.props.applications && this.props.applications.map(function(item) {
          return (<TableRow key={item.id} selected={item.selected}>
             <TableRowColumn>{item.name}</TableRowColumn>
             <TableRowColumn>{item.url}</TableRowColumn>
             <TableRowColumn>
                <span>{item.updatedBy} on {item.updatedOn}</span>
             </TableRowColumn>
           </TableRow>)
        })
      }
    </TableBody>
  </Table>)}
}

export default ApplicationList
