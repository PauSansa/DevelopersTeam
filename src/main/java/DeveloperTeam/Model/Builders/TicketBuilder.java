package DeveloperTeam.Model.Builders;

import DeveloperTeam.Application.AskParameter;
import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Entity.Ticket;
import DeveloperTeam.Model.Service.DevelopersService;

public class TicketBuilder {
    DevelopersService service;
    Ticket cTicket;

    public TicketBuilder(DevelopersService service) {
        this.service = service;
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
                case 4 -> {
                    saveTicket();
                    return;
                }
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

        //TODO Colocar aqui un if que compruebe si el item existe con data.exists() y depende de si existe o no, borrarlo o printear "El item ya existe"


        service.listAllArticles();
        int id = AskParameter.askInteger("Enter the id of the Article to add");
        
        IArticle article = service.getOne(id);

        if (article != null) {
            this.cTicket.getArticles().add(article);
            System.out.println("Article successfully added! ");

        }
        else {
            System.out.println("Article does not exist");
        }

    }

    public void deleteItemT(){
        //TODO Colocar aqui un if que compruebe si el item existe con data.exists() y depende de si existe o no, borrarlo o printear "El item no existe"
        service.listAllArticles();
        int id = AskParameter.askInteger("Enter the id of the Article to delete");
        IArticle article = service.getOne(id);

        if (article == null){
            System.out.println("Article does not exist");
            } else {
            this.cTicket.getArticles().remove(article);
            System.out.println("Article removed successfully!");
                }
    }

    public void listCurrentTicket(){
        
        this.cTicket.getArticles().forEach(System.out::println);
    }

    public void saveTicket(){
        service.insertTicket(cTicket);
        cTicket=null;
    }
}
