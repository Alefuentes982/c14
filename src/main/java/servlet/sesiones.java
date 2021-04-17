/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author elena
 */

@WebServlet("/sesionesServlet")
public class sesiones extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        HttpSession sesion = req.getSession();
        String titulo;

        //Pedir el atributo contadorVisitas a la sesion
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");

        //Si es nulo es la primera vez que ingresamos a la plataforma
        if (contadorVisitas == null) {
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez";
        } else {
            contadorVisitas++;
            titulo = "Bienvenido Nuevamente";
        }

        //Agregar el nuevo valor a la sesion
        sesion.setAttribute("contadorVisitas", contadorVisitas);

        //Enviamos la respuesta al cliente
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Sesiones con Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" + titulo + "</h1>");
        out.println("<br>");
        out.println("<h2>" + "EL numero de acceso es: " + contadorVisitas + "</h2>");
        out.println("<br>");
        out.println("<h3>" + "El ID de la sesion es: " + sesion.getId() + "</h3>");
        out.println("</body>");
        out.println("</html>");
    }
}