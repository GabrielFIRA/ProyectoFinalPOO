package prisma;
public class Trabajadores {
    private boolean m_ListaNegra;
    private int ID;
    private String m_NombreTrabajador;
    private Proyectos[] m_Proyectos = new Proyectos[1];
    
    public void setNewProyect(String fechaI,String fechaS, int score,String coment,String nombreP){
        Proyectos obj = new Proyectos();
        obj.setCalificacion(score);
        obj.setComentarios(coment);
        obj.setFechaI(fechaI);
        obj.setFechaS(fechaS);
        obj.setNombreProyecto(nombreP);
        m_Proyectos[0]=obj;
        if(obj.getScore()<=5){
            m_ListaNegra=true;
        }
    }
    public Proyectos getProyecto(int x){
        return m_Proyectos[x];
    }
    
}
