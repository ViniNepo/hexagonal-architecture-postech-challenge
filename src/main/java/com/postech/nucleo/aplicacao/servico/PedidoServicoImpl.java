package com.postech.nucleo.aplicacao.servico;

import com.postech.adaptador.condutor.api.dto.PedidoDTO;
import com.postech.adaptador.condutor.api.entidade.ClienteEntidade;
import com.postech.adaptador.condutor.api.entidade.PedidoEntidade;
import com.postech.adaptador.condutor.api.entidade.ProdutoEntidade;
import com.postech.adaptador.condutor.api.mapeador.MapeadorPedido;
import com.postech.adaptador.condutor.api.mapeador.MapeadorProduto;
import com.postech.nucleo.dominio.base.PedidoEstadoExcecao;
import com.postech.nucleo.dominio.base.PedidoException;
import com.postech.nucleo.dominio.base.PedidoNaoEncontradoExcecao;
import com.postech.nucleo.dominio.modelo.PedidoProduto;
import com.postech.nucleo.dominio.repositorio.ClienteRepositorio;
import com.postech.nucleo.dominio.repositorio.PedidoRepositorio;
import com.postech.nucleo.dominio.enums.EstadoPedidoEnum;
import com.postech.nucleo.dominio.modelo.Pedido;
import com.postech.nucleo.dominio.repositorio.ProdutoRepositorio;

import java.util.List;

public class PedidoServicoImpl implements PedidoServico {

    private final PedidoRepositorio pedidoRepositorio;

    private final ProdutoRepositorio produtoRepository;

    private final ClienteRepositorio clienteRepositorio;

    public PedidoServicoImpl(PedidoRepositorio pedidoRepositorio, ProdutoRepositorio produtoRepository, ClienteRepositorio clienteRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
        this.produtoRepository = produtoRepository;
        this.clienteRepositorio = clienteRepositorio;
    }

    @Override
    public PedidoDTO pegaPedidoPorId(Long id) {
        PedidoEntidade pedidoEntidade = pedidoRepositorio.pegaPedidoPorId(id);

        if(pedidoEntidade == null){
            throw new PedidoNaoEncontradoExcecao("Pedido com o ID informado não foi encontrado em nossa base de dados");
        }

        return MapeadorPedido.INSTANCIA.paraDto(MapeadorPedido.INSTANCIA.paraDominio(pedidoEntidade));
    }

    @Override
    public PedidoDTO criaPedido(PedidoDTO pedidoDTO) {

        Pedido pedido = MapeadorPedido.INSTANCIA.paraDominio(pedidoDTO);

        for (PedidoProduto pedidoProduto : pedido.getPedidosProdutos()) {
            ProdutoEntidade produtoEntidade = produtoRepository.pegaProdutoPorId(pedidoProduto.getProduto().getId());
            pedidoProduto.setProduto(MapeadorProduto.INSTANCIA.paraDominio(produtoEntidade));
            pedidoProduto.setPedido(pedido);
        }

        PedidoEntidade pedidoEntidade = MapeadorPedido.INSTANCIA.paraEntidade(pedido);

        ClienteEntidade clienteEntidade = clienteRepositorio.buscarClientePorId(pedidoEntidade.getCliente().getId());

        pedidoEntidade.setCliente(clienteEntidade);

        pedidoEntidade.getPedidosProdutos().forEach(x -> x.setPedido(pedidoEntidade));

        return MapeadorPedido.INSTANCIA.paraDto( MapeadorPedido.INSTANCIA.paraDominio(pedidoRepositorio.salvaPedido(pedidoEntidade)));
    }

    @Override
    public PedidoDTO atualizaEstadoPedidoPorId(Long id, EstadoPedidoEnum estado) {
        PedidoDTO pedidoDTO = this.pegaPedidoPorId(id);

        if(!isTransicaoEstadoValida(pedidoDTO.getEstado(), estado)){
            throw new PedidoEstadoExcecao("Não foi realizar a transição de estado para o novo estado informado");
        }

        pedidoDTO.setEstado(estado);

        Pedido pedidoDominio = MapeadorPedido.INSTANCIA.paraDominio(pedidoDTO);

        pedidoRepositorio.salvaPedido(MapeadorPedido.INSTANCIA.paraEntidade(pedidoDominio));

        return pedidoDTO;
    }

    /**
     * Este método verifica se a transição de estado informada é permitida
     * @param estadoAtual
     * @param novoEstado
     * @return
     */
    private boolean isTransicaoEstadoValida(EstadoPedidoEnum estadoAtual, EstadoPedidoEnum novoEstado) {
        return switch (estadoAtual) {
            case PENDENTE_PAGAMENTO -> novoEstado == EstadoPedidoEnum.PAGO || novoEstado == EstadoPedidoEnum.CANCELADO;
            case PAGO -> novoEstado == EstadoPedidoEnum.RECEBIDO || novoEstado == EstadoPedidoEnum.CANCELADO;
            case RECEBIDO -> novoEstado == EstadoPedidoEnum.PREPARANDO || novoEstado == EstadoPedidoEnum.CANCELADO;
            case PREPARANDO -> novoEstado == EstadoPedidoEnum.PRONTO || novoEstado == EstadoPedidoEnum.CANCELADO;
            case PRONTO -> novoEstado == EstadoPedidoEnum.FINALIZADO || novoEstado == EstadoPedidoEnum.CANCELADO;
            case FINALIZADO, CANCELADO -> throw new PedidoEstadoExcecao("Não é possível alterar o estado do pedido Finalizado ou Cancelado"); // Não pode mudar de FINALIZADO ou CANCELADO
        };
    }

    @Override
    public EstadoPedidoEnum notificaEstadoPedido(Long id) {
        PedidoDTO pedido = this.pegaPedidoPorId(id);
        return pedido.getEstado();
    }

    @Override
    public List<PedidoDTO> pegaTodosProdutos() {
        List<PedidoEntidade> pedidoEntidades = pedidoRepositorio.pegaTodosProdutos();

        if(pedidoEntidades.isEmpty()){
            throw new PedidoNaoEncontradoExcecao("Nenhum pedido foi encontrado na nossa base de dados");
        }

        List<Pedido> pedidos = MapeadorPedido.INSTANCIA.paraDominioListaEntidade(pedidoEntidades);


        return MapeadorPedido.INSTANCIA.paraDTOLista(pedidos);
    }

    @Override
    public void deletarPedido(Long id) {
        pedidoRepositorio.deletaPedido(id);
    }


}
