package Model;

public class TurmaModel {
    private String name;
    private Integer anoLetivo;
    private Integer id;

    public TurmaModel() {
    }

    public TurmaModel(String name, Integer anoLetivo, Integer id) {
        this.name = name;
        this.anoLetivo = anoLetivo;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(Integer anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
