// CODIGO DE TODOS LOS EJERCICIOS:


//EJERCICIO 1

// import java.time.LocalDate;
// import java.util.Arrays;
// import java.util.Objects;

// public class Pasaporte {
//     private final String numero;
//     private final LocalDate fechaEmision;
//     private final Foto foto;            // composición: creado y poseído por Pasaporte
//     private final Titular titular;      // asociación bidireccional

//     /**
//      * Crea un Pasaporte con su Foto (composición) y enlaza bidireccionalmente al Titular.
//      * La Foto se crea acá para garantizar la composición (vida dependiente del Pasaporte).
//      */
//     public Pasaporte(String numero, LocalDate fechaEmision,
//                      Titular titular,
//                      byte[] imagenFoto, String formatoFoto) {
//         this.numero = Objects.requireNonNull(numero, "numero no puede ser null");
//         this.fechaEmision = Objects.requireNonNull(fechaEmision, "fechaEmision no puede ser null");
//         this.titular = Objects.requireNonNull(titular, "titular no puede ser null");

//         // Composición: Pasaporte construye su Foto
//         this.foto = new Foto(Objects.requireNonNull(imagenFoto, "imagenFoto no puede ser null"),
//                              Objects.requireNonNull(formatoFoto, "formatoFoto no puede ser null"));

//         // Asociación bidireccional: Titular ↔ Pasaporte
//         titular.setPasaporte(this);
//     }

//     public String getNumero() {
//         return numero;
//     }

//     public LocalDate getFechaEmision() {
//         return fechaEmision;
//     }

//     public Foto getFoto() {
//         return foto;
//     }

//     public Titular getTitular() {
//         return titular;
//     }

//     @Override
//     public String toString() {
//         return "Pasaporte{" +
//                 "numero='" + numero + '\'' +
//                 ", fechaEmision=" + fechaEmision +
//                 ", titular=" + titular.getNombre() + " (dni=" + titular.getDni() + ")" +
//                 ", foto.formato=" + foto.getFormato() +
//                 ", foto.bytes=" + foto.getImagen().length +
//                 '}';
//     }
// }

// class Foto {
//     private final byte[] imagen;
//     private final String formato;

//     public Foto(byte[] imagen, String formato) {
//         // defensivo: copiar array para inmutabilidad superficial
//         this.imagen = Arrays.copyOf(Objects.requireNonNull(imagen, "imagen no puede ser null"),
//                                     imagen.length);
//         this.formato = Objects.requireNonNull(formato, "formato no puede ser null");
//     }

//     public byte[] getImagen() {
//         return Arrays.copyOf(imagen, imagen.length);
//     }

//     public String getFormato() {
//         return formato;
//     }
// }

// class Titular {
//     private final String nombre;
//     private final String dni;
//     // referencia inversa para asociación bidireccional 1 a 1
//     private Pasaporte pasaporte;

//     public Titular(String nombre, String dni) {
//         this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
//         this.dni = Objects.requireNonNull(dni, "dni no puede ser null");
//     }

//     public String getNombre() {
//         return nombre;
//     }

//     public String getDni() {
//         return dni;
//     }

//     public Pasaporte getPasaporte() {
//         return pasaporte;
//     }

//     /**
//      * Solo debería ser llamado desde el constructor de Pasaporte
//      * o un flujo controlado que mantenga la invariante 1 a 1.
//      */
//     public void setPasaporte(Pasaporte pasaporte) {
//         if (this.pasaporte != null && this.pasaporte != pasaporte) {
//             throw new IllegalStateException("El titular ya tiene un pasaporte asociado.");
//         }
//         this.pasaporte = pasaporte;
//     }

//     @Override
//     public String toString() {
//         return "Titular{" +
//                 "nombre='" + nombre + '\'' +
//                 ", dni='" + dni + '\'' +
//                 '}';
//     }
// }



//EJERCICIO 2:


// import java.util.Objects;

// public class Celular {
//     private final String imei;
//     private final String marca;
//     private final String modelo;

//     // Agregación: el celular "tiene" una batería, pero esta puede existir independiente y cambiarse
//     private Bateria bateria;

//     // Asociación bidireccional con Usuario
//     private final Usuario usuario;

//     public Celular(String imei, String marca, String modelo,
//                    Bateria bateria, Usuario usuario) {
//         this.imei = Objects.requireNonNull(imei, "imei no puede ser null");
//         this.marca = Objects.requireNonNull(marca, "marca no puede ser null");
//         this.modelo = Objects.requireNonNull(modelo, "modelo no puede ser null");
//         this.bateria = Objects.requireNonNull(bateria, "bateria no puede ser null");
//         this.usuario = Objects.requireNonNull(usuario, "usuario no puede ser null");

//         // Bidireccionalidad: el usuario queda enlazado a este celular
//         usuario.setCelular(this);
//     }

