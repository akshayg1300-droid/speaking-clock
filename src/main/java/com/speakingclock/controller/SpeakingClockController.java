package com.speakingclock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.speakingclock.dto.TimeRequestDto;
import com.speakingclock.service.SpeakingClockService;

@RestController
@RequestMapping("/api/clock")
public class SpeakingClockController {

    @Autowired
    private SpeakingClockService speakingClockService;

    @GetMapping("/now")
    public ResponseEntity<String> getCurrentTimeInWords() {
        return ResponseEntity.ok(speakingClockService.getCurrentTimeInWords());
    }

    @PostMapping("/convert")
    public ResponseEntity<String> convertUserTime(@RequestBody TimeRequestDto request) {
        return ResponseEntity.ok(speakingClockService.convertTimeToWords(request.getTime()));
    }

}