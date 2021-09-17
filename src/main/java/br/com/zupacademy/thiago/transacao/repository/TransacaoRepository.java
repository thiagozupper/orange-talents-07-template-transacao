package br.com.zupacademy.thiago.transacao.repository;

import br.com.zupacademy.thiago.transacao.model.Transacao;
import org.springframework.data.repository.CrudRepository;

public interface TransacaoRepository extends CrudRepository<Transacao, String> {
}
