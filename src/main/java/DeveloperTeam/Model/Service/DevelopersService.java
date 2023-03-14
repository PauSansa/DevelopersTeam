package DeveloperTeam.Model.Service;

import DeveloperTeam.Application.AskParameter;
import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Entity.Decor;
import DeveloperTeam.Model.Entity.Flower;
import DeveloperTeam.Model.Entity.Tree;
import DeveloperTeam.Model.Interfaces.ArticleFactory;
import DeveloperTeam.Model.Repository.MongoRepository;
import DeveloperTeam.Model.Repository.Repository;
import DeveloperTeam.Model.Repository.SQLRepository;
import DeveloperTeam.Model.Repository.TxtRepository;

public class DevelopersService {
    ArticleFactory factory = new ArticleFactory();
    Repository data;

    public DevelopersService(byte persistence){
        switch(persistence){
            default -> data = new TxtRepository();
            case 1 -> data = new SQLRepository();
            case 2 -> data = new MongoRepository();
        }
    }

    //returns 1 if created and 0 if not
    public void createArticle(){
        byte kind = AskParameter.askByte("What do you wanna add?\n1-tree\n2-flower\n3-decor");
        IArticle article = factory.getArticle(kind);
        try{
            data.addStockItem(article);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}