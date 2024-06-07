package com.syrine.bookc.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginUser {
	 @NotEmpty(message = "Email is required")
		@Email(message="Email must be valid")
		private String email;
	    //password
	    @NotEmpty(message = "Password is required")
	    @Size(min=8 , max=200, message="Password must be at least 8 characters")
	    private String password;
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public LoginUser() {
			super();
		}

}
