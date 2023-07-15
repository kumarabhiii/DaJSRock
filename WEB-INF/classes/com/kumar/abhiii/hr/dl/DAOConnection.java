package com.kumar.abhiii.hr.dl;
import com.kumar.abhiii.hr.dl.*;
import java.sql.*;
public class DAOConnection
{
private DAOConnection(){}
static public Connection getConnection() throws DAOException
{
Connection connection=null;
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/tmdb","tmdbuser","tmdbuser");
}catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
return connection;
}
}