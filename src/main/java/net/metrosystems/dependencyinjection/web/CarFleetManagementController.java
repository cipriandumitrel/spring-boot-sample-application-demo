package net.metrosystems.dependencyinjection.web;

import net.metrosystems.dependencyinjection.domain.persistence.Car;
import net.metrosystems.dependencyinjection.services.CarFleetManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/cars")
public class CarFleetManagementController {

  private final CarFleetManagementService carFleetManagementService;

  @Autowired
  public CarFleetManagementController(CarFleetManagementService carFleetManagementService) {
    this.carFleetManagementService = carFleetManagementService;
  }

  @GetMapping
  public List<Car> getAllCars() {
    return carFleetManagementService.getCarList();
  }

  @PostMapping
  public ResponseEntity addCar(@RequestBody Car car) {
    carFleetManagementService.addCar(car);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping
  public void removeCar(@RequestParam String licensePlate) {
    carFleetManagementService.removeCar(licensePlate);
  }

  @DeleteMapping("/removeAll")
  public void removeAllCars() {
    carFleetManagementService.removeAllCars();
  }
}
