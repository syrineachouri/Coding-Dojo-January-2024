import logo from './logo.svg';
import './App.css';
import { Route, Routes } from 'react-router-dom';
import Create from './components/Create';
import List from './components/List';
import Show from './components/Show';
import Edit from './components/Edit';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path='/create' element={<Create />}/>
        <Route path='/' element={<List />}/>
        <Route path='/product/:id' element={<Show />}/>
        <Route path="/product/edit/:id" element={<Edit/>}/>
      </Routes>
    </div>
  );
}

export default App;
