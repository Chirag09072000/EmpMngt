/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmngmnt.pojo;

/**
 *
 * @author lenovo
 */

public class Emp {
    private int empNo;
    private String ename;
    private double empSal;

    public Emp() {
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(double empSal) {
        this.empSal = empSal;
    }

    public Emp(int empNo, String ename, double empSal) {
        this.empNo = empNo;
        this.ename = ename;
        this.empSal = empSal;
    }
}
