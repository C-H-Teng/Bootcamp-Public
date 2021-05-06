import React from 'react';
import './App.css';
import Person from './components/PersonCard';

function App() {
  return (
    <div className="App">
      <Person lastName={"Doe"} firstName={"Jane"} age={45} hairColor={"Black"}>

      </Person>


      <Person lastName={"Smith"} firstName={"John"} age={88} hairColor={"Brown"}>

      </Person>


      <Person lastName={"Fillmore"} firstName={"Millard"} age={50} hairColor={"Brown"}>

      </Person>


      <Person lastName={"Smith"} firstName={"Maria"} age={62} hairColor={"Brown"}>

      </Person>
    </div> // return div end
  );
}

export default App;