//     public String getImei() { return imei; }
//     public String getMarca() { return marca; }
//     public String getModelo() { return modelo; }

//     public Bateria getBateria() { return bateria; }
//     public void setBateria(Bateria bateria) {
//         this.bateria = Objects.requireNonNull(bateria, "bateria no puede ser null");
//     }

//     public Usuario getUsuario() { return usuario; }

//     @Override
//     public String toString() {
//         return "Celular{" +
//                 "imei='" + imei + '\'' +
//                 ", marca='" + marca + '\'' +
//                 ", modelo='" + modelo + '\'' +
//                 ", bateria=" + bateria +
//                 ", usuario=" + usuario +
//                 '}';
//     }
// }

// class Bateria {
//     private final String modelo;
//     private final int capacidad; // mAh

//     public Bateria(String modelo, int capacidad) {
//         this.modelo = Objects.requireNonNull(modelo, "modelo no puede ser null");
//         if (capacidad <= 0) throw new IllegalArgumentException("capacidad debe ser positiva");
//         this.capacidad = capacidad;
//     }

//     public String getModelo() { return modelo; }
//     public int getCapacidad() { return capacidad; }

//     @Override
//     public String toString() {
//         return "Bateria{" +
//                 "modelo='" + modelo + '\'' +
//                 ", capacidad=" + capacidad + "mAh" +
//                 '}';
//     }
// }

// class Usuario {
//     private final String nombre;
//     private final String dni;
//     // referencia inversa para la asociación bidireccional 1 a 1
//     private Celular celular;

//     public Usuario(String nombre, String dni) {
//         this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
//         this.dni = Objects.requireNonNull(dni, "dni no puede ser null");
//     }

//     public String getNombre() { return nombre; }
//     public String getDni() { return dni; }

//     public Celular getCelular() { return celular; }

//     public void setCelular(Celular celular) {
//         if (this.celular != null && this.celular != celular) {
//             throw new IllegalStateException("El usuario ya tiene un celular asociado.");
//         }
//         this.celular = Objects.requireNonNull(celular, "celular no puede ser null");
//     }

//     @Override
//     public String toString() {
//         return "Usuario{" +
//                 "nombre='" + nombre + '\'' +
//                 ", dni='" + dni + '\'' +
//                 '}';
//     }
// }


//ejercicio 3

// import java.util.Objects;

// public class Libro {
//     private final String titulo;
//     private final String isbn;

//     // Asociación unidireccional: Libro -> Autor
//     private final Autor autor;

//     // Agregación: Libro -> Editorial (puede cambiarse)
//     private Editorial editorial;

//     public Libro(String titulo, String isbn, Autor autor, Editorial editorial) {
//         this.titulo = Objects.requireNonNull(titulo, "titulo no puede ser null");
//         this.isbn = Objects.requireNonNull(isbn, "isbn no puede ser null");
//         this.autor = Objects.requireNonNull(autor, "autor no puede ser null");
//         this.editorial = Objects.requireNonNull(editorial, "editorial no puede ser null");
//     }

//     public String getTitulo() { return titulo; }
//     public String getIsbn() { return isbn; }
//     public Autor getAutor() { return autor; }
//     public Editorial getEditorial() { return editorial; }

//     public void setEditorial(Editorial editorial) {
//         this.editorial = Objects.requireNonNull(editorial, "editorial no puede ser null");
//     }

//     @Override
//     public String toString() {
//         return "Libro{" +
//                 "titulo='" + titulo + '\'' +
//                 ", isbn='" + isbn + '\'' +
//                 ", autor=" + autor +
//                 ", editorial=" + editorial +
//                 '}';
//     }
// }

// class Autor {
//     private final String nombre;
//     private final String nacionalidad;

//     public Autor(String nombre, String nacionalidad) {
//         this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
//         this.nacionalidad = Objects.requireNonNull(nacionalidad, "nacionalidad no puede ser null");
//     }

//     public String getNombre() { return nombre; }
//     public String getNacionalidad() { return nacionalidad; }

//     @Override
//     public String toString() {
//         return "Autor{" +
//                 "nombre='" + nombre + '\'' +
//                 ", nacionalidad='" + nacionalidad + '\'' +
//                 '}';
//     }
// }

// class Editorial {
//     private final String nombre;
//     private final String direccion;

//     public Editorial(String nombre, String direccion) {
//         this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
//         this.direccion = Objects.requireNonNull(direccion, "direccion no puede ser null");
//     }

//     public String getNombre() { return nombre; }
//     public String getDireccion() { return direccion; }

//     @Override
//     public String toString() {
//         return "Editorial{" +
//                 "nombre='" + nombre + '\'' +
//                 ", direccion='" + direccion + '\'' +
//                 '}';
//     }
// }

//ejercicio 4

// import java.time.LocalDate;
// import java.util.Objects;

// public class TarjetaDeCredito {
//     private final String numero;
//     private final LocalDate fechaVencimiento;

