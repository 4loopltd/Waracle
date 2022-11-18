package com.waracle.cake_manager_client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CakeDTO {

    @NotNull
    @Size(max = 255)
    private String title;

    private String description;

    @Size(max = 255)
    private String image;

}
