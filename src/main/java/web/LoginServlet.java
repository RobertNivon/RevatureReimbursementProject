package web;

import com.entity.Employee;
import com.repository.EmployeeRepository;
import com.repository.JdbcEmployeeRepository;
import com.service.AuthenticationService;
import com.service.AuthenticationServiceImplementation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;


@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    EmployeeRepository employeeRepository = new JdbcEmployeeRepository();
    AuthenticationService authenticationService = new AuthenticationServiceImplementation(employeeRepository);

//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String userName = req.getParameter("username");
//        String message = "hello " + userName;
//
//        resp.setContentType("text/html");
//
//        PrintWriter out = resp.getWriter();
//        out.println("<html>");
//        out.println("<head><title>Hello response</title></head>");
//        out.println("<body>");
//        out.println(message);
//        out.println("</body>");
//        out.println("</html>");
//        out.close();
//    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Optional<Employee> employee = employeeRepository.findByEmpUsername(username);

        boolean bool = authenticationService.authenticate(username, password);
        if (!bool) {
//            if (req.getSession().getAttribute("is_manager")=="false") {
//                resp.sendRedirect("employeeHome.html");
//            }
//            else {
//                resp.sendRedirect("managerHome.html");
//            }
            resp.sendRedirect("index.html");
        }
        else {
            if (employee.get().isManager()) {
                HttpSession session = req.getSession();

                System.out.println(session.isNew());
                System.out.println(session.getId());
                System.out.println(new Date(session.getCreationTime()));
                System.out.println(new Date(session.getLastAccessedTime()));

                session.setAttribute("current-user", username);
                session.setAttribute("employee-id", employee.get().getEmpId());
                resp.sendRedirect("managerHome.jsp");
            }
            else {
                HttpSession session = req.getSession();

                System.out.println(session.isNew());
                System.out.println(session.getId());
                System.out.println(new Date(session.getCreationTime()));
                System.out.println(new Date(session.getLastAccessedTime()));

                session.setAttribute("current-user", username);
                session.setAttribute("employee-id", employee.get().getEmpId());
                resp.sendRedirect("employeeHome.jsp");
            }
        }
    }
}
