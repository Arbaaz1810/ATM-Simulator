# ATM Simulator

## Project Description
The ATM Simulator is a Java-based application that simulates basic ATM operations. It uses Hibernate for ORM and MySQL for database management. The application performs basic CRUD (Create, Read, Update, Delete) operations.

## Features
- Create a new bank account
- View account details
- Update account information
- Delete an account
- Deposit and withdraw money

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- Eclipse IDE
- Apache Maven
- MySQL Database
- MySQL Workbench

## Installation and Setup
- Import Project into Eclipse
   -Open Eclipse and select File > Import.
   -Choose Existing Maven Projects and click Next.
   -Browse to the location of the cloned repository and click Finish.
   
- Configure MySQL Database
   -Open MySQL Workbench and create a new schema called atm_simulator.
   -Update the hibernate.cfg.xml file with your MySQL username and password.

- Build the Project
   -Right-click on the project in the Project Explorer.
   -Select Run As > Maven install to build the project and download dependencies.

- Run the Application
   -Right-click on the MainApplication class in the Project Explorer.
   -Select Run As > Java Application.

### Clone the Repository
```bash
git clone https://github.com/Arbaaz1810/ATM-Simulator.git
