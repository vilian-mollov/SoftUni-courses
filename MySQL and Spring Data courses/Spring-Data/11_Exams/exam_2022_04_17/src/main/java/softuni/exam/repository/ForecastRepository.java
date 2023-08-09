package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.models.entity.enums.DayOfWeek;

import java.util.List;
import java.util.Optional;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast, java.lang.Long> {

    Optional<Forecast> findByDayOfWeekAndCity(String dayOfWeek, City aCity);

    Optional<Forecast> findFirstByDayOfWeekAndCity(DayOfWeek dayOfWeek, City city);

    List<Forecast> findAllByDayOfWeekOrderByMaxTemperatureDesc(DayOfWeek dayOfWeek);
}
