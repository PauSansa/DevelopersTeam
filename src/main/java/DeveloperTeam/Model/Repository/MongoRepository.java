package DeveloperTeam.Model.Repository;

import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Entity.Ticket;

import java.io.IOException;
import java.util.List;

public class MongoRepository implements Repository{
    @Override
    public void addStockItem(IArticle IArticle) {

    }

    @Override
    public List<IArticle> getAll() {
        return null;
    }

    @Override
    public void removeStockItem(int idArticle) {

    }

    @Override
    public List<Ticket> getAllTickets() {
        return null;
    }

    @Override
    public void insertTicket(Ticket ticket){

    }

    @Override
    public int countStock() throws IOException {
        return 0;
    }

    @Override
    public boolean exists(int idArticle) {
        return false;
    }

    @Override
    public IArticle getOne(int idArticle){
        return null;
    }


}
