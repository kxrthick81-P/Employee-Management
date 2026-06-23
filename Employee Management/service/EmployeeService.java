package in.kce.service;

import java.util.ArrayList;
import in.kce.bean.Employee;
import in.kce.dao.EmployeeDAO;

public class EmployeeService {

    EmployeeDAO empdao = new EmployeeDAO();

    public boolean saveEmployee(int empId, String empName, String designation) {
        Employee emp = new Employee();
        emp.setEmpId(empId);
        emp.setEmpName(empName);
        emp.setDesignation(designation);
        return empdao.saveEmployee(emp);
    }

    public boolean updateEmployee(int empId, String empName, String designation) {
        Employee emp = new Employee();
        emp.setEmpId(empId);
        emp.setEmpName(empName);
        emp.setDesignation(designation);
        return empdao.updateEmployee(emp);
    }

    public boolean deleteEmployee(int empId) {
        return empdao.deleteEmployee(empId);
    }

    public Employee getEmployee(int empId) {
        return empdao.getEmployee(empId);
    }

    public ArrayList<Employee> getAllEmployees() {
        return empdao.getAllEmployees();
    }
}