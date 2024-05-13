import React, { useEffect } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import { useState } from 'react';
import axios from 'axios';

const Edit = () => {
  const {id}=useParams()
  const nav = useNavigate();
  const [title, setTitle] = useState("")
  const [price, setPrice] = useState("")
  const [description, setDescription] = useState("")
  const [errors, setErrors] = useState([])
  const navigate = useNavigate();
  const SubmitHandler = (e) => {
    e.preventDefault()
    axios.patch('http://localhost:8000/api/product/'+id, { title, price, description })
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





  useEffect(()=>{
    axios.get('http://localhost:8000/api/product/'+id)
    .then(res=>{
      setTitle(res.data.title)
      setPrice(res.data.price)
      setDescription(res.data.description)
    })
    

  },[id])
  return (
    <div className='container'>
      <h1>Edit </h1>
    <form onSubmit={SubmitHandler}>
      {errors.map((err,i)=>(
        <p key={i} className='text-danger'>{err}</p>
      ))}
      <label className='label-control'>Title</label>
      <input type="text" className='form-control' value={title} onChange={(e) => setTitle(e.target.value)} />
      <label className='label-control'>Price</label>
      <input type="text" className='form-control' value={price} onChange={(e) => setPrice(e.target.value)} />
      <label className='label-control'>Description</label>
      <input type="text" className='form-control' value={description} onChange={(e) => setDescription(e.target.value)} />

      <button className='btn btn-success '> Edit</button>



    </form>

  </div>
)
};

export default Edit;
