package EmployeeProject
object Main extends App{

    private val company = new Company

    company.addEmployee(Employee("Raj", 30, 20000, true))
    company.addEmployee(Employee("Sanjay", 20, 5000, false))
    company.addEmployee(Employee("Akash", 50, 50000, true))
    company.addEmployee(new Employee("Ajay", 20))

    println("Printing all employees")
    company.showAllEmployees()

    // employees with salary lesser than 20000.0
    println("\nEmployees with salary lesser than 20000.0")
    company.employeesWithMinSalary(20000.0)

    // employees with salary greater than 20000.0
    println("\nEmployees with salary greater than 20000.0")
    company.employeesWithMaxSalary(20000.0)

    println("\nActive Employees")
    company.activeEmployees()

    println("\nInactive Employees")
    company.inactiveEmployees()







}
