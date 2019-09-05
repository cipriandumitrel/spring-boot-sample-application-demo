package net.metrosystems.dependencyinjection.domain.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Car {

  @NonNull
  private String carModel;

  @NonNull
  private Integer manufactureYear;

  @NonNull
  private String licensePlate;

  private String assignee;
}