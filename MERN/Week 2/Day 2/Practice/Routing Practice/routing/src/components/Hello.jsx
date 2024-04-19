import React from "react";
import { useParams } from "react-router-dom";

const Hello = (props) => {
    const {string, color1, color2} = useParams();

    return(
        isNaN(string) ? 
        <h1 style={{color : color1, backgroundColor : color2}}> The word is : {string} </h1> : 
        <h1> The number is : {string} </h1>
    )
    }

export default Hello;