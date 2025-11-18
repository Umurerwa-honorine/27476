package question1;

import java.util.Locale;
import java.util.Scanner;

public class Question1App {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Stock Management System ===");
            StockReport report = buildReport(scanner);
            System.out.println("\n--- Generated Stock Report ---");
            report.generateReport();
        } catch (IllegalArgumentException ex) {
            System.out.println("Validation error: " + ex.getMessage());
        }
    }

    private static StockReport buildReport(Scanner scanner) {
        int id = 0;
        boolean validInput = false;
        do {
            try {
                id = readPositiveInt(scanner, "Entity ID (> 0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String warehouseName = "";
        validInput = false;
        do {
            try {
                warehouseName = readNonEmpty(scanner, "Warehouse Name: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String location = "";
        validInput = false;
        do {
            try {
                location = readNonEmpty(scanner, "Warehouse Location: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String contactNumber = "";
        validInput = false;
        do {
            try {
                contactNumber = readFixedDigits(scanner, "Warehouse Contact (10 digits): ", 10);
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String categoryName = "";
        validInput = false;
        do {
            try {
                categoryName = readNonEmpty(scanner, "Category Name: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String categoryCode = "";
        validInput = false;
        do {
            try {
                categoryCode = readMinAlphanumeric(scanner, "Category Code (>=3 alphanumeric): ", 3);
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

        String supplierEmail = "";
        validInput = false;
        do {
            try {
                supplierEmail = readEmail(scanner, "Supplier Email: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String supplierPhone = "";
        validInput = false;
        do {
            try {
                supplierPhone = readFixedDigits(scanner, "Supplier Phone (10 digits): ", 10);
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
                unitPrice = readPositiveDouble(scanner, "Product Unit Price (> 0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        int stockLimit = 0;
        validInput = false;
        do {
            try {
                stockLimit = readNonNegativeInt(scanner, "Product Stock Limit (>= 0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        int quantityAvailable = 0;
        validInput = false;
        do {
            try {
                quantityAvailable = readNonNegativeInt(scanner, "Quantity Available (>= 0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        int reorderLevel = 0;
        validInput = false;
        do {
            try {
                reorderLevel = readNonNegativeInt(scanner, "Reorder Level (>= 0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String purchaseDate = "";
        validInput = false;
        do {
            try {
                purchaseDate = readNonEmpty(scanner, "Purchase Date: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        int purchasedQuantity = 0;
        validInput = false;
        do {
            try {
                purchasedQuantity = readPositiveInt(scanner, "Purchased Quantity (> 0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String purchaseSupplierName = "";
        validInput = false;
        do {
            try {
                purchaseSupplierName = readNonEmpty(scanner, "Supplier Name for Purchase: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String saleDate = "";
        validInput = false;
        do {
            try {
                saleDate = readNonEmpty(scanner, "Sale Date: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        int soldQuantity = 0;
        validInput = false;
        do {
            try {
                soldQuantity = readPositiveInt(scanner, "Sold Quantity (> 0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String customerName = "";
        validInput = false;
        do {
            try {
                customerName = readNonEmpty(scanner, "Customer Name: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        int totalItems = Math.max(0, quantityAvailable + purchasedQuantity - soldQuantity);
        double stockValue = totalItems * unitPrice;

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

        String remarks = "";
        validInput = false;
        do {
            try {
                remarks = readNonEmpty(scanner, "Remarks: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        return new StockReport(
                id,
                warehouseName,
                location,
                contactNumber,
                categoryName,
                categoryCode,
                supplierName,
                supplierEmail,
                supplierPhone,
                productName,
                unitPrice,
                stockLimit,
                quantityAvailable,
                reorderLevel,
                reportDate, // Assuming purchaseDate is reportDate for simplicity in this context
                purchasedQuantity,
                purchaseSupplierName,
                reportDate, // Assuming saleDate is reportDate for simplicity in this context
                soldQuantity,
                customerName,
                totalItems,
                stockValue,
                reportDate,
                remarks
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
            throw new IllegalArgumentException("Value must be > 0.");
        }
        return value;
    }

    private static String readFixedDigits(Scanner scanner, String prompt, int digits) {
        String value = readNonEmpty(scanner, prompt);
        if (!value.matches("\\d{" + digits + "}")) {
            throw new IllegalArgumentException("Value must be exactly " + digits + " digits.");
        }
        return value;
    }

    private static String readMinAlphanumeric(Scanner scanner, String prompt, int minLength) {
        String value = readNonEmpty(scanner, prompt);
        if (value.length() < minLength || !value.matches("[A-Za-z0-9]+")) {
            throw new IllegalArgumentException("Value must be alphanumeric and at least " + minLength + " chars.");
        }
        return value;
    }

    private static String readEmail(Scanner scanner, String prompt) {
        String value = readNonEmpty(scanner, prompt);
        if (!value.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        return value;
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
            throw new IllegalArgumentException("Updated date cannot be null or blank.");
        }
        this.updatedDate = updatedDate;
    }
}

class Warehouse extends Entity {
    private final String warehouseName;
    private final String location;
    private final String contactNumber;

    public Warehouse(int id, String warehouseName, String location, String contactNumber) {
        super(id);
        if (warehouseName == null || warehouseName.isBlank()) {
            throw new IllegalArgumentException("Warehouse name cannot be empty.");
        }
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Location cannot be empty.");
        }
        if (contactNumber == null || !contactNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Contact number must be exactly 10 digits.");
        }
        this.warehouseName = warehouseName;
        this.location = location;
        this.contactNumber = contactNumber;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public String getLocation() {
        return location;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}

class Category extends Warehouse {
    private final String categoryName;
    private final String categoryCode;

    public Category(int id, String warehouseName, String location, String contactNumber,
                    String categoryName, String categoryCode) {
        super(id, warehouseName, location, contactNumber);
        if (categoryName == null || categoryName.isBlank()) {
            throw new IllegalArgumentException("Category name cannot be empty.");
        }
        if (categoryCode == null || categoryCode.length() < 3 || !categoryCode.matches("[A-Za-z0-9]+")) {
            throw new IllegalArgumentException("Category code must be alphanumeric and at least 3 characters.");
        }
        this.categoryName = categoryName;
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }
}

class Supplier extends Category {
    private final String supplierName;
    private final String supplierEmail;
    private final String supplierPhone;

    public Supplier(int id, String warehouseName, String location, String contactNumber,
                    String categoryName, String categoryCode,
                    String supplierName, String supplierEmail, String supplierPhone) {
        super(id, warehouseName, location, contactNumber, categoryName, categoryCode);
        if (supplierName == null || supplierName.isBlank()) {
            throw new IllegalArgumentException("Supplier name cannot be empty.");
        }
        if (supplierEmail == null || !supplierEmail.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("Invalid supplier email.");
        }
        if (supplierPhone == null || !supplierPhone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Supplier phone must be exactly 10 digits.");
        }
        this.supplierName = supplierName;
        this.supplierEmail = supplierEmail;
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }
}

class Product extends Supplier {
    private final String productName;
    private final double unitPrice;
    private final int stockLimit;

    public Product(int id, String warehouseName, String location, String contactNumber,
                   String categoryName, String categoryCode,
                   String supplierName, String supplierEmail, String supplierPhone,
                   String productName, double unitPrice, int stockLimit) {
        super(id, warehouseName, location, contactNumber, categoryName, categoryCode,
                supplierName, supplierEmail, supplierPhone);
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }
        if (unitPrice <= 0) {
            throw new IllegalArgumentException("Unit price must be greater than zero.");
        }
        if (stockLimit < 0) {
            throw new IllegalArgumentException("Stock limit cannot be negative.");
        }
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.stockLimit = stockLimit;
    }

    public String getProductName() {
        return productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getStockLimit() {
        return stockLimit;
    }
}

class StockItem extends Product {
    private final int quantityAvailable;
    private final int reorderLevel;

    public StockItem(int id, String warehouseName, String location, String contactNumber,
                     String categoryName, String categoryCode,
                     String supplierName, String supplierEmail, String supplierPhone,
                     String productName, double unitPrice, int stockLimit,
                     int quantityAvailable, int reorderLevel) {
        super(id, warehouseName, location, contactNumber, categoryName, categoryCode,
                supplierName, supplierEmail, supplierPhone, productName, unitPrice, stockLimit);
        if (quantityAvailable < 0) {
            throw new IllegalArgumentException("Quantity available cannot be negative.");
        }
        if (reorderLevel < 0) {
            throw new IllegalArgumentException("Reorder level cannot be negative.");
        }
        this.quantityAvailable = quantityAvailable;
        this.reorderLevel = reorderLevel;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }
}

class Purchase extends StockItem {
    private final String purchaseDate;
    private final int purchasedQuantity;
    private final String purchaseSupplierName;

    public Purchase(int id, String warehouseName, String location, String contactNumber,
                    String categoryName, String categoryCode,
                    String supplierName, String supplierEmail, String supplierPhone,
                    String productName, double unitPrice, int stockLimit,
                    int quantityAvailable, int reorderLevel,
                    String purchaseDate, int purchasedQuantity, String purchaseSupplierName) {
        super(id, warehouseName, location, contactNumber, categoryName, categoryCode,
                supplierName, supplierEmail, supplierPhone, productName, unitPrice, stockLimit,
                quantityAvailable, reorderLevel);
        if (purchaseDate == null || purchaseDate.isBlank()) {
            throw new IllegalArgumentException("Purchase date cannot be empty.");
        }
        if (purchasedQuantity <= 0) {
            throw new IllegalArgumentException("Purchased quantity must be greater than zero.");
        }
        if (purchaseSupplierName == null || purchaseSupplierName.isBlank()) {
            throw new IllegalArgumentException("Purchase supplier name cannot be empty.");
        }
        this.purchaseDate = purchaseDate;
        this.purchasedQuantity = purchasedQuantity;
        this.purchaseSupplierName = purchaseSupplierName;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public int getPurchasedQuantity() {
        return purchasedQuantity;
    }

    public String getPurchaseSupplierName() {
        return purchaseSupplierName;
    }
}

class Sale extends Purchase {
    private final String saleDate;
    private final int soldQuantity;
    private final String customerName;

    public Sale(int id, String warehouseName, String location, String contactNumber,
                String categoryName, String categoryCode,
                String supplierName, String supplierEmail, String supplierPhone,
                String productName, double unitPrice, int stockLimit,
                int quantityAvailable, int reorderLevel,
                String purchaseDate, int purchasedQuantity, String purchaseSupplierName,
                String saleDate, int soldQuantity, String customerName) {
        super(id, warehouseName, location, contactNumber, categoryName, categoryCode,
                supplierName, supplierEmail, supplierPhone, productName, unitPrice, stockLimit,
                quantityAvailable, reorderLevel, purchaseDate, purchasedQuantity, purchaseSupplierName);
        if (saleDate == null || saleDate.isBlank()) {
            throw new IllegalArgumentException("Sale date cannot be empty.");
        }
        if (soldQuantity <= 0) {
            throw new IllegalArgumentException("Sold quantity must be greater than zero.");
        }
        if (customerName == null || customerName.isBlank()) {
            throw new IllegalArgumentException("Customer name cannot be empty.");
        }
        this.saleDate = saleDate;
        this.soldQuantity = soldQuantity;
        this.customerName = customerName;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public String getCustomerName() {
        return customerName;
    }
}

class Inventory extends Sale {
    private final int totalItems;
    private final double stockValue;

    public Inventory(int id, String warehouseName, String location, String contactNumber,
                     String categoryName, String categoryCode,
                     String supplierName, String supplierEmail, String supplierPhone,
                     String productName, double unitPrice, int stockLimit,
                     int quantityAvailable, int reorderLevel,
                     String purchaseDate, int purchasedQuantity, String purchaseSupplierName,
                     String saleDate, int soldQuantity, String customerName,
                     int totalItems, double stockValue) {
        super(id, warehouseName, location, contactNumber, categoryName, categoryCode,
                supplierName, supplierEmail, supplierPhone, productName, unitPrice, stockLimit,
                quantityAvailable, reorderLevel, purchaseDate, purchasedQuantity, purchaseSupplierName,
                saleDate, soldQuantity, customerName);
        if (totalItems < 0) {
            throw new IllegalArgumentException("Total items cannot be negative.");
        }
        if (stockValue < 0) {
            throw new IllegalArgumentException("Stock value cannot be negative.");
        }
        this.totalItems = totalItems;
        this.stockValue = stockValue;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public double getStockValue() {
        return stockValue;
    }
}

final class StockReport extends Inventory {
    private final String reportDate;
    private final String remarks;

    public StockReport(int id, String warehouseName, String location, String contactNumber,
                       String categoryName, String categoryCode,
                       String supplierName, String supplierEmail, String supplierPhone,
                       String productName, double unitPrice, int stockLimit,
                       int quantityAvailable, int reorderLevel,
                       String purchaseDate, int purchasedQuantity, String purchaseSupplierName,
                       String saleDate, int soldQuantity, String customerName,
                       int totalItems, double stockValue,
                       String reportDate, String remarks) {
        super(id, warehouseName, location, contactNumber, categoryName, categoryCode,
                supplierName, supplierEmail, supplierPhone, productName, unitPrice, stockLimit,
                quantityAvailable, reorderLevel, purchaseDate, purchasedQuantity, purchaseSupplierName,
                saleDate, soldQuantity, customerName, totalItems, stockValue);
        if (reportDate == null || reportDate.isBlank()) {
            throw new IllegalArgumentException("Report date cannot be empty.");
        }
        if (remarks == null || remarks.isBlank()) {
            throw new IllegalArgumentException("Remarks cannot be empty.");
        }
        this.reportDate = reportDate;
        this.remarks = remarks;
    }

    public void generateReport() {
        System.out.printf("Entity ID: %d%n", getId());
        System.out.printf("Created Date: %s, Updated Date: %s%n", getCreatedDate(), getUpdatedDate());
        System.out.printf("Warehouse: %s (%s) Contact: %s%n", getWarehouseName(), getLocation(), getContactNumber());
        System.out.printf("Category: %s [%s]%n", getCategoryName(), getCategoryCode());
        System.out.printf("Supplier: %s | Email: %s | Phone: %s%n", getSupplierName(), getSupplierEmail(), getSupplierPhone());
        System.out.printf("Product: %s | Unit Price: %.2f | Stock Limit: %d%n", getProductName(), getUnitPrice(), getStockLimit());
        System.out.printf("Stock Item: Available=%d | Reorder Level=%d%n", getQuantityAvailable(), getReorderLevel());
        System.out.printf("Purchase: %s Qty=%d Supplier=%s%n", getPurchaseDate(), getPurchasedQuantity(), getPurchaseSupplierName());
        System.out.printf("Sale: %s Qty=%d Customer=%s%n", getSaleDate(), getSoldQuantity(), getCustomerName());
        System.out.printf("Inventory: Total Items=%d | Stock Value=%.2f%n", getTotalItems(), getStockValue());
        System.out.printf("Report Date: %s | Remarks: %s%n", reportDate, remarks);
        System.out.println("Student ID: 27476");
    }
}

