package DeveloperTeam.Model.Repository;


import DeveloperTeam.Application.WindowManager;
import DeveloperTeam.Model.Entity.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtRepository implements Repository{
    private String path;
    private File ticketFile;
    private File stockFile;
    private FileWriter stockWriter;
    private PrintWriter ticketWriter;
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
            ticketWriter = new PrintWriter(new FileWriter(ticketFile,true));

            stockReader = new BufferedReader(new FileReader(stockFile));
            ticketReader = new BufferedReader(new FileReader(ticketFile));

            stockReader.mark(1000);
            ticketReader.mark(1000);
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
    public List<IArticle> getAll() throws IOException{
        List<IArticle> articles = new ArrayList<>();

        try{
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            stockReader.close();
            stockReader = new BufferedReader(new FileReader(stockFile));
        }
        return articles;
    }



    @Override
    public void removeStockItem(int idArticle) throws IOException{
        try{
            List<String> lines = new ArrayList<>();

            String line;
            while ((line = stockReader.readLine()) != null) {
                if (line.contains("," + idArticle + ",")) {
                    continue;
                }
                lines.add(line);
            }


            try (PrintWriter writer = new PrintWriter(new FileWriter(stockFile))) {
                for (String l : lines) {
                    writer.println(l);
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        } finally {
            stockReader.close();
            stockReader = new BufferedReader(new FileReader(stockFile));
        }

    }


    @Override
    public List<String> getAllTickets() throws IOException{
        List<String> lines = ticketReader.lines().toList();

        ticketReader.close();
        ticketReader = new BufferedReader(new FileReader(ticketFile));

        return lines;

    }


    @Override
    public float listTotalGains() throws IOException {
        float totalGain = 0f;

        List<String> lines = ticketReader.lines().toList();

        for (int i =0; i < lines.size();i++){

            if (lines.get(i).equalsIgnoreCase("$$$$")){
                totalGain += Float.parseFloat(lines.get(i+1).substring(0,lines.get(i+1).length()-1));
            }

        }

        ticketReader.close();
        ticketReader = new BufferedReader(new FileReader(ticketFile));

        return totalGain;
    }


    @Override
    public void insertTicket(Ticket ticket){
        ticketWriter.println("{");

        ticketWriter.println(ticket.getTicketID());
        ticketWriter.println(ticket.getNameClient());
        ticketWriter.println(ticket.getAddressClient());
        ticketWriter.println("12/04/2003");
        ticketWriter.println("####");
        for(IArticle art : ticket.getArticles()){
            ticketWriter.print(art.getId());
            ticketWriter.print(","+art.getName());
            ticketWriter.print(","+art.getCaracteristic());
            ticketWriter.println(","+art.getPrice()+"€");
        }
        ticketWriter.println("$$$$");
        ticketWriter.println(ticket.getTicketTotal()+"€");
        ticketWriter.println("}");
        ticketWriter.flush();
    }

    @Override
    public int countStock() throws IOException{
        int id = 0;
        String[] tokens;
        String last = "", line;

        try{
            while ((line = stockReader.readLine()) != null) {
                last = line;
            }

            if (last.equalsIgnoreCase("")){
                id = 0;
            }else{
                tokens = last.replace("{","").replace("}","").split(",");
                id = Integer.parseInt(tokens[1]) + 1;
            }


        } catch (IOException e){
            e.printStackTrace();
        }finally {
            stockReader.close();
            stockReader = new BufferedReader(new FileReader(stockFile));
        }
        return id;
    }

    @Override
    public boolean exists(int idArticle) throws IOException{
        String line;
        boolean found = false;

        try{
            while((line=stockReader.readLine())!=null && !found ){
                if (line.contains("," + idArticle + ",")) {
                    found = true;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            stockReader.close();
            stockReader = new BufferedReader(new FileReader(stockFile));
        }


        return found;
    }

    @Override
    public IArticle getOne(int idArticle) throws IOException{
        IArticle art = null;
        try{
            boolean found = false;
            String line= "";
            while((line=stockReader.readLine())!=null && !found){
                String[] tokens = line.replace("{","").replace("}","").split(",");
                int id = Integer.parseInt(tokens[1]);
                if(id == idArticle) {
                    String name = tokens[2];
                    String caract = tokens[3];
                    Float price = Float.parseFloat(tokens[4]);
                    switch (tokens[0]) {
                        case "Tree" -> art = new Tree(id, name, caract, price);
                        case "Decor" -> art = new Decor(id, name, caract, price);
                        case "Flower" -> art = new Flower(id, name, caract, price);
                    }
                    found=true;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            stockReader.close();
            stockReader = new BufferedReader(new FileReader(stockFile));
        }
        return art;
    }
}
