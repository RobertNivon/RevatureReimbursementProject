package web;

import com.entity.Employee;
import com.repository.EmployeeRepository;
import com.repository.JdbcEmployeeRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/view-all-employees"})
public class ViewAllEmployeesControllerServlet extends HttpServlet {

    EmployeeRepository employeeRepository = new JdbcEmployeeRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        System.out.println(session.isNew());
        System.out.println(session.getId());
        System.out.println(new Date(session.getCreationTime()));
        System.out.println(new Date(session.getLastAccessedTime()));

        String currentUser = (String) session.getAttribute("current-user");
        System.out.println(currentUser);

        if (currentUser != null) {
            List<Employee> allEmployees = employeeRepository.findAllEmployees();
            req.setAttribute("all-employees-list", allEmployees);
            req.getRequestDispatcher("all-employees.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.html");
        }
    }
}
