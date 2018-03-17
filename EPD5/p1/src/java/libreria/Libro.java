package libreria;
// Generated 17-mar-2018 18:05:18 by Hibernate Tools 4.3.1

/**
 * Libro generated by hbm2java
 */
public class Libro implements java.io.Serializable {

    private int id;
    private Editorial editorial;
    private String autor;
    private String titulo;
    private float precio;
    private int isbn;
    private int cantidad;

    public Libro() {
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Libro(int id, Editorial editorial, String autor, String titulo, float precio, int isbn) {
        this.id = id;
        this.editorial = editorial;
        this.autor = autor;
        this.titulo = titulo;
        this.precio = precio;
        this.isbn = isbn;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Editorial getEditorial() {
        return this.editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getIsbn() {
        return this.isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void incrementaCantidad() {
        this.cantidad++;
    }

    public void disminuyeCantidad() {
        this.cantidad--;
    }

    public boolean equals(Object olibro) {
        boolean eq = false;
        Libro libro = (Libro) olibro;
        if (this.getTitulo().equals(libro.getTitulo())
                && this.getAutor().equals(libro.getAutor())
                && this.getPrecio() == libro.getPrecio()
                && this.getIsbn() == libro.getIsbn()) {
            eq = true;
        }
        return eq;
    }

}
