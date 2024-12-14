package com.sulimann.sw_planet_api.web.dtos;

import com.sulimann.sw_planet_api.domain.Planet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatePlanetResponse {

  private Long id;
  private String name;
  private String climate;
  private String terrain;

  public CreatePlanetResponse(Planet planet) {
    this.id = planet.getId();
    this.name = planet.getName();
    this.climate = planet.getClimate();
    this.terrain = planet.getTerrain();
  }

}
