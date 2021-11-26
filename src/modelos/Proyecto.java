package Modelos;


/**
 * @author DELL
 * @version 1.0
 * @created 16-Nov-2021 12:56:56 PM
 */
public class Proyecto {

	private int estado;
	private int idProyecto;
	private String nombreProyecto;

    public Proyecto(int estado, int idProyecto, String nombreProyecto) {
        this.estado = estado;
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
    }

	public Proyecto(){

	}

	public void finalize() throws Throwable {
	}

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }
}//end Proyecto