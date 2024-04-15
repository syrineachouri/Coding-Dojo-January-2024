import React, { useState } from  'react';

const ColorForm = (props) => {

    const {boxcolorArray, setBoxcolorArray} = props;
    const [color, setColor] = useState("");
    const [size, setSize] = useState(50);

    const createBox = (e) => {
        e.preventDefault();
        setBoxcolorArray([...boxcolorArray, {color : color, size: size + "px"}])
    }

    return (
        <div>
            <form onSubmit={createBox}> 
                <label> Color : </label>
                <input  type='text' value={color} onChange={ (e) => setColor(e.target.value)}/>
                <label> Size : </label>
                <input type='number' value={size} onChange={ (e) => setSize(e.target.value)}/>
                <input type='submit' value={'Add'} />
            </form>
        </div>
    )
}

export default ColorForm;
