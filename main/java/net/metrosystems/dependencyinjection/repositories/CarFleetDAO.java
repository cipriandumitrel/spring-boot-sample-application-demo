package net.metrosystems.dependencyinjection.repositories;

import net.metrosystems.dependencyinjection.domain.persistence.Car;

import java.util.List;

public interface CarFleetDAO {

  List<Car> getCarList();

  void addCar(Car car);

  void removeCar(String licensePlate);

  void removeAllCars();
}
