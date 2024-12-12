package com.sulimann.sw_planet_api.domain;

import com.sulimann.sw_planet_api.utils.constants.TableName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = TableName.PLANET)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(onConstructor_ = @Deprecated)
@EqualsAndHashCode
@ToString
public class Planet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "climate")
  private String climate;

  @Column(name = "terrain")
  private String terrain;

}
