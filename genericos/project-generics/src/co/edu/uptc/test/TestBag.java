package co.edu.uptc.test;

import java.util.ArrayList;
import java.util.Scanner;

import co.edu.uptc.control.BagControl;

public class TestBag {
    public static void main(String[] args) {
        String flavorDonut = "", typeCookie = "", flavorCandy = "";
        int packageSize = 0;
        ArrayList bagCookies, bagCandys, bagDonuts;
        boolean c = false, d = false, co = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Shopping!!");
        System.out.println("enter the flavor of donuts");
        flavorDonut = sc.nextLine();
        System.out.println("enter the type of cookie");
        typeCookie = sc.nextLine();
        System.out.println("enter the packageSize of candy");
        packageSize = sc.nextInt();
        sc.nextLine();
        System.out.println("enter the flavor of candy");
        flavorCandy = sc.nextLine();

        BagControl bc = new BagControl();
        c = bc.packProductCandy(packageSize, flavorCandy);
        d = bc.packProductDonut(flavorCandy);
        co = bc.packProductCookie(typeCookie);

        bagCookies = bc.getBagCookies();
        System.out.println("Bag of cookies");
        for (int i = 0; i < bagCookies.size(); i++) {
            System.out.println(i + 1 + " " + bagCookies.get(i));
        }

        bagDonuts = bc.getBagDonuts();
        System.out.println("Bag of donuts");
        for (int i = 0; i < bagDonuts.size(); i++) {
            System.out.println(i + 1 + " " + bagDonuts.get(i));
        }

        bagCandys = bc.getBagCandys();
        System.out.println("Bag of candys");
        for (int i = 0; i < bagCandys.size(); i++) {
            System.out.println(i + 1 + " " + bagCandys.get(i));
        }
    }
}
