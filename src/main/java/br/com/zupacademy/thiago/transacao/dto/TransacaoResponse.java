package br.com.zupacademy.thiago.transacao.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private BigDecimal valor;
    private String estabelecimento;
    private String cidade;
    private String endereco;
    private LocalDateTime quando;

    public TransacaoResponse(BigDecimal valor, String estabelecimento,
                    String cidade, String endereco, LocalDateTime quando) {
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cidade = cidade;
        this.endereco = endereco;
        this.quando = quando;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public LocalDateTime getQuando() {
        return quando;
    }

}
