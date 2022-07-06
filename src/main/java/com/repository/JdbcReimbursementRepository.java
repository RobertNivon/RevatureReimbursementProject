package com.repository;

import com.datasource.SQLConnectionFactory;
import com.entity.Employee;
import com.entity.Reimbursement;
import org.apache.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.entity.Reimbursement.reimbursement_state.APPROVED;
import static com.entity.Reimbursement.reimbursement_state.DENIED;


public class JdbcReimbursementRepository implements ReimbursementRepository {

    public static final Logger LOG = Logger.getLogger("ers");

    public List<Reimbursement> loadEmployeePendingReimbursements(int empId) {
        LOG.info("retrieving pending reimbursements");
        List<Reimbursement> pendingReimbursementList = new ArrayList<>();
        try (Connection connection = SQLConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM reimbursement WHERE employee_id=? AND state=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, empId);
            ps.setString(2, "PENDING");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Reimbursement reimbursement = new Reimbursement();
                reimbursement.setReimbursementId(rs.getInt("reimbursement_id"));
                reimbursement.setEmpId(empId);
                reimbursement.setTitle(rs.getString("title"));
                reimbursement.setDescription(rs.getString("description"));
                reimbursement.setTotal(rs.getDouble("total"));
                reimbursement.setState(Reimbursement.reimbursement_state.valueOf(rs.getString("state")));
                pendingReimbursementList.add(reimbursement);
            }
        } catch(SQLException e) {
            LOG.error("error retrieving pending transactions");
            e.printStackTrace();
        }
        return pendingReimbursementList;
    }

    @Override
    public List<Reimbursement> loadEmployeeResolvedReimbursements(int empId) {
        LOG.info("retrieving resolved reimbursements");
        List<Reimbursement> resolvedReimbursementList = new ArrayList<>();
        try (Connection connection = SQLConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM reimbursement WHERE employee_id = ? AND NOT state = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, empId);
            ps.setString(2, "PENDING");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Reimbursement reimbursement = new Reimbursement();
                reimbursement.setReimbursementId(rs.getInt("reimbursement_id"));
                reimbursement.setEmpId(empId);
                reimbursement.setTitle(rs.getString("title"));
                reimbursement.setDescription(rs.getString("description"));
                reimbursement.setTotal(rs.getDouble("total"));
                reimbursement.setState(Reimbursement.reimbursement_state.valueOf(rs.getString("state")));
                resolvedReimbursementList.add(reimbursement);
            }
        } catch(SQLException e) {
            LOG.error("error retrieving resolved transactions");
            e.printStackTrace();
        }
        return resolvedReimbursementList;
    }

    public List<Reimbursement> loadAllEmployeePendingReimbursements() {
        LOG.info("retrieving all pending reimbursements");
        List<Reimbursement> pendingReimbursementList = new ArrayList<>();
        try (Connection connection = SQLConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM reimbursement WHERE state = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "PENDING");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Reimbursement reimbursement = new Reimbursement();
                reimbursement.setReimbursementId(rs.getInt("reimbursement_id"));
                reimbursement.setEmpId(rs.getInt("employee_id"));
                reimbursement.setTitle(rs.getString("title"));
                reimbursement.setDescription(rs.getString("description"));
                reimbursement.setTotal(rs.getDouble("total"));
                reimbursement.setState(Reimbursement.reimbursement_state.valueOf(rs.getString("state")));
                pendingReimbursementList.add(reimbursement);
            }
        } catch(SQLException e) {
            LOG.error("error retrieving pending transactions");
            e.printStackTrace();
        }
        return pendingReimbursementList;
    }

    public List<Reimbursement> loadAllEmployeeResolvedReimbursements() {
        LOG.info("retrieving all resolved reimbursements");
        List<Reimbursement> pendingReimbursementList = new ArrayList<>();
        try (Connection connection = SQLConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM reimbursement WHERE NOT state = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "PENDING");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Reimbursement reimbursement = new Reimbursement();
                reimbursement.setReimbursementId(rs.getInt("reimbursement_id"));
                reimbursement.setEmpId(rs.getInt("employee_id"));
                reimbursement.setTitle(rs.getString("title"));
                reimbursement.setDescription(rs.getString("description"));
                reimbursement.setTotal(rs.getDouble("total"));
                reimbursement.setState(Reimbursement.reimbursement_state.valueOf(rs.getString("state")));
                pendingReimbursementList.add(reimbursement);
            }
        } catch(SQLException e) {
            LOG.error("error retrieving pending transactions");
            e.printStackTrace();
        }
        return pendingReimbursementList;
    }

    public void approveReimbursement(int reimbursementId) {
        LOG.info("approving reimbursement with reimbursement id " + reimbursementId);
        try (Connection connection = SQLConnectionFactory.getConnection()) {
            String sql = "UPDATE reimbursement SET state = ? WHERE reimbursement_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(APPROVED));
            statement.setInt(2, reimbursementId);
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void denyReimbursement(int reimbursementId) {
        LOG.info("denying reimbursement with reimbursement id " + reimbursementId);
        try (Connection connection = SQLConnectionFactory.getConnection()) {
            String sql = "UPDATE reimbursement SET state = ? WHERE reimbursement_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(DENIED));
            statement.setInt(2, reimbursementId);
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void submitReimbursement(Reimbursement reimbursement) {
        LOG.info("submitting reimbursement");
        try (Connection connection = SQLConnectionFactory.getConnection()) {
            String sql = "INSERT INTO reimbursement (employee_id, title, description, total, state) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, reimbursement.getEmpId());
            statement.setString(2, reimbursement.getTitle());
            statement.setString(3, reimbursement.getDescription());
            statement.setDouble(4, reimbursement.getTotal());
            statement.setString(5, String.valueOf(reimbursement.getState()));
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
