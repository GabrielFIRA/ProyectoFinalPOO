package dao;

import Modelos.Proyecto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 * @author DELL
 * @version 1.0
 * @created 16-Nov-2021 1:08:27 PM
 */
public class DaoProyecto {

	private final Conexion conexion = new Conexion();
	private Connection conn;
	private PreparedStatement eliminarProyecto;
	private PreparedStatement insertarProyecto;
	private PreparedStatement modificarProyecto;
	private PreparedStatement mostrarProyecto;
        private ArrayList<Proyecto> listaProyecto = new ArrayList();



       
	public void finalize() throws Throwable {

	}
	public DaoProyecto(){
            try{
                conn = conexion.obtenerConexion();
                mostrarProyecto = conn.prepareStatement("Select * from "
                        + "Proyecto");
                insertarProyecto = conn.prepareStatement("Insert into Proyecto"
                        + "(idProyecto, nombreProyecto)" +
                        "Values(?, ?)");
                modificarProyecto = conn.prepareStatement("Update Proyecto set"
                        + " nombreProyecto = ?"
                        + " where idProyecto = ?");
                eliminarProyecto = conn.prepareStatement("Delete Proyecto where"
                        + " idProyecto = ?");
                listaProyecto = new ArrayList<>();
                listaProyecto = this.listarProyecto();
           
            }catch(SQLException ex){
                ex.printStackTrace();
                conexion.close(conn);
            } 

	}

	public String actualizarBD(){
            String msn ="";
            String msnError = "Errores en:";
            int nuevo = 0, modificado = 0, eliminados = 0;
            int errorN = 0, errorM = 0, errorE = 0;
            
            for(Proyecto pro: listaProyecto){
                switch(pro.getEstado()){
                    case 1:
                        break;
                    case 2:
                        if(this.modificarProyectoBD(pro) != 0) modificado++;
                        else{
                            errorM++;
                            msnError += "-Error al modificar registro " +
                                    pro.getNombreProyecto() + "\n";
                        }
                        break;
                    case 3:
                        if(this.eliminarProyectoBD(pro) != 0) eliminados++;
                        else{
                            errorE++;
                            msnError += "-Error al eliminar registro " +
                                    pro.getNombreProyecto() + "\n";
                        }
                        break;
                    case 4:
                        if(this.agregarProyectoBD(pro) != 0) nuevo++;
                        else{
                            errorN++;
                            msnError += "-Error al agregar proyecto " +
                                    pro.getNombreProyecto() + "\n";
                        }
                        break;
                    default:
                        msnError += "Revise el registro " +
                                pro.getNombreProyecto();
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
     * @param idProyecto
	 * @param nombreProyecto
     * @return 
	 */
	public int agregarProyecto(int idProyecto, String nombreProyecto){
            int b = 0;
            try{
                listaProyecto.add(new Proyecto(4, 
                        idProyecto, 
                        nombreProyecto
                ));
                b = 1;
                return b;
            }catch(Exception ex){
                ex.printStackTrace();
            }
		return b;
	}

	/**
	 * 
     * @param proyecto
     * @return 
	 */
	public int agregarProyectoBD(Proyecto proyecto){
            int r = 0;
            try{
                
                insertarProyecto.setInt(1, proyecto.getIdProyecto());
                insertarProyecto.setString(2, proyecto.getNombreProyecto());
                System.out.println(proyecto.getIdProyecto());
                System.out.println(proyecto.getNombreProyecto());
                System.out.println(proyecto.getEstado());
                r = insertarProyecto.executeUpdate();
                
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(),
                        "Error al agregar registro", JOptionPane.ERROR_MESSAGE);
                conexion.close(conn);
            }
		return r;
	}

	/**
	 * 
	 * @param idProyecto
     * @return 
	 */
	public Proyecto buscarProyecto(int idProyecto){
            try{
                for(Proyecto pro: listaProyecto){
                    if(pro.getIdProyecto()== idProyecto){
                        return pro;
                    }
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
		return null;
	}

	/**
	 * 
	 * @param idProyecto
     * @return 
	 */
	public int eliminarProyecto(int idProyecto){
            int b = 0;
            try{
                for(Proyecto pro: listaProyecto){
                    if(pro.getIdProyecto()== idProyecto){
                        pro.setEstado(3);
                        b = 1;
                        return b;
                    }
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
		return b;
	}

	/**
	 * 
     * @param proyecto
     * @return 
	 */
	public int eliminarProyectoBD(Proyecto proyecto){
            int r = 0;
            try{
                eliminarProyecto.setInt(1, proyecto.getIdProyecto());
                r = eliminarProyecto.executeUpdate();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), 
                        "Error al eliminar registro", JOptionPane.ERROR_MESSAGE)
                        ;
                conexion.close(conn);
            }
		return r;
	}

	public ArrayList<Proyecto> getListaProyecto(){
            
		return listaProyecto;
	}

	private ArrayList<Proyecto> listarProyecto(){
            ArrayList<Proyecto> listado = null;
            ResultSet rs = null;
            try{
                rs = mostrarProyecto.executeQuery();
                listado = new ArrayList<>();
                while(rs.next()){
                    listado.add(new Proyecto(1,
                            rs.getInt("idProyecto"),
                            rs.getString("nombreProyecto")
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
	 * 
	 * @param idProyecto
	 * @param nombreProyecto
     * @return 
	 */
	public int modificarProyecto(int idProyecto, String nombreProyecto){
            int b = 0;
            try{
                for(Proyecto pro: listaProyecto){
                    if(pro.getIdProyecto()==idProyecto){
                        pro.setNombreProyecto(nombreProyecto);
                        pro.setEstado(2);
                        b = 1;
                        return b;
                    }
                   
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
		return b;
	}

	/**
     * @param proyecto
     * @pn b;
	}

	/**
     * @return 
	 */
	public int modificarProyectoBD(Proyecto proyecto){
            int r = 0;
            try{
                modificarProyecto.setInt(2, proyecto.getIdProyecto());
                modificarProyecto.setString(1, proyecto.getNombreProyecto());
                r = modificarProyecto.executeUpdate();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), 
                        "Error al modificar", JOptionPane.ERROR_MESSAGE);
            }
		return r;
	}
}//end daoProyecto