function noExiste() {
	alert("Usuario Inexistente");
}
function usuarioCreado() {
	alert("Usuario Creado");
}

function errorCrear() {
	alert("Faltan datos del usuario");
}

function confirmacionBorrar(e) {
	var resultado = window.confirm('Estas seguro de borrar al usuario?');
	
	if(!resultado){
		e.preventDefault() ;
            returnToPreviousPage();
		return false;
	} return resultado;
}

function confirmacionCampos(e){
	var txtUsuario = document.getElementById("txtUsuario").value;
	if(txtUsuario==null || txtUsuario==""){
		alert("Campo usuario requerido");
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
	var pwdContrasena = document.getElementById("pwdContrasena").value;
	if(pwdContrasena==null  || pwdContrasena==""){
		alert("Campo contraseña requerido");
		e.preventDefault() ;
            returnToPreviousPage();
		return false;
		}
	var emCorreo = document.getElementById("emCorreo").value;
	if(emCorreo==null  || emCorreo==""){
		alert("Campo correo requerido");
		e.preventDefault() ;
            returnToPreviousPage();
		return false;
		}
}