package DeveloperTeam.Model.Repository;

import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Entity.Ticket;

import java.util.List;

public interface Repository {
    void addStockItem(IArticle art);
    List<IArticle> getAll();
    void removeStockItem(int idArticle);
    List<Ticket> getAllTickets();

}
