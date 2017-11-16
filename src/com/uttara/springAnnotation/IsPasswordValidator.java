package com.uttara.springAnnotation;



import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class IsPasswordValidator implements ConstraintValidator <PasswordValidator, String> 
{
	
	@Override
	public void initialize(PasswordValidator constrainAnnotation) 
	{
		
		
	}

	@Override
	public boolean isValid(String Password, ConstraintValidatorContext context) 
	{
		
		if(Password == null)
		{
			return false;
		}
		if(Password.matches("abc"))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

}
