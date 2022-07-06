package web;

import com.entity.Employee;
import com.entity.Reimbursement;
import com.repository.EmployeeRepository;
import com.repository.JdbcEmployeeRepository;
import com.repository.JdbcReimbursementRepository;
import com.repository.ReimbursementRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = {"/submit-reimbursement", "/submit-reimbursement-button"})
public class SubmitReimbursementControllerServlet extends HttpServlet {

    ReimbursementRepository reimbursementRepository = new JdbcReimbursementRepository();
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
            req.getRequestDispatcher("submitReimbursement.jsp").forward(req, resp);
        }
        else {
            resp.sendRedirect("index.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String total = req.getParameter("total");

        int employeeId = (int) session.getAttribute("employee-id");
        String currentUser = (String) session.getAttribute("current-user");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setEmpId(employeeId);
        reimbursement.setTitle(title);
        reimbursement.setDescription(description);
        reimbursement.setTotal(Double.parseDouble(total));
        reimbursement.setState(Reimbursement.reimbursement_state.PENDING);

        reimbursementRepository.submitReimbursement(reimbursement);

        if (currentUser != null) {
            resp.sendRedirect("employeeHome.jsp");
        }
        else {
            resp.sendRedirect("index.html");
        }
    }
}
