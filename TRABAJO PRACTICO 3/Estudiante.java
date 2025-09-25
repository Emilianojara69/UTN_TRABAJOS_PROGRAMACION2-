//EJERCICIO 1

// public class Estudiante {
//     // Atributos privados
//     private String nombre;
//     private String apellido;
//     private String curso;
//     private double calificacion;

//     // Constructor
//     public Estudiante(String nombre, String apellido, String curso, double calificacion) {
//         this.nombre = nombre;
//         this.apellido = apellido;
//         this.curso = curso;
//         this.calificacion = calificacion;
//     }

//     // Método para mostrar la información del estudiante
//     public void mostrarInfo() {
//         System.out.println("Nombre: " + nombre + " " + apellido);
//         System.out.println("Curso: " + curso);
//         System.out.println("Calificación: " + calificacion);
//     }

//     // Método para subir la calificación
//     public void subirCalificacion(double puntos) {
//         calificacion += puntos;
//         System.out.println("Calificación aumentada a: " + calificacion);
//     }

//     // Método para bajar la calificación
//     public void bajarCalificacion(double puntos) {
//         calificacion -= puntos;
//         System.out.println("Calificación reducida a: " + calificacion);
//     }

//     // Método main para probar la clase
//     public static void main(String[] args) {
//         Estudiante estudiante1 = new Estudiante("Emiliano", "Jara", "Programación II", 7.5);

//         estudiante1.mostrarInfo();
//         estudiante1.subirCalificacion(1.0);
//         estudiante1.bajarCalificacion(0.5);
//         estudiante1.mostrarInfo();
//     }
// }


//EJERCICIO 2

// public class Mascota {
//     // Atributos
//     private String nombre;
//     private String especie;
//     private int edad;

//     // Constructor
//     public Mascota(String nombre, String especie, int edad) {
//         this.nombre = nombre;
//         this.especie = especie;
//         this.edad = edad;
//     }

//     // Método para mostrar la información de la mascota
//     public void mostrarInfo() {
//         System.out.println("Nombre: " + nombre);
//         System.out.println("Especie: " + especie);
//         System.out.println("Edad: " + edad + " años");
//     }

//     // Método para simular el paso del tiempo
//     public void cumplirAnios() {
//         edad++;
//         System.out.println(nombre + " ha cumplido años. Nueva edad: " + edad);
//     }

//     // Método main para probar la clase
//     public static void main(String[] args) {
//         Mascota mascota1 = new Mascota("Luna", "Perro", 3);

//         mascota1.mostrarInfo();
//         mascota1.cumplirAnios();
//         mascota1.mostrarInfo();
//     }
// }


//EJERCICIO 3

// public class Libro {
//     // Atributos privados
//     private String titulo;
//     private String autor;
//     private int añoPublicacion;

//     // Constructor
//     public Libro(String titulo, String autor, int añoPublicacion) {
//         this.titulo = titulo;
//         this.autor = autor;
//         setAñoPublicacion(añoPublicacion); // Usamos el setter para validar
//     }

//     // Getters
//     public String getTitulo() {
//         return titulo;
//     }

//     public String getAutor() {
//         return autor;
//     }

//     public int getAñoPublicacion() {
//         return añoPublicacion;
//     }

//     // Setter con validación
//     public void setAñoPublicacion(int año) {
//         if (año >= 1450 && año <= 2025) {
//             this.añoPublicacion = año;
//         } else {
//             System.out.println("Año inválido. Debe estar entre 1450 y 2025.");
//         }
//     }

//     // Método para mostrar la información del libro
//     public void mostrarInfo() {
//         System.out.println("Título: " + titulo);
//         System.out.println("Autor: " + autor);
//         System.out.println("Año de publicación: " + añoPublicacion);
//     }

//     // Método main para probar la clase
//     public static void main(String[] args) {
//         Libro libro1 = new Libro("El Principito", "Antoine de Saint-Exupéry", 1943);

//         libro1.mostrarInfo();

//         // Intento de modificar el año con un valor inválido
//         libro1.setAñoPublicacion(1300);

//         // Intento de modificar el año con un valor válido
//         libro1.setAñoPublicacion(2000);

//         libro1.mostrarInfo();
//     }
// }


//EJERCICIO 4

// public class NaveEspacial {
//     // Atributos
//     private String nombre;
//     private int combustible;
//     private final int MAX_COMBUSTIBLE = 100;

//     // Constructor
//     public NaveEspacial(String nombre, int combustibleInicial) {
//         this.nombre = nombre;
//         this.combustible = Math.min(combustibleInicial, MAX_COMBUSTIBLE);
//     }

//     // Método para despegar
//     public void despegar() {
//         if (combustible >= 10) {
//             combustible -= 10;
//             System.out.println(nombre + " ha despegado. Combustible restante: " + combustible);
//         } else {
//             System.out.println("No hay suficiente combustible para despegar.");
//         }
//     }

//     // Método para avanzar cierta distancia
//     public void avanzar(int distancia) {
//         int consumo = distancia * 2; // 2 unidades por cada unidad de distancia
//         if (combustible >= consumo) {
//             combustible -= consumo;
//             System.out.println(nombre + " avanzó " + distancia + " unidades. Combustible restante: " + combustible);
//         } else {
//             System.out.println("Combustible insuficiente para avanzar " + distancia + " unidades.");
//         }
//     }

//     // Método para recargar combustible
//     public void recargarCombustible(int cantidad) {
//         if (combustible + cantidad <= MAX_COMBUSTIBLE) {
//             combustible += cantidad;
//             System.out.println("Combustible recargado. Nivel actual: " + combustible);
//         } else {
//             System.out.println("No se puede recargar esa cantidad. Superaría el límite de " + MAX_COMBUSTIBLE);
//         }
//     }

//     // Método para mostrar el estado actual
//     public void mostrarEstado() {
//         System.out.println("Nave: " + nombre + " - Combustible: " + combustible + "/" + MAX_COMBUSTIBLE);
//     }

//     // Método main para probar la clase
//     public static void main(String[] args) {
//         NaveEspacial nave1 = new NaveEspacial("Andrómeda", 50);

//         nave1.mostrarEstado();
//         nave1.avanzar(10); // Intento sin recargar
//         nave1.recargarCombustible(30);
//         nave1.avanzar(10); // Avance exitoso
//         nave1.despegar();
//         nave1.mostrarEstado();
//     }
// }
