The Strategy design pattern is used in the software. It specifies and encapsulates a set of algorithms known as EmployeeRoles. It also includes a context class (EmployeePay) that allows clients to dynamically switch between these algorithms by modifying the EmployeeRole object it contains.

The EmployeeRole interface describes the general behaviour for all concrete classes that implement it, which is to compute a specific employee's pay, bonus, and raise.

The concrete classes (Attendant, Manager, Supervisor, and Worker) implement the EmployeeRole interface and implement the methods calculateSalary(), calculateBonus(), and calculateHike().

The context class (EmployeePay) accepts the employee's name, basic salary, and an EmployeeRole object as instance variables and saves them. It also includes an ArrayList to store the pay data calculated by the executeStrategy() function, which calls the EmployeeRole object's calculateSalary(), calculateBonus(), and calculateHike() methods to acquire the pay details.

Overall, this software calculates an employee's pay information by dynamically switching between distinct EmployeeRoles, which is useful in a real-world scenario where an employee's pay grade or job may vary over time.