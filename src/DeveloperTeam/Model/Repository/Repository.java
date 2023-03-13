package DeveloperTeam.Model.Repository;

import DeveloperTeam.Model.Entity.Article;
import DeveloperTeam.Model.Entity.Ticket;

import java.util.List;

public interface Repository {
    void addStockItem(Article article);
    List<Article> getAll(Article article);
    void removeStockItem(Article article);
    List<Ticket> getAllTickets();

}
