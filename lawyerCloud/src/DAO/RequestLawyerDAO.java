package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.LawyerRegisterVO;
import VO.LoginVO;
import VO.RequestLawyerVO;

public class RequestLawyerDAO 
{

	public void insertRequestLawyer(RequestLawyerVO requestLawyerVO)
	{
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(requestLawyerVO);
			
			System.out.println(requestLawyerVO.getRequestDateAndTime());
			
			transaction.commit();
			
			session.close();
		}
	catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

	

	public List searchLs(LawyerRegisterVO lawyerRegisterVO) 
	{
		List ls = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q = session.createQuery("from LawyerRegisterVO where  loginId = '"+lawyerRegisterVO.getLoginVO().getLoginId()+"'");
			
			ls = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return ls;
	}
	
	
	public List searchClientRequest(RequestLawyerVO requestLawyerVO) 
	{
		List clientRequestList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q = session.createQuery("from RequestLawyerVO where  lawyerId = '"+requestLawyerVO.getLoginVO().getLoginId()+"'");
			
			clientRequestList = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return clientRequestList;
		
	}



	public List searchRequest(RequestLawyerVO requestLawyerVO) 
	{
		List clientRequestList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q = session.createQuery("from RequestLawyerVO where  requestLawyerId = '"+requestLawyerVO.getRequestLawyerId()+"'");
			
			clientRequestList = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return clientRequestList;
	}



	public void insertAcceptRequestDescription(RequestLawyerVO requestLawyerVO)
	{
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.update(requestLawyerVO);
			
			transaction.commit();
			
			session.close();
		}
	catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}



	public List searchMyRequest(RequestLawyerVO requestLawyerVO)
	{
		List myRequestList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q = session.createQuery("from RequestLawyerVO where  ClientId = '"+requestLawyerVO.getLoginVO().getLoginId()+"'");
			
			myRequestList = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return myRequestList;
	}



	public List searchLoginLs(LoginVO loginVO) 
	{
		// TODO Auto-generated method stub
		List loginLsList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q = session.createQuery("from LoginVO where  LoginId = '"+loginVO.getLoginId()+"'");
			
			loginLsList = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return loginLsList;
	}



	public List getLawyerLoginId(LawyerRegisterVO lawyerRegisterVO) 
	{
		// TODO Auto-generated method stub
		List loginLsList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q = session.createQuery("from LawyerRegisterVO where  LawyerRegisterId = '"+lawyerRegisterVO.getRegisterId()+"'");
			
			loginLsList = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return loginLsList;
	}



	
}
