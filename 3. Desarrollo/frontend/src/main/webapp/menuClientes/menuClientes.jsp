<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.ubosque.mintic.frontend.logica.ClienteLogica" %>
<%@ page import="com.ubosque.mintic.frontend.dto.ClienteDTO" %>
<!DOCTYPE html>

  <head>
    <meta charset="UTF-8">
    <title> Tienda Genérica | Clientes </title>
    <link rel="stylesheet" type="text/css" href="css/style1.css">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <script type="text/javascript" src="./alertas.js"></script>
   </head>
<body>
     <div class="content">
      <form method="post" action="">
      <%
      ClienteDTO dto = new ClienteDTO();
      ClienteLogica logica = new ClienteLogica();
      
      	String consultar = request.getParameter("Consultar");
		String crear = request.getParameter("Crear");
		String actualizar = request.getParameter("Actualizar");
		String borrar = request.getParameter("Borrar");
		
		String cedulaDigitada = request.getParameter("txtCedula");
		String direccionDigitada = request.getParameter("txtDireccion");
		String correoDigitado = request.getParameter("emCorreo");
		String nombreDigitado = request.getParameter("txtNombre");
		String telefonoDigitado = request.getParameter("txtTelefono");
		
		dto.setCedulaCliente(cedulaDigitada);
		dto.setDireccionCliente(direccionDigitada);
		dto.setEmailCliente(correoDigitado);
		dto.setNombreCliente(nombreDigitado);
		dto.setTelefonoCliente(telefonoDigitado);
		
		ClienteDTO clienteConsultado = new ClienteDTO();
      
      if(consultar !=null){
		clienteConsultado = logica.consultarPorCedula(dto) ;
      } else if (crear !=null){
    	  boolean existeCliente = logica.crear(dto);
      } else if (actualizar != null){
    	  boolean actualizoCliente = logica.actualizar(dto);
      }else if (borrar !=null){
    	  boolean borroCliente = logica.borrar(dto);
      }
      
      %>
       <div class="containerb">
        <div class="button">
          <button onclick="location.href='/frontend/menuUsuarios/menuUsuarios.jsp'">Usuarios</button>
          <button onclick="location.href='/frontend/menuClientes/menuClientes.jsp'">Clientes</button> 
          <button onclick="location.href='/frontend/menuProveedores/menuProveedores.jsp'">Proveedores</button>
		  <button onclick="location.href='/frontend/menuProductos/menuProductos.html'">Productos</button> 
		  <button onclick="location.href='/frontend/menuVentas/menuVentas.html'">Ventas</button>
		  <button onclick="location.href='/frontend/menuReportes/menuReportes.html'">Reportes</button>
       </div>
     </div>
       <div class="content">
       <form action="">
         <div class="container">
         <div class="title">Clientes</div>
          <div class="user-details">
           <div class="input-box">
            <span class="details">Cédula</span>
            <input type="number" name="txtCedula" placeholder="Digite la cédula" required value="<%= clienteConsultado!=null && clienteConsultado.getCedulaCliente() !=null?clienteConsultado.getCedulaCliente():""%>">
          </div>
          <div class="input-box">
            <span class="details">Teléfono</span>
            <input type="text" id="txtTelefono" name="txtTelefono" placeholder="Digite el teléfono" value="<%= clienteConsultado!=null && clienteConsultado.getTelefonoCliente() !=null?clienteConsultado.getTelefonoCliente(): ""%>"> 
          </div>
          <div class="input-box">
            <span class="details">Nombre Completo</span>
            <input type="text" id="txtNombre" name="txtNombre" placeholder="Digite el nombre" value="<%= clienteConsultado!=null && clienteConsultado.getNombreCliente() !=null?clienteConsultado.getNombreCliente(): ""%>">
          </div>
          <div class="input-box">
            <span class="details">Correo Electrónico</span>
            <input type="text" id="emCorreo" name="emCorreo"placeholder="Digite el correo electrónico" value="<%= clienteConsultado!=null && clienteConsultado.getEmailCliente() !=null?clienteConsultado.getEmailCliente(): ""%>">
          </div>
          <div class="input-box">
            <span class="details">Dirección</span>
            <input type="text" id="txtDireccion" name="txtDireccion" placeholder="Digite la dirección" value="<%= clienteConsultado!=null && clienteConsultado.getDireccionCliente() !=null?clienteConsultado.getDireccionCliente(): ""%>">
          </div>
         </div>
        
          <div class="button">
          <input type="submit" value="Consultar" name="Consultar">
          <input type="submit" value="Crear" name="Crear" onclick="return confirmacionCampos(event)">
          <input type="submit" value="Actualizar" name="Actualizar" onclick="return confirmacionCampos(event)">
          <input type="submit" value="Borrar" name="Borrar" onclick="confirmacionBorrar(event)">
          

        </div>
      </form>
    </div>
  </div>
</body>
</html>
