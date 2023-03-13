package DeveloperTeam.Model.Repository;

import DeveloperTeam.Model.Entity.Article;
import DeveloperTeam.Model.Entity.Ticket;

import java.util.List;

public class MongoRepository implements Repository{
    @Override
    public void addStockItem(Article article) {

    }

    @Override
    public List<Article> getAll(Article article) {
        return null;
    }

    @Override
    public void removeStockItem(int idArticle) {

    }

    @Override
    public List<Ticket> getAllTickets() {
        return null;
    }
}
