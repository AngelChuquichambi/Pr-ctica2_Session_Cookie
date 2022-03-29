<%@page import="com.emergentes.tarea"%>
<%@page import="java.util.ArrayList"%>
<%
    if (session.getAttribute("tareas") == null) {

        ArrayList<tarea> lisaux = new ArrayList<tarea>();
        session.setAttribute("tareas", lisaux);

    }

    ArrayList<tarea> lista = (ArrayList<tarea>) session.getAttribute("tareas");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Tareas Pendientes</h1>

        <form action="MainServlet" method="post">
            ID <input type="number" min="1" name="id" required><br><br>
            Descripción <input type="text" name="tarea" required><br><br>
            <input type="submit" value="Nueva Tarea">
        </form>

        <br><br>

        <table border="1" cellpadding="5">
            <tr>
                <th>ID</th><th>TAREA</th><th>COMPLETO</th><th>OPCIÓN</th>
            </tr>
            <%                if (lista != null) {
                    for (tarea t : lista) {

            %>
            <tr>
                <th> <%= t.getId()%> </th>
                <th> <%= t.getTarea()%> </th>
                <th><input type="checkbox" name="completado"></th>
                <th><a href="MainServlet?op=eliminar&id=<%= t.getId()%>"><input type="submit" value="Eliminar Tarea"></a></th>
            </tr>
            <%                    }
                }
            %>
        </table>

    </body>
</html>
