package DeveloperTeam.Model.Service;

import DeveloperTeam.Model.Entity.Article;
import DeveloperTeam.Model.Entity.Decor;
import DeveloperTeam.Model.Entity.Flower;
import DeveloperTeam.Model.Entity.Tree;
import DeveloperTeam.Model.Repository.ItemRepository;

public class DevelopersService {

    ItemRepository data = new ItemRepository();

    //returns 1 if created and 0 if not
    public void createArticle(String articleKind){
        Article article;
        switch(articleKind.toLowerCase()){
            default -> throw new IllegalStateException("Unexpected value: " + articleKind);
            case "decor"-> article = new Decor();
            case "flower" -> article = new Flower();
            case "tree" -> article = new Tree();
        }
        data.addArticle(article);
    }

}
