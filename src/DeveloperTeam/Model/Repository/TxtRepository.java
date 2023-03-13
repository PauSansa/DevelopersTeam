package DeveloperTeam.Model.Repository;

import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Entity.Ticket;

import java.util.List;

//TODO implmementar metodos
public class TxtRepository implements Repository{

    @Override
    public void addStockItem(IArticle IArticle) {

    }

    @Override
    public List<IArticle> getAll(IArticle IArticle) {
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
