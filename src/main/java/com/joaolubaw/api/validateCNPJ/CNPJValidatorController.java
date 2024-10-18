package com.joaolubaw.api.validateCNPJ;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cnpjvalidator")
@Tag(name = "Exercise 1: CNPJ Validator")
public class CNPJValidatorController {
    private final Gson gson;

    public CNPJValidatorController() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(String.class, (JsonDeserializer<String>) (json, typeOfT, context) -> {
                    String str = json.getAsString();
                    return str.replaceAll("^\"|\"$", "");
                })
                .create();
    }

    @Operation(summary = "Validate CNPJ", description = "Validates a given CNPJ number. " +
            "The CNPJ number can be in 00000000000000 or 00.000.000/0000-00 format")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "CNPJ is valid",
                    content = @Content(schema = @Schema(implementation = CNPJValidationResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid CNPJ number",
                    content = @Content(schema = @Schema(type = "string", example = "That's not a valid CNPJ.")))
    })
    @PostMapping
    public ResponseEntity<CNPJValidationResponse> validateCNPJ(
            @Schema(type = "string", example = "00.000.000/0000-00", description = "CNPJ")
            @RequestBody String cnpjnumber) {

        cnpjnumber = gson.fromJson(cnpjnumber, String.class);

        try {
            CNPJValidator cnpj = new CNPJValidator(cnpjnumber);
            String message;

            if (cnpj.getFantasyName() != null && cnpj.getActivity() != null) {
                message = "Valid CNPJ.";
                return ResponseEntity.ok(new CNPJValidationResponse(message, cnpj.getFantasyName(), cnpj.getActivity()));
            } else {
                message = "Valid CNPJ, but is not linked to a company.";
                return ResponseEntity.ok(new CNPJValidationResponse(message, null, null));
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new CNPJValidationResponse(e.getMessage(), null, null));
        }
    }
}
