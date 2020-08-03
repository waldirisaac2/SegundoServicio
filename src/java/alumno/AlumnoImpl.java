/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumno;
import java.sql.*;
import java.util.*;
import com.mysql.jdbc.MysqlIO;
import conexion.Conexion;


/**
 *
 * @author Acer
 */
public class AlumnoImpl {
    Conexion x  = new Conexion();
    String sql="";
    ArrayList<Alumno> listAlumnosEgresados = new ArrayList<Alumno>();
    
    public ArrayList<Alumno> listEgresados(String s_anhio_egreso) throws Exception{
        
        try {
            Connection conn = x.connectDatabase();
            sql="SELECT * FROM alumno where alumno_codigo like '"+ s_anhio_egreso +"%'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Alumno datos= new Alumno();
                datos.setO_alumno_id(rs.getString("alumno_id"));
                datos.setO_alumno_codigo(rs.getString("alumno_codigo"));
                
                datos.setO_alumno_nombres(rs.getString("alumno_nombres"));
                datos.setO_alumno_apellido_paterno(rs.getString("alumno_apellido_paterno"));
                datos.setO_alumno_apellido_materno(rs.getString("alumno_apellido_materno"));
                
                datos.setO_alumno_direccion(rs.getString("alumno_direccion"));
                listAlumnosEgresados.add(datos);
            }
            
        } catch (SQLException e) {
                System.out.println("Error: " + e);
                
        }
        
        return listAlumnosEgresados;
    
    }
    
    public static void main(String[] args) throws Exception{
        AlumnoImpl am = new AlumnoImpl();
      
        for(Alumno ad: am.listEgresados("2004")){
            System.out.println("en el for loop");
            System.out.println(ad.getO_alumno_codigo());
            System.out.println(ad.getO_alumno_nombres());
        }
    }
}
