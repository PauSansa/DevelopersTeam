package DeveloperTeam.Model.Entity;

import DeveloperTeam.Application.AskParameter;

public class Decor implements IArticle {

    private int id;
    private String name;
    private boolean material;
    private float price;

    public Decor(int id, String name, boolean material, float price) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.price = price;
    }

    public Decor(int id){
        this.id = id;
        this.name = AskParameter.askString("Introduce the name");
        this.material = AskParameter.askBoolean("Introduce the Material: " +"\n" +"(True) for wood and (false) for plastic");
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

    public boolean getMaterial() {
        return material;
    }

    public void setMaterial(boolean material) {
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
