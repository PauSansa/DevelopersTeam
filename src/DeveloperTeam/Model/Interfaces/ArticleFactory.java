package DeveloperTeam.Model.Interfaces;

import DeveloperTeam.Model.Entity.Decor;
import DeveloperTeam.Model.Entity.Flower;
import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Entity.Tree;

public class ArticleFactory {

    private static int nArticles = 0;

    public IArticle getArticle(String country) {
        if(country=="tree"){
            return new Tree(nArticles++);
        } else if (country=="flower") {
            return new Flower(nArticles++);
        }else if (country=="decor") {
            return new Decor(nArticles++);
        }
        return null;
    }




}
