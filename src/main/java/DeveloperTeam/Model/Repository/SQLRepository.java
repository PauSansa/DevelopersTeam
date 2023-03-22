package DeveloperTeam.Model.Repository;

import DeveloperTeam.Model.Entity.*;

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
        String initTicket = "";
        stmt.execute(initStock);
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
    public List<String> getAllTickets() {
        return null;
    }

    @Override
    public void insertTicket(Ticket ticket){

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
    public IArticle getOne(int idArticle){
        return null;
    }
}
