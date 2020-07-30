package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.ClientRegisterVO;
import VO.LawyerRegisterVO;
import VO.LoginVO;
import VO.TestimonialVO;

public class TestimonialDAO {

	public List searchRole(LoginVO loginVO)
	{
		List roleList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from LoginVO where loginId ='"+loginVO.getLoginId()+"'");
			
			roleList = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return roleList;
		
	}

	public List searchClientDetails(ClientRegisterVO clientRegisterVO) 
	{
		List clientList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from ClientRegisterVO where 	ClientRegisterId ='"+clientRegisterVO.getRegisterId()+"'");
			
			clientList = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return clientList;
	}

	public List searchLawyerDetails(LawyerRegisterVO lawyerRegisterVO) 
	{
		List lawyerList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from LawyerRegisterVO where LawyerRegisterId ='"+lawyerRegisterVO.getRegisterId()+"'");
			
			lawyerList = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return lawyerList;
	}

	public void insertTestimonialDetails(TestimonialVO testimonialVO) 
	{
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(testimonialVO);
			
			transaction.commit();
			
			session.close();
		}
	catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

	public List searchTestimonialDetails() 
	{
		List testimonialList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from TestimonialVO");
			
			testimonialList = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return testimonialList;
		
	}

}
