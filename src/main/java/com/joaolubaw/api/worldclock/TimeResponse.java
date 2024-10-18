package com.joaolubaw.api.worldclock;

public class TimeResponse {
    private String utcTime;
    private String localTime;

    public TimeResponse(String utcTime, String localTime) {
        this.utcTime = utcTime;
        this.localTime = localTime;
    }

    public String getUtcTime() {
        return utcTime;
    }

    public String getLocalTime() {
        return localTime;
    }
}
