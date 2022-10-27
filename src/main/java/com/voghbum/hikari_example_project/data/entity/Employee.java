package com.voghbum.hikari_example_project.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.time.LocalDate;

public class Employee {
    @Id
    private Long empno;
    private String ename;
    private String job;
    private Long mgr;
    private LocalDate hireDate;
    private Long sal;
    private Long comm;
    private Long deptNo;

    public Long getEmpno() {
        return empno;
    }

    public void setEmpno(Long empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Long getMgr() {
        return mgr;
    }

    public void setMgr(Long mgr) {
        this.mgr = mgr;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Long getSal() {
        return sal;
    }

    public void setSal(Long sal) {
        this.sal = sal;
    }

    public Long getComm() {
        return comm;
    }

    public void setComm(Long comm) {
        this.comm = comm;
    }

    public Long getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Long deptNo) {
        this.deptNo = deptNo;
    }

    public void setHiredate(Date hiredate) {
        this.hireDate = hiredate.toLocalDate();
    }

    public void setEmpNo(int empno) {
        this.empno = (long) empno;
    }

    public void setDeptno(int deptno) {
        this.deptNo = (long) deptno;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", hireDate=" + hireDate +
                ", sal=" + sal +
                '}';
    }
}
