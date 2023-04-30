package pl.pjatk.MVCProjetct.Car.Model;

public class Car {
    private String model, make, color;
    private int horsePower;

    public Car(String model, String make, String color, String horsePower) {
        this.model = model;
        this.make = make;
        this.color = color;
        this.horsePower = Integer.parseInt(horsePower);
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public String getColor() {
        return color;
    }

    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", color='" + color + '\'' +
                ", horsePower=" + horsePower +
                '}';
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
