import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Cola {
    private Queue<Pasajero> coleccion;

    public Cola() {
        coleccion = new LinkedList<>();
        predefinir();
    }

    public void predefinir() {
        coleccion.add(new Pasajero("Ana", 1, "PRIMERA CLASE"));
        coleccion.offer(new Pasajero("Juan", 20, "ECONOMICA"));
        coleccion.add(new Pasajero("Flor", 4, "PRIMERA CLASE"));
        coleccion.offer(new Pasajero("Pepe", 10, "EJECUTIVA"));
    }

    //R1 Validar pasajeros
    public void agregar(Pasajero p) {
        if (p != null) {
            if (p.getNombre() == null || p.getNombre().trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre del pasajero no puede estar vacío o en blanco.");
            }
            if (p.getNumeroAsiento() < 1 || p.getNumeroAsiento() > 30) {
                throw new IllegalArgumentException("El asiento debe estar entre 1 y 30.");
            }
            for (Pasajero aux:coleccion) {
                if (aux.getNumeroAsiento() == p.getNumeroAsiento()) {
                    throw new IllegalArgumentException("El asiento ya está ocupado.");
                }
            }
            coleccion.offer(p);
        } else {
            throw new IllegalArgumentException("Pasajero no puede ser nulo");
        }
    }

    public Pasajero extraer() throws Exception {
        if (coleccion.isEmpty()) {
            throw new Exception("Cola sin elementos");
        }
        return coleccion.poll();
    }

    public Pasajero frente() throws Exception {
        if (coleccion.isEmpty()) {
            throw new Exception("Cola sin elementos");
        }
        return coleccion.peek();
    }

    // R2 Buscar pasajero y su posición
    public Pasajero buscarPorAsiento(int asiento) {
        if (asiento < 1 || asiento > 30) {
            throw new IllegalArgumentException("El asiento debe estar entre 1 y 30.");
        }
        for (Pasajero p : coleccion) {
            if (p.getNumeroAsiento() == asiento) {
                return p;
            }
        }
        return null;
    }

    public int posicionPorAsiento(int asiento) {
        if (asiento < 1 || asiento > 30) {
            throw new IllegalArgumentException("El asiento debe estar entre 1 y 30.");
        }
        int posicion = 1;
        for (Pasajero p : coleccion) {
            if (p.getNumeroAsiento() == asiento) {
                return posicion;
            }
            posicion++;
        }
        return -1;
    }

    // --- R3: Cancelar un registro pendiente ---
    public Pasajero cancelarPorAsiento(int asiento) {
        if (asiento < 1 || asiento > 30) {
            throw new IllegalArgumentException("El asiento debe estar entre 1 y 30.");
        }
        Pasajero pasajeroEncontrado = null;
        for (Pasajero p : coleccion) {
            if (p.getNumeroAsiento() == asiento) {
                pasajeroEncontrado = p;
                break;
            }
        }
        if (pasajeroEncontrado == null) {
            throw new NoSuchElementException("El pasajero con el asiento indicado no se encuentra en la fila.");
        }
        coleccion.remove(pasajeroEncontrado);
        return pasajeroEncontrado;
    }

    public int size() {
        return coleccion.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pasajero aux : coleccion) {
            sb.append(aux.toString());
        }
        return sb.toString().length() != 0 ? sb.toString() :
                "Cola sin elementos";
    }
}