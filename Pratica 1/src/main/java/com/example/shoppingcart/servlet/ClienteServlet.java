package com.example.shoppingcart.servlet;

import com.example.shoppingcart.dto.ClienteDTO;
import com.example.shoppingcart.model.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/cliente")
public class ClienteServlet extends HttpServlet {

    private ClienteDTO clienteDTO = new ClienteDTO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cliente> clientes = clienteDTO.list();
        request.setAttribute("clientes", clientes);
        request.getRequestDispatcher("/cliente-list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setEmail(email);

        clienteDTO.save(cliente);
        response.sendRedirect("cliente");
    }
}