//     // Asociación bidireccional 1 a 1
//     private final Cliente cliente;

//     // Agregación: puede cambiarse
//     private Banco banco;

//     public TarjetaDeCredito(String numero, LocalDate fechaVencimiento,
//                             Cliente cliente, Banco banco) {
//         this.numero = Objects.requireNonNull(numero, "numero no puede ser null");
//         this.fechaVencimiento = Objects.requireNonNull(fechaVencimiento, "fechaVencimiento no puede ser null");
//         this.cliente = Objects.requireNonNull(cliente, "cliente no puede ser null");
//         this.banco = Objects.requireNonNull(banco, "banco no puede ser null");

//         // Bidireccionalidad: Cliente ↔ Tarjeta
//         cliente.setTarjeta(this);
//     }

//     public String getNumero() { return numero; }
//     public LocalDate getFechaVencimiento() { return fechaVencimiento; }
//     public Cliente getCliente() { return cliente; }

//     public Banco getBanco() { return banco; }
//     public void setBanco(Banco banco) {
//         this.banco = Objects.requireNonNull(banco, "banco no puede ser null");
//     }

//     @Override
//     public String toString() {
//         return "TarjetaDeCredito{" +
//                 "numero='" + numero + '\'' +
//                 ", fechaVencimiento=" + fechaVencimiento +
//                 ", cliente=" + cliente +
//                 ", banco=" + banco +
//                 '}';
//     }
// }

// class Cliente {
//     private final String nombre;
//     private final String dni;

//     // referencia inversa para asociación bidireccional
//     private TarjetaDeCredito tarjeta;

//     public Cliente(String nombre, String dni) {
//         this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
//         this.dni = Objects.requireNonNull(dni, "dni no puede ser null");
//     }

//     public String getNombre() { return nombre; }
//     public String getDni() { return dni; }

//     public TarjetaDeCredito getTarjeta() { return tarjeta; }

//     public void setTarjeta(TarjetaDeCredito tarjeta) {
//         if (this.tarjeta != null && this.tarjeta != tarjeta) {
//             throw new IllegalStateException("El cliente ya tiene una tarjeta asociada.");
//         }
//         this.tarjeta = Objects.requireNonNull(tarjeta, "tarjeta no puede ser null");
//     }

//     @Override
//     public String toString() {
//         return "Cliente{" +
//                 "nombre='" + nombre + '\'' +
//                 ", dni='" + dni + '\'' +
//                 '}';
//     }
// }

// class Banco {
//     private final String nombre;
//     private final String cuit;

//     public Banco(String nombre, String cuit) {
//         this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
//         this.cuit = Objects.requireNonNull(cuit, "cuit no puede ser null");
//         // Podrías agregar validación de formato CUIT si hace falta
//     }

//     public String getNombre() { return nombre; }
//     public String getCuit() { return cuit; }

//     @Override
//     public String toString() {
//         return "Banco{" +
//                 "nombre='" + nombre + '\'' +
//                 ", cuit='" + cuit + '\'' +
//                 '}';
//     }
// }

//ejercicio 5


// import java.util.Objects;

// public class Computadora {
//     private final String marca;
//     private final String numeroSerie;

//     // Composición: creada y poseída por Computadora
//     private final PlacaMadre placaMadre;

//     // Asociación bidireccional: Computadora <-> Propietario
//     private final Propietario propietario;

//     /**
//      * Crea la Computadora, instancia su PlacaMadre (composición) y enlaza bidireccionalmente al Propietario.
//      */
//     public Computadora(String marca, String numeroSerie,
//                        Propietario propietario,
//                        String modeloPM, String chipsetPM) {
//         this.marca = Objects.requireNonNull(marca, "marca no puede ser null");
//         this.numeroSerie = Objects.requireNonNull(numeroSerie, "numeroSerie no puede ser null");
//         this.propietario = Objects.requireNonNull(propietario, "propietario no puede ser null");

//         // Composición: la placa madre se crea dentro de la computadora
//         this.placaMadre = new PlacaMadre(
//                 Objects.requireNonNull(modeloPM, "modeloPM no puede ser null"),
//                 Objects.requireNonNull(chipsetPM, "chipsetPM no puede ser null")
//         );

//         // Bidireccionalidad controlada
//         propietario.setComputadora(this);
//     }

//     public String getMarca() { return marca; }
//     public String getNumeroSerie() { return numeroSerie; }
//     public PlacaMadre getPlacaMadre() { return placaMadre; }
//     public Propietario getPropietario() { return propietario; }

//     @Override
//     public String toString() {
//         return "Computadora{" +
//                 "marca='" + marca + '\'' +
//                 ", numeroSerie='" + numeroSerie + '\'' +
//                 ", placaMadre=" + placaMadre +
//                 ", propietario=" + propietario +
//                 '}';
//     }
// }

// class PlacaMadre {
//     private final String modelo;
//     private final String chipset;

