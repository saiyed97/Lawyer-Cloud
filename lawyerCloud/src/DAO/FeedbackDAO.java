package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.FeedbackVO;
import VO.LawyerRegisterVO;
import VO.LoginVO;

public class FeedbackDAO {

	public void insertFeedback(FeedbackVO feedbackVO) {
		
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(feedbackVO);
			
			transaction.commit();
			
			session.close();
		}
	catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

	public List searchFeedbackForAdmin() 
	{
		List feedbackList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from FeedbackVO where feedbackTo like 1");
			
			feedbackList = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return feedbackList;
	}

	public List searchloginId(LawyerRegisterVO lawyerRegisterVO)
	{
		// TODO Auto-generated method stub
		List complainList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q = session.createQuery("from LawyerRegisterVO where registerId ='"+lawyerRegisterVO.getRegisterId()+"'");
			
			complainList = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return complainList;
	}

	public List searchName(LawyerRegisterVO lawyerRegisterVO) 
	{
		// TODO Auto-generated method stub
		List nameList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q = session.createQuery("from LawyerRegisterVO where LawyerRegisterId = '"+lawyerRegisterVO.getRegisterId()+"'");
			
			nameList = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return nameList;
	}

	public List searchClientSentComplains(FeedbackVO feedbackVO) 
	{
		// TODO Auto-generated method stub
		List feedbackList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q = session.createQuery("from FeedbackVO where feedbackFrom = '"+feedbackVO.getFromLoginVO().getLoginId()+"'");
			
			feedbackList = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return feedbackList;
	}

	public List searchLawyerSentComplains(FeedbackVO feedbackVO) 
	{
		// TODO Auto-generated method stub
		List feedbackList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q = session.createQuery("from FeedbackVO where feedbackFrom = '"+feedbackVO.getFromLoginVO().getLoginId()+"'");
			
			feedbackList = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return feedbackList;
	}

	public List searchFeedbackForLawyer(LoginVO loginVO)
	{
		// TODO Auto-generated method stub
		List feedbackList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q = session.createQuery("from FeedbackVO where feedbackTo = '"+loginVO.getLoginId()+"'");
			
			feedbackList = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return feedbackList;
	}

	

	
	
	

}
