import java.io.IOException;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args){
        calc("sad");
    }

    //method for calculating nums
    public static int calculation(int num1, int num2, String operation){
        int result = 0;
        if ("+".equals(operation)) {
            result = num1 + num2;
        } else if ("-".equals(operation)) {
            result = num1 - num2;
        } else if ("*".equals(operation)) {
            result = num1 * num2;
        } else if ("/".equals(operation)) {
            result = num1 / num2;
        } else {
            System.out.print("You can use only + - * / operations");
        }
        return result;
    }


    public static String calc (String input)  {
        int result = 0;
        int num1 = 0;
        int num2 = 0;
        String operation;
        Scanner in = new Scanner(System.in);


        while(true) {
            System.out.print("Input an logic expression as x + y:");
            String expression = in.nextLine();
            //splitting expression for 3 parts
            String[] parts = expression.split(" ");
            operation = parts[1];

            if (parts.length>3){
                System.out.println("Type only expression with two operand and one operator");
                return input;
            }
            //checking if it less than 10
            try {
                num1 = Integer.parseInt(parts[0]);
                num2 = Integer.parseInt(parts[2]);
                if ((num1 > 10) || (num2 > 10)) {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("One of number or both are more than 10");
                        return input;
                    }
                }
                System.out.print("Result is ");
                System.out.print(calculation(num1, num2, operation));

                //checking if it Roman numerals
            } catch (NumberFormatException e) {

                System.out.println("You typed something wrong");

            }
            return input;
        }
    }
}
