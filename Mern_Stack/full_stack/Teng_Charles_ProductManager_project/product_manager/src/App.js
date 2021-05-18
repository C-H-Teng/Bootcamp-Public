import './App.css';
import React from 'react';
import {Router} from '@reach/router';
import Main from './views/Main';
import ViewSingle from './views/ViewSingle';
import Update from './views/Update';

function App() {
  console.log("app test");

  return (
    <div className="App">
      <Router>
        <Main path="/" />
        <ViewSingle path="/:id" />
        <Update path="/:id/edit" />
      </Router>
    </div>
  );
}

export default App;
