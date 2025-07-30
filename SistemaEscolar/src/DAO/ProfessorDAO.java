package DAO;

import Model.ProfessorModel;
import Singleton.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public void createProfessor(ProfessorModel professor) throws Exception{
        try{
            this.conn = DB.getConn();
            this.ps = conn.prepareStatement("INSERT INTO professores (nome, email, telefone, materia_id) VALUE (?,?,?,?)");
            ps.setString(1,professor.getName());
            ps.setString(2,professor.getEmail());
            ps.setString(3, professor.getTelefone());
            ps.setInt(4,professor.getMateriaId());
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }finally {
            DB.closeConection();
            DB.closePrepareStatement(ps);
        }
    }
    public List<ProfessorModel> readProfessores() throws Exception{
        List<ProfessorModel> professores = new ArrayList<>();
        try{
            this.conn = DB.getConn();
            this.ps = conn.prepareStatement("SELECT * FROM professores");
            this.rs = ps.executeQuery();
            while(rs.next()){
                ProfessorModel professor = new ProfessorModel();
                professor.setName(rs.getString("nome"));
                professor.setEmail(rs.getString("email"));
                professor.setTelefone(rs.getString("telefone"));
                professor.setMateriaId(rs.getInt("materia_id"));
                professores.add(professor);
            }
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }finally {
            DB.closeConection();
            DB.closePrepareStatement(ps);
            DB.closeResultSet(rs);
        }
        return professores;
    }
    public void updateProfessor(ProfessorModel professor) throws Exception{
        try{
            this.conn = DB.getConn();
            this.ps = conn.prepareStatement("UPDATE professores SET nome = ?, email = ?, telefone = ?, materia_id = ? WHERE id = ?");
            ps.setString(1,professor.getName());
            ps.setString(2,professor.getEmail());
            ps.setString(3,professor.getTelefone());
            ps.setInt(4,professor.getMateriaId());
            ps.setInt(5,professor.getId());
            ps.executeUpdate();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }finally {
            DB.closeConection();
            DB.closePrepareStatement(ps);
        }
    }
    public void deleteProfessor(int id) throws Exception{
        try{
            this.conn = DB.getConn();
            this.ps = conn.prepareStatement("DELETE FROM professores WHERE id = ?");
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
