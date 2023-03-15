package DeveloperTeam.Model.Interfaces;

import DeveloperTeam.Model.Entity.Decor;
import DeveloperTeam.Model.Entity.Flower;
import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Entity.Tree;

public class ArticleFactory {

    private static int nArticles = 0;

    public IArticle getArticle(Byte type) {

        switch (type){
            case 1 -> {return new Tree(nArticles++);}
            case 2 -> {return new Flower(nArticles++);}
            case 3 -> {return new Decor(nArticles++);}
        }

        return null;
    }




}
