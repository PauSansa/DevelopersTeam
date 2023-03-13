package DeveloperTeam.Model.Interfaces;

import DeveloperTeam.Model.Entity.Decor;
import DeveloperTeam.Model.Entity.Flower;
import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Entity.Tree;

public class ArticleFactory {

    public IArticle getArticle(String country) {
        if(country=="tree"){
            return new Tree();
        } else if (country=="flower") {
            return new Flower();
        }else if (country=="decor") {
            return new Decor();
        }
        return null;
    }




}
