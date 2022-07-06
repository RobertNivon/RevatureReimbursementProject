package web;

import com.entity.Reimbursement;
import com.repository.JdbcReimbursementRepository;
import com.repository.ReimbursementRepository;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/manager-resolved-reimbursements", "/resolved-sort"})
public class ResolvedReimbursementControllerManagerServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger("ers");

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

        if (currentUser != null) {
            List<Reimbursement> allResolvedReimbursements = reimbursementRepository.loadAllEmployeeResolvedReimbursements();
            req.setAttribute("all-resolved-reimbursement-list", allResolvedReimbursements);
            req.getRequestDispatcher("resolved-reimbursements-manager.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String search = req.getParameter("search");

        HttpSession session = req.getSession();
        System.out.println(session.isNew());
        System.out.println(session.getId());
        System.out.println(new Date(session.getCreationTime()));
        System.out.println(new Date(session.getLastAccessedTime()));

        String currentUser = (String) session.getAttribute("current-user");
        try {
            List<Reimbursement> resolvedReimbursements = reimbursementRepository.loadEmployeeResolvedReimbursements(Integer.parseInt(search));
            if (currentUser != null) {
                req.setAttribute("resolved-sort-employee", resolvedReimbursements);
                req.getRequestDispatcher("resolved-reimbursements-manager-sort.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("index.html");
            }
        }
        catch(NumberFormatException nfe) {
            LOG.error("illegal argument");
            resp.sendRedirect("manager-resolved-reimbursements");
        }

    }
}
