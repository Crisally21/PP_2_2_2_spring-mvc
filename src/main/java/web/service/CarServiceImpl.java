package web.service;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl {
    private static int CAR_COUNT;
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car(++CAR_COUNT, "Lada", 2017));
        cars.add(new Car(++CAR_COUNT, "BMW", 2003));
        cars.add(new Car(++CAR_COUNT, "Mercedes", 2023));
        cars.add(new Car(++CAR_COUNT, "Lexus", 2020));
        cars.add(new Car(++CAR_COUNT, "Audi", 2015));
    }

    public List<Car> getCars(int count) {
        return cars.subList(0, Math.min(count, cars.size()));
    }

    public List<Car> index() {
        return cars;
    }


}
