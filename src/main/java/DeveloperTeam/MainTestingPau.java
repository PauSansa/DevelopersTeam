package DeveloperTeam;


import DeveloperTeam.Model.Entity.Decor;
import DeveloperTeam.Model.Entity.Flower;
import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Entity.Tree;

import DeveloperTeam.Model.Repository.Repository;
import DeveloperTeam.Model.Repository.SQLRepository;
import DeveloperTeam.Model.Repository.TxtRepository;
import DeveloperTeam.Model.Service.DevelopersService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MainTestingPau {
    public static void main(String[] args) {

        try {
            Repository repo = new SQLRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
