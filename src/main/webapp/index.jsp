<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Almacen"%>
<%
    List<Almacen> avisos = (List<Almacen>) request.getAttribute("avisos");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
        </head>

        <body>
        <center>
            <table border="1">
                <td>
                    <p>SEGUNDO PARCIAL TEM-742<p>
                    <p>Nombre: MIGUEL ANGEL JACINTO SURCO<p>
                    <p>Carnet: 13569326 L.P.<p>
                </td>
            </table>


            <h1>Gestion de productos</h1>
            <p><a href="Inicio?action=add">Nuevo producto</a></p>
            <table border="1">
                <tr>
                    <th>Id</th>
                    <th>Descripcion</th>
                    <th>Cantidad</th>
                    <th>Precio</th>
                    <th>Categoria</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="item" items="${avisos}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.descripcion}</td>
                        <td>${item.cantidad}</td>
                        <td>${item.precio}</td>
                        <td>${item.categoria}</td>
                        <td><a href="Inicio?action=edit&id=${item.id}">Editar</a> </td>

                        <td><a href="Inicio?action=delete&id=${item.id}" onclick="return(confirm('Estas seguro?'))">Eliminar</a></td>
                    </tr>
                </c:forEach>
            </table>
        </center>
    </body>
</html>