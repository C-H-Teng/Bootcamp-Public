import React, {useState, useEffect} from 'react';
import obi_mind_trick from './images/obi_mind_trick.jpeg';
import axios from 'axios';

const Planets = props => {
    const {id} = props;
    const [planet, setPlanet] = useState({
        name: "",
        diameter: "",
        gravity: "",
        population: "",
        climate: "",
        terrain: ""
    })
    const [error, setError] = useState(false);

    useEffect(() => {
        axiosSWPlanet();
    }, [])
    
    const axiosSWPlanet = () => {
        axios.get(`https://swapi.dev/api/planets/${id}`)
        .then(response => setPlanet(response.data))
        // .then(response => console.log(response.data))
        .catch(err => {
            setError(true);
            console.log(err);
        });
    }

    let content = (
        error ?
            <div>
                <img src={obi_mind_trick} alt="Obi-Wan Kenobi mind trick" width="400"></img>
                <p>These aren't the droids you're looking for.</p>
            </div>
        :
            <div>
                {/* <button onClick={axiosSWPerson}>Get info</button> */}
                <h2>{planet.name}</h2>
                <p>Diameter: {planet.diameter}</p>
                <p>Gravity: {planet.gravity}</p>
                <p>Population: {planet.population}</p>
                <p>Climate: {planet.climate}</p>
                <p>Terrain: {planet.terrain}</p>
            </div>
    )

    return (
        <>
            {content}
        </>
    )
}

export default Planets