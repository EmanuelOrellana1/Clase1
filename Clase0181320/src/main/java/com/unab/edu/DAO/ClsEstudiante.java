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

    public boolean LoguinEstudiante(String usuario, String Pass) {
        ArrayList<Estudiante> ListaUsuarios = new ArrayList<>();
        ArrayList<Estudiante> ListarContra = new ArrayList<>();
        try {
            CallableStatement st = conectar.prepareCall("call SP_S_LOGUINESTUDIANTE(?,?)");

            st.setString("pusuario", usuario);
            st.setString("ppass", Pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Estudiante es = new Estudiante();
                es.setUsu(rs.getNString("USU"));
                es.setPass(rs.getNString("PASS"));
                ListaUsuarios.add(es);
            }
            String usuariodebasedatos = null;
            String passdebasededatos = null;
            for (var iterador : ListaUsuarios) {
                usuariodebasedatos = iterador.getUsu();
                passdebasededatos = iterador.getPass();
                System.err.print(passdebasededatos + "" + Pass);

            }

            CallableStatement st2 = conectar.prepareCall("call SP_S_CRIP(?)");
            st2.setString("PcripPass", Pass);
            ResultSet rs2 = st2.executeQuery();
            while (rs2.next()) {
                Estudiante escrip = new Estudiante();

                escrip.setPass(rs2.getNString("crip"));
                ListarContra.add(escrip);
            }

            String passcrip = null;
            for (var iterador : ListarContra) {

                passcrip = iterador.getPass();

                Pass = passcrip;

            }

            if (usuariodebasedatos != null && passdebasededatos != null) {
                if (usuariodebasedatos.equals(usuario) && passdebasededatos.equals(Pass)) {
                    return true;
                }
            }
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
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
