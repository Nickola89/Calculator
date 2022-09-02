
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {


        String Input = new String();
        String result = calc (Input);
        System.out.println(result);



        }

    public  static String calc (String Input) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int sum = num1+num2;

       String result = Integer.toString(sum);

        return result;

    }

    }
