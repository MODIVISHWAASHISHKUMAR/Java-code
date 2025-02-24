//import React from 'react';
// function Counter() {
//  const [count, setCount] = useState(0);
//  const increment = () => setCount(count + 1);
//  const decrement = () => setCount(count - 1);
// return (
//     <div>
//       <h1>Simple Counter</h1>
//       <p>Current Count: {count}</p>
//       <button onClick={increment}>Increment</button>
//       <button onClick={decrement}>Decrement</button>
//     </div>
//   );
// }
// class Counter extends React.Component{
//   constructor(props){
//   super(props);
//   this.state={counter:0};
// }
// render(){
//   return(
//     <>
//     <h1>{this.state.counter}</h1>
//     <input type='button' value="+" onClick={()=>this.setState({counter:this.state.counter+1})}/>
//     <input type='button' value="-" onClick={()=>this.setState({counter:this.state.counter-1})}/>
//     <input type='button' value="X" onClick={()=>this.setState({counter:0})}/>
//     </>

//   )
// }}
// export default Counter;


import React from 'react';
class Counter extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0, 
    };
  }
  increment = () => {
    this.setState((prevState) => ({
      count: prevState.count + 1,
    }));
  };
  decrement = () => {
    this.setState((prevState) => ({
      count: prevState.count - 1,
    }));
  };
  render() {
    const { count } = this.state;
    return (
      <div>
        <h1>Counter</h1>
        <p>Count: {count}</p>
        {count < 5 && (
          <button onClick={this.increment}>
            Increment
          </button>
        )}
        {count > 0 && (
          <button onClick={this.decrement}>
            Decrement
          </button>
        )}
      </div>
    );
  }
}
export default Counter;

