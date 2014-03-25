package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import allClasses.AbstractEmployees;
import allClasses.AddEmployees;
import allClasses.TypeSalary;
import allClasses.TypeSalaryList;

public final class addEmployee_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/pages/../WEB-INF/jspf/header.jspf");
    _jspx_dependants.add("/pages/../WEB-INF/jspf/footer.jspf");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("<link href=\"../css/style.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("<title>Personel records</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\t<div id=\"container\">\n");
      out.write("    \t<div id=\"head\">\n");
      out.write("\t\t    <h1>Personnel records of company</h1>\n");
      out.write("\t\t<!-- /head -->\n");
      out.write("\t\t</div>\n");
      out.write("        <div id=\"content\">");
      out.write('\n');
      out.write('\n');

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


      out.write("\n");
      out.write("\n");
      out.write("<div id=\"newEmployee\">\n");
      out.write("\t<h2>New employee</h2>\n");
      out.write("\t<hr>\n");
      out.write("\t<div class=\"menuItem\" id=\"back\">\n");
      out.write("\t\t<a href=\"../\">Back</a>\t\t\n");
      out.write("\t</div>\n");
      out.write("\t<div id=\"form\">\n");
      out.write("\t\t<form action=\"addEmployee.jsp\" method=\"POST\">\n");
      out.write("\n");
      out.write("\t\t\t<label>Name: <input type=\"text\" size=\"30\" name=\"name\"></label><br>\n");
      out.write("\t\t\t<label>Surname: <input type=\"text\" size=\"30\" name=\"surname\"></label><br>\n");
      out.write("\t\t\t<label>Address: <input type=\"text\" size=\"30\" name=\"address\"></label><br>\n");
      out.write("\t\t\t<label>Phone: <input type=\"text\" size=\"30\" name=\"phone\"></label><br>\n");
      out.write("\t\t\tDate of birth <br>\n");
      out.write("\t\t\t<label>Year: <input type=\"text\" size=\"4\" name=\"year\"></label>\n");
      out.write("\t\t\t<label>Month: <input type=\"text\" size=\"2\" name=\"month\"></label>\n");
      out.write("\t\t\t<label>Day: <input type=\"text\" size=\"2\" name=\"day\"><br></label>\n");
      out.write("\t\t\tType salary: \n");
      out.write("\t\t\t<select name=\"salary_type\">\n");
      out.write("\t\t\t\t<option selected disabled>select salary type</option>\n");
      out.write("\t\t\t\t");
					TypeSalaryList salaryList = new TypeSalaryList();
					for (TypeSalary salary : salaryList.getSalaryList()) {
				
      out.write("\n");
      out.write("\t\t\t\t<option value=\"");
      out.print(salary.getId());
      out.write('"');
      out.write('>');
      out.print(salary.getTypeSalary());
      out.write("</option>\n");
      out.write("\t\t\t\t");
	}
      out.write("\n");
      out.write("\t\t\t</select>\n");
      out.write("\t\t\t<br>\n");
      out.write("\t\t\t<label>Salary: <input type=\"text\" size=\"30\" name=\"salary\"></label><br>\n");
      out.write("\t\t\t<input class=\"btn\" type=\"submit\" value=\"Add\">\n");
      out.write("\n");
      out.write("\t\t</form>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t    </div> <!--content-->\n");
      out.write("\t</div> <!-- /container -->\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
