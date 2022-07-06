package web;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.entity.Employee;
import com.entity.Reimbursement;
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
import java.util.Optional;

@WebServlet(urlPatterns = {"/register-user", "/register-user-button"})
public class RegisterUserControllerServlet extends HttpServlet {

    EmployeeRepository employeeRepository = new JdbcEmployeeRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        System.out.println(session.isNew());
        System.out.println(session.getId());
        System.out.println(new Date(session.getCreationTime()));
        System.out.println(new Date(session.getLastAccessedTime()));

        String currentUser = (String) session.getAttribute("current-user");

        if (currentUser != null) {
            req.getRequestDispatcher("registerUser.html").forward(req, resp);
        }
        else {
            resp.sendRedirect("index.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String name = req.getParameter("name");
        String phoneNumber = req.getParameter("phoneNumber");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        String currentUser = (String) session.getAttribute("current-user");

        Employee employee = new Employee();
        employee.setName(name);
        employee.setPhoneNumber(phoneNumber);
        employee.setAddress(address);
        employee.setEmail(email);
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        System.out.println(bcryptHashString);
        employee.setPassword(bcryptHashString);

        employeeRepository.saveEmployee(employee);

        if (currentUser != null) {
            resp.sendRedirect("managerHome.jsp");
        }
        else {
            resp.sendRedirect("index.html");
        }
    }
}
