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

    public boolean LoguinEstudiante(String usuario, String pass) {
        ArrayList<Estudiante> ListaUsuariosPass = new ArrayList<>();

        try {
            CallableStatement Statement = conectar.prepareCall("call SP_S_LOGUINESTUDIANTE(?,?)");
            Statement.setString("pusuario", usuario);
            Statement.setString("ppass", pass);
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            while (resultadoDeConsulta.next()) {
                Estudiante es = new Estudiante();
                es.setUsu(resultadoDeConsulta.getString("USU"));
                es.setPass(resultadoDeConsulta.getString("PASS"));
                ListaUsuariosPass.add(es);

            }
            String usuariodebasededatos = null;
            String passdebasededatos = null;
            for (var iterador : ListaUsuariosPass) {
                usuariodebasededatos = iterador.getUsu();
                passdebasededatos = iterador.getPass();
            }
            if (usuariodebasededatos.equals(usuario) && passdebasededatos.equals(pass)) {
                return true;
            }
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }

    public ArrayList<Estudiante> MostrarEstudiante() {
        ArrayList<Estudiante> Estudiantes = new ArrayList<>();
        try {
            CallableStatement Statement = conectar.prepareCall(" call SP_S_Estudiante()");
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            while (resultadoDeConsulta.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setIdEsudiante(resultadoDeConsulta.getInt("idEstudiante"));
                estudiante.setMatricula(resultadoDeConsulta.getInt("matricula"));
                estudiante.setIdPersona(resultadoDeConsulta.getInt("idPersona"));
                estudiante.setNombre(resultadoDeConsulta.getString("Nombre"));
                estudiante.setUsu(resultadoDeConsulta.getString("USU"));
                estudiante.setPass(resultadoDeConsulta.getString("PASS"));
                estudiante.setNie(resultadoDeConsulta.getInt("NIE"));
                Estudiantes.add(estudiante);

            }
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return Estudiantes;

    }
    
    public void AgregarEstudiante(Estudiante Est) {
        try {
            CallableStatement Statement = conectar.prepareCall(" call SP_I_Estudiante(?,?,?,?,?)");
            Statement.setInt("PMatricula", Est.getMatricula());
            Statement.setInt("PIdPersona", Est.getIdPersona());
            Statement.setString("PUsu", Est.getUsu());
            Statement.setString("PPass", Est.getPass());
            Statement.setInt("PNie", Est.getNie());
            Statement.executeQuery();
            JOptionPane.showMessageDialog(null, "ESTUDIANTE GUARDADO");
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void BorrarEstudiante(Estudiante Est) {
        try {
            CallableStatement Statement = conectar.prepareCall(" call SP_D_Estudiante(?)");
            Statement.setInt("PIdEstudiante", Est.getIdEsudiante());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "ESTUDIANTE ELIMINADO");
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void ActualizarEsudiante(Estudiante Est) {
        try {
            CallableStatement Statement = conectar.prepareCall(" call SP_U_Estudiante(?,?,?,?,?,?)");
            Statement.setInt("PIdEstudiante", Est.getIdEsudiante());
            Statement.setInt("PMatricula", Est.getMatricula());
            Statement.setInt("PIdPersona", Est.getIdPersona());
            Statement.setString("PUsu", Est.getUsu());
            Statement.setString("PPass", Est.getPass());
             Statement.setInt("PNie", Est.getNie());
            Statement.execute();
            conectar.close();
            JOptionPane.showMessageDialog(null, "ESTUDIANTE ACTUALIZADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
