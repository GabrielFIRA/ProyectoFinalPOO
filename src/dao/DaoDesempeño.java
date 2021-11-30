package dao;

import Modelos.Desempeño;
import Modelos.Proyecto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


/**
 * @author DELL
 * @version 1.0
 * @created 17-Nov-2021 5:38:05 PM
 */
public class DaoDesempeño {


    private final Conexion conexion = new Conexion();
    private Connection conn;
    private PreparedStatement eliminarDesempeño;
    private PreparedStatement insertarDesempeño;
    private PreparedStatement modificarDesempeño;
    private PreparedStatement mostrarDesempeño;
    ArrayList<Desempeño> listaDesempeño = new ArrayList<>();



    public void finalize() throws Throwable {

    }
    public DaoDesempeño(){
        try{
            conn = conexion.obtenerConexion();
            mostrarDesempeño = conn.prepareStatement("Select * from Desempeño");
            insertarDesempeño = conn.prepareStatement("Insert into Desempeño"
                    + "( calificacion,"
                    + " idDesempeño, idProyecto, notaDisciplinaria1,"
                    + " notaDisciplinaria2, notaDisciplinaria3, numCedula, "
                    + " puesto, razonSalida, salario,"
                    + "fechaIngreso, fechaSalida)"
                    + "Values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            modificarDesempeño = conn.prepareStatement("Update Desempeño set"
                    + " calificacion = ?,"
                    + " idProyecto = ?, notaDisciplinaria1 = ?,"
                    + " notaDisciplinaria2 = ?, notaDisciplinaria3 = ?, "
                    + "numCedula = ?, puesto = ?, "
                    + "razonSalida = ?, salario = ?, fechaIngreso = ?,"
                    + " fechaSalida = ? where idDesempeño = ?");
            eliminarDesempeño = conn.prepareStatement("Delete Desempeño "
                    + "where idDesempeño = ?");

            listaDesempeño = new ArrayList<>();
            listaDesempeño = this.listarDesempeño();
        }catch(SQLException ex){
            ex.printStackTrace();
            conexion.close(conn);
        }
    }

    /**
     * 
     * @param calificacion    puede ser nulo
     * @param fechaIngreso
     * @param fechaSalida    puede ser nulo
     * @param idDesempeño
     * @param puesto
     * @param razonSalida    puede ser nulo
     * @param salario
     * @param idProyecto
     * @param numCedula
     * @return int
     */
    public int agregarDesempeño(double calificacion, 
            String fechaIngreso, String fechaSalida, int idDesempeño,
            String puesto, String razonSalida, double salario,
            int idProyecto, String numCedula){
        int b = 0;
        try{
            listaDesempeño.add(new Desempeño(
                    calificacion,
                    4, 
                    fechaIngreso, 
                    fechaSalida, 
                    idDesempeño, 
                    idProyecto,
                    numCedula, 
                    puesto, 
                    razonSalida,
                    salario
            ));
            b = 1;
            return b;
        }catch(Exception ex){
            ex.printStackTrace();
        }
            return b;
    }

    public String actualizarBD(){
        String msn ="";
        String msnError = "Errores en:";
        int nuevo = 0, modificado = 0, eliminados = 0;
        int errorN = 0, errorM = 0, errorE = 0;

        for(Desempeño des: listaDesempeño){
            switch(des.getEstado()){
                case 1:
                    break;
                case 2:
                    if(this.modificarDesempeñoBD(des) != 0) modificado++;
                    else{
                        errorM++;
                        msnError += "-Error al modificar registro " +
                                des.getIdDesempeño() + "\n";
                    }
                    break;
                case 3:
                    if(this.eliminarDesempeñoBD(des) != 0) eliminados++;
                    else{
                        errorE++;
                        msnError += "-Error al eliminar registro " +
                                des.getIdDesempeño() + "\n";
                    }
                    break;
                case 4:
                    if(this.agregarDesempeñoBD(des) != 0) nuevo++;
                    else{
                        errorN++;
                        msnError += "-Error al agregar proyecto " +
                                des.getIdDesempeño() + "\n";
                    }
                    break;
                default:
                    msnError += "Revise el registro " +
                            des.getIdDesempeño();
                    break;
            }
        }
        msn = "Registros Guardados " + nuevo + "\n" +
            "Registros Modificados " + modificado + "\n" +
            "Registros Eliminados " + eliminados + "\n";
        if(!msnError.equals("Errores en:")){
            msn += "\n" + msnError;
        }
        return msn;
    }

    /**
     * 
     * @param des
     * @return 
     */
    public int agregarDesempeñoBD(Desempeño des){
        int r = 0;

        try{
            String [] temp = des.getNotasDisciplinarias();
            insertarDesempeño.setDouble(1, des.getCalificacion());
            insertarDesempeño.setInt(2, des.getIdDesempeño());
            insertarDesempeño.setInt(3, des.getIdProyecto());
            insertarDesempeño.setString(4, temp[0]);
            insertarDesempeño.setString(5, temp[1]);
            insertarDesempeño.setString(6, temp[2]);
            insertarDesempeño.setString(7, des.getNumCedula());
            insertarDesempeño.setString(9, des.getPuesto());
            insertarDesempeño.setString(10, des.getRazonSalida());
            insertarDesempeño.setDouble(11, des.getSalario());
            insertarDesempeño.setString(12, des.getFechaIngreso());
            insertarDesempeño.setString(13, des.getFechaSalida());



            r = insertarDesempeño.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Error al agregar en BD", JOptionPane.ERROR_MESSAGE);
            conexion.close(conn);
        }
            return r;
    }

