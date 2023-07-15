package com.kumar.abhiii.hr.dl;
public class AdministratorDTO implements java.io.Serializable,Comparable<AdministratorDTO>
{
private String username;
private String password;
public AdministratorDTO()
{
this.username="";
this.password="";
}
public void setUsername(String username)
{
this.username=username;
}
public String getUsername()
{
return this.username;
}
public void setPassword(String password)
{
this.password=password;
}
public String getPassword()
{
return this.password;
}
public int hashCode()
{
return username.hashCode();
}
//deep comparison
public boolean equals(Object object)
{
if(!(object instanceof AdministratorDTO)) return false;
AdministratorDTO administrator=(AdministratorDTO)object;
return this.username.equalsIgnoreCase(administrator.username);
}
//lecxical comparison
public int compareTo(AdministratorDTO administrator)
{
return this.username.compareTo(administrator.username);
}
}