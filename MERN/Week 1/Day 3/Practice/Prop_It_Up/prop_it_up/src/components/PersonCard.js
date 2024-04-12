import react from 'react'

const PersonCard = props => {
    return (
        <div>
            <h2>{props.firstname}, {props.lastname}</h2>
            <p>Age:{props.age}</p>
            <p>Hair color: {props.haircolor}</p>
        </div>

    )
}
export default PersonCard;