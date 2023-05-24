<%-- 
    Document   : frmaviso
    Created on : 23 may. 2023, 20:27:03
    Author     : MIGUEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <h1>Editar</h1>
        <form action="Inicio" method="post">
            <input type="hidden" name="id" value ="${aviso.id}"/>
            <table>

                <tr>
                    <td>Descripcion</td>
                    <td><input type="text" name="descripcion" value="${aviso.descripcion}" /></td>
                </tr>
                <tr>
                    <td>Cantidad</td>
                    <td><input type="number" step="0.01"  name="cantidad" value="${aviso.cantidad}" /></td>
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><input type="text" name="precio" value="${aviso.precio}" /></td>
                </tr>
                <tr>
                    <td>Categoria</td>
                    <td><input type="text" name="categoria" value="${aviso.categoria}" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" /></td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>
