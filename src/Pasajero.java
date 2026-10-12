public class Pasajero {
    private String nombre;
    private int numeroAsiento;
    private String tipoAsiento;
    private Boolean checkin;

    public Pasajero(String nombre, int numeroAsiento, String tipoAsiento) {
        this.nombre = nombre;
        this.numeroAsiento = numeroAsiento;
        this.tipoAsiento = tipoAsiento;
        checkin = false;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public String getTipoAsiento() {
        return tipoAsiento;
    }

    public Boolean getCheckin() {
        return checkin;
    }

    public void setCheckin(Boolean checkin) {
        this.checkin = checkin;
    }

    @Override
    public String toString() {
        return "Pasajero " +
                "nombre: " + nombre +
                ", No. Asiento: " + numeroAsiento +
                ", Categoria: '" + tipoAsiento +
                ", checkin: " + checkin + "\n";
    }
}

