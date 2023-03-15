package DeveloperTeam.Model.Builders;

import DeveloperTeam.Application.AskParameter;
import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Entity.Ticket;
import DeveloperTeam.Model.Service.DevelopersService;

public class TicketBuilder {
    DevelopersService service;
    Ticket cTicket;

    public TicketBuilder(byte persistence) {
        this.service = new DevelopersService(persistence);
    }

    public void build(){
        String name = AskParameter.askString("Enter your Name");
        String address = AskParameter.askString("Enter Your Address");
        cTicket = new Ticket(name,address);
        boolean loop = true;
        while(loop){
            byte opt = getOptTicket();

            switch(opt){
                case 1 -> addItemT();
                case 2 -> deleteItemT();
                case 3 -> listCurrentTicket();
                case 4 -> saveTicket();
                case 5 -> {
                    return;
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
        service.listAllArticles();
        int id = AskParameter.askInteger("Enter the id of the Article to add");
    }

    public void deleteItemT(){
        System.out.println("Remove Item T");
    }

    public void listCurrentTicket(){
        System.out.println("List Item T");
    }

    public void saveTicket(){
        System.out.println("Save Item T");
    }
}