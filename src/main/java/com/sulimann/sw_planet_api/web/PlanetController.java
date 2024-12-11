package com.sulimann.sw_planet_api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sulimann.sw_planet_api.domain.Planet;
import com.sulimann.sw_planet_api.domain.PlanetService;
import com.sulimann.sw_planet_api.utils.constants.ResourceURI;

@RestController
@RequestMapping(value = ResourceURI.PLANET)
public class PlanetController {

  @Autowired
  private PlanetService planetService;

  @PostMapping
  public ResponseEntity<Planet> create(@RequestBody Planet planet){
    return ResponseEntity.status(HttpStatus.CREATED).body(this.planetService.create(planet));
  }

}
