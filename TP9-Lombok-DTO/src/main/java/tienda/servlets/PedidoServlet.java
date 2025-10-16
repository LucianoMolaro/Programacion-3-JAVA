package tienda.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tienda.DTO.PedidoDTO;
import tienda.Repository.PedidoRepository;
import tienda.mapper.FuncionApp;
import tienda.mapper.MapperUtil;
import tienda.models.Pedido;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@WebServlet(name = "PedidoServlet"   ,urlPatterns = "/SvPedido")
public class PedidoServlet extends HttpServlet {
    private final ObjectMapper mapper = new ObjectMapper();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PedidoRepository pr = new PedidoRepository();
        List<Pedido> pedidos = pr.getTodosLosPedidos();

        List<PedidoDTO> dtos = pedidos.stream()
                .map(MapperUtil::toPedidoDTO) // mapea cada Pedido → PedidoDTO
                .collect(Collectors.toList());

        resp.setContentType("application/json");
        resp.getWriter().write(mapper.writeValueAsString(dtos));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        FuncionApp.crearPedidos();

        PedidoRepository pr = new PedidoRepository();
        List<Pedido> pedidos = pr.getTodosLosPedidos();

        List<PedidoDTO> dtos = pedidos.stream()
                .map(MapperUtil::toPedidoDTO)
                .collect(Collectors.toList());

        resp.setContentType("application/json");
        resp.getWriter().write(mapper.writeValueAsString(dtos));
    }

}
