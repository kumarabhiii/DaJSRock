package com.kumar.abhiii.hr.servlets;
import com.kumar.abhiii.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class ServletTwo extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
int code=Integer.parseInt(request.getParameter("code"));
PrintWriter pw=response.getWriter();
response.setContentType("text/plain");
DesignationDAO designationDAO=new DesignationDAO();
try
{
DesignationDTO designation=designationDAO.getByCode(code);
pw.print(designation.getCode()+","+designation.getTitle());
}catch(DAOException daoException)
{
pw.print("INVALID");
}
}catch(Exception e)
{
try
{
response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
}catch(Exception ee)
{
//do nothing.
}
}
}

public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
}catch(Exception e)
{
//do nothing.
}
}
}