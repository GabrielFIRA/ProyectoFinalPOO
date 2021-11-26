package Modelos;


/**
 * @author DELL
 * @version 1.0
 * @created 17-Nov-2021 8:01:02 PM
 */
public class Trabajador {

	private String apellidos;
	private boolean apropiado;
	private int contNotasDisciplinarias;
	private int estado;
	private String nombres;
	private String numCedula;
	private String numSeguroSocial;

	public Trabajador(){

	}

    public Trabajador(String apellidos, boolean apropiado,
            int contNotasDisciplinarias,
            int estado, String nombres,
            String numCedula, String numSeguroSocial) {
        this.apellidos = apellidos;
        this.apropiado = apropiado;
        this.contNotasDisciplinarias = contNotasDisciplinarias;
        this.estado = estado;
        this.nombres = nombres;
        this.numCedula = numCedula;
        this.numSeguroSocial = numSeguroSocial;
    }

	public void finalize() throws Throwable {

	}

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public boolean isApropiado() {
        return apropiado;
    }

    public void setApropiado(boolean apropiado) {
        this.apropiado = apropiado;
    }

    public int getContNotasDisciplinarias() {
        return contNotasDisciplinarias;
    }

    public void setContNotasDisciplinarias(int contNotasDisciplinarias) {
        this.contNotasDisciplinarias = contNotasDisciplinarias;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNumCedula() {
        return numCedula;
    }

    public void setNumCedula(String numCedula) {
        this.numCedula = numCedula;
    }

    public String getNumSeguroSocial() {
        return numSeguroSocial;
    }

    public void setNumSeguroSocial(String numSeguroSocial) {
        this.numSeguroSocial = numSeguroSocial;
    }
}//end Trabajador