//     public PlacaMadre(String modelo, String chipset) {
//         this.modelo = Objects.requireNonNull(modelo, "modelo no puede ser null");
//         this.chipset = Objects.requireNonNull(chipset, "chipset no puede ser null");
//     }

//     public String getModelo() { return modelo; }
//     public String getChipset() { return chipset; }

//     @Override
//     public String toString() {
//         return "PlacaMadre{" +
//                 "modelo='" + modelo + '\'' +
//                 ", chipset='" + chipset + '\'' +
//                 '}';
//     }
// }

// class Propietario {
//     private final String nombre;
//     private final String dni;

//     // referencia inversa para asociación bidireccional 1 a 1
//     private Computadora computadora;

//     public Propietario(String nombre, String dni) {
//         this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
//         this.dni = Objects.requireNonNull(dni, "dni no puede ser null");
//     }

//     public String getNombre() { return nombre; }
//     public String getDni() { return dni; }

//     public Computadora getComputadora() { return computadora; }

//     /**
//      * Enlaza la relación inversa. Se restringe para mantener 1 a 1.
//      */
//     public void setComputadora(Computadora computadora) {
//         if (this.computadora != null && this.computadora != computadora) {
//             throw new IllegalStateException("El propietario ya tiene una computadora asociada.");
//         }
//         this.computadora = Objects.requireNonNull(computadora, "computadora no puede ser null");
//     }

//     @Override
//     public String toString() {
//         return "Propietario{" +
//                 "nombre='" + nombre + '\'' +
//                 ", dni='" + dni + '\'' +
//                 '}';
//     }
// */

//ejercicio 6

// import java.time.LocalDate;
// import java.time.LocalTime;
// import java.util.Objects;

// public class Reserva {
//     private final LocalDate fecha;
//     private final LocalTime hora;

//     // Asociación unidireccional: Reserva -> Cliente
//     private final Cliente cliente;

//     // Agregación: Reserva -> Mesa (puede cambiarse)
//     private Mesa mesa;

//     public Reserva(LocalDate fecha, LocalTime hora, Cliente cliente, Mesa mesa) {
//         this.fecha = Objects.requireNonNull(fecha, "fecha no puede ser null");
//         this.hora = Objects.requireNonNull(hora, "hora no puede ser null");
//         this.cliente = Objects.requireNonNull(cliente, "cliente no puede ser null");
//         this.mesa = Objects.requireNonNull(mesa, "mesa no puede ser null");
//     }

//     public LocalDate getFecha() { return fecha; }
//     public LocalTime getHora() { return hora; }

//     public Cliente getCliente() { return cliente; }

//     public Mesa getMesa() { return mesa; }
//     public void setMesa(Mesa mesa) {
//         this.mesa = Objects.requireNonNull(mesa, "mesa no puede ser null");
//     }

//     @Override
//     public String toString() {
//         return "Reserva{" +
//                 "fecha=" + fecha +
//                 ", hora=" + hora +
//                 ", cliente=" + cliente +
//                 ", mesa=" + mesa +
//                 '}';
//     }
// }

// class Cliente {
//     private final String nombre;
//     private final String telefono;

//     public Cliente(String nombre, String telefono) {
//         this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
//         this.telefono = Objects.requireNonNull(telefono, "telefono no puede ser null");
//         // Podrías agregar validación de formato del teléfono si lo necesitás
//     }

//     public String getNombre() { return nombre; }
//     public String getTelefono() { return telefono; }

//     @Override
//     public String toString() {
//         return "Cliente{" +
//                 "nombre='" + nombre + '\'' +
//                 ", telefono='" + telefono + '\'' +
//                 '}';
//     }
// }

// class Mesa {
//     private final int numero;
//     private final int capacidad;

//     public Mesa(int numero, int capacidad) {
//         if (numero <= 0) throw new IllegalArgumentException("numero debe ser positivo");
//         if (capacidad <= 0) throw new IllegalArgumentException("capacidad debe ser positiva");
//         this.numero = numero;
//         this.capacidad = capacidad;
//     }

//     public int getNumero() { return numero; }
//     public int getCapacidad() { return capacidad; }

//     @Override
//     public String toString() {
//         return "Mesa{" +
//                 "numero=" + numero +
//                 ", capacidad=" + capacidad +
//                 '}';
//     }
// }



//EJERCICIO 7 

// import java.util.Objects;

// public class Vehiculo {
//     private final String patente;
//     private final String modelo;

//     // Agregación: el vehículo "tiene" un motor que puede existir independientemente y reemplazarse
//     private Motor motor;

//     // Asociación bidireccional con Conductor (1 a 1)
//     private final Conductor conductor;

//     public Vehiculo(String patente, String modelo, Motor motor, Conductor conductor) {
//         this.patente = Objects.requireNonNull(patente, "patente no puede ser null");
//         this.modelo  = Objects.requireNonNull(modelo, "modelo no puede ser null");
//         this.motor   = Objects.requireNonNull(motor, "motor no puede ser null");
//         this.conductor = Objects.requireNonNull(conductor, "conductor no puede ser null");

