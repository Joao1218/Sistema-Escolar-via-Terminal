package DAO;

import Model.MateriasModel;
import Model.TurmaModel;
import Singleton.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public void createTurma(TurmaModel turma) throws Exception{
        try{
            this.conn = DB.getConn();
            this.ps = conn.prepareStatement("INSERT INTO turmas (nome, ano_letivo) VALUE (?,?)");
            ps.setString(1,turma.getName());
            ps.setInt(2,turma.getAnoLetivo());
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }finally {
            DB.closeConection();
            DB.closePrepareStatement(ps);
        }
    }

    public List<TurmaModel> readTurma() throws Exception{
        List<TurmaModel> turmas = new ArrayList<>();
        try{
            this.conn = DB.getConn();
            this.ps = conn.prepareStatement("SELECT * FROM turmas");
            this.rs = ps.executeQuery();
            while(rs.next()){
                TurmaModel turma = new TurmaModel();
                turma.setName(rs.getString("nome"));
                turma.setAnoLetivo(rs.getInt("ano_letivo"));
                turmas.add(turma);
            }
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }finally {
            DB.closeConection();
            DB.closePrepareStatement(ps);
        }
        return turmas;
    }

    public void updateTurmas(TurmaModel turma) throws Exception{
        try{
            this.conn = DB.getConn();
            this.ps = conn.prepareStatement("UPDATE turmas SET nome = ?, ano_letivo = ? WHERE id = ? ");
            ps.setString(1,turma.getName());
            ps.setInt(2,turma.getAnoLetivo());
            ps.setInt(3,turma.getId());
            ps.executeUpdate();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }finally {
            DB.closeConection();
            DB.closePrepareStatement(ps);
        }
    }
    public void deleteTurma(int id)throws Exception{
        try{
            this.conn = DB.getConn();
            this.ps = conn.prepareStatement("DELETE FROM turmas WHERE id = ?");
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
