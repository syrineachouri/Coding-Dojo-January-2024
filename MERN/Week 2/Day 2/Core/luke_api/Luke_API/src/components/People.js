import React from 'react'
import { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom'



const People = () => {
    const [people, setPeople] = useState('');
    const { id } = useParams()
    console.log(id)


    useEffect(() => {
        axios.get(`https://swapi.dev/api/people/${id}`)
            .then((res) => {
                console.log(res.data)
                setPeople(res.data)
            }).catch((err) => {
                console.log(err)
            })
    }, [id])
    return (
        <div>
            <h2>Name: {people.name}</h2>
            <p>Height: {people.height}</p>
            <p>Mass: {people.mass}</p>
            <p>Hair Color: {people.hair_color}</p>
            <p>Skin Color: {people.skin_color}</p>
        </div>
    )
}

export default People