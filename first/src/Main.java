import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }
    public static String calc (String input) throws Exception {
        int num1;
        int num2;
        String oper;
        String result;
        boolean isRoman;
        String [] operands = input.split("[+\\-*/]");
        if (operands.length !=2) throw new Exception("Не больше 2 значений выражения");
        oper = detectOperation(input);
        if (Converter.isRoman(operands[0]) && Converter.isRoman(operands[1])) {
            num1 = Converter.convertToArabian(operands[0]);
            num2 = Converter.convertToArabian(operands[1]);
            isRoman = true;
        } else if (!Converter.isRoman(operands[0]) && !Converter.isRoman(operands[1])) {
            num1 = Integer.parseInt(operands[0]);
            num2 = Integer.parseInt(operands[1]);
            isRoman = false;
        }
        else throw new Exception("Выражение не удовлетворяет требованиям");

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new Exception("Неподходящие значения");
        }
        int exp = action(num1, num2, oper);
        if (isRoman) {
            if (exp <= 0) {
                throw new Exception("Результат не может быть отрицательным");
            }
            result = Converter.convertToRoman(exp);
        }
        else {
            result = String.valueOf(exp);
        }
        return result;
    }
    static String detectOperation(String input) {
        if (input.contains("+")) return "+";
        else if (input.contains("-")) return "-";
        else if (input.contains("*")) return "*";
        else if (input.contains("/")) return "/";
        else return null;
    }

    static int action(int a, int b, String oper) {
        if (oper.equals("+")) return a + b;
        if (oper.equals("-")) return a - b;
        if (oper.equals("*")) return a * b;
        else return a / b;
    }
}