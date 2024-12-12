package com.sulimann.sw_planet_api.domain;

import com.sulimann.sw_planet_api.utils.constants.TableName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = TableName.PLANET)
@Getter
@RequiredArgsConstructor
@NoArgsConstructor(onConstructor_ = @Deprecated)
@EqualsAndHashCode
@ToString
public class Planet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NonNull
  @Column(name = "name")
  private String name;

  @NonNull
  @Column(name = "climate")
  private String climate;

  @NonNull
  @Column(name = "terrain")
  private String terrain;
}
