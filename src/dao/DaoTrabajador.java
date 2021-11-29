package dao;

import Modelos.Trabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 * @author DELL
 * @version 1.0
 * @created 17-Nov-2021 7:59:55 PM
 */
public class DaoTrabajador {

    private final Conexion conexion = new Conexion();
    private Connection conn;
    private PreparedStatement eliminarTrabajador;
    private PreparedStatement insertarTrabajador;
    private PreparedStatement modificarTrabajador;
    private PreparedStatement mostrarTrabajador;
    private ArrayList<Trabajador> listaTrabajador = new ArrayList();

    public void finalize() throws Throwable {

    }
    public DaoTrabajador(){
        try{

        conn = conexion.obtenerConexion();
        insertarTrabajador = conn.prepareStatement("Insert into Trabajador"
                + "(apellidos, apropiado, contNotasDisciplinarias"
                + ", nombres, numCedula, numSeguroSocial)"
                + " Values(?, ?, ?, ?, ?, ?)");
        mostrarTrabajador = conn.prepareStatement("Select * from "
                + "Trabajador");
        modificarTrabajador = conn.prepareStatement("Update Trabajador set "
                + "apellidos = ?, apropiado = ?, contNotasDisciplinarias = ?,"
                + "nombres = ?, numSeguroSocial = ?"
                + " where numCedula = ?");
        eliminarTrabajador = conn.prepareStatement("Delete Trabajador where"
                + " numCedula = ?");
        listaTrabajador = new ArrayList<>();
        listaTrabajador = this.listarTrabajadores();

        }
        catch(SQLException ex){
            ex.printStackTrace();
            conexion.close(conn);
        }
    }
    /**
     * 
     * @param nombres
     * @param apellidos
     * @param numCedula
     * @param numSeguroSocial
     * @return 
     */
    public int agregarTrabajador(String nombres, String apellidos, 
            String numCedula, String numSeguroSocial){
        int b = 0;
        try{
            listaTrabajador.add(new Trabajador( 
                    apellidos, 
                    true, 
                    0, 
                    4,
                    nombres, 
                    numCedula, 
                    numSeguroSocial
            ));
            b =1;
            return b;
        }catch(Exception ex){
            ex.printStackTrace();
        }
            return b;
    }

    public String actualizarBD(){
        String msn = "";
        String msnError = "Errores en: ";
        int nuevo = 0, modificado = 0, eliminados = 0;
        int errorN = 0, errorM =0, errorE = 0;
        for(Trabajador tra: listaTrabajador){
            switch(tra.getEstado()){
                case 1:
                    break;
                case 2:
                    if(this.modificarTrabajadorBD(tra) != 0) modificado++;
                    else{
                        errorE++;
                        msnError += "-Error al modificar registro" + 
                                tra.getNombres() + tra.getApellidos() +"\n";
                    }
                    break;
                case 3:
                    if(this.eliminarTrabajadorBD(tra) != 0) eliminados++;
                    else{
                        errorE++;
                        msnError += "-Error al eliminar registro" +
                                tra.getNombres() + tra.getApellidos() +"\n";
                    }
                    break;
                case 4:
                    if(this.agregarTrabajadorBD(tra) != 0) nuevo++;
                    else{
                        errorN++;
                        msnError += "-Error al eliminar registro" + 
                                tra.getNombres() + tra.getApellidos() +"\n";
                    }
                    break;
                default:
                    msnError += "Revise el registro: " + tra.getNombres() +
                            tra.getApellidos() + "\n";
                    break;
            }
        }
        msn = "Registros guardados " + nuevo + "\n" + 
                "Registros modificados " + modificado + "\n"
                + "Registros eliminados" + eliminados + "\n";
        if(!msnError.equals("Errores en: ")){
            msn += "\n" + msnError;
        }

        return msn;
    }

