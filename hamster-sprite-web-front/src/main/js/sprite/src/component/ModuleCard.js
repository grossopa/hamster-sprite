import React, { Component } from 'react';
import {Card, CardText} from 'material-ui/Card';/*CardActions, CardHeader, CardMedia, CardTitle, */
import { Link } from 'react-router-dom';

class ModuleCard extends Component {
  iconClass : null;
  title : null;
  link : null;

  constructor(iconClass, title, link) {
    super();
    this.iconClass = iconClass;
    this.title = title;
    this.link = link;
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
      <Link to={this.link}>
        <IconClass style={iconClassStyle} />
      </Link>
      <CardText expandable={false}>
        {this.title}
      </CardText>
    </Card>);
  }
}

export default ModuleCard;
