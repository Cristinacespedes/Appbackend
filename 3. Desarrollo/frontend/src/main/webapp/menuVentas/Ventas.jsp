<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ubosque.mintic.frontend.logica.ClienteLogica" %>
<%@ page import="com.ubosque.mintic.frontend.dto.ClienteDTO" %>
<%@ page import="com.ubosque.mintic.frontend.logica.ProductoLogica" %>
<%@ page import="com.ubosque.mintic.frontend.dto.ProductoDTO" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/Style2.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="./alertas.js"></script>
	<meta charset="ISO-8859-1">
	<title>Tienda Generica | Ventas</title>
</head>
<body>
	<div class="content">
    	<form method="post" action="">
	      <%
	      ClienteDTO dto = new ClienteDTO();
	      ClienteLogica logica = new ClienteLogica();
	      
    	  String consultar = request.getParameter("consultarCliente");
    	  
    	  String cedulaDigitada = request.getParameter("txtCedula");
    	  
    	  dto.setCedulaCliente(cedulaDigitada);
    	  
    	  ClienteDTO clienteConsultado = new ClienteDTO();
    	  
          if(consultar !=null){
    		clienteConsultado = logica.consultarPorCedula(dto) ;
          }
          
    	  %>
    	  
    	
    	
    	
    	
    	
    	
    		<div class="containerb">
    			<div class="button_encabezado">
    				<input type="submit" formnovalidate="formnovalidate" formaction="/frontend/menuUsuarios/menuUsuarios.jsp" value="Usuarios">
          			<input type="submit" formnovalidate="formnovalidate" formaction="/frontend/menuClientes/menuClientes.jsp" value="Clientes">
          			<input type="submit" formnovalidate="formnovalidate" formaction="/frontend/menuProveedores/menuProveedores.jsp" value="Proveedores">
		  			<input type="submit" formnovalidate="formnovalidate" formaction="/frontend/menuProductos/menuProductos.html" value="Productos">
					<input type="submit" formnovalidate="formnovalidate" formaction="/frontend/menuVentas/menuVentas.html" value="Ventas">
		 			<input type="submit" formnovalidate="formnovalidate" formaction="/frontend/menuReportes/menuReportes.html" value="Reportes">
       			</div>
    		</div>
    		<div class="container">
    			<div class="title">VENTAS</div>
   					<div class="content">
   						<div class="user-details">
	   						<div class="input-box">
	            				<table>
	            					<tr>
	            						<td><label>Cédula</label></td>
	            						<td><input type="text" name="txtCedula" placeholder="Cedula Cliente" required="required" value="<%= clienteConsultado.getCedulaCliente() !=null?clienteConsultado.getCedulaCliente(): ""%>"></td>
	            						<td><input type="submit" name="consultarCliente" value="Consultar"></td>
	            						<td><label>Cliente</label></td>
	            						<td><input type="text" name="cliente" disabled="disabled" value="<%= clienteConsultado.getNombreCliente() !=null?clienteConsultado.getNombreCliente(): ""%>"></td>
	            						<td><label>Consec</label></td>
	            						<td width="10%"><input type="text" name="consec" disabled="disabled" value=""></td>
	            					</tr>
	            				</table>
	            				<table cellspacing="5" BORDER="0" >
	            					<tr>
	            						<td colspan="2"><strong>Codigo</strong></td>
	            						<td align="center"><strong>Nombre Producto</strong></td>
	            						<td align="center"><strong>Cantidad</strong></td>
	            						<td align="center"><strong>Valor Total</strong></td>
	            					</tr>
	            					<tr>
	            						<td width="10%"><input type="number" name="codigo1"></td>
	            						<td><input type="submit" name="consultarProducto1" value="Consultar" ></td>
	            						<td width="45%"><input type="text" name="producto" disabled="disabled" value=""></td>
	            						<td width="10%"><input type="text" name="cantidad"></td>
	            						<td width="32%"><input type="text" name="valorTotal" disabled="disabled" ></td>
	            					</tr>
	            					<tr>
	            						<td width="10%"><input type="number" name="codigo2"></td>
	            						<td><input type="submit" name="consultarProducto2" value="Consultar" ></td>
	            						<td width="45%"><input type="text" name="producto" disabled="disabled" ></td>
	            						<td width="10%"><input type="text" name="cantidad"></td>
	            						<td width="32%"><input type="text" name="valorTotal" disabled="disabled" ></td>
	            					</tr>
	            					<tr>
	            						<td width="10%"><input type="number" name="codigo3"></td>
	            						<td><input type="submit" name="consultarProducto3" value="Consultar" ></td>
	            						<td width="45%"><input type="text" name="producto" disabled="disabled" ></td>
	            						<td width="10%"><input type="text" name="cantidad"></td>
	            						<td width="32%"><input type="text" name="valorTotal" disabled="disabled" ></td>
	            					</tr>
	            					<tr>
	            						<td colspan="4" align="right">Total Venta</td>
	            						<td><input type="text" name="vlr Total" disabled="disabled"></td>
	            					</tr>
	            					<tr>
	            						<td colspan="4" align="right">Total IVA</td>
	            						<td><input type="text" name="totalVenta" disabled="disabled"></td>
	            					</tr>
	            					<tr>
	            						<td colspan="3" align="right"><input type="submit" name="confirmar" value="Confirmar" ></td>
	            						<td>Total Con IVA</td>
	            						<td><input type="text" name="totalConIva" disabled="disabled"></td>
	            					</tr>
	            				</table>
	         				</div>
	         			</div>
	         		</div>
	         	</div>		
    	</form>
	</div>
</body>
</html>