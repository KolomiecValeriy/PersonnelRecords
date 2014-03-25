package allClasses;

import db.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeList {

	ArrayList<AbstractEmployees> emploeeList = new ArrayList<AbstractEmployees>();

	String sql = "SELECT e.name, e.surname, e.address, e.phone, e.date, t.typeSalary as typeSalary, e.typeSalary, e.salary FROM employees e "
			+ "INNER JOIN typeSalary t on e.typeSalary = t.id ";
	String sort_option = null;
	int sort = 0;

	public EmployeeList() {
	}

	public EmployeeList(String sort_option, int sort) {
		this.sort_option = sort_option;
		this.sort = sort;
	}

	private ArrayList<AbstractEmployees> getEmployees() {

		Connection conn = null;
		Statement stmt = null;
		ResultSet res = null;

		if (this.sort_option != null) {
			this.sql += "ORDER BY " + this.sort_option;
			if (this.sort == 1) {
				this.sql += " DESC";
			}
		}

		try {
			conn = Database.getConnection();
			stmt = conn.createStatement();
			res = stmt.executeQuery(sql);
			int cnt = 1;
			while (res.next()) {
				AbstractEmployees employee;

				employee = getEmployee(res);

				employee.setId(cnt++);
				employee.setName(res.getString("name"));
				employee.setSurname(res.getString("surname"));
				employee.setAddress(res.getString("address"));
				employee.setPhone(res.getString("phone"));
				employee.setDate(res.getString("date"));
				employee.setTypeSalary(res.getString("t.typeSalary"));
				employee.setSalary(new Float(res.getString("salary")));

				emploeeList.add(employee);
			}
		} catch (SQLException ex) {
			Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
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
		return emploeeList;

	}

	public AbstractEmployees getEmployee(ResultSet res) {

		int type = 0;
		AbstractEmployees employee = null;
		try {
			type = res.getInt("e.typeSalary");
		} catch (SQLException ex) {
			Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
		}

		switch (type) {
			case 1:
				employee = new EmployeeHourlyWages();
				break;
			case 2:
				employee = new EmployeeFixedSalary();
				break;
		}
		return employee;

	}

	public ArrayList<AbstractEmployees> getEmployeeList() {
		if (!emploeeList.isEmpty()) {
			return emploeeList;
		} else {
			return getEmployees();
		}
	}

}
