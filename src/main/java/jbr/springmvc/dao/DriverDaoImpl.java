package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jbr.springmvc.model.Driver;


public class DriverDaoImpl implements DriverDao {
	
	 @Autowired
	  DataSource datasource;

	  @Autowired
	  JdbcTemplate jdbcTemplate;

	@Override
	public int driverRegister(Driver p) 
	{
		String sql="insert into driver_register(driverId,FirstName,LastName, DrivingLicense, MobileNo, EmailId, Address) values("
				  +p.getDriverid()+",'"+p.getFname()+"','"+p.getLname()+"',' "+p.getDlicence()+
				  "','"+p.getMobile()+"','"+p.getEmail()+"','"+p.getAddress()+"')";
				  
		return jdbcTemplate.update(sql);
	}

	@Override
	public Driver validateDriver(Driver driver) {
		System.out.println("Inside validate user");
		System.out.println(driver.getFname());
		System.out.println(driver.getDlicence());
		
	//String sql = "select * from driver_register where FirstName='"+driver.getFname()+"' and DrivingLicense="+driver.getDlicence()+"";
		String sql = "select * from driver_register where FirstName=? and DrivingLicense=?";
		
	    List<Driver> users = jdbcTemplate.query(sql, new DriverMapper());
	    System.out.println(users.size());
	    return users.size() > 0 ? users.get(0) : null;
		
	}
	  
	

}


class DriverMapper implements RowMapper<Driver> {

  public Driver mapRow(ResultSet rs, int arg1) throws SQLException {
	  
	  System.out.println("Driver mapper");
    Driver driver = new Driver();
    
    driver.setDriverid(rs.getInt("driverId"));
    driver.setFname(rs.getString("FirstName"));
    driver.setLname(rs.getString("LastName"));
    driver.setDlicence(rs.getString("DrivingLicense"));
    driver.setMobile(rs.getString("MobileNo"));
    driver.setEmail(rs.getString("EmailId"));
    driver.setAddress(rs.getString("Address"));
    
   
    return driver;
  }
}