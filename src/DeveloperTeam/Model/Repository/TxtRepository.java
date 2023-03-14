package DeveloperTeam.Model.Repository;


import DeveloperTeam.Application.WindowManager;
import DeveloperTeam.Model.Entity.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//TODO implmementar metodos
public class TxtRepository implements Repository{
    private String path;
    private File ticketFile;
    private File stockFile;
    private FileWriter stockWriter;
    private FileWriter ticketWriter;
    private BufferedReader stockReader;
    private BufferedReader ticketReader;

    public TxtRepository(){
        this.path = WindowManager.getPath();
        if(path.isBlank()){
            path = ".";
        }
        ticketFile = new File(path+"/tickets.txt");
        stockFile = new File(path + "/stock.txt");
        try{
            stockWriter = new FileWriter(stockFile,true);
            ticketWriter = new FileWriter(ticketFile,true);

            stockReader = new BufferedReader(new FileReader(stockFile));
            ticketReader = new BufferedReader(new FileReader(ticketFile));
        } catch(Exception e){
            e.printStackTrace();
        }


    }


    @Override
    public void addStockItem(IArticle art){
        try {
            stockWriter.write("{");
            stockWriter.write(art.getClass().getSimpleName()+",");
            stockWriter.write(art.getId()+",");
            stockWriter.write(art.getName()+",");
            stockWriter.write(art.getCaracteristic()+",");
            stockWriter.write(art.getPrice()+"");
            stockWriter.write("}\n");
            stockWriter.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<IArticle> getAll() throws Exception {
        List<IArticle> articles = new ArrayList<>();

        String line= "";
        while((line=stockReader.readLine())!=null){
            String[] tokens = line.replace("{","").replace("}","").split(",");
            int id = Integer.parseInt(tokens[1]);
            String name = tokens[2];
            String caract = tokens[3];
            Float price = Float.parseFloat(tokens[4]);
            switch (tokens[0]){
                case "Tree" -> articles.add(new Tree(id,name,caract,price));
                case "Decor" -> articles.add(new Decor(id,name,caract,price));
                case "Flower" -> articles.add(new Flower(id,name,caract,price));
            }
        }

        return articles;
    }

    @Override
    public void removeStockItem(int idArticle) {

    }

    @Override
    public List<Ticket> getAllTickets() {
        return null;
    }

    @Override
    public boolean exists(IArticle art) {
        return false;
    }
}
