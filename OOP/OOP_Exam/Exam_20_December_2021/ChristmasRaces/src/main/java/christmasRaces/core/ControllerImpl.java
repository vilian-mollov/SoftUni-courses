package christmasRaces.core;

import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.List;

import static christmasRaces.common.ExceptionMessages.*;
import static christmasRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        Driver driver1 = new DriverImpl(driver);
        driverRepository.add(driver1);
        return String.format("Driver %s is created.", driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car;
        if (type.equals("Muscle")) {
            car = new MuscleCar(model, horsePower);
        } else if (type.equals("Sports")) {
            car = new SportsCar(model, horsePower);
        } else {
            car = null;
        }

        if (!carRepository.getAll().isEmpty() && car == (carRepository.getByName(model))) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }

        carRepository.add(car);
        return String.format(CAR_CREATED, car.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Car car = carRepository.getByName(carModel);
        Driver driver = driverRepository.getByName(driverName);
        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        if (car == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }

        driver.addCar(car);
        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = raceRepository.getByName(raceName);
        Driver driver = driverRepository.getByName(driverName);

        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        race.addDriver(driver);
        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = new RaceImpl(name, laps);
        if (null != raceRepository.getByName(name)) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }
        raceRepository.add(race);
        return String.format(RACE_CREATED, name);
    }

    @Override
    public String startRace(String raceName) {
        Race race = raceRepository.getByName(raceName);

        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        boolean hasAtLeastThreeParticipants = false;
        int participants = 0;

        List<Driver> players = new ArrayList<>();
        for (Driver driver : driverRepository.getAll()) {
            if (driver.getCanParticipate()) {
                players.add(driver);
                participants++;
            }
        }
        if (participants >= 3) {
            hasAtLeastThreeParticipants = true;
        }

        if (!hasAtLeastThreeParticipants) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }

        int laps = race.getLaps();
        for (int i = 0; i < players.size() - 1; i++) {
            for (int j = i; j < players.size() - 1; j++) {
                if (players.get(j).getCar().calculateRacePoints(laps) < players.get(j + 1).getCar().calculateRacePoints(laps)) {
                    Driver temp = players.get(j);
                    players.set(j, players.get(j + 1));
                    players.set(j + 1, temp);
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Driver %s wins %s race.", players.get(0).getName(), raceName));
        sb.append(System.lineSeparator());
        sb.append(String.format("Driver %s is second in %s race.", players.get(1).getName(), raceName));
        sb.append(System.lineSeparator());
        sb.append(String.format("Driver %s is third in %s race.", players.get(2).getName(), raceName));

        players.get(0).winRace();
        return sb.toString().trim();
    }
}
