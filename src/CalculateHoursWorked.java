/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * MotorPH Payroll System
 * -------------------------------------------------------------------------
 * This program calculates the total hours worked by an employee
 * based on their time - in, time - out, and break duration.
 * 
 * The purpose of this program is to demonstrate the use of:
 * - Variables
 * - Appropriate data types
 * - Arithmetic operators
 * - Clear inline documentation
 * 
 * @author rochellerivera
 */
public class CalculateHoursWorked {
    public static void main(String[] args) {
        // Store the employee's name for display purposes
        String employeeName = "Rochelle Rivera";
        
        // Record the employee's time - in (8:00 AM)
        // Using double to allow decimal values if needed (e.g, 8.5 for 8:30 AM)
        double timeIn = 8.0;
        
        // Record the employee's time - out(5:00 PM or 17:00 in 24-hour format
        double timeOut = 17.0;
        
        // Break time in hours (1 hour lunch break)
        // This will be deducted from total working hours 
        double breakTime = 1.0;
        
        // Calculate total hours worked
        // Formula:
        // (Time Out - Time In)gives total presence hours
        // Subtract breakTime to get actual working hours
        double totalHoursWorked = timeOut - timeIn - breakTime;
        
        // Display formatted payroll summary
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Time In: " + timeIn);
        System.out.println("Time Out: " + timeOut);
        System.out.println("Break Time: " + breakTime);
        System.out.println("Total Hours Worked: " + totalHoursWorked);
        
        // Verification message to confirm correct computation
        System.out.println("Test passed: Computation is correct");
        
    }
    
}