//         // Establecer bidireccionalidad
//         conductor.setVehiculo(this);
//     }

//     public String getPatente() { return patente; }
//     public String getModelo()  { return modelo; }

//     public Motor getMotor() { return motor; }
//     public void setMotor(Motor motor) {
//         this.motor = Objects.requireNonNull(motor, "motor no puede ser null");
//     }

//     public Conductor getConductor() { return conductor; }

//     @Override
//     public String toString() {
//         return "Vehiculo{" +
//                 "patente='" + patente + '\'' +
//                 ", modelo='" + modelo + '\'' +
//                 ", motor=" + motor +
//                 ", conductor=" + conductor +
//                 '}';
//     }
// }

// class Motor {
//     private final String tipo;         // p.ej. "NAFTA", "DIESEL", "ELÉCTRICO"
//     private final String numeroSerie;

//     public Motor(String tipo, String numeroSerie) {
//         this.tipo = Objects.requireNonNull(tipo, "tipo no puede ser null");
//         this.numeroSerie = Objects.requireNonNull(numeroSerie, "numeroSerie no puede ser null");
//     }

//     public String getTipo() { return tipo; }
//     public String getNumeroSerie() { return numeroSerie; }

//     @Override
//     public String toString() {
//         return "Motor{" +
//                 "tipo='" + tipo + '\'' +
//                 ", numeroSerie='" + numeroSerie + '\'' +
//                 '}';
//     }
// }

// class Conductor {
//     private final String nombre;
//     private final String licencia;   // código de licencia (p.ej. "B1", "C", etc.)
//     // referencia inversa para asociación bidireccional 1 a 1
//     private Vehiculo vehiculo;

//     public Conductor(String nombre, String licencia) {
//         this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
//         this.licencia = Objects.requireNonNull(licencia, "licencia no puede ser null");
//     }

//     public String getNombre() { return nombre; }
//     public String getLicencia() { return licencia; }

//     public Vehiculo getVehiculo() { return vehiculo; }

//     public void setVehiculo(Vehiculo vehiculo) {
//         if (this.vehiculo != null && this.vehiculo != vehiculo) {
//             throw new IllegalStateException("El conductor ya tiene un vehículo asociado.");
//         }
//         this.vehiculo = Objects.requireNonNull(vehiculo, "vehiculo no puede ser null");
//     }

//     @Override
//     public String toString() {
//         return "Conductor{" +
//                 "nombre='" + nombre + '\'' +
//                 ", licencia='" + licencia + '\'' +
//                 '}';
//     }
// }



// EJERCICIO 8


// import java.nio.charset.StandardCharsets;
// import java.security.MessageDigest;
// import java.security.NoSuchAlgorithmException;
// import java.time.LocalDateTime;
// import java.util.HexFormat;
// import java.util.Objects;

// public class Documento {
//     private final String titulo;
//     private final String contenido;

//     // Composición: la firma pertenece al documento
//     private FirmaDigital firma;

//     public Documento(String titulo, String contenido) {
//         this.titulo = Objects.requireNonNull(titulo, "titulo no puede ser null");
//         this.contenido = Objects.requireNonNull(contenido, "contenido no puede ser null");
//     }

//     public String getTitulo() { return titulo; }
//     public String getContenido() { return contenido; }
//     public FirmaDigital getFirma() { return firma; }

//     /**
//      * Crea la firma digital (composición) enlazando el Usuario (agregación).
//      * Si ya existe una firma, se sobrescribe por una nueva (p. ej., nueva versión).
//      */
//     public void firmar(Usuario usuario) {
//         Objects.requireNonNull(usuario, "usuario no puede ser null");
//         String hash = generarHash(contenido, usuario);
//         this.firma = new FirmaDigital(hash, LocalDateTime.now(), usuario);
//     }

//     private static String generarHash(String contenido, Usuario usuario) {
//         String data = contenido + "|" + usuario.getNombre() + "|" + usuario.getEmail();
//         try {
//             MessageDigest md = MessageDigest.getInstance("SHA-256");
//             byte[] digest = md.digest(data.getBytes(StandardCharsets.UTF_8));
//             return HexFormat.of().formatHex(digest);
//         } catch (NoSuchAlgorithmException e) {
//             throw new IllegalStateException("Algoritmo de hash no disponible", e);
//         }
//     }

//     @Override
//     public String toString() {
//         return "Documento{" +
//                 "titulo='" + titulo + '\'' +
//                 ", contenido='" + (contenido.length() > 30 ? contenido.substring(0, 30) + "..." : contenido) + '\'' +
//                 ", firma=" + firma +
//                 '}';
//     }
// }

// class FirmaDigital {
//     private final String codigoHash;
//     private final LocalDateTime fecha;

