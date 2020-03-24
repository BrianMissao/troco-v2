public enum Dinheiro {
    CEMREAIS(100.00),

    CINQUENTAREAIS(50.00),

    VINTEREAIS(20.00),

    DEZREAIS(10.00),

    CINCOREAIS(05.00),

    DOISREAIS(02.00),

    UMREAL(01.00),
    CINQUENTACENTAVOS(0.50),
    VINTEECINCOCENTAVOS(0.25),
    DEZCENTAVOS(0.10),
    CINCOCENTAVOS(0.05),
    UMCENTAVO(0.01);
    private double valor;
    private String tipoDinheiro;
    private String nomeDinheiro;
    Dinheiro(double valor){
        this.valor = valor;
        this.tipoDinheiro = valor < 1.00? "centavo (s)": "real (s)";
        this.nomeDinheiro = valor+tipoDinheiro;
    }

    public double getValor() {
        return valor;
    }

    public String getNomeDinheiro() {
        return nomeDinheiro;
    }
}
