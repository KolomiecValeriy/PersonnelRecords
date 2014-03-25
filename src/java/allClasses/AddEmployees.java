package allClasses;

import java.util.ArrayList;
import java.sql.Connection;
import db.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddEmployees extends AbstractEmployees {

	private static String sql;

	public static void addToDb(ArrayList<AddEmployees> list) {

		ArrayList<AddEmployees> employees = list;

		for (AddEmployees emp : employees) {
			sql = "INSERT INTO employees (name, surname, address, phone, date, typeSalary, salary) "
					+ "values ('" + emp.getName() + "','" + emp.getSurname() + "', '" + emp.getAddress() + "', '" + emp.getPhone() + "', '"
					+ emp.getDate() + "', " + emp.getTypeSalary() + ", " + emp.getSalary() + ")";
		}

		try {
			Connection conn = Database.getConnection();
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
		} catch (SQLException ex) {
			Logger.getLogger(AddEmployees.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
	@Override
	public float calculatingWage() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
