import React from 'react';
class CountdownTimer extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      time: 60, 
      isRunning: false,
      intervalId: null,
    };
  }
  startTimer = () => {
    if (!this.state.isRunning) {
      this.setState({ isRunning: true });
      const intervalId = setInterval(() => {
        this.setState((prevState) => {
          if (prevState.time <= 0) {
            clearInterval(intervalId);
            return { time: 0, isRunning: false };
          }
          return { time: prevState.time -1 }; 
        });
      }, 1000);
      this.setState({ intervalId });
    }
  };
  pauseTimer = () => {
    if (this.state.isRunning) {
      clearInterval(this.state.intervalId);
      this.setState({ isRunning: false });
    }
  };
  stopTimer = () => {
    clearInterval(this.state.intervalId);
    this.setState({ isRunning: false, time: 60 });
  };
  componentWillUnmount() {
    if (this.state.intervalId) {
      clearInterval(this.state.intervalId);
    }
  }
  render( ) {
    const { time, isRunning } = this.state;
    return (
      <div>
        <h1>Countdown Timer</h1>
        <div>
          <p>Time: {time} seconds</p>
          <button onClick={this.startTimer} disabled={isRunning}>
            Start
          </button>
          <button onClick={this.pauseTimer} disabled={!isRunning}>
            Pause
          </button>
          <button onClick={this.stopTimer}>
            Stop
          </button>
        </div>
      </div>
    );
  }
}
export default CountdownTimer;
