public class Pasajero {
    private String nombre;
    private int numeroAsiento;
    private String tipoAsiento;
    private Boolean checkin;

    public Pasajero(String nombre, int numeroAsiento, String tipoAsiento) {
        this.nombre = nombre;
        this.numeroAsiento = numeroAsiento;
        this.tipoAsiento = tipoAsiento;
        this.checkin = false;

    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoAsiento() {
        return tipoAsiento;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public Boolean getCheckin() {
        return checkin;
    }

    @Override
    public String toString() {
        return "Pasajero" +
                "Nombre: '" + nombre +
                ", No. Asiento:" + numeroAsiento +
                ", Tipo Asiento: '" + tipoAsiento +
                ", Checkin: " + checkin + "\n";
    }
}
