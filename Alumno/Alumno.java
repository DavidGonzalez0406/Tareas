package Alumno;

class Alumno {
    private String nombre;
    private String carrera;
    private String matricula;
    private String grado;
    private String grupo;
    private Tutor tutor;

    public Alumno() {
        // Constructor vacío
    }

    public Alumno(String nombre, String carrera, String matricula, String grado, String grupo, Tutor tutor) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.matricula = matricula;
        this.grado = grado;
        this.grupo = grupo;
        this.tutor = tutor;
    }

    public Tutor getTutor() {
        return tutor;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Carrera: " + carrera + ", Matrícula: " + matricula + ", Grado: " + grado + ", Grupo: " + grupo + "\n" + tutor.toString();
    }
public static void main(String[] args) {
        Telefono telefonoTutor = new Telefono("+52", "981", "104-4687");
        Tutor tutor = new Tutor("Diana", 43, telefonoTutor);
        Alumno pepito = new Alumno("David", "ISC", "64862", "3ro", "B", tutor);

        System.out.println(pepito.toString());
    }
}
