package ru.loginet.test.Test.sandBox;

import org.testng.annotations.Test;

/**
 * Created by supfe_000 on 20.09.2015.
 */
public class Pricer {
    @Test
    public void test() {
        String column = "13000,00 RUR / 0,00 RUR";
        column = column.trim();
        String priceOrg;
        String priceTr;
        String[] str = column.split("/");
        priceOrg = str[0].trim();
        priceTr = str[1].trim();

        System.out.println(priceOrg);
        System.out.println(priceTr);

    }
}
