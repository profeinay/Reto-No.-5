package reto4.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import reto4.model.vo.ComprasPorProyectoVo;
import reto4.utils.JDBCUtilities;

public class ComprasPorProyectoDao {
    public List<ComprasPorProyectoVo> listar() throws SQLException{
        List<ComprasPorProyectoVo> respuesta = new ArrayList<ComprasPorProyectoVo>();
        Connection conn = JDBCUtilities.getConnection();
        java.sql.Statement stm = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Compra as id, p.Constructora, p.Banco_Vinculado as banco FROM Compra c JOIN Proyecto p ON c.ID_Proyecto = p.ID_Proyecto WHERE Proveedor = 'Homecenter' AND p.Ciudad = 'Salento'";
        
        try{
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while(rs.next()){
                ComprasPorProyectoVo vo = new ComprasPorProyectoVo();
                vo.setId(rs.getInt("id"));
                vo.setConstructora(rs.getString("constructora"));
                vo.setBanco(rs.getString("banco"));
                respuesta.add(vo);
            }
        }
        finally{
            if (rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(conn !=null){
                conn.close();
            }
        }
        return respuesta;
    }
}
