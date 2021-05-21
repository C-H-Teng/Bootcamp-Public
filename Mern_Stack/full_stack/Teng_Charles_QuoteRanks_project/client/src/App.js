import './App.css';
import React from 'react';
import {Router} from '@reach/router';
import Main from './views/Main';
import AddAuthor from './views/AddAuthor';
import UpdateAuthor from './views/UpdateAuthor';
import QuotesList from './views/QuotesList';
import AddQuote from './views/AddQuote';

function App() {


  return (
    <div>
      <Router>
        <Main path="/" />
        <AddAuthor path="/new" />
        <UpdateAuthor path="/authors/:id/edit" />
        <QuotesList path="/quotes/:id" />
        <AddQuote path="/quotes/:id/new" />
      </Router>
    </div>
  );
}

export default App;
