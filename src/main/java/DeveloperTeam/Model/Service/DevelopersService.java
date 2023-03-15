package DeveloperTeam.Model.Service;

import DeveloperTeam.Application.AskParameter;
import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Builders.ArticleFactory;
import DeveloperTeam.Model.Repository.MongoRepository;
import DeveloperTeam.Model.Repository.Repository;
import DeveloperTeam.Model.Repository.SQLRepository;
import DeveloperTeam.Model.Repository.TxtRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DevelopersService {
    ArticleFactory factory = new ArticleFactory();
    Repository data;

    public DevelopersService(byte persistence){
        try{
            switch(persistence){
                default -> data = new TxtRepository();
                case 1 -> data = new SQLRepository();
                case 2 -> data = new MongoRepository();
            }
        } catch (Exception e){
            e.printStackTrace();
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

    public void removeArticle(){
        listAllArticles();
        int askInteger= AskParameter.askInteger("Choose a option: ");
        try {
            data.removeStockItem(askInteger);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void listAllArticles(){

        List<IArticle> articles= null;

        try {
            articles = data.getAll();
            if (articles.size()==0){
                System.out.println("No Articles available");
            } else {
                System.out.println("The articles available are: ");
                articles.forEach(System.out::println);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void listAllStock(){

        List<IArticle> articles = null;

        try{
            articles = data.getAll();
            if (articles.size()==0){
                System.out.println("No Articles available");
            }
            else {
                Map<? extends Class<?>, Long> classCount = articles.stream()
                        .collect(Collectors.groupingBy(Object::getClass, Collectors.counting()));

                System.out.println("Articles Available in Stock are: ");

                classCount.forEach((key, value) -> System.out.println(key.getCanonicalName() + ": " + value));
            }
        }  catch (Exception e) {
                    throw new RuntimeException(e);
        }
    }

    public void getOne(){
        int askIdArticle= AskParameter.askInteger("Write a Id Article: ");
        try {
            data.getOne(askIdArticle);
        } catch (Exception e) {
            System.out.println("There is not article. ");
        }

    }
    public void createTicket(){
        //Pending of implementation ;
    }
}