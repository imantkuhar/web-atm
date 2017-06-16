package com.atm.domain.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Imant on 28.05.17.
 */
@Component
public class DateUtil {

    public static final String DATE_FORMAT = "HH:mm:ss yyyy/MM/dd";

    public static String getCurrentDate(){
        return new SimpleDateFormat(DATE_FORMAT).format(Calendar.getInstance().getTime());
    }
}
