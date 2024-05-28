package com.postech.nucleo.dominio.enums;

public enum ErroPedidoEnum {
    PEDIDOS_NAO_ECONTRADOS(400, "Nenhum pedido foi encontrado"),
    PEDIDO_NAO_ENCONTRADO(404, "Pedido com o ID informado não foi encontrado"),
    ESTADO_INVALIDO(400, "Não foi possivel realizar a transição de estado para o novo estado informado");

    private Integer httpStatusCode;
    private String detalhe;

    ErroPedidoEnum(Integer httpStatusCode, String detalhe) {
        this.httpStatusCode = httpStatusCode;
        this.detalhe = detalhe;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getDetalhe() {
        return detalhe;
    }
}
