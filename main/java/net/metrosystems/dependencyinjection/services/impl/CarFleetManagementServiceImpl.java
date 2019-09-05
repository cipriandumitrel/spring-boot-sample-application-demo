package net.metrosystems.dependencyinjection.services.impl;

import net.metrosystems.dependencyinjection.domain.persistence.Car;
import net.metrosystems.dependencyinjection.repositories.CarFleetDAO;
import net.metrosystems.dependencyinjection.services.CarFleetManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarFleetManagementServiceImpl implements CarFleetManagementService {

  private CarFleetDAO carFleetDAO;

  @Autowired
  public CarFleetManagementServiceImpl(CarFleetDAO carFleetDAO) {
    this.carFleetDAO = carFleetDAO;
  }

  @Override
  public List<Car> getCarList() {
    return carFleetDAO.getCarList();
  }

  @Override
  public void addCar(Car car) {
    carFleetDAO.addCar(car);
  }

  @Override
  public void removeCar(String licensePlate) {
    carFleetDAO.removeCar(licensePlate);
  }

  @Override
  public void removeAllCars() {
    carFleetDAO.removeAllCars();
  }
}
