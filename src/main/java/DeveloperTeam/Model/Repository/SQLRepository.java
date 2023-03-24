package DeveloperTeam.Model.Repository;

import DeveloperTeam.Application.WindowManager;
import DeveloperTeam.Exceptions.StoppedByUser;
import DeveloperTeam.Model.Entity.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLRepository implements Repository{
    private Connection conn;
    private Statement stmt;

    public SQLRepository() throws SQLException, StoppedByUser {
        boolean done = false;
        boolean cont = true;
        while(!done && cont){
            try{
                String[] credentials = WindowManager.getSQLConnection();
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost",
                        credentials[0],
                        credentials[1]
                );
                stmt = conn.createStatement();
                stmt.execute("CREATE DATABASE IF NOT EXISTS developer_team");
                stmt.execute("USE developer_team");
                String initStock = "CREATE TABLE IF NOT EXISTS stock(\n" +
                        "class VARCHAR(30),\n" +
                        "id INT,\n" +
                        "name VARCHAR(30),\n" +
                        "caracteristic VARCHAR(30),\n" +
                        "price FLOAT\n" +
                        ");";
                String initTicket = "CREATE TABLE IF NOT EXISTS Ticket (\n" +
                        "  `line` VARCHAR(90) NOT NULL,\n" +
                        "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                        "  PRIMARY KEY (`id`));";
                stmt.execute(initStock);
                stmt.execute(initTicket);
                done=true;
            }catch (SQLException e){
                if(!WindowManager.promptYesNo("The Conexion failed, do you wanna try again?")){
                    throw new StoppedByUser("The app has been stopped by the user");
                }
            }
        }

    }

    @Override
    public void addStockItem(IArticle IArticle) {
        try {
            String query = "INSERT INTO stock (class, id, name, caracteristic, price) " +
                    "VALUES ('%s', %d, '%s', '%s', %s);";
            query = String.format(query, IArticle.getClass().getSimpleName(), IArticle.getId(), IArticle.getName(),
                    IArticle.getCaracteristic(), String.format("%.2f",IArticle.getPrice()).replace(",","."));
            stmt.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<IArticle> getAll() throws SQLException{
        ResultSet rs = stmt.executeQuery("SELECT * FROM STOCK");
        List<IArticle> articles = new ArrayList<>();
        while(rs.next()){

            int id = rs.getInt("id");
            String name = rs.getString("name");
            String caract = rs.getString("caracteristic");
            float price = rs.getFloat("price");
            switch(rs.getString("class").toLowerCase()){
                case "tree"-> articles.add(new Tree(id,name,caract,price));
                case "decor"-> articles.add(new Decor(id,name,caract,price));
                case "flower"-> articles.add(new Flower(id,name,caract,price));
            }
        }
        return articles;
    }

    @Override
    public void removeStockItem(int idArticle) throws SQLException{
        String query = String.format("DELETE FROM stock WHERE id=%d;",idArticle);
        stmt.execute(query);

    }

    @Override
    public List<String> getAllTickets() throws SQLException{
        List<String> lines = new ArrayList<>();
        ResultSet rs = stmt.executeQuery("SELECT * FROM TICKET");
        while(rs.next()){
            lines.add(rs.getString("line"));
        }

        return lines;
    }

    @Override
    public void insertTicket(Ticket ticket) throws SQLException{
        insertTicketLine(Integer.toString(ticket.getTicketID()));
        insertTicketLine(ticket.getNameClient());
        insertTicketLine(ticket.getAddressClient());
        insertTicketLine(ticket.getTicketDate());
        insertTicketLine("####");
        for(IArticle art : ticket.getArticles()){
            String article = String.join(", ", Integer.toString(art.getId()),art.getName(),art.getCaracteristic(),Float.toString(art.getPrice()));
            insertTicketLine(article);
        }
        insertTicketLine("$$$$");
        insertTicketLine(Float.toString(ticket.getTicketTotal()));
        insertTicketLine("}");
    }

    public void insertTicketLine(String line) throws SQLException{
        String query = "INSERT INTO ticket(line) VALUES(%s)";
        stmt.execute(String.format(query,line));
    }

    @Override
    public float listTotalGains() throws IOException {
        return 0;
    }

    @Override
    public int countStock() throws SQLException {
        ResultSet rs =stmt.executeQuery("SELECT id FROM stock ORDER BY id DESC LIMIT 1;");
        int id = 0;
        if(rs.next()){
            id = rs.getInt("id")+1;
        }
        rs.close();
        return id;
    }

    @Override
    public boolean exists(int idArticle) throws SQLException{
        ResultSet rs =stmt.executeQuery("SELECT id FROM stock ORDER BY id DESC LIMIT 1;");
        if(rs.next()){
            rs.close();
            return true;
        }else{
            rs.close();
            return false;
        }
    }

    @Override
    public IArticle getOne(int idArticle) throws SQLException{
        ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM stock WHERE id = %d LIMIT 1",idArticle));
        IArticle article = null;
        if(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String caract = rs.getString("caracteristic");
            float price = rs.getFloat("price");
            switch(rs.getString("class").toLowerCase()){
                case "tree"-> article =(new Tree(id,name,caract,price));
                case "decor"-> article =(new Decor(id,name,caract,price));
                case "flower"-> article =(new Flower(id,name,caract,price));
            }
        }
        rs.close();
        return article;

    }
}
