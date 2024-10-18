package com.joaolubaw.api.worldclock;

import com.joaolubaw.api.utils.Api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WorldClock {
    private String currentUTCDateTime;
    private String currentLocalDateTime;
    private Api api = new Api();

    public String getCurrentUTCDateTime() {
        updateTime();
        return currentUTCDateTime;
    }

    public String getCurrentLocalDateTime() {
        updateTime();
        return currentLocalDateTime;
    }

    public void updateTime() {
        this.currentUTCDateTime = api.getCurrentUTCTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.currentLocalDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public TimeResponse  GetCurrentTime() {
        updateTime();
        return new TimeResponse(this.currentUTCDateTime, this.currentLocalDateTime);
    }


}
