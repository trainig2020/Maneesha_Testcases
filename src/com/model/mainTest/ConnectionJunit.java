package com.model.mainTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.model.dao.connectionFactory;

public class ConnectionJunit {

	@Test
	public void testDaoConnection(){
		assertNotNull(connectionFactory.getConnection());
	}
}

