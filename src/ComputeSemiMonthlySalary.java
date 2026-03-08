/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 MotorPH Payroll System
 This program computes the semi-monthly salary

 It collects the following information:
 - Employee Name
 - Total Hours Worked
 - Hourly Rate

 The program calculates the semi-monthly salary using:
 Salary = Hours Worked x Hourly Rate

 It also validates if the input values are valid using a conditional statement.
 The result is displayed as s formatted payroll summary.
 * @author rochellerivera
 */
public class ComputeSemiMonthlySalary {
    
    public static void main (String[] args) {
        
        // Declare employee information
        String employeeName = "Juan Dela Cruz";
        
        // Declare work data
        double hoursWorked = 80;     // total hurs worked cutoff
        double hourlyRate = 150;     // hourly pay rate
        
        // Variable to store computed salary
        double semiMonthlySalary;
        
        // Validte inputs
        if (hoursWorked < 0) {
            System.out.println("Error: Hours cannot be negative.");
        }
        else if (hourlyRate < 0) {
            System.out.println("Error: Hourly Rate cannot be negative.");
        }
        else if (hoursWorked == 0) {
            System.out.println("Notice: Employee worked zero hours this cutoff.");
        }
        else {
                       
            // Compute salary
            semiMonthlySalary = hoursWorked * hourlyRate;
            
            // Display payroll summary
            System.out.println("===== Mothor PH Payroll Summary =====");
            System.out.println("Employee Name: " + employeeName);
            System.out.println("Hours Worked:" + hoursWorked);
            System.out.println("Hourly Rate PHP " + hourlyRate);
            System.out.println("----------------------------------------");
            System.out.println("Semi-Monthly Salary: PHP " + semiMonthlySalary);
            System.out.println("----------------------------------------");
            
            //Test message as suggested in the instructions
            System.out.println("Computation verified successfully!");
        }
           
    }
    
}
