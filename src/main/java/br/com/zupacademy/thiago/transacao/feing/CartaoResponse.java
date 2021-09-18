package br.com.zupacademy.thiago.transacao.feing;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CartaoResponse {
    private String id;
    private LocalDateTime emitidoEm;
    private String titular;
    private BigDecimal limite;
    private String idProposta;

    public CartaoResponse(String id, LocalDateTime emitidoEm, String titular, BigDecimal limite, String idProposta) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.limite = limite;
        this.idProposta = idProposta;
    }

    public String getId() {
        return this.id;
    }
}
