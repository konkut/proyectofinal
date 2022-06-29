
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("logueado") != "ok") {
        response.sendRedirect("login.jsp");
    }

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
        <title>Formulario Ordenes</title>
    </head>
    <body class="d-flex align-content-start h-100 flex-wrap text-start text-white bg-dark">
        <div class="container">
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="Ordenes"/>
            </jsp:include>
            <div class="row bg-dark">
                <div class="col-12">
                    <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
                        <h1>Formulario Ordenes</h1>

                        <form action="ordenControlador" method="post">
                            <input type="hidden" name="id" value="${orden.id}">
                            
                            
                            <div class="mb-3">
                                <label for="cliente" class="form-label float-start">Cliente</label>
                                <select name="idCliente" id="cliente" class="form-select">
                                    <option value="">--seleccione--</option>
                                    <c:forEach var="item" items="${listaCli}">
                                        <option value="${item.id}"
                                                <c:if test="${orden.idCliente == item.id}">
                                                    selected
                                                </c:if>
                                                >${item.nombre}</option>
                                    </c:forEach>    
                                </select>
                            </div>
             
                            <div class="mb-3">
                                <label for="domicilio" class="form-label float-start">Domicilio</label>
                                <select name="idDomicilio" id="domicilio" class="form-select">
                                    <option value="">--seleccione--</option>
                                    <c:forEach var="item" items="${listaDom}">
                                        <option value="${item.id}"
                                                <c:if test="${orden.idDomicilio == item.id}">
                                                    selected
                                                </c:if>
                                                >${item.ciudad}, ${item.calle}, ${item.nroPuerta}</option>
                                    </c:forEach>    
                                </select>
                            </div>
                            
                            <div class="mb-3">
                                <label for="metodo" class="form-label float-start">Metodo</label>
                                <input type="text" value="${orden.metodoPago}" name="metodoPago" class="form-control" id="metodo" placeholder="Ingrese su metodo de pago">
                            </div>
                            
                            
                            <div class="mb-3">
                                <label for="total" class="form-label float-start">Total</label>
                                <input type="text" value="${orden.total}" name="total" class="form-control" id="total" placeholder="Ingrese el total">
                            </div>
                            
                            <button type="submit" class="btn btn-primary d-block">Enviar</button>
                        </form>

                    </div> 
                </div> 
            </div> 
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
            
           
    </body>
</html>


