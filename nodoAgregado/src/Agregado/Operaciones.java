package Agregado;



public class Operaciones{
	Nodo inicio;

    public Operaciones() {
        this.inicio = null;
    }

    public void agregar(String dato) {
        Nodo nuevo = new Nodo(dato);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo temp = inicio;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
        }
        System.out.println("Elemento agregado: " + dato);
    }

    public void agregarE(String dato, int posicion) {
        Nodo nuevo = new Nodo(dato);
    
        if (posicion == 1) {
            nuevo.siguiente = inicio;
            inicio = nuevo;
            System.out.println("Elemento agregado en la posición 1: " + dato);
        } else {
            Nodo temp = inicio;
            int contador = 1; 
    
            while (temp != null && contador < posicion - 1) {
                temp = temp.siguiente;
                contador++;
            }
    
            if (temp == null) {
                System.out.println("La posición está fuera de rango.");
            } else {
                nuevo.siguiente = temp.siguiente;
                temp.siguiente = nuevo;
                System.out.println("Elemento agregado en la posición " + posicion + ": " + dato);
            }
        }
    }


    public void mostrar() {
        Nodo temp = inicio;
        if (temp == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        while (temp != null) {
            System.out.print(temp.dato + " ");
            temp = temp.siguiente;
        }
        System.out.println();
    }

    public void agregarU(String dato) {
        Nodo nuevo = new Nodo(dato);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo temp = inicio;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
        }
        System.out.println("Elemento agregado al final: " + dato);
    }

    public void agregarP(String dato) {
        Nodo nuevo = new Nodo(dato);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            nuevo.siguiente = inicio;
            inicio = nuevo;
            System.out.println("Elemento agregado al principio: " + dato);
        }
    }
}