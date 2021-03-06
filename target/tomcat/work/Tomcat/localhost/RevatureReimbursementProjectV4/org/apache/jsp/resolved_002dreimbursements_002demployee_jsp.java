/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-06-22 04:34:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.entity.Reimbursement;
import com.entity.Employee;
import java.util.List;
import java.util.Optional;
import com.repository.EmployeeRepository;
import com.repository.JdbcEmployeeRepository;

public final class resolved_002dreimbursements_002demployee_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("  <title>Employee Homepage</title>\r\n");
      out.write("  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n");
      out.write("        integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\r\n");
      out.write("  <link rel=\"icon\" type=\"image/x-icon\" href=\"icons8-money-box-48.png\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"employeeHome.css\" />\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <nav class=\"navbar sticky-top navbar-light bg-dark navbar-right\">\r\n");
      out.write("      <button class=\"btn\" id=\"sidebar-toggle\"><i class=\"fa fa-bars\"></i> Menu</button>\r\n");
      out.write("\r\n");
      out.write("      <li class=\"nav-item dropdown dropdown-menu-end\">\r\n");
      out.write("        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" data-toggle=\"dropdown\" aria-hashpopup=\"true\" aria-expanded=\"false\"><img src=\"businessman.png\" alt=\"Avatar\" class=\"avatar\">\r\n");
      out.write("          Settings\r\n");
      out.write("        </a>\r\n");
      out.write("        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\r\n");
      out.write("          <a class=\"dropdown-item\" href=\"view-information-employee\">My Information</a>\r\n");
      out.write("          <a class=\"dropdown-item\" href=\"logout\">Logout</a>\r\n");
      out.write("        </div>\r\n");
      out.write("      </li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </nav>\r\n");
      out.write("\r\n");
      out.write("    <div id=\"sidebar-container\">\r\n");
      out.write("      <div id=\"sidebar\">\r\n");
      out.write("            ");

                 EmployeeRepository employeeRepository = new JdbcEmployeeRepository();
                 String currentUser = (String) session.getAttribute("current-user");
                 Optional<Employee> employee = employeeRepository.findByEmpUsername(currentUser);
            
      out.write("\r\n");
      out.write("        <h3 id=\"name\">Hello, ");
      out.print(employee.get().getName());
      out.write("</h3>\r\n");
      out.write("        <ul class=\"sidebar-items\">\r\n");
      out.write("          <li><a href=\"pending-reimbursements\" class=\"sidebar-item\">My Pending Reimbursements</a></li>\r\n");
      out.write("          <li><a href=\"resolved-reimbursements\" class=\"sidebar-item\">My Resolved Reimbursements</a></li>\r\n");
      out.write("          <li><a href=\"submit-reimbursement\" class=\"sidebar-item\">Submit a Reimbursement</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div id=\"website-content m-0\">\r\n");
      out.write("      <div class=\"container-fluid\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("          <div class=\"col-lg-12\">\r\n");
      out.write("            ");

                List<Reimbursement> reimbursements = (List<Reimbursement>) request.getAttribute("resolved-reimbursement-list");
                for (Reimbursement reimbursement : reimbursements) {
            
      out.write("\r\n");
      out.write("                <div class=\"card\" style=\"background : linear-gradient(315deg, #000000 0%, #7f8c8d 90%);\" id=\"my-card\">\r\n");
      out.write("                    <img src=\"businessan.png\" class=\"card-img-top\" alt=\"...\">\r\n");
      out.write("                    <div class=\"card-body\">\r\n");
      out.write("                        <h5 class=\"card-title \" style=\"color : white\">Title: ");
      out.print(reimbursement.getTitle());
      out.write("</h5>\r\n");
      out.write("                        <hr>\r\n");
      out.write("                        <p class=\"card-text\" style=\"color : white\">Description: ");
      out.print(reimbursement.getDescription());
      out.write("</p>\r\n");
      out.write("                        <p class=\"card-text\" style=\"color : white\">Total: $");
      out.print(reimbursement.getTotal());
      out.write("</p>\r\n");
      out.write("                        <p class=\"card-text\" style=\"color : white\">Status: ");
      out.print(reimbursement.getState());
      out.write("</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            ");

                }
            
      out.write("\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.14.6/dist/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.2.1/dist/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"employeeHome.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
