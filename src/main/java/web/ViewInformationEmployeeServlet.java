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
import java.util.Optional;

@WebServlet(urlPatterns = {"/view-information-employee", "/update-information-employee"})
public class ViewInformationEmployeeServlet extends HttpServlet {

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
            Optional<Employee> employee = employeeRepository.findByEmpUsername(currentUser);
            req.setAttribute("employee-info", employee);
            req.getRequestDispatcher("employee-view-information.jsp").forward(req, resp);
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

        String currentUser = (String) session.getAttribute("current-user");
        int employeeId = (int) session.getAttribute("employee-id");
        Optional<Employee> employee = employeeRepository.findByEmpId(employeeId);

        employee.get().setName(name);
        employee.get().setPhoneNumber(phoneNumber);
        employee.get().setAddress(address);

        employeeRepository.updateByEmpId(employee);

        if (currentUser != null) {
            resp.sendRedirect("employeeHome.jsp");
        }
        else {
            resp.sendRedirect("index.html");
        }
    }
}
