package DAO;
import Singleton.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdmDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public Boolean readMaterias(String nome, String cpf) throws Exception{
        Boolean retorno = null;
        try{
            this.conn = DB.getConn();
            this.ps = conn.prepareStatement("SELECT * FROM administrador");
            this.rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getString("nome").equals(nome) && rs.getString("cpf").equals(cpf)){
                    retorno = true;
                } else {
                    retorno = false;
                }
            }
            return retorno;
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }finally {
            DB.closeConection();
            DB.closePrepareStatement(ps);
        }
    }

}
