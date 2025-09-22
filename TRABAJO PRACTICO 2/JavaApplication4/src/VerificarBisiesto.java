import java.util.Scanner;


//EJERCICIO1
/*public class VerificarBisiesto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un año: ");
        int año = scanner.nextInt();

        if ((año % 4 == 0 && año % 100 != 0) || (año % 400 == 0)) {
            System.out.println("El año " + año + " es bisiesto.");
        } else {
            System.out.println("El año " + año + " no es bisiesto.");
        }

        scanner.close();
    }
}
*/

//EJERCICIO 2

/*import java.util.Scanner;

public class MayorDeTresNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        int num1 = scanner.nextInt();

        System.out.print("Ingrese el segundo número: ");
        int num2 = scanner.nextInt();

        System.out.print("Ingrese el tercer número: ");
        int num3 = scanner.nextInt();

        int mayor;

        if (num1 >= num2 && num1 >= num3) {
            mayor = num1;
        } else if (num2 >= num1 && num2 >= num3) {
            mayor = num2;
        } else {
            mayor = num3;
        }

        System.out.println("El mayor es: " + mayor);

        scanner.close();
    }
}
*/

//EJERCICIO 3
/*
import java.util.Scanner;

public class ClasificacionEdad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();

        if (edad < 12) {
            System.out.println("Eres un Niño.");
        } else if (edad >= 12 && edad <= 17) {
            System.out.println("Eres un Adolescente.");
        } else if (edad >= 18 && edad <= 59) {
            System.out.println("Eres un Adulto.");
        } else if (edad >= 60) {
            System.out.println("Eres un Adulto mayor.");
        } else {
            System.out.println("Edad inválida.");
        }

        scanner.close();
    }
}

#EJERCICIO 4
import java.util.Scanner;

public class CalculadoraDescuento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();

        System.out.print("Ingrese la categoría del producto (A, B o C): ");
        char categoria = scanner.next().toUpperCase().charAt(0);

        double descuento = obtenerDescuentoPorCategoria(categoria);
        double montoDescuento = precio * descuento;
        double precioFinal = precio - montoDescuento;

        System.out.println("Descuento aplicado: " + (descuento * 100) + "%");
        System.out.println("Precio final: " + precioFinal);

        scanner.close();
    }

    public static double obtenerDescuentoPorCategoria(char categoria) {
        switch (categoria) {
            case 'A':
                return 0.10;
            case 'B':
                return 0.15;
            case 'C':
                return 0.20;
            default:
                System.out.println("Categoría inválida. No se aplica descuento.");
                return 0.0;
        }
    }
}

#EJERCICIO 5

import java.util.Scanner;

public class SumaNumerosPares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;
        int sumaPares = 0;

        System.out.print("Ingrese un número (0 para terminar): ");
        numero = scanner.nextInt();

        while (numero != 0) {
            if (numero % 2 == 0) {
                sumaPares += numero;
            }

            System.out.print("Ingrese un número (0 para terminar): ");
            numero = scanner.nextInt();
        }

        System.out.println("La suma de los números pares es: " + sumaPares);

        scanner.close();
    }
}

#EJERCICIO 6
import java.util.Scanner;

public class ContadorNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int positivos = 0;
        int negativos = 0;
        int ceros = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            int numero = scanner.nextInt();

            if (numero > 0) {
                positivos++;
            } else if (numero < 0) {
                negativos++;
            } else {
                ceros++;
            }
        }

        System.out.println("Resultados:");
        System.out.println("Positivos: " + positivos);
        System.out.println("Negativos: " + negativos);
        System.out.println("Ceros: " + ceros);

        scanner.close();
    }
}

#EJERCICIO 6
import java.util.Scanner;

public class ContadorNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int positivos = 0;
        int negativos = 0;
        int ceros = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            int numero = scanner.nextInt();

            if (numero > 0) {
                positivos++;
            } else if (numero < 0) {
                negativos++;
            } else {
                ceros++;
            }
        }

        System.out.println("Resultados:");
        System.out.println("Positivos: " + positivos);
        System.out.println("Negativos: " + negativos);
        System.out.println("Ceros: " + ceros);

        scanner.close();
    }
}

#EJERCICIO 7

import java.util.Scanner;

public class ValidacionNota {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nota;

        do {
            System.out.print("Ingrese una nota (0-10): ");
            nota = scanner.nextInt();

            if (nota < 0 || nota > 10) {
                System.out.println("Error: Nota inválida. Ingrese una nota entre 0 y 10.");
            }
        } while (nota < 0 || nota > 10);

        System.out.println("Nota guardada correctamente.");

        scanner.close();
    }
}

#EJERCICIO 8
import java.util.Scanner;

public class PrecioFinal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el precio base del producto: ");
        double precioBase = scanner.nextDouble();

        System.out.print("Ingrese el impuesto en porcentaje (Ejemplo: 10 para 10%): ");
        double impuestoPorcentaje = scanner.nextDouble();

        System.out.print("Ingrese el descuento en porcentaje (Ejemplo: 5 para 5%): ");
        double descuentoPorcentaje = scanner.nextDouble();

        double precioFinal = calcularPrecioFinal(precioBase, impuestoPorcentaje, descuentoPorcentaje);

        System.out.println("El precio final del producto es: " + precioFinal);

        scanner.close();
    }

    public static double calcularPrecioFinal(double precioBase, double impuestoPorcentaje, double descuentoPorcentaje) {
        double impuesto = precioBase * (impuestoPorcentaje / 100);
        double descuento = precioBase * (descuentoPorcentaje / 100);
        return precioBase + impuesto - descuento;
    }
}

#EJERCICIO 9
import java.util.Scanner;

public class TotalCompraConEnvio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el precio del producto: ");
        double precioProducto = scanner.nextDouble();

        System.out.print("Ingrese el peso del paquete en kg: ");
        double peso = scanner.nextDouble();

        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese la zona de envío (Nacional/Internacional): ");
        String zona = scanner.nextLine().trim();

        double costoEnvio = calcularCostoEnvio(peso, zona);
        double totalCompra = calcularTotalCompra(precioProducto, costoEnvio);

        System.out.println("El costo de envío es: " + costoEnvio);
        System.out.println("El total a pagar es: " + totalCompra);

        scanner.close();
    }

    public static double calcularCostoEnvio(double peso, String zona) {
        if (zona.equalsIgnoreCase("Nacional")) {
            return peso * 5;
        } else if (zona.equalsIgnoreCase("Internacional")) {
            return peso * 10;
        } else {
            System.out.println("Zona inválida. Se asume costo de envío 0.");
            return 0;
        }
    }

    public static double calcularTotalCompra(double precioProducto, double costoEnvio) {
        return precioProducto + costoEnvio;
    }
}


#EJERCICIO 10
import java.util.Scanner;

public class ActualizarStock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el stock actual del producto: ");
        int stockActual = scanner.nextInt();

        System.out.print("Ingrese la cantidad vendida: ");
        int cantidadVendida = scanner.nextInt();

        System.out.print("Ingrese la cantidad recibida: ");
        int cantidadRecibida = scanner.nextInt();

        int nuevoStock = actualizarStock(stockActual, cantidadVendida, cantidadRecibida);

        System.out.println("El nuevo stock del producto es: " + nuevoStock);

        scanner.close();
    }

    public static int actualizarStock(int stockActual, int cantidadVendida, int cantidadRecibida) {
        return stockActual - cantidadVendida + cantidadRecibida;
    }
}

#EJERCICIO 11
import java.util.Scanner;

public class ActualizarStock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el stock actual del producto: ");
        int stockActual = scanner.nextInt();

        System.out.print("Ingrese la cantidad vendida: ");
        int cantidadVendida = scanner.nextInt();

        System.out.print("Ingrese la cantidad recibida: ");
        int cantidadRecibida = scanner.nextInt();

        int nuevoStock = actualizarStock(stockActual, cantidadVendida, cantidadRecibida);

        System.out.println("El nuevo stock del producto es: " + nuevoStock);

        scanner.close();
    }

    public static int actualizarStock(int stockActual, int cantidadVendida, int cantidadRecibida) {
        return stockActual - cantidadVendida + cantidadRecibida;
    }
}

#EJERCICIO 12

public class ModificarArrayPrecios {
    public static void main(String[] args) {
        // a. Declarar e inicializar el array
        double[] precios = {199.99, 299.5, 149.75, 399.0, 89.99};

        // b. Mostrar precios originales
        System.out.println("Precios originales:");
        for (double precio : precios) {
            System.out.println("Precio: $" + precio);
        }

        // c. Modificar el precio del tercer producto (índice 2)
        precios[2] = 129.99;

        // d. Mostrar precios modificados
        System.out.println("\nPrecios modificados:");
        for (double precio : precios) {
            System.out.println("Precio: $" + precio);
        }
    }
}

#EJERCICIO 13

public class RecursividadArrayPrecios {
    public static void main(String[] args) {
        double[] precios = {199.99, 299.5, 149.75, 399.0, 89.99};

        System.out.println("Precios originales:");
        imprimirArrayRecursivo(precios, 0);

        // Modificar el precio del tercer producto (índice 2)
        precios[2] = 129.99;

        System.out.println("\nPrecios modificados:");
        imprimirArrayRecursivo(precios, 0);
    }

    public static void imprimirArrayRecursivo(double[] array, int indice) {
        if (indice < array.length) {
            System.out.println("Precio: $" + array[indice]);
            imprimirArrayRecursivo(array, indice + 1);
        }
    }
}

*/