//     // Agregación: referencia a Usuario (firmante)
//     private Usuario usuario;

//     public FirmaDigital(String codigoHash, LocalDateTime fecha, Usuario usuario) {
//         this.codigoHash = Objects.requireNonNull(codigoHash, "codigoHash no puede ser null");
//         this.fecha = Objects.requireNonNull(fecha, "fecha no puede ser null");
//         this.usuario = Objects.requireNonNull(usuario, "usuario no puede ser null");
//     }

//     public String getCodigoHash() { return codigoHash; }
//     public LocalDateTime getFecha() { return fecha; }
//     public Usuario getUsuario() { return usuario; }

//     public void setUsuario(Usuario usuario) {
//         this.usuario = Objects.requireNonNull(usuario, "usuario no puede ser null");
//     }

//     @Override
//     public String toString() {
//         return "FirmaDigital{" +
//                 "codigoHash='" + codigoHash + '\'' +
//                 ", fecha=" + fecha +
//                 ", usuario=" + usuario +
//                 '}';
//     }
// }

// class Usuario {
//     private final String nombre;
//     private final String email;

//     public Usuario(String nombre, String email) {
//         this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
//         this.email = Objects.requireNonNull(email, "email no puede ser null");
//     }

//     public String getNombre() { return nombre; }
//     public String getEmail() { return email; }

//     @Override
//     public String toString() {
//         return "Usuario{" +
//                 "nombre='" + nombre + '\'' +
//                 ", email='" + email + '\'' +
//                 '}';
//     }
// }


// //ejercicio 9


// import java.time.LocalDate;
// import java.time.LocalTime;
// import java.util.Objects;

// public class CitaMedica {
//     private final LocalDate fecha;
//     private final LocalTime hora;

//     // Asociaciones unidireccionales
//     private final Paciente paciente;
//     private final Profesional profesional;

//     public CitaMedica(LocalDate fecha, LocalTime hora, Paciente paciente, Profesional profesional) {
//         this.fecha = Objects.requireNonNull(fecha, "fecha no puede ser null");
//         this.hora = Objects.requireNonNull(hora, "hora no puede ser null");
//         this.paciente = Objects.requireNonNull(paciente, "paciente no puede ser null");
//         this.profesional = Objects.requireNonNull(profesional, "profesional no puede ser null");
//     }

//     public LocalDate getFecha() { return fecha; }
//     public LocalTime getHora() { return hora; }
//     public Paciente getPaciente() { return paciente; }
//     public Profesional getProfesional() { return profesional; }

//     @Override
//     public String toString() {
//         return "CitaMedica{" +
//                 "fecha=" + fecha +
//                 ", hora=" + hora +
//                 ", paciente=" + paciente +
//                 ", profesional=" + profesional +
//                 '}';
//     }
// }

// class Paciente {
//     private final String nombre;
//     private final String obraSocial;

//     public Paciente(String nombre, String obraSocial) {
//         this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
//         this.obraSocial = Objects.requireNonNull(obraSocial, "obraSocial no puede ser null");
//     }

//     public String getNombre() { return nombre; }
//     public String getObraSocial() { return obraSocial; }

//     @Override
//     public String toString() {
//         return "Paciente{" +
//                 "nombre='" + nombre + '\'' +
//                 ", obraSocial='" + obraSocial + '\'' +
//                 '}';
//     }
// }

// class Profesional {
//     private final String nombre;
//     private final String especialidad;

//     public Profesional(String nombre, String especialidad) {
//         this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
//         this.especialidad = Objects.requireNonNull(especialidad, "especialidad no puede ser null");
//     }

//     public String getNombre() { return nombre; }
//     public String getEspecialidad() { return especialidad; }

//     @Override
//     public String toString() {
//         return "Profesional{" +
//                 "nombre='" + nombre + '\'' +
//                 ", especialidad='" + especialidad + '\'' +
//                 '}';
//     }
// }


// //EJERCICIO 10


// import java.time.LocalDateTime;
// import java.util.Objects;

// public class CuentaBancaria {
//     private final String cbu;
//     private double saldo;

//     // Composición: ClaveSeguridad pertenece a la CuentaBancaria
//     private ClaveSeguridad clave;

//     // Asociación bidireccional 1 a 1 con Titular
//     private final Titular titular;

//     public CuentaBancaria(String cbu, double saldoInicial, Titular titular, String codigoClave) {
//         this.cbu = Objects.requireNonNull(cbu, "cbu no puede ser null");
//         if (saldoInicial < 0) throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
//         this.saldo = saldoInicial;

//         this.titular = Objects.requireNonNull(titular, "titular no puede ser null");

//         // Composición: creación de la clave dentro de la CuentaBancaria
//         this.clave = new ClaveSeguridad(
//                 Objects.requireNonNull(codigoClave, "codigoClave no puede ser null"),
//                 LocalDateTime.now()
//         );

