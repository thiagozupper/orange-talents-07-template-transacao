package br.com.zupacademy.thiago.transacao.consumer.kafkadto;

import br.com.zupacademy.thiago.transacao.model.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoKafka {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoKafka estabelecimento;
    private CartaoKafka cartao;
    private LocalDateTime efetivadaEm;

    public TransacaoKafka() {
    }

    public TransacaoKafka(String id, BigDecimal valor,
                          EstabelecimentoKafka estabelecimento, CartaoKafka cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setEstabelecimento(EstabelecimentoKafka estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public void setCartao(CartaoKafka cartao) {
        this.cartao = cartao;
    }

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }

    public Transacao toTransacao() {
        return new Transacao(this.id, this.valor,
                this.estabelecimento.toEstabelecimento(),
                this.cartao.toCartao(),
                this.efetivadaEm);
    }

}

