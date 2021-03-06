/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-06-22 04:38:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.entity.Employee;
import java.util.Optional;

public final class manager_002dview_002dinformation_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Employee Information</title>\r\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n");
      out.write("          integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\r\n");
      out.write("    <link rel=\"icon\" type=\"image/x-icon\" href=\"icons8-money-box-48.png\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"employeeInfo.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"container rounded bg-white mt-5 mb-5\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-5 border-right\">\r\n");
      out.write("                <div class=\"d-flex flex-column align-items-center text-center p-3 py-5\"><img class=\"rounded-circle mt-5\" width=\"250px\" src=\"businessman1.png\" />\r\n");
      out.write("                    ");
Optional<Employee> employee = (Optional<Employee>) request.getAttribute("employee-info");
                    
      out.write("\r\n");
      out.write("                    <span>");
      out.print(employee.get().getName());
      out.write("</span>\r\n");
      out.write("                    <span>");
      out.print(employee.get().getEmail());
      out.write("</span>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-5 border-right\">\r\n");
      out.write("                <div class=\"p-3 py-5\">\r\n");
      out.write("                    <div class=\"d-flex justify-content-between align-items-center mb-3\">\r\n");
      out.write("                        <h2 class=\"text-right\">My Information</h2>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row mt-3\">\r\n");
      out.write("                        <form action=\"update-information-manager\" method=\"post\">\r\n");
      out.write("                            <div class=\"col-md-12\"><span class=\"information\">Name</span>\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" placeholder=\"Name\" name=\"name\" value=\"");
      out.print(employee.get().getName());
      out.write("\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-md-12\"><span class=\"information\">Phone Number</span>\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" placeholder=\"Phone Number\" name=\"phoneNumber\" value=\"");
      out.print(employee.get().getPhoneNumber());
      out.write("\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-md-12\"><span class=\"information\">Address</span>\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" placeholder=\"Address\" name=\"address\" value=\"");
      out.print(employee.get().getAddress());
      out.write("\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"mt-3 text-center\">\r\n");
      out.write("                                <input class=\"btn btn-primary profile-button\" type=\"submit\" value=\"Update Information\" id=\"submit-button\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</body>");
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
