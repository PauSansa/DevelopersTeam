package DeveloperTeam.Model.Repository;


import DeveloperTeam.Application.WindowManager;
import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Entity.Ticket;

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
        String line= "";
        while(line=stockReader.readLine()!=null){

        }
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
