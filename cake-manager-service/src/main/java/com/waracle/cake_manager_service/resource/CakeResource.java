package com.waracle.cake_manager_service.resource;

import com.waracle.cake_manager_service.model.CakeDTO;
import com.waracle.cake_manager_service.service.CakeService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class CakeResource {

    private final CakeService cakeService;

    public CakeResource(final CakeService cakeService) {
        this.cakeService = cakeService;
    }

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getCakesString() {
        // Not strictly restful - confirm requirements
        return ResponseEntity.ok(
                cakeService.findAll()
                        .stream()
                        .map(CakeDTO::toString)
                        .collect(Collectors.joining(", "))
        );
        // Alternatively as a more web readable resp
        // map to HTML & produces = MediaType.TEXT_HTML_VALUE
    }

    @GetMapping(value = "/cakes")
    public ResponseEntity<List<CakeDTO>> getAllCakes() {
        return ResponseEntity.ok(cakeService.findAll());
    }

    @PostMapping("/cakes")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createCake(@RequestBody @Valid final CakeDTO cakeDTO) {
        return new ResponseEntity<>(cakeService.create(cakeDTO), HttpStatus.CREATED);
    }

}
