package co.edu.uptc.control;

import java.util.ArrayList;

import co.edu.uptc.model.Bag;
import co.edu.uptc.model.Candy;
import co.edu.uptc.model.Cookie;
import co.edu.uptc.model.Donut;

public class BagControl {
    Bag<Donut> bagDonut;
    Bag<Cookie> bagCookie;
    Bag<Candy> bagCandy;

    public boolean packProductDonut(String flavor) {
        Donut donut = new Donut(flavor);
        bagDonut = new Bag<Donut>();
        bagDonut.add(donut);
        return true;
    }

    public boolean packProductCandy(int packageSize, String flavor) {
        Candy candy = new Candy(packageSize, flavor);
        bagCandy = new Bag<Candy>();
        bagCandy.add(candy);
        return true;
    }

    public boolean packProductCookie(String type) {
        Cookie cookie = new Cookie(type);
        bagCookie = new Bag<Cookie>();
        bagCookie.add(cookie);
        return true;
    }

    public ArrayList<Cookie> getBagCookies() {
        return bagCookie.getProducts();
    }

    public ArrayList<Donut> getBagDonuts() {
        return bagDonut.getProducts();
    }

    public ArrayList<Candy> getBagCandys() {
        return bagCandy.getProducts();
    }

}
