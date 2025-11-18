package question6;

import java.util.Locale;
import java.util.Scanner;

public class Question6App {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Payroll Management System (RSSB) ===");
            Payslip payslip = buildPayslip(scanner);
            System.out.println("\n--- Payslip ---");
            payslip.generatePayslip();
        } catch (IllegalArgumentException ex) {
            System.out.println("Validation error: " + ex.getMessage());
        }
    }

    private static Payslip buildPayslip(Scanner scanner) {
        int id = 0;
        boolean validInput = false;
        do {
            try {
                id = readPositiveInt(scanner, "Entity ID (>0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String orgName = "";
        validInput = false;
        do {
            try {
                orgName = readNonEmpty(scanner, "Organization Name: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String orgCode = "";
        validInput = false;
        do {
            try {
                orgCode = readMinCode(scanner, "Organization Code (>=3 chars): ", 3);
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String rssbNumber = "";
        validInput = false;
        do {
            try {
                rssbNumber = readDigits(scanner, "RSSB Number (8 digits): ", 8);
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String contactEmail = "";
        validInput = false;
        do {
            try {
                contactEmail = readEmail(scanner, "Organization Email: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String deptName = "";
        validInput = false;
        do {
            try {
                deptName = readNonEmpty(scanner, "Department Name: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String deptCode = "";
        validInput = false;
        do {
            try {
                deptCode = readMinCode(scanner, "Department Code (>=3 chars): ", 3);
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String managerName = "";
        validInput = false;
        do {
            try {
                managerName = readNonEmpty(scanner, "Department Manager Name: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        int employeeId = 0;
        validInput = false;
        do {
            try {
                employeeId = readMinInt(scanner, "Employee ID (>=1000): ", 1000);
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String fullName = "";
        validInput = false;
        do {
            try {
                fullName = readNonEmpty(scanner, "Employee Full Name: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String position = "";
        validInput = false;
        do {
            try {
                position = readNonEmpty(scanner, "Employee Position: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        double baseSalary = 0.0;
        validInput = false;
        do {
            try {
                baseSalary = readPositiveDouble(scanner, "Base Salary (>0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        boolean rssbRegistered = false;
        validInput = false;
        do {
            try {
                rssbRegistered = readBoolean(scanner, "Is RSSB Registered? (true/false): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        int month = 0;
        validInput = false;
        do {
            try {
                month = readMonth(scanner, "Payroll Month (1-12): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        int year = 0;
        validInput = false;
        do {
            try {
                year = readMinInt(scanner, "Payroll Year (>=2000): ", 2000);
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String startDate = "";
        validInput = false;
        do {
            try {
                startDate = readNonEmpty(scanner, "Payroll Start Date: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String endDate = "";
        validInput = false;
        do {
            try {
                endDate = readNonEmpty(scanner, "Payroll End Date: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        double transportAllowance = 0.0;
        validInput = false;
        do {
            try {
                transportAllowance = readNonNegativeDouble(scanner, "Transport Allowance (>=0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        double housingAllowance = 0.0;
        validInput = false;
        do {
            try {
                housingAllowance = readNonNegativeDouble(scanner, "Housing Allowance (>=0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        double payeTax = 0.0;
        validInput = false;
        do {
            try {
                payeTax = readNonNegativeDouble(scanner, "PAYE Tax (>=0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        double loanDeduction = 0.0;
        validInput = false;
        do {
            try {
                loanDeduction = readNonNegativeDouble(scanner, "Loan Deduction (>=0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        double overtimeHours = 0.0;
        validInput = false;
        do {
            try {
                overtimeHours = readNonNegativeDouble(scanner, "Overtime Hours (>=0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        double overtimeRate = 0.0;
        validInput = false;
        do {
            try {
                overtimeRate = readNonNegativeDouble(scanner, "Overtime Rate (>=0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        double bonus = 0.0;
        validInput = false;
        do {
            try {
                bonus = readNonNegativeDouble(scanner, "Bonus (>=0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String payslipNumber = "";
        validInput = false;
        do {
            try {
                payslipNumber = readNonEmpty(scanner, "Payslip Number: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String issueDate = "";
        validInput = false;
        do {
            try {
                issueDate = readNonEmpty(scanner, "Payslip Issue Date: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        return new Payslip(
                id,
                orgName,
                orgCode,
                rssbNumber,
                contactEmail,
                deptName,
                deptCode,
                managerName,
                employeeId,
                fullName,
                position,
                baseSalary,
                rssbRegistered,
                month,
                year,
                startDate,
                endDate,
                baseSalary,
                transportAllowance,
                housingAllowance,
                payeTax,
                loanDeduction,
                overtimeHours,
                overtimeRate,
                bonus,
                payslipNumber,
                issueDate
        );
    }

    private static String readNonEmpty(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String value = scanner.nextLine().trim();
        if (value.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be empty.");
        }
        return value;
    }

    private static int readPositiveInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        int value = Integer.parseInt(scanner.nextLine().trim());
        if (value <= 0) {
            throw new IllegalArgumentException("Value must be positive.");
        }
        return value;
    }

    private static int readMinInt(Scanner scanner, String prompt, int min) {
        System.out.print(prompt);
        int value = Integer.parseInt(scanner.nextLine().trim());
        if (value < min) {
            throw new IllegalArgumentException("Value must be >= " + min + ".");
        }
        return value;
    }

    private static double readPositiveDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        double value = Double.parseDouble(scanner.nextLine().trim());
        if (value <= 0) {
            throw new IllegalArgumentException("Value must be positive.");
        }
        return value;
    }

    private static double readNonNegativeDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        double value = Double.parseDouble(scanner.nextLine().trim());
        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be negative.");
        }
        return value;
    }

    private static int readMonth(Scanner scanner, String prompt) {
        int value = readPositiveInt(scanner, prompt);
        if (value < 1 || value > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12.");
        }
        return value;
    }

    private static boolean readBoolean(Scanner scanner, String prompt) {
        String value = readNonEmpty(scanner, prompt);
        if (!(value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false"))) {
            throw new IllegalArgumentException("Value must be true or false.");
        }
        return Boolean.parseBoolean(value);
    }

    private static String readMinCode(Scanner scanner, String prompt, int minLength) {
        String value = readNonEmpty(scanner, prompt);
        if (value.length() < minLength) {
            throw new IllegalArgumentException("Value must be at least " + minLength + " characters.");
        }
        return value;
    }

    private static String readDigits(Scanner scanner, String prompt, int length) {
        String digits = readNonEmpty(scanner, prompt);
        if (!digits.matches("\\d{" + length + "}")) {
            throw new IllegalArgumentException("Value must be exactly " + length + " digits.");
        }
        return digits;
    }

    private static String readEmail(Scanner scanner, String prompt) {
        String email = readNonEmpty(scanner, prompt);
        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email.");
        }
        return email;
    }
}

class Entity {
    private final int id;
    private final String createdDate;
    private String updatedDate;

    public Entity(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive.");
        }
        this.id = id;
        this.createdDate = java.time.LocalDateTime.now().toString();
        this.updatedDate = this.createdDate;
    }

    public int getId() {
        return id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        if (updatedDate == null || updatedDate.isBlank()) {
            throw new IllegalArgumentException("Updated date cannot be blank.");
        }
        this.updatedDate = updatedDate;
    }
}

class Organization extends Entity {
    private final String orgName;
    private final String orgCode;
    private final String rssbNumber;
    private final String contactEmail;

    public Organization(int id, String orgName, String orgCode, String rssbNumber, String contactEmail) {
        super(id);
        if (orgName == null || orgName.isBlank()) {
            throw new IllegalArgumentException("Organization name cannot be empty.");
        }
        if (orgCode == null || orgCode.length() < 3) {
            throw new IllegalArgumentException("Organization code must be at least 3 characters.");
        }
        if (rssbNumber == null || !rssbNumber.matches("\\d{8}")) {
            throw new IllegalArgumentException("RSSB number must be 8 digits.");
        }
        if (contactEmail == null || !contactEmail.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email.");
        }
        this.orgName = orgName;
        this.orgCode = orgCode;
        this.rssbNumber = rssbNumber;
        this.contactEmail = contactEmail;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public String getRssbNumber() {
        return rssbNumber;
    }

    public String getContactEmail() {
        return contactEmail;
    }
}

class Department extends Organization {
    private final String deptName;
    private final String deptCode;
    private final String managerName;

    public Department(int id, String orgName, String orgCode, String rssbNumber, String contactEmail,
                      String deptName, String deptCode, String managerName) {
        super(id, orgName, orgCode, rssbNumber, contactEmail);
        if (deptName == null || deptName.isBlank()) {
            throw new IllegalArgumentException("Department name cannot be empty.");
        }
        if (deptCode == null || deptCode.length() < 3) {
            throw new IllegalArgumentException("Department code must be at least 3 characters.");
        }
        if (managerName == null || managerName.isBlank()) {
            throw new IllegalArgumentException("Manager name cannot be empty.");
        }
        this.deptName = deptName;
        this.deptCode = deptCode;
        this.managerName = managerName;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public String getManagerName() {
        return managerName;
    }
}

class Employee extends Department {
    private final int employeeId;
    private final String fullName;
    private final String position;
    private final double baseSalary;
    private final boolean rssbRegistered;

    public Employee(int id, String orgName, String orgCode, String rssbNumber, String contactEmail,
                    String deptName, String deptCode, String managerName,
                    int employeeId, String fullName, String position,
                    double baseSalary, boolean rssbRegistered) {
        super(id, orgName, orgCode, rssbNumber, contactEmail, deptName, deptCode, managerName);
        if (employeeId < 1000) {
            throw new IllegalArgumentException("Employee ID must be >= 1000.");
        }
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Full name cannot be empty.");
        }
        if (position == null || position.isBlank()) {
            throw new IllegalArgumentException("Position cannot be empty.");
        }
        if (baseSalary <= 0) {
            throw new IllegalArgumentException("Base salary must be > 0.");
        }
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.position = position;
        this.baseSalary = baseSalary;
        this.rssbRegistered = rssbRegistered;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public boolean isRssbRegistered() {
        return rssbRegistered;
    }
}

class PayrollPeriod extends Employee {
    private final int month;
    private final int year;
    private final String startDate;
    private final String endDate;

    public PayrollPeriod(int id, String orgName, String orgCode, String rssbNumber, String contactEmail,
                         String deptName, String deptCode, String managerName,
                         int employeeId, String fullName, String position,
                         double baseSalary, boolean rssbRegistered,
                         int month, int year, String startDate, String endDate) {
        super(id, orgName, orgCode, rssbNumber, contactEmail, deptName, deptCode, managerName,
                employeeId, fullName, position, baseSalary, rssbRegistered);
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12.");
        }
        if (year < 2000) {
            throw new IllegalArgumentException("Year must be >= 2000.");
        }
        if (startDate == null || startDate.isBlank() || endDate == null || endDate.isBlank()) {
            throw new IllegalArgumentException("Dates cannot be empty.");
        }
        this.month = month;
        this.year = year;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}

class SalaryStructure extends PayrollPeriod {
    private final double basicPay;
    private final double transportAllowance;
    private final double housingAllowance;

    public SalaryStructure(int id, String orgName, String orgCode, String rssbNumber, String contactEmail,
                           String deptName, String deptCode, String managerName,
                           int employeeId, String fullName, String position,
                           double baseSalary, boolean rssbRegistered,
                           int month, int year, String startDate, String endDate,
                           double basicPay, double transportAllowance, double housingAllowance) {
        super(id, orgName, orgCode, rssbNumber, contactEmail,
                deptName, deptCode, managerName,
                employeeId, fullName, position, baseSalary, rssbRegistered,
                month, year, startDate, endDate);
        if (basicPay < 0 || transportAllowance < 0 || housingAllowance < 0) {
            throw new IllegalArgumentException("Salary components cannot be negative.");
        }
        this.basicPay = basicPay;
        this.transportAllowance = transportAllowance;
        this.housingAllowance = housingAllowance;
    }

    public double getBasicPay() {
        return basicPay;
    }

    public double getTransportAllowance() {
        return transportAllowance;
    }

    public double getHousingAllowance() {
        return housingAllowance;
    }
}

class Deduction extends SalaryStructure {
    private final double rssbContribution;
    private final double payeTax;
    private final double loanDeduction;

    public Deduction(int id, String orgName, String orgCode, String rssbNumber, String contactEmail,
                     String deptName, String deptCode, String managerName,
                     int employeeId, String fullName, String position,
                     double baseSalary, boolean rssbRegistered,
                     int month, int year, String startDate, String endDate,
                     double basicPay, double transportAllowance, double housingAllowance,
                     double payeTax, double loanDeduction) {
        super(id, orgName, orgCode, rssbNumber, contactEmail,
                deptName, deptCode, managerName,
                employeeId, fullName, position, baseSalary, rssbRegistered,
                month, year, startDate, endDate,
                basicPay, transportAllowance, housingAllowance);
        if (payeTax < 0 || loanDeduction < 0) {
            throw new IllegalArgumentException("Deductions cannot be negative.");
        }
        double expectedRssb = basicPay * 0.05;
        this.rssbContribution = Math.round(expectedRssb * 100.0) / 100.0;
        this.payeTax = payeTax;
        this.loanDeduction = loanDeduction;
    }

    public double getRssbContribution() {
        return rssbContribution;
    }

    public double getPayeTax() {
        return payeTax;
    }

    public double getLoanDeduction() {
        return loanDeduction;
    }
}

class Allowance extends Deduction {
    private final double overtimeHours;
    private final double overtimeRate;
    private final double bonus;

    public Allowance(int id, String orgName, String orgCode, String rssbNumber, String contactEmail,
                     String deptName, String deptCode, String managerName,
                     int employeeId, String fullName, String position,
                     double baseSalary, boolean rssbRegistered,
                     int month, int year, String startDate, String endDate,
                     double basicPay, double transportAllowance, double housingAllowance,
                     double payeTax, double loanDeduction,
                     double overtimeHours, double overtimeRate, double bonus) {
        super(id, orgName, orgCode, rssbNumber, contactEmail,
                deptName, deptCode, managerName,
                employeeId, fullName, position, baseSalary, rssbRegistered,
                month, year, startDate, endDate,
                basicPay, transportAllowance, housingAllowance,
                payeTax, loanDeduction);
        if (overtimeHours < 0 || overtimeRate < 0 || bonus < 0) {
            throw new IllegalArgumentException("Allowance values cannot be negative.");
        }
        this.overtimeHours = overtimeHours;
        this.overtimeRate = overtimeRate;
        this.bonus = bonus;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public double getOvertimeRate() {
        return overtimeRate;
    }

    public double getBonus() {
        return bonus;
    }

    public double getOvertimePay() {
        return overtimeHours * overtimeRate;
    }
}

class Payroll extends Allowance {
    private final double grossSalary;
    private final double totalDeductions;
    private final double netSalary;

    public Payroll(int id, String orgName, String orgCode, String rssbNumber, String contactEmail,
                   String deptName, String deptCode, String managerName,
                   int employeeId, String fullName, String position,
                   double baseSalary, boolean rssbRegistered,
                   int month, int year, String startDate, String endDate,
                   double basicPay, double transportAllowance, double housingAllowance,
                   double payeTax, double loanDeduction,
                   double overtimeHours, double overtimeRate, double bonus) {
        super(id, orgName, orgCode, rssbNumber, contactEmail,
                deptName, deptCode, managerName,
                employeeId, fullName, position, baseSalary, rssbRegistered,
                month, year, startDate, endDate,
                basicPay, transportAllowance, housingAllowance,
                payeTax, loanDeduction,
                overtimeHours, overtimeRate, bonus);
        double allowances = getTransportAllowance() + getHousingAllowance() + getOvertimePay() + bonus;
        this.grossSalary = getBasicPay() + allowances;
        this.totalDeductions = getRssbContribution() + getPayeTax() + getLoanDeduction();
        this.netSalary = grossSalary - totalDeductions;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public double getTotalDeductions() {
        return totalDeductions;
    }

    public double getNetSalary() {
        return netSalary;
    }
}

final class Payslip extends Payroll {
    private final String payslipNumber;
    private final String issueDate;

    public Payslip(int id, String orgName, String orgCode, String rssbNumber, String contactEmail,
                   String deptName, String deptCode, String managerName,
                   int employeeId, String fullName, String position,
                   double baseSalary, boolean rssbRegistered,
                   int month, int year, String startDate, String endDate,
                   double basicPay, double transportAllowance, double housingAllowance,
                   double payeTax, double loanDeduction,
                   double overtimeHours, double overtimeRate, double bonus,
                   String payslipNumber, String issueDate) {
        super(id, orgName, orgCode, rssbNumber, contactEmail,
                deptName, deptCode, managerName,
                employeeId, fullName, position, baseSalary, rssbRegistered,
                month, year, startDate, endDate,
                basicPay, transportAllowance, housingAllowance,
                payeTax, loanDeduction,
                overtimeHours, overtimeRate, bonus);
        if (payslipNumber == null || payslipNumber.isBlank()) {
            throw new IllegalArgumentException("Payslip number cannot be empty.");
        }
        if (issueDate == null || issueDate.isBlank()) {
            throw new IllegalArgumentException("Issue date cannot be empty.");
        }
        this.payslipNumber = payslipNumber;
        this.issueDate = issueDate;
    }

    public void generatePayslip() {
        System.out.printf("Payslip #: %s | Issue Date: %s%n", payslipNumber, issueDate);
        System.out.printf("Organization: %s (%s) RSSB: %s Email: %s%n",
                getOrgName(), getOrgCode(), getRssbNumber(), getContactEmail());
        System.out.printf("Department: %s [%s] | Manager: %s%n", getDeptName(), getDeptCode(), getManagerName());
        System.out.printf("Employee: %s (ID: %d) | Position: %s | RSSB Registered: %s%n",
                getFullName(), getEmployeeId(), getPosition(), isRssbRegistered());
        System.out.printf("Payroll Period: %02d/%d (%s to %s)%n", getMonth(), getYear(), getStartDate(), getEndDate());
        System.out.printf("Basic Pay: %.2f%n", getBasicPay());
        System.out.printf("Allowances -> Transport: %.2f, Housing: %.2f, Overtime Pay: %.2f, Bonus: %.2f%n",
                getTransportAllowance(), getHousingAllowance(), getOvertimePay(), getBonus());
        System.out.printf("Deductions -> RSSB (5%%): %.2f, PAYE: %.2f, Loan: %.2f%n",
                getRssbContribution(), getPayeTax(), getLoanDeduction());
        System.out.printf("Gross Salary: %.2f%n", getGrossSalary());
        System.out.printf("Total Deductions: %.2f%n", getTotalDeductions());
        System.out.printf("Net Salary: %.2f%n", getNetSalary());
        System.out.println("Student ID: 27476");
    }
}

