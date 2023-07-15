package com.kumar.abhiii.hr.servlets;
import com.kumar.abhiii.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.google.gson.*;
public class ServletThree extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{

BufferedReader br=request.getReader();
StringBuffer sb=new StringBuffer();
String d;
while(true)
{
d=br.readLine();
if(d==null) break;
sb.append(d);
}
String rawData=sb.toString();
Gson gson=new Gson();
Customer c=gson.fromJson(rawData,Customer.class);
PrintWriter pw=response.getWriter();
response.setContentType("application.plain");
response.setCharacterEncoding("utf-8");
pw.print(gson.toJson(c));
pw.flush();
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

public void doGet(HttpServletRequest request,HttpServletResponse response)
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