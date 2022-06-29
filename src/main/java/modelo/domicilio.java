package modelo;

public class domicilio {

    private int id;
    private int idCliente;
    private String nroPuerta;
    private String calle;
    private String ciudad;
    private String departamento;
    private String cliente;

    public domicilio(int id, int idCliente, String nroPuerta, String calle, String ciudad, String departamento, String cliente) {
        this.id = id;
        this.idCliente = idCliente;
        this.nroPuerta = nroPuerta;
        this.calle = calle;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.cliente = cliente;
    }

    public domicilio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNroPuerta() {
        return nroPuerta;
    }

    public void setNroPuerta(String nroPuerta) {
        this.nroPuerta = nroPuerta;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }



}
