package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Usuario;

/**
 *
 * @author algui
 */
public class DaoUsuario {
    private final Conexion conexion = new Conexion();
    private Connection conn;
    private PreparedStatement modificarUsuario;
    private PreparedStatement mostrarUsuario;
    ArrayList<Usuario> listaUsuario = new ArrayList<>();
    
    @Override
    public void finalize() throws Throwable{
        
    }
    /**
     * Establece conexion con la base de datos y prepara los enunciados a 
     * insertar en el Query
     */
    public DaoUsuario(){
        try{
            conn = conexion.obtenerConexion();
            mostrarUsuario = conn.prepareStatement("Select * from Usuario");
            modificarUsuario = conn.prepareStatement("Update Usuario set"
                    + " passw = ?, usuario = ?"
                    + " where usuario = ?");

            listaUsuario = new ArrayList<>();
            listaUsuario = this.listarUsuario();
                    
            
        }catch(Exception ex){
            ex.printStackTrace();
            conexion.close(conn);
        }
    }
    /**
     * Accede al arreglo de usuario
     * @return 
     */
    private ArrayList<Usuario> getListaUsuario(){
        return listaUsuario;
    }
    
    /**
     * Carga los datos de la base de datos en el arreglo Usuario
     * @return 
     */
    private ArrayList<Usuario> listarUsuario() {
        ArrayList<Usuario> listado = null;
        ResultSet rs = null;
        try{
            rs = mostrarUsuario.executeQuery();
            listado = new ArrayList<>();
            while(rs.next()){
                listado.add(new Usuario(
                        rs.getString("usuario"),
                        rs.getString("passw"),
                        1
                ));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
   
        }finally{
            try{
                rs.close();
            }catch(SQLException ex){
                conexion.close(conn);
                ex.printStackTrace();
            }
        }
        return listado;
    }
    /**
     * Modifica la contraseña del usuario en el arreglo utilizando el 
     * nombre de usuario como referencia
     * @param username
     * @param password
     * @return 
    */
    public int modificarUsuario(String username, String password){
        int b = 1;
        try{
            for(Usuario us: listaUsuario){
                if(us.getUsusario().equals(username)){
                    us.setContraseña(username);
                    b =1;
                    return b;
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return b;
    }
    /**
     * Modifica los datos del usuario en la base de datos
     * @param usuario
     * @return 
     */
    public int modificarUsuarioBD(Usuario usuario){
        int r = 0;
        try{
            modificarUsuario.setString(1, usuario.getContraseña());
            modificarUsuario.setString(2, usuario.getUsusario());
            modificarUsuario.setString(3, usuario.getUsusario());
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), 
                    "Error al modificar", JOptionPane.ERROR_MESSAGE);
        }
        return r;
    }
    
    /**
     * Acualiza la base de datos e informa al usuario si la accion fue realizada
     * con exito y/o si ocurrieron errores
     * @return 
     */
    public String actualizarBD(){
        String msn = "";
        String msnError = "Errores en: ";
        
        int modificado = 0;
        int errorM = 0;
        
        for(Usuario us: listaUsuario){
            if (this.modificarUsuarioBD(us) != 0) modificado++;
            else{
                errorM++;
                msnError += "-Error al modificar Usuario" + us.getUsusario();
            }
        }
        msn = "Usuario modificado con exito";
        if(!msnError.equals("Errores en:")){
            msn += "\n" + msnError;
        }
        return msn;
    }
}