package Model;

public class ProfessorModel {
    private String name;
    private String email;
    private String telefone;
    private Integer materiad;

    public ProfessorModel() {
    }

    public ProfessorModel(String name, String email, String telefone, Integer materiad) {
        this.name = name;
        this.email = email;
        this.telefone = telefone;
        this.materiad = materiad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getMateriad() {
        return materiad;
    }

    public void setMateriad(Integer materiad) {
        this.materiad = materiad;
    }
}
