package DeveloperTeam.Model.Repository;

import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Entity.Ticket;

import java.io.IOException;
import java.sql.*;
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
    public List<IArticle> getAll() {
        return null;
    }

    @Override
    public void removeStockItem(int idArticle) {

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
        System.out.println("break");
        return id;
    }

    @Override
    public boolean exists(int idArticle) {
        return false;
    }

    @Override
    public IArticle getOne(int idArticle){
        return null;
    }
}
