package DeveloperTeam.Model.Repository;

import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Entity.Ticket;

import java.io.IOException;
import java.util.List;

public interface Repository {
    //Stock
    void addStockItem(IArticle art);
    List<IArticle> getAll() throws IOException;
    void removeStockItem(int idArticle) throws IOException;
    boolean exists(int idArticle) throws IOException;
    IArticle getOne(int idArticle) throws IOException;
    int countStock() throws IOException;

    //Ticket
    List<Ticket> getAllTickets() throws IOException;
    void insertTicket(Ticket ticket);


}