    /**
     * 
     * @param trabajador
     */
    public int agregarTrabajadorBD(Trabajador trabajador){
        int r = 0;
        try{
            insertarTrabajador.setString(1, trabajador.getApellidos());
            insertarTrabajador.setBoolean(2, true);
            insertarTrabajador.setInt(3, 
                    trabajador.getContNotasDisciplinarias());
            insertarTrabajador.setString(4, trabajador.getNombres());
            insertarTrabajador.setString(5, trabajador.getNumCedula());
            insertarTrabajador.setString(6, 
                    trabajador.getNumSeguroSocial());
            r = insertarTrabajador.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Error al guardar en BD",
                    JOptionPane.ERROR_MESSAGE);
            conexion.close(conn);
        }


            return r;
    }

    /**
     * 
     * @param trabajador
     * @return int
     */
    public int eliminarTrabajadorBD(Trabajador trabajador){
        int r = 0;
        try{
            eliminarTrabajador.setString(1, trabajador.getNumCedula());
            r = eliminarTrabajador.executeUpdate();
            return r;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Error al eliminar en BD", JOptionPane.ERROR_MESSAGE);
            conexion.close(conn);
        }
            return r;
    }

    /**
     * 
     * @param trabajador
     * @return 
     */
    public int modificarTrabajadorBD(Trabajador trabajador){
        int r = 0;
        try{
            modificarTrabajador.setString(1, trabajador.getApellidos());
            modificarTrabajador.setBoolean(2, trabajador.isApropiado());
            modificarTrabajador.setInt(3,
                    trabajador.getContNotasDisciplinarias());
            modificarTrabajador.setString(4, trabajador.getNombres());
            modificarTrabajador.setString(5, trabajador.getNumSeguroSocial());
            modificarTrabajador.setString(6, 
                    trabajador.getNumCedula());
            r = modificarTrabajador.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Error al modificar BD", JOptionPane.ERROR_MESSAGE);
            conexion.close(conn);
        }

            return r;
    }

    /**
     * 
     * @param numCedula
 * @return 
     */
    public Trabajador buscarTrabajador(String numCedula){
        try{
            for(Trabajador tra: listaTrabajador){
                if(tra.getNumCedula().equals(numCedula)){
                    return tra;
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
            return null;
    }

    /**
     * 
     * @param numCedula
     */
    public int eliminarTrabajador(String numCedula){
        int b = 0;
        try{
            for(Trabajador tra: listaTrabajador){
                if(tra.getNumCedula().equals(numCedula)){
                    tra.setEstado(3);
                    b = 1;
                    return b;
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
            return b;
    }

    public ArrayList<Trabajador> getListaTrabajador(){

            return listaTrabajador;
    }

    private ArrayList<Trabajador> listarTrabajadores(){
        ArrayList<Trabajador> listado = null;
        ResultSet rs = null;
        try{
            rs = mostrarTrabajador.executeQuery();
            listado = new ArrayList<>();
            while(rs.next()){
                listado.add(new Trabajador( 
                rs.getString("apellidos"),
                rs.getBoolean("apropiado"),
                rs.getInt("contNotasDisciplinarias"),
                1,
                rs.getString("nombres"),
                rs.getString("numCedula"),
                rs.getString("numSeguroSocial")
                ));

            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        finally{
            try{
             rs.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
            return listado;
    }

    /**
     * 
     * @param nombres
     * @param apellidos
     * @param numCedula
     * @param numSeguroSocial
 * @return 
     */
    public int modificarTrabajador(String nombres, String apellidos,
            String numCedula, String numSeguroSocial){
        int b = 0;
        try{
            for(Trabajador tra: listaTrabajador){
                if(tra.getNumCedula().equals(numCedula)){
                    b = 1;
                    tra.setApellidos(apellidos);
                    tra.setNombres(nombres);
                    tra.setNumSeguroSocial(numSeguroSocial);
                    tra.setEstado(2);
                    return b;
                }

            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

            return b;
    }
    public int aumentarConteo(String numCedula){
        int b = 0;
        try{
            for(Trabajador t: listaTrabajador){
                if(t.getNumCedula().equals(numCedula)){
                    int temp = t.getContNotasDisciplinarias();
                    temp ++;
                    t.setContNotasDisciplinarias(temp);
                    b = 1;
                    return b;
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return b;
    }
}//end DaoTrabajador