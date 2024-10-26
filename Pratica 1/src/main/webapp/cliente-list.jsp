<%@ page import="com.example.shoppingcart.model.Cliente" %>
<%@ page import="java.util.List" %>

<html>
<body>
    <h2>Lista de Clientes</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
            <th>Ações

</th>
        </tr>
        <%
            List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
            for (Cliente cliente : clientes) {
        %>
        <tr>
            <td><%= cliente.getId() %></td>
            <td><%= cliente.getNome() %></td>
            <td><%= cliente.getEmail() %></td>
            <td><a href="editarCliente?id=<%= cliente.getId() %>">Editar</a> | 
                <a href="deletarCliente?id=<%= cliente.getId() %>">Deletar</a></td>
        </tr>
        <%
            }
        %>
    </table>
    <a href="cliente-form.jsp">Adicionar Novo Cliente</a>
</body>
</html>