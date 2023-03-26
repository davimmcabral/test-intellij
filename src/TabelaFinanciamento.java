import java.text.DecimalFormat;

public class TabelaFinanciamento {
    public static void main(String[] args) {
        double valorFinanciado = 30000.0;
        double taxaJurosMensal = 0.01;
        int numParcelas = 48;

        double pmt = (valorFinanciado * taxaJurosMensal) / (1 - Math.pow(1 + taxaJurosMensal, -numParcelas));

        DecimalFormat df = new DecimalFormat("R$ ###,##0.00");

        double saldoDevedor = valorFinanciado;

        System.out.println("Tabela de financiamento:");
        System.out.println("Parcela\tPMT\tJuros\tSaldo Devedor");

        for (int i = 1; i <= numParcelas; i++) {
            double juros = saldoDevedor * taxaJurosMensal;
            double amortizacao = pmt - juros;
            saldoDevedor -= amortizacao;

            System.out.println(i + "\t" + df.format(pmt) + "\t" + df.format(juros) + "\t" + df.format(saldoDevedor));
        }
    }
}
