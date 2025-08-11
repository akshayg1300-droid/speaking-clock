package com.speakingclock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.speakingclock.exception.InvalidTimeFormatException;
import com.speakingclock.service.SpeakingClockServiceImpl;

public class SpeakingClockServiceImplTest {

    private SpeakingClockServiceImpl speakingClockService;

    @BeforeEach
    public void setUp() {
        speakingClockService = new SpeakingClockServiceImpl();
    }

    @Test
    public void testConvertTimeToWords_Midnight() {
        String result = speakingClockService.convertTimeToWords("00:00");
        assertEquals("It's Midnight", result);
    }

    @Test
    public void testConvertTimeToWords_Midday() {
        String result = speakingClockService.convertTimeToWords("12:00");
        assertEquals("It's Midday", result);
    }

    @Test
    public void testConvertTimeToWords_ExactHour() {
        String result = speakingClockService.convertTimeToWords("08:00");
        assertEquals("It's eight o'clock", result);
    }

    @Test
    public void testConvertTimeToWords_WithMinutes() {
        String result = speakingClockService.convertTimeToWords("14:35");
        assertEquals("It's two thirty five", result);
    }

    @Test
    public void testConvertTimeToWords_InvalidFormat() {
        assertThrows(InvalidTimeFormatException.class, () -> {
            speakingClockService.convertTimeToWords("8:00 AM");
        });
    }

    @Test
    public void testConvertTimeToWords_InvalidInput() {
        assertThrows(InvalidTimeFormatException.class, () -> {
            speakingClockService.convertTimeToWords("invalid-time");
        });
    }

    @Test
    public void testGetCurrentTimeInWords() {
        // Just check that method doesn't throw and returns a non-null, non-empty string
        String result = speakingClockService.getCurrentTimeInWords();
        assertNotNull(result);
        assertTrue(result.startsWith("It's "));
    }
}