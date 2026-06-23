package in.kce.dao;

import java.sql.*;
import java.util.ArrayList;
import in.kce.bean.Employee;
import in.kce.util.DBUtil;

public class EmployeeDAO {

    public boolean saveEmployee(Employee employee) {
        Connection con = DBUtil.getConnection();
        String query = "INSERT INTO employee2 (empid, empname, designation) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, employee.getEmpId());
            ps.setString(2, employee.getEmpName());
            ps.setString(3, employee.getDesignation());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateEmployee(Employee employee) {
        Connection con = DBUtil.getConnection();
        String query = "UPDATE employee2 SET empname=?, designation=? WHERE empid=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, employee.getEmpName());
            ps.setString(2, employee.getDesignation());
            ps.setInt(3, employee.getEmpId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteEmployee(int empId) {
        Connection con = DBUtil.getConnection();
        String query = "DELETE FROM employee2 WHERE empid=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, empId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Employee getEmployee(int empId) {
        Connection con = DBUtil.getConnection();
        String query = "SELECT * FROM employee2 WHERE empid=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Employee emp = new Employee();
                emp.setEmpId(rs.getInt("empid"));
                emp.setEmpName(rs.getString("empname"));
                emp.setDesignation(rs.getString("designation"));
                return emp;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Employee> getAllEmployees() {
        Connection con = DBUtil.getConnection();
        String query = "SELECT * FROM employee2";

        ArrayList<Employee> list = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmpId(rs.getInt("empid"));
                emp.setEmpName(rs.getString("empname"));
                emp.setDesignation(rs.getString("designation"));
                list.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}