package com.tyss.foodapp.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.foodapp.dao.UserDao;
import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.util.MyEntityManager;

public class UserDaoImplementation implements UserDao {

//	EntityManager manager = MyEntityManager.getEntityManager();
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	@Override
	public User saveUser(User user) {
		if (user != null) {
			transaction.begin();
			manager.persist(user);
			transaction.commit();
			return user;
		}
		return null;
	}

	@Override
	public User updateUser(User user) {
		if (user != null) {
			transaction.begin();
			manager.merge(user);
			transaction.commit();
			return user;
		}
		return null;
	}

	@Override
	public User findUser(int id) {
		return manager.find(User.class, id);
	}

	@Override
	public boolean deleteUser(int id) {
		User user = findUser(id);
		if (user != null) {
			transaction.begin();
			manager.remove(user);
			transaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public User verifyUser(String email, String password) {
		Query query = manager.createQuery("select u from User u where u.email=?1 and u.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		try {
			User user = (User) query.getSingleResult();
			return user;
		} catch (NoResultException e) {
			return null;
		}
//		List<User> users = query.getResultList();
//		if (users.size() > 0) {
//			return users.get(0);
//		}
//		return null;
	}

	@Override
	public User findByUsername(String username) {
		Query query = manager.createQuery("select u from User u where u.name=?1");
		query.setParameter(1, username);
		List<User> users = query.getResultList();
		if (users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public User findByEmail(String email) {
		Query query = manager.createQuery("select u from User u where u.email=?1");
		query.setParameter(1, email);
		List<User> users = query.getResultList();
		if (users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

}
