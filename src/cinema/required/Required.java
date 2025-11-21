package cinema.required;

import java.util.Scanner;

public class Required {
    Scanner sc = new Scanner(System.in);
    public int inputInteger(String text){
        System.out.println(text);
        int input= sc.nextInt();
        sc.nextLine();
        return input;
    }

    public String inputString(String text){
        System.out.println(text);
        return sc.nextLine();
    }
}
