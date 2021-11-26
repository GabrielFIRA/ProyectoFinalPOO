package Modelos;


/**
 * @author DELL
 * @version 1.0
 * @created 17-Nov-2021 5:29:47 PM
 */
public class Desempeño {

	private double calificacion;
	private int estado;
	private String fechaIngreso;
	private String fechaSalida;
	private int idDesempeño;
	private int idProyecto;
	private String[] notasDisciplinarias = {"", "", ""};
	private String numCedula;
	private int periodoContratado;
	private String puesto;
	private String razonSalida;
	private double salario;

	public Desempeño(){

	}

    public Desempeño(double calificacion, int estado, String fechaIngreso, 
            String fechaSalida, int idDesempeño, int idProyecto, 
            String[] notasDisciplinarias,
            String numCedula, int periodoContratado, String puesto, 
            String razonSalida, double salario) {

        this.calificacion = calificacion;
        this.estado = estado;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.idDesempeño = idDesempeño;
        this.idProyecto = idProyecto;
        this.numCedula = numCedula;
        this.periodoContratado = periodoContratado;
        this.puesto = puesto;
        this.razonSalida = razonSalida;
        this.salario = salario;
        this.notasDisciplinarias = notasDisciplinarias;
        
    }
    public Desempeño(double calificacion, int estado, String fechaIngreso, 
            String fechaSalida, int idDesempeño, int idProyecto, 
            String numCedula, int periodoContratado, String puesto, 
            String razonSalida, double salario){
        
        this.calificacion = calificacion;
        this.estado = estado;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.idDesempeño = idDesempeño;
        this.idProyecto = idProyecto;
        this.numCedula = numCedula;
        this.periodoContratado = periodoContratado;
        this.puesto = puesto;
        this.razonSalida = razonSalida;
        this.salario = salario;
        
    }

	public void finalize() throws Throwable {

	}

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getIdDesempeño() {
        return idDesempeño;
    }

    public void setIdDesempeño(int idDesempeño) {
        this.idDesempeño = idDesempeño;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String[] getNotasDisciplinarias() {
        return notasDisciplinarias;
    }

    public void agregarNotaDisciplinaria(String notaDisciplinaria){
        for(int i=0; i<3; i++){
            if(notasDisciplinarias[i].equals("")){
                this.notasDisciplinarias[i] = notaDisciplinaria;
                return;
            }
        }
    }
    
    public void modificarNotasDisciplinarias(String notasDisciplonarias, 
            int indice){
        this.notasDisciplinarias[indice] = notasDisciplonarias;
    }
    
    public void eliminarNotasDisciplinarias(int indice){
        this.notasDisciplinarias[indice] = "";
    }

    public String getNumCedula() {
        return numCedula;
    }

    public void setNumCedula(String numCedula) {
        this.numCedula = numCedula;
    }

    public int getPeriodoContratado() {
        return periodoContratado;
    }

    public void setPeriodoContratado(int periodoContratado) {
        this.periodoContratado = periodoContratado;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getRazonSalida() {
        return razonSalida;
    }

    public void setRazonSalida(String razonSalida) {
        this.razonSalida = razonSalida;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}//end Desempe�o