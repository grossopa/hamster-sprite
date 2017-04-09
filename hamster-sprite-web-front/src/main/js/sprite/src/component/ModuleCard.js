import React, { Component } from 'react';
import {Card, CardText} from 'material-ui/Card';/*CardActions, CardHeader, CardMedia, CardTitle, */

class ModuleCard extends Component {
  iconClass : null;
  title : null;

  constructor(iconClass, title) {
    super();
    this.iconClass = iconClass;
    this.title = title;
  }

  render() {
    const IconClass = this.iconClass;
    const iconClassStyle = {
      width : '90%',
      marginLeft : '5%',
      height : 200,
      cursor : 'pointer'
    };

    return (<Card>
      <IconClass style={iconClassStyle} />
      <CardText expandable={false}>
        {this.title}
      </CardText>
    </Card>);
  }
}

export default ModuleCard;