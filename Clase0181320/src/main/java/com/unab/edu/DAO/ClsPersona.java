/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.Persona;
import com.unab.edu.conexionamysql.ConexionBd;
import java.sql.*;

import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author orell
 */
public class ClsPersona {

    ConexionBd claseConectar = new ConexionBd();
    Connection conectar = claseConectar.retornarConexion();

    public ArrayList<Persona> MostrarPersona() {
        ArrayList<Persona> Personas = new ArrayList<>();
        try {
            CallableStatement Statement = conectar.prepareCall(" call SP_S_Persona()");
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            while (resultadoDeConsulta.next()) {
                Persona persona = new Persona();
                persona.setIdPersona(resultadoDeConsulta.getInt("idPersona"));
                persona.setNombre(resultadoDeConsulta.getString("Nombre"));
                persona.setApellido(resultadoDeConsulta.getString("Apellido"));
                persona.setEdad(resultadoDeConsulta.getInt("Edad"));
                persona.setSexo(resultadoDeConsulta.getString("Sexo"));
                persona.setFecha(resultadoDeConsulta.getDate("Fecha"));
                Personas.add(persona);
            }
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return Personas;
    }

    public void AgregarPersonas(Persona Per) {
        try {
            CallableStatement Statement = conectar.prepareCall(" call SP_I_Persona(?,?,?,?,?)");
            Statement.setString("PNombre", Per.getNombre());
            Statement.setString("PApellido", Per.getApellido());
            Statement.setInt("PEdad", Per.getEdad());
            Statement.setString("PSexo", Per.getSexo());
            Statement.setDate("PFecha", new java.sql.Date (Per.getFecha().getTime()));
            Statement.execute();
            JOptionPane.showMessageDialog(null, "PERSONA GUARDADA");
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void BorrarPersonas(Persona Per) {
        try {
            CallableStatement Statement = conectar.prepareCall(" call SP_D_Persona(?)");
            Statement.setInt("PIdPersonas", Per.getIdPersona());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "PERSONA ELIMINADA");
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void ActualizarPersona(Persona Per) {
        try {
            CallableStatement Statement = conectar.prepareCall(" call SP_U_Persona(?,?,?,?,?)");
            Statement.setInt("PIdPersona", Per.getIdPersona());
            Statement.setString("PNombre", Per.getNombre());
            Statement.setString("PApellido", Per.getApellido());
            Statement.setInt("PEdad", Per.getEdad());
            Statement.setString("PSexo", Per.getSexo());
            Statement.execute();
            conectar.close();
            JOptionPane.showMessageDialog(null, "PERSONA ACTUALIZADA");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    

}
