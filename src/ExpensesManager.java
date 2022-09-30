import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {
    HashMap <String, ArrayList<Double>> expensesByCategories; // Замените на таблицу с именем expensesByCategories

    ExpensesManager() {
        expensesByCategories = new HashMap<>(); // Создайте таблицу
    }

    // Добавьте в метод ещё один параметр — category
    double saveExpense(double moneyBeforeSalary, double expense, String category) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        //expensesByCategories.get(category).add(expense); // Замените на работу с таблицей
        if (expensesByCategories.containsKey(category)){ // Проверьте наличие категории
            // Получите список трат в этой категории
            // Добавьте трату
            expensesByCategories.get(category).add(expense);
        } else {
            // Создайте новый список трат и добавьте в него сумму
            // Сохраните категорию и новый список трат в хеш-таблицу
            ArrayList<Double> expenses = new ArrayList<>();
            expenses.add(expense);
            expensesByCategories.put(category, expenses);
        }
        if (moneyBeforeSalary < 1000) {
        System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }


    void printAllExpensesByCategories() {
        // Замените логику для работы с таблицами
        for (String category : expensesByCategories.keySet()) {
            System.out.println(category);
            for (Double expense : expensesByCategories.get(category)) {
                System.out.println(expense);
            }
        }
    }
 //       for (int i = 0; i < expenses.size(); i++) {
 //           System.out.println("Трата № " + (i + 1) + ". Потрачено " + expenses.get(i) + " рублей");
 //       }


    // Метод должен принимать название категории и называться findMaxExpenseInCategory
    double findMaxExpenseInCategory(String category) {
        double maxExpense = 0;
        if (expensesByCategories.containsKey(category)){
            for (Double expense : expensesByCategories.get(category)){
                if (expense > maxExpense) {
                    maxExpense = expense;
                }
            }
        } else {
            System.out.println("Такой категории пока нет.");
        }
        return maxExpense;
    }
        /* Замените логику для работы с таблицами
        Если категория есть, то ищем максмальную трату.
        Иначе печатаем "Такой категории пока нет." */
//        for (Double exp : expenses) {
//            if (exp > maxExpense) {
//                maxExpense = exp;
//            }
//        }
//        return maxExpense;
//    }

    void removeAllExpenses() {
        expensesByCategories.clear(); // Таблица называется иначе
        System.out.println("Траты удалены.");
    }
}