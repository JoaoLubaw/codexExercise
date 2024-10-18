package com.joaolubaw.api.worldclock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Exercise 5: Rest Client - World Clock")
public class WorldClockExternApiController {

    @GetMapping("/timefromexternapi")
    @Operation(summary = "Get time directly from extern api. ", description = "Get the result of a api rest client, " +
            "consuming worldclockapi.com")
    public TimeResponse getTime() {
        WorldClock worldClock = new WorldClock();

        return worldClock.GetCurrentTime();
    }
}