//         // Establecer bidireccionalidad
//         titular.setCuenta(this);
//     }

//     public String getCbu() { return cbu; }
//     public double getSaldo() { return saldo; }

//     public void depositar(double monto) {
//         if (monto <= 0) throw new IllegalArgumentException("El monto a depositar debe ser positivo");
//         saldo += monto;
//     }

//     public void extraer(double monto) {
//         if (monto <= 0) throw new IllegalArgumentException("El monto a extraer debe ser positivo");
//         if (monto > saldo) throw new IllegalStateException("Fondos insuficientes");
//         saldo -= monto;
//     }

//     public ClaveSeguridad getClave() { return clave; }
//     public Titular getTitular() { return titular; }

//     /**
//      * Reemplaza la clave actual por una nueva (composición: creada por la cuenta).
//      */
//     public void cambiarClave(String nuevoCodigo) {
//         this.clave = new ClaveSeguridad(
//                 Objects.requireNonNull(nuevoCodigo, "nuevoCodigo no puede ser null"),
//                 LocalDateTime.now()
//         );
//     }

//     @Override
//     public String toString() {
//         return "CuentaBancaria{" +
//                 "cbu='" + cbu + '\'' +
//                 ", saldo=" + saldo +
//                 ", titular=" + titular +
//                 ", clave=" + clave +
//                 '}';
//     }
// }

// class ClaveSeguridad {
//     private final String codigo;
//     private final LocalDateTime ultimaModificacion;

//     public ClaveSeguridad(String codigo, LocalDateTime ultimaModificacion) {
//         this.codigo = Objects.requireNonNull(codigo, "codigo no puede ser null");
//         this.ultimaModificacion = Objects.requireNonNull(ultimaModificacion, "ultimaModificacion no puede ser null");
//     }

//     public String getCodigo() { return codigo; }
//     public LocalDateTime getUltimaModificacion() { return ultimaModificacion; }

//     @Override
//     public String toString() {
//         return "ClaveSeguridad{" +
//                 "codigo='" + codigo + '\'' +
//                 ", ultimaModificacion=" + ultimaModificacion +
//                 '}';
//     }
// }

// class Titular {
//     private final String nombre;
//     private final String dni;

//     // referencia inversa para asociación bidireccional 1 a 1
//     private CuentaBancaria cuenta;

//     public Titular(String nombre, String dni) {
//         this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
//         this.dni = Objects.requireNonNull(dni, "dni no puede ser null");
//     }

//     public String getNombre() { return nombre; }
//     public String getDni() { return dni; }

//     public CuentaBancaria getCuenta() { return cuenta; }

//     public void setCuenta(CuentaBancaria cuenta) {
//         if (this.cuenta != null && this.cuenta != cuenta) {
//             throw new IllegalStateException("El titular ya tiene una cuenta asociada.");
//         }
//         this.cuenta = Objects.requireNonNull(cuenta, "cuenta no puede ser null");
//     }

//     @Override
//     public String toString() {
//         return "Titular{" +
//                 "nombre='" + nombre + '\'' +
//                 ", dni='" + dni + '\'' +
//                 '}';
//     }
// }

// EJERCICIO 11


// import java.util.Objects;

// public class Cancion {
//     private final String titulo;
//     private final Artista artista;

//     public Cancion(String titulo, Artista artista) {
//         this.titulo = Objects.requireNonNull(titulo, "titulo no puede ser null");
//         this.artista = Objects.requireNonNull(artista, "artista no puede ser null");
//     }

//     public String getTitulo() { return titulo; }
//     public Artista getArtista() { return artista; }

//     @Override
//     public String toString() {
//         return "Cancion{" +
//                 "titulo='" + titulo + '\'' +
//                 ", artista=" + artista +
//                 '}';
//     }
// }

// class Artista {
//     private final String nombre;
//     private final String genero;

//     public Artista(String nombre, String genero) {
//         this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
//         this.genero = Objects.requireNonNull(genero, "genero no puede ser null");
//     }

//     public String getNombre() { return nombre; }
//     public String getGenero() { return genero; }

//     @Override
//     public String toString() {
//         return "Artista{" +
//                 "nombre='" + nombre + '\'' +
//                 ", genero='" + genero + '\'' +
//                 '}';
//     }
// }

// class Reproductor {

//     public Reproductor() { /* sin estado */ }

//     /**
//      * Dependencia de uso: utiliza Cancion como parámetro y no la guarda como atributo.
//      */
//     public void reproducir(Cancion cancion) {
//         Objects.requireNonNull(cancion, "cancion no puede ser null");
//         Artista a = cancion.getArtista();
//         System.out.printf("▶ Reproduciendo: '%s' — %s (%s)%n",
//                 cancion.getTitulo(), a.getNombre(), a.getGenero());
//         // Aquí iría la lógica real de reproducción (streaming, buffer, etc.)
//     }
// }

//ejercicio 12


// import java.util.Objects;

