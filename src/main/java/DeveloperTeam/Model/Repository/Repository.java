package DeveloperTeam.Model.Repository;

import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Entity.Ticket;

import java.util.List;

public interface Repository {
    void addStockItem(IArticle art) throws Exception;
    List<IArticle> getAll() throws Exception;
    void removeStockItem(int idArticle) throws Exception;
    boolean exists(int idArticle) throws Exception;
    IArticle getOne(int idArticle) throws Exception;
    List<Ticket> getAllTickets() throws Exception;
    void insertTicket(Ticket ticket) throws Exception;

}
