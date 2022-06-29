<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
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
        <title>Login</title>
    </head>
    <body class="text-center">

        <main class="form-signin">
            <form action="loginControlador" method="post">
                <img class="mb-4" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAMAAAD04JH5AAAAZlBMVEX///8AAAD4+Pjn5+fz8/Pw8PDk5OSgoKCGhoZ1dXUsLCzJycnc3Nyjo6NiYmK+vr5EREQdHR0TExNLS0skJCRYWFjR0dFTU1OpqalpaWlvb28LCwuysrIYGBh+fn49PT0zMzOSkpJ2tnxdAAAE6ElEQVR4nO1ba8NzMAytuo65bMbs4jH//0++yhjWcmK8n5yvo4k0SZOTjrEdO3bs2LEU3DBN3aqgm6bB/69s07Odw7VwtTfc4npwbM/8H7K5ZweaEoHtbWqLY5ac1dIbnJPsuI103b/OSn/rcPX11cV7B0x4i4O3qvjsRRMv8MrWkm7aoOnHONtrxAX3F3x9ZwX/56Dw4uXiBeLffMG8/SZe4PbDPjx/Fy/wXCheX+HzG9wWpQXPnV8ZhbvAE+z1xAvYRPF84sRZhoAUkPqPwSdDTHAEa8Xt/8C1YPn5FvI1LQc1SLcRL5BC8i/bKXABNLA2lF9pMLsLfBP/+8CdiUYebStf06JpDSiF1/l6L/0s88s7WizWOEzJx/NvHoRW9y3cCoMT/OpEVsYD8Lvs1X34ZWUoGA9whVL+fgm+/jAUCoAOkChDyUqwFRRuEGJvlxNuzEtsjVD2sollAF8tXgDzBFdWJ2IbINWdbkfJJmARMCsf1eA7EqASROH+Q5TISvEivQNEPmNQOTeyJXQGnMAWw0Sy4uhMgFoQwAEaQOYctCsc8YAbKp8xpKWJ+ybwEJUJzMsRWa/frCAGuOPyGbsDC/YCAcoBUEG5cEUHePpFkc8Ywmo43dOIusTmDipt2oeRqHkQyb8jUlu0cY0cQxFNPmNIZnsfSQbSif1RFfgDFs2b0ghKAnAWbAFlQw/WlZKFGkC5qLYrlIYvZJZHR1q8Oh1DqkaqQlYJA+qxhGGhzUrIjCeHKmThWpALgKVIH1BZIpwAMhXpJGqAnEcivWD9+FYKVN06lDMpxUgLiGetMjyUhrQr3Qmv0MIeSEgXZMrbLKCFnyglAHN8LSxsXRuLwq1SsYhDyFkXcP7grOGOtWQLMhHIdscMpOWkDfUEDHDU5TKUXCIWBFh0V+0eQxk2YkmEFNoCZ6girkFTAF8WZcbmuJkh4HnbA1dgjuUdAEuDtQL4cIKQCvCBYw71UA1cuCwzcMr9xbBDq8YkzdwHgfJOSPw4OH4EGc/3R5WEpy9QOjQoMxeHNqAuEAVIM4+MZC/oTKLNXEPqkC6YCQUOHu8tUqYTp5TxpAYGIagE8qrlo47J3Ini6EhejLxnAqqJATot6CGpXsvIb2mvp0QFHi64biOYp0Wj4igbpQQzWzRxFKlNB/fNCYflY+Cnbzvw1B/u4ws9DBvaAeijT381qfidtvMo+o6i6szQS8ggSf0Bs61J8mxDD+pi7LdZgFOmeXSmhwn6HG06a9zi8/jRmat4m35rkiRKRhQxnzGCPYgPs5xW9v2w+qlYwlAbjrKKezhfadKY2oh2BKXag1xRh5q21Gax/PZeqnbHruOVZxD1iLbyMCca7O+pcFJV0cpVPYLbPSKtCeZGdLr3dG5BFAU35+lN04ihvPv5XLnkEm9d9U6oKduzc89hvoz0IhMSM5Acef1mb8wmFGvLl2TR4QRiRGltcUl7XCoNibdhJK5/LVlgdOaM6po+VUSeDWDgg3J93OXon5+gEfkSDCqPLy/rTDBz0+gX9ILN+fqxywUb3Y2vZXQp9yz5ylDmnCuj64KkrX4TiqQJLRXtNQV5g1WHItT9LYev8MAGT5Vt1oOh3gCBg3ba0AVrXCfdjLvkCS0VVUX3mojzdNMYEAi1fNLIm/9V6LhVokdhUS+Z79ixY8eOzfEP6AtAgWsk1GsAAAAASUVORK5CYII=" alt="" width="100" height="100">
                <h1 class="h3 mb-3 fw-normal">Login</h1>

                <div class="form-floating">
                    <input type="correo" name="correo" class="form-control" id="floatingInput" placeholder="nombre@ejemplo.com">
                    <label for="floatingInput">Direccion de correo electronico</label>
                </div>
                <div class="form-floating">
                    <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="contraseña">
                    <label for="floatingPassword">Clave</label>
                </div>

                <div class="checkbox mb-3">
                    <label>
                        <input type="checkbox" value="remember-me"> Recuerdame
                    </label>
                </div>
                <button class="w-100 btn btn-lg btn-dark" type="submit">Registrarse</button>
                <p class="mt-5 mb-3 text-muted">&copy; 2022–2023</p>
            </form>
        </main>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>

