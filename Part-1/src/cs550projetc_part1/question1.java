package cs550projetc_part1;

import java.sql.*;

public class question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c= DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu","spallemp","vortetoa");
			 String query="select mgrssn from department where mgrssn=?";
		      PreparedStatement stmt= c.prepareStatement(query);
		     
		      stmt.setString(1, ssn);
		      ResultSet rs=stmt.executeQuery();
		      if(rs.next()) 
				{
					rs="Yes";
				}

		      System.out.println("Got it!");
			/*Statement st = c.createStatement();
			ResultSet re = st.executeQuery("select distinct e.lname, e.ssn from employee e, department d where d.dname = 'Research' and d.dnumber = e.dno");
		
					while (re.next()) 
					{
						System.out.println(re.getString(1) + " " + "," + " "+ re.getString(2));
					}

					// Closing the connection
					 * 
					 */
					c.close();
				} 
				catch (Exception e) 
				{
					System.out.println(e);
				}
		
			}
}

