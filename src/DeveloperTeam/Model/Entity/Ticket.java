package DeveloperTeam.Model.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Ticket {

    private static int ticketCount = 0;
    private int ticketID;
    private String nameClient;
    private String addressClient;
    private LocalDateTime ticketDate; //fer servir string o int?
    private float ticketTotal;


    private ArrayList<Article> articles = new ArrayList<Article>();


    public Ticket(String nameClient, String addressClient) {
        this.nameClient = nameClient;
        this.addressClient = addressClient;
        this.ticketCount +=1;
        this.ticketID=ticketCount;
        this.ticketDate = LocalDateTime.now();

    }


    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getAddressClient() {
        return addressClient;
    }

    public void setAddressClient(String addressClient) {
        this.addressClient = addressClient;
    }

    public LocalDateTime getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(LocalDateTime ticketDate) {
        this.ticketDate = ticketDate;
    }

    public float getTicketTotal() {
        for (Article article:articles) {
            ticketTotal += article.getPrice();
        }
        return ticketTotal;
    }

    public void setTicketTotal(float ticketTotal) {
        this.ticketTotal = ticketTotal;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID=" + ticketID +
                ", nameClient='" + nameClient + '\'' +
                ", addressClient='" + addressClient + '\'' +
                ", ticketDate=" + ticketDate +
                ", ticketTotal=" + ticketTotal +
                ", articles=" + articles +
                '}';
    }
}//closes class
