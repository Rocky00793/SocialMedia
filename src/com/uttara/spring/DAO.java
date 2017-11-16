package com.uttara.spring;

import java.util.List;

public interface DAO 
{

	public boolean insert(RegBean bean);
	public boolean update(String email, RegBean bean);
	public boolean delete(String email);
	public List<RegBean> getUsers();
	public RegBean getUserInfo(String email);
}
