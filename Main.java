import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
// Задача "Строковый калькулятор"
// Описание:
// Создать консольное приложение "Строковый калькулятор".
// Приложение должно читать из консоли введенные пользователем строки, числа, арифмитические операции проводимые между ними и выводить в консоль
// результат их выполнения.
//
// Требования:
// 1.Калькулятор умеет выполнять операции сложения строк, вычитания строки из строки, умножения строки на число и деления строки на число: "a" + "b", "a" - "b", "a" * b, "a" / b. Данные передаются в одну строку(смотрите пример)! Решения, в которых каждая строка, число и арифмитеческая операция передаются с новой строки считаются неверными.
// 2.Значения строк передаваемых в выражении выделяются двойными кавычками.
// 3.Результатом сложения двух строк, является строка состоящая из переданных.
// 4.Результатом деления строки на число n, является строка в n раз короче исходной (смотрите пример).
// 5.Результатом умножения строки на число n, является строка, в которой переданная строка повторяется ровно n раз.
// 6.Результатом вычитания строки из строки, является строка, в которой удалена переданная подстрока или сама исходная строка, если в нее нет вхождения вычитаемой строки (смотрите пример).
// 7.Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. И строки длинной не более 10 символов. Если строка, полученная в результате работы приложения длинее 40 симовлов, то в выводе после 40 символа должны стоять три точки (...)
// 8.Калькулятор умеет работать только с целыми числами.
// 9.Первым аргументом выражения, подаваемого на вход, должна быть строка, при вводе пользователем выражения вроде 3 + "hello", калькулятор должен выбросить исключение и прекратить свою работу.
// 10.При вводе пользователем неподходящих чисел, строк или неподдерживаемых операций (например, деление строки на строку) приложение выбрасывает исключение и завершает свою работу.
// 11.При вводе пользователем выражения, не соответствующего одной из вышеописанных арифметических операций, приложение выбрасывает исключение и завершает свою работу.
// Пример работы программы:
// Input:
// "100" + "500"
// Output:
// "100500"
// Input:
// "Hi World!" - "World!"
//  Output:
// "Hi "
// Input:
// "Bye-bye!" - "World!"
// Output:
// "Bye-bye!"
// Input:
// "Java" * 5
// Output:
// "JavaJavaJavaJavaJava"
// Input:
// "Example Text!!!" / 3
// Output:
// "Exa"
public class test {
    static Scanner scanner = new Scanner(System.in);
    static int number;
    static char operation;
    static String result;

    public static void main(String[] args) {
        System.out.println("Введите выражение [\"a\" + \"b\", \"a\" - \"b\", \"a\" * x, \"a\" / x] где a и b - строки а x - число  от 1 до 10 включительно  + Enter ");
        // Считываем строку userInput которую ввёл пользователь
        String userInput = scanner.nextLine();
        // Создаём пустой символьный массив длиной 26 символов:  uchar
        char[] uchar = new char[26];
        // Заполняем символьный массив символами строки которую ввел пользователь и по ходу ловим знак операции
        for (int i = 0; i < userInput.length(); i++) {
            uchar[i] = userInput.charAt(i);
            if (uchar[i] == '+') {
                operation = '+';
            }
            if (uchar[i] == '-'){
                operation = '-';
            }
            if (uchar[i] == '*'){
                operation = '*';
            }
            if (uchar[i] == '/'){
                operation = '/';
            }


        }

        String[] blocks = userInput.split("[+-/*\"]");


        if (blocks.length == 5) {
            String st00 = blocks[0];
            String st01 = blocks[1];
            String st02 = blocks[2];
            String st03 = blocks[3];
            String st04 = blocks[4];
            System.out.println("-" + st00 + "-");
            System.out.println("-" + st01 + "-");
            System.out.println("-" + st02 + "-");
            System.out.println("-" + st03 + "-");
            System.out.println("-" + st04 + "-");
            System.out.println(Arrays.toString(blocks));
            System.out.println(operation);
            result = calculated(st01, st04, operation);
            System.out.println(result);
        } else {
            String st01 = blocks[1];
            String st03 = blocks[3];
            System.out.println("-" + st01 + "-");
            System.out.println("-" + st03 + "-");
            System.out.println(Arrays.toString(blocks));
            System.out.println(operation);
            number = Integer.parseInt(st03);
            result = calculated(st01, number, operation);
            System.out.println(result);
        }


    }

    public static String calculated(String num1, String num2, char op) {

        switch (op) {
            case '+' -> result = num1 + num2;
            case '-' -> {
                int resultA = num1.length() - num2.length();
                result = num1.substring(0, resultA);
            }
            case '*' -> System.out.println("Неверный знак операции * (Введите + или -)");
            case '/' -> System.out.println("Неверный знак операции / (Введите + или -)");
            default -> throw new IllegalArgumentException("Неверный знак операции");
        }
        return result;
    }

    public static String calculated(String num1, int num, char op) {
        switch (op) {
            case '+':
                System.out.println("Неверный знак операции + (введите * или /)");
                break;
            case '-':
                System.out.println("Неверный знак операции - (введите * или /)");
                break;
            case '*':
                //  При умножении строки на число выводит правильный ответ но впереди null ("a" * 5 = nullaaaaa)?
                for (int u = 0; u < num; u++) {
                    result = result + num1;
                }
                break;
            case '/':
                try {
                    int resultB = num1.length() / num;
                    result = num1.substring(0, resultB);
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");
                    break;
                } finally {
                    if (num1.length() < num){
                        System.out.println("Делимое меньше делителя");
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Неверный знак операции");
        }
        return result;
    }
}
