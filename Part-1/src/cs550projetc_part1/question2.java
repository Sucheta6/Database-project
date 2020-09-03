package cs550projetc_part1;

import java.sql.*;

public class question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c= DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu","spallemp","vortetoa");
			Statement st = c.createStatement();
			ResultSet re = st.executeQuery("select e.lname, e.ssn, w.hours from employee e, project p, works_on w where e.ssn=w.essn and w.pno=p.pnumber and e.dno=p.dnum and  plocation='Houston' and pname='ProductZ'");
		
					while (re.next()) 
					{
						System.out.println(re.getString(1) + "," + re.getString(2)+ "," + re.getString(3));
					}

					// Closing the connection
					c.close();
				} 
				catch (Exception e) 
				{
					System.out.println(e);
				}
		
			}
}


