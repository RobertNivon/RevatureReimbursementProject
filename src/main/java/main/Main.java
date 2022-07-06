package main;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.entity.Employee;
import com.repository.EmployeeRepository;
import com.repository.JdbcEmployeeRepository;
import com.repository.JdbcReimbursementRepository;
import com.repository.ReimbursementRepository;
import org.apache.log4j.Logger;

import java.util.Optional;

public class Main {

    private static final Logger LOG = Logger.getLogger("ers");

    public static void main(String[] args) {

        EmployeeRepository jdbcEmployeeRepository = new JdbcEmployeeRepository();
        ReimbursementRepository jdbcReimbursementRepository = new JdbcReimbursementRepository();

        Optional<Employee> employee1 = Optional.of(new Employee());
        employee1.get().setEmpId(2);
        employee1.get().setName("John Smith");
        employee1.get().setPhoneNumber("983-476-1097");
        employee1.get().setAddress("1320 Lincoln Avenue");
        employee1.get().setEmail("johnsmith@gmail.com");
        employee1.get().setIsManager(false);
        employee1.get().setPassword("$2a$12$4mUZl81DA7afbENcJH1IpueRpSEmdLnxiKNhT3PEtAgvZPgBCRstS");

        jdbcEmployeeRepository.updateByEmpId(employee1);
        System.out.println(employee1);

        System.out.println(jdbcEmployeeRepository.findByEmpUsername("johnsmith@gmail.com"));
        System.out.println(jdbcEmployeeRepository.findByEmpId(2).get().getName());

        System.out.println(jdbcEmployeeRepository.findAllEmployees());

        System.out.println(jdbcReimbursementRepository.loadEmployeePendingReimbursements(2));
        System.out.println(jdbcReimbursementRepository.loadEmployeeResolvedReimbursements(3));

        System.out.println(jdbcReimbursementRepository.loadAllEmployeePendingReimbursements());
        System.out.println(jdbcReimbursementRepository.loadAllEmployeeResolvedReimbursements());

        Optional<Employee> employee = jdbcEmployeeRepository.findByEmpUsername("johnsmith@gmail.com");
        System.out.println(employee.get().getName());

        jdbcReimbursementRepository.approveReimbursement(2);
        jdbcReimbursementRepository.denyReimbursement(3);

//        String password = "bestbossever";
//
//        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
//        System.out.println(bcryptHashString);

    }
}
