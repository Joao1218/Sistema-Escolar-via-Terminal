package Model;

public class ProfessorModel {
    private String name;
    private String email;
    private String telefone;
    private Integer materiaId;
    private Integer id;

    public ProfessorModel() {
    }

    public ProfessorModel(String name, String email, String telefone, Integer materiaId, Integer id) {
        this.name = name;
        this.email = email;
        this.telefone = telefone;
        this.materiaId = materiaId;
        this.id = id;
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

    public Integer getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Integer materiaId) {
        this.materiaId = materiaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
