# Student Expense Manager

## 1. Project Overview

Student Expense Manager is a simple Java console application designed to help students record and manage their daily expenses.

The application allows users to add, view, search, delete and summarize expenses. It also provides file-based storage so that expenses can be saved and loaded without using a database.

## 2. Features

- Add a new expense
- View all expenses
- Search expenses by category or description
- Delete an expense using its ID
- Generate a monthly expense summary
- Display category-wise expenses
- Save expenses to a text file
- Load expenses from a text file
- Input validation and exception handling

## 3. Technologies Used

- Java 21
- VS Code
- Java Collections Framework
- ArrayList
- File I/O
- Exception Handling

## 4. Project Structure

```text
StudentExpenseManager/
│
├── src/
│   ├── Main.java
│   ├── Expense.java
│   ├── ExpenseManager.java
│   ├── FileManager.java
│   └── Report.java
│
├── data/
│   └── expenses.txt
│
├── .gitignore
├── README.md
└── statement.md