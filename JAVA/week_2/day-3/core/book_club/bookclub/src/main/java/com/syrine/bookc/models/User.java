package com.syrine.bookc.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //username
    @NotEmpty(message = "Name is required")
	@Size(min=2 , max= 200 , message="Name must be between 2 and 200 characters")
	private String name;
    //email
    @NotEmpty(message = "Email is required")
	@Email(message="Email must be valid")
	private String email;
    //password
    @NotEmpty(message = "Password is required")
    @Size(min=8 , max=200, message="Password must be at least 8 characters")
    private String password;
    //confirm password
    @Transient
    @NotEmpty(message = "Confirm Password is required")
    @Size(min=8 , max=200, message="Confirm Password must be at least 8 characters")
    private String confirmPassword;
    //createdAt and updatedAt 
    @Column(updatable = false)
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date updatedAT;
    
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
		
	@PreUpdate
    protected void onUpdate(){
        this.updatedAT = new Date();
		}
	
	  //relationship
    @OneToMany(mappedBy="postedBy", fetch = FetchType.LAZY)
    private List<Book> books;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAT() {
		return updatedAT;
	}

	public void setUpdatedAT(Date updatedAT) {
		this.updatedAT = updatedAT;
	}

	public User() {
		super();
	}
	}