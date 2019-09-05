package net.metrosystems.dependencyinjection.domain.mapper;

import net.metrosystems.dependencyinjection.domain.persistence.Car;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarsRowMapper implements RowMapper<Car> {

  @Override
  public Car mapRow(ResultSet resultSet, int i) throws SQLException {
    Car car = new Car(resultSet.getString("car_model"),
            resultSet.getInt("manufacture_year"),
            resultSet.getString("license_plate"));

    if(resultSet.getString("assignee") != null) {
      car.setAssignee(resultSet.getString("assignee"));
    }

    return car;
  }
}
