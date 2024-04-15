import { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import TabContent from './components/TabContent';

import './App.css';

function App() {
  const [tab, setTab] = useState({
    content: ["I'm one TAB ", "I'm two TABS", "I'm three TABS"],
    selectedTab: 0,
  })
  
  
  return (
    <div className= "container mt-5">
      <h1>TABS</h1>
      <TabContent tab={tab} setTab={setTab}/>
    </div>
  );
}

export default App;