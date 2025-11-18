package question2;

import java.util.Locale;
import java.util.Scanner;

public class Question2App {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Flight Booking System ===");
            Ticket ticket = buildTicket(scanner);
            System.out.println("\n--- Ticket Summary ---");
            ticket.printTicket();
        } catch (IllegalArgumentException ex) {
            System.out.println("Validation error: " + ex.getMessage());
        }
    }

    private static Ticket buildTicket(Scanner scanner) {
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

        String airportName = "";
        validInput = false;
        do {
            try {
                airportName = readNonEmpty(scanner, "Airport Name: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String airportCode = "";
        validInput = false;
        do {
            try {
                airportCode = readAirportCode(scanner, "Airport Code (3 uppercase letters): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String location = "";
        validInput = false;
        do {
            try {
                location = readNonEmpty(scanner, "Airport Location: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String airlineName = "";
        validInput = false;
        do {
            try {
                airlineName = readNonEmpty(scanner, "Airline Name: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String airlineCode = "";
        validInput = false;
        do {
            try {
                airlineCode = readAirlineCode(scanner, "Airline Code (2-4 letters): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String airlineEmail = "";
        validInput = false;
        do {
            try {
                airlineEmail = readEmail(scanner, "Airline Contact Email: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String flightNumber = "";
        validInput = false;
        do {
            try {
                flightNumber = readNonEmpty(scanner, "Flight Number: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String departure = "";
        validInput = false;
        do {
            try {
                departure = readNonEmpty(scanner, "Departure Airport: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String destination = "";
        validInput = false;
        do {
            try {
                destination = readNonEmpty(scanner, "Destination Airport: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        double baseFare = 0.0;
        validInput = false;
        do {
            try {
                baseFare = readPositiveDouble(scanner, "Base Fare (>0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String pilotName = "";
        validInput = false;
        do {
            try {
                pilotName = readNonEmpty(scanner, "Pilot Name: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String licenseNumber = "";
        validInput = false;
        do {
            try {
                licenseNumber = readNonEmpty(scanner, "Pilot License Number: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        int experienceYears = 0;
        validInput = false;
        do {
            try {
                experienceYears = readMinInt(scanner, "Pilot Experience Years (>=2): ", 2);
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String crewName = "";
        validInput = false;
        do {
            try {
                crewName = readNonEmpty(scanner, "Cabin Crew Name: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String role = "";
        validInput = false;
        do {
            try {
                role = readNonEmpty(scanner, "Cabin Crew Role: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String shift = "";
        validInput = false;
        do {
            try {
                shift = readShift(scanner, "Cabin Crew Shift (Day/Night): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String passengerName = "";
        validInput = false;
        do {
            try {
                passengerName = readNonEmpty(scanner, "Passenger Name: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        int age = 0;
        validInput = false;
        do {
            try {
                age = readPositiveInt(scanner, "Passenger Age (>0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String gender = "";
        validInput = false;
        do {
            try {
                gender = readGender(scanner, "Passenger Gender (Male/Female/Other): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String contact = "";
        validInput = false;
        do {
            try {
                contact = readNonEmpty(scanner, "Passenger Contact: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String bookingDate = "";
        validInput = false;
        do {
            try {
                bookingDate = readNonEmpty(scanner, "Booking Date: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String seatNumber = "";
        validInput = false;
        do {
            try {
                seatNumber = readNonEmpty(scanner, "Seat Number: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String travelClass = "";
        validInput = false;
        do {
            try {
                travelClass = readTravelClass(scanner, "Travel Class (Economy/Business/First): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String paymentDate = "";
        validInput = false;
        do {
            try {
                paymentDate = readNonEmpty(scanner, "Payment Date: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String paymentMethod = "";
        validInput = false;
        do {
            try {
                paymentMethod = readNonEmpty(scanner, "Payment Method: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        double amountPaid = 0.0;
        validInput = false;
        do {
            try {
                amountPaid = readPositiveDouble(scanner, "Amount Paid (>0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String ticketNumber = "";
        validInput = false;
        do {
            try {
                ticketNumber = readNonEmpty(scanner, "Ticket Number: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String issueDate = "";
        validInput = false;
        do {
            try {
                issueDate = readNonEmpty(scanner, "Ticket Issue Date: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        double taxes = 0.0;
        validInput = false;
        do {
            try {
                taxes = readNonNegativeDouble(scanner, "Taxes (>=0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        double discount = 0.0;
        validInput = false;
        do {
            try {
                discount = readNonNegativeDouble(scanner, "Discount (>=0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        return new Ticket(
                id,
                airportName,
                airportCode,
                location,
                airlineName,
                airlineCode,
                airlineEmail,
                flightNumber,
                departure,
                destination,
                baseFare,
                pilotName,
                licenseNumber,
                experienceYears,
                crewName,
                role,
                shift,
                passengerName,
                age,
                gender,
                contact,
                bookingDate,
                seatNumber,
                travelClass,
                paymentDate,
                paymentMethod,
                amountPaid,
                ticketNumber,
                issueDate,
                taxes,
                discount
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

    private static int readMinInt(Scanner scanner, String prompt, int min) {
        System.out.print(prompt);
        int value = Integer.parseInt(scanner.nextLine().trim());
        if (value < min) {
            throw new IllegalArgumentException("Value must be at least " + min + ".");
        }
        return value;
    }

    private static String readAirportCode(Scanner scanner, String prompt) {
        String code = readNonEmpty(scanner, prompt);
        if (!code.matches("[A-Z]{3}")) {
            throw new IllegalArgumentException("Airport code must be 3 uppercase letters.");
        }
        return code;
    }

    private static String readAirlineCode(Scanner scanner, String prompt) {
        String code = readNonEmpty(scanner, prompt);
        if (!code.matches("[A-Za-z]{2,4}")) {
            throw new IllegalArgumentException("Airline code must be 2-4 letters.");
        }
        return code.toUpperCase(Locale.ROOT);
    }

    private static String readEmail(Scanner scanner, String prompt) {
        String email = readNonEmpty(scanner, prompt);
        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email.");
        }
        return email;
    }

    private static String readShift(Scanner scanner, String prompt) {
        String shift = readNonEmpty(scanner, prompt);
        if (!(shift.equalsIgnoreCase("Day") || shift.equalsIgnoreCase("Night"))) {
            throw new IllegalArgumentException("Shift must be Day or Night.");
        }
        return FormatUtils.capitalize(shift);
    }

    private static String readGender(Scanner scanner, String prompt) {
        String gender = readNonEmpty(scanner, prompt);
        if (!(gender.equalsIgnoreCase("Male") ||
                gender.equalsIgnoreCase("Female") ||
                gender.equalsIgnoreCase("Other"))) {
            throw new IllegalArgumentException("Gender must be Male/Female/Other.");
        }
        return FormatUtils.capitalize(gender);
    }

    private static String readTravelClass(Scanner scanner, String prompt) {
        String value = readNonEmpty(scanner, prompt);
        if (!(value.equalsIgnoreCase("Economy") ||
                value.equalsIgnoreCase("Business") ||
                value.equalsIgnoreCase("First"))) {
            throw new IllegalArgumentException("Travel class must be Economy/Business/First.");
        }
        return FormatUtils.capitalize(value);
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

class Airport extends Entity {
    private final String airportName;
    private final String code;
    private final String location;

    public Airport(int id, String airportName, String code, String location) {
        super(id);
        if (airportName == null || airportName.isBlank()) {
            throw new IllegalArgumentException("Airport name cannot be empty.");
        }
        if (code == null || !code.matches("[A-Z]{3}")) {
            throw new IllegalArgumentException("Airport code must be 3 uppercase letters.");
        }
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Location cannot be empty.");
        }
        this.airportName = airportName;
        this.code = code;
        this.location = location;
    }

    public String getAirportName() {
        return airportName;
    }

    public String getCode() {
        return code;
    }

    public String getLocation() {
        return location;
    }
}

class Airline extends Airport {
    private final String airlineName;
    private final String airlineCode;
    private final String contactEmail;

    public Airline(int id, String airportName, String code, String location,
                   String airlineName, String airlineCode, String contactEmail) {
        super(id, airportName, code, location);
        if (airlineName == null || airlineName.isBlank()) {
            throw new IllegalArgumentException("Airline name cannot be empty.");
        }
        if (airlineCode == null || !airlineCode.matches("[A-Za-z]{2,4}")) {
            throw new IllegalArgumentException("Airline code must be 2-4 letters.");
        }
        if (contactEmail == null || !contactEmail.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("Invalid airline email.");
        }
        this.airlineName = airlineName;
        this.airlineCode = airlineCode.toUpperCase(Locale.ROOT);
        this.contactEmail = contactEmail;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public String getContactEmail() {
        return contactEmail;
    }
}

class Flight extends Airline {
    private final String flightNumber;
    private final String departure;
    private final String destination;
    private final double baseFare;

    public Flight(int id, String airportName, String code, String location,
                  String airlineName, String airlineCode, String contactEmail,
                  String flightNumber, String departure, String destination, double baseFare) {
        super(id, airportName, code, location, airlineName, airlineCode, contactEmail);
        if (flightNumber == null || flightNumber.isBlank()) {
            throw new IllegalArgumentException("Flight number cannot be empty.");
        }
        if (departure == null || departure.isBlank()) {
            throw new IllegalArgumentException("Departure cannot be empty.");
        }
        if (destination == null || destination.isBlank()) {
            throw new IllegalArgumentException("Destination cannot be empty.");
        }
        if (baseFare <= 0) {
            throw new IllegalArgumentException("Base fare must be > 0.");
        }
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.baseFare = baseFare;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public double getBaseFare() {
        return baseFare;
    }
}

class Pilot extends Flight {
    private final String pilotName;
    private final String licenseNumber;
    private final int experienceYears;

    public Pilot(int id, String airportName, String code, String location,
                 String airlineName, String airlineCode, String contactEmail,
                 String flightNumber, String departure, String destination, double baseFare,
                 String pilotName, String licenseNumber, int experienceYears) {
        super(id, airportName, code, location, airlineName, airlineCode, contactEmail,
                flightNumber, departure, destination, baseFare);
        if (pilotName == null || pilotName.isBlank()) {
            throw new IllegalArgumentException("Pilot name cannot be empty.");
        }
        if (licenseNumber == null || licenseNumber.isBlank()) {
            throw new IllegalArgumentException("License number cannot be empty.");
        }
        if (experienceYears < 2) {
            throw new IllegalArgumentException("Experience years must be at least 2.");
        }
        this.pilotName = pilotName;
        this.licenseNumber = licenseNumber;
        this.experienceYears = experienceYears;
    }

    public String getPilotName() {
        return pilotName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public int getExperienceYears() {
        return experienceYears;
    }
}

class CabinCrew extends Pilot {
    private final String crewName;
    private final String role;
    private final String shift;

    public CabinCrew(int id, String airportName, String code, String location,
                     String airlineName, String airlineCode, String contactEmail,
                     String flightNumber, String departure, String destination, double baseFare,
                     String pilotName, String licenseNumber, int experienceYears,
                     String crewName, String role, String shift) {
        super(id, airportName, code, location, airlineName, airlineCode, contactEmail,
                flightNumber, departure, destination, baseFare,
                pilotName, licenseNumber, experienceYears);
        if (crewName == null || crewName.isBlank()) {
            throw new IllegalArgumentException("Crew name cannot be empty.");
        }
        if (role == null || role.isBlank()) {
            throw new IllegalArgumentException("Role cannot be empty.");
        }
        if (!(shift.equalsIgnoreCase("Day") || shift.equalsIgnoreCase("Night"))) {
            throw new IllegalArgumentException("Shift must be Day or Night.");
        }
        this.crewName = crewName;
        this.role = role;
        this.shift = FormatUtils.capitalize(shift);
    }

    public String getCrewName() {
        return crewName;
    }

    public String getRole() {
        return role;
    }

    public String getShift() {
        return shift;
    }
}

class Passenger extends CabinCrew {
    private final String passengerName;
    private final int age;
    private final String gender;
    private final String contact;

    public Passenger(int id, String airportName, String code, String location,
                     String airlineName, String airlineCode, String contactEmail,
                     String flightNumber, String departure, String destination, double baseFare,
                     String pilotName, String licenseNumber, int experienceYears,
                     String crewName, String role, String shift,
                     String passengerName, int age, String gender, String contact) {
        super(id, airportName, code, location, airlineName, airlineCode, contactEmail,
                flightNumber, departure, destination, baseFare,
                pilotName, licenseNumber, experienceYears,
                crewName, role, shift);
        if (passengerName == null || passengerName.isBlank()) {
            throw new IllegalArgumentException("Passenger name cannot be empty.");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be positive.");
        }
        if (!(gender.equalsIgnoreCase("Male") ||
                gender.equalsIgnoreCase("Female") ||
                gender.equalsIgnoreCase("Other"))) {
            throw new IllegalArgumentException("Gender must be Male/Female/Other.");
        }
        if (contact == null || contact.isBlank()) {
            throw new IllegalArgumentException("Contact cannot be empty.");
        }
        this.passengerName = passengerName;
        this.age = age;
        this.gender = FormatUtils.capitalize(gender);
        this.contact = contact;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getContact() {
        return contact;
    }
}

class Booking extends Passenger {
    private final String bookingDate;
    private final String seatNumber;
    private final String travelClass;

    public Booking(int id, String airportName, String code, String location,
                   String airlineName, String airlineCode, String contactEmail,
                   String flightNumber, String departure, String destination, double baseFare,
                   String pilotName, String licenseNumber, int experienceYears,
                   String crewName, String role, String shift,
                   String passengerName, int age, String gender, String contact,
                   String bookingDate, String seatNumber, String travelClass) {
        super(id, airportName, code, location, airlineName, airlineCode, contactEmail,
                flightNumber, departure, destination, baseFare,
                pilotName, licenseNumber, experienceYears,
                crewName, role, shift,
                passengerName, age, gender, contact);
        if (bookingDate == null || bookingDate.isBlank()) {
            throw new IllegalArgumentException("Booking date cannot be empty.");
        }
        if (seatNumber == null || seatNumber.isBlank()) {
            throw new IllegalArgumentException("Seat number cannot be empty.");
        }
        if (!(travelClass.equalsIgnoreCase("Economy") ||
                travelClass.equalsIgnoreCase("Business") ||
                travelClass.equalsIgnoreCase("First"))) {
            throw new IllegalArgumentException("Travel class must be Economy/Business/First.");
        }
        this.bookingDate = bookingDate;
        this.seatNumber = seatNumber;
        this.travelClass = FormatUtils.capitalize(travelClass);
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getTravelClass() {
        return travelClass;
    }
}

class Payment extends Booking {
    private final String paymentDate;
    private final String paymentMethod;
    private final double amountPaid;

    public Payment(int id, String airportName, String code, String location,
                   String airlineName, String airlineCode, String contactEmail,
                   String flightNumber, String departure, String destination, double baseFare,
                   String pilotName, String licenseNumber, int experienceYears,
                   String crewName, String role, String shift,
                   String passengerName, int age, String gender, String contact,
                   String bookingDate, String seatNumber, String travelClass,
                   String paymentDate, String paymentMethod, double amountPaid) {
        super(id, airportName, code, location, airlineName, airlineCode, contactEmail,
                flightNumber, departure, destination, baseFare,
                pilotName, licenseNumber, experienceYears,
                crewName, role, shift,
                passengerName, age, gender, contact,
                bookingDate, seatNumber, travelClass);
        if (paymentDate == null || paymentDate.isBlank()) {
            throw new IllegalArgumentException("Payment date cannot be empty.");
        }
        if (paymentMethod == null || paymentMethod.isBlank()) {
            throw new IllegalArgumentException("Payment method cannot be empty.");
        }
        if (amountPaid <= 0) {
            throw new IllegalArgumentException("Amount paid must be > 0.");
        }
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.amountPaid = amountPaid;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getAmountPaid() {
        return amountPaid;
    }
}

final class Ticket extends Payment {
    private final String ticketNumber;
    private final String issueDate;
    private final double taxes;
    private final double discount;

    public Ticket(int id, String airportName, String code, String location,
                  String airlineName, String airlineCode, String contactEmail,
                  String flightNumber, String departure, String destination, double baseFare,
                  String pilotName, String licenseNumber, int experienceYears,
                  String crewName, String role, String shift,
                  String passengerName, int age, String gender, String contact,
                  String bookingDate, String seatNumber, String travelClass,
                  String paymentDate, String paymentMethod, double amountPaid,
                  String ticketNumber, String issueDate,
                  double taxes, double discount) {
        super(id, airportName, code, location, airlineName, airlineCode, contactEmail,
                flightNumber, departure, destination, baseFare,
                pilotName, licenseNumber, experienceYears,
                crewName, role, shift,
                passengerName, age, gender, contact,
                bookingDate, seatNumber, travelClass,
                paymentDate, paymentMethod, amountPaid);
        if (ticketNumber == null || ticketNumber.isBlank()) {
            throw new IllegalArgumentException("Ticket number cannot be empty.");
        }
        if (issueDate == null || issueDate.isBlank()) {
            throw new IllegalArgumentException("Issue date cannot be empty.");
        }
        if (taxes < 0) {
            throw new IllegalArgumentException("Taxes cannot be negative.");
        }
        if (discount < 0) {
            throw new IllegalArgumentException("Discount cannot be negative.");
        }
        this.ticketNumber = ticketNumber;
        this.issueDate = issueDate;
        this.taxes = taxes;
        this.discount = discount;
    }

    public double calculateFare() {
        return getBaseFare() + taxes - discount;
    }

    public void printTicket() {
        System.out.printf("Ticket Number: %s | Issue Date: %s%n", ticketNumber, issueDate);
        System.out.printf("Passenger: %s | Age: %d | Gender: %s | Contact: %s%n",
                getPassengerName(), getAge(), getGender(), getContact());
        System.out.printf("Flight: %s (%s -> %s) | Class: %s%n",
                getFlightNumber(), getDeparture(), getDestination(), getTravelClass());
        System.out.printf("Pilot: %s (%s) | Crew: %s (%s - %s shift)%n",
                getPilotName(), getLicenseNumber(), getCrewName(), getRole(), getShift());
        System.out.printf("Booking Date: %s | Seat Number: %s%n", getBookingDate(), getSeatNumber());
        System.out.printf("Payment: %s via %s | Amount Paid: %.2f%n",
                getPaymentDate(), getPaymentMethod(), getAmountPaid());
        System.out.printf("Fare Breakdown => Base: %.2f + Taxes: %.2f - Discount: %.2f%n",
                getBaseFare(), taxes, discount);
        System.out.printf("Total Fare: %.2f%n", calculateFare());
        System.out.println("Student ID: 27476");
    }
}

final class FormatUtils {
    private FormatUtils() {
    }

    static String capitalize(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Text cannot be blank.");
        }
        return text.substring(0, 1).toUpperCase(Locale.ROOT) + text.substring(1).toLowerCase(Locale.ROOT);
    }
}


