package com.controlador;

import javax.naming.InitialContext;

import com.services.AnalistaBeanRemote;
import com.services.AreaTutorBeanRemote;
import com.services.ConvocatoriaAsistenciaBeanRemote;
import com.services.DepartamentoBeanRemote;
import com.services.EstadoAsistenciaBeanRemote;
import com.services.EstadosEventosBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.EventoBeanRemote;
import com.services.GeneroBeanRemote;
import com.services.ITRBeanRemote;
import com.services.InscripcionBeanRemote;
import com.services.MateriaBeanRemote;
import com.services.MatriculaBeanRemote;
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
	public static EstadosEventosBeanRemote estadosEventoRemote;
	public static ModalidadesEventosBeanRemote modalidadEventoRemote;
	public static ConvocatoriaAsistenciaBeanRemote conAsistenciaBean;
	public static EstudianteBeanRemote estudianteBean;
	public static EstadoAsistenciaBeanRemote estadoAsistenciaBean;
	public static MateriaBeanRemote materiaBean;
	public static InscripcionBeanRemote  inscripcionBean;
	public static MatriculaBeanRemote  matriculaBean;
	
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
			estadosEventoRemote=(EstadosEventosBeanRemote) InitialContext.doLookup("ejb:/Proyecto-5bit/EstadosEventosBean!com.services.EstadosEventosBeanRemote");
			modalidadEventoRemote=(ModalidadesEventosBeanRemote) InitialContext.doLookup("ejb:/Proyecto-5bit/ModalidadesEventosBean!com.services.ModalidadesEventosBeanRemote");
			conAsistenciaBean = (ConvocatoriaAsistenciaBeanRemote) InitialContext.doLookup(
					"ejb:/Proyecto-5bit/ConvocatoriaAsistenciaBean!com.services.ConvocatoriaAsistenciaBeanRemote");
			estudianteBean = (EstudianteBeanRemote) InitialContext.doLookup(
					"ejb:/Proyecto-5bit/EstudianteBean!com.services.EstudianteBeanRemote");
			estadoAsistenciaBean = (EstadoAsistenciaBeanRemote) InitialContext.doLookup(
					"ejb:/Proyecto-5bit/EstadoAsistenciaBean!com.services.EstadoAsistenciaBeanRemote");
			materiaBean=(MateriaBeanRemote) InitialContext.doLookup(
					"ejb:/Proyecto-5bit/MateriaBean!com.services.MateriaBeanRemote");
			inscripcionBean=(InscripcionBeanRemote) InitialContext.doLookup(
					"ejb:/Proyecto-5bit/InscripcionBean!com.services.InscripcionBeanRemote");
			
			matriculaBean=(MatriculaBeanRemote) InitialContext.doLookup(
					"ejb:/Proyecto-5bit/MatriculaBean!com.services.MatriculaBeanRemote");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
