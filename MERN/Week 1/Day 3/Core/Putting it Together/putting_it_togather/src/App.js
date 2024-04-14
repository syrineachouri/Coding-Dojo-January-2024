import logo from './logo.svg';
import './App.css';
import putting from './components/putting';
function App() {
  return (
    <div className="App">
      <putting firstname={"Smith"} lastname={"Jane"} age={45} haircolor={"Black"} />
      <putting firstname={"Smith"} lastname={"John"} age={88} haircolor={"Brown"} />
      <putting firstname={"Fillmore"} lastname={"Millard"} age={50} haircolor={"Brown"} />
      <putting firstname={"Smith"} lastname={"Maria"} age={62} haircolor={"Brown"} />
    </div>
    );
}

export default App;
