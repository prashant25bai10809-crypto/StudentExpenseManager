import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        int choice = 0;

        do {

            System.out.println("STUDENT EXPENSE MANAGER");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Search Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Monthly Summary");
            System.out.println("6. Save Expenses");
            System.out.println("7. Load Expenses");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:
                        System.out.println("\n--- Add Expense ---");

                        System.out.print("Enter category: ");
                        String category = scanner.nextLine();

                        System.out.print("Enter description: ");
                        String description = scanner.nextLine();

                        System.out.print("Enter amount: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Enter date (DD-MM-YYYY): ");
                        String date = scanner.nextLine();

                        if (amount <= 0) {
                            System.out.println("Amount should be greater than zero.");
                        } else {
                            manager.addExpense(category, description, amount, date);
                        }
                        break;

                    case 2:
                        manager.viewExpenses();
                        break;

                    case 3:
                        System.out.print("\nEnter category or description: ");
                        String keyword = scanner.nextLine();

                        manager.searchExpense(keyword);
                        break;

                    case 4:
                        System.out.print("\nEnter expense ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        manager.deleteExpense(id);
                        break;

                    case 5:
                        System.out.print("\nEnter month and year (MM-YYYY): ");
                        String monthYear = scanner.nextLine();

                        manager.monthlySummary(monthYear);
                        break;

                    case 6:
                        FileManager.saveExpenses(manager);
                        break;

                    case 7:
                        FileManager.loadExpenses(manager);
                        break;

                    case 8:
                        System.out.println("\nThank you for using Student Expense Manager!");
                        break;

                    default:
                        System.out.println("Please enter a number between 1 and 8.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
                choice = 0;
            }

        } while (choice != 8);

        scanner.close();
    }
}