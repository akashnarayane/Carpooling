package jbr.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jbr.springmvc.dao.DriverDao;

import jbr.springmvc.model.Driver;


@Service
public class DriverServiceImpl implements DriverService{
	
	
	@Autowired
	  public DriverDao driverDao;

	@Override
	public int driverRegister(Driver driver) {
		// TODO Auto-generated method stub
		return driverDao.driverRegister(driver);
	}

	@Override
	public Driver validateDriver(Driver driver) {
		
		
		return driverDao.validateDriver(driver);
	}

	/*
	 * public int driverRegister(Driver driver) { return
	 * driverDao.driverRegister(driver); }
	 */	

}
