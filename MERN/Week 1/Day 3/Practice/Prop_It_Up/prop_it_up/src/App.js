import logo from './logo.svg';
import './App.css';
import PersonCard from './components/PersonCard';
function App() {
  return (
    <div className="App">
    <PersonCard firstname={"Smith"} lastname={"Jane"} age={45} haircolor={"Black"} />
    <PersonCard firstname={"Smith"} lastname={"John"} age={88} haircolor={"Brown"} />
    <PersonCard firstname={"Fillmore"} lastname={"Millard"} age={50} haircolor={"Brown"} />
    <PersonCard firstname={"Smith"} lastname={"Maria"} age={62} haircolor={"Brown"} />

  </div>
  );
}

export default App;
