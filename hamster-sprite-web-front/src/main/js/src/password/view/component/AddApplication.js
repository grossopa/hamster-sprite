import React, { Component } from 'react'
import AutoComplete from 'material-ui/AutoComplete'

class AddApplication extends Component {

  constructor(props) {
    super(props)
    this.state = {filteredApplicationList : []}
    this.handleAutoCompleteUpdateInput = this.handleAutoCompleteUpdateInput.bind(this)
  }

  componentDidMount() {
    this.props.onComponentDidMountHandler()
  }

  handleAutoCompleteUpdateInput(value) {
    const filteredApplicationList = this.props.applications.filter((application) => {
      return application.name.toLowerCase().indexOf(value.toLowerCase()) >= 0
    })
    console.log(this.props.applications)
    this.setState({filteredApplicationList : filteredApplicationList})
  }

  render() {
    return (<div>
        <AutoComplete
          hintText="Applications"
          dataSource={this.state.filteredApplicationList}
          dataSourceConfig={{text : 'name', value : 'id'}}
          onUpdateInput={this.handleAutoCompleteUpdateInput}
          floatingLabelText="Search or add new application"
          fullWidth={true}
         />
      </div>)
  }
}

export default AddApplication
