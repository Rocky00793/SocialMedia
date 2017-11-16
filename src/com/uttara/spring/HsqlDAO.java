package com.uttara.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class HsqlDAO implements DAO 
{
	
	private String nname;
	private String eemail;
	private String ppassword;
	
	public String getNname() {
		return nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}

	public String getEemail() {
		return eemail;
	}

	public void setEemail(String eemail) {
		this.eemail = eemail;
	}

	public String getPpassword() {
		return ppassword;
	}

	public void setPpassword(String ppassword) {
		this.ppassword = ppassword;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eemail == null) ? 0 : eemail.hashCode());
		result = prime * result + ((nname == null) ? 0 : nname.hashCode());
		result = prime * result + ((ppassword == null) ? 0 : ppassword.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HsqlDAO other = (HsqlDAO) obj;
		if (eemail == null) {
			if (other.eemail != null)
				return false;
		} else if (!eemail.equals(other.eemail))
			return false;
		if (nname == null) {
			if (other.nname != null)
				return false;
		} else if (!nname.equals(other.nname))
			return false;
		if (ppassword == null) {
			if (other.ppassword != null)
				return false;
		} else if (!ppassword.equals(other.ppassword))
			return false;
		return true;
	}
	
	

	@Override
	public String toString() {
		return "HsqlDAO [nname=" + nname + ", eemail=" + eemail + ", ppassword=" + ppassword + "]";
	}

	public boolean insert(RegBean bean) 
	{
		
		Connection con = null;
		PreparedStatement ps_ins = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		
		
		try
		{
			con = JDBCHelper.getConnection();
			ps_ins = con.prepareStatement("insert into UserDetailsTBL(name,lname,email,dob,password,cpassword,city) values(?,?,?,?,?,?,?) ");
			ps_ins.setString(1, bean.getName());
			ps_ins.setString(2, bean.getLname());
			ps_ins.setString(3, bean.getEmail());
			ps_ins.setDate(4, new java.sql.Date(bean.getDob().getTime()));
			ps_ins.setString(5, bean.getPassword());
			ps_ins.setString(6, bean.getCpassword());
			ps_ins.setString(7, bean.getPassword());
			
			ps1 = con.prepareStatement("select * from UserDetailsTBL");
			
			//FileInputStream fin = new FileInputStream(bean.getPic());
			
			//ps_ins.setBlob(5, x);
			ps_ins.execute();
			ps1.execute();
			rs = ps1.getResultSet();
			
			while(rs.next())
			{
				 nname = rs.getString("name"); 
				eemail  = rs.getString("email");
				ppassword = rs.getString("password");
				
				System.out.println("name :"+nname+ "Email :"+eemail);
			
			}
			
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			JDBCHelper.close(ps_ins);
			JDBCHelper.close(con);
		}
		
		
		
	}

	public boolean Login(LoginRegBean bean) 
	{
		
		Connection con = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		try
		{
			String email = bean.getEmail();
			String pass = bean.getPassword();
			con = JDBCHelper.getConnection();	
			ps1 = con.prepareStatement("select * from UserDetailsTBL  WHERE EMAIL='"+email+"' AND PASSWORD='"+pass+"'");
			
			//FileInputStream fin = new FileInputStream(bean.getPic());
			
			//ps_ins.setBlob(5, x);
			ps1.execute();
			rs = ps1.getResultSet();
			if(rs.next())
				return true;
			else
				return false;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			JDBCHelper.close(con);
		}
	}
	public boolean update(String email, RegBean bean)
	{
		return false;
	}

	public boolean delete(String email)
	{
		return false;
	}

	public List<RegBean> getUsers() 
	{
		return null;
	}

	public RegBean getUserInfo(String email) 
	{
		return null;
	}

}
