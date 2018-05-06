package beans;

public class Client {

    private String id;
    private String fullName;
    private String greeting;

    public Client(String id, String name) {
        this.id = id;
        this.fullName = name;

    }

    public String getId() { return String.valueOf(id); }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
