package jdbcConnectionProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnectorClass {
	
	public static void main (String args[]) {
		
		//COnnection Details
		
		String db_url="jdbc:mysql://localhost:3306";
		String username = "root";
		String password = "2025";
		
		//Establish Connection
		
		try {
			Connection connection = DriverManager.getConnection(db_url, username, password);
			
			String createDB = "create database jdbcEmp1";
			String useDB = "use jdbcEmp1";
			String createTable = "create Table EmpDetails(empcode int, empname varchar(20), empage int, esalary int)";
			String insertValue1 = "insert into EmpDetails values(101,'Jenny',25,10000)";
			String insertValue2 = "insert into EmpDetails values(102,'Jacky',30,20000)";
			String insertValue3 = "insert into EmpDetails values(103,'Joe',20,40000)";
			String insertValue4 = "insert into EmpDetails values(104,'John',40,80000)";
			String insertValue5 = "insert into EmpDetails values(105,'Shameer',25,90000)";
			String select = "Select * from EmpDetails";
			
			Statement smt = connection.createStatement();
			
			//Step4: Execute the statements
			
			smt.execute(createDB);
			smt.execute(useDB);
			smt.execute(createTable);
			smt.executeUpdate(insertValue1);
			smt.executeUpdate(insertValue2);
			smt.executeUpdate(insertValue3);
			smt.executeUpdate(insertValue4);
			smt.executeUpdate(insertValue5);
			
			ResultSet result = smt.executeQuery(select);
			
			while(result.next()) {
				System.out.println(result.getInt("empcode")+ " --> " +result.getString("empname") + " --> "+result.getInt("empage")+ " --> "+result.getInt("esalary"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
