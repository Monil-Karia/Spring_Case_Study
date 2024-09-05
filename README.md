# Bank Transaction Management System

## Overview

This project is a console-based bank transaction management system built using the Spring Framework and Hibernate ORM. It allows you to manage bank loans, customers, and loan types through a menu-driven interface.

## Features

- **Customer Management**: Add and delete customers.
- **Loan Type Management**: Add and update loan types.
- **Loan Management**: Issue, reissue, and view loans.
- **Search Functionality**: Retrieve loans by customer or loan type.

## Technologies

- **Java**: Programming language.
- **Spring Framework**: Dependency Injection, transaction management.
- **Hibernate ORM**: Object-Relational Mapping.
- **Oracle Database**: Database (configured in `hibernate.cfg.xml`).
- **Maven**: Build and dependency management tool.

## Project Flow and Functionality

### Overview

The Bank Transaction Management System is a console-based application designed to manage customers, loan types, and loans using the Spring Framework and Hibernate ORM. The application allows users to perform various operations related to loans and customer management.

### Functionality

#### 1. Customer Management

- **Add Customer**
    - **Function**: Adds a new customer to the system.
    - **Inputs**: Customer name.
    - **Output**: Confirmation of customer creation.

- **Delete Customer**
    - **Function**: Deletes an existing customer from the system.
    - **Inputs**: Customer ID.
    - **Output**: Confirmation of customer deletion.

#### 2. Loan Type Management

- **Add Loan Type**
    - **Function**: Adds a new type of loan to the system.
    - **Inputs**: Loan type name (e.g., Personal, Home, Car).
    - **Output**: Confirmation of loan type creation.

- **Update Loan Type**
    - **Function**: Updates the details of an existing loan type.
    - **Inputs**: Loan type ID, new loan type name.
    - **Output**: Confirmation of loan type update.

#### 3. Loan Management

- **Issue Loan**
    - **Function**: Issues a new loan to a customer.
    - **Inputs**: Customer ID, Loan Type ID, Issue Date, End Date.
    - **Output**: Confirmation of loan issuance.

- **Reissue Loan**
    - **Function**: Extends the end date of an existing loan.
    - **Inputs**: Loan ID, new end date.
    - **Output**: Confirmation of loan reissuance.

- **View Loans by Customer**
    - **Function**: Displays all loans associated with a specific customer.
    - **Inputs**: Customer ID.
    - **Output**: List of loans for the specified customer.

- **View Loans by Loan Type**
    - **Function**: Displays all loans of a specific loan type.
    - **Inputs**: Loan Type ID.
    - **Output**: List of loans for the specified loan type.

### Project Flow

1. **Initialization**
    - The application is initialized by setting up the Spring context and loading configuration from `AppConfig.java` and `hibernate.cfg.xml`.

2. **Menu Display**
    - Upon starting the application, a menu is displayed to the user with options to manage customers, loan types, and loans.

3. **User Interaction**
    - The user selects an option from the menu. Based on the selection, the application performs the following:
        - **Add or Delete Customer**: The application interacts with `CustomerService` to add or remove customer records.
        - **Add or Update Loan Type**: The application interacts with `LoanTypeService` to add or update loan type records.
        - **Issue or Reissue Loan**: The application interacts with `LoanService` to issue new loans or reissue existing loans.
        - **View Loans**: The application retrieves and displays loans based on the specified criteria (customer or loan type).

4. **Processing Requests**
    - For operations such as adding, updating, or deleting records, the application uses the corresponding service methods in `LoanService`, `CustomerService`, and `LoanTypeService`.

5. **Database Interaction**
    - All data interactions are managed using Hibernate ORM, which maps Java objects to database tables and handles CRUD operations through repository interfaces.

6. **Output**
    - Results of operations (e.g., confirmation messages, lists of loans) are displayed to the user via the console.

7. **Exit**
    - The user can exit the application by selecting the appropriate menu option.

### Example Workflow

**Example 1: Issuing a Loan**
1. User selects "Issue Loan" from the menu.
2. User provides Customer ID, Loan Type ID, Issue Date, and End Date.
3. Application validates inputs and calls `LoanService.issueLoan()`.
4. The loan is added to the database, and a confirmation message is displayed.

**Example 2: Viewing Loans by Customer**
1. User selects "View Loans by Customer" from the menu.
2. User provides Customer ID.
3. Application retrieves loans associated with the given Customer ID using `LoanService.getLoansByCustomer()`.
4. A list of loans is displayed to the user.

### Conclusion

The Bank Transaction Management System provides a robust and user-friendly interface for managing bank loans, customers, and loan types. It leverages the Spring Framework for dependency injection and transaction management, while Hibernate ORM handles database interactions. The menu-driven approach ensures ease of use and effective management of banking transactions.


