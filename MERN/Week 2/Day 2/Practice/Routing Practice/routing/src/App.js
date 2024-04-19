import { BrowserRouter, Routes, Route} from 'react-router-dom';
import './App.css';
import Welcome from './components/Welcome';
import Number from './components/Number';
import Hello from './components/Hello';


function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <p>
      </p>
        <Routes> 
          <Route path='/home' element={<Welcome />} />
          <Route  path='/:string/:color1/:color2' element={<Hello />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;