package DeveloperTeam;


import DeveloperTeam.Model.Entity.Decor;
import DeveloperTeam.Model.Entity.Flower;
import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Entity.Tree;

import DeveloperTeam.Model.Repository.TxtRepository;
import DeveloperTeam.Model.Service.DevelopersService;

import java.util.ArrayList;
import java.util.List;

//TODO: Implementar repo txt
public class MainTestingPau {
    public static void main(String[] args) {

        DevelopersService myService = new DevelopersService((byte)0);

        myService.createArticle();

    }
}
