package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.ContactUsVO;
import VO.LoginVO;

public class ContactUsDAO {

	public void insertContactUsDetails(ContactUsVO contactUsVO) 
	{
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(contactUsVO);
			
			transaction.commit();
			
			session.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

	public List searchContactsUsDetails()
	{
		List contactUsDetailsList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from ContactUsVO");
			
			contactUsDetailsList = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return contactUsDetailsList;
		
	}

	public List verifyEmailId(LoginVO loginVO) 
	{
		List loginList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q = session.createQuery("from LoginVO where email = '"+loginVO.getEmail()+"'");
			
			loginList = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return loginList;
		
	}

	public void updatePassword(LoginVO loginVO) 
	{
		// TODO Auto-generated method stub
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.update(loginVO);
			
			transaction.commit();
			
			session.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
