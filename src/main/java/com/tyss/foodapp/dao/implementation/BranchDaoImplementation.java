package com.tyss.foodapp.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.foodapp.dao.BranchDao;
import com.tyss.foodapp.dto.Branch;
import com.tyss.foodapp.util.MyEntityManager;

public class BranchDaoImplementation implements BranchDao {

//	EntityManager manager = MyEntityManager.getEntityManager();
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	@Override
	public Branch saveBranch(Branch branch) {
		if (branch != null) {
			transaction.begin();
			manager.persist(branch);
			transaction.commit();
			return branch;
		}
		return null;
	}

	@Override
	public Branch updateBranch(Branch branch) {
		if (branch != null) {
			transaction.begin();
			manager.merge(branch);
			transaction.commit();
			return branch;
		}
		return null;
	}

	@Override
	public Branch findBranch(int id) {
		return manager.find(Branch.class, id);
	}

	@Override
	public boolean deleteBranch(int id) {
		Branch branch = findBranch(id);
		if (branch != null) {
			transaction.begin();
			manager.remove(branch);
			transaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public Branch findBranchByName(String name) {
		Query query = manager.createQuery("select b from Branch b where b.name=?1");
		query.setParameter(1, name);
		try {
			return (Branch) query.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	public List<Branch> findAll() {
		Query query = manager.createQuery("from Branch b");
		return query.getResultList();
	}

}
