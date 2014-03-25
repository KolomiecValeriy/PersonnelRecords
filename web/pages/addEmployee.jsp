<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="allClasses.AbstractEmployees"%>
<%@page import="allClasses.AddEmployees"%>
<%@page import="allClasses.TypeSalary"%>
<%@page import="allClasses.TypeSalaryList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../WEB-INF/jspf/header.jspf" %>

<%
	if (request.getMethod().equals("POST")) {
		ArrayList<AddEmployees> employeesList = new ArrayList<AddEmployees>();
//	?name=1&surname=2&address=3&year=0000&month=00&day=00&salary_type=2&salary=5

		AddEmployees employee = new AddEmployees();
		try {
			employee.setName(request.getParameter("name"));
			employee.setSurname(request.getParameter("surname"));
			employee.setAddress(request.getParameter("address"));
			employee.setPhone(request.getParameter("phone"));
			employee.setDate(request.getParameter("year") + "-" + request.getParameter("month") + "-" + request.getParameter("day"));
			employee.setTypeSalary(request.getParameter("salary_type"));
			employee.setSalary(Float.parseFloat(request.getParameter("salary")));

			employeesList.add(employee);
			AddEmployees.addToDb(employeesList);
			response.sendRedirect("../");
		} catch (Exception ex) {
			PrintWriter print = new PrintWriter(out);
			print.print("<h3 style='color:red'>You entered don't all data into form!</h3>");
		}

	}

//					response.sendRedirect("../index.jsp");

%>

<div id="newEmployee">
	<h2>New employee</h2>
	<hr>
	<div class="menuItem" id="back">
		<a href="../">Back</a>		
	</div>
	<div id="form">
		<form action="addEmployee.jsp" method="POST">

			<label>Name: <input type="text" size="30" name="name"></label><br>
			<label>Surname: <input type="text" size="30" name="surname"></label><br>
			<label>Address: <input type="text" size="30" name="address"></label><br>
			<label>Phone: <input type="text" size="30" name="phone"></label><br>
			Date of birth <br>
			<label>Year: <input type="text" size="4" name="year"></label>
			<label>Month: <input type="text" size="2" name="month"></label>
			<label>Day: <input type="text" size="2" name="day"><br></label>
			Type salary: 
			<select name="salary_type">
				<option selected disabled>select salary type</option>
				<%					TypeSalaryList salaryList = new TypeSalaryList();
					for (TypeSalary salary : salaryList.getSalaryList()) {
				%>
				<option value="<%=salary.getId()%>"><%=salary.getTypeSalary()%></option>
				<%	}%>
			</select>
			<br>
			<label>Salary: <input type="text" size="30" name="salary"></label><br>
			<input class="btn" type="submit" value="Add">

		</form>
	</div>
</div>


<%@include file="../WEB-INF/jspf/footer.jspf" %>