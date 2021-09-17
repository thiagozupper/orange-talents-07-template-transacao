package br.com.zupacademy.thiago.transacao.consumer.kafkadto;

import br.com.zupacademy.thiago.transacao.model.Estabelecimento;

public class EstabelecimentoKafka {

    private String nome;
    private String cidade;
    private String endereco;

    public EstabelecimentoKafka() {
    }

    public EstabelecimentoKafka(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Estabelecimento toEstabelecimento() {
        return new Estabelecimento(this.nome, this.cidade, this.endereco);
    }
}
