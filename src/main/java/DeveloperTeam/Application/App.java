package DeveloperTeam.Application;

import DeveloperTeam.Model.Entity.FlowerShop;
import DeveloperTeam.Model.Service.DevelopersService;

public class App {
    FlowerShop flowerShop;
    static int appQuantity = 0;

    DevelopersService service;

    public App(){
        appQuantity++;
        String name = AskParameter.askString("Enter the name of the FlowerShop:");
        flowerShop = new FlowerShop(appQuantity,name);


        System.out.println("0.-TXT");
        System.out.println("1.-mySQL");
        System.out.println("2.-mongoDB");
        byte persistence = AskParameter.askByte("Select Persistence 0-2 (Default 0)");

        service = new DevelopersService(persistence);
    }

    public void init(){
        loopMain();
    }

    public void loopMain(){
        boolean loop = true;

        while(loop){
            byte opt = getOptMain();
            System.out.println("\n");

            switch(opt){
                case 1 -> addItem();
                case 2 -> deleteItem();
                case 3 -> listAll();
                case 4 -> listStock();
                case 5 -> {
                    loop = false;
                    loopTicket();
                }
            }

        }
    }
    public byte getOptMain(){
        System.out.println(" #·#·# MAIN MENU #·#·# ");
        System.out.println("1.-Add Item");
        System.out.println("2.-Delete Item");
        System.out.println("3.-List All");
        System.out.println("4.-List Stock (with quantity)");
        System.out.println("5.-Create a Ticket (Ticket Menu)");

        return AskParameter.askByte("Insert Your Option: ");
    }

    public void addItem(){
        System.out.println("Add Item");
    }

    public void deleteItem(){
        System.out.println("Delete Item");
    }

    public void listAll(){
        System.out.println("List Items");
    }

    public void listStock(){
        System.out.println("List Stock");
    }

    public void loopTicket(){
        boolean loop = true;
        listAll();
        while(loop){
            byte opt = getOptTicket();

            switch(opt){
                case 1 -> addItemT();
                case 2 -> deleteItemT();
                case 3 -> listTicket();
                case 4 -> saveTicket();
                case 5 -> {
                    loop = false;
                    loopMain();
                }
            }
        }
    }

    public byte getOptTicket(){
        System.out.println(" #·#·# TICKET MENU #·#·# ");
        System.out.println("1.-Add Ticket Item");
        System.out.println("2.-Delete Ticket Item");
        System.out.println("3.-See Current Ticket");
        System.out.println("4.-Save Ticket");
        System.out.println("5.-Go Back");

        return AskParameter.askByte("Insert Your Option: ");
    }

    public void addItemT(){
        System.out.println("Add Item T");
    }

    public void deleteItemT(){
        System.out.println("Remove Item T");
    }

    public void listTicket(){
        System.out.println("List Item T");
    }

    public void saveTicket(){
        System.out.println("Save Item T");
    }




}
