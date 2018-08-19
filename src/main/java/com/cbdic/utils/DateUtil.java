package com.cbdic.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by sqzhang on 2018/8/18.
 * Date util
 */
public class DateUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private static SimpleDateFormat sdf_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static LocalDate localDate(Date date) {
        return date.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDate();
    }

    public static Boolean isValidDate(Date date) {
        try{
            localDate(date);
            return true;
        } catch (Exception e) {
            System.out.println(sdf_time.format(date));
            return false;
        }
    }

    private static LocalTime localDateTime(Date date) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault()).toLocalTime();
    }

    public static Boolean isInFourWeeks(LocalDateTime beforeDate, LocalDateTime afterDate) {
        return beforeDate.plusWeeks(4).isAfter(afterDate);
    }

    public static Boolean isInNinetyDays(LocalDateTime beforeDate, LocalDateTime afterDate) {
        return beforeDate.plusDays(90).isAfter(afterDate);
    }

    public static Boolean isInHalfYear(LocalDateTime beforeDate, LocalDateTime afterDate) {
        return beforeDate.plusDays(180).isAfter(afterDate);
    }

    public static Boolean isBetweenZeroToThree(LocalDateTime date) {
        LocalTime dateTime = date.toLocalTime();
        LocalTime zero = LocalTime.of(0, 0, 0);
        LocalTime three = LocalTime.of(2, 59, 59);
        return (zero.equals(dateTime) || dateTime.isAfter(zero)) && (dateTime.isBefore(three));
    }

    public static long until(LocalDateTime startDate, LocalDateTime endDate) {
        return startDate.until(endDate, ChronoUnit.DAYS);
    }
}
