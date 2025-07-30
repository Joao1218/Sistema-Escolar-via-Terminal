package Model;

public class MateriasModel {
    private String nome;
    private String descricao;
    private Integer id;

    public MateriasModel() {
    }

    public MateriasModel(String nome, String descricao, Integer id) {
        this.nome = nome;
        this.descricao = descricao;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
