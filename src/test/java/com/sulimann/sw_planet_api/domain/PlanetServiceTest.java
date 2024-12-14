package com.sulimann.sw_planet_api.domain;

import static com.sulimann.sw_planet_api.common.PlanetConstants.CREATE_PLANET_RESPONSE;
import static com.sulimann.sw_planet_api.common.PlanetConstants.CREATE_PLANTET_REQUEST;
import static com.sulimann.sw_planet_api.common.PlanetConstants.INVALID_CREATE_PLANTET_REQUEST;
import static com.sulimann.sw_planet_api.common.PlanetConstants.PLANET;
import static com.sulimann.sw_planet_api.common.PlanetConstants.PLANET_SAVED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sulimann.sw_planet_api.web.dtos.CreatePlanetResponse;

@ExtendWith(MockitoExtension.class)
public class PlanetServiceTest {

  @InjectMocks
  private PlanetService planetService;

  @Mock
  private PlanetRepository planetRepository;

  @Test
  @DisplayName("Deve criar um planeta chamando o repository.save e retornando o planeta criado")
  void shouldCreateAPlanetWithSucess(){
    when(this.planetRepository.save(PLANET)).thenReturn(PLANET_SAVED);

    CreatePlanetResponse response = this.planetService.create(CREATE_PLANTET_REQUEST);

    verify(this.planetRepository, times(1)).save(argThat(planet -> {
      assertThat(planet).usingRecursiveComparison().isEqualTo(PLANET);
      return true;
    }));
    verifyNoMoreInteractions(this.planetRepository);

    assertThat(response).isNotNull();
    assertThat(response).usingRecursiveComparison().isEqualTo(CREATE_PLANET_RESPONSE);
  }

  @Test
  void shouldBeThrowAIllegalArgumentExceptionWhenCreatePlanetRequestIsInvalid(){
    assertThatThrownBy(() -> this.planetService.create(INVALID_CREATE_PLANTET_REQUEST)).isInstanceOf(IllegalArgumentException.class);
  }


}
