package DAO;

import Model.MateriasModel;
import Singleton.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MateriasDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public void createMateria(MateriasModel materia) throws Exception{
        try{
            this.conn = DB.getConn();
            this.ps = conn.prepareStatement("INSERT INTO materias (nome, descricao) VALUE (?,?)");
            ps.setString(1,materia.getNome());
            ps.setString(2,materia.getDescricao());
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }finally {
            DB.closeConection();
            DB.closePrepareStatement(ps);
        }
    }

    public List<MateriasModel> readMaterias() throws Exception{
        List<MateriasModel> materia = new ArrayList<>();
        try{
            this.conn = DB.getConn();
            this.ps = conn.prepareStatement("SELECT * FROM materias");
            this.rs = ps.executeQuery();
            while(rs.next()){
                MateriasModel materias = new MateriasModel();
                materias.setNome(rs.getString("nome"));
                materias.setDescricao(rs.getString("descricao"));
                materia.add(materias);
            }
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }finally {
            DB.closeConection();
            DB.closePrepareStatement(ps);
        }
        return materia;
    }

    public void updateMateria(MateriasModel materias) throws Exception{
        try{
            this.conn = DB.getConn();
            this.ps = conn.prepareStatement("UPDATE materias SET nome = ?, descricao = ? WHERE id = ? ");
            ps.setString(1,materias.getNome());
            ps.setString(2,materias.getDescricao());
            ps.setInt(3,materias.getId());
            ps.executeUpdate();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }finally {
            DB.closeConection();
            DB.closePrepareStatement(ps);
        }
    }
    public void deleteMateria(int id)throws Exception{
        try{
            this.conn = DB.getConn();
            this.ps = conn.prepareStatement("DELETE FROM materias WHERE id = ?");
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
