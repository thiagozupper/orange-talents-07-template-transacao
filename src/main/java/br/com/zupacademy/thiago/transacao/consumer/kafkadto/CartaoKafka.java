package br.com.zupacademy.thiago.transacao.consumer.kafkadto;

import br.com.zupacademy.thiago.transacao.model.Cartao;

public class CartaoKafka {

    private String id;
    private String email;

    public CartaoKafka() {
    }

    public CartaoKafka(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cartao toCartao() {
        return new Cartao(this.id, this.email);
    }
}
