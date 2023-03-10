package DeveloperTeam.Model.Entity;

import DeveloperTeam.Application.AskParameter;

public class Tree implements Article {

    private int id;
    private String name;
    private float height;
    private float price;


    public Tree(int id, String name, float height, float price) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.price = price;
    }

    public Tree(){
        this.id = AskParameter.readInt("Introduce the id");
        this.name = AskParameter.readString("Introduce the name");
        this.height = AskParameter.readFloat("Introduce the Height");
        this.price = AskParameter.readFloat("Introduce the Price");
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

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
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
