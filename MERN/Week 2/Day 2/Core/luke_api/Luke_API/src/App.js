import './App.css';
import Home from './components/Home';
import People from './components/People';
import Planet from './components/Planet';
import { Route, Routes } from 'react-router-dom';


function App() {
  return (
    <div className="App">
      <Home />
      <Routes>
        <Route path="/people/:id" element={<People />} />
        <Route path="/planets/:id" element={<Planet />} />
      </Routes>
    </div>
  );
}

export default App;
