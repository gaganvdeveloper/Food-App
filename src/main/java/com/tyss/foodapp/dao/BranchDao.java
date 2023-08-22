package com.tyss.foodapp.dao;

import java.util.List;

import com.tyss.foodapp.dto.Branch;

public interface BranchDao {

	public Branch saveBranch(Branch branch);

	public Branch updateBranch(Branch branch);

	public Branch findBranch(int id);

	public boolean deleteBranch(int id);

	Branch findBranchByName(String name);
	
	List<Branch> findAll();
}
