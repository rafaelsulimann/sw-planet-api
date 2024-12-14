package com.sulimann.sw_planet_api.domain;

import org.springframework.util.Assert;

import com.sulimann.sw_planet_api.utils.constants.TableName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = TableName.PLANET)
@Getter
@NoArgsConstructor(onConstructor_ = @Deprecated)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Planet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", unique = true)
  @EqualsAndHashCode.Include
  private String name;

  @Column(name = "climate")
  private String climate;

  @Column(name = "terrain")
  private String terrain;

  public Planet(String name, String climate, String terrain) {
    this.name = name;
    this.climate = climate;
    this.terrain = terrain;
    validateEntity();
  }

  private void validateEntity() {
    Assert.hasText(this.name, "Name cannot be blank or null");
    Assert.hasText(this.climate, "Climate cannot be blank or null");
    Assert.hasText(this.terrain, "Terrain cannot be blank or null");
  }

}
