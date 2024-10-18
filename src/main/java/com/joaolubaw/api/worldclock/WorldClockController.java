package com.joaolubaw.api.worldclock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestController
@Tag(name = "Exercise 6: Rest Server - World Clock")
public class WorldClockController {

    @GetMapping("/time")
    @Operation(summary = "Get time", description = "Gives the Local and UTC real time.")
    public TimeResponse getTime() {
        ZonedDateTime utcTime = ZonedDateTime.now(ZoneId.of("UTC"));
        LocalDateTime localTime = LocalDateTime.now();

        return new TimeResponse(utcTime.toString(), localTime.toString());
    }
}
