package in.kce.main;
import java.util.*;
import in.kce.bean.Employee;
import in.kce.service.EmployeeService;

public class TestEmployee {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeService es = new EmployeeService();
        while (true) {
            System.out.println("\n--- Employee Management ---");
            System.out.println("1. Store Employee");
            System.out.println("2. Update Employee");
	        System.out.println("3. Fetch One Employee");
	        System.out.println("4. Fetch All Employees");
	        System.out.println("5. Delete Employee");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Designation: ");
                    String desig = sc.next();
                    if (es.saveEmployee(id, name, desig))
                    System.out.println("Record inserted successfully");
                    else System.out.println("Record does not inserted");
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    System.out.print("Enter Name: ");
                    name = sc.next();
                    System.out.print("Enter Designation: ");
                    desig = sc.next();
                    if(es.updateEmployee(id, name, desig))
                    System.out.println("Record Updated Successfully");
                    else System.out.println("Record does not updated");
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    Employee emp = es.getEmployee(id);
                    if (emp != null)
                        System.out.println(emp.getEmpId() + " " + emp.getEmpName() + " " + emp.getDesignation());
                    else
                        System.out.println("Not Found");
                    break;

                case 4:
                    ArrayList<Employee> list = es.getAllEmployees();
                    for (Employee e : list) {
                        System.out.println(e.getEmpId() + " " + e.getEmpName() + " " + e.getDesignation());
                    }
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    System.out.println(es.deleteEmployee(id) ? "Deleted" : "Failed");
                    break;

                default:
                    System.out.println("Invalid Option");
            }
        }
    }
}