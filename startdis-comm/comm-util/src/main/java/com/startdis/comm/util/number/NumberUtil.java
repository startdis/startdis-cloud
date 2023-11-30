package com.startdis.comm.util.number;

import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberUtil {

    AtomicInteger count = new AtomicInteger(0);

    public String getNumb() {
        String newNumb = "";
        Integer integer = Integer.valueOf(count.get()) + 1;
        DecimalFormat decimalFormat = new DecimalFormat("0000");
        if (integer < 9999) {
            newNumb = decimalFormat.format(integer);
            return newNumb;
        } else {
            newNumb = decimalFormat.format(integer);
            return newNumb;
        }
    }


    public static void main(String[] args) {
        System.out.println(new NumberUtil().getNumb());
    }
}
