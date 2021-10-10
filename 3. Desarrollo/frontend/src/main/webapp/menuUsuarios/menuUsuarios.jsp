<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title> Tienda Genérica | Usuarios </title>
    <link rel="stylesheet" type="text/css" href="css/style1.css">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
  <div class="content">
      <form method="post" action="/frontend/MenuUsuariosServlet">
       <div class="containerb">
        <div class="button_encabezado">
          <button onclick="location.href='/frontend/menuUsuarios/menuUsuarios.html'">Usuarios</button>
          <button onclick="location.href='/frontend/menuClientes/menuClientes.html'">Clientes</button> 
          <button onclick="location.href='/frontend/menuProveedores/menuProveedores.html'">Proveedores</button>
		  <button onclick="location.href='/frontend/menuProductos/menuProductos.html'">Productos</button> 
		  <button onclick="location.href='/frontend/menuVentas/menuVentas.html'">Ventas</button>
		  <button onclick="location.href='/frontend/menuReportes/menuReportes.html'">Reportes</button>
       </div>
     </div>
   <div class="container">
    <div class="title">Usuarios</div>
    <div class="content">

        <div class="user-details">
          <div class="input-box">
            <span class="details">Cédula</span>
            <input type="text" required="required" name="txtCedula" maxlength="20" placeholder="Digite su cédula">
          </div>
          <div class="input-box">
            <span class="details">Usuario</span>
            <input type="text" name="txtUsuario" maxlength="255" placeholder="Digite su usuario">
          </div>
          <div class="input-box">
            <span class="details">Nombre Completo</span>
            <input type="text" name="txtNombre" maxlength="255" placeholder="Digite su nombre">
          </div>
          <div class="input-box">
            <span class="details">Contraseña</span>
            <input type="password" name="pwdContrasena" maxlength="255" placeholder="Digite su contraseña">
          </div>
          <div class="input-box">
            <span class="details">Correo Electrónico</span>
            <input type="email" name="emCorreo" maxlength="255" placeholder="Digite su correo electrónico">
          </div>
         </div>
        
          <div class="button">
          <input type="submit" value="Consultar" name="Consultar">
          <input type="submit" value="Crear" name="Crear">
          <input type="submit" value="Actualizar" name="Actualizar">
          <input type="submit" value="Borrar" name="Borrar">

        </div>
      </form>
    </div>
  </div>
</body>
</html>