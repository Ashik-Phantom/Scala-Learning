package EmployeeProject

case class Employee(var name : String, var age : Int, var salary : Double, var isActive : Boolean) {
    require(age >= 18)

    def this(name : String, age : Int) = this(name, age, 0.0, false)

    override def toString : String = {
        "name: " + name + "\nage: " + age + "\nsalary: " + salary + "\nis Active: " + isActive
    }

    def updateName(actualName : String) = name = actualName
    def updateAge(actualAge : Int) = age = actualAge
    def updateAge() = this.age+=1
    def giveRaise(raise : Double) = this.salary += raise
    def giveRaise() = this.salary += 1000
    def makeActive() = this.isActive = true
    def makeInActive() = this.isActive = false
}




