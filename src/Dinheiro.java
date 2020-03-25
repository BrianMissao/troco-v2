import java.math.BigDecimal;
import java.math.RoundingMode;

public enum Dinheiro {
    CEMREAIS(BigDecimal.valueOf(100.00)),

    CINQUENTAREAIS(BigDecimal.valueOf(50.00)),

    VINTEREAIS(BigDecimal.valueOf(20.00)),

    DEZREAIS(BigDecimal.valueOf(10.00)),

    CINCOREAIS(BigDecimal.valueOf(05.00)),

    DOISREAIS(BigDecimal.valueOf(02.00)),

    UMREAL(BigDecimal.valueOf(01.00)),
    CINQUENTACENTAVOS(BigDecimal.valueOf(0.50)),
    VINTEECINCOCENTAVOS(BigDecimal.valueOf(0.25)),
    DEZCENTAVOS(BigDecimal.valueOf(0.10)),
    CINCOCENTAVOS(BigDecimal.valueOf(0.05)),
    UMCENTAVO(BigDecimal.valueOf(0.01));
    private BigDecimal valor;
    private String tipoDinheiro;
    private String nomeDinheiro;
    Dinheiro(BigDecimal valor){
        this.valor = valor.setScale(2, RoundingMode.HALF_EVEN);
        this.tipoDinheiro = valor.compareTo(BigDecimal.valueOf(1.00)) == -1? "centavo (s)": "real (s)";
        this.nomeDinheiro = valor+tipoDinheiro;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getNomeDinheiro() {
        return nomeDinheiro;
    }
}
