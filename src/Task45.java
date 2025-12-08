public class Task45 {

    public static void main(String[] args) {
        // Тест 1: Валідний масив
        // Індекси:   0  1   2   3  4  5   6   7  8
        int[] arr = {10, -5, 2, 8, 20, 6, -3, 4, -5};
        // Перевіряємо індекси 0, 4, 8.
        // arr[0]=10 (>0), arr[4]=20 (>0), arr[8]=-5 (не >0). Разом: 2.

        try {
            int res = countPositiveAtMultipleOfFourIndex(arr);
            System.out.println("Тест 1 (Результат): " + res);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Тест 2: Масив null
        try {
            countPositiveAtMultipleOfFourIndex(null);
        } catch (NullPointerException e) {
            System.out.println("Тест 2 (null): Спіймано виключення -> " + e.getMessage());
        }
    }

    /**
     * Знаходить кількість додатних елементів, індекс яких кратний 4.
     * Використовує цикл for.
     */
    public static int countPositiveAtMultipleOfFourIndex(int[] array) {
        if (array == null) {
            throw new NullPointerException("Вхідний масив є null");
        }

        int count = 0;
        // Вимога: використання циклу for, бо нам потрібен індекс
        for (int i = 0; i < array.length; i++) {
            // Умова: індекс кратний 4 ТА елемент додатний (> 0)
            if (i % 4 == 0 && array[i] > 0) {
                count++;
            }
        }
        return count;
    }
}