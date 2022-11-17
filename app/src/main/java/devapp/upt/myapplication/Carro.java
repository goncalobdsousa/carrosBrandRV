package devapp.upt.myapplication;

public class Carro {
    String marca;
    int logo;

    public int getLogo() {
        return logo;
    }

    public String getMarca() {
        return marca;
    }

    public Carro(String marca,  int logo) {
        this.marca = marca;
        this.logo = logo;
    }
}
