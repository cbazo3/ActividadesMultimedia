package com.example.tema5act2;

public class Objeto {
    private String nombreObjeto;
    private String descripcionObjeto;
    private int imagenResourceId; // Referencia a un recurso de imagen en res/drawable

    public Objeto(String nombreObjeto, String descripcionObjeto, int imagenResourceId) {
        this.nombreObjeto = nombreObjeto;
        this.descripcionObjeto = descripcionObjeto;
        this.imagenResourceId = imagenResourceId;
    }

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }

    public String getDescripcionObjeto() {
        return descripcionObjeto;
    }

    public void setDescripcionObjeto(String descripcionObjeto) {
        this.descripcionObjeto = descripcionObjeto;
    }

    public int getImagenResourceId() {
        return imagenResourceId;
    }

    public void setImagenResourceId(int imagenResourceId) {
        this.imagenResourceId = imagenResourceId;
    }

    // Puedes agregar otros métodos o propiedades según tus necesidades.
}
