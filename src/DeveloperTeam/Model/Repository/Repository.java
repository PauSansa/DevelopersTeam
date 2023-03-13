package DeveloperTeam.Model.Repository;

import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Entity.Ticket;

import java.util.List;

public interface Repository {
    void addStockItem(IArticle IArticle);
    List<IArticle> getAll(IArticle IArticle);
    void removeStockItem(int idArticle);
    List<Ticket> getAllTickets();

}
