package jbr.springmvc.dao;

import jbr.springmvc.model.Driver;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;


public interface DriverDao {
	
	int driverRegister(Driver driver);

	Driver validateDriver(Driver driver);	
	
}
