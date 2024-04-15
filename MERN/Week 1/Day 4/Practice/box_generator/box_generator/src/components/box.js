import React from  'react';

const DisplayBox = (props) => {
    const {boxcolorArray} = props;
    return (
        <div> 
        {boxcolorArray.map( (box, index) => (
            <div key={index} 
                style={{
                    backgroundColor : box.color,
                    height : box.size,
                    width : box.size,
                    display : "inline-block",
                    margin : "15px",
                }}> 
            </div>
            ))
        }
        </div>
    );
}

export default DisplayBox;