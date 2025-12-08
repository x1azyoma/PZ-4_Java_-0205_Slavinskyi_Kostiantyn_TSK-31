public class Task15 {

    public static void main(String[] args) {
        // Тест 1: Звичайний масив
        int[] array1 = {5, 10, 3, 7, 25, 0, -10};
        try {
            int result = countMultiplesOfFive(array1);
            System.out.println("Тест 1 (Нормальний): " + result); // Очікується: 5 (5, 10, 25, 0, -10)
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }

        // Тест 2: Порожній масив
        int[] array2 = {};
        try {
            System.out.println("Тест 2 (Порожній): " + countMultiplesOfFive(array2)); // Очікується: 0
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }

        // Тест 3: null (Перевірка виключення)
        int[] array3 = null;
        try {
            countMultiplesOfFive(array3);
        } catch (NullPointerException e) {
            System.out.println("Тест 3 (null): Спіймано очікуване виключення -> " + e.getMessage());
        }
    }

    /**
     * Знаходить кількість елементів, що кратні 5.
     * Використовує цикл for-each.
     */
    public static int countMultiplesOfFive(int[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }

        int count = 0;
        // Вимога: використання for-each
        for (int element : array) {
            // 0 ділиться на будь-що без остачі, тому вважаємо його кратним 5
            if (element % 5 == 0) {
                count++;
            }
        }
        return count;
    }
}
