package com.WareTech.CmsTech.service;

import java.util.List;

import com.WareTech.CmsTech.database.Database;
import com.WareTech.CmsTech.entity.Access;
import com.WareTech.CmsTech.entity.User;

public class SecurityService 
{
	static protected SecurityService securityService = new SecurityService();
	
	/**
	 * @return
	 */
	static public SecurityService getInstance()
	{
		return SecurityService.securityService;
	}
	
	/**
	 * @param user
	 * @param access
	 * @return
	 */
	public boolean checkAuthorization(
			User user,
			String url
			) 
	{
		System.out.println(String.format("SecurityService#checkAuthorization user=%s url=%s", user, url));

		if (url == null || "".equals(url))
		{
			return true;
		}
			
		if (url.startsWith("_"))
		{
			return true;
		}
			
		List<Access> accessList = Database.getCurrentSession()
				.createQuery("FROM Access WHERE value = :value")
				.setParameter("value", url)
				.list();
		
		return accessList.size() == 0;
	}
	
}