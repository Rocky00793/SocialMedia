package com.uttara.spring;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


public class RegBean 
{
	//Declaring input fields in register page
	@NotEmpty
	@Length(min=5, max=20)
	private String name,lname,city;
	@NotEmpty
	@Email
	private String email;
	//@PasswordValidator
	@Length(min=5, max=20)
	private String password,cpassword;
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Past
	private Date dob;
	
	
	//Getters and setters for the inputfields
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getCpassword() 
	{
		return cpassword;
	}
	public void setCpassword(String cpassword) 
	{
		this.cpassword = cpassword;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getLname() 
	{
		return lname;
	}
	public void setLname(String lname) 
	{
		this.lname = lname;
	}
	public String getCity() 
	{
		return city;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}
	public Date getDob() 
	{
		return dob;
	}
	public void setDob(Date dob) 
	{
		this.dob = dob;
	}
	
	//hascode
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((cpassword == null) ? 0 : cpassword.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegBean other = (RegBean) obj;
		if (city == null) 
		{
			if (other.city != null)
				return false;
		} 
		else if (!city.equals(other.city))
			return false;
		if (cpassword == null) 
		{
			if (other.cpassword != null)
				return false;
		} 
		else if (!cpassword.equals(other.cpassword))
			return false;
		if (dob == null) 
		{
			if (other.dob != null)
				return false;
		} 
		else if (!dob.equals(other.dob))
			return false;
		if (email == null) 
		{
			if (other.email != null)
				return false;
		} 
		else if (!email.equals(other.email))
			return false;
		if (lname == null) 
		{
			if (other.lname != null)
				return false;
		} 
		else if (!lname.equals(other.lname))
			return false;
		if (name == null) 
		{
			if (other.name != null)
				return false;
		} 
		else if (!name.equals(other.name))
			return false;
		if (password == null) 
		{
			if (other.password != null)
				return false;
		} 
		else if (!password.equals(other.password))
			return false;
		return true;
	}
	
	//Tostring
	@Override
	public String toString() 
	{
		return "RegBean [email=" + email + ", password=" + password + ", cpassword=" + cpassword + ", name=" + name
				+ ", lname=" + lname + ", city=" + city + ", dob=" + dob + "]";
	}
	
	
	
}
