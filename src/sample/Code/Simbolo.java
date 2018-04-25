package sample.Code;

import java.util.Objects;

public class Simbolo {
    String nombre;
    String tipo;
    int size;
    int offset;
    String firma;

    public Simbolo(String nombre, String tipo, int size, int offset, String firma) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.size = size;
        this.offset = offset;
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

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Simbolo)) return false;
        Simbolo simbolo = (Simbolo) o;
        return Objects.equals(getNombre(), simbolo.getNombre());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getNombre());
    }
}
