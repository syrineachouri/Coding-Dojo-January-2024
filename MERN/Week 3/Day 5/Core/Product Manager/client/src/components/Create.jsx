import React, { useState } from 'react'
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
const Create = () => {
  const [title, setTitle] = useState("")
  const [price, setPrice] = useState("")
  const [description, setDescription] = useState("")
  const [errors, setErrors] = useState([])
  const navigate = useNavigate();
  const SubmitHandler = (e) => {
    e.preventDefault()
    axios.post('http://localhost:8000/api/product/new', { title, price, description })
      .then(res => {
        console.log(res);
        navigate('/');
      })
      .catch(err => {
        const errorRes = err.response.data.errors;
        const errArray = []
        for (const key of Object.keys(errorRes)) {
          errArray.push(errorRes[key].message)
        }
        setErrors(errArray)
      });
  }


  return (
    <div className='container'>
      <h1>Product Manager</h1>
      <form onSubmit={SubmitHandler}>
        {errors.map((err,i)=>(
          <p key={i} className='text-danger'>{err}</p>
        ))}
        <label className='label-control'>Title</label>
        <input type="text" className='form-control' value={title} onChange={(e) => setTitle(e.target.value)} />
        <label className='label-control'>Price</label>
        <input type="text" className='form-control' value={price} onChange={(e) => setPrice(e.target.value)} />
        <label className='label-control'>description</label>
        <input type="text" className='form-control' value={description} onChange={(e) => setDescription(e.target.value)} />

        <button className='btn btn-success '> Create</button>



      </form>

    </div>
  )
};

export default Create;
