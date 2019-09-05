package net.metrosystems.dependencyinjection.repositories;

import net.metrosystems.dependencyinjection.SpringBootDependencyinjectionDemoApplication;
import net.metrosystems.dependencyinjection.config.InMemoryConfig;
import net.metrosystems.dependencyinjection.domain.persistence.Car;
import net.metrosystems.dependencyinjection.services.CarFleetManagementService;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootDependencyinjectionDemoApplication.class, InMemoryConfig.class})
public class SpringBootH2IntegrationTest {

  private CarFleetManagementService carFleetManagementService;

  @Autowired
  public void setCarFleetManagementService(CarFleetManagementService carFleetManagementService) {
    this.carFleetManagementService = carFleetManagementService;
  }

  @Test
  public void testCarFleetSize() {
    carFleetManagementService.addCar(new Car("Mazda 6", 2012, "IF30AAA"));
    carFleetManagementService.addCar(new Car("Skoda Octavia", 2012, "IF31AAA"));
    assertEquals(carFleetManagementService.getCarList().size(), 2);
  }

  @Test
  public void removingCarFromFleetShouldDecreaseFleetSize() {
    carFleetManagementService.addCar(new Car("Renault Megane", 2013, "IF32AAA"));
    carFleetManagementService.addCar(new Car("Skoda Octavia", 2014, "IF33AAA"));
    carFleetManagementService.removeCar("IF33AAA");
    assertEquals(carFleetManagementService.getCarList().size(), 1);
  }

  @After
  public void destroy() {
    carFleetManagementService.removeAllCars();
  }

}
