import React, { useState } from 'react';

const UserForm = () => {

    const initialForm = {
        firstName:"",
        lastName:"",
        email:"",
        password:"",
        confirmPassword:""
    };
    const [user, setUser] = useState(initialForm);

    const [userError,setUserError] = useState({
        firstNameError:"First Name must be at least 2 characters",
        lastNameError: "Last Name must be at least 2 characters",
        emailError: "Email must be at least 5 characters",
        passwordError: "Password must be at least 8 characters",
        confirmPasswordError: "Password must Match"     
    });

    const [isFirstNameError,setIsFirstNameError]= useState(false);
    const [isLastNameError,setIsLastNameError]= useState(false);
    const [isEmailError,setIsEmailError]= useState(false);
    const [isPasswordError,setIsPasswordError]= useState(false);
    const [isConfirmPasswordError,setIsConfirmPasswordError]= useState(false);         
    

    const createUser = (e) => {
        e.preventDefault();
        const newUser = user;
        console.log("Welcome", newUser);
        handleReset();
    }
    
    const handleOnChange=(e)=>{ 
        
        if (e.target.name === "firstName" && e.target.value.length <= 2 ){
            setIsFirstNameError(true)
        }else{
            setIsFirstNameError(false)
        }
        
        if (e.target.name === "lastName" && e.target.value.length <= 2 ){
            setIsLastNameError(true)
        }else{
            setIsLastNameError(false)
        }

        if (e.target.name === "email" && e.target.value.length <= 5 ){
            setIsEmailError(true)
        }else{
            setIsEmailError(false)
        }

        if (e.target.name === "password" && e.target.value.length < 8 ){
            setIsPasswordError(true)
        }else{
            setIsPasswordError(false)
        }

        if (e.target.name === "confirmPassword" && e.target.value !== user.password ){
            setIsConfirmPasswordError(true)
        }else{
            setIsConfirmPasswordError(false)
        }

        setUser({
            ...user,
            [e.target.name]:e.target.value
        })
    } 

    const handleReset = () =>{
        setUser(initialForm);
    }

    return (
        <div className='col-5 mx-auto'>
            <form onSubmit={createUser}>
                <div className="form-group">
                    <label className="form-label" htmlFor="firstName">First Name</label>
                    <input className="form-control" onChange={handleOnChange} type="text" name="firstName" value={user.firstName} />
                    {
                        isFirstNameError ? <span className='text-danger'>{userError.firstNameError}</span> : ''
                    }
                </div>
                <div className="form-group">
                    <label className="form-label" htmlFor="lastName">Last Name</label>
                    <input className="form-control" onChange={handleOnChange} type="text" name="lastName" value={user.lastName}/>
                    {
                        isLastNameError ? <span className='text-danger'>{userError.lastNameError}</span> : ''
                    }
                </div>
                <div className="form-group">
                    <label className="form-label" htmlFor="email">Email</label>
                    <input className="form-control" onChange={handleOnChange} type="email" name="email" value={user.email}/>
                    {
                        isEmailError ? <span className='text-danger'>{userError.emailError}</span> : ''   
                    }
                </div>
                <div className="form-group">
                    <label className="form-label" htmlFor="password">Password</label>
                    <input className="form-control" onChange={handleOnChange} type="password" name="password" value={user.password}/>
                    {
                        isPasswordError ? <span className='text-danger'>{userError.passwordError}</span> : ''   
                    }
                </div>
                <div className="form-group">
                    <label className="form-label" htmlFor="confirmPassword">Confirm Password</label>
                    <input className="form-control" onChange={handleOnChange} type="password" name="confirmPassword" value={user.confirmPassword}/>
                    {
                        isConfirmPasswordError ? <span className='text-danger'>{userError.confirmPasswordError}</span> : ''
                    }
                </div>
                <button className='btn btn-warning' type='submit'>Submit</button>
            </form>
        </div>
    );
}

export default UserForm;