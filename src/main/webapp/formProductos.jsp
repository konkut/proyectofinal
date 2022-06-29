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
        <title>Formulario Productos</title>
    </head>
    <body class="d-flex align-content-start h-100 flex-wrap text-start text-white bg-dark">
        <div class="container">
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="Productos"/>
            </jsp:include>
            <div class="row bg-dark">
                <div class="col-12">
                    <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
                        <h1>Formulario Productos</h1>

                        <form action="productoControlador" method="post">
                            <input type="hidden" name="id" value="${producto.id}">
                            <div class="mb-3">
                                <label for="nombre" class="form-label float-start">Nombre</label>
                                <input type="text" value="${producto.nombre}" name="nombre" class="form-control" id="nombre" placeholder="Ingrese su nombre">
                            </div>
                            <div class="mb-3">
                                <label for="descripcion" class="form-label float-start">Descripcion</label>
                                <input type="text" value="${producto.descripcion}" name="descripcion" class="form-control" id="descripcion" placeholder="Ingrese su descripcion">
                            </div>
                            <div class="mb-3">
                                <label for="precio" class="form-label float-start">Precio</label>
                                <input type="text" value="${producto.precio}" name="precio" class="form-control" id="precio" placeholder="Ingrese su precio">
                            </div>
                            <button type="submit" class="btn btn-primary d-block">Enviar</button>
                        </form>

                    </div>
                </div> 
            </div> 
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>

