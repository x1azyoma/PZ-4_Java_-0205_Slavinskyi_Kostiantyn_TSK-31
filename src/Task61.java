import java.util.Arrays;

public class Task61 {

    public static void main(String[] args) {
        // Тест 1: Коректні дані
        int[] a = {2, -3, -4, 5, 0};
        int[] b = {3, -2, 5, 6, 0};
        // Очікуємо:
        // 0: 2, 3 (обидва +) -> сума 5
        // 1: -3, -2 (обидва -) -> добуток 6
        // 2: -4, 5 (різні) -> 0
        // 3: 5, 6 (обидва +) -> сума 11
        // 4: 0, 0 (інше) -> 0

        try {
            int[] c = generateArrayC(a, b);
            System.out.println("Тест 1 (Масив C): " + Arrays.toString(c));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Тест 2: Різна довжина масивів (IllegalArgumentException)
        int[] aBad = {1, 2};
        int[] bBad = {1, 2, 3};
        try {
            generateArrayC(aBad, bBad);
        } catch (IllegalArgumentException e) {
            System.out.println("Тест 2 (Різна довжина): Спіймано виключення -> " + e.getMessage());
        }

        // Тест 3: null (NullPointerException)
        try {
            generateArrayC(null, b);
        } catch (NullPointerException e) {
            System.out.println("Тест 3 (null): Спіймано виключення -> " + e.getMessage());
        }
    }

    /**
     * Формує масив C на основі масивів A і B.
     * A[i] > 0 && B[i] > 0 -> A+B
     * A[i] < 0 && B[i] < 0 -> A*B
     * інакше -> 0
     */
    public static int[] generateArrayC(int[] a, int[] b) {
        // 1. Перевірка на null
        if (a == null || b == null) {
            throw new NullPointerException("Один з масивів є null");
        }

        // 2. Перевірка на відповідність розмірів (бізнес-логіка вимагає A(n) і B(n))
        if (a.length != b.length) {
            throw new IllegalArgumentException("Масиви повинні мати однакову довжину");
        }

        int n = a.length;
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            if (a[i] > 0 && b[i] > 0) {
                // Обидва додатні: сума
                c[i] = a[i] + b[i];
            } else if (a[i] < 0 && b[i] < 0) {
                // Обидва від'ємні: добуток
                c[i] = a[i] * b[i];
            } else {
                // Всі інші випадки (різні знаки або нулі)
                c[i] = 0;
            }
        }
        return c;
    }
}