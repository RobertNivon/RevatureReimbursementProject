package web;

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

@WebServlet(urlPatterns = {"/approve-reimbursement"})
public class ApproveReimbursementControllerServlet extends HttpServlet {

    ReimbursementRepository reimbursementRepository = new JdbcReimbursementRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        System.out.println(session.isNew());
        System.out.println(session.getId());
        System.out.println(new Date(session.getCreationTime()));
        System.out.println(new Date(session.getLastAccessedTime()));

        String currentUser = (String) session.getAttribute("current-user");
        System.out.println(currentUser);

        String id = req.getParameter("id");

        if (currentUser != null) {
            reimbursementRepository.approveReimbursement(Integer.parseInt(id));
            resp.sendRedirect("manager-pending-reimbursements");
        } else {
            resp.sendRedirect("index.html");
        }

    }
}
