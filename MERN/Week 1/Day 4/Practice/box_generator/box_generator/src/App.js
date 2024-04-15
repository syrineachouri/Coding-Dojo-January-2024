import React, {useState} from 'react';
import ColorForm from './components/form';
import DisplayBox from './components/box';
import './App.css';

function App() {
  const [boxcolorArray, setBoxcolorArray] = useState([]);
  return (
    <div className="App">
      <ColorForm boxcolorArray={boxcolorArray} setBoxcolorArray={setBoxcolorArray} />
      <DisplayBox boxcolorArray={boxcolorArray}/>
    </div>
  );
}

export default App;
