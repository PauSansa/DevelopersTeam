package DeveloperTeam.Model.Repository;


import DeveloperTeam.Application.WindowManager;
import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Entity.Ticket;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TODO implmementar metodos
public class TxtRepository implements Repository{
    private String path;
    private File ticketFile;
    private File stockFile;
    private FileWriter stockWriter;
    private FileWriter ticketWriter;
    private FileReader stockReader;
    private FileReader ticketReader;

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

            stockReader = new FileReader(stockFile);
            ticketReader = new FileReader(ticketFile);
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
    public List<IArticle> getAll() {
        return null;
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
