import React, {useState, useEffect} from 'react';
import {Router} from '@reach/router';
import './App.css';
import Header from './components/Header';
import People from './components/People';
import Planets from './components/Planets';


function App() {
  

  return (
    <div className="App">
      <Header />
      <Router>
        <People path="/people/:id" />
        <Planets path="/planets/:id" />
      </Router>
    </div>
  );
}

export default App;