// public class Impuesto {
//     private final double monto;
//     private final Contribuyente contribuyente;

//     public Impuesto(double monto, Contribuyente contribuyente) {
//         if (monto < 0) throw new IllegalArgumentException("monto no puede ser negativo");
//         this.monto = monto;
//         this.contribuyente = Objects.requireNonNull(contribuyente, "contribuyente no puede ser null");
//     }

//     public double getMonto() { return monto; }
//     public Contribuyente getContribuyente() { return contribuyente; }

//     @Override
//     public String toString() {
//         return "Impuesto{" +
//                 "monto=" + monto +
//                 ", contribuyente=" + contribuyente +
//                 '}';
//     }
// }

// class Contribuyente {
//     private final String nombre;
//     private final String cuil;

//     public Contribuyente(String nombre, String cuil) {
//         this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
//         this.cuil = Objects.requireNonNull(cuil, "cuil no puede ser null");
//         // si querés, podés validar formato de CUIL aquí
//     }

//     public String getNombre() { return nombre; }
//     public String getCuil() { return cuil; }

//     @Override
//     public String toString() {
//         return "Contribuyente{" +
//                 "nombre='" + nombre + '\'' +
//                 ", cuil='" + cuil + '\'' +
//                 '}';
//     }
// }

// class Calculadora {

//     public Calculadora() { /* sin estado */ }

//     /**
//      * Dependencia de uso: utiliza Impuesto como parámetro y no lo guarda como atributo.
//      * Ejemplo: aplica un recargo del 10% al monto base y muestra el total.
//      */
//     public void calcular(Impuesto impuesto) {
//         Objects.requireNonNull(impuesto, "impuesto no puede ser null");

//         double base = impuesto.getMonto();
//         double recargo = base * 0.10;  // 10%
//         double total = base + recargo;

//         Contribuyente c = impuesto.getContribuyente();
//         System.out.printf("🧮 Cálculo de impuesto%n" +
//                           "- Contribuyente: %s (CUIL: %s)%n" +
//                           "- Monto base: $%.2f%n" +
//                           "- Recargo (10%%): $%.2f%n" +
//                           "- Total a pagar: $%.2f%n",
//                 c.getNombre(), c.getCuil(), base, recargo, total);
//     }
// }


//ejercicio 13

// import java.util.Objects;

// public class CodigoQR {
//     private final String valor;
//     // Asociación unidireccional: CodigoQR -> Usuario
//     private final Usuario usuario;

//     public CodigoQR(String valor, Usuario usuario) {
//         this.valor = Objects.requireNonNull(valor, "valor no puede ser null");
//         this.usuario = Objects.requireNonNull(usuario, "usuario no puede ser null");
//     }

//     public String getValor() { return valor; }
//     public Usuario getUsuario() { return usuario; }

//     @Override
//     public String toString() {
//         return "CodigoQR{" +
//                 "valor='" + valor + '\'' +
//                 ", usuario=" + usuario +
//                 '}';
//     }
// }

// class Usuario {
//     private final String nombre;
//     private final String email;

//     public Usuario(String nombre, String email) {
//         this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
//         this.email = Objects.requireNonNull(email, "email no puede ser null");
//     }

//     public String getNombre() { return nombre; }
//     public String getEmail() { return email; }

//     @Override
//     public String toString() {
//         return "Usuario{" +
//                 "nombre='" + nombre + '\'' +
//                 ", email='" + email + '\'' +
//                 '}';
//     }
// }

// class GeneradorQR {

//     public GeneradorQR() { /* sin estado */ }

//     /**
//      * Dependencia de creación (versión void):
//      * Crea el CódigoQR dentro del método y no lo conserva como atributo.
//      * Demostrativamente, lo "entrega" imprimiendo/mostrando.
//      */
//     public void generar(String valor, Usuario usuario) {
//         Objects.requireNonNull(valor, "valor no puede ser null");
//         Objects.requireNonNull(usuario, "usuario no puede ser null");

//         CodigoQR qr = new CodigoQR(valor, usuario); // creación interna
//         // "Entregar" sin guardar: por ejemplo, mostrarlo, enviarlo, etc.
//         System.out.printf("✅ Código QR generado:%n- valor: %s%n- usuario: %s (%s)%n",
//                 qr.getValor(), qr.getUsuario().getNombre(), qr.getUsuario().getEmail());
//         // No se guarda en ningún campo; el objeto se pierde al salir del método (dependencia de creación).
//     }

//     /**
//      * Dependencia de creación (versión que retorna el objeto):
//      * También crea el CódigoQR dentro del método; retornarlo permite usarlo después desde el caller.
//      */
//     public CodigoQR crear(String valor, Usuario usuario) {
//         Objects.requireNonNull(valor, "valor no puede ser null");
//         Objects.requireNonNull(usuario, "usuario no puede ser null");
//         return new CodigoQR(valor, usuario);
//     }
// }
