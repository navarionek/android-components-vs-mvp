package co.netguru.android.cityscoremvp;

import android.text.Html;
import android.text.Spanned;

public final class Utils {

    private Utils() {}

    public static Spanned stripHtml(String html) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            return Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(html);
        }
    }

    public static String capitalize(String text) {
        return text.substring(0,1).toUpperCase() + text.substring(1);
    }
}
