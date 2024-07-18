package control.finance.domain;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {
    public static String formatToUSD(double number) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        return formatter.format(number);
    }
}
