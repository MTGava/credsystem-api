package com.api.credsystem.manager.utils;

import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
public class Utils {
    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static String generateRandomNumber(int length) {
        String randomValue;
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < length; i++) {
            randomValue = String.valueOf(Math.random() * 10);
            number.append(randomValue.charAt(0));
        }
        return String.valueOf(number);
    }
}
