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

public class LawyerRegisterDAO {

	public void insertFieldsForLawyer(LawyerRegisterVO lawyerRegisterVO) 
	{
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(lawyerRegisterVO);
			
			transaction.commit();
			
			session.close();
		}
	catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public List searchLawyer()
	{
		List lawyerList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from LawyerRegisterVO");
			
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

	public List searchLawyerForClient(LawyerRegisterVO lawyerRegisterVO)
	{
		List lawyerList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q = session.createQuery("from LawyerRegisterVO where stateId = '"+lawyerRegisterVO.getStateVO().getStateId()+"' or cityId = '"+lawyerRegisterVO.getCityVO().getCityId()+"' or areaId = '"+lawyerRegisterVO.getAreaVO().getAreaId()+"' or categoryId = '"+lawyerRegisterVO.getCategoryVO().getCategoryId()+"'");
			
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

	public List searchLawyersByGroup(LawyerRegisterVO lawyerRegisterVO)
	{
		List lawyerList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q = session.createQuery("from LawyerRegisterVO Group By categoryId");
			
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

	public List searchLawyerProfile(LoginVO loginVO) 
	{
		List lawyerList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q = session.createQuery("from LawyerRegisterVO where loginId = '"+loginVO.getLoginId()+"'");
			
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

	public void editProfile(LawyerRegisterVO registerVO) 
	{
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.update(registerVO);
			
			transaction.commit();
			
			session.close();
		}
	catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

	public void updateProfileImage(LawyerRegisterVO registerVO)
	{
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.update(registerVO);
			
			transaction.commit();
			
			session.close();
		}
	catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
}
