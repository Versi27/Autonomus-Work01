package PaqI04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Container c = new Container();
        /*Scanner scan = new Scanner(System.in);
        int w = scan.nextInt();
        String co = scan.nextLine();
        c.setWeight(58);
        c.setPriority(2);
        System.out.println(c.toString());*/


        Hub h = new Hub();
        c.setPriority(1);
        h.apilar(c);
        System.out.println(h.getV()[0].length);
        System.out.println(h.getV()[8][0].country);
        System.out.println(h);

        //h.contC();


    }
}
