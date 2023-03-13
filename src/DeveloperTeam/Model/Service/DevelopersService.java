package DeveloperTeam.Model.Service;

import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Entity.Decor;
import DeveloperTeam.Model.Entity.Flower;
import DeveloperTeam.Model.Entity.Tree;
import DeveloperTeam.Model.Repository.MongoRepository;
import DeveloperTeam.Model.Repository.Repository;
import DeveloperTeam.Model.Repository.SQLRepository;
import DeveloperTeam.Model.Repository.TxtRepository;

public class DevelopersService {
    Repository data;

    public DevelopersService(byte persistence){
        switch(persistence){
            default -> data = new TxtRepository();
            case 1 -> data = new SQLRepository();
            case 2 -> data = new MongoRepository();
        }
    }

    //returns 1 if created and 0 if not
    public void createArticle(String articleKind){
        IArticle IArticle;
        switch(articleKind.toLowerCase()){
            default -> throw new IllegalStateException("Unexpected value: " + articleKind);
            case "decor"-> IArticle = new Decor();
            case "flower" -> IArticle = new Flower();
            case "tree" -> IArticle = new Tree();
        }
        data.addStockItem(IArticle);
    }

}
