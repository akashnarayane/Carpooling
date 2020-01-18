<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
       <h1>Add New Driver</h1>  
       <form:form method="post" modelAttribute="driver" action="registerProcess">    
        <table > 
         <tr>    
          <td>Driver Id : </td>   
          <td><form:input path="driverid"/></td>  
         </tr> 
           
         <tr>    
          <td>First Name : </td>   
          <td><form:input path="fname"/></td>  
         </tr>    
         <tr>    
          <td>Last Name :</td>    
          <td><form:input path="lname"/></td>  
         </tr>   
         <tr>    
          <td>Driving License :</td>    
          <td><form:input path="dlicence"/></td>  
         </tr>   
         <tr>    
         <tr>    
          <td>Mobile Number : </td>   
          <td><form:input path="mobile"/></td>  
         </tr>
         <tr>    
          <td>Email Id : </td>   
          <td><form:input path="email"/></td>  
         </tr> 
         <tr>    
          <td>Address : </td>   
          <td><form:input path="address"/></td>  
         </tr>     
          <tr>   
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    
</body>
</html>