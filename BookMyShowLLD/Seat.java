package BookMyShowLLD;

public class Seat {
    Integer id;
    Integer row;
    Catagory searCatagory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Catagory getSearCatagory() {
        return searCatagory;
    }

    public void setSearCatagory(Catagory searCatagory) {
        this.searCatagory = searCatagory;
    }
}
