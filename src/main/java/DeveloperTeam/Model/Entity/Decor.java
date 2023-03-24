package DeveloperTeam.Model.Entity;

import DeveloperTeam.Application.AskParameter;

import java.util.Objects;

public class Decor implements IArticle {

    private int id;
    private String name;
    private String material;
    private float price;

    public Decor(int id, String name, String material, float price) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.price = price;
    }

    public Decor(int id){
        this.id = id;
        this.name = AskParameter.askString("Introduce the name");
        this.material = AskParameter.askMaterial("Introduce the material");
        this.price = AskParameter.askFloat("Introduce the price");
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
        return material;
    }

    @Override
    public void setCaracteristic(String caracteristic) {
        this.material=caracteristic;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Decor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", material='" + material + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Decor decor = (Decor) o;
        return id == decor.id && Float.compare(decor.price, price) == 0 && name.equals(decor.name) && material.equals(decor.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, material, price);
    }
}
