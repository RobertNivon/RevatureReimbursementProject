package com.entity;

import static com.entity.Reimbursement.reimbursement_state.*;

public class Reimbursement {

    public enum reimbursement_state {
        PENDING, DENIED, APPROVED
    }

    private int reimbursementId;
    private int empId;
    private String title;
    private String description;
    private double total;
    private reimbursement_state state;

    public Reimbursement(int reimbursementId, int empId, String title, String description, double total) {
        this.reimbursementId = reimbursementId;
        this.empId = empId;
        this.title = title;
        this.description = description;
        this.total = total;
        this.state = PENDING;
    }

    public Reimbursement() {

    }

    public int getReimbursement_id() {
        return reimbursementId;
    }

    public void setReimbursementId(int reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public reimbursement_state getState() {
        return state;
    }

    public void setState(reimbursement_state state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbursementId=" + reimbursementId +
                ", empId=" + empId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", total=" + total +
                ", state=" + state +
                '}';
    }
}
