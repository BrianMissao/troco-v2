import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    private static double valorPagoPeloCliente;
    private static double valorDoProduto;
    private static double troco;
    private static double trocoOrganizado;
    private static int quantidadeDeDinheiro;
    private static Dinheiro[] dinheiro = Dinheiro.values();
    private static Map<Dinheiro, Integer> dinheiroOrganizadoParaPagamento = new HashMap<Dinheiro, Integer>();

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o preço do produto:\n");
        valorDoProduto = Double.parseDouble(teclado.nextLine());
        System.out.println("Agora, digite o quanto o cliente pagou a você:\n");
        valorPagoPeloCliente = Double.parseDouble(teclado.nextLine());
        troco = valorPagoPeloCliente - valorDoProduto;
        trocoOrganizado = troco;
        organizarDinheiroParaPagamento();
        System.out.println(resumirPagamento())  ;
    }

    private static void organizarDinheiroParaPagamento() {
        int contador = 0;
        while (trocoOrganizado > 0.00 && contador < dinheiro.length) {
            if (dinheiro[contador].getValor() <= trocoOrganizado) {
                quantidadeDeDinheiro = (int) ((int) trocoOrganizado / dinheiro[contador].getValor());
                dinheiroOrganizadoParaPagamento.put(dinheiro[contador], quantidadeDeDinheiro);
                trocoOrganizado = trocoOrganizado % dinheiro[contador].getValor();
            }
            contador++;
        }
    }

    private static String resumirPagamento() {
        String pagamentoResumido = "";
        String notaOuMoeda;
        for (Dinheiro organizado : dinheiroOrganizadoParaPagamento.keySet()) {
            notaOuMoeda = organizado.getValor() < 1.00 ? "moeda (s)" : "nota (s)";
            pagamentoResumido = pagamentoResumido + dinheiroOrganizadoParaPagamento.get(organizado) + " " + notaOuMoeda + " de " + organizado.getNomeDinheiro() + "\n";
        }
        return pagamentoResumido;
    }
}
