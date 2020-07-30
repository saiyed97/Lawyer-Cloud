package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.CategoryVO;
import VO.ClientRegisterVO;
import VO.ComplainVO;
import VO.LawyerRegisterVO;
import VO.LoginVO;
import VO.RequestLawyerVO;

public class LoginDAO {

	public void insertFields(LoginVO loginVO) {
		
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(loginVO);
			
			transaction.commit();
			
			session.close();
		}
	catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
	}

	public List authentication(LoginVO loginVO) {
		// TODO Auto-generated method stub
		List categoryList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from LoginVO where email='"+loginVO.getEmail()+"' and password='"+loginVO.getPassword()+"'");
			
			categoryList = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return categoryList;
	}

	public List searchClientRegisterList(ClientRegisterVO clientRegisterVO) 
	{
		List clientRegisterDetails = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from ClientRegisterVO where loginId ='"+clientRegisterVO.getLoginVO().getLoginId()+"'");
			
			clientRegisterDetails = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return clientRegisterDetails;
	}

	public List searchLawyerRegisterList(LawyerRegisterVO lawyerRegisterVO) 
	{
		List lawyerRegisterDetails = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from LawyerRegisterVO where loginId ='"+lawyerRegisterVO.getLoginVO().getLoginId()+"'");
			
			lawyerRegisterDetails = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return lawyerRegisterDetails;
	}

	public List search(LoginVO loginVO) {
		// TODO Auto-generated method stub
		List lawyerRegisterDetails = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from LoginVO where role ='Lawyer'");
			
			lawyerRegisterDetails = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return lawyerRegisterDetails;
	}

	public List search1(LoginVO loginVO) 
	{
		// TODO Auto-generated method stub
		List clientRegisterDetails = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from LoginVO where role = 'Client'");
			
			clientRegisterDetails = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return clientRegisterDetails;
	}

	public List search2(RequestLawyerVO requestLawyerVO)
	{
		// TODO Auto-generated method stub
		List requestsDetails = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from RequestLawyerVO");
			
			requestsDetails = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return requestsDetails;
	}

	public List search3(ComplainVO complainVO) 
	{
		// TODO Auto-generated method stub
		List complainsDetails = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from ComplainVO");
			
			complainsDetails = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return complainsDetails;
	}

	public List search4(CategoryVO categoryVO)
	{
		// TODO Auto-generated method stub
		List categoryDetails = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from CategoryVO");
			
			categoryDetails = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return categoryDetails;
	}

	public List search5(RequestLawyerVO requestLawyerVO) 
	{
		List categoryListOne = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from RequestLawyerVO where categoryId = 1");
			
			categoryListOne = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return categoryListOne;
	}
	
	public List search6(RequestLawyerVO requestLawyerVO) 
	{
		List categoryListTwo = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from RequestLawyerVO where categoryId = 2");
			
			categoryListTwo = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return categoryListTwo;
	}
	public List search7(RequestLawyerVO requestLawyerVO) 
	{
		List categoryListThree = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from RequestLawyerVO where categoryId = 3");
			
			categoryListThree = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return categoryListThree;
	}
	public List search8(RequestLawyerVO requestLawyerVO) 
	{
		List categoryListFour = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from RequestLawyerVO where categoryId = 4");
			
			categoryListFour = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return categoryListFour;
	}
	
	public List search9(RequestLawyerVO requestLawyerVO) 
	{
		List categoryListFive = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from RequestLawyerVO where categoryId = 5");
			
			categoryListFive = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return categoryListFive;
	}
	
	public List search10(RequestLawyerVO requestLawyerVO) 
	{
		List categoryListSix = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from RequestLawyerVO where categoryId = 6");
			
			categoryListSix = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return categoryListSix;
	}

	public void updatePassword(LoginVO loginVO) 
	{
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

	public List getLogin(LoginVO loginVO) 
	{
		List loginList = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from LoginVO where loginId = '"+loginVO.getLoginId()+"'");
			
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

	public List search11(RequestLawyerVO requestLawyerVO) 
	{
		List categoryList7 = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from RequestLawyerVO where categoryId = 7");
			
			categoryList7 = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return categoryList7;

	}
	
	public List search12(RequestLawyerVO requestLawyerVO) 
	{
		List categoryList8 = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from RequestLawyerVO where categoryId = 8");
			
			categoryList8 = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return categoryList8;

	}

	
	public List search13(RequestLawyerVO requestLawyerVO) 
	{
		List categoryList9 = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from RequestLawyerVO where categoryId = 9");
			
			categoryList9 = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return categoryList9;

	}

	
	public List search14(RequestLawyerVO requestLawyerVO) 
	{
		List categoryList10 = new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			Query q = session.createQuery("from RequestLawyerVO where categoryId = 10");
			
			categoryList10 = q.list();
			
			transaction.commit();
			
			session.close();
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return categoryList10;

	}


}
