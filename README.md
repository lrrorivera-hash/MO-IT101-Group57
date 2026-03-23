# MotorPH Payroll System
Terminal Assessment – Computer Programming 1

## Team Details
Name: Rochelle Rivera

Contribution:
- Developed the Java payroll program
- Implemented employee data and attendance reading from CSV files
- Implemented payroll computation including hours worked, gross salary, and government deductions
- Implemented tax computation based on Philippine withholding tax table
- Tested the program and verified payroll outputs
- Updated documentation and repository files

## Program Details
The MotorPH Payroll System is a Java console-based program that processes employee payroll using employee and attendance records stored in CSV files.

The program performs the following tasks:

1. Reads employee information from **EmployeeDetails.csv**.
2. Reads attendance records from **AttendanceRecord.csv**.
3. Calculates the total hours worked between **8:00 AM and 5:00 PM**.
4. Computes the employee’s **gross salary** based on hours worked and hourly rate.
5. Applies government deductions including:
   - SSS
   - PhilHealth
   - Pag-IBIG
   - Withholding Tax
6. Displays payroll information for two cutoffs:
   - June 1 – June 15
   - June 16 – June 30

Government deductions are applied during payroll computation after calculating the salary for both cutoffs.

