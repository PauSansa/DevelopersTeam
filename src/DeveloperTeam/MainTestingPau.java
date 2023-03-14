package DeveloperTeam;


import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Entity.Tree;

import DeveloperTeam.Model.Repository.TxtRepository;

//TODO: Implementar repo txt
public class MainTestingPau {
    public static void main(String[] args) {
        TxtRepository repo = new TxtRepository();

        IArticle article1 = new Tree(1,"Pino","26",25.10f);
        IArticle article2 = new Tree(1,"Pino","26",25.10f);


        repo.addStockItem(article1);


    }
}
