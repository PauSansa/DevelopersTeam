package DeveloperTeam.Model.Repository;


import DeveloperTeam.Application.WindowManager;
import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Entity.Ticket;

import java.util.List;

//TODO implmementar metodos
public class TxtRepository implements Repository{
    private String path;

    public TxtRepository(){
        this.path = WindowManager.getPath();
    }


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
