package DeveloperTeam.Model.Repository;

import DeveloperTeam.Model.Entity.*;

import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLRepository implements Repository{
    private Connection conn;
    private Statement stmt;

    public SQLRepository() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/developer_team",
                "root",
                "root"
        );
        stmt = conn.createStatement();
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
        //TODO en el service llamar antes de a data.remov.... a exists y si el id no existe no llamar a este metodo
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
//        ticketWriter.println("{");
//
//        ticketWriter.println(ticket.getTicketID());
//        ticketWriter.println(ticket.getNameClient());
//        ticketWriter.println(ticket.getAddressClient());
//        ticketWriter.println("12/04/2003");
//        ticketWriter.println("####");
//        for(IArticle art : ticket.getArticles()){
//            ticketWriter.print(art.getId());
//            ticketWriter.print(","+art.getName());
//            ticketWriter.print(","+art.getCaracteristic());
//            ticketWriter.println(","+art.getPrice()+"€");
//        }
//        ticketWriter.println("$$$$");
//        ticketWriter.println(ticket.getTicketTotal()+"€");
//        ticketWriter.println("}");

        String query = "INSERT INTO ticket(line) VALUES(%s)";
        stmt.execute(String.format(query,ticket.getTicketID()));
        stmt.execute(String.format(query,ticket.getNameClient()));
        stmt.execute(String.format(query,ticket.getAddressClient()));
        stmt.execute(String.format(query,ticket.getTicketDate()));
        stmt.execute(String.format(query,"####"));
        //TODO acabar implementacion

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
        return article;

    }
}
