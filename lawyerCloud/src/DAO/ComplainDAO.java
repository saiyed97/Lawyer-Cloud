package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.ComplainVO;
import VO.LawyerRegisterVO;
import VO.LoginVO;

public class ComplainDAO {

	public void insertComplain(ComplainVO complainVO) 
	{
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(complainVO);
			
			transaction.commit();
			
			session.close();
		}
	catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

	public List searchComplainForAdmin(ComplainVO complainVO) 
	{
		List complainList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q = session.createQuery("from ComplainVO where complainTo like 1");
			
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

	public void insertComplainReply(ComplainVO complainVO) 
	{
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.update(complainVO);
			
			transaction.commit();
			
			session.close();
		}
	catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

	public List searchComplainForComplainReply(ComplainVO complainVO) 
	{
		List complainList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from ComplainVO where complainId = '"+complainVO.getComplainId()+"'");
			
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

	public List searchloginId(LawyerRegisterVO lvo) {
		// TODO Auto-generated method stub
		List complainList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q = session.createQuery("from LawyerRegisterVO where registerId ='"+lvo.getRegisterId()+"'");
			
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

	public List searchLawyerSentComplains(ComplainVO complainVO) 
	{
		// TODO Auto-generated method stub
		List complainList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q = session.createQuery("from ComplainVO where complainFrom = '"+complainVO.getFromLoginVO().getLoginId()+"'");
			
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

	public List searchClientSentComplains(ComplainVO complainVO)
	{
		// TODO Auto-generated method stub
		List complainList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q = session.createQuery("from ComplainVO where complainFrom = '"+complainVO.getFromLoginVO().getLoginId()+"'");
			
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

	public List searchComplainForLawyer(LoginVO loginVO)
	{
		// TODO Auto-generated method stub
		List complainList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q = session.createQuery("from ComplainVO where complainTo = '"+loginVO.getLoginId()+"'");
			
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

}
