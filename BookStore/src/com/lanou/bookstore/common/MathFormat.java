package com.lanou.bookstore.common;

import java.text.DecimalFormat;

public class MathFormat {

    public static double formatDouble(double d) {
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.parseDouble(df.format(d));
    }

    public static float formatFloat(float d) {
        DecimalFormat df = new DecimalFormat("#.00");
        return Float.parseFloat(df.format(d));
    }

}
