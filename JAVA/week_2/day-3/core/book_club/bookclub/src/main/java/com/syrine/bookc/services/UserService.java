package com.syrine.bookc.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.syrine.bookc.Repositories.UserRepository;
import com.syrine.bookc.models.LoginUser;
import com.syrine.bookc.models.User;

@Service
public class UserService {
	
    @Autowired
    private UserRepository userRepository;
    
    //! Register
    //register user and hash their password
    public User register(User newUser, BindingResult result){
        //check if email is already in the database
        Optional<User> opUser = userRepository.findByEmail(newUser.getEmail());
        //if email is already in the database
        if(opUser.isPresent()){
            //rejectValue is used to send an error message to the view
            result.rejectValue("email", "registerErrors", "This email is already in use");
        }
        //check if password and confirm password match
        if(!newUser.getPassword().equals(newUser.getConfirmPassword())){
            //rejectValue is used to send an error message to the view
            result.rejectValue("confirmPassword", "registerErrors", "Passwords do not match");
        }
        //if there are errors
        if(result.hasErrors()){
        return null;
        }else{
            //hash the password
            newUser.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
            //save the user
            return userRepository.save(newUser);
        }
    }
    
    
    //login user
    public User login(LoginUser newLogin, BindingResult result){
        //check if email is in the database
        Optional<User> opUser = userRepository.findByEmail(newLogin.getEmail());
        //if user is not present in the database
        if(!opUser.isPresent()){
            result.rejectValue("email", "loginErrors", "Invalid credential!");

        }else{
            User user = opUser.get();
            //check if password matches
            if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())){
                //if password does not match
                result.rejectValue("password", "loginErrors", "Invalid credential!");
            }
            //if there are errors
            if(result.hasErrors()){
                return null;
            }else{
                //if there are no errors
                return user;
            }
        }
        return null;
    }
    
    
    //find user by id
    public User findUserById(Long id){
        Optional<User> opUser = userRepository.findById(id);
        if(opUser.isPresent()){
            return opUser.get();
        }else{
            return null;
        }
    }

}
