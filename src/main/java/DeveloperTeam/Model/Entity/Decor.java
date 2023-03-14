package DeveloperTeam.Model.Entity;

import DeveloperTeam.Application.AskParameter;

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
        this.material = AskParameter.askString("Introduce the material");
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
}
