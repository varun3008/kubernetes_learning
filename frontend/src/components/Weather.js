import React, {Component} from 'react';
import PropTypes from 'prop-types';

class Weather extends Component {

    propTypes = {
        city: PropTypes.string.isRequired,
        weather: PropTypes.number.isRequired
    };

    render() {

        const textColor = {
            color: isNaN(this.props.weather) ? 'red' : this.props.weather > 20 ? 'Orange': 'Blue',
            padding: '15px'
        };

        return  this.props.weather && this.props.weather !== 'null' ?
        <h3 style={textColor}>Weather of "{this.props.city}" is : {this.props.weather}</h3>
        :
        <h3 style={textColor}>Please check the city name.</h3>;
    }
}

export default Weather;