package question5;

import java.util.Locale;
import java.util.Scanner;

public class Question5App {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Attendance Management System ===");
            AttendanceSummary summary = buildSummary(scanner);
            System.out.println("\n--- Attendance Summary ---");
            summary.generateSummary();
        } catch (IllegalArgumentException ex) {
            System.out.println("Validation error: " + ex.getMessage());
        }
    }

    private static AttendanceSummary buildSummary(Scanner scanner) {
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

        String createdDate = "";
        validInput = false;
        do {
            try {
                createdDate = readNonEmpty(scanner, "Created Date: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String updatedDate = "";
        validInput = false;
        do {
            try {
                updatedDate = readNonEmpty(scanner, "Updated Date: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String institutionName = "";
        validInput = false;
        do {
            try {
                institutionName = readNonEmpty(scanner, "Institution Name: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String institutionCode = "";
        validInput = false;
        do {
            try {
                institutionCode = readMinCode(scanner, "Institution Code (>=3 chars): ", 3);
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String institutionAddress = "";
        validInput = false;
        do {
            try {
                institutionAddress = readNonEmpty(scanner, "Institution Address: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String departmentName = "";
        validInput = false;
        do {
            try {
                departmentName = readNonEmpty(scanner, "Department Name: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String departmentHead = "";
        validInput = false;
        do {
            try {
                departmentHead = readNonEmpty(scanner, "Department Head: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String courseName = "";
        validInput = false;
        do {
            try {
                courseName = readNonEmpty(scanner, "Course Name: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String courseCode = "";
        validInput = false;
        do {
            try {
                courseCode = readNonEmpty(scanner, "Course Code: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        int credits = 0;
        validInput = false;
        do {
            try {
                credits = readPositiveInt(scanner, "Course Credits (>0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String instructorName = "";
        validInput = false;
        do {
            try {
                instructorName = readNonEmpty(scanner, "Instructor Name: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String instructorEmail = "";
        validInput = false;
        do {
            try {
                instructorEmail = readEmail(scanner, "Instructor Email: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String instructorPhone = "";
        validInput = false;
        do {
            try {
                instructorPhone = readFixedDigits(scanner, "Instructor Phone (10 digits): ", 10);
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String studentName = "";
        validInput = false;
        do {
            try {
                studentName = readNonEmpty(scanner, "Student Name: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String studentId = "";
        validInput = false;
        do {
            try {
                studentId = readNonEmpty(scanner, "Student ID: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        int studentAge = 0;
        validInput = false;
        do {
            try {
                studentAge = readPositiveInt(scanner, "Student Age (>0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String sessionDate = "";
        validInput = false;
        do {
            try {
                sessionDate = readNonEmpty(scanner, "Class Session Date: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String topic = "";
        validInput = false;
        do {
            try {
                topic = readNonEmpty(scanner, "Session Topic: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String attendanceStudentId = "";
        validInput = false;
        do {
            try {
                attendanceStudentId = readNonEmpty(scanner, "Attendance Student ID: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String sessionId = "";
        validInput = false;
        do {
            try {
                sessionId = readNonEmpty(scanner, "Session ID: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String status = "";
        validInput = false;
        do {
            try {
                status = readStatus(scanner, "Attendance Status (Present/Absent): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        String requestDate = "";
        String reason = "";
        boolean approved = false;

        if (status.equalsIgnoreCase("absent")) {
            validInput = false;
            do {
                try {
                    requestDate = readNonEmpty(scanner, "Leave Request Date: ");
                    validInput = true;
                } catch (IllegalArgumentException ex) {
                    System.out.println("Error: " + ex.getMessage() + " Please try again.");
                }
            } while (!validInput);

            validInput = false;
            do {
                try {
                    reason = readNonEmpty(scanner, "Leave Reason: ");
                    validInput = true;
                } catch (IllegalArgumentException ex) {
                    System.out.println("Error: " + ex.getMessage() + " Please try again.");
                }
            } while (!validInput);

            validInput = false;
            do {
                try {
                    approved = readBoolean(scanner, "Leave Approved? (true/false): ");
                    validInput = true;
                } catch (IllegalArgumentException ex) {
                    System.out.println("Error: " + ex.getMessage() + " Please try again.");
                }
            } while (!validInput);
        }

        String reportDate = "";
        validInput = false;
        do {
            try {
                reportDate = readNonEmpty(scanner, "Summary Report Date: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        int totalPresent = 0;
        validInput = false;
        do {
            try {
                totalPresent = readNonNegativeInt(scanner, "Total Present: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        int totalAbsent = 0;
        validInput = false;
        do {
            try {
                totalAbsent = readNonNegativeInt(scanner, "Total Absent: ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        int totalSessions = 0;
        validInput = false;
        do {
            try {
                totalSessions = readPositiveInt(scanner, "Total Sessions (>0): ");
                validInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage() + " Please try again.");
            }
        } while (!validInput);

        return new AttendanceSummary(
                id,
                createdDate,
                updatedDate,
                institutionName,
                institutionCode,
                institutionAddress,
                departmentName,
                departmentHead,
                courseName,
                courseCode,
                credits,
                instructorName,
                instructorEmail,
                instructorPhone,
                studentName,
                studentId,
                studentAge,
                sessionDate,
                topic,
                attendanceStudentId,
                sessionId,
                status,
                requestDate,
                reason,
                approved,
                reportDate,
                totalPresent,
                totalAbsent,
                totalSessions
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

    private static String readMinCode(Scanner scanner, String prompt, int min) {
        String value = readNonEmpty(scanner, prompt);
        if (value.length() < min) {
            throw new IllegalArgumentException("Value must be at least " + min + " characters.");
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

    private static String readFixedDigits(Scanner scanner, String prompt, int length) {
        String digits = readNonEmpty(scanner, prompt);
        if (!digits.matches("\\d{" + length + "}")) {
            throw new IllegalArgumentException("Value must be exactly " + length + " digits.");
        }
        return digits;
    }

    private static String readStatus(Scanner scanner, String prompt) {
        String status = readNonEmpty(scanner, prompt);
        if (!(status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent"))) {
            throw new IllegalArgumentException("Status must be Present or Absent.");
        }
        return status.substring(0, 1).toUpperCase(Locale.ROOT) + status.substring(1).toLowerCase(Locale.ROOT);
    }

    private static boolean readBoolean(Scanner scanner, String prompt) {
        String value = readNonEmpty(scanner, prompt);
        if (!(value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false"))) {
            throw new IllegalArgumentException("Value must be true or false.");
        }
        return Boolean.parseBoolean(value);
    }
}

class Entity {
    private final int id;
    private final String createdDate;
    private String updatedDate;

    public Entity(int id, String createdDate, String updatedDate) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive.");
        }
        if (createdDate == null || createdDate.isBlank()) {
            throw new IllegalArgumentException("Created date cannot be empty.");
        }
        if (updatedDate == null || updatedDate.isBlank()) {
            throw new IllegalArgumentException("Updated date cannot be empty.");
        }
        this.id = id;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
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
            throw new IllegalArgumentException("Updated date cannot be empty.");
        }
        this.updatedDate = updatedDate;
    }
}

class Institution extends Entity {
    private final String institutionName;
    private final String code;
    private final String address;

    public Institution(int id, String createdDate, String updatedDate,
                       String institutionName, String code, String address) {
        super(id, createdDate, updatedDate);
        if (institutionName == null || institutionName.isBlank()) {
            throw new IllegalArgumentException("Institution name cannot be empty.");
        }
        if (code == null || code.length() < 3) {
            throw new IllegalArgumentException("Institution code must be at least 3 characters.");
        }
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address cannot be empty.");
        }
        this.institutionName = institutionName;
        this.code = code;
        this.address = address;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public String getCode() {
        return code;
    }

    public String getAddress() {
        return address;
    }
}

class Department extends Institution {
    private final String departmentName;
    private final String departmentHead;

    public Department(int id, String createdDate, String updatedDate,
                      String institutionName, String code, String address,
                      String departmentName, String departmentHead) {
        super(id, createdDate, updatedDate, institutionName, code, address);
        if (departmentName == null || departmentName.isBlank()) {
            throw new IllegalArgumentException("Department name cannot be empty.");
        }
        if (departmentHead == null || departmentHead.isBlank()) {
            throw new IllegalArgumentException("Department head cannot be empty.");
        }
        this.departmentName = departmentName;
        this.departmentHead = departmentHead;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentHead() {
        return departmentHead;
    }
}

class Course extends Department {
    private final String courseName;
    private final String courseCode;
    private final int credits;

    public Course(int id, String createdDate, String updatedDate,
                  String institutionName, String code, String address,
                  String departmentName, String departmentHead,
                  String courseName, String courseCode, int credits) {
        super(id, createdDate, updatedDate, institutionName, code, address,
                departmentName, departmentHead);
        if (courseName == null || courseName.isBlank()) {
            throw new IllegalArgumentException("Course name cannot be empty.");
        }
        if (courseCode == null || courseCode.isBlank()) {
            throw new IllegalArgumentException("Course code cannot be empty.");
        }
        if (credits <= 0) {
            throw new IllegalArgumentException("Credits must be > 0.");
        }
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getCredits() {
        return credits;
    }
}

class Instructor extends Course {
    private final String instructorName;
    private final String email;
    private final String phone;

    public Instructor(int id, String createdDate, String updatedDate,
                      String institutionName, String code, String address,
                      String departmentName, String departmentHead,
                      String courseName, String courseCode, int credits,
                      String instructorName, String email, String phone) {
        super(id, createdDate, updatedDate, institutionName, code, address,
                departmentName, departmentHead, courseName, courseCode, credits);
        if (instructorName == null || instructorName.isBlank()) {
            throw new IllegalArgumentException("Instructor name cannot be empty.");
        }
        if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email.");
        }
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be 10 digits.");
        }
        this.instructorName = instructorName;
        this.email = email;
        this.phone = phone;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}

class Student extends Instructor {
    private final String studentName;
    private final String studentId;
    private final int age;

    public Student(int id, String createdDate, String updatedDate,
                   String institutionName, String code, String address,
                   String departmentName, String departmentHead,
                   String courseName, String courseCode, int credits,
                   String instructorName, String email, String phone,
                   String studentName, String studentId, int age) {
        super(id, createdDate, updatedDate, institutionName, code, address,
                departmentName, departmentHead, courseName, courseCode, credits,
                instructorName, email, phone);
        if (studentName == null || studentName.isBlank()) {
            throw new IllegalArgumentException("Student name cannot be empty.");
        }
        if (studentId == null || studentId.isBlank()) {
            throw new IllegalArgumentException("Student ID cannot be empty.");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be > 0.");
        }
        this.studentName = studentName;
        this.studentId = studentId;
        this.age = age;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public int getAge() {
        return age;
    }
}

class ClassSession extends Student {
    private final String sessionDate;
    private final String topic;

    public ClassSession(int id, String createdDate, String updatedDate,
                        String institutionName, String code, String address,
                        String departmentName, String departmentHead,
                        String courseName, String courseCode, int credits,
                        String instructorName, String email, String phone,
                        String studentName, String studentId, int age,
                        String sessionDate, String topic) {
        super(id, createdDate, updatedDate, institutionName, code, address,
                departmentName, departmentHead, courseName, courseCode, credits,
                instructorName, email, phone, studentName, studentId, age);
        if (sessionDate == null || sessionDate.isBlank()) {
            throw new IllegalArgumentException("Session date cannot be empty.");
        }
        if (topic == null || topic.isBlank()) {
            throw new IllegalArgumentException("Topic cannot be empty.");
        }
        this.sessionDate = sessionDate;
        this.topic = topic;
    }

    public String getSessionDate() {
        return sessionDate;
    }

    public String getTopic() {
        return topic;
    }
}

class AttendanceRecord extends ClassSession {
    private final String attendanceStudentId;
    private final String sessionId;
    private final String status;

    public AttendanceRecord(int id, String createdDate, String updatedDate,
                            String institutionName, String code, String address,
                            String departmentName, String departmentHead,
                            String courseName, String courseCode, int credits,
                            String instructorName, String email, String phone,
                            String studentName, String studentId, int age,
                            String sessionDate, String topic,
                            String attendanceStudentId, String sessionId, String status) {
        super(id, createdDate, updatedDate, institutionName, code, address,
                departmentName, departmentHead, courseName, courseCode, credits,
                instructorName, email, phone, studentName, studentId, age,
                sessionDate, topic);
        if (attendanceStudentId == null || attendanceStudentId.isBlank()) {
            throw new IllegalArgumentException("Attendance student ID cannot be empty.");
        }
        if (sessionId == null || sessionId.isBlank()) {
            throw new IllegalArgumentException("Session ID cannot be empty.");
        }
        if (!(status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent"))) {
            throw new IllegalArgumentException("Status must be Present or Absent.");
        }
        this.attendanceStudentId = attendanceStudentId;
        this.sessionId = sessionId;
        this.status = status.substring(0, 1).toUpperCase(Locale.ROOT) + status.substring(1).toLowerCase(Locale.ROOT);
    }

    public String getAttendanceStudentId() {
        return attendanceStudentId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getStatus() {
        return status;
    }
}

class LeaveRequest extends AttendanceRecord {
    private final String requestDate;
    private final String reason;
    private final boolean approved;

    public LeaveRequest(int id, String createdDate, String updatedDate,
                        String institutionName, String code, String address,
                        String departmentName, String departmentHead,
                        String courseName, String courseCode, int credits,
                        String instructorName, String email, String phone,
                        String studentName, String studentId, int age,
                        String sessionDate, String topic,
                        String attendanceStudentId, String sessionId, String status,
                        String requestDate, String reason, boolean approved) {
        super(id, createdDate, updatedDate, institutionName, code, address,
                departmentName, departmentHead, courseName, courseCode, credits,
                instructorName, email, phone, studentName, studentId, age,
                sessionDate, topic, attendanceStudentId, sessionId, status);
        this.requestDate = requestDate;
        this.reason = reason;
        this.approved = approved;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public String getReason() {
        return reason;
    }

    public boolean isApproved() {
        return approved;
    }
}

final class AttendanceSummary extends LeaveRequest {
    private final String reportDate;
    private final int totalPresent;
    private final int totalAbsent;
    private final int totalSessions;

    public AttendanceSummary(int id, String createdDate, String updatedDate,
                             String institutionName, String code, String address,
                             String departmentName, String departmentHead,
                             String courseName, String courseCode, int credits,
                             String instructorName, String email, String phone,
                             String studentName, String studentId, int age,
                             String sessionDate, String topic,
                             String attendanceStudentId, String sessionId, String status,
                             String requestDate, String reason, boolean approved,
                             String reportDate, int totalPresent, int totalAbsent, int totalSessions) {
        super(id, createdDate, updatedDate, institutionName, code, address,
                departmentName, departmentHead, courseName, courseCode, credits,
                instructorName, email, phone, studentName, studentId, age,
                sessionDate, topic, attendanceStudentId, sessionId, status,
                requestDate, reason, approved);
        if (reportDate == null || reportDate.isBlank()) {
            throw new IllegalArgumentException("Report date cannot be empty.");
        }
        if (totalPresent < 0 || totalAbsent < 0) {
            throw new IllegalArgumentException("Totals cannot be negative.");
        }
        if (totalSessions <= 0) {
            throw new IllegalArgumentException("Total sessions must be > 0.");
        }
        this.reportDate = reportDate;
        this.totalPresent = totalPresent;
        this.totalAbsent = totalAbsent;
        this.totalSessions = totalSessions;
    }

    public void generateSummary() {
        double attendancePercent = (double) totalPresent / totalSessions * 100.0;
        System.out.printf("Report Date: %s%n", reportDate);
        System.out.printf("Institution: %s (%s)%n", getInstitutionName(), getCode());
        System.out.printf("Department: %s | Head: %s%n", getDepartmentName(), getDepartmentHead());
        System.out.printf("Course: %s [%s] Credits: %d%n", getCourseName(), getCourseCode(), getCredits());
        System.out.printf("Instructor: %s | Email: %s | Phone: %s%n", getInstructorName(), getEmail(), getPhone());
        System.out.printf("Student: %s (%s) Age: %d%n", getStudentName(), getStudentId(), getAge());
        System.out.printf("Session: %s Topic: %s%n", getSessionDate(), getTopic());
        System.out.printf("Attendance Record: StudentID=%s SessionID=%s Status=%s%n",
                getAttendanceStudentId(), getSessionId(), getStatus());
        System.out.printf("Leave Request: Date=%s Reason=%s Approved=%s%n",
                getRequestDate(), getReason(), isApproved());
        System.out.printf("Totals - Present: %d | Absent: %d | Sessions: %d%n",
                totalPresent, totalAbsent, totalSessions);
        System.out.printf("Attendance Percentage: %.2f%%%n", attendancePercent);
        System.out.println("Student ID: 27476");
    }
}

