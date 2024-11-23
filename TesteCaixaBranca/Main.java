package TesteCaixaBranca;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Digite o número do cartão (sem espaços ou com espaços, tanto faz):");
            String numeroCartao = Teclado.getUmString();

            ValidarCartao validarCartao = new ValidarCartao(numeroCartao);

            if (validarCartao.isValid()) {
                System.out.println("O número do cartão é válido.");
            } else {
                System.out.println("O número do cartão é inválido.");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar validar o cartão: " + e.getMessage());
        }
    }
}
