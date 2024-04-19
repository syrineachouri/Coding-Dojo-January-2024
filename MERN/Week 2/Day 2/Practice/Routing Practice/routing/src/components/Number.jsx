import React from "react";
import { useParams } from "react-router-dom";

const Number = (props) => {
    const {num } = useParams();

    return(
        isNaN({num}) ? null :
        <h1> The num is : {num} </h1> 
    )
}
export default Number;