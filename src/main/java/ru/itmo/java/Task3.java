package ru.itmo.java;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null) {
            return new int[0];
        }

        int len = inputArray.length;
        int[] outputArray = new int[len];

        if (len != 0) {
            outputArray[0] = inputArray[len - 1];
        }
        for (int i = 1; i < len; ++i) {
            outputArray[i] = inputArray[i - 1];
        }
        return outputArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     * <p>
     * Если входной массив пуст или равен null - вернуть 0
     * <p>
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return 0;
        }
        if (inputArray.length == 1) {
            return inputArray[0];
        }

        int max = Integer.MIN_VALUE;
        int len = inputArray.length;
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                int p = inputArray[i] * inputArray[j];
                if (p > max) {
                    max = p;
                }
            }
        }
        return max;
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     * <p>
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int count = 0;
        int len = input.length();
        for (int i = 0; i < len; ++i) {
            char c = Character.toLowerCase(input.charAt(i));
            if (c == 'a' || c == 'b') {
                ++count;
            }
        }
        return 100 * count / len;
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        boolean ans = true;
        int len = input.length();
        for (int i = 0; i < len / 2; ++i) {
            if (input.charAt(i) != input.charAt(len - i - 1)) {
                ans = false;
                break;
            }
        }
        return ans;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        int count = 1;
        int len = input.length();
        for (int i = 1; i < len; ++i) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                ++count;
            } else {
                ans.append(input.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        ans.append(input.charAt(len - 1)).append(count);
        return ans.toString();
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null) {
            return false;
        }
        if (one.length() == 0 || two.length() == 0) {
            return false;
        }
        char[] first = one.toCharArray();
        char[] second = two.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] a = s.toCharArray();
        Arrays.sort(a);
        boolean flag = true;
        for (int i = 1; i < a.length; ++i) {
            if (a[i] == a[i - 1]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     * <p>
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null) {
            return new int[0][0];
        }
        int len = m.length;
        int[][] mT = new int[len][len];
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                mT[i][j] = m[j][i];
            }
        }
        return mT;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     * <p>
     * Запрещается пользоваться функций join
     * <p>
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        StringBuilder ans = new StringBuilder();
        if (separator == null) {
            separator = ' ';
        }
        if (inputStrings != null) {
            for (String string : inputStrings) {
                ans.append(string).append(separator.toString());
            }
            if (ans.length() != 0) {
                ans = new StringBuilder(ans.substring(0, ans.length() - 1));
            }
        }
        return ans.toString();
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        int count = 0;
        if (inputStrings != null && prefix != null) {
            for (String string : inputStrings) {
                if (string.startsWith(prefix)) {
                    ++count;
                }
            }
        }
        return count;
    }
}
