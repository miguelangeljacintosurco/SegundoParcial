package com.emergentes.controlador;

import com.emergentes.dao.AlmacenDAOimple;
import com.emergentes.modelo.Almacen;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.dao.AlmacenDAO;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id;
            Almacen avi = new Almacen();
            AlmacenDAO dao = new AlmacenDAOimple();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("aviso", avi);
                    request.getRequestDispatcher("frmavio.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    avi = dao.getById(id);

                    request.setAttribute("aviso", avi);
                    request.getRequestDispatcher("frmavio.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);

                    response.sendRedirect("Inicio");

                    break;
                case "view":
                    List<Almacen> lista = dao.getAll();
                    request.setAttribute("avisos", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("ERROR" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AlmacenDAO dao = new AlmacenDAOimple();
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        float precio = Float.parseFloat(request.getParameter("precio"));
        String categoria = request.getParameter("categoria");
        Almacen avi = new Almacen();

        avi.setId(id);
        avi.setDescripcion(descripcion);
        avi.setCantidad(cantidad);
        avi.setPrecio(precio);
        avi.setCategoria(categoria);
        try {
            if (id == 0) {
                dao.insert(avi);
            } else {

                dao.update(avi);
            }

        } catch (Exception ex) {
            System.out.println("ERROR AL GUARDAR DATOS");
        }
        response.sendRedirect("Inicio");
    }

}
