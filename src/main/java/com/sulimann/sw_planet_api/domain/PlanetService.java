package com.sulimann.sw_planet_api.domain;

import org.springframework.stereotype.Service;

import com.sulimann.sw_planet_api.web.dtos.CreatePlanetRequest;
import com.sulimann.sw_planet_api.web.dtos.CreatePlanetResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanetService {

  private final PlanetRepository planetRepository;

  public CreatePlanetResponse create(CreatePlanetRequest request){
    return new CreatePlanetResponse(this.planetRepository.save(request.toEntity()));
  }

}
