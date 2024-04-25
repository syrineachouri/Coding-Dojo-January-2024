import axios from 'axios'
import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'

const Create = () => {
    const [name, setName] = useState("")
    const [errors, setErrors] = useState([])
    const nav = useNavigate()

    const SubmitHandler = (e) => {
        e.preventDefault()
        axios.post(`http://localhost:8000/api/author/new`, { name })
            .then((res) => {
                console.log("✅✅")
                nav("/")
            })
            .catch((err) => {
                const errorRes = err.response.data.errors;
                const errArray = []
                for (const key of Object.keys(errorRes)) {
                    errArray.push(errorRes[key].message)
                }
                setErrors(errArray)
                console.log(err)
            })
    }

    return (
        <div className='container'>
            <h3> Favorite authors</h3>
            <Link to={`/`}>Home</Link>
            <p>Add a new author:</p>
            <div>
                <form onSubmit={SubmitHandler}>
                    {errors.map((err, i) => (
                        <p key={i} className='text-danger'>{err}</p>
                    ))}
                    <label className='label-control'>Name</label><br />
                    <input className='label-control' value={name} type="text" onChange={(e) => { setName(e.target.value) }} />
                    <br />
                    <button className='btn btn-success'>Submit</button>
                    <Link className='btn btn-danger' to={`/`}>Cancel</Link>
                </form>
            </div>

        </div>
    )
}

export default Create