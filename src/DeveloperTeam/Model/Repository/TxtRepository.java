package DeveloperTeam.Model.Repository;

import DeveloperTeam.Application.WindowManager;
import DeveloperTeam.Model.Entity.Article;
import DeveloperTeam.Model.Entity.Ticket;

import java.util.List;

//TODO implmementar metodos
public class TxtRepository implements Repository{
    private String path;

    public TxtRepository(){
        this.path = WindowManager.getPath();
    }


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
