package sample.Code;

public class Simbolo {
    String nombre;
    String tipo;
    int ambito;
    String firma;

    public Simbolo(String nombre, String tipo, int ambito, String firma) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ambito = ambito;
        this.firma = firma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAmbito() {
        return ambito;
    }

    public void setAmbito(int ambito) {
        this.ambito = ambito;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }
}
