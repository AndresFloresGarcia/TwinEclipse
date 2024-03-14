package es.twineclipse;

import androidx.annotation.NonNull;

class Efecto {
    private final String titulo;
    private final String descripcion;
    private final int duracionHoras;
    private final TipoEfecto tipo;

    public Efecto(String titulo, String descripcion, int duracionHoras, TipoEfecto tipo) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracionHoras = duracionHoras;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public TipoEfecto getTipo() {
        return tipo;
    }

    @NonNull
    @Override
    public String toString() {
        return "Efecto: " + titulo + "\nDescripción: " + descripcion + "\nDuración: " + duracionHoras + " horas\nTipo: " + tipo;
    }
}