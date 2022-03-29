package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String op = request.getParameter("op");

        if (op.equals("eliminar")) {

            int id = Integer.parseInt(request.getParameter("id"));
            int bus = 0;
            int pos = 0;

            HttpSession session = request.getSession();
            ArrayList<tarea> lista = (ArrayList<tarea>) session.getAttribute("tareas");

            for (tarea t : lista) {
                if (t.getId() == id) {
                    bus = pos;
                    pos++;
                }
            }
            lista.remove(bus);
            response.sendRedirect("index.jsp");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String tarea = request.getParameter("tarea");

        tarea t = new tarea();

        t.setId(id);
        t.setTarea(tarea);

        HttpSession sesion = request.getSession();

        ArrayList<tarea> lista = (ArrayList<tarea>) sesion.getAttribute("tareas");
        lista.add(t);

        response.sendRedirect("index.jsp");

    }

}
