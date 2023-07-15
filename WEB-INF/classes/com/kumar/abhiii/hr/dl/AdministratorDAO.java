package com.kumar.abhiii.hr.dl;
import java.sql.*;
public class AdministratorDAO
{
public AdministratorDTO getByUsername(String username) throws DAOException
{
try
{
if(username==null) 
{
throw new DAOException("Invalid username : "+username);
}
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement=connection.prepareStatement("select * from administrator where uname=?");
preparedStatement.setString(1,username);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid username : "+username);
}
AdministratorDTO administrator=new AdministratorDTO();
administrator.setUsername(resultSet.getString("uname").trim());
administrator.setPassword(resultSet.getString("pwd").trim());
resultSet.close();
preparedStatement.close();
connection.close();
return administrator;
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
}
}