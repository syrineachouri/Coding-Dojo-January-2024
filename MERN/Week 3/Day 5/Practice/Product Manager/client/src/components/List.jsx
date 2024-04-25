import React, { useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';
const List = () => {

  const [product, setProduct] = useState([])
  const nav = useNavigate();
  useEffect(() => {
    axios.get('http://localhost:8000/api/product')
      .then(res => {
        setProduct(res.data)
      })
      .catch(err => console.log(err));
  }, [])

  const deleteObject = (id)=>{
    axios.delete(`http://localhost:8000/api/product/delete/${id}`)
    .then(res=>{
      setProduct(product.filter(c=>c._id !== id))
    })
    .catch(err=>console.log(err))
  }


  return (
    <div>
      <table className='table'>
        <thead>
          <th>Title</th>

          <th>Actions</th>
        </thead>
        <tbody>
          {product.map(c => (
            <tr key={c._id}>
              <td> <Link to={`/product/${c._id}`}>{c.title}</Link></td>
              <td>
                <button className='btn btn-primary' onClick={() => nav(`/product/edit/${c._id}`)}>Edit</button>
                <button className='btn btn-danger' onClick={()=>deleteObject(c._id)}>delete</button>

              </td>



            </tr>

          ))}
        </tbody>
      </table>

    </div>
  )
}

export default List;
