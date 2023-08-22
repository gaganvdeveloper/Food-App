package com.tyss.foodapp.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FoodAppEntityManager {
	public static EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	public static EntityTransaction transaction = manager.getTransaction();
	
}
