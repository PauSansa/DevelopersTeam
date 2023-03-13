package DeveloperTeam;

import DeveloperTeam.Application.App;
import DeveloperTeam.Application.WindowManager;
import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Entity.Tree;
import DeveloperTeam.Model.Interfaces.ArticleFactory;
import DeveloperTeam.Model.Repository.Repository;
import DeveloperTeam.Model.Repository.TxtRepository;

public class MainTestingPau {
    public static void main(String[] args) {
        ArticleFactory factory = new ArticleFactory();

        IArticle article1 = factory.getArticle("tree");
        IArticle article2 = factory.getArticle("decor");
        IArticle article3 = factory.getArticle("flower");

        System.out.println("Breakpoint");
    }
}
