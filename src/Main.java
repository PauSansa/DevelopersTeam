import DeveloperTeam.Model.Entity.*;

public class Main {
    public static void main(String[] args) {

        //FLOWER SHOP
        FlowerShop myFS = new FlowerShop(1,"myflower");

        //ARTICLES
        Flower flower = new Flower(1,"girasol","groc",20f);

        Tree tree = new Tree(1,"pi",150,50f);

        Decor decor = new Decor(1,"font","fusta",200f);

        //INSERTING ARTICLES IN STOCK
        myFS.getStock().add(flower);
        myFS.getStock().add(tree);
        myFS.getStock().add(decor);

        //PRINTING STOCK
        System.out.println("*** CURRENT TOTAL STOCK ***");
        System.out.println(myFS.getStockTotal());

        //CREATING ONE TICKET AND INSERTING ITEMS
        Ticket fac1 = new Ticket("pepe","gran via");
        fac1.getArticles().add(flower);
        fac1.getArticles().add(tree);

        //PRINTING TICKET FAC1
        System.out.println("*** CURRENT TOTAL TICKETS ***");
        System.out.println(fac1.getTicketTotal());
        System.out.println(fac1.getTicketDate());


    }//closes main


}//closes class