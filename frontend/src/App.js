import React, {Component} from 'react';
import './App.css';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import TextField from 'material-ui/TextField';
import RaisedButton from 'material-ui/RaisedButton';
import Paper from 'material-ui/Paper';
import Weather from "./components/Weather";

const style = {
    marginLeft: 12,
};

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            city: '',
            weather: undefined,
            backendDown: false
        };
    };

    getWeather() {
        try{
            fetch('http://localhost:8080/weather/'+this.textField.getValue(), {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                }
            })
            .then(response => response.json())
            .then(data => {
                this.setState({
                    city: data.cityName,
                    weather: data.temp
                });
            }).catch(error => {
                this.setState({
                    backendDown: true
                });
                console.log(error);
            });
        } catch(error) {
            console.log(error);
        }
    }

    onEnterPress = e => {
        if (e.key === 'Enter') {
            this.getWeather();
        }
    };

    render() {
        const WeatherComponent = this.state.weather !== undefined ?
            <Weather city={this.state.city} weather={this.state.weather}/> :
            this.state.backendDown ? <center><h3 style={{color:'red'}}>Backend server is down !!!!</h3></center> : null;

        return (
            <MuiThemeProvider>
                <div className="centerize">
                    <Paper zDepth={2} className="content">
                        <h1  style={{color:'grey'}}>Check you city's weather</h1>
                        <TextField ref={ref => this.textField = ref} onKeyUp={this.onEnterPress.bind(this)}
                                   hintText="Type a city name."/>
                        <RaisedButton  label="Search" style={style} onClick={this.getWeather.bind(this)}/>
                        {WeatherComponent}
                    </Paper>
                </div>
            </MuiThemeProvider>
        );
    }
}

export default App;