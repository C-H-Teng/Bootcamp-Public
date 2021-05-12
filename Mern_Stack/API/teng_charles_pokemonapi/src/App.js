import { useState, useEffect } from 'react';
import './App.css';
import axios from 'axios';

function App() {
  const [pokemon, setPokemon] = useState([]);

  // with fetch
  const getPokemon = () => {
    fetch("https://pokeapi.co/api/v2/pokemon?limit=807")
      .then(response => response.json())
      .then(jsonResponse => setPokemon(jsonResponse.results))
      .catch(err => console.log(err));
  }
  
  // with axios
  const axiosPokemon = () => {
    axios.get("https://pokeapi.co/api/v2/pokemon?limit=807")
      .then(response => setPokemon(response.data.results))
      .catch(err => console.log(err));
  }

    // without button
    // useEffect(() => {
    //   fecthPokemon();
    // }, [])

  return (
    <div className="App">
      {/* <button onClick={getPokemon}>Get Pokemon</button> */}
      <button onClick={axiosPokemon}>Get Pokemon</button>

      <ul>
        {
          pokemon.map((pokemon, idx) => {
            return <li key={idx}>{pokemon.name}</li>
          })
        }
      </ul>
      {/* {content} */}
    </div>
  );
}

export default App;
