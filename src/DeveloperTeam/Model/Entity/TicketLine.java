package DeveloperTeam.Model.Entity;

public class TicketLine {

    private int numLinia;
    private String nomArticle;
    private String descArticle;
    private int qtyArticle;
    private float preuArticle;

    public TicketLine(int numLinia, String nomArticle, String descArticle, int qtyArticle, float preuArticle) {
        this.numLinia = numLinia;
        this.nomArticle = nomArticle;
        this.descArticle = descArticle;
        this.qtyArticle = qtyArticle;
        this.preuArticle = preuArticle;
    }


    public int getNumLinia() {
        return numLinia;
    }

    public void setNumLinia(int numLinia) {
        this.numLinia = numLinia;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public String getDescArticle() {
        return descArticle;
    }

    public void setDescArticle(String descArticle) {
        this.descArticle = descArticle;
    }

    public int getQtyArticle() {
        return qtyArticle;
    }

    public void setQtyArticle(int qtyArticle) {
        this.qtyArticle = qtyArticle;
    }

    public float getPreuArticle() {
        return preuArticle;
    }

    public void setPreuArticle(float preuArticle) {
        this.preuArticle = preuArticle;
    }


    @Override
    public String toString() {
        return "TicketLine{" +
                "numLinia=" + numLinia +
                ", nomArticle='" + nomArticle + '\'' +
                ", descArticle='" + descArticle + '\'' +
                ", qtyArticle=" + qtyArticle +
                ", preuArticle=" + preuArticle +
                '}';
    }




}
