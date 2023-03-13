package DeveloperTeam.Model.Entity;

import java.util.ArrayList;

public class FlowerShop {

    private int id;
    private String name;
    private float stockTotal;
    private float ticketsTotal;


    private ArrayList<IArticle> stock = new ArrayList<>();
    private ArrayList<Ticket> tickets = new ArrayList<>();



    public FlowerShop(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ArrayList<IArticle> getStock() {
        return stock;
    }

    public void setStock(ArrayList<IArticle> stock) {
        this.stock = stock;
    }

    public float getStockTotal() {

        for (IArticle IArticle :stock) {
            stockTotal += IArticle.getPrice();
        }

        return stockTotal;
    }

    public void setStockTotal(float stockTotal) {
        this.stockTotal = stockTotal;
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


    public ArrayList<Ticket> getTickets() {

        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }


    public float getTicketsTotal() {
        for (Ticket ticket:tickets) {
            ticketsTotal += ticket.getTicketTotal();
        }
        return ticketsTotal;
    }

    public void setTicketsTotal(float ticketsTotal) {
        this.ticketsTotal = ticketsTotal;
    }


    @Override
    public String toString() {
        return "FlowerShop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stockTotal=" + stockTotal +
                '}';
    }


}
