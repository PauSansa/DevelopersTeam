package DeveloperTeam.Model.Service;

import DeveloperTeam.Application.AskParameter;
import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Builders.ArticleFactory;
import DeveloperTeam.Model.Entity.Ticket;
import DeveloperTeam.Model.Repository.MongoRepository;
import DeveloperTeam.Model.Repository.Repository;
import DeveloperTeam.Model.Repository.SQLRepository;
import DeveloperTeam.Model.Repository.TxtRepository;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//TODO implementar metodes veure tots tickets y sumar factures
public class DevelopersService {
    ArticleFactory factory;
    Repository data;

    public DevelopersService(Repository repo){
        data = repo;
        factory = new ArticleFactory(repo);

    }

    public void createArticle(){

        byte kind = AskParameter.askByteRange("What do you wanna add?\n1-tree\n2-flower\n3-decor", 1, 3);
        IArticle article = factory.getArticle(kind);

        try{
            data.addStockItem(article);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void removeArticle(){
        listAllArticles();
        int askIdArticle= AskParameter.askInteger("Choose a option: ");
        try {
            if (data.exists(askIdArticle)){
                data.removeStockItem(askIdArticle);}
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
                System.out.println("The available articles are: ");
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

                System.out.println("Available articles in Stock:");

                classCount.forEach((key, value) -> System.out.println(key.getCanonicalName() + ": " + value));
            }
        }  catch (Exception e) {
                    throw new RuntimeException(e);
        }
    }

    public IArticle getOne(){
        IArticle article = null;
        int askIdArticle= AskParameter.askInteger("Introduce the Id of the article: ");
        try {
            article = data.getOne(askIdArticle);
        } catch (Exception e) {
            System.out.println("Error retrieving the article. Please try again");
        }
        return article;
    }

    public IArticle getOne(int id){
        IArticle article = null;
        try {
            article = data.getOne(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return article;
    }

    public void insertTicket(Ticket ticket){
        try{
            data.insertTicket(ticket);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //TODO Implment Method listAllTickets and ListTotalGains
    public void listAllTickets(){

        try {
            System.out.println("List of all saved tickets:");
            List<String> lines = data.getAllTickets();
            for (String line:lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void listTotalGains(){

        try {
            System.out.println("Total amount from all tickets: "+data.listTotalGains() +" €");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}