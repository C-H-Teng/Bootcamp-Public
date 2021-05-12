import './App.css';
import React from 'react';
import {Router} from '@reach/router';
import Home from './components/Home';
import Parameter from './components/Parameter';
import ParamColor from './components/ParamColor';

function App() {
  return (
    <div className="App">
      <Router>
        <Home path="/home" />
        <Parameter path="/:id" />
        <ParamColor path="/:id/:txtClr/:bgClr" />
      </Router>
    </div>
  );
}

export default App;
