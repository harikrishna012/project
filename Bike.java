public class Bike {
    private int id;
    private String model;
    private boolean isAvailable;

    public Bike(int id, String model) {
        this.id = id;
        this.model = model;
        this.isAvailable = true;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Bike [ID=" + id + ", Model=" + model + ", Available=" + isAvailable + "]";
    }
}
