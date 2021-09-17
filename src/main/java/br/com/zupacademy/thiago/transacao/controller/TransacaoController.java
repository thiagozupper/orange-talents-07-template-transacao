package br.com.zupacademy.thiago.transacao.controller;

import br.com.zupacademy.thiago.transacao.dto.TransacaoResponse;
import br.com.zupacademy.thiago.transacao.model.Transacao;
import br.com.zupacademy.thiago.transacao.repository.TransacaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    private final TransacaoRepository transacaoRepository;

    public TransacaoController(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping("/ultimas/{idCartao}")
    public ResponseEntity<?> ultimasTransacoes(@PathVariable String idCartao) {

        Optional<Transacao> transacaoOptional = transacaoRepository.findById(idCartao);
        if (transacaoOptional.isEmpty()) {
            ResponseEntity.notFound();
        }
        List<Transacao> transacoes = transacaoRepository.findTop10ByCartaoIdOrderByEfetivadaEmDesc(idCartao);
        List<TransacaoResponse> transacaoResponseList = transacoes.stream()
                                                .map(transacao -> transacao.toTransacaoResponse())
                                                .collect(Collectors.toList());
        return ResponseEntity.ok(transacaoResponseList);
    }
}
