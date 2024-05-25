package com.postech.adaptador.condutor.api.tratador;

import com.postech.adaptador.condutor.api.dto.ApiRespostaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
public class ResponseHandler {
    public static ResponseEntity<Object> responseBuilder(String mensagem, HttpStatus httpEstado, Object objetoResposta){
        return new ResponseEntity<>(new ApiRespostaDTO(httpEstado.value(), mensagem, objetoResposta), httpEstado);
    }
}
