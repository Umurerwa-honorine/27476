package question4;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Question4App {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Procurement Management System ===");
            ProcurementReport report = buildReport(scanner);
            System.out.println("\n--- Procurement Report ---");
            report.printReport();
        } catch (IllegalArgumentException ex) {
            System.out.println("Validation error: " + ex.getMessage());
        }
    }

    private static ProcurementReport buildReport(Scanner scanner) {
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

        String orgAddress = "";
        validInput = false;
        do {
            try {
                orgAddress = readNonEmpty(scanner, "Organization Address: ");
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
                rssbNumber = readDigits(scanner, "RSSB Number (8 digits acceptable for organization context): ", 8);
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
                deptCode = readMinAlphanumeric(scanner, "Department Code (>=3 alphanumeric): ", 3);
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String supplierName = "";
        validInput = false;
        do {
            try {
                supplierName = readNonEmpty(scanner, "Supplier Name: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String supplierTin = "";
        validInput = false;
        do {
            try {
                supplierTin = readDigits(scanner, "Supplier TIN (9 digits): ", 9);
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String supplierContact = "";
        validInput = false;
        do {
            try {
                supplierContact = readFixedDigits(scanner, "Supplier Phone (10 digits): ", 10);
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String productName = "";
        validInput = false;
        do {
            try {
                productName = readNonEmpty(scanner, "Product Name: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        double unitPrice = 0.0;
        validInput = false;
        do {
            try {
                unitPrice = readPositiveDouble(scanner, "Unit Price (>0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        int quantity = 0;
        validInput = false;
        do {
            try {
                quantity = readNonNegativeInt(scanner, "Quantity (>=0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String poNumber = "";
        validInput = false;
        do {
            try {
                poNumber = readNonEmpty(scanner, "Purchase Order Number: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String orderDate = "";
        validInput = false;
        do {
            try {
                orderDate = readNonEmpty(scanner, "Order Date: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        double totalAmount = 0.0;
        validInput = false;
        do {
            try {
                totalAmount = readPositiveDouble(scanner, "Purchase Order Total (>0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String deliveryDate = "";
        validInput = false;
        do {
            try {
                deliveryDate = readNonEmpty(scanner, "Delivery Date: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String deliveredBy = "";
        validInput = false;
        do {
            try {
                deliveredBy = readNonEmpty(scanner, "Delivered By: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String inspectorName = "";
        validInput = false;
        do {
            try {
                inspectorName = readNonEmpty(scanner, "Inspector Name: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String status = "";
        validInput = false;
        do {
            try {
                status = readStatus(scanner, "Inspection Status (Passed/Failed): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String remarks = "";
        validInput = false;
        do {
            try {
                remarks = readNonEmpty(scanner, "Inspection Remarks: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        int invoiceCount = 0;
        validInput = false;
        do {
            try {
                invoiceCount = readPositiveInt(scanner, "Number of invoices (>=1): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        List<String> invoiceNos = new ArrayList<>();
        List<Double> invoiceAmounts = new ArrayList<>();
        for (int i = 1; i <= invoiceCount; i++) {
            String invoiceNo = "";
            validInput = false;
            do {
                try {
                    invoiceNo = readNonEmpty(scanner, "Invoice " + i + " Number: ");
                    validInput = true;
                } catch (IllegalArgumentException ex) {
                    System.out.println("Error: " + ex.getMessage() + " Please try again.");
                }
            } while (!validInput);

            double invoiceAmount = 0.0;
            validInput = false;
            do {
                try {
                    invoiceAmount = readPositiveDouble(scanner, "Invoice " + i + " Amount (>0): ");
                    validInput = true;
                } catch (IllegalArgumentException ex) {
                    System.out.println("Error: " + ex.getMessage() + " Please try again.");
                }
            } while (!validInput);
            invoiceNos.add(invoiceNo);
            invoiceAmounts.add(invoiceAmount);
        }

        String reportDate = "";
        validInput = false;
        do {
            try {
                reportDate = readNonEmpty(scanner, "Report Date: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String summary = "";
        validInput = false;
        do {
            try {
                summary = readNonEmpty(scanner, "Report Summary: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        return new ProcurementReport(
                id,
                orgName,
                orgAddress,
                contactEmail,
                orgCode,
                rssbNumber,
                deptName,
                deptCode,
                supplierName,
                supplierTin,
                supplierContact,
                productName,
                unitPrice,
                quantity,
                poNumber,
                orderDate,
                totalAmount,
                deliveryDate,
                deliveredBy,
                inspectorName,
                status,
                remarks,
                invoiceNos,
                invoiceAmounts,
                reportDate,
                summary
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

    private static int readNonNegativeInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        int value = Integer.parseInt(scanner.nextLine().trim());
        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be negative.");
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

    private static String readEmail(Scanner scanner, String prompt) {
        String email = readNonEmpty(scanner, prompt);
        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        return email;
    }

    private static String readDigits(Scanner scanner, String prompt, int length) {
        String digits = readNonEmpty(scanner, prompt);
        if (!digits.matches("\\d{" + length + "}")) {
            throw new IllegalArgumentException("Value must be exactly " + length + " digits.");
        }
        return digits;
    }

    private static String readFixedDigits(Scanner scanner, String prompt, int length) {
        return readDigits(scanner, prompt, length);
    }

    private static String readMinCode(Scanner scanner, String prompt, int min) {
        String value = readNonEmpty(scanner, prompt);
        if (value.length() < min) {
            throw new IllegalArgumentException("Value must be at least " + min + " characters.");
        }
        return value;
    }

    private static String readMinAlphanumeric(Scanner scanner, String prompt, int min) {
        String value = readNonEmpty(scanner, prompt);
        if (value.length() < min || !value.matches("[A-Za-z0-9]+")) {
            throw new IllegalArgumentException("Value must be alphanumeric with at least " + min + " characters.");
        }
        return value;
    }

    private static String readStatus(Scanner scanner, String prompt) {
        String status = readNonEmpty(scanner, prompt);
        if (!(status.equalsIgnoreCase("Passed") || status.equalsIgnoreCase("Failed"))) {
            throw new IllegalArgumentException("Status must be Passed or Failed.");
        }
        return status.substring(0, 1).toUpperCase(Locale.ROOT) + status.substring(1).toLowerCase(Locale.ROOT);
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
    private final String address;
    private final String contactEmail;
    private final String orgCode;
    private final String rssbNumber;

    public Organization(int id, String orgName, String address, String contactEmail,
                        String orgCode, String rssbNumber) {
        super(id);
        if (orgName == null || orgName.isBlank()) {
            throw new IllegalArgumentException("Organization name cannot be empty.");
        }
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address cannot be empty.");
        }
        if (contactEmail == null || !contactEmail.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email.");
        }
        if (orgCode == null || orgCode.length() < 3) {
            throw new IllegalArgumentException("Org code must be at least 3 characters.");
        }
        if (rssbNumber == null || !rssbNumber.matches("\\d{8}")) {
            throw new IllegalArgumentException("RSSB number must be 8 digits.");
        }
        this.orgName = orgName;
        this.address = address;
        this.contactEmail = contactEmail;
        this.orgCode = orgCode;
        this.rssbNumber = rssbNumber;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getAddress() {
        return address;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public String getRssbNumber() {
        return rssbNumber;
    }
}

class Department extends Organization {
    private final String deptName;
    private final String deptCode;

    public Department(int id, String orgName, String address, String contactEmail,
                      String orgCode, String rssbNumber,
                      String deptName, String deptCode) {
        super(id, orgName, address, contactEmail, orgCode, rssbNumber);
        if (deptName == null || deptName.isBlank()) {
            throw new IllegalArgumentException("Department name cannot be empty.");
        }
        if (deptCode == null || deptCode.length() < 3 || !deptCode.matches("[A-Za-z0-9]+")) {
            throw new IllegalArgumentException("Department code must be alphanumeric and >= 3 chars.");
        }
        this.deptName = deptName;
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getDeptCode() {
        return deptCode;
    }
}

class Supplier extends Department {
    private final String supplierName;
    private final String supplierTin;
    private final String contact;

    public Supplier(int id, String orgName, String address, String contactEmail,
                    String orgCode, String rssbNumber,
                    String deptName, String deptCode,
                    String supplierName, String supplierTin, String contact) {
        super(id, orgName, address, contactEmail, orgCode, rssbNumber, deptName, deptCode);
        if (supplierName == null || supplierName.isBlank()) {
            throw new IllegalArgumentException("Supplier name cannot be empty.");
        }
        if (supplierTin == null || !supplierTin.matches("\\d{9}")) {
            throw new IllegalArgumentException("Supplier TIN must be 9 digits.");
        }
        if (contact == null || !contact.matches("\\d{10}")) {
            throw new IllegalArgumentException("Supplier contact must be 10 digits.");
        }
        this.supplierName = supplierName;
        this.supplierTin = supplierTin;
        this.contact = contact;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierTin() {
        return supplierTin;
    }

    public String getContact() {
        return contact;
    }
}

class Product extends Supplier {
    private final String productName;
    private final double unitPrice;
    private final int quantity;

    public Product(int id, String orgName, String address, String contactEmail,
                   String orgCode, String rssbNumber,
                   String deptName, String deptCode,
                   String supplierName, String supplierTin, String contact,
                   String productName, double unitPrice, int quantity) {
        super(id, orgName, address, contactEmail, orgCode, rssbNumber,
                deptName, deptCode, supplierName, supplierTin, contact);
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }
        if (unitPrice <= 0) {
            throw new IllegalArgumentException("Unit price must be > 0.");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }
}

class PurchaseOrder extends Product {
    private final String poNumber;
    private final String orderDate;
    private final double totalAmount;

    public PurchaseOrder(int id, String orgName, String address, String contactEmail,
                         String orgCode, String rssbNumber,
                         String deptName, String deptCode,
                         String supplierName, String supplierTin, String contact,
                         String productName, double unitPrice, int quantity,
                         String poNumber, String orderDate, double totalAmount) {
        super(id, orgName, address, contactEmail, orgCode, rssbNumber,
                deptName, deptCode, supplierName, supplierTin, contact,
                productName, unitPrice, quantity);
        if (poNumber == null || poNumber.isBlank()) {
            throw new IllegalArgumentException("PO number cannot be empty.");
        }
        if (orderDate == null || orderDate.isBlank()) {
            throw new IllegalArgumentException("Order date cannot be empty.");
        }
        if (totalAmount <= 0) {
            throw new IllegalArgumentException("Total amount must be > 0.");
        }
        this.poNumber = poNumber;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}

class Delivery extends PurchaseOrder {
    private final String deliveryDate;
    private final String deliveredBy;

    public Delivery(int id, String orgName, String address, String contactEmail,
                    String orgCode, String rssbNumber,
                    String deptName, String deptCode,
                    String supplierName, String supplierTin, String contact,
                    String productName, double unitPrice, int quantity,
                    String poNumber, String orderDate, double totalAmount,
                    String deliveryDate, String deliveredBy) {
        super(id, orgName, address, contactEmail, orgCode, rssbNumber,
                deptName, deptCode, supplierName, supplierTin, contact,
                productName, unitPrice, quantity, poNumber, orderDate, totalAmount);
        if (deliveryDate == null || deliveryDate.isBlank()) {
            throw new IllegalArgumentException("Delivery date cannot be empty.");
        }
        if (deliveredBy == null || deliveredBy.isBlank()) {
            throw new IllegalArgumentException("Delivered by cannot be empty.");
        }
        this.deliveryDate = deliveryDate;
        this.deliveredBy = deliveredBy;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getDeliveredBy() {
        return deliveredBy;
    }
}

class Inspection extends Delivery {
    private final String inspectorName;
    private final String status;
    private final String remarks;

    public Inspection(int id, String orgName, String address, String contactEmail,
                      String orgCode, String rssbNumber,
                      String deptName, String deptCode,
                      String supplierName, String supplierTin, String contact,
                      String productName, double unitPrice, int quantity,
                      String poNumber, String orderDate, double totalAmount,
                      String deliveryDate, String deliveredBy,
                      String inspectorName, String status, String remarks) {
        super(id, orgName, address, contactEmail, orgCode, rssbNumber,
                deptName, deptCode, supplierName, supplierTin, contact,
                productName, unitPrice, quantity, poNumber, orderDate, totalAmount,
                deliveryDate, deliveredBy);
        if (inspectorName == null || inspectorName.isBlank()) {
            throw new IllegalArgumentException("Inspector name cannot be empty.");
        }
        if (!(status.equalsIgnoreCase("Passed") || status.equalsIgnoreCase("Failed"))) {
            throw new IllegalArgumentException("Status must be Passed or Failed.");
        }
        if (remarks == null || remarks.isBlank()) {
            throw new IllegalArgumentException("Remarks cannot be empty.");
        }
        this.inspectorName = inspectorName;
        this.status = status.substring(0, 1).toUpperCase(Locale.ROOT) + status.substring(1).toLowerCase(Locale.ROOT);
        this.remarks = remarks;
    }

    public String getInspectorName() {
        return inspectorName;
    }

    public String getStatus() {
        return status;
    }

    public String getRemarks() {
        return remarks;
    }
}

class Invoice extends Inspection {
    private final String invoiceNo;
    private final double invoiceAmount;

    public Invoice(int id, String orgName, String address, String contactEmail,
                   String orgCode, String rssbNumber,
                   String deptName, String deptCode,
                   String supplierName, String supplierTin, String contact,
                   String productName, double unitPrice, int quantity,
                   String poNumber, String orderDate, double totalAmount,
                   String deliveryDate, String deliveredBy,
                   String inspectorName, String status, String remarks,
                   String invoiceNo, double invoiceAmount) {
        super(id, orgName, address, contactEmail, orgCode, rssbNumber,
                deptName, deptCode, supplierName, supplierTin, contact,
                productName, unitPrice, quantity, poNumber, orderDate, totalAmount,
                deliveryDate, deliveredBy, inspectorName, status, remarks);
        if (invoiceNo == null || invoiceNo.isBlank()) {
            throw new IllegalArgumentException("Invoice number cannot be empty.");
        }
        if (invoiceAmount <= 0) {
            throw new IllegalArgumentException("Invoice amount must be > 0.");
        }
        this.invoiceNo = invoiceNo;
        this.invoiceAmount = invoiceAmount;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }
}

final class ProcurementReport extends Invoice {
    private final List<String> invoiceNos;
    private final List<Double> invoiceAmounts;
    private final String reportDate;
    private final String summary;

    public ProcurementReport(int id, String orgName, String address, String contactEmail,
                             String orgCode, String rssbNumber,
                             String deptName, String deptCode,
                             String supplierName, String supplierTin, String contact,
                             String productName, double unitPrice, int quantity,
                             String poNumber, String orderDate, double totalAmount,
                             String deliveryDate, String deliveredBy,
                             String inspectorName, String status, String remarks,
                             List<String> invoiceNos, List<Double> invoiceAmounts,
                             String reportDate, String summary) {
        super(id, orgName, address, contactEmail, orgCode, rssbNumber,
                deptName, deptCode, supplierName, supplierTin, contact,
                productName, unitPrice, quantity, poNumber, orderDate, totalAmount,
                deliveryDate, deliveredBy, inspectorName, status, remarks,
                invoiceNos.get(0), invoiceAmounts.get(0));
        if (invoiceNos == null || invoiceAmounts == null || invoiceNos.isEmpty()
                || invoiceNos.size() != invoiceAmounts.size()) {
            throw new IllegalArgumentException("Invoice lists must be non-empty and equal in size.");
        }
        if (reportDate == null || reportDate.isBlank()) {
            throw new IllegalArgumentException("Report date cannot be empty.");
        }
        if (summary == null || summary.isBlank()) {
            throw new IllegalArgumentException("Summary cannot be empty.");
        }
        this.invoiceNos = new ArrayList<>(invoiceNos);
        this.invoiceAmounts = new ArrayList<>(invoiceAmounts);
        this.reportDate = reportDate;
        this.summary = summary;
    }

    public double calculateTotal() {
        return invoiceAmounts.stream().mapToDouble(Double::doubleValue).sum();
    }

    public void printReport() {
        System.out.printf("Organization: %s (%s) Email: %s%n", getOrgName(), getOrgCode(), getContactEmail());
        System.out.printf("Department: %s [%s]%n", getDeptName(), getDeptCode());
        System.out.printf("Supplier: %s | TIN: %s | Contact: %s%n", getSupplierName(), getSupplierTin(), getContact());
        System.out.printf("Product: %s | Unit Price: %.2f | Quantity: %d%n", getProductName(), getUnitPrice(), getQuantity());
        System.out.printf("PO: %s | Date: %s | Total: %.2f%n", getPoNumber(), getOrderDate(), getTotalAmount());
        System.out.printf("Delivery: %s by %s%n", getDeliveryDate(), getDeliveredBy());
        System.out.printf("Inspection: %s | Status: %s | Remarks: %s%n", getInspectorName(), getStatus(), getRemarks());
        for (int i = 0; i < invoiceNos.size(); i++) {
            System.out.printf("Invoice %d: %s Amount: %.2f%n", i + 1, invoiceNos.get(i), invoiceAmounts.get(i));
        }
        System.out.printf("Report Date: %s | Summary: %s%n", reportDate, summary);
            System.out.printf("Total Invoiced Amount: %.2f%n", calculateTotal());
            System.out.println("Student ID: 27476");
        }
}

