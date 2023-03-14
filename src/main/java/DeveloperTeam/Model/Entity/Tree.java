package DeveloperTeam.Model.Entity;

import DeveloperTeam.Application.AskParameter;

public class Tree implements IArticle {

    private int id;
    private String name;
    private String height;
    private float price;


    public Tree(int id, String name, String height, float price) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.price = price;
    }

    public Tree(int id){
        this.id = id;
        this.name = AskParameter.askString("Introduce the name");
        this.height = AskParameter.askString("Introduce the height");
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
        return height;
    }

    @Override
    public void setCaracteristic(String caracteristic) {
        this.height = caracteristic;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Tree{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", price=" + price +
                '}';
    }
}
