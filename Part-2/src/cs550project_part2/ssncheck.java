package cs550project_part2;

import java.util.*;
import java.sql.Date;
import java.text.SimpleDateFormat;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;
public class ssncheck {
	public String manager_check(String ssn) {
		String res="False";
		// Connection conn = null;
		    try {
		    	Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c= DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu","spallemp","vortetoa");
		      
		      String query="select mgrssn from department where mgrssn=?";
		      PreparedStatement stmt= c.prepareStatement(query);
		     
		      stmt.setString(1, ssn);
		      ResultSet rs=stmt.executeQuery();
		      if(rs.next()) 
				{
					res="Yes";
				}

		      System.out.println("Got it!");
		     c.close();
		    } catch (Exception e) {
		        throw new Error("Problem", e);
		    } finally {
		    	 
		      
		    }
		return(res);
	}
	public String insert_employee(String fname, String minit, String lname, String ssn,String bdate, String address, String sex,String  salary, String superssn, String dno, String email ) {
		String res="False";
		Connection c = null;
		 try {
		    	Class.forName("oracle.jdbc.driver.OracleDriver");
				 c= DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu","spallemp","vortetoa");
		      
		      String query="INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		      PreparedStatement stmt= c.prepareStatement(query);
		      Date date2=Date.valueOf(bdate);
		      if(sex.equalsIgnoreCase("male")) {
		    	  sex="M";
		      }
		      else {
		    	  sex="F";
		      }
		     // DateFormat formatter2=new SimpleDateFormat("yyyy-MM-dd"); 
		      //Date date2=  formatter2.parse(bdate); 
		      stmt.setString(1, fname);
		      stmt.setString(2, minit);
		      stmt.setString(3, lname);
		      stmt.setString(4, ssn);
		      stmt.setDate(5, date2);
		      stmt.setString(6, address);
		      stmt.setString(7, sex);
		      stmt.setString(8, salary);
		      stmt.setString(9, superssn);
		      stmt.setString(10, dno);
		      stmt.setString(11, email);
		     		      
		      
		      ResultSet rs=stmt.executeQuery();
		      if(rs.next()) 
				{
					res="Yes";
				}

		      System.out.println("Got it!");
		    
		    } catch (Exception e) {
		        throw new Error("Problem", e);
		    } finally {
		    	 try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      
		    }
		return res;
		
	}
	public String Projname(List l1,List l2, String ssn) {
		String res="False";
		Connection c = null;
		 try {
		    	Class.forName("oracle.jdbc.driver.OracleDriver");
				 c= DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu","spallemp","vortetoa");
				 String query="INSERT INTO works_on VALUES (?,?,?)";
				 PreparedStatement stmt= c.prepareStatement(query);
				 String qry="select pnumber from project where pname=?";
				 PreparedStatement st1=c.prepareStatement(qry);
				 double sumhrs=0;
				 for (int i = 0; i < l1.size(); i++) {
					 stmt.setString(1, ssn);
					 st1.setString(1, l1.get(i).toString());;
						ResultSet re = st1.executeQuery();
						String pno="";
								while (re.next()) 
								{
								                pno=re.getString(1) ;
								}
					 stmt.setInt(2,Integer.parseInt(pno));
				     stmt.setDouble(3, Double.parseDouble(l2.get(i).toString())); 
				     sumhrs=sumhrs+Integer.parseInt(l2.get(i).toString());
				     if(sumhrs>40) {
				    	 return("assigned more than 40  hrs of work");
				     }
				     ResultSet rs=stmt.executeQuery();
				      if(rs.next()) 
						{
							res="True";
						}
				 }
		     
		      System.out.println("Got it!");
		    
		    } catch (Exception e) {
		        throw new Error("Problem", e);
		    } finally {
		    	 try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      
		    }
		
		return res;
	}
	public String inser_depend(String ssnid,String dname, String sex, String bdt,String relationship ) {
		String res="False";
		Connection c = null;
		 try {
		    	Class.forName("oracle.jdbc.driver.OracleDriver");
				 c= DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu","spallemp","vortetoa");
		      
		      String query="INSERT INTO dependent VALUES (?,?,?,?,?)";
		      PreparedStatement stmt= c.prepareStatement(query);
		      Date date2=Date.valueOf(bdt);
		      if(sex.equalsIgnoreCase("male")) {
		    	  sex="M";
		      }
		      else {
		    	  sex="F";
		      }
		     // DateFormat formatter2=new SimpleDateFormat("yyyy-MM-dd"); 
		      //Date date2=  formatter2.parse(bdate); 
		      stmt.setString(1, ssnid);
		      stmt.setString(2, dname);
		      stmt.setString(3, sex);
		      stmt.setDate(4, date2);
		      stmt.setString(5, relationship);
		      
		      
		      ResultSet rs=stmt.executeQuery();
		      if(rs.next()) 
				{
					res="Yes";
				}

		      System.out.println("Got it!");
		    
		    } catch (Exception e) {
		        throw new Error("Problem", e);
		    } finally {
		    	 try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      
		    }
		return res;
		
	}
	
		public List report_employee(String ssn) {
			String res="False";
			// Connection conn = null;
			Connection c=null;
			List<String> al=new ArrayList<String>(); 
			    try {
			    	Class.forName("oracle.jdbc.driver.OracleDriver");
					 c= DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu","spallemp","vortetoa");
			      
			      String query="select fname,lname,ssn,bdate,address,sex,salary,superssn,email  from employee where ssn=?";
			      PreparedStatement stmt= c.prepareStatement(query);
			     
			      stmt.setString(1, ssn);
			      ResultSet rs=stmt.executeQuery();
			      
			      if(rs.next()) 
					{
			    	    al.add(rs.getString(1));
			    	    al.add(rs.getString(2));
			    	    al.add(rs.getString(3));
			    	    al.add(rs.getString(4));
			    	    al.add(rs.getString(5));
			    	    al.add(rs.getString(6));
			    	    al.add(rs.getString(7));
			    	    al.add(rs.getString(8));
			    	    al.add(rs.getString(9));
			    	   
					}

			      System.out.println("Got it!");
			      c.close();
			     
			    } catch (Exception e) {
			        throw new Error("Problem", e);
			    } finally {
			    
			      
			    }
			return(al);
		}
/*
	public static void main(String[] args)  throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
	            // Initialize the database 
            Connection con;
			con = Conne
            Statement stmt=con.createStatement();   
            ResultSet rs=stmt.executeQuery("select * from department where mgrssn = '" + ssn + "'");
            if(rs.next())  {
            	System.out.println(rs.getString("DNAME")); 
            }
            else {
                System.out.println("Sorry, could not find a manager with that ssn. ");
            }
            con.close();  
            }
	public void Project(List<Integer> projectNumber, List<Integer> workinghours) throws SQLException, ClassNotFoundException {
		// Initialize the database 
		int sum=0;
		int index=0;
        Connection con;
		con = DatabaseConnection.initializeDatabase();
        Statement stmt=con.createStatement();  
        for (int i : projectNumber)  {
        	ResultSet rs=stmt.executeQuery("select * from project where pnumber = '" + i + "'");
        	if(rs.next())  {
            	Integer number=rs.getInt("PNUMBER"); 
            	System.out.println("Allocated project number is: "+number);
            			int j=index++;
            			sum = sum+workinghours.get(j);
            			if(sum>=40) {
            				System.out.println("Sorry, employee working hours exceeding 40. ");
            			}else {
            				System.out.println("Total Working hours: "+sum);
            			}
        }else {
    		System.out.println("Sorry, project "+i+" does not exist.");
    	}
        
        }
        con.close();  
	}
	*/
}
