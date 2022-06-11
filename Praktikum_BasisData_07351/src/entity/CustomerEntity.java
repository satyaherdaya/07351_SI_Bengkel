package entity;

public class CustomerEntity {
    protected int id_customer;
    protected String nama_customer;
    protected String notelp_customer;

    public CustomerEntity(String nama_customer, String notelp_customer) {
        this.nama_customer = nama_customer;
        this.notelp_customer = notelp_customer;
    }
    
    public CustomerEntity(int id_customer, String nama_customer, String notelp_customer) {
        this.id_customer = id_customer;
        this.nama_customer = nama_customer;
        this.notelp_customer = notelp_customer;
    }

    public int getIdCustomer() {
        return id_customer;
    }

    public void setIdCustomer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getNamaCustomer() {
        return nama_customer;
    }

    public void setNamaCustomer(String nama_customer) {
        this.nama_customer = nama_customer;
    }

    public String getNotelpCustomer() {
        return notelp_customer;
    }

    public void setNotelpCustomer(String notelp_customer) {
        this.notelp_customer = notelp_customer;
    }
    
    
}
