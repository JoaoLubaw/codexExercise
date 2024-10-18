package com.joaolubaw.api.validateCNPJ;

import java.util.ArrayList;
import java.util.List;

import com.joaolubaw.api.utils.Api;

public class CNPJValidator {
    private String number;
    private String activity;
    private String fantasyName;


    public String getNumber() {
        return number;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public String getActivity() {
        return activity;
    }

    public CNPJValidator(String number) {
        if ((number.length() == 14) || (number.length() == 18)) {
            number = number.replaceAll("\\D", "").trim();
            if (Validating(number)) {
                this.number = number;
                fetchCNPJInfo();
            } else {
                throw new IllegalArgumentException("That's not a valid CNPJ.");
            }
        }
        else {
            throw new IllegalArgumentException("Doesn't look like a valid CNPJ. Accepted formats: 00.000.000/0000-00 or 00000000000000");
        }
    }

    private boolean Validating(String number){
        List<Integer> numbers = new ArrayList<>();
        int calcAssistant = 0;
        final int[] weights1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        final int[] weights2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        for (char c: number.toCharArray()) {
            numbers.add(c - '0');
        }

        for(int i = 0; i < 12; i++) {
            calcAssistant += (numbers.get(i) * weights1[i]);
        }

        calcAssistant = calcAssistant % 11;

        if (calcAssistant > 1){
            calcAssistant = 11 - calcAssistant;
        } else {
            calcAssistant = 0;
        }

        if (calcAssistant != numbers.get(12)) {
            return false;
        } else {
            calcAssistant = 0;

            for(int i = 0; i < 13; i++) {
                calcAssistant += (numbers.get(i) * weights2[i]);
            }

            calcAssistant = calcAssistant % 11;

            if (calcAssistant > 1){
                calcAssistant = 11 - calcAssistant;
            } else {
                calcAssistant = 0;
            }

            return calcAssistant == numbers.get(13);
        }
    }
    private void fetchCNPJInfo() {
        Api api = new Api();
        String[] cnpjInfo = api.getCPNJInfos(this.number);

        if(cnpjInfo != null) {
            this.fantasyName = cnpjInfo[0];
            this.activity = cnpjInfo[1];
        } else {
            System.out.println("Failed to retrieve CPNJ information.");
        }
    }
}