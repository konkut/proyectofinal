package modelo;

import java.sql.Date;

public class venta {

    private int id;
    private int cliente_id;
    private int producto_id;
    private Date fecha;
private String cliente;
private String producto;

    public venta() {
    }

    public venta(int id, int cliente_id, int producto_id, Date fecha, String cliente, String producto) {
        this.id = id;
        this.cliente_id = cliente_id;
        this.producto_id = producto_id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.producto = producto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

}
