package com.ennovate.gildedrose.products.quality;

public class QualityScaleDeterminer {

    public static final int ZERO_SCALE = 0;
    public static final int NORMAL_SCALE = 1;
    public static final int MEDIUM_SCALE = 2;
    public static final int RAPID_SCALE = 3;

    public static final int SELL_IN_SCALE_1 = 11;
    public static final int SELL_IN_SCALE_2 = 6;

    public static int determine(boolean sellInPassed, int mediumScale, int normalScale) {
        if (sellInPassed) {
            return mediumScale;
        }
        return normalScale;
    }

    public static int determine(boolean sellInPassed) {
        return determine(sellInPassed, MEDIUM_SCALE, NORMAL_SCALE);
    }

    public static int determine(boolean sellInPassed, int sellInDays) {
        if (sellInPassed) {
            return ZERO_SCALE;
        } else if (tenDaysOrLess(sellInDays)) {
            return MEDIUM_SCALE;
        } else if (fiveDaysOrLess(sellInDays)) {
            return RAPID_SCALE;
        }
        return NORMAL_SCALE;
    }

    private static boolean fiveDaysOrLess(int sellInDays) {
        return sellInDays < SELL_IN_SCALE_2;
    }

    private static boolean tenDaysOrLess(int sellInDays) {
        return sellInDays >= SELL_IN_SCALE_2 && sellInDays < SELL_IN_SCALE_1;
    }
}
