package com.tyss.foodapp.service;

import java.util.List;

import com.tyss.foodapp.dto.Branch;
import com.tyss.foodapp.dto.User;

public interface BranchService {
	Branch saveBranch(Branch branch);

	Branch updateBranch(Branch branch);

	Branch findBranchById(int id);

	boolean deleteBranchById(int id);
	
	Branch findBranchByName(String branchName);

	Object findBranchManagerByBranchId(int id);
	
	List<Branch> findAllBranchs();
}
