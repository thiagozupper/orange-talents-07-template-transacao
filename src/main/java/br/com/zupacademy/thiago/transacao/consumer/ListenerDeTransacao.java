package br.com.zupacademy.thiago.transacao.consumer;

import br.com.zupacademy.thiago.transacao.consumer.kafkadto.TransacaoKafka;
import br.com.zupacademy.thiago.transacao.model.Transacao;
import br.com.zupacademy.thiago.transacao.repository.TransacaoRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class ListenerDeTransacao {

    Logger logger = Logger.getLogger(ListenerDeTransacao.class.getName());

    private final TransacaoRepository transacaoRepository;

    public ListenerDeTransacao(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoKafka transacaoKafka) {
        Transacao transacao = transacaoKafka.toTransacao();
        transacaoRepository.save(transacao);
        logger.info("Transação " + transacao.getId() + " salva com sucesso.");
    }

}

