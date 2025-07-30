package DAO;

import Model.NotasModel;
import Singleton.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotasDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public void createNotas(NotasModel notas) throws Exception{
        try{
            this.conn = DB.getConn();
            this.ps = conn.prepareStatement("INSERT INTO notas (aluno_id, materia_id, professor_id, nota) VALUES (?,?,?,?)");
            ps.setInt(1,notas.getAlunoId());
            ps.setInt(2,notas.getMateriaId());
            ps.setInt(3,notas.getProfessorId());
            ps.setBigDecimal(4,notas.getNota());
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }finally{
            DB.closeConection();
            DB.closePrepareStatement(ps);
        }
    }
    public List<NotasModel> readNotas() throws Exception{
        List<NotasModel> notas = new ArrayList<>();
        try{
            this.conn = DB.getConn();
            this.ps = conn.prepareStatement("SELECT * FROM notas");
            this.rs = ps.executeQuery();
            while(rs.next()){
                NotasModel nota = new NotasModel();
                nota.setNota(rs.getBigDecimal("nota"));
                nota.setProfessorId(rs.getInt("professor_id"));
                nota.setMateriaId(rs.getInt("materia_id"));
                nota.setAlunoId(rs.getInt("aluno_id"));
                notas.add(nota);
            }
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }finally {
            DB.closeConection();
            DB.closePrepareStatement(ps);
            DB.closeResultSet(rs);
        }
        return notas;
    }
    public void updateNotas(NotasModel notas) throws Exception{
            try{
                this.conn = DB.getConn();
                this.ps = conn.prepareStatement("UPDATE notas SET nota = ?, aluno_id = ?, materia_id = ?, professor_id = ? WHERE id = ?");
                ps.setBigDecimal(1,notas.getNota());
                ps.setInt(2,notas.getAlunoId());
                ps.setInt(3,notas.getMateriaId());
                ps.setInt(4,notas.getProfessorId());
                ps.setInt(5,notas.getId());
                ps.executeUpdate();
            }catch (SQLException e){
                throw new SQLException(e.getMessage());
            }finally {
                DB.closeConection();
                DB.closePrepareStatement(ps);
            }
    }
    public void deleteNotas(int id) throws Exception{
        try{
            this.conn = DB.getConn();
            this.ps = conn.prepareStatement("DELETE FROM notas WHERE id = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }finally {
            DB.closeConection();
            DB.closePrepareStatement(ps);
        }
    }
}
