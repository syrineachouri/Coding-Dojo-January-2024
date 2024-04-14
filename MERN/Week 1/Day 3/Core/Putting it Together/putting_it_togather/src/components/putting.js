import react,{ useState } from 'react'

const putting = (props) => {
    const [age, setAge]= useState[props.age]
    const increase= ()=> {
        setAge(age+ 1);
    }
    return (
        <div>
            <h2>{props.firstname}, {props.lastname}</h2>
            <p>Age:{age}</p>
            <p>Hair color: {props.haircolor}</p>
            <button onClick={increase}> birth for {props.lastname} {props.firstname} </button>
        </div>

    )
}
export default putting;