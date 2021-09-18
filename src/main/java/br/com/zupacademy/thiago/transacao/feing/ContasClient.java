package br.com.zupacademy.thiago.transacao.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "contas", url = "${contas.url.base}")
public interface ContasClient {

    @RequestMapping(method = RequestMethod.GET, path ="/api/cartoes/{id}")
    public CartaoResponse consultaCartaoPeloId(@PathVariable("id") String idCartao);

}