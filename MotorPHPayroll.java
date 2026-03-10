/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 MotorPH Payroll System
 Milestone 2

 This program demonstrates a simple payroll system that:
 - Authenticates user login
 - Reads employee data from CSV
 - Reads attendance records
 - Computes payroll for two cutoffs
 - Calculates government deductions
* @author rochellerivera
*/

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class MotorPHPayroll {

    // location of csv files
    static String employeeFile = "resources/EmployeeDetails.csv";
    static String attendanceFile = "resources/AttendanceRecord.csv";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println(" MotorPH Payroll System ");
        System.out.println("=====================================");

        // ask for username and password
        System.out.print("Enter Username: ");
        String username = input.nextLine();

        System.out.print("Enter Password: ");
        String password = input.nextLine();

        // check if login is correct
        if (!(password.equals("12345") &&
              (username.equals("employee") || username.equals("payroll_staff")))) {

            System.out.println("Incorrect username and/or password.");
            System.out.println("Program terminated.");
            return;
        }

        System.out.println("\nLogin successful.\n");

        // employee user menu
        if (username.equals("employee")) {

            System.out.println("Employee Menu");
            System.out.println("1. Enter Employee Number");
            System.out.println("2. Exit");

            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {

                System.out.print("Enter Employee Number: ");
                String empNumber = input.nextLine();

                // show employee details
                double rate = displayEmployeeDetails(empNumber);

                // compute payroll if employee exists
                if (rate > 0) {
                    computePayroll(empNumber, rate);
                }

            } else {
                System.out.println("Program terminated.");
            }
        }

        // payroll staff menu
        if (username.equals("payroll_staff")) {

            System.out.println("Payroll Staff Menu");
            System.out.println("1. Process Payroll");
            System.out.println("2. Exit");

            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {

                System.out.println("1. One Employee");
                System.out.println("2. All Employees");
                System.out.println("3. Exit");

                int option = input.nextInt();
                input.nextLine();

                if (option == 1) {

                    System.out.print("Enter Employee Number: ");
                    String empNumber = input.nextLine();

                    double rate = displayEmployeeDetails(empNumber);

                    if (rate > 0) {
                        computePayroll(empNumber, rate);
                    }

                } else if (option == 2) {

                    // compute payroll for all employees
                    processAllEmployees();

                } else {
                    System.out.println("Program terminated.");
                }
            }
        }

        input.close();
    }

    // read employee csv and display employee information
    public static double displayEmployeeDetails(String empNumber) {

        double hourlyRate = 0;

        try {

            BufferedReader br = new BufferedReader(new FileReader(employeeFile));
            String line;

            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data[0].equals(empNumber)) {

                    System.out.println("\nEmployee Details");
                    System.out.println("Employee #: " + data[0]);
                    System.out.println("Employee Name: " + data[1] + ", " + data[2]);
                    System.out.println("Birthday: " + data[3]);

                    // get hourly rate from csv
                    hourlyRate = Double.parseDouble(data[4]);

                    br.close();
                    return hourlyRate;
                }
            }

            System.out.println("Employee number does not exist.");
            br.close();

        } catch (IOException e) {

            // prevent program crash if file missing
            System.out.println("Employee file not found.");
        }

        return hourlyRate;
    }

    // compute payroll based on attendance
    public static void computePayroll(String empNumber, double rate) {

        DecimalFormat df = new DecimalFormat("0.00");

        double hours1 = 0;
        double hours2 = 0;

        try {

            BufferedReader br = new BufferedReader(new FileReader(attendanceFile));
            String line;

            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data[0].equals(empNumber)) {

                    String date = data[3];
                    String login = data[4];
                    String logout = data[5];

                    String[] dateParts = date.split("/");

                    int month = Integer.parseInt(dateParts[0]);
                    int day = Integer.parseInt(dateParts[1]);

                    // only compute attendance for June
                    if (month != 6) continue;

                    // compute hours worked for that day
                    double hours = computeHours(login, logout);

                    // separate hours by cutoff
                    if (day <= 15) {
                        hours1 += hours;
                    } else {
                        hours2 += hours;
                    }
                }
            }

            br.close();

        } catch (IOException e) {

            System.out.println("Attendance file not found.");
            return;
        }

        // compute gross salary
        double gross1 = hours1 * rate;
        double gross2 = hours2 * rate;

        // combine both cutoffs to get monthly salary
        double monthlySalary = gross1 + gross2;

        // compute government deductions
        double sss = computeSSS(monthlySalary);
        double philhealth = computePhilHealth(monthlySalary);
        double pagibig = computePagibig(monthlySalary);
        double tax = computeTax(monthlySalary);

        double totalDeductions = sss + philhealth + pagibig + tax;

        double net1 = gross1;
        double net2 = gross2 - totalDeductions;

        // display first cutoff
        System.out.println("\nCutoff: June 1 - June 15");
        System.out.println("Hours Worked: " + df.format(hours1));
        System.out.println("Gross Salary: " + df.format(gross1));
        System.out.println("Net Salary: " + df.format(net1));

        // display second cutoff with deductions
        System.out.println("\nCutoff: June 16 - June 30");
        System.out.println("Hours Worked: " + df.format(hours2));
        System.out.println("Gross Salary: " + df.format(gross2));

        System.out.println("SSS: " + df.format(sss));
        System.out.println("PhilHealth: " + df.format(philhealth));
        System.out.println("PagIBIG: " + df.format(pagibig));
        System.out.println("Tax: " + df.format(tax));

        System.out.println("Total Deductions: " + df.format(totalDeductions));
        System.out.println("Net Salary: " + df.format(net2));
    }

    // compute hours worked between login and logout
    // working hours allowed only between 8am and 5pm
    public static double computeHours(String login, String logout) {

        int loginHour = Integer.parseInt(login.split(":")[0]);
        int loginMin = Integer.parseInt(login.split(":")[1]);

        int logoutHour = Integer.parseInt(logout.split(":")[0]);
        int logoutMin = Integer.parseInt(logout.split(":")[1]);

        double start = loginHour + (loginMin / 60.0);
        double end = logoutHour + (logoutMin / 60.0);

        if (start < 8) start = 8;
        if (end > 17) end = 17;

        double hours = end - start;

        if (hours > 8) hours = 8;
        if (hours < 0) hours = 0;

        return hours;
    }

    // compute sss based on salary bracket
    public static double computeSSS(double salary) {

        if (salary < 3250) return 135.00;
        if (salary >= 24750) return 1125.00;

        double bracket = Math.floor((salary - 3250) / 500);

        return 157.50 + (bracket * 22.50);
    }

    // philhealth contribution (3% divided by 2)
    public static double computePhilHealth(double salary) {

        double contribution = salary * 0.03;

        return contribution / 2;
    }

    // pagibig contribution (2% with max of 100)
    public static double computePagibig(double salary) {

        double contribution = salary * 0.02;

        if (contribution > 100) contribution = 100;

        return contribution;
    }

    // withholding tax computation
    public static double computeTax(double salary) {

        if (salary <= 20832) return 0;

        if (salary <= 33333)
            return (salary - 20833) * 0.20;

        if (salary <= 66667)
            return 2500 + (salary - 33333) * 0.25;

        return 10833 + (salary - 66667) * 0.30;
    }

    // compute payroll for all employees
    public static void processAllEmployees() {

        try {

            BufferedReader br = new BufferedReader(new FileReader(employeeFile));
            String line;

            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String empNumber = data[0];
                double rate = Double.parseDouble(data[4]);

                System.out.println("\n--------------------------------");
                System.out.println("Employee #: " + empNumber);

                computePayroll(empNumber, rate);
            }

            br.close();

        } catch (IOException e) {

            System.out.println("Employee file not found.");
        }
    }
}