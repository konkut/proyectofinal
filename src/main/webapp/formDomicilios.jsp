
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%
    if (session.getAttribute("logueado") != "ok") {
        response.sendRedirect("login.jsp");
    }
%>
<%
    int valor = 0;
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/bd_ventas";
    String usuario = "root";
    String password = "";
    Connection conn = null;
    Class.forName(driver);
    conn = DriverManager.getConnection(url, usuario, password);
    String sql = "select * from clientes";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
        valor = rs.getInt("id");
    }
    rs.close();
    ps.close();
    conn.close();

    
%>
<!doctype html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="Pagina de venta de productos tecnologicos">
        <meta name="author" content="Pedro Luis Condori Cutile">
        <link rel="canonical" href="loginControlador">
        <link rel="icon" href="IMG/imagen.ico">
        <link href="CSS/styles.css" rel="stylesheet"> 
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
        <title>Formulario Domicilios</title>
    </head>
    <body class="d-flex align-content-start h-100 flex-wrap text-start text-white bg-dark">
        <div class="container">
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="Domicilios"/>
            </jsp:include>
            <div class="row bg-dark">
                <div class="col-12">
                    <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
                        <h1>Formulario Domicilios</h1>

                        <form action="domicilioControlador?user=domicilio" method="post">
                            <input type="hidden" name="id" value="${domicilio.id}">

                           <%if (session.getAttribute("rol").toString().contains("2")) {%>
                            <div class="mb-3">
                                <label for="cliente" class="form-label float-start">Clientes</label>
                                <select name="idCliente" id="cliente" class="form-select">

                                    <option value="">--seleccione--</option>
                                    <c:forEach var="item" items="${listaCli}">

                                        <option value="${item.id}"
                                                <c:if test="${domicilio.idCliente == item.id}">
                                                    selected
                                                </c:if>
                                                >${item.nombre}</option>
                                    </c:forEach>    
                                </select>
                            </div>
                            <%}%>
                            <%if (session.getAttribute("rol").toString().contains("1")) {%>
                            <input type="hidden" name="idCliente" value="<%=valor%>">
                            <%}%>
                            <div class="mb-3">
                                <label for="numero" class="form-label float-start">Numero de puerta</label>
                                <input type="text" value="${domicilio.nroPuerta}" name="nroPuerta" class="form-control" id="numero" placeholder="Ingrese sus numero de puerta">
                            </div>
                            <div class="mb-3">
                                <label for="calle" class="form-label float-start">Calle</label>
                                <input type="text" value="${domicilio.calle}" name="calle" class="form-control" id="calle" placeholder="Ingrese su calle">
                            </div>
                            <div class="mb-3">
                                <label for="ciudad" class="form-label float-start">Ciudad</label>
                                <input type="text" value="${domicilio.ciudad}" name="ciudad" class="form-control" id="ciudad" placeholder="Ingrese su ciudad">
                            </div>
                            <div class="mb-3">
                                <label for="departamento" class="form-label float-start">Departamento</label>
                                <input type="text" value="${domicilio.departamento}" name="departamento" class="form-control" id="departamento" placeholder="Ingrese su departamento">
                            </div>
                            <button type="submit" class="btn btn-primary d-block">Enviar</button>
                        </form>

                    </div> 
                </div> 
            </div> 
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
