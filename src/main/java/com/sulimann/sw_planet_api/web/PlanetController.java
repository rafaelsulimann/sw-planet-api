package com.sulimann.sw_planet_api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sulimann.sw_planet_api.domain.PlanetService;
import com.sulimann.sw_planet_api.utils.constants.ResourceURI;
import com.sulimann.sw_planet_api.web.dtos.CreatePlanetRequest;
import com.sulimann.sw_planet_api.web.dtos.CreatePlanetResponse;

@RestController
@RequestMapping(value = ResourceURI.PLANET)
public class PlanetController {

  @Autowired
  private PlanetService planetService;

  @PostMapping
  public ResponseEntity<CreatePlanetResponse> create(@RequestBody CreatePlanetRequest request){
    return ResponseEntity.status(HttpStatus.CREATED).body(this.planetService.create(request));
  }

}
