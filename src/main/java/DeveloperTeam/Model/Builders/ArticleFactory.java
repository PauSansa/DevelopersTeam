package DeveloperTeam.Model.Builders;

import DeveloperTeam.Model.Entity.Decor;
import DeveloperTeam.Model.Entity.Flower;
import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Entity.Tree;
import DeveloperTeam.Model.Repository.Repository;

public class ArticleFactory {
    private Repository data;
    private static int nArticles;

    public ArticleFactory(Repository repository) {
        this.data = repository;
        try{
            nArticles = data.countStock();
        } catch (Exception e){
            e.printStackTrace();
        }


    }



    public IArticle getArticle(Byte type) {

        switch (type){
            case 1 -> {return new Tree(nArticles++);}
            case 2 -> {return new Flower(nArticles++);}
            case 3 -> {return new Decor(nArticles++);}
        }

        return null;
    }




}
