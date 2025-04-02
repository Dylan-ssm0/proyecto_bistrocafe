
package Clases;


public class detalle_venta {
    
    private String categoria;
    private String producto;
    private int cantidad;
    private double valor;
    private double subtotal;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public detalle_venta(String categoria, String producto, int cantidad, double valor, double subtotal) {
        this.categoria = categoria;
        this.producto = producto;
        this.cantidad = cantidad;
        this.valor = valor;
        this.subtotal = subtotal;
    }
    
}
