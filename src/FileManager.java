import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    private static final String FILE_PATH = "data/expenses.txt";

    public static void saveExpenses(ExpenseManager manager) {

        try {
            File folder = new File("data");

            if (!folder.exists()) {
                folder.mkdir();
            }

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(FILE_PATH)
            );

            for (Expense expense : manager.getExpenses()) {

                writer.write(
                        expense.getId() + "|" +
                        expense.getCategory() + "|" +
                        expense.getDescription() + "|" +
                        expense.getAmount() + "|" +
                        expense.getDate()
                );

                writer.newLine();
            }

            writer.close();

            System.out.println("Expenses saved successfully.");

        } catch (IOException e) {
            System.out.println("Could not save expenses.");
        }
    }

    public static void loadExpenses(ExpenseManager manager) {

        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("No saved expenses found.");
            return;
        }

        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(FILE_PATH)
            );

            manager.clearExpenses();

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                if (data.length == 5) {

                    int id = Integer.parseInt(data[0]);
                    String category = data[1];
                    String description = data[2];
                    double amount = Double.parseDouble(data[3]);
                    String date = data[4];

                    Expense expense = new Expense(
                            id,
                            category,
                            description,
                            amount,
                            date
                    );

                    manager.addLoadedExpense(expense);
                }
            }

            reader.close();

            System.out.println("Expenses loaded successfully.");

        } catch (IOException | NumberFormatException e) {
            System.out.println("Could not load expenses.");
        }
    }
}