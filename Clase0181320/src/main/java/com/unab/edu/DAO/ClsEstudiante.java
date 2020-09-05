/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.Estudiante;
import com.unab.edu.conexionamysql.ConexionBd;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author orell
 */
public class ClsEstudiante {
    ConexionBd conectarclase = new ConexionBd();
    Connection conectar = conectarclase.retornarConexion();
    
    public boolean LoguinEstudiante(String usuario, String pass){
      ArrayList<Estudiante> ListaUsuariosPass = new ArrayList<>();
    
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_S_LOGUINESTUDIANTE(?,?)");
            Statement.setString("pusuario", usuario);
            Statement.setString("ppass",pass);
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            while (resultadoDeConsulta.next()) {
                Estudiante es = new Estudiante();
                es.setUsu(resultadoDeConsulta.getString("USU"));
                es.setPass(resultadoDeConsulta.getString("PASS"));
                ListaUsuariosPass.add(es);
              
            }
            String usuariodebasededatos = null;
            String passdebasededatos = null;
            for(var iterador : ListaUsuariosPass){
            usuariodebasededatos = iterador.getUsu();
            passdebasededatos = iterador.getPass();
            }
            if(usuariodebasededatos.equals(usuario) && passdebasededatos.equals(pass)){
                return true;
            }
             conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }
    
}
