import React, { useState } from  'react';
    
const UserForm = (props) => {
    const [fname, setFname] = useState("");
    const [lname, setLname] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [cpassword, setCpassword] = useState("");
    
    const createUser = (e) => {
        e.preventDefault();
        
        const newUser = { fname, lname, email, password, cpassword };
        console.log("Welcome", newUser);
        setFname("");
        setLname("");
        setEmail("");
        setPassword("");
        setCpassword("")
    };
    
    return(
        <div>
            <form onSubmit={ createUser }>
                <div>
                    <label>First Name: </label> 
                    <input type="text" value={fname} onChange={ (e) => setFname(e.target.value) } />
                </div>
                <div>
                    <label> Last Name : </label>
                    <input type='text' value={lname} onChange={(e)=> setLname(e.target.value)}/>
                </div>
                <div>
                    <label>Email Address: </label> 
                    <input type="text" value={email} onChange={ (e) => setEmail(e.target.value) } />
                </div>
                <div>
                    <label>Password: </label>
                    <input type="text" value={password} onChange={ (e) => setPassword(e.target.value) } />
                </div>
                <div>
                    <label>Confirm Password: </label>
                    <input type="text" value={cpassword} onChange={ (e) => setCpassword(e.target.value) } />
                </div>
                <input type="submit" value="Create User" />
            </form>
            <div>
                <h4>Your data form</h4>
                <p>Your First Name : {fname} </p>
                <p> Your Last Name : {lname} </p>
                <p>Your email :{email} </p>
                <p>Your password : {password} </p>
                <p>Confirm Password : {cpassword}</p>
            </div>
        </div>
    );
};
    
export default UserForm;