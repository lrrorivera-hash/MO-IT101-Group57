MotorPH Payroll System
Milestone 2 - Computer Programming 1

Program Description
The MotorPH Payroll System is a Java console-based program that processes employee payroll using employee details and attendance records stored in CSV files.
The program allows a user to log in either as an employee or payroll staff. It reads employee data, calculates hours worked based on attendance records, computes
gross salary for two payroll cutoffs, and applies government deductions to determine the net salary.

Features of the Program
1. Login Authentication
   The system requires a valid username and password before the program can be acccessed.
   Valid usernames:
       employee
       payroll_staff
   Password:
       12345
      If the credentials are incorrect, the program will display an error message and terminate.

2. Employee Name
   If the user logs in as employee, the program displays the following menu:
      * Enter Employee Number
      * Exit
   If the employee number exists in the system, the program displays:
      * Employee Number
      * Employee Name
      * Birthday
      * Payroll computation results
   If the employee number does not exist, the program displays:
      * Employee number does not exist.

3. Payroll Staff Menu
   If the user logs in as payroll_staff, the program displays the following menu:
      * Process Payroll
      * Exit
   If the user selects Process Payroll, the following options appear:
      * One Employee
      * All Employees
      * Exit
   The payroll staff can compute payroll for a single employee or for all amployees stored in the system.

4. Payroll Computation
   The payroll system computes salary based on two payroll cutoffs.
      First Cutoff
      * June 1 - June 15
        Displayed information:
          * Total Hours Worked
          * Gross Salary
          * Net Salary
        No government deductions are applied in the first cutoff

      Second Cutoff
      * June 16 - June 30
        Displayed information:
          * Total Hours Worked
          * Gross Salary
          * Government Deductions
          * Net Salary
        The government deductions include:
          * SSS
          * PhilHealth
          * Pag-IBIG
          * Withholding Tax
        Total deductions are applied in the second cutoff payroll.

5. Government Deductions
   The system calculates deductions based on the monthly salary, which is the sum of the first and second cutoff gross salaries.
          * SSS Contribution
               SSS is computed based on the SSS contribution table using salary brackets.
          * PhilHealth Contribution
               PhilHealth Contribution is calculated as:
                      3% of monthly salary divided by 2.
          * Pag-IBIG Contribution
               Pag-IBIG contribution is calculated as:
                      2% of monthly salary with a maximum contribution of 100
          * Withholding Tax
               Withholding tax is computed based on the withholding tax table.

6. Work Hour Rules
   The system computes working hours based on the following rules:
       * Working hours are only counted between 8:00 AM and 5:00 PM
       * Maximum working hours per day is 8 hours
       * Extra hours outside the working schedule are not included
     Examples:
         8:30 AM - 5:30 PM = 7.5 hours
         8:05 AM - 5:00 PM = 8 hours
         8:05 AM - 4:30 PM = 7.5 hours

7. Input Files
   The system reads data from the following files.

   EmployeeDetails.csv
     - Contains empoyee information such as:
         * Employee Number
         * Last Name
         * First Name
         * Birthday
         * Hourly Rate

   AttendanceRecord.csv
      - Contains employee attendance data such as:
         * Employee Number
         * Date
         * Login Time
         * Logout Time

   Error Handling
      - The program includes basic error handling to prevent crashes.

      Examples:
       * If a CSV file cannot be found, the program displays an error message.
       * If an invalid employee number is entered, th eprogram displays a message and continues running.

   AUTHOR: Rochelle Manalaysay Rivera

          
     









   
