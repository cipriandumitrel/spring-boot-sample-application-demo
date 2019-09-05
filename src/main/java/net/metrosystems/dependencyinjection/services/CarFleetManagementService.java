package net.metrosystems.dependencyinjection.services;

import net.metrosystems.dependencyinjection.domain.persistence.Car;

import java.util.List;

public interface CarFleetManagementService {

  List<Car> getCarList();

  void addCar(Car car);

  void removeCar(String licensePlate);

  void removeAllCars();
}
