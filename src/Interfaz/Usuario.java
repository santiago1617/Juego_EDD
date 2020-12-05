/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import TDAs.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;


/**
 *
 * @author tagoa
 */
public class Usuario {
    private String usuario;
    private String contra;

    public Usuario(String usuario, String contra) {
        this.usuario = usuario;
        this.contra = contra;
    }
    public Usuario(String usuario) {
        this.usuario = usuario;
        this.contra = "";
    }
    public static void Serializar(String archivo, ArrayList<Usuario> usuarios) {
        FileOutputStream stream;
        ObjectOutputStream out = null;
        try {
            stream = new FileOutputStream(archivo, false);
            out = new ObjectOutputStream(stream);
            out.writeObject(usuarios);
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        } catch (IOException ex2) {
            ex2.getMessage();
        }

    }

    //Desearializacion
    public static ArrayList<Usuario> Deserializar(String archivo) {
        FileInputStream arch;
        ObjectInputStream input;
        ArrayList<Usuario> objeto = new ArrayList();
        try {
            arch = new FileInputStream(archivo);
            input = new ObjectInputStream(arch);
            objeto = (ArrayList<Usuario>) input.readObject();
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        } catch (IOException ex) {
            ex.getMessage();
        } catch (ClassNotFoundException ex) {
            ex.getMessage();
        }
        return objeto;
    }
    public static boolean ComprobarExistencia(String nombre){
        ArrayList<Usuario> usuarios=Deserializar("usuarios.txt");
        Usuario us= new Usuario(nombre);
        if(usuarios.contains(us)){
            return true;
        }
        return false;
    }

    /**
     *
     * @return
     */
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }
    
    
}
