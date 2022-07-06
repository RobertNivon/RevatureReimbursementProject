package com.repository;

import com.entity.Reimbursement;

import java.util.List;
import java.util.Optional;

public interface ReimbursementRepository {
    List<Reimbursement> loadEmployeePendingReimbursements(int empId);

    List<Reimbursement> loadEmployeeResolvedReimbursements(int empId);

    List<Reimbursement> loadAllEmployeePendingReimbursements();

    List<Reimbursement> loadAllEmployeeResolvedReimbursements();
    void approveReimbursement(int reimbursementId);
    void denyReimbursement(int reimbursementId);
    void submitReimbursement(Reimbursement reimbursement);

}
