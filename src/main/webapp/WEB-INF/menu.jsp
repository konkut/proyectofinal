<%
    String opcion = request.getParameter("opcion");
    
%>
<div class="row bg-dark">
    <div class="col-3">
        <div class="float-start fw-lighter border border-primary p-2 text-primary me-3">Punto de venta</div>
    </div>
    <div class="col-9">
        <div class="text-dark d-flex h-20 w-100 justify-content-around">
            <nav class="nav nav-masthead">
                <%if (session.getAttribute("rol").toString().contains("1")) {%>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Opciones
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="nav-link <%=(opcion.equals("Index")) ? "active" : ""%>" href="index.jsp" aria-current="page">Inicio</a></li>
                        <li><a class="nav-link disabled <%=(opcion.equals("Clientes")) ? "active" : ""%>" href="clienteControlador">Clientes</a></li>
                        <li><a class="nav-link disabled <%=(opcion.equals("Domicilios")) ? "active" : ""%>" href="domicilioControlador">Domicilios</a></li>
                    </ul>
                </li>
                <%}%>
                <%if (session.getAttribute("rol").toString().contains("2")) {%>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Modulos
                    </a>
                    <ul class="dropdown-menu text-dark" aria-labelledby="navbarDropdown">
                        <li><a class="nav-link  <%=(opcion.equals("Index")) ? "active" : ""%>" href="index.jsp" aria-current="page">Inicio</a></li>
                        <li><a class="nav-link <%=(opcion.equals("Usuarios")) ? "active" : ""%>" href="usuarioControlador">Usuarios</a></li>
                        <li><a class="nav-link <%=(opcion.equals("Roles")) ? "active" : ""%>" href="rolControlador">Rol</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="nav-link <%=(opcion.equals("Clientes")) ? "active" : ""%>" href="clienteControlador">Clientes</a></li>
                        <li><a class="nav-link <%=(opcion.equals("Domicilios")) ? "active" : ""%>" href="domicilioControlador">Domicilios</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="nav-link <%=(opcion.equals("Productos")) ? "active" : ""%>" href="productoControlador">Productos</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="nav-link <%=(opcion.equals("Ordenes")) ? "active" : ""%>" href="ordenControlador">Ordenes</a></li> 
                        <li><a class="nav-link <%=(opcion.equals("OrdenesDetalle")) ? "active" : ""%>" href="ordenDetalleControlador">Ordenes Detalles</a></li> 
                    </ul>
                </li>

                <%}%> 

            </nav>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>

  </span>

            <a class="btn btn-outline-primary" href="logoutControlador?action=logout">Cerrar Session</a>  
        </div>
    </div>

</div>



