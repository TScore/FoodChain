package com.foodsupplay.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.loader.custom.Return;

import com.foodsupplay.hibernate.util.HibernateUtil;
import com.foodsupplay.model.User;

public class RegisterService {
	public  boolean register(User user)
	{
		Session session=HibernateUtil.openSession();
		if(isUserExists(user))
		{
			return false;
		}
		Transaction tx=null;
		try
		{

		}catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return true;

	}

	private boolean isUserExists(User user) {
		Session session=HibernateUtil.openSession();
		boolean result=false;
		Transaction tx=null;
		try
		{
			tx=session.getTransaction();
			tx.begin();
			Query qusery=session.createQuery("From user where userId='"+user.getUserID()+"'");
			User u=(User)qusery.uniqueResult();
			tx.commit();
			if(u!=null)
				result=true;
		}
		catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}

		}
		finally 
		{
			session.close();
		}

		return result;
	}
}
