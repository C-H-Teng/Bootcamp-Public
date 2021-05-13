import React, {useState, useEffect} from 'react';
import obi_mind_trick from './images/obi_mind_trick.jpeg';
import axios from 'axios';

const People = props => {
    const {id} = props;
    const [person, setPerson] = useState({
        name: "",
        birth_year: "",
        eye_color: "",
        gender: "",
        height: "",
        homeworld: ""
    })
    const [homeworld, setHomeworld] = useState({
        name: ""
    })
    const [error, setError] = useState(false);

    useEffect(() => {
        axiosSWPerson();
    }, [])
    
    const axiosSWPerson = () => {
        axios.get(`https://swapi.dev/api/people/${id}`)
            .then(response => setPerson(response.data))
            // .then(response => console.log(response.data))
            .catch(err => {
                setError(true);
                console.log(err);
        });
    }

    const axiosHomeworld = () => {
        axios.get(person.homeworld)
            .then(response => setHomeworld(response.data))
            .catch(err => console.log(err));
        return homeworld.name
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
                <h2>{person.name}</h2>
                <p>Birth Year: {person.birth_year}</p>
                <p>Eye Color: {person.eye_color}</p>
                <p>Gender: {person.gender}</p>
                <p>Height: {person.height}</p>
                <p>Homeworld: {person.homeworld}{axiosHomeworld}</p>
            </div>
    )

    return (
        <>
            {content}
        </>
    )
}

export default People