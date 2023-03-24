package DeveloperTeam.Model.Entity;

import DeveloperTeam.Application.AskParameter;

import java.util.Objects;

public class Flower implements IArticle {

    private int id;
    private String name;
    private String colour; //podria ser int
    private float price;

    public Flower(int id, String name, String colour, float price) {
        this.id = id;
        this.name = name;
        this.colour = colour;
        this.price = price;
    }

    public Flower(int id){
        this.id = id;
        this.name = AskParameter.askString("Introduce the name");
        this.colour = AskParameter.askString("Introduce the Colour");
        this.price = AskParameter.askFloat("Introduce the Price");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCaracteristic() {
        return colour;
    }

    @Override
    public void setCaracteristic(String caracteristic) {
        this.colour = caracteristic;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Flower{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return id == flower.id && Float.compare(flower.price, price) == 0 && name.equals(flower.name) && colour.equals(flower.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, colour, price);
    }
}
