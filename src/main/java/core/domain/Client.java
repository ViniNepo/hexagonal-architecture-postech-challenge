package core.domain;

public class Client {
    private String ID;
    private String name;
    private String email;
    private String cpf;

    public Client(String ID, String name, String email, String cpf) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }
}
