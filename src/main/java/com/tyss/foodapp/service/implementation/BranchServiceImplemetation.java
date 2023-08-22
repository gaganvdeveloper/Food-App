package com.tyss.foodapp.service.implementation;

import java.util.List;

import javax.persistence.Query;

import com.tyss.foodapp.dao.implementation.BranchDaoImplementation;
import com.tyss.foodapp.dto.Branch;
import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.BranchService;

public class BranchServiceImplemetation implements BranchService {

	BranchDaoImplementation dao = new BranchDaoImplementation();

	@Override
	public Branch saveBranch(Branch branch) {
		return dao.saveBranch(branch);
	}

	@Override
	public Branch updateBranch(Branch branch) {
		return dao.updateBranch(branch);
	}

	@Override
	public Branch findBranchById(int id) {
		return dao.findBranch(id);
	}

	@Override
	public boolean deleteBranchById(int id) {
		return dao.deleteBranch(id);
	}

	@Override
	public Branch findBranchByName(String branchName) {
		return dao.findBranchByName(branchName);
	}

	@Override
	public Object findBranchManagerByBranchId(int id) {
		Branch branch = findBranchById(id);
		if (branch != null) {
			return branch.getUser();
		}
		return "User Not found With given ID";
	}

	@Override
	public List<Branch> findAllBranchs() {
		return dao.findAll();
	}

}
