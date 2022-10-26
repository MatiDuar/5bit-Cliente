package com.controlador;

import javax.naming.InitialContext;

import com.services.UsuarioBeanRemote;

public class DAOUsuario {
	InitialContext ic;
	public static UsuarioBeanRemote usuarioRemote;
	
	
	public DAOUsuario ( ) {
		try {
			usuarioRemote = (UsuarioBeanRemote)InitialContext.doLookup("ejb:/Proyecto-5bit/UsuarioBean!com.services.UsuarioBeanRemote");		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
