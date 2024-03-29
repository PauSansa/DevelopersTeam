package DeveloperTeam.Application;

import DeveloperTeam.Exceptions.StoppedByUser;
import DeveloperTeam.Model.Builders.TicketBuilder;
import DeveloperTeam.Model.Entity.FlowerShop;
import DeveloperTeam.Model.Repository.MongoRepository;
import DeveloperTeam.Model.Repository.Repository;
import DeveloperTeam.Model.Repository.SQLRepository;
import DeveloperTeam.Model.Repository.TxtRepository;
import DeveloperTeam.Model.Service.DevelopersService;

import java.security.Provider;
import java.sql.SQLException;

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
        byte opt = AskParameter.askByte("Select Persistence 0-2 (Default 0)");
        Repository repo = null;
        try{
            switch(opt){
                default -> repo = new TxtRepository();
                case 1 -> repo = new SQLRepository();
                case 2 -> repo = new MongoRepository();
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }


        service = new DevelopersService(repo);
        ticketBuilder = new TicketBuilder(service);
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
                case 5 -> service.listAllTickets();
                case 6 -> service.listTotalGains();
                case 7 -> ticketBuilder.build();
            }

        }
    }
    public byte getOptMain(){

        System.out.println("\n #·#·# MAIN MENU #·#·# ");
        System.out.println("1.-Add Item");
        System.out.println("2.-Delete Item");
        System.out.println("3.-List All");
        System.out.println("4.-List Stock (with quantity)");
        System.out.println("5.-See all Tickets");
        System.out.println("6.-See total gains");
        System.out.println("7.-Create a Ticket (Ticket Menu)");
        return AskParameter.askByte("Type in your choice: ");
    }






}
