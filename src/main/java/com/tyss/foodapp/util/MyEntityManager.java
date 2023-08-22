package com.tyss.foodapp.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MyEntityManager {

	private MyEntityManager() {
	};

	public static EntityManager manager;

	public static EntityManager getEntityManager() {

		if (manager == null) {
			manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
			return manager;
		}

		return manager;
	}
}
