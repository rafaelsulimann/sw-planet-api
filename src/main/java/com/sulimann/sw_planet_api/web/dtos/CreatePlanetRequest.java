package com.sulimann.sw_planet_api.web.dtos;

import com.sulimann.sw_planet_api.domain.Planet;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatePlanetRequest {

  @NotBlank
  private String name;
  @NotBlank
  private String climate;
  @NotBlank
  private String terrain;

  public Planet toEntity() {
    return new Planet(this.name, this.climate, this.terrain);
  }

}
