package DAO;

import Model.AlunosModel;
import Singleton.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AlunosDAO {
        private Connection conn;
        private PreparedStatement ps;
        private ResultSet rs;

        public void createAluno(AlunosModel aluno) throws Exception {
            try{
                this.conn = DB.getConn();
                this.ps = conn.prepareStatement("INSERT INTO alunos (nome, email, data_nascimento, turma_id) VALUES" +
                        "(?,?,?,?)");
                ps.setString(1,aluno.getName());
                ps.setString(2, aluno.getEmail());
                ps.setDate(3, java.sql.Date.valueOf(aluno.getAniversario()));
                ps.setInt(4,aluno.getTurmaId());

            }catch (SQLException e){
                throw new SQLException(e.getMessage());
            }finally {
                DB.closeConection();
                DB.closePrepareStatement(ps);
            }
        }
        public List<AlunosModel> readALunos() throws Exception{
            List<AlunosModel> alunos = new ArrayList<>();
            try {
                this.conn = DB.getConn();
                this.ps = conn.prepareStatement("SELECT * FROM alunos");
                this.rs = ps.executeQuery();
                while (rs.next()) {
                    AlunosModel aluno = new AlunosModel();
                    aluno.setName(rs.getString("nome"));
                    aluno.setEmail(rs.getString("email"));
                    aluno.setAniversario(rs.getDate("data_nascimento").toLocalDate());
                    aluno.setTurmaId(rs.getInt("turma_id"));
                    alunos.add(aluno);
                }
            } catch (SQLException e) {
                throw new SQLException(e.getMessage());
            }finally {
                DB.closeConection();
                DB.closePrepareStatement(ps);
                DB.closeResultSet(rs);
            }
            return alunos;
        }
        public void UpdateAluno(AlunosModel aluno) throws Exception{
            try{
                this.conn = DB.getConn();
                this.ps = conn.prepareStatement(
                        "UPDATE alunos SET nome = ?, email = ?, data_nascimento = ?, turma_id = ? WHERE id = ?"
                );
                ps.setString(1, aluno.getName());
                ps.setString(2, aluno.getEmail());
                ps.setDate(3, java.sql.Date.valueOf(aluno.getAniversario()));
                ps.setInt(4, aluno.getTurmaId());
                ps.setInt(5, aluno.getId());
                ps.executeUpdate();
            }catch (SQLException e){
                throw new SQLException(e.getMessage());
            }finally {
                DB.closeConection();
                DB.closePrepareStatement(ps);
            }
        }
        public void deleteALuno(Integer id)throws Exception {
            try {
                this.conn = DB.getConn();
                this.ps = conn.prepareStatement("DELETE FROM alunos WHERE id = ?");
                ps.setInt(1, id);
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new SQLException(e.getMessage());
            } finally {
                DB.closeConection();
                DB.closePrepareStatement(ps);
            }
        }
}
