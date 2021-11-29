package api1.api1.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import api1.api1.validator.UserDob;


public class Users {
private  Long id;
	
	@NotNull
	@Size(message= "name should be less than 30 characters")
	private String name;
	
	@NotNull(message="The bithdate is required")
	@BirthDate
	private String dob;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Size(min=0,max=10)
	private String mobno;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	
	
	

}
