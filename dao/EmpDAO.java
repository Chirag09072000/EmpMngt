/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmngmnt.dao;

import empmngmnt.dbutil.DBConnection;
import empmngmnt.pojo.Emp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class EmpDAO {
    public static boolean addEmployee(Emp e)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Insert into employee values(?,?,?)");
        ps.setInt(1,e.getEmpNo());
        ps.setString(2,e.getEname());
        ps.setDouble(3,e.getEmpSal());
        int result=ps.executeUpdate();
        if(result==1)
            return true;
        return false;
    }
    public static Emp findEmployeeById(int empno)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select * from employee where empid=?");
        ps.setInt(1,empno);
        ResultSet rs=ps.executeQuery();
        Emp e=null;
        if(rs.next())
        {
            e=new Emp();
            e.setEmpNo(rs.getInt(1));
            e.setEname(rs.getString(2));
            e.setEmpSal(rs.getDouble(3));
        }
        return e;
    }
    public static ArrayList<Emp> getAllEmployees() throws SQLException
    {
       Connection conn=DBConnection.getConnection();
       Statement st=conn.createStatement();
       ArrayList<Emp> empList=new ArrayList<>();
      ResultSet rs=st.executeQuery("Select * from employee");
       while(rs.next())
       {
           Emp e=new Emp();
           e.setEmpNo(rs.getInt(1));
           e.setEname(rs.getString(2));
           e.setEmpSal(rs.getDouble(3));
           empList.add(e);
       }
       return empList;
    }
    public static boolean updateEmployee(int empno,String ename,double sal) throws SQLException
    {   
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update employee set ename=?,sal=? where empid=?");
        ps.setInt(3,empno);
        ps.setString(1,ename);
        ps.setDouble(2,sal);
        int rs=ps.executeUpdate();
        if(rs==1)
            return true;
        return false;
    }
    public static boolean deleteEmployee(int empno) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("delete from employee where empid=?");
        ps.setInt(1,empno);
        int result=ps.executeUpdate();
        if(result==1)
            return true;
        return false;
    }
}

