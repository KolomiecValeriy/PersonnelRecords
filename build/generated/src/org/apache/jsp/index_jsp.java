package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import allClasses.AbstractEmployees;
import allClasses.EmployeeFixedSalary;
import allClasses.EmployeeList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/WEB-INF/jspf/header.jspf");
    _jspx_dependants.add("/WEB-INF/jspf/footer.jspf");
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
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"menu\">\n");
      out.write("\t<h2>Employees</h2>\n");
      out.write("\t<hr>\n");
      out.write("\t<div class=\"menuItem\" id=\"addEmployee\">\n");
      out.write("\t\t<a href=\"pages/addEmployee.jsp\">Add employee</a>\t\t\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div class=\"menuItem\" id=\"sortEmployee\">\t\t\t\t\t\n");
      out.write("\t\t<form action=\"index.jsp\" method=\"GET\">\n");
      out.write("\t\t\t<span>sort by: </span>\n");
      out.write("\t\t\t<select name=\"sort_option\">\n");
      out.write("\t\t\t\t<option disabled selected> select field</option>\n");
      out.write("\t\t\t\t<option value=\"surname\">surname</option>\n");
      out.write("\t\t\t\t<option value=\"address\">address</option>\n");
      out.write("\t\t\t\t<option value=\"date\">day of birth</option>\n");
      out.write("\t\t\t\t<option value=\"e.typeSalary\">type of salary</option>\n");
      out.write("\t\t\t\t<option value=\"salary\">salary</option>\n");
      out.write("\t\t\t</select>\n");
      out.write("\n");
      out.write("\t\t\tDesc: <input type=\"checkbox\" name=\"desc\" value=\"1\">\n");
      out.write("\t\t\t<input type=\"submit\" width=\"20\" value=\"OK\">\n");
      out.write("\t\t</form>\n");
      out.write("\t</div>\t\t\t\n");
      out.write("</div> <!--menu-->\n");
      out.write("\n");
      out.write("<div class=\"tableEmplayees\">\n");
      out.write("\n");
      out.write("\t<table border=\"1\" bordercolor=\"#CCCCCC\" cellspacing=\"0\">\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<th>№</th>\n");
      out.write("\t\t\t<th>Full name</th>\n");
      out.write("\t\t\t<th>Address</th>\n");
      out.write("\t\t\t<th>Phone</th>\n");
      out.write("\t\t\t<th>Day of birth</th>\n");
      out.write("\t\t\t<th>Type of salary</th>\n");
      out.write("\t\t\t<th>Salary</th>\n");
      out.write("\t\t\t<th>Avaradge salary</th>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t");

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
		
      out.write("\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td class=\"id\">");
      out.print(employee.getId());
      out.write("</td>\n");
      out.write("\t\t\t<td>");
      out.print(employee.getSurname() + " " + employee.getName());
      out.write("</td>\n");
      out.write("\t\t\t<td>");
      out.print(employee.getAddress());
      out.write("</td>\n");
      out.write("\t\t\t<td>");
      out.print(employee.getPhone());
      out.write("</td>\n");
      out.write("\t\t\t<td>");
      out.print(employee.getDate());
      out.write("</td>\n");
      out.write("\t\t\t<td>");
      out.print(employee.getTypeSalary());
      out.write("</td>\n");
      out.write("\t\t\t<td>");
      out.print(employee.getSalary());
      out.write("</td>\n");
      out.write("\t\t\t<td>");
      out.print(employee.calculatingWage());
      out.write("</td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t");
	}
      out.write("\n");
      out.write("\n");
      out.write("\t</table>\n");
      out.write("\n");
      out.write("</div><!--tableEmplayees-->\t\t\n");
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
