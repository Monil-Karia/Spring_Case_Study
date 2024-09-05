package org.example;

import org.example.model.Customer;
import org.example.model.Loan;
import org.example.model.LoanType;
import org.example.service.LoanService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        LoanService loanService = context.getBean(LoanService.class);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to the Bank Transaction Management System");
            System.out.println("1. Add Customer");
            System.out.println("2. Delete Customer");
            System.out.println("3. Add Loan Type");
            System.out.println("4. Update Loan Type");
            System.out.println("5. Issue Loan");
            System.out.println("6. Reissue Loan");
            System.out.println("7. View Customer Loans");
            System.out.println("8. View Loans by Loan Type");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Customer
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    Customer newCustomer = new Customer();
                    newCustomer.setName(name);
                    loanService.addCustomer(newCustomer);
                    System.out.println("Customer added successfully!");
                    break;

                case 2:
                    // Delete Customer
                    System.out.print("Enter customer ID to delete: ");
                    Long customerId = scanner.nextLong();
                    loanService.deleteCustomer(customerId);
                    System.out.println("Customer deleted successfully!");
                    break;

                case 3:
                    // Add Loan Type
                    System.out.print("Enter loan type name: ");
                    String loanTypeName = scanner.nextLine();
                    LoanType newLoanType = new LoanType();
                    newLoanType.setName(loanTypeName);
                    loanService.addLoanType(newLoanType);
                    System.out.println("Loan type added successfully!");
                    break;

                case 4:
                    // Update Loan Type
                    System.out.print("Enter loan type ID to update: ");
                    Long loanTypeId = scanner.nextLong();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new loan type name: ");
                    String newLoanTypeName = scanner.nextLine();
                    loanService.updateLoanType(loanTypeId, newLoanTypeName);
                    System.out.println("Loan type updated successfully!");
                    break;

                case 5:
                    // Issue Loan
                    System.out.print("Enter customer ID: ");
                    Long issueCustomerId = scanner.nextLong();
                    System.out.print("Enter loan type ID: ");
                    Long issueLoanTypeId = scanner.nextLong();
                    System.out.print("Enter issue date (YYYY-MM-DD): ");
                    String issueDateStr = scanner.next();
                    LocalDate issueDate = LocalDate.parse(issueDateStr);
                    System.out.print("Enter end date (YYYY-MM-DD): ");
                    String endDateStr = scanner.next();
                    LocalDate endDate = LocalDate.parse(endDateStr);
                    Loan newLoan = loanService.issueLoan(issueCustomerId, issueLoanTypeId, issueDate, endDate);
                    System.out.println("Loan issued successfully! Loan ID: " + newLoan.getId());
                    break;

                case 6:
                    // Reissue Loan
                    System.out.print("Enter loan ID to reissue: ");
                    Long loanId = scanner.nextLong();
                    System.out.print("Enter new end date (YYYY-MM-DD): ");
                    String newEndDateStr = scanner.next();
                    LocalDate newEndDate = LocalDate.parse(newEndDateStr);
                    loanService.reissueLoan(loanId, newEndDate);
                    System.out.println("Loan reissued successfully!");
                    break;

                case 7:
                    // View Customer Loans
                    System.out.print("Enter customer ID to view loans: ");
                    Long viewCustomerId = scanner.nextLong();
                    List<Loan> customerLoans = loanService.getLoansByCustomer(viewCustomerId);
                    System.out.println("Loans for customer ID " + viewCustomerId + ": " + customerLoans);
                    break;

                case 8:
                    // View Loans by Loan Type
                    System.out.print("Enter loan type ID to view loans: ");
                    Long viewLoanTypeId = scanner.nextLong();
                    List<Loan> loansByType = loanService.getLoansByLoanType(viewLoanTypeId);
                    System.out.println("Loans for loan type ID " + viewLoanTypeId + ": " + loansByType);
                    break;

                case 9:
                    // Exit
                    running = false;
                    System.out.println("Exiting the application...");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }
}
