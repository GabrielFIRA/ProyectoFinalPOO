package prisma;
public class Proyectos { 
    //sinceramente esto lo estoy usando como estructura  
    private String m_FechaIngreso;
    private String m_FechaSalida;
    private int m_Calificacion;
    private String m_Comentarios;
    private String m_NombreProyecto;
   
    public void setFechaI(String fechaI) {
        m_FechaIngreso = fechaI;
    }
    public void setFechaS(String fechaS) {
        m_FechaSalida = fechaS;
    }
    public void setCalificacion(int score) {
        m_Calificacion = score;
    }
    public void setComentarios(String coment) {
        m_Comentarios = coment;
    }
    public void setNombreProyecto(String nombreP) {
        m_NombreProyecto = nombreP;
    }
    public String getFechaI(){
        return m_FechaIngreso;
    }
    public String getFechaS(){
        return m_FechaSalida;
    }
    public int getScore(){
        return m_Calificacion;
    }
    public String getCometarios(){
        return m_Comentarios;
    }
    public String getNombreProyecto(){
        return m_NombreProyecto;
    }
    
    
}
