package TesteCaixaBranca;

public class ValidarCartao {
    private String numeroCartao;

    public ValidarCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao.replaceAll("\\s+", "");
    }

    public boolean isValid() {
        // 1
        if (this.numeroCartao == null || this.numeroCartao.isEmpty() || this.numeroCartao.length() != 16)
            // 2
            return false;

        // 3
        if (!this.numeroCartao.matches("[0-9]+")) {
            // 4
            return false;
        }

        // 5
        return ehVisa() || ehMastercard() || ehElo();
    }

    private boolean ehVisa() {
        // 1
        return this.numeroCartao.startsWith("4");
    }

    private boolean ehMastercard() {
        // 1
        int prefixo = Integer.parseInt(this.numeroCartao.substring(0, 6));
        // 2
        return (prefixo >= 510000 && prefixo <= 559999) || (prefixo >= 222100 && prefixo <= 272099);
    }

    private boolean ehElo() {
        // 1
        var primeirosSeisDigitos = this.numeroCartao.substring(0, 6);
        String[] prefixosElo = {
                "401178", "401179", "431274", "438935", "451416", "457393", "457631", "457632",
                "504175", "506699", "506770", "506771", "506772", "506773", "506774", "506775",
                "506776", "506777", "509000", "509001", "509002", "509003", "509004", "509005",
                "509006", "509007", "509008", "509009", "636368", "636297", "636369", "627780"
        };

        // 3
        for (String prefixo : prefixosElo) {
            // 4
            if (primeirosSeisDigitos.startsWith(prefixo)) {
                // 5
                return true;
            }
        }
        // 6
        return false;
    }
}