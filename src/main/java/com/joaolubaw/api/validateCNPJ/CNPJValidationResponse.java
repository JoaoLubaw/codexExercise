package com.joaolubaw.api.validateCNPJ;

public class CNPJValidationResponse {
    private String message;
    private String fantasyName;
    private String activity;

    public CNPJValidationResponse(String message, String fantasyName, String activity) {
        this.message = message;
        this.fantasyName = fantasyName;
        this.activity = activity;
    }

    public String getMessage() {
        return message;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public String getActivity() {
        return activity;
    }
}
