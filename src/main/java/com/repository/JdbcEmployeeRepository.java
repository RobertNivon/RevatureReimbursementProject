package com.repository;

import com.datasource.SQLConnectionFactory;
import com.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.entity.Reimbursement;
import org.apache.log4j.Logger;

public class JdbcEmployeeRepository implements EmployeeRepository {

    private static final Logger LOG = Logger.getLogger("ers");

    public Optional<Employee> findByEmpUsername(String empUsername) {
        LOG.info("loading employee: " + empUsername);
        try (Connection connection = SQLConnectionFactory.getConnection();) {
            String sql = "select * from employee where employee_email=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, empUsername);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee();
                employee.setEmpId(rs.getInt("employee_id"));
                employee.setName(rs.getString("employee_name"));
                employee.setPhoneNumber(rs.getString("phone_number"));
                employee.setAddress(rs.getString("employee_address"));
                employee.setEmail(rs.getString("employee_email"));
                employee.setIsManager(rs.getBoolean("is_manager"));
                employee.setPassword(rs.getString("password"));
                return Optional.of(employee);
            }
        } catch (SQLException e) {
            LOG.error("error loading account: " + empUsername);
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Employee> findByEmpId(int empId) {
        LOG.info("loading employee: " + empId);
        try (Connection connection = SQLConnectionFactory.getConnection()) {
            String sql = "select * from employee where employee_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee();
                employee.setEmpId(rs.getInt("employee_id"));
                employee.setName(rs.getString("employee_name"));
                employee.setPhoneNumber(rs.getString("phone_number"));
                employee.setAddress(rs.getString("employee_address"));
                employee.setEmail(rs.getString("employee_email"));
                employee.setIsManager(rs.getBoolean("is_manager"));
                employee.setPassword(rs.getString("password"));
                return Optional.of(employee);
            }
        } catch (SQLException e) {
            LOG.error("error loading account: " + empId);
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Employee> findAllEmployees() {
        LOG.info("loading all employees");
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = SQLConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM employee";
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmpId(rs.getInt("employee_id"));
                employee.setName(rs.getString("employee_name"));
                employee.setPhoneNumber(rs.getString("phone_number"));
                employee.setAddress(rs.getString("employee_address"));
                employee.setEmail(rs.getString("employee_email"));
                employee.setIsManager(rs.getBoolean("is_manager"));
                employee.setPassword(rs.getString("password"));
                employeeList.add(employee);
            }
        } catch(SQLException e) {
            LOG.error("error loading all employees:");
            e.printStackTrace();
        }
        return employeeList;
    }

    public void updateByEmpId(Optional<Employee> employee) {
        LOG.info("updating employee with id: " + employee.get().getEmpId());
        try (Connection connection = SQLConnectionFactory.getConnection()) {
            String sql = "UPDATE employee SET employee_name = ?, phone_number = ?, employee_address = ? WHERE employee_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.get().getName());
            statement.setString(2, employee.get().getPhoneNumber());
            statement.setString(3, employee.get().getAddress());
            statement.setInt(4, employee.get().getEmpId());
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveEmployee(Employee employee) {
        LOG.info("saving employee");
        try (Connection connection = SQLConnectionFactory.getConnection()) {
            String sql = "INSERT INTO employee (employee_name, phone_number, employee_address, employee_email, is_manager, password) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getPhoneNumber());
            statement.setString(3, employee.getAddress());
            statement.setString(4, employee.getEmail());
            statement.setBoolean(5, employee.isManager());
            statement.setString(6, employee.getPassword());
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
