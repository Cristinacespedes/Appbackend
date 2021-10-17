<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.ubosque.mintic.frontend.logica.ProveedorLogica" %>
<%@ page import="com.ubosque.mintic.frontend.dto.ProveedorDTO" %>
<!DOCTYPE html>

  <head>
    <meta charset="UTF-8">
    <title> Tienda Genérica | Proveedores </title>
    <link rel="stylesheet" type="text/css" href="css/style1.css">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <script type="text/javascript" src="./alertas.js"></script>
   </head>
<body>
  <div class="content">
      <form method="post" action="">
      <%
      ProveedorDTO dto = new ProveedorDTO();
      ProveedorLogica logica = new ProveedorLogica();
      
      	String consultar = request.getParameter("Consultar");
		String crear = request.getParameter("Crear");
		String actualizar = request.getParameter("Actualizar");
		String borrar = request.getParameter("Borrar");
		
		String nitDigitado = request.getParameter("txtNit");
		String telefonoDigitado = request.getParameter("txtTelefono");
		String nombreDigitado = request.getParameter("txtNombre");
		String ciudadDigitada = request.getParameter("txtCiudad");
		String direcccionDigitada = request.getParameter("txtDireccion");
		
		dto.setNitProveedor(nitDigitado);
		dto.setTelefonoProveedor(telefonoDigitado);
		dto.setNombreProveedor(nombreDigitado);
		dto.setCiudadProveedor(ciudadDigitada);
		dto.setDireccionProveedor(direcccionDigitada);
		
		ProveedorDTO proveedorConsultado = new ProveedorDTO();
      
      if(consultar !=null){
		proveedorConsultado = logica.consultarPorNit(dto);
      } else if (crear !=null){
    	  boolean existeProveedor = logica.crear(dto);
      } else if (actualizar != null){
    	  boolean actualizoProveedor = logica.actualizar(dto);
      }else if (borrar !=null){
    	  boolean borroProveedor = logica.borrar(dto);
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
   <div class="container">
    <div class="title">Proveedores</div>
    <div class="content">
      <form action="">
        <div class="user-details">
          <div class="input-box">
            <span class="details">NIT</span>
            <input type="number" id="txtNit" name="txtNit" placeholder="Digite el NIT" required="required" maxlength="20" placeholder="Digite el NIT" value="<%= proveedorConsultado!=null && proveedorConsultado.getNitProveedor() !=null?proveedorConsultado.getNitProveedor():""%>">
          </div>
          <div class="input-box">
            <span class="details">Teléfono</span>
            <input type="text" id="txtTelefono" name="txtTelefono" placeholder="Digite el teléfono" value="<%= proveedorConsultado!=null && proveedorConsultado.getTelefonoProveedor() !=null?proveedorConsultado.getTelefonoProveedor():""%>">
          </div>
          <div class="input-box">
            <span class="details">Nombre Proveedor</span>
            <input type="text" id="txtNombre" name="txtNombre" placeholder="Digite el proveedor" value="<%= proveedorConsultado!=null && proveedorConsultado.getNombreProveedor() !=null?proveedorConsultado.getNombreProveedor():""%>">
          </div>
          <div class="input-box">
            <span class="details">Ciudad</span>
            <input type="text" id="txtCiudad" name="txtCiudad" placeholder="Digite la ciudad" value="<%= proveedorConsultado!=null && proveedorConsultado.getCiudadProveedor() !=null?proveedorConsultado.getCiudadProveedor():""%>">
          </div>
          <div class="input-box">
            <span class="details">Dirección</span>
            <input type="text" id="txtDireccion" name="txtDireccion" placeholder="Digite la dirección" value="<%= proveedorConsultado!=null && proveedorConsultado.getDireccionProveedor() !=null?proveedorConsultado.getDireccionProveedor():""%>">
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
