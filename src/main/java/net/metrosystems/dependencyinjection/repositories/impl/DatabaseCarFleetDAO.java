package net.metrosystems.dependencyinjection.repositories.impl;

import net.metrosystems.dependencyinjection.domain.persistence.Car;
import net.metrosystems.dependencyinjection.domain.mapper.CarsRowMapper;
import net.metrosystems.dependencyinjection.repositories.CarFleetDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DatabaseCarFleetDAO implements CarFleetDAO {

  private final NamedParameterJdbcTemplate jdbcTemplate;

  @Autowired
  public DatabaseCarFleetDAO(NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Car> getCarList() {
    return jdbcTemplate.query("select * from cars", new CarsRowMapper());
  }

  @Override
  public void addCar(Car car) {
    final String sql = "insert into cars(car_model, manufacture_year, license_plate, assignee) " +
            "values(:carModel,:manufactureYear,:licensePlate,:assignee)";

    KeyHolder holder = new GeneratedKeyHolder();
    SqlParameterSource param = new MapSqlParameterSource()
            .addValue("carModel", car.getCarModel())
            .addValue("manufactureYear", car.getManufactureYear())
            .addValue("licensePlate", car.getLicensePlate())
            .addValue("assignee", car.getAssignee());
    jdbcTemplate.update(sql,param, holder);
  }

  @Override
  public void removeCar(String licensePlate) {
    final String sql = "delete from cars where license_plate=:licensePlate";


    Map<String, Object> map = new HashMap<>();
    map.put("licensePlate", licensePlate);

    jdbcTemplate.execute(sql, map, PreparedStatement::executeUpdate);
  }

  @Override
  public void removeAllCars() {
    jdbcTemplate.execute("delete from cars", PreparedStatement::execute);
  }
}
