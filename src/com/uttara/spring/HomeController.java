package com.uttara.spring;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

//Main controller 
@Controller("/SocialMedia")
public class HomeController
{
	//wiring with HsqlDAO
	@Autowired
	HsqlDAO database;

	//Requesting for homepage
	@RequestMapping("/")
	public String ShowHome()
	{
		try
		{
			return "HomePage";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}

	}
	
	//Requesting for user register page
	@RequestMapping("/openregister")
	public String showreg(Model model)
	{
			try
			{
				RegBean bean = new RegBean();
				model.addAttribute("bean",bean);
				return "Register";
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return null;
			}
	
	}
	
	@RequestMapping("/register")
	public String register (@ModelAttribute("bean") @Valid RegBean bean,BindingResult result, Model model)
	{
		try
		{
			System.out.println("bean ="+bean+"val res"+result);
			if(result.hasErrors())
			{
				model.addAttribute("bean",bean);
				return "Register";
			}
			else
			{
				database.insert(bean);
				return "Success";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
	
	//Requesting homepage back from success register page
	@RequestMapping("/backtohp ")
	public String Backhp()
	{
		try
		{
			return "HomePage";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("/login")
	public String Login(Model model)
	{
			try
			{
				LoginRegBean bean1 = new LoginRegBean();
				model.addAttribute("bean",bean1);
				boolean log = database.Login(bean1);
				if(log)
					return "Loginpage";
				else
					return "HomePage";
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return null;
			}
	
	}
}
