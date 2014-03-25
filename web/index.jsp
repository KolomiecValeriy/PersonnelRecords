<%@page import="java.io.PrintWriter"%>
<%@page import="allClasses.AbstractEmployees"%>
<%@page import="allClasses.EmployeeFixedSalary"%>
<%@page import="allClasses.EmployeeList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/jspf/header.jspf" %>

<div class="menu">
	<h2>Employees</h2>
	<hr>
	<div class="menuItem" id="addEmployee">
		<a href="pages/addEmployee.jsp">Add employee</a>		
	</div>

	<div class="menuItem" id="sortEmployee">					
		<form action="index.jsp" method="GET">
			<span>sort by: </span>
			<select name="sort_option">
				<option disabled selected> select field</option>
				<option value="surname">surname</option>
				<option value="address">address</option>
				<option value="date">day of birth</option>
				<option value="e.typeSalary">type of salary</option>
				<option value="salary">salary</option>
			</select>

			Desc: <input type="checkbox" name="desc" value="1">
			<input type="submit" width="20" value="OK">
		</form>
	</div>			
</div> <!--menu-->

<div class="tableEmplayees">

	<table border="1" bordercolor="#CCCCCC" cellspacing="0">
		<tr>
			<th>№</th>
			<th>Full name</th>
			<th>Address</th>
			<th>Phone</th>
			<th>Day of birth</th>
			<th>Type of salary</th>
			<th>Salary</th>
			<th>Avaradge salary</th>
		</tr>
		<%
			String sort_option = request.getParameter("sort_option");

			int sort = 0;
			try {
				if (request.getParameter("desc").equals("1")) {
					sort = 1;
				}
			} catch (Exception ex) {
			}

			EmployeeList employeeList = new EmployeeList(sort_option, sort);
			for (AbstractEmployees employee : employeeList.getEmployeeList()) {
		%>
		<tr>
			<td class="id"><%=employee.getId()%></td>
			<td><%=employee.getSurname() + " " + employee.getName()%></td>
			<td><%=employee.getAddress()%></td>
			<td><%=employee.getPhone()%></td>
			<td><%=employee.getDate()%></td>
			<td><%=employee.getTypeSalary()%></td>
			<td><%=employee.getSalary()%></td>
			<td><%=employee.calculatingWage()%></td>
		</tr>
		<%	}%>

	</table>

</div><!--tableEmplayees-->		


<%@include file="WEB-INF/jspf/footer.jspf" %>