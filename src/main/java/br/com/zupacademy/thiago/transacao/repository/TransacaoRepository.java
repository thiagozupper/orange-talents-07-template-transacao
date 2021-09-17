package br.com.zupacademy.thiago.transacao.repository;

import br.com.zupacademy.thiago.transacao.model.Transacao;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransacaoRepository extends CrudRepository<Transacao, String> {

    List<Transacao> findTop10ByCartaoIdOrderByEfetivadaEmDesc(String idCartao);
}
