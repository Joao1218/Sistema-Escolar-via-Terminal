package Model;

import java.math.BigDecimal;

public class NotasModel {
    private Integer alunoId;
    private Integer materiaId;
    private Integer professorId;
    private BigDecimal nota;

    public NotasModel() {
    }

    public NotasModel(Integer alunoId, Integer materiaId, Integer professorId, BigDecimal nota) {
        this.alunoId = alunoId;
        this.materiaId = materiaId;
        this.professorId = professorId;
        this.nota = nota;
    }

    public Integer getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Integer alunoId) {
        this.alunoId = alunoId;
    }

    public Integer getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Integer materiaId) {
        this.materiaId = materiaId;
    }

    public Integer getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Integer professorId) {
        this.professorId = professorId;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }
}
