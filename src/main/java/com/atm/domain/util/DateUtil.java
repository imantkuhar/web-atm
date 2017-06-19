package com.atm.domain.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Imant on 28.05.17.
 */
public class DateUtil {

    public static final String DATE_FORMAT = "HH:mm:ss yyyy/MM/dd";

    public static String getCurrentDate(){
        return new SimpleDateFormat(DATE_FORMAT).format(Calendar.getInstance().getTime());
    }
}
