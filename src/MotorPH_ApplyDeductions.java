/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 * MotorPH Payroll Deduction System
 *
 * Description:
 * This program calculates the semi-monthly net pay of a MotorPH employee.
 * It computes mandatory government deductions including SSS, PhilHealth,
 * Pag-IBIG, and Income Tax using separate reusable methods.
 *
 * The program demonstrates proper use of methods, parameter passing,
 * return values, and structured program design. Each deduction is computed
 * independently and then combined to determine the employee’s net salary.
 *
 * Author: Rochelle Rivera
 * Course: MO-IT101 Computer Programming
 */

public class MotorPH_ApplyDeductions {

    // Constants used for deduction rates
    // Using constants avoids "magic numbers" and makes the code easier to maintain
    static final double SSS_RATE = 0.045;
    static final double PHILHEALTH_RATE = 0.03;
    static final double PAGIBIG_RATE = 0.02;
    static final double TAX_RATE = 0.10;

    /**
     * Computes the SSS deduction based on the employee's gross salary.
     *
     * SSS is a mandatory social security contribution deducted from payroll.
     *
     * @param grossSalary the employee's semi-monthly salary
     * @return the calculated SSS deduction amount
     */
    public static double computeSSS(double grossSalary) {
        return grossSalary * SSS_RATE;
    }

    /**
     * Computes the PhilHealth deduction.
     *
     * PhilHealth contributions support the national health insurance program.
     *
     * @param grossSalary the employee's semi-monthly salary
     * @return the PhilHealth deduction amount
     */
    public static double computePhilHealth(double grossSalary) {
        return grossSalary * PHILHEALTH_RATE;
    }

    /**
     * Computes the Pag-IBIG deduction.
     *
     * Pag-IBIG contributions support the housing and savings program
     * for Filipino workers.
     *
     * @param grossSalary the employee's semi-monthly salary
     * @return the Pag-IBIG deduction amount
     */
    public static double computePagIbig(double grossSalary) {
        return grossSalary * PAGIBIG_RATE;
    }

    /**
     * Computes the Income Tax deduction.
     *
     * This represents the withholding tax deducted from employee salaries
     * before the payroll is released.
     *
     * @param grossSalary the employee's semi-monthly salary
     * @return the income tax deduction amount
     */
    public static double computeIncomeTax(double grossSalary) {
        return grossSalary * TAX_RATE;
    }

    /**
     * Computes the employee's net pay.
     *
     * This method calls all deduction methods, sums the total deductions,
     * and subtracts them from the gross salary to determine the net salary.
     *
     * @param grossSalary the employee's semi-monthly salary
     * @return the final net pay after deductions
     */
    public static double computeNetPay(double grossSalary) {

        double sss = computeSSS(grossSalary);
        double philhealth = computePhilHealth(grossSalary);
        double pagibig = computePagIbig(grossSalary);
        double tax = computeIncomeTax(grossSalary);

        double totalDeductions = sss + philhealth + pagibig + tax;

        return grossSalary - totalDeductions;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter the employee's semi-monthly gross salary
        System.out.print("Enter employee semi-monthly gross salary: ");
        double grossSalary = sc.nextDouble();

        // Validate that the salary entered is a positive number
        if (grossSalary <= 0) {
            System.out.println("Invalid salary amount. Salary must be positive.");
            return;
        }

        // Compute each deduction using the defined methods
        double sss = computeSSS(grossSalary);
        double philhealth = computePhilHealth(grossSalary);
        double pagibig = computePagIbig(grossSalary);
        double tax = computeIncomeTax(grossSalary);

        // Compute total deductions
        double totalDeductions = sss + philhealth + pagibig + tax;

        // Compute net pay
        double netPay = computeNetPay(grossSalary);

        // Display a clear payroll summary
        System.out.println("\n========== MotorPH Payroll Summary ==========");
        System.out.println("Gross Salary: " + grossSalary);
        System.out.println("SSS Deduction: " + sss);
        System.out.println("PhilHealth Deduction: " + philhealth);
        System.out.println("Pag-IBIG Deduction: " + pagibig);
        System.out.println("Income Tax Deduction: " + tax);
        System.out.println("Total Deductions: " + totalDeductions);
        System.out.println("Net Pay: " + netPay);
        System.out.println("==============================================");
    }
}