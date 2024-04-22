import React from 'react'
import { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom'



const Planet = () => {
    const [planet, setPlanet] = useState('');
    const { id } = useParams()
    console.log(id)


    useEffect(() => {
        axios.get(`https://swapi.dev/api/planets/${id}`)
            .then((res) => {
                console.log(res.data)
                setPlanet(res.data)
            }).catch((err) => {
                console.log(err)
            })
    }, [id])
    return (
        <div>
            <h2>Name: {planet.name}</h2>
            <p>Climate: {planet.climate}</p>
            <p>Terrain: {planet.terrain}</p>
            <p>Surface_water: {planet.surface_water}</p>
            <p>Population: {planet.population}</p>
        </div>
    )
}

export default Planet