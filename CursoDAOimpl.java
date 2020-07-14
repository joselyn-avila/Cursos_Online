/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosonline.dao;

import cursosonline.entidades.Curso;
import cursosonline.util.Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicol
 */
public class CursoDAOimpl implements CursoDAO{
    
   

    @Override
    public List<Curso> getCursos() {
        List<Curso> cursos= new ArrayList<>();
        Connection conn;
        try {
            conn = DriverManager.getConnection(Util.url, Util.user, Util.password);
            
            
             String sql = "SELECT id, nombre FROM public.cursos;";
             PreparedStatement stm = conn.prepareStatement(sql);
           
            ResultSet rs= stm.executeQuery();
            while(rs.next()){
                Curso curso = new Curso(rs.getInt(1),rs.getString(2));
                cursos.add(curso);
               
        }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return cursos;
    }

    @Override
    public void ingresar(Curso curso) {
        String query = "INSERT INTO public.cursos(nombre) VALUES (?);";
        Connection conn;
         try {
            conn = DriverManager.getConnection(Util.url, Util.user, Util.password);
            
             PreparedStatement stm = conn.prepareStatement(query);
             stm.setString(1, curso.getNombre());
             stm.execute();
                     }
         catch(SQLException e){
             e.printStackTrace();
         }
            
    }

    @Override
    public void actualizar(Curso curso) {
        String query ="UPDATE public.cursos SET nombre=? WHERE id=?;";
        Connection conn;
         try {
            conn = DriverManager.getConnection(Util.url, Util.user, Util.password);
            
             PreparedStatement stm = conn.prepareStatement(query);
             stm.setString(1, curso.getNombre());
             stm.setInt(2, curso.getId());
             stm.execute();
             }
                catch(SQLException e){
             e.printStackTrace();
         }
	
        
    }

    @Override
    public void eliminar(int id) {
        String query = "DELETE FROM public.cursos WHERE id=?;";
        Connection conn;
         try {
            conn = DriverManager.getConnection(Util.url, Util.user, Util.password);
            
             PreparedStatement stm = conn.prepareStatement(query);
             stm.setInt(1, id);
             stm.execute();
             }
         catch(SQLException e){
             e.printStackTrace();
         }
	
        
        
    }
    
}
