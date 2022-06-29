<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("logueado") != "ok") {
        response.sendRedirect("login.jsp");
    }
%>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Pagina de venta de productos tecnologicos">
        <meta name="author" content="Pedro Luis Condori Cutile">
        <link rel="canonical" href="loginControlador">
        <link rel="icon" href="IMG/imagen.ico">
        <link href="CSS/styles.css" rel="stylesheet"> 
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
        <title>Ordenes Detalle</title>
    </head>
    <body class="d-flex align-content-start h-100 flex-wrap text-start text-white bg-dark">
        <div class="container">
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="OrdenesDetalle"/>
            </jsp:include>
            <div class="row bg-dark">
                <div class="col-12">
                    <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
                        <h1>Ordenes de Detalle</h1>

                        <a class="btn btn-primary btn-sm" href="ordenDetalleControlador?action=insert"><i class="fa-solid fa-cart-plus"></i>Nuevo</a>
                        <table class="table table-striped">
                            <tr>
                                <td class="text-primary">Id</td>
                                <td class="text-primary">Numero Orden</td>
                                <td class="text-primary">producto</td>
                                <td class="text-primary">cantidad</td>
                                <td class="text-primary">precio</td>
                                <td class="text-primary">fecha</td>
                           
                            </tr>
                            <c:forEach var="item" items="${ordenDetalle}">
                                <tr>
                                    <td class="text-white-50">${item.id}</td>
                                    <td class="text-white-50">${item.idOrden}</td>
                                    <td class="text-white-50">${item.producto}</td>
                                    <td class="text-white-50">${item.cantidad}</td>
                                    <td class="text-white-50">${item.precio}</td>
                                    <td class="text-white-50">${item.fecha}</td>
                                    <td><a href="ordenDetalleControlador?action=update&id=${item.id}" Target="_self" ><i class="fa-solid fa-file-pen"></i></a></td>
                                    <td><a href="ordenDetalleControlador?action=delete&id=${item.id}" onclick="return(confirm('Estas seguro???'))"><i class="fa-solid fa-trash"></i></a></td> 
                                </tr>
                            </c:forEach>
                        </table>
                    </div> 
                </div>
            </div>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
</html>