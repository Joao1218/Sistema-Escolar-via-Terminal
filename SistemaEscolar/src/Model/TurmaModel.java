package Model;

public class TurmaModel {
    private String name;
    private Integer anoLetivo;

    public TurmaModel() {
    }

    public TurmaModel(String name, Integer anoLetivo) {
        this.name = name;
        this.anoLetivo = anoLetivo;
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
}
