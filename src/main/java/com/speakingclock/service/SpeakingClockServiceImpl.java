package com.speakingclock.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.stereotype.Service;

import com.speakingclock.exception.InvalidTimeFormatException;

@Service
public class SpeakingClockServiceImpl implements SpeakingClockService {

    private static final String[] HOURS = {
            "twelve", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten", "eleven"
    };

    private static final String[] MINUTES = {
            "zero", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
            "twenty one", "twenty two", "twenty three", "twenty four", "twenty five",
            "twenty six", "twenty seven", "twenty eight", "twenty nine", "thirty",
            "thirty one", "thirty two", "thirty three", "thirty four", "thirty five",
            "thirty six", "thirty seven", "thirty eight", "thirty nine", "forty",
            "forty one", "forty two", "forty three", "forty four", "forty five",
            "forty six", "forty seven", "forty eight", "forty nine", "fifty",
            "fifty one", "fifty two", "fifty three", "fifty four", "fifty five",
            "fifty six", "fifty seven", "fifty eight", "fifty nine"
    };

    @Override
    public String convertTimeToWords(String time) {
        try {
            LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
            int hour = localTime.getHour();
            int minute = localTime.getMinute();

            if (hour == 0 && minute == 0) return "It's Midnight";
            if (hour == 12 && minute == 0) return "It's Midday";

            String hourWord = HOURS[hour % 12];
            String minuteWord;

            if (minute == 0) {
                minuteWord = "o'clock";
            } else {
                minuteWord = MINUTES[minute];
            }

            return String.format("It's %s %s", hourWord, minuteWord);
        } catch (DateTimeParseException e) {
            throw new InvalidTimeFormatException("Invalid time format. Please use HH:mm (24-hour).");
        }
    }

    @Override
    public String getCurrentTimeInWords() {
        LocalTime now = LocalTime.now();
        return convertTimeToWords(now.format(DateTimeFormatter.ofPattern("HH:mm")));
    }
}