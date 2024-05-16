package com.postech.adapter.driver.api.controller;

import com.postech.adapter.driver.api.dto.ErrorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/swagger", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "swagger-example")
public class SwaggerController {

    //Swagger: http://localhost:8080/cafeteria/swagger-ui
    //Swagger yml: http://localhost:8080/cafeteria/api-docs

    @Operation(summary = "Test example", method = "GET", description = "This api is for example only")
    @ApiResponses(value = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "400", description = "Error example", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))),
    })
    @GetMapping
    public ResponseEntity<?> errorTest() {
        return ResponseEntity.badRequest().body(new ErrorDTO("400", "Error example"));
    }

}