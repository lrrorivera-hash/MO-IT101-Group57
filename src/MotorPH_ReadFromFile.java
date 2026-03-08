/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * MotorPH_ReadFromFile.java
 *
 * This program reads employee payroll information from a text file and
 * automatically computes government deductions and net pay.
 *
 * The program demonstrates the use of Java file handling using
 * FileReader and BufferedReader. Each line of the input file contains
 * an employee name and gross salary separated by a comma.
 *
 * Example input file format:
 * Juan Dela Cruz,40000
 * Maria Santos,55000
 *
 * The program validates the file, parses each employee record,
 * calculates payroll deductions, and prints a readable payroll summary.
 *
 * Author: Rochelle Rivera
 * Course: MO-IT101
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class MotorPH_ReadFromFile {

    /**
     * Computes the SSS deduction.
     * This represents the employee contribution to the Social Security System.
     *
     * @param grossSalary employee's monthly salary before deductions
     * @return calculated SSS contribution
     */
    public static double computeSSS(double grossSalary) {
        return grossSalary * 0.045;
    }

    /**
     * Computes the PhilHealth deduction.
     * This contribution supports the Philippine national health insurance.
     *
     * @param grossSalary employee's monthly salary
     * @return calculated PhilHealth deduction
     */
    public static double computePhilHealth(double grossSalary) {
        return grossSalary * 0.035;
    }

    /**
     * Computes the Pag-IBIG deduction.
     * Pag-IBIG is a housing savings contribution required for employees.
     *
     * @param grossSalary employee's monthly salary
     * @return calculated Pag-IBIG deduction
     */
    public static double computePagIBIG(double grossSalary) {
        return grossSalary * 0.02;
    }

    /**
     * Computes the income tax deduction.
     * This is a simplified percentage-based calculation.
     *
     * @param grossSalary employee's salary before deductions
     * @return calculated tax amount
     */
    public static double computeIncomeTax(double grossSalary) {
        return grossSalary * 0.10;
    }

    /**
     * Computes the employee's net pay.
     * Net pay = gross salary minus all deductions.
     *
     * @param grossSalary employee's salary before deductions
     * @return final salary after deductions
     */
    public static double computeNetPay(double grossSalary) {

        double sssContribution = computeSSS(grossSalary);
        double philHealthContribution = computePhilHealth(grossSalary);
        double pagIbigContribution = computePagIBIG(grossSalary);
        double incomeTax = computeIncomeTax(grossSalary);

        return grossSalary - (sssContribution
                + philHealthContribution
                + pagIbigContribution
                + incomeTax);
    }

    public static void main(String[] args) {

        String fileName = "employee_data.txt";

        try {

            // Check if the file exists before attempting to read it
            File payrollFile = new File(fileName);

            if (!payrollFile.exists()) {
                System.out.println("Error: employee_data.txt file not found.");
                return;
            }

            // BufferedReader reads the text file line by line
            BufferedReader reader = new BufferedReader(new FileReader(payrollFile));

            String line;

            System.out.println("\n========================================");
            System.out.println("MotorPH Payroll Processing System");
            System.out.println("========================================");

            // Loop through every record in the text file
            while ((line = reader.readLine()) != null) {

                // Split the line into name and salary using comma
                String[] employeeRecord = line.split(",");

                // Validate record structure
                if (employeeRecord.length != 2) {
                    System.out.println("Invalid record format: " + line);
                    continue;
                }

                String employeeName = employeeRecord[0].trim();
                double grossSalary;

                try {

                    // Convert salary from text to number
                    grossSalary = Double.parseDouble(employeeRecord[1].trim());

                    // Validate salary value
                    if (grossSalary <= 0) {
                        System.out.println("Invalid salary for employee: " + employeeName);
                        continue;
                    }

                } catch (NumberFormatException error) {

                    System.out.println("Salary format error for employee: " + employeeName);
                    continue;
                }

                // Compute deductions
                double sss = computeSSS(grossSalary);
                double philHealth = computePhilHealth(grossSalary);
                double pagIbig = computePagIBIG(grossSalary);
                double incomeTax = computeIncomeTax(grossSalary);
                double netPay = computeNetPay(grossSalary);

                // Display formatted payroll summary
                System.out.println("\n----------------------------------------");
                System.out.println("Employee Name : " + employeeName);
                System.out.printf("Gross Salary  : %.2f%n", grossSalary);
                System.out.printf("SSS           : %.2f%n", sss);
                System.out.printf("PhilHealth    : %.2f%n", philHealth);
                System.out.printf("Pag-IBIG      : %.2f%n", pagIbig);
                System.out.printf("Income Tax    : %.2f%n", incomeTax);
                System.out.println("----------------------------------------");
                System.out.printf("Net Pay       : %.2f%n", netPay);
                System.out.println("----------------------------------------");

            }

            // Close the file after reading
            reader.close();

        } catch (IOException error) {

            // Handles file reading errors
            System.out.println("Error reading employee file.");
        }
    }
}
    

