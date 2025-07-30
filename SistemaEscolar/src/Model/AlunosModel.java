package Model;

import java.time.LocalDate;

public class AlunosModel {
    private String name;
    private String email;
    private LocalDate aniversario;
    private Integer turmaId;

    public AlunosModel() {
    }

    public AlunosModel(String name, String email, LocalDate aniversario, Integer turmaId) {
        this.name = name;
        this.email = email;
        this.aniversario = aniversario;
        this.turmaId = turmaId;
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

    public LocalDate getAniversario() {
        return aniversario;
    }

    public void setAniversario(LocalDate aniversario) {
        this.aniversario = aniversario;
    }

    public Integer getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Integer turmaId) {
        this.turmaId = turmaId;
    }
}
