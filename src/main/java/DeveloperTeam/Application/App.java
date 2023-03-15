package DeveloperTeam.Application;

import DeveloperTeam.Model.Builders.TicketBuilder;
import DeveloperTeam.Model.Entity.FlowerShop;
import DeveloperTeam.Model.Service.DevelopersService;

import java.security.Provider;

public class App {
    FlowerShop flowerShop;
    static int appQuantity = 0;

    DevelopersService service;
    TicketBuilder ticketBuilder;

    public App(){
        appQuantity++;
        String name = AskParameter.askString("Enter the name of the FlowerShop:");
        flowerShop = new FlowerShop(appQuantity,name);


        System.out.println("0.-TXT");
        System.out.println("1.-mySQL");
        System.out.println("2.-mongoDB");
        byte persistence = AskParameter.askByte("Select Persistence 0-2 (Default 0)");

        service = new DevelopersService(persistence);
        ticketBuilder = new TicketBuilder(persistence);
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
                case 1 -> service.createArticle();
                case 2 -> service.removeArticle();
                case 3 -> service.listAllArticles();
                case 4 -> service.listAllStock();
                case 5 -> {
                    ticketBuilder.build();
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






}
