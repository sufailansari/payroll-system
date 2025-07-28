import java.util.ArrayList;

abstract  class Employee{
    private String name;
    private  int id;

    public Employee(String name ,int id){
        this.name= name;
        this.id = id;
    }
    public String getName(){
        return name;
    }

    public int getId() {
        return id;
    }
    public abstract double calculateSalary();
    @Override
    public String toString(){
        return "Employee[name="+name+" ,id="+id+",salary="+calculateSalary()+"]";
    }
}

class FulltimeEmployee extends Employee {
    private double monthlySalary ;

    public  FulltimeEmployee(String name , int id , double monthlySalary){
        super(name ,id);
        this.monthlySalary=monthlySalary;
    }
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }

}

class partTimeEmployee extends Employee{
    private  int hoursWorked;

    private  double hourlyRate;

    public partTimeEmployee(String name ,int id ,int hoursWorked ,double hourlyRate){
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;


    }
    @Override
    public  double calculateSalary(){
        return hoursWorked*hourlyRate;
    }
}

class payrollSystem{
    private ArrayList<Employee> employeeList;
    public payrollSystem(){
        employeeList= new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee:employeeList){
            if(employee.getId()==id){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove!=null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployee(){
        for(Employee employee : employeeList){
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        payrollSystem payrollSystem = new payrollSystem();
        FulltimeEmployee Emp1 = new FulltimeEmployee("vikas",1 ,70000 );
        partTimeEmployee Emp2 = new partTimeEmployee("Alex" ,2 ,40 ,100);
        FulltimeEmployee Emp3 =new FulltimeEmployee("rohit" ,3 , 80000.10);
        payrollSystem.addEmployee(Emp1);
        payrollSystem.addEmployee(Emp2);
        System.out.println("Initial Employee Details");
        payrollSystem.displayEmployee();
        System.out.println("Remove Employee");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employee Details");
        payrollSystem.displayEmployee();
        payrollSystem.addEmployee(Emp3);
        payrollSystem.displayEmployee();
    }
}