package DeveloperTeam.Model.Repository;

import DeveloperTeam.Model.Entity.IArticle;
import DeveloperTeam.Model.Entity.Ticket;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
                "clase VARCHAR(30),\n" +
                "id INT PRIMARY KEY,\n" +
                "characteristic VARCHAR(30),\n" +
                "price FLOAT\n" +
                ")";
        String initTicket = "";
        stmt.execute(initStock);
    }

    @Override
    public void addStockItem(IArticle IArticle) {

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
    public void insertTicket(Ticket ticket){

    }

    @Override
    public int countStock() throws IOException {
        return 0;
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
