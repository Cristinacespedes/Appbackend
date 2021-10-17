function noExiste() {
	alert("Proveedor no existe")
	var vacio="";
	return vacio;
}

function proveedorCreado() {
	alert("Cliente Creado");
}

function errorCrear() {
	alert("Faltan datos del proveedor")
	var vacio="";
	return vacio;
}

function confirmacionBorrar(e) {
	var resultado = window.confirm('Estas seguro de borrar al proveedor?');
	
	if(!resultado){
		e.preventDefault() ;
            returnToPreviousPage();
		return false;
	} return resultado;
}

function confirmacionCampos(e){
	var txtTelefono = document.getElementById("txtTelefono").value;
	if(txtTelefono==null || txtTelefono==""){
		alert("Campo telefono requerido");
		e.preventDefault() ;
            returnToPreviousPage();
		return false;
	}
	var txtNombre = document.getElementById("txtNombre").value;
	if(txtNombre==null  || txtNombre==""){
		alert("Campo nombre requerido");
		e.preventDefault() ;
            returnToPreviousPage();
		return false;
		}
	var txtCiudad = document.getElementById("txtCiudad").value;
	if(txtCiudad==null  || txtCiudad==""){
		alert("Campo ciudad requerido");
		e.preventDefault() ;
            returnToPreviousPage();
		return false;
		}
	var txtDireccion = document.getElementById("txtDireccion").value;
	if(txtDireccion==null  || txtDireccion==""){
		alert("Campo direccion requerido");
		e.preventDefault() ;
            returnToPreviousPage();
		return false;
		}
}