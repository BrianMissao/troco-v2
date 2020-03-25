import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    private static BigDecimal valorPagoPeloCliente;
    private static BigDecimal valorDoProduto;
    private static BigDecimal trocoOrganizado;
    private static int quantidadeDeDinheiro;
    private static Dinheiro[] dinheiro = Dinheiro.values();
    private static Map<Dinheiro, Integer> dinheiroOrganizadoParaPagamento = new HashMap<Dinheiro, Integer>();

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o preço do produto:\n");
        valorDoProduto = new BigDecimal(teclado.nextLine()).setScale(2, RoundingMode.HALF_EVEN);
        System.out.println("Agora, digite o quanto o cliente pagou a você:\n");
        valorPagoPeloCliente = new BigDecimal(teclado.nextLine()).setScale(2, RoundingMode.HALF_EVEN);
        trocoOrganizado = valorPagoPeloCliente.subtract(valorDoProduto);
        organizarDinheiroParaPagamento();
        System.out.println(resumirPagamento())  ;
    }

    private static void organizarDinheiroParaPagamento() {
        int contador = 0;
        while (trocoOrganizado.compareTo(BigDecimal.valueOf(0.00)) > 0   && contador < dinheiro.length) {
            if (dinheiro[contador].getValor().compareTo(trocoOrganizado) <= 0) {
                quantidadeDeDinheiro = trocoOrganizado.divideToIntegralValue(dinheiro[contador].getValor()).intValue();
                dinheiroOrganizadoParaPagamento.put(dinheiro[contador], quantidadeDeDinheiro);
                trocoOrganizado = trocoOrganizado.remainder(dinheiro[contador].getValor());
            }
            contador++;
        }
    }

    private static String resumirPagamento() {
        String pagamentoResumido = "Você deve dar ao cliente "+valorPagoPeloCliente.subtract(valorDoProduto)+", na seguinte organização:\n";
        String notaOuMoeda;
        for (Dinheiro organizado : dinheiroOrganizadoParaPagamento.keySet()) {
            notaOuMoeda = organizado.getValor().compareTo(BigDecimal.valueOf(1.00)) < 0? "moeda (s)" : "nota (s)";
            pagamentoResumido = pagamentoResumido + dinheiroOrganizadoParaPagamento.get(organizado) + " " + notaOuMoeda + " de " + organizado.getNomeDinheiro() + "\n";
        }
        return pagamentoResumido;
    }
}
