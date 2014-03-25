package allClasses;

import db.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TypeSalaryList {

	ArrayList<TypeSalary> salaryList = new ArrayList<TypeSalary>();

	private ArrayList<TypeSalary> getSalary() {
		Connection conn;
		Statement stmt = null;
		ResultSet res = null;

		try {
			conn = Database.getConnection();
			
			stmt = conn.createStatement();
			res = stmt.executeQuery("SELECT id, typeSalary FROM typeSalary");

			while (res.next()) {
				TypeSalary salary = new TypeSalary();
				salary.setId(res.getInt("id"));
				salary.setTypeSalary(res.getString("typeSalary"));
				
				salaryList.add(salary);
			}

		} catch (SQLException ex) {
			Logger.getLogger(TypeSalaryList.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				if (res != null) {
					res.close();
				}
				if (stmt != null) {
					stmt.close();
				}
//				if(conn!=null) {
//					conn.close();
//				}
			} catch (SQLException ex) {
				Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return salaryList;
	}

	public ArrayList<TypeSalary> getSalaryList() {
		if (!salaryList.isEmpty()) {
			return salaryList;
		} else {
			return getSalary();
		}
	}

}
