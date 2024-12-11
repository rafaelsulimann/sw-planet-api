package com.sulimann.sw_planet_api.domain;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanetService {

  private final PlanetRepository planetRepository;

  public Planet create(Planet planet){
    return this.planetRepository.save(planet);
  }

}
