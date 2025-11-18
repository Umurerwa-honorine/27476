package question3;

import java.util.Locale;
import java.util.Scanner;

public class Question3App {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Tax Administration System ===");
            TaxRecord record = buildRecord(scanner);
            System.out.println("\n--- Tax Record Summary ---");
            record.printRecord();
        } catch (TaxDataException ex) {
            System.out.println("Tax data error: " + ex.getMessage());
        }
    }

    private static TaxRecord buildRecord(Scanner scanner) {
        int id = 0;
        boolean validInput = false;
        do {
            try {
                id = readPositiveInt(scanner, "Entity ID (>0): ");
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String authorityName = "";
        validInput = false;
        do {
            try {
                authorityName = readNonEmpty(scanner, "Tax Authority Name: ");
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String region = "";
        validInput = false;
        do {
            try {
                region = readNonEmpty(scanner, "Authority Region: ");
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String authorityEmail = "";
        validInput = false;
        do {
            try {
                authorityEmail = readEmail(scanner, "Authority Email: ");
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String categoryName = "";
        validInput = false;
        do {
            try {
                categoryName = readNonEmpty(scanner, "Tax Category Name: ");
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        double rate = 0.0;
        validInput = false;
        do {
            try {
                rate = readPositiveDouble(scanner, "Tax Rate (% >0): ") / 100.0;
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String categoryCode = "";
        validInput = false;
        do {
            try {
                categoryCode = readMinCode(scanner, "Tax Category Code (>=3 chars): ", 3);
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String tin = "";
        validInput = false;
        do {
            try {
                tin = readDigits(scanner, "Taxpayer TIN (9 digits): ", 9);
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String taxpayerName = "";
        validInput = false;
        do {
            try {
                taxpayerName = readNonEmpty(scanner, "Taxpayer Name: ");
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String address = "";
        validInput = false;
        do {
            try {
                address = readNonEmpty(scanner, "Taxpayer Address: ");
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String employerName = "";
        validInput = false;
        do {
            try {
                employerName = readNonEmpty(scanner, "Employer Name: ");
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String employerTin = "";
        validInput = false;
        do {
            try {
                employerTin = readDigits(scanner, "Employer TIN (9 digits): ", 9);
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String employerContact = "";
        validInput = false;
        do {
            try {
                employerContact = readDigits(scanner, "Employer Phone (10 digits): ", 10);
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String employeeName = "";
        validInput = false;
        do {
            try {
                employeeName = readNonEmpty(scanner, "Employee Name: ");
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        double salary = 0.0;
        validInput = false;
        do {
            try {
                salary = readPositiveDouble(scanner, "Employee Salary (>0): ");
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String employeeTin = "";
        validInput = false;
        do {
            try {
                employeeTin = readDigits(scanner, "Employee TIN (9 digits): ", 9);
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String declarationMonth = "";
        validInput = false;
        do {
            try {
                declarationMonth = readNonEmpty(scanner, "Declaration Month: ");
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        double totalIncome = 0.0;
        validInput = false;
        do {
            try {
                totalIncome = readNonNegativeDouble(scanner, "Total Income (>=0): ");
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String assessmentDate = "";
        validInput = false;
        do {
            try {
                assessmentDate = readNonEmpty(scanner, "Assessment Date: ");
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        double assessedTax = 0.0;
        validInput = false;
        do {
            try {
                assessedTax = readNonNegativeDouble(scanner, "Assessed Tax (>=0): ");
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String paymentDate = "";
        validInput = false;
        do {
            try {
                paymentDate = readNonEmpty(scanner, "Payment Date: ");
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        double paymentAmount = 0.0;
        validInput = false;
        do {
            try {
                paymentAmount = readPositiveDouble(scanner, "Payment Amount (>0): ");
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String receiptNo = "";
        validInput = false;
        do {
            try {
                receiptNo = readNonEmpty(scanner, "Receipt Number: ");
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        double credits = 0.0;
        validInput = false;
        do {
            try {
                credits = readNonNegativeDouble(scanner, "Credits/Deductions (>=0): ");
                validInput = true;
            } catch (TaxDataException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        return new TaxRecord(
                id,
                authorityName,
                region,
                authorityEmail,
                categoryName,
                rate,
                categoryCode,
                tin,
                taxpayerName,
                address,
                employerName,
                employerTin,
                employerContact,
                employeeName,
                salary,
                employeeTin,
                declarationMonth,
                totalIncome,
                assessmentDate,
                assessedTax,
                paymentDate,
                paymentAmount,
                receiptNo,
                credits
        );
    }

    private static String readNonEmpty(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String value = scanner.nextLine().trim();
        if (value.isEmpty()) {
            throw new TaxDataException("Value cannot be empty.");
        }
        return value;
    }

    private static int readPositiveInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        int value = Integer.parseInt(scanner.nextLine().trim());
        if (value <= 0) {
            throw new TaxDataException("Value must be positive.");
        }
        return value;
    }

    private static double readPositiveDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        double value = Double.parseDouble(scanner.nextLine().trim());
        if (value <= 0) {
            throw new TaxDataException("Value must be positive.");
        }
        return value;
    }

    private static double readNonNegativeDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        double value = Double.parseDouble(scanner.nextLine().trim());
        if (value < 0) {
            throw new TaxDataException("Value cannot be negative.");
        }
        return value;
    }

    private static String readDigits(Scanner scanner, String prompt, int length) {
        String value = readNonEmpty(scanner, prompt);
        if (!value.matches("\\d{" + length + "}")) {
            throw new TaxDataException("Value must be exactly " + length + " digits.");
        }
        return value;
    }

    private static String readEmail(Scanner scanner, String prompt) {
        String email = readNonEmpty(scanner, prompt);
        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) {
            throw new TaxDataException("Invalid email format.");
        }
        return email;
    }

    private static String readMinCode(Scanner scanner, String prompt, int minLength) {
        String code = readNonEmpty(scanner, prompt);
        if (code.length() < minLength) {
            throw new TaxDataException("Code must be at least " + minLength + " characters.");
        }
        return code;
    }
}

class TaxDataException extends RuntimeException {
    public TaxDataException(String message) {
        super(message);
    }
}

class Entity {
    private final int id;
    private final String createdDate;
    private String updatedDate;

    public Entity(int id) {
        if (id <= 0) {
            throw new TaxDataException("ID must be positive.");
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
            throw new TaxDataException("Updated date cannot be blank.");
        }
        this.updatedDate = updatedDate;
    }
}

class TaxAuthority extends Entity {
    private final String authorityName;
    private final String region;
    private final String email;

    public TaxAuthority(int id, String authorityName, String region, String email) {
        super(id);
        if (authorityName == null || authorityName.isBlank()) {
            throw new TaxDataException("Authority name cannot be empty.");
        }
        if (region == null || region.isBlank()) {
            throw new TaxDataException("Region cannot be empty.");
        }
        if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) {
            throw new TaxDataException("Invalid authority email.");
        }
        this.authorityName = authorityName;
        this.region = region;
        this.email = email;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public String getRegion() {
        return region;
    }

    public String getEmail() {
        return email;
    }
}

class TaxCategory extends TaxAuthority {
    private final String categoryName;
    private final double rate;
    private final String code;

    public TaxCategory(int id, String authorityName, String region, String email,
                       String categoryName, double rate, String code) {
        super(id, authorityName, region, email);
        if (categoryName == null || categoryName.isBlank()) {
            throw new TaxDataException("Category name cannot be empty.");
        }
        if (rate <= 0) {
            throw new TaxDataException("Rate must be > 0.");
        }
        if (code == null || code.length() < 3) {
            throw new TaxDataException("Category code must be at least 3 characters.");
        }
        this.categoryName = categoryName;
        this.rate = rate;
        this.code = code;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public double getRate() {
        return rate;
    }

    public String getCode() {
        return code;
    }
}

class Taxpayer extends TaxCategory {
    private final String tin;
    private final String taxpayerName;
    private final String address;

    public Taxpayer(int id, String authorityName, String region, String email,
                    String categoryName, double rate, String code,
                    String tin, String taxpayerName, String address) {
        super(id, authorityName, region, email, categoryName, rate, code);
        if (tin == null || !tin.matches("\\d{9}")) {
            throw new TaxDataException("Taxpayer TIN must be 9 digits.");
        }
        if (taxpayerName == null || taxpayerName.isBlank()) {
            throw new TaxDataException("Taxpayer name cannot be empty.");
        }
        if (address == null || address.isBlank()) {
            throw new TaxDataException("Address cannot be empty.");
        }
        this.tin = tin;
        this.taxpayerName = taxpayerName;
        this.address = address;
    }

    public String getTin() {
        return tin;
    }

    public String getTaxpayerName() {
        return taxpayerName;
    }

    public String getAddress() {
        return address;
    }
}

class Employer extends Taxpayer {
    private final String employerName;
    private final String employerTin;
    private final String contact;

    public Employer(int id, String authorityName, String region, String email,
                    String categoryName, double rate, String code,
                    String tin, String taxpayerName, String address,
                    String employerName, String employerTin, String contact) {
        super(id, authorityName, region, email, categoryName, rate, code,
                tin, taxpayerName, address);
        if (employerName == null || employerName.isBlank()) {
            throw new TaxDataException("Employer name cannot be empty.");
        }
        if (employerTin == null || !employerTin.matches("\\d{9}")) {
            throw new TaxDataException("Employer TIN must be 9 digits.");
        }
        if (contact == null || !contact.matches("\\d{10}")) {
            throw new TaxDataException("Employer contact must be 10 digits.");
        }
        this.employerName = employerName;
        this.employerTin = employerTin;
        this.contact = contact;
    }

    public String getEmployerName() {
        return employerName;
    }

    public String getEmployerTin() {
        return employerTin;
    }

    public String getContact() {
        return contact;
    }
}

class Employee extends Employer {
    private final String employeeName;
    private final double salary;
    private final String employeeTin;

    public Employee(int id, String authorityName, String region, String email,
                    String categoryName, double rate, String code,
                    String tin, String taxpayerName, String address,
                    String employerName, String employerTin, String contact,
                    String employeeName, double salary, String employeeTin) {
        super(id, authorityName, region, email, categoryName, rate, code,
                tin, taxpayerName, address, employerName, employerTin, contact);
        if (employeeName == null || employeeName.isBlank()) {
            throw new TaxDataException("Employee name cannot be empty.");
        }
        if (salary <= 0) {
            throw new TaxDataException("Salary must be > 0.");
        }
        if (employeeTin == null || !employeeTin.matches("\\d{9}")) {
            throw new TaxDataException("Employee TIN must be 9 digits.");
        }
        this.employeeName = employeeName;
        this.salary = salary;
        this.employeeTin = employeeTin;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmployeeTin() {
        return employeeTin;
    }
}

class TaxDeclaration extends Employee {
    private final String declarationMonth;
    private final double totalIncome;

    public TaxDeclaration(int id, String authorityName, String region, String email,
                          String categoryName, double rate, String code,
                          String tin, String taxpayerName, String address,
                          String employerName, String employerTin, String contact,
                          String employeeName, double salary, String employeeTin,
                          String declarationMonth, double totalIncome) {
        super(id, authorityName, region, email, categoryName, rate, code,
                tin, taxpayerName, address, employerName, employerTin, contact,
                employeeName, salary, employeeTin);
        if (declarationMonth == null || declarationMonth.isBlank()) {
            throw new TaxDataException("Declaration month cannot be empty.");
        }
        if (totalIncome < 0) {
            throw new TaxDataException("Total income cannot be negative.");
        }
        this.declarationMonth = declarationMonth;
        this.totalIncome = totalIncome;
    }

    public String getDeclarationMonth() {
        return declarationMonth;
    }

    public double getTotalIncome() {
        return totalIncome;
    }
}

class TaxAssessment extends TaxDeclaration {
    private final String assessmentDate;
    private final double assessedTax;

    public TaxAssessment(int id, String authorityName, String region, String email,
                         String categoryName, double rate, String code,
                         String tin, String taxpayerName, String address,
                         String employerName, String employerTin, String contact,
                         String employeeName, double salary, String employeeTin,
                         String declarationMonth, double totalIncome,
                         String assessmentDate, double assessedTax) {
        super(id, authorityName, region, email, categoryName, rate, code,
                tin, taxpayerName, address, employerName, employerTin, contact,
                employeeName, salary, employeeTin, declarationMonth, totalIncome);
        if (assessmentDate == null || assessmentDate.isBlank()) {
            throw new TaxDataException("Assessment date cannot be empty.");
        }
        if (assessedTax < 0) {
            throw new TaxDataException("Assessed tax cannot be negative.");
        }
        this.assessmentDate = assessmentDate;
        this.assessedTax = assessedTax;
    }

    public String getAssessmentDate() {
        return assessmentDate;
    }

    public double getAssessedTax() {
        return assessedTax;
    }
}

class Payment extends TaxAssessment {
    private final String paymentDate;
    private final double paymentAmount;

    public Payment(int id, String authorityName, String region, String email,
                   String categoryName, double rate, String code,
                   String tin, String taxpayerName, String address,
                   String employerName, String employerTin, String contact,
                   String employeeName, double salary, String employeeTin,
                   String declarationMonth, double totalIncome,
                   String assessmentDate, double assessedTax,
                   String paymentDate, double paymentAmount) {
        super(id, authorityName, region, email, categoryName, rate, code,
                tin, taxpayerName, address, employerName, employerTin, contact,
                employeeName, salary, employeeTin, declarationMonth, totalIncome,
                assessmentDate, assessedTax);
        if (paymentDate == null || paymentDate.isBlank()) {
            throw new TaxDataException("Payment date cannot be empty.");
        }
        if (paymentAmount <= 0) {
            throw new TaxDataException("Payment amount must be > 0.");
        }
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }
}

final class TaxRecord extends Payment {
    private final String receiptNo;
    private final double credits;
    private final double totalTax;

    public TaxRecord(int id, String authorityName, String region, String email,
                     String categoryName, double rate, String code,
                     String tin, String taxpayerName, String address,
                     String employerName, String employerTin, String contact,
                     String employeeName, double salary, String employeeTin,
                     String declarationMonth, double totalIncome,
                     String assessmentDate, double assessedTax,
                     String paymentDate, double paymentAmount,
                     String receiptNo, double credits) {
        super(id, authorityName, region, email, categoryName, rate, code,
                tin, taxpayerName, address, employerName, employerTin, contact,
                employeeName, salary, employeeTin, declarationMonth, totalIncome,
                assessmentDate, assessedTax, paymentDate, paymentAmount);
        if (receiptNo == null || receiptNo.isBlank()) {
            throw new TaxDataException("Receipt number cannot be empty.");
        }
        if (credits < 0) {
            throw new TaxDataException("Credits cannot be negative.");
        }
        this.receiptNo = receiptNo;
        this.credits = credits;
        this.totalTax = computeTax();
    }

    public double computeTax() {
        double computed = (getSalary() * getRate()) - credits;
        return Math.max(0, computed);
    }

    public void printRecord() {
        System.out.printf("Receipt: %s | Entity ID: %d%n", receiptNo, getId());
        System.out.printf("Authority: %s (%s) Email: %s%n", getAuthorityName(), getRegion(), getEmail());
        System.out.printf("Category: %s [%s] Rate: %.2f%%%n", getCategoryName(), getCode(), getRate() * 100);
        System.out.printf("Taxpayer: %s | TIN: %s | Address: %s%n", getTaxpayerName(), getTin(), getAddress());
        System.out.printf("Employer: %s | TIN: %s | Contact: %s%n", getEmployerName(), getEmployerTin(), getContact());
        System.out.printf("Employee: %s | TIN: %s | Salary: %.2f%n", getEmployeeName(), getEmployeeTin(), getSalary());
        System.out.printf("Declaration: %s | Income: %.2f%n", getDeclarationMonth(), getTotalIncome());
        System.out.printf("Assessment: %s | Tax: %.2f%n", getAssessmentDate(), getAssessedTax());
        System.out.printf("Payment: %s | Amount Paid: %.2f%n", getPaymentDate(), getPaymentAmount());
        System.out.printf("Credits: %.2f | Total Tax Due: %.2f%n", credits, totalTax);
        System.out.println("Student ID: 27476");
    }
}

