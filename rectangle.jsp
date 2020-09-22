<%-- 
    Document   : rectangle
    Created on : Sep 22, 2020, 5:36:49 PM
    Author     : Phu Cong
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Rectangle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<Rectangle> rec = (ArrayList<Rectangle>)
                    request.getAttribute("rec");
        %>
        
        <canvas id="myCanvas" width="500" height="500" style="border:1px solid #d3d3d3;">
            Your browser does not support the HTML5 canvas tag.</canvas>

        <script>
            var c = document.getElementById("myCanvas");
            var ctx = c.getContext("2d");
            
            <% for (Rectangle r : rec) {
            %>
            ctx.beginPath();
            ctx.rect(<%=r.getX()%>, <%=r.getY()%>, <%=r.getW()%>, <%=r.getH()%>);
            ctx.fillStyle = "rgb(<%=r.getRed() %>,<%=r.getGreen()%>,<%=r.getBlue()%>)";
            ctx.fill();
            ctx.stroke();
            <%}%>

           

        </script> 
    </body>
</html>
