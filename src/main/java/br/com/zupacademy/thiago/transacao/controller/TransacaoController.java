package br.com.zupacademy.thiago.transacao.controller;

import br.com.zupacademy.thiago.transacao.dto.TransacaoResponse;
import br.com.zupacademy.thiago.transacao.feing.ContasClient;
import br.com.zupacademy.thiago.transacao.model.Transacao;
import br.com.zupacademy.thiago.transacao.repository.TransacaoRepository;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    private final TransacaoRepository transacaoRepository;
    private final ContasClient contasClient;

    public TransacaoController(TransacaoRepository transacaoRepository, ContasClient contasClient) {
        this.transacaoRepository = transacaoRepository;
        this.contasClient = contasClient;
    }

    @GetMapping("/ultimas/{idCartao}")
    public ResponseEntity<?> ultimasTransacoes(@PathVariable String idCartao) {

        try {
            contasClient.consultaCartaoPeloId(idCartao);
        } catch(FeignException.NotFound ex) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartão não existe.");
        } catch (FeignException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema ao consultar cartão");
        }

        List<Transacao> transacoes = transacaoRepository.findTop10ByCartaoIdOrderByEfetivadaEmDesc(idCartao);
        List<TransacaoResponse> transacaoResponseList = transacoes.stream()
                                                .map(transacao -> transacao.toTransacaoResponse())
                                                .collect(Collectors.toList());
        return ResponseEntity.ok(transacaoResponseList);
    }
}
