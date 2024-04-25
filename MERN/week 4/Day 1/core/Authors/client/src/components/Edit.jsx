import axios from 'axios'
import { useEffect } from 'react'
import React, { useState, } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom'

const Edit = () => {
    const { id } = useParams()
    const nav = useNavigate();
    const [name, setName] = useState("")
    const [errors, setErrors] = useState([])
    const navigate = useNavigate();

    const SubmitHandler = (e) => {
        e.preventDefault()
        axios.put(`http://localhost:8000/api/author/` + id, { name })
            .then((res) => {
                console.log("✅✅✅✅✅")
                navigate('/');
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

    useEffect(() => {
        axios.get('http://localhost:8000/api/author/' + id)
            .then(res => {
                setName(res.data.name)
            })

    }, [id])

    return (
        <div className='container'>
            <h3> Favorite authors:</h3>
            <Link to={`/`}>Home</Link>
            <p>Edit this author</p>
            <form onSubmit={SubmitHandler}>
                {errors.map((err, i) => (
                    <p key={i} className='text-danger'>{err}</p>
                ))}
                <label className='label-control'>Name</label>
                <input className='label-control' value={name} type="text" onChange={(e) => { setName(e.target.value) }} />
                <br />
                <button className='btn btn-success'>Submit</button>
                <Link className='btn btn-danger' to={`/`}>Cancel</Link>

            </form>


        </div>
    )
}

export default Edit