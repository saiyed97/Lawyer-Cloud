package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.StateVO;

public class StateDAO 
{

	public void insertState(StateVO stateVO)
	{
		// TODO Auto-generated method stub
		
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(stateVO);
			
			transaction.commit();
			
			session.close();
		}
	catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

	public List searchState()
	{
		List stateList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from StateVO");
			
			stateList = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return stateList;
	}
	
	public void deleteState(StateVO stateVO)
	{
		// TODO Auto-generated method stub
		
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.delete(stateVO);
			
			transaction.commit();
			
			session.close();
		}
	catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

	public List editState(StateVO stateVO) 
	{
		List editStateList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from StateVO where StateId='"+stateVO.getStateId()+"'");
			
			editStateList = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return editStateList;

	}

	public void updateState(StateVO stateVO) 
	{
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.update(stateVO);
			
			transaction.commit();
			
			session.close();
		}
	catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
}
