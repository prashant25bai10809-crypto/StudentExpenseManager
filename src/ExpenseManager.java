import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExpenseManager implements Report {

    private ArrayList<Expense> expenses;
    private int nextId;

    public ExpenseManager() {
        expenses = new ArrayList<>();
        nextId = 1;
    }

    public void addExpense(String category, String description, double amount, String date) {
        Expense expense = new Expense(nextId, category, description, amount, date);

        expenses.add(expense);
        nextId++;

        System.out.println("Expense added successfully!");
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("\nNo expenses found.");
            return;
        }

        System.out.println("\nALL EXPENSES");

        for (Expense expense : expenses) {
            expense.displayExpense();
            System.out.println("");
        }
    }

    public void searchExpense(String keyword) {
        boolean found = false;

        System.out.println("\nSEARCH RESULTS");

        for (Expense expense : expenses) {
            String category = expense.getCategory().toLowerCase();
            String description = expense.getDescription().toLowerCase();

            if (category.contains(keyword.toLowerCase()) ||
                description.contains(keyword.toLowerCase())) {
                expense.displayExpense();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching expense found.");
        }
    }

    public void deleteExpense(int id) {
        Iterator<Expense> iterator = expenses.iterator();

        while (iterator.hasNext()) {
            Expense expense = iterator.next();

            if (expense.getId() == id) {
                iterator.remove();
                System.out.println("Expense deleted successfully.");
                return;
            }
        }

        System.out.println("Expense with ID " + id + " not found.");
    }

    @Override
    public void monthlySummary(String monthYear) {
        double total = 0;
        int count = 0;

        HashMap<String, Double> categoryTotals = new HashMap<>();

        for (Expense expense : expenses) {
            if (expense.getDate().endsWith(monthYear)) {
                total = total + expense.getAmount();
                count++;

                String category = expense.getCategory();

                double oldAmount = categoryTotals.getOrDefault(category, 0.0);
                categoryTotals.put(category, oldAmount + expense.getAmount());
            }
        }

        System.out.println("\nMONTHLY SUMMARY");

        if (count == 0) {
            System.out.println("No expenses found for " + monthYear);
            return;
        }

        System.out.println("Month              : " + monthYear);
        System.out.println("Number of Expenses : " + count);
        System.out.println("Total Expense      : Rs." + total);

        System.out.println("\nCategory-wise Expenses:");

        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            System.out.println(entry.getKey() + " : Rs." + entry.getValue());
        }

    }

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }

    public void clearExpenses() {
        expenses.clear();
        nextId = 1;
    }

    public void addLoadedExpense(Expense expense) {
        expenses.add(expense);

        if (expense.getId() >= nextId) {
            nextId = expense.getId() + 1;
        }
    }
}
