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

        service.listAllArticles();
        int id = AskParameter.askInteger("Enter the id of the Article to add");
        
        IArticle article = service.getOne(id);

        this.cTicket.getArticles().add(article);
        this.cTicket.getArticles().add(article);


       // this code is to ask to the partner
       if (this.cTicket.getArticles().size()!= 0 ){
           int i = 0;
           boolean verify= false;
           while (i < this.cTicket.getArticles().size()  && !verify) {
               if (this.cTicket.getArticles().get(i).getId()==id){
                   verify=true;
               }
               i++;
           }
           if(!verify){
               this.cTicket.getArticles().add(article);
           }

       }  //

    }

    public void deleteItemT(){
        service.listAllArticles();
        int id = AskParameter.askInteger("Enter the id of the Article to add");
        IArticle article = service.getOne(id);
        this.cTicket.getArticles().remove(article);

        // this code is to ask to the partner
        if (this.cTicket.getArticles().size()!= 0 ){
            int i = 0;
            boolean verify= false;
            while (i < this.cTicket.getArticles().size()  && !verify) {
                if (this.cTicket.getArticles().get(i).getId()==id){
                    verify=true;
                }
                i++;
            }
            if(!verify){
                this.cTicket.getArticles().remove(article);
            }

        }  //


    }

    public void listCurrentTicket(){
        
        this.cTicket.getArticles().forEach(System.out::println);
    }

    public void saveTicket(){
        service.insertTicket(cTicket);
        cTicket=null;
    }
}
