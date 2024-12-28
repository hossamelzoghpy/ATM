# **ATM Application**

## **Overview**
The **ATM Application** is a web-based application built using **Java Servlets** for business logic and **JSP** for the presentation layer. This application simulates a real-world ATM machine, allowing users to perform essential banking operations such as checking balances, withdrawing cash, depositing funds, and viewing transaction history.

It is developed with a robust backend using **SQLite** for data storage, ensuring lightweight and efficient database operations. The user interface combines **HTML**, **CSS**, and **JavaScript** to provide a seamless and user-friendly experience.

---

## **Features**
- **User Authentication:** Secure login with unique card numbers and PINs.
- **Balance Inquiry:** View the current account balance.
- **Cash Withdrawal:** Withdraw money with real-time balance updates.
- **Cash Deposit:** Add funds to the account securely.
- **Mini Statement:** View recent transactions in a concise format.
- **Error Handling:** Graceful handling of invalid inputs and errors.

---

## **Technologies Used**
- **Java:** Core language for business logic and backend development.
- **Servlets:** To handle server-side logic and communication between the UI and database.
- **JSP:** For dynamic content rendering and the presentation layer.
- **SQLite:** A lightweight database for storing user data and transactions.
- **HTML/CSS/JavaScript:** For creating a responsive and user-friendly interface.
- **Maven:** For project dependency management and build automation.

---

## **System Requirements**
- **Java JDK:** Version 8 or higher.
- **Application Server:** Apache Tomcat (or any Java EE-compatible server).
- **Database:** SQLite (pre-configured database file included in the resources folder).
- **Web Browser:** Any modern browser (Google Chrome, Mozilla Firefox, etc.).

---

## **Setup and Installation**

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/ATM.git
cd ATM-Application
```

### 2. Import the Project
- Open your favorite IDE (e.g., NetBeans, IntelliJ IDEA, or Eclipse).
- Import the project as a **Maven project**.

### 3. Configure the Database
- Ensure the `ATMDB.db` file is placed in the `src/main/resources/db/` directory.
- Update the database connection URL in the `db_holder` class if required:
  ```java
  url = "jdbc:sqlite:src/main/resources/db/ATMDB.db";
  ```

### 4. Deploy the Application
- Configure the **Apache Tomcat** server in your IDE.
- Deploy the project to the server and start the server.

### 5. Access the Application
- Open your browser and navigate to:
  ```
  http://localhost:8080/ATM/
  ```

---

## **How It Works**
1. **Authentication:**
   - Users log in using their card number and PIN.
2. **Operations:**
   - Once logged in, users can perform ATM-like operations:
     - View account balance.
     - Deposit and withdraw funds.
     - Check transaction history.
3. **Transaction Recording:**
   - All transactions are logged in the database for later retrieval.

---

## **Future Enhancements**
- **Admin Panel:** Allow administrators to manage user accounts and view transaction logs.
- **Enhanced Security:** Add encryption for sensitive user data such as card numbers and PINs.
- **Multilingual Support:** Provide an option for users to interact in multiple languages.
- **Mobile-Friendly Design:** Optimize the UI for mobile devices.

---

## **Contributing**
If you’d like to contribute to this project:
1. Fork the repository.
2. Create a new branch for your feature (`git checkout -b feature-name`).
3. Commit your changes (`git commit -m "Add feature"`).
4. Push to your branch (`git push origin feature-name`).
5. Open a pull request.

---

## **License**
This project is licensed under the Hossam_Elzoghpy License 

