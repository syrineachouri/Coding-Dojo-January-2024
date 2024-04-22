import React from 'react'
import { useState } from 'react'
import { useNavigate } from 'react-router-dom'



const Home = () => {
    const [select, setSelect] = useState('people');
    const [selectId, setSelectId] = useState();
    const nav = useNavigate()

    const handleSubmit = (e) => {
        e.preventDefault()
        console.log(select);
        nav(`/${select}/${selectId}`)
    }
    return (
        <div>
            <form onSubmit={handleSubmit}>
                <label>Search for: </label>
                <select onChange={(e) => setSelect(e.target.value)}>
                    <option >people</option>
                    <option >planets</option>
                </select>
                <label>ID: </label>
                <input type='number' onChange={(e) => setSelectId(e.target.value)} />
                <button> Search </button>
            </form>
        </div>
    )
}

export default Home