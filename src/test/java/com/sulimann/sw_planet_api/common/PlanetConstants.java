package com.sulimann.sw_planet_api.common;

import org.springframework.test.util.ReflectionTestUtils;

import com.sulimann.sw_planet_api.domain.Planet;
import com.sulimann.sw_planet_api.web.dtos.CreatePlanetRequest;
import com.sulimann.sw_planet_api.web.dtos.CreatePlanetResponse;

public class PlanetConstants {

  public static final CreatePlanetRequest CREATE_PLANTET_REQUEST = new CreatePlanetRequest("Terra", "Topzera", "Mto boa");
  public static final CreatePlanetRequest INVALID_CREATE_PLANTET_REQUEST = new CreatePlanetRequest("", "", "");
  public static final Planet PLANET = new Planet("Terra", "Topzera", "Mto boa");
  public static final Planet PLANET_SAVED;
  public static final CreatePlanetResponse CREATE_PLANET_RESPONSE;
  static {
    PLANET_SAVED = new Planet("Terra", "Topzera", "Mto boa");
    ReflectionTestUtils.setField(PLANET_SAVED, "id", 1L);
    CREATE_PLANET_RESPONSE = new CreatePlanetResponse(PLANET_SAVED);
  }

}
