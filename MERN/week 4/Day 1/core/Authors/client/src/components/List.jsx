import React, { useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';
const List = () => {

    const [author, setAuthor] = useState([])
    const nav = useNavigate();
    useEffect(() => {
        axios.get('http://localhost:8000/api/author')
            .then(res => {
                setAuthor(res.data)
            })
            .catch(err => console.log(err));
    }, [])

    const deleteObject = (id) => {
        axios.delete(`http://localhost:8000/api/author/delete/${id}`)
            .then(res => {
                setAuthor(author.filter(c => c._id !== id))
            })
            .catch(err => console.log(err))
    }


    return (
        <div>
            <h3>Favorite authors:</h3>
            <Link to={`/create`}>Add an author</Link>
            <p>We have quotes by:</p>
            <table className='table'>
                <thead>
                    <tr>
                        <th>Authors</th>
                        <th>Actions Available</th>
                    </tr>
                </thead>
                <tbody>
                    {author.map(c => (
                        <tr key={c._id}>
                            <td> {c.name} </td>
                            <td>
                                <button className='btn btn-primary' onClick={() => nav(`/author/edit/${c._id}`)}>Edit</button>
                                <button className='btn btn-danger' onClick={() => deleteObject(c._id)}>delete</button>

                            </td>



                        </tr>

                    ))}
                </tbody>
            </table>

        </div>
    )
}

export default List;