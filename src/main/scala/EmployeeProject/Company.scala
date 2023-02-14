package EmployeeProject

import scala.collection.mutable.ListBuffer
class Company {
    var employees = ListBuffer[Employee]()

    def addEmployee(employee : Employee) = employees += employee

    def showAllEmployees() = printEmployees(employees)

    def employeesWithMinSalary(salary : Double) =
        printEmployees(employees.filter(i => i.salary <= salary && i.salary != 0.0))

    def employeesWithMaxSalary(salary : Double) =
        printEmployees(employees.filter(i => i.salary >= salary && i.salary != 0.0))

    def activeEmployees() = printEmployees(employees.filter(i => i.isActive))

    def inactiveEmployees() = printEmployees(employees.filter(i => !i.isActive))

    private def printEmployees(employeeList : ListBuffer[Employee]) =
        employeeList.foreach(i => println("Employee \n"+ i + "\n"))

}
