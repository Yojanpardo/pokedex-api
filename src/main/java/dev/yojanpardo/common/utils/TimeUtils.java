package dev.yojanpardo.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    public static String dateToString(final Date date) {
        final String pattern = "dd-MM-yyyy HH:mm:ss";
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

}
