package S4;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
public class Persona {
    private String nombre;
    private LocalDate fechaNacimiento;
    public Persona(String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
    
    public int getEdad(){
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
    @Override
    public int hashCode() {
        return Objects.hash(nombre,fechaNacimiento);
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Persona) {
            Persona otro= (Persona)obj;
            return Objects.equals(this.fechaNacimiento, otro.fechaNacimiento);
        }
        else return false;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
