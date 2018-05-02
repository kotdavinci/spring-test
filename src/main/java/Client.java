public class Client {

    private int id;
    private String fullName;

    public Client(String id, String name) {
        this.id = Integer.parseInt(id);
        this.fullName = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