    /**
     * 
     * @param des
     * @return 
     */
    public int eliminarDesempeñoBD(Desempeño des){
        int r = 0;
        try{
            eliminarDesempeño.setInt(1, des.getIdDesempeño());
            r = eliminarDesempeño.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), 
                    "Error al eliminar registro", JOptionPane.ERROR_MESSAGE)
                    ;
            conexion.close(conn);
        }
            return r;
    }

    /**
     * 
     * @param des
     * @return 
     */
    public int modificarDesempeñoBD(Desempeño des){
        int r = 0;
        try{
            String[] temp = des.getNotasDisciplinarias();
            modificarDesempeño.setDouble(1, des.getCalificacion());                
            modificarDesempeño.setInt(2, des.getIdProyecto());
            modificarDesempeño.setString(3, temp[0]);
            modificarDesempeño.setString(4, temp[1]);
            modificarDesempeño.setString(5, temp[2]);
            modificarDesempeño.setString(6, des.getNumCedula());
            modificarDesempeño.setString(8, des.getPuesto());
            modificarDesempeño.setString(9, des.getRazonSalida());
            modificarDesempeño.setDouble(10, des.getSalario());
            modificarDesempeño.setString(11, des.getFechaIngreso());
            modificarDesempeño.setString(12, des.getFechaSalida());
            modificarDesempeño.setInt(13, des.getIdDesempeño());

            r = modificarDesempeño.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), 
                    "Error al modificar", JOptionPane.ERROR_MESSAGE);
            conexion.close(conn);
        }
            return r;
    }

    /**
     * 
     * @param numCedula
     * @param idProyecto
     * @return 
     */
    public Desempeño buscarDesempeño(String numCedula, int idProyecto){
        try{
            for(Desempeño des: listaDesempeño){
                if(des.getNumCedula().equals(numCedula)
                        && des.getIdProyecto() == idProyecto){
                    return des;
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
            return null;
    }
    /**
     * Busca el desempeño pero por el id de desempeño
     * @param IdDesempeño
     * @return Desempeño
     */
    public Desempeño buscarDesempeño(int IdDesempeño){
        try{
            for(Desempeño des: listaDesempeño){
                if(des.getIdDesempeño() == IdDesempeño){
                    return des;
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
            return null;
    }

    /**
     * 
     * @param idDesempeño
     * @return 
     */
    public int eliminarDesempeño(int idDesempeño){
        int b = 0;
        try{
            for(Desempeño des: listaDesempeño){
                if(des.getIdDesempeño() == idDesempeño){
                    des.setEstado(3);
                    b = 1;
                    return b;
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
            return b;
    }

    public ArrayList<Desempeño> getListaDesempeño(){
            return listaDesempeño;
    }

    private ArrayList<Desempeño> listarDesempeño(){
        ArrayList<Desempeño> listado = new ArrayList();
        ResultSet rs = null;
        try{
            String[] temp = new String[3];
            rs = mostrarDesempeño.executeQuery();
            listado = new ArrayList<>();
            while(rs.next()){
                temp[0] = rs.getString("notaDisciplinaria1");
                temp[1] = rs.getString("notaDisciplinaria2");
                temp[2] = rs.getString("notadisciplinaria3");
                listado.add(new Desempeño(rs.getDouble("calificacion"),
                        1, 
                        rs.getString("fechaIngreso"), 
                        rs.getString("fechaSalida"), 
                        rs.getInt("idDesempeño"), 
                        rs.getInt("idProyecto"),
                        temp,
                        rs.getString("numCedula"), 
                        rs.getString("puesto"), 
                        rs.getString("razonSalida"), 
                        rs.getDouble("Salario")
                ));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                rs.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
            return listado;
    }

    /**
     * 
     * @param idDesempeño
     * @param idProyecto
     * @param numCedula
     * @param fechaIngreso
     * @param fechaSalida
     * @param calificacion
     * @param notasDisciplinarias
     * @param indexNotasDisiplinarias
     * @param razonSalida
     * @param salario
     * @return int
     */
    public int modificarDesempeño(int idDesempeño, int idProyecto, 
            String numCedula, String fechaIngreso, String fechaSalida,
            double calificacion,
            String razonSalida, double salario){
        int b =0;
        try{
            for(Desempeño des: listaDesempeño){
                if(des.getIdDesempeño() == idDesempeño){
                    des.setIdProyecto(idProyecto);
                    des.setNumCedula(numCedula);
                    des.setFechaIngreso(fechaIngreso);
                    des.setFechaSalida(fechaSalida);
                    des.setCalificacion(calificacion);
                    des.setRazonSalida(razonSalida);
                    des.setSalario(salario);
                    des.setEstado(2);
                    b = 1;
                    return b;
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return b;

    }

    public int agregarNotaDisciplinaria(int idDesempeño, String nota){
        int b = 0;
        try{
            for(Desempeño d: listaDesempeño){
                if(d.getIdDesempeño()== idDesempeño){
                    d.agregarNotaDisciplinaria(nota);
                    d.setEstado(2);
                    b = 1;
                    return b;

                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return b;
    }

    public int modificarNotasDisciplinarias(int idDesempeño, 
            String notasDisciplinarias, 
            int indice){

        int b = 1;
        try{
        for(Desempeño d: listaDesempeño){
            if(d.getIdDesempeño()== idDesempeño){
                    d.modificarNotasDisciplinarias(notasDisciplinarias, 
                            indice);
                    d.setEstado(2);
                    b = 1;
                    return b;

            }
        }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return b;
    }

    public int eliminarNotasDisciplinarias(int idDesempeño, 
            int indice){
        int b = 1;
        try{
            for(Desempeño d: listaDesempeño){
                if(d.getIdDesempeño() == idDesempeño){
                    d.eliminarNotasDisciplinarias(indice);
                    d.setEstado(2);
                    b = 1;
                    return b;
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return b;
    }
    
    
}//end daoDesempe�o