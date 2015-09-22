package ru.loginet.test.ojects;

/**
 * Created by supfe_000 on 20.09.2015.
 */
public class Pricer {
    public static boolean compare(String prices) {
        String[] str = prices.split("/");
        String priceOrg = str[0].trim();
        String priceTr = str[1].trim();
        return priceOrg.equals(priceTr);
    }

    public static String normalize(String unnormalPrice) {
        String[] str = unnormalPrice.split(",");
        return str[0];
    }
}
