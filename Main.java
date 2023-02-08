import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NewlyCreatedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String input = scanner.nextLine();
        System.out.println("Результат: ");
        System.out.println(calc(input));
    }
    public static String calc(String input) throws  NewlyCreatedException {
        int num1 = 0;
        int num2 = 0;
        String result = null;
        String[] b = input.split(" ");
        if (b.length == 1){
            throw new NewlyCreatedException("т.к. строка не является математической операцией");
        }
            boolean romane = b[0].equals("I") || b[0].equals("II") || b[0].equals("III") || b[0].equals("IV") || b[0].equals("V") || b[0].equals("VI") || b[0].equals("VII") || b[0].equals("VIII") || b[0].equals("IX") || b[0].equals("X");

            if (romane) {
                exception1(b);
                convertRomanToArab(b);
                num1 = Integer.parseInt(b[0]);
                num2 = Integer.parseInt(b[2]);
                exception(num1, num2, b);
                result = calculateRomane(b, num1, num2);
            } else {
                exception(num1,num2,b);
                num1 = Integer.parseInt(b[0]);
                num2 = Integer.parseInt(b[2]);
                exception(num1, num2, b);
                result = calculateArab(b, num1, num2);
            }
        return result;
    }
    public static void exception1(String[]b) throws NewlyCreatedException {
        boolean arab = b[0].equals("1") || b[0].equals("2") || b[0].equals("3") || b[0].equals("4") || b[0].equals("5") || b[0].equals("6") || b[0].equals("7") || b[0].equals("8") || b[0].equals("9") || b[0].equals("10") || b[2].equals("1") || b[2].equals("2") || b[2].equals("3") || b[2].equals("4") || b[2].equals("5") || b[2].equals("6") || b[2].equals("7") || b[2].equals("8") || b[2].equals("9") || b[2].equals("10");
        if (arab) {
            throw new NewlyCreatedException("т.к. используются одновременно разные системы счисления");
        }
    }
    public static void exception(int num1, int num2, String[]b) throws NewlyCreatedException {
        if (num1 < 0 || num1 > 10 || num2 < 0 || num2 > 10) {
            throw new NewlyCreatedException("т.к. калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. ");
        }

        switch (b[1]) {
            case "+":
                b[1] = "+";
                break;
            case "-":
                b[1] = "-";
                break;
            case "*":
                b[1] = "*";
                break;
            case "/":
                b[1] = "/";
                break;
            default:
                throw new NewlyCreatedException("т.к. используются неверные арифметические операции");
        }
        if (b.length > 3) {
            throw new NewlyCreatedException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        boolean romane = b[2].equals("I") || b[2].equals("II") || b[2].equals("III") || b[2].equals("IV") || b[2].equals("V") || b[2].equals("VI") || b[2].equals("VII") || b[2].equals("VIII") || b[2].equals("IX") || b[2].equals("X");
        if (romane) {
            throw new NewlyCreatedException("т.к. используются одновременно разные системы счисления");
        }
    }
    public static void convertRomanToArab(String[] num) {
        String[] roman = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        for (int i = 0; i < roman.length; i++) {
            if (num[0].equals(roman[i])) {
                num[0] = String.valueOf(i + 1);
            }
            if (num[2].equals(roman[i])) {
                num[2] = String.valueOf(i + 1);
            }
        }
    }
    public static String convertArabToRomane(String num) {
        String[] roman = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        String[] arab = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
                "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53",
                "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84",
                "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"};
        for (int i = 0; i < roman.length; i++) {
            if (num.equals(arab[i])) {
                num = roman[i];
                break;
            }
        }
        return num;
    }
    public static String calculateRomane(String[] num, int num1, int num2) throws NewlyCreatedException {
        String str1 = null;
        switch (num[1]) {
            case "+":
                int sum1 = num1 + num2;
                str1 = Integer.toString(sum1);
                break;
            case "-":
                int sum2 = num1 - num2;
                if (sum2 <= 0) {
                    throw new NewlyCreatedException("т.к. в римской системе нет отрицательных чисел");
                } else {
                    str1 = Integer.toString(sum2);
                }
                break;
            case "*":
                int sum3 = num1 * num2;
                str1 = Integer.toString(sum3);
                break;
            case "/":
                int sum4 = num1 / num2;
                if (sum4 <= 0) {
                    throw new NewlyCreatedException("т.к. в римской системе нет отрицательных чисел");
                } else {
                    str1 = Integer.toString(sum4);
                }
        }
        return convertArabToRomane(str1);
    }
    public static String calculateArab(String[] num, int num1, int num2) {
        String str2 = null;
        switch (num[1]) {
            case "+":
                int sum1 = num1 + num2;
                str2 = Integer.toString(sum1);
                break;
            case "-":
                int sum2 = num1 - num2;
                str2 = Integer.toString(sum2);
                break;
            case "*":
                int sum3 = num1 * num2;
                str2 = Integer.toString(sum3);
                break;
            case "/":
                int sum4 = num1 / num2;
                str2 = Integer.toString(sum4);
        }
        return str2;
    }
}







































