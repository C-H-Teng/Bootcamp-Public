import React, { useState } from 'react';
import './App.css';
import Tabs from "./components/Tabs"

function App() {
  const [tabArr, setTabArr] = useState([
    "Tab 1 data",
    "Tab 2 stuff",
    "Tab 3 things"
  ]);

  return (
    <div className="App">
      <Tabs
        tabArr={tabArr}
        setTabArr={setTabArr}
      />
    </div>
  );
}

export default App;
