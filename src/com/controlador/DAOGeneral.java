package com.controlador;

import javax.naming.InitialContext;

import com.services.AnalistaBeanRemote;
import com.services.AreaTutorBeanRemote;
import com.services.ConvocatoriaAsistenciaBeanRemote;
import com.services.DepartamentoBeanRemote;
import com.services.EstadosEventosBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.EventoBeanRemote;
import com.services.GeneracionBeanRemote;
import com.services.GeneroBeanRemote;
import com.services.ITRBeanRemote;
import com.services.ModalidadesEventosBeanRemote;
import com.services.TipoActividadBeanRemote;
import com.services.TipoTutorBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;

public class DAOGeneral {

	public static TipoActividadBeanRemote tipoActividadRemote;
	public static DepartamentoBeanRemote DepRemote;
	public static GeneroBeanRemote generoRemote ;
	public static ITRBeanRemote itrRemote;
	public static TipoTutorBeanRemote tipoTutorRemote;
	public static AreaTutorBeanRemote areaTutorRemote;
	public static UsuarioBeanRemote usuarioRemote;
	public static EventoBeanRemote eventoRemote;
	public static AnalistaBeanRemote analistaRemote;
	public static TutorBeanRemote tutorRemote;
	public static GeneracionBeanRemote generacionRemote;
	public static EstadosEventosBeanRemote estadosEventoRemote;
	public static ModalidadesEventosBeanRemote modalidadEventoRemote;
	public static ConvocatoriaAsistenciaBeanRemote conAsistenciaBean;
	public static EstudianteBeanRemote estudianteBean;
	
	public DAOGeneral ( ) {
		try {
			tipoActividadRemote = (TipoActividadBeanRemote) InitialContext.doLookup("ejb:/Proyecto-5bit/TipoActividadBean!com.services.TipoActividadBeanRemote");
			DepRemote= (DepartamentoBeanRemote) InitialContext.doLookup("ejb:/Proyecto-5bit/DepartamentoBean!com.services.DepartamentoBeanRemote");
			generoRemote = (GeneroBeanRemote) InitialContext.doLookup("ejb:/Proyecto-5bit/GeneroBean!com.services.GeneroBeanRemote");
			itrRemote= (ITRBeanRemote) InitialContext.doLookup("ejb:/Proyecto-5bit/ITRBean!com.services.ITRBeanRemote");
			tipoTutorRemote = (TipoTutorBeanRemote) InitialContext.doLookup("ejb:/Proyecto-5bit/TipoTutorBean!com.services.TipoTutorBeanRemote");
			areaTutorRemote=(AreaTutorBeanRemote) InitialContext.doLookup("ejb:/Proyecto-5bit/AreaTutorBean!com.services.AreaTutorBeanRemote");
			usuarioRemote = (UsuarioBeanRemote) InitialContext.doLookup("ejb:/Proyecto-5bit/UsuarioBean!com.services.UsuarioBeanRemote");		
			eventoRemote=(EventoBeanRemote) InitialContext.doLookup("ejb:/Proyecto-5bit/EventoBean!com.services.EventoBeanRemote");
			analistaRemote=(AnalistaBeanRemote) InitialContext.doLookup("ejb:/Proyecto-5bit/AnalistaBean!com.services.AnalistaBeanRemote");
			tutorRemote=(TutorBeanRemote) InitialContext.doLookup("ejb:/Proyecto-5bit/TutorBean!com.services.TutorBeanRemote");
			generacionRemote=(GeneracionBeanRemote) InitialContext.doLookup("ejb:/Proyecto-5bit/GeneracionBean!com.services.GeneracionBeanRemote");
			estadosEventoRemote=(EstadosEventosBeanRemote) InitialContext.doLookup("ejb:/Proyecto-5bit/EstadosEventosBean!com.services.EstadosEventosBeanRemote");
			modalidadEventoRemote=(ModalidadesEventosBeanRemote) InitialContext.doLookup("ejb:/Proyecto-5bit/ModalidadesEventosBean!com.services.ModalidadesEventosBeanRemote");
			conAsistenciaBean = (ConvocatoriaAsistenciaBeanRemote) InitialContext.doLookup(
					"ejb:/Proyecto-5bit/ConvocatoriaAsistenciaBean!com.services.ConvocatoriaAsistenciaBeanRemote");
			estudianteBean = (EstudianteBeanRemote) InitialContext.doLookup(
					"ejb:/Proyecto-5bit/EstudianteBean!com.services.EstudianteBeanRemote");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
