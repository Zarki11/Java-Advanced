package DefiningClasses.CarSalesman;

public class Car {

    private String carModel;

    private Engine engine;

    private int weight;

    private String colour;

    public Car(String carModel, Engine engine, int weight, String colour) {
        this.carModel = carModel;
        this.engine = engine;
        this.weight = weight;
        this.colour = colour;
    }
}
