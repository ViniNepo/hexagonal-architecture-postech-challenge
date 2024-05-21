package com.postech.adapter.driver.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> responseBuilder(String mensagem, HttpStatus httpEstado, Object objetoResposta){
        Map<String, Object> resposta = new HashMap<>();
        resposta.put("mensagem", mensagem);
        resposta.put("httpEstado", httpEstado);
        resposta.put("dados", objetoResposta);

        return new ResponseEntity<>(resposta, httpEstado);
    }
}
