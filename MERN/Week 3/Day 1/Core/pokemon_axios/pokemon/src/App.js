import './App.css';
import React, { useState } from 'react';
import axios from 'axios';

function App() {
  const [pokemonNames, setPokemonNames] = useState([]);

  const AxiosPok = () => {
    axios.get("https://pokeapi.co/api/v2/pokemon")
      .then((res) => {
        //! -- axios wraps the res in it's own .data key
        console.log(res.data)
        setPokemonNames(res.data.results) // we know from the prev console log that this IS an Array of Data
      }).catch((err) => {
        console.log("❌❌❌❌❌❌", err)
      })
  }

  return (
    <div className="App">
      <h1>Pokemon</h1>
      {/* {JSON.stringify(Heroes)} */}
      <button onClick={AxiosPok}>Fetch pokemon</button>
      {
        pokemonNames.map((p) => {
          return (
            <ul>
              <il>{p.name}</il>
            </ul>
          )
        })
      }
    </div>
  );
}

export default App;