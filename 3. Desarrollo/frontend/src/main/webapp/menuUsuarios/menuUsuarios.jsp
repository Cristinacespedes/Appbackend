<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ubosque.mintic.frontend.logica.UsuarioLogica" %>
<%@ page import="com.ubosque.mintic.frontend.dto.UsuarioDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title> Tienda Genérica | Usuarios </title>
    <link rel="stylesheet" type="text/css" href="css/style1.css">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <script type="text/javascript" src="./alertas.js"></script>
</head>
<body>
  <div class="content">
      <form method="post" action="">
      
      <%
      	String consultar = request.getParameter("Consultar");
		String crear = request.getParameter("Crear");
		String actualizar = request.getParameter("Actualizar");
		String borrar = request.getParameter("Borrar");
		
      	UsuarioLogica logica = new UsuarioLogica();
      	UsuarioDTO dtoConsultado =new UsuarioDTO();
      	
      	String cedulaDigitada = request.getParameter("txtCedula");
      	String correoDigitado = request.getParameter("emCorreo");
		String nombreDigitado = request.getParameter("txtNombre");
		String contrasenaDigitada = request.getParameter("pwdContrasena");
		String usuarioDigitado = request.getParameter("txtUsuario");
		
		UsuarioDTO dtoAConsultar = new UsuarioDTO();
  		dtoAConsultar.setCedulaUsuario(cedulaDigitada);
  		dtoAConsultar.setEmailUsuario(correoDigitado);
  		dtoAConsultar.setNombreUsuario(nombreDigitado);
  		dtoAConsultar.setPassword(contrasenaDigitada);
  		dtoAConsultar.setUsuario(usuarioDigitado);
		
		if (consultar !=null) {
      		if(cedulaDigitada !=null){
	      		
	      		dtoConsultado=logica.consultarPorCedula(dtoAConsultar);
      		}
      		
		}else if(crear != null){
			boolean existeUsuario = logica.crear(dtoAConsultar);
		
		}else if(actualizar != null){
			boolean existeUsuario = logica.actualizar(dtoAConsultar);
		}
		else if (borrar !=null) {
			boolean usuarioBorrado = logica.borrar(dtoAConsultar);
		}
      %>
       <div class="containerb">
        <div class="button_encabezado">
          <button onclick="location.href='/frontend/menuUsuarios/menuUsuarios.jsp'">Usuarios</button>
          <button onclick="location.href='/frontend/menuClientes/menuClientes.jsp'">Clientes</button> 
          <button onclick="location.href='/frontend/menuProveedores/menuProveedores.jsp'">Proveedores</button>
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
            <input type="number" id="txtCedula" required="required" name="txtCedula" maxlength="20" placeholder="Digite su cédula" value="<%= dtoConsultado !=null && dtoConsultado.getCedulaUsuario() !=null?dtoConsultado.getCedulaUsuario():"" %>">
          </div>
          <div class="input-box">
            <span class="details">Usuario</span>
            <input type="text" id="txtUsuario" name="txtUsuario" maxlength="255" placeholder="Digite su usuario" value="<%= dtoConsultado !=null && dtoConsultado.getUsuario() !=null?dtoConsultado.getUsuario():"" %>">
          </div>
          <div class="input-box">
            <span class="details">Nombre Completo</span>
            <input type="text" id="txtNombre" name="txtNombre" maxlength="255" placeholder="Digite su nombre" value="<%= dtoConsultado !=null && dtoConsultado.getNombreUsuario() !=null?dtoConsultado.getNombreUsuario():"" %>">
          </div>
          <div class="input-box">
            <span class="details">Contraseña</span>
            <input type="password" id="pwdContrasena" name="pwdContrasena" maxlength="255" placeholder="Digite su contraseña" value="<%= dtoConsultado !=null && dtoConsultado.getPassword() !=null?dtoConsultado.getPassword():"" %>">
          </div>
          <div class="input-box">
            <span class="details">Correo Electrónico</span>
            <input type="email" id="emCorreo" name="emCorreo" maxlength="255" placeholder="Digite su correo electrónico" value="<%= dtoConsultado !=null && dtoConsultado.getEmailUsuario() !=null?dtoConsultado.getEmailUsuario():"" %>">
          </div>
         </div>
        
          <div class="button">
          <input type="submit" value="Consultar" name="Consultar">
          <input type="submit" value="Crear" name="Crear" onclick="return confirmacionCampos(event)">
          <input type="submit" value="Actualizar" name="Actualizar" onclick="return confirmacionCampos(event)">
          <input type="submit" value="Borrar" onclick="confirmacionBorrar(event)" name="Borrar">

        </div>
      </form>
    </div>
  </div>
</body>
</html>