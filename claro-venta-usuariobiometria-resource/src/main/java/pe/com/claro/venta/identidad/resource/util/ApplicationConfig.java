package pe.com.claro.venta.identidad.resource.util;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//import java.util.Set;
//import java.util.stream.Collectors;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import pe.com.claro.venta.usuariobiometria.common.property.Constantes;

@Singleton
@ApplicationPath(Constantes.API)
public class ApplicationConfig extends Application {

//	@Override
//	public Set<Class<?>> getClasses() {

//		Set<Class<?>> resources = new java.util.HashSet<>();
//		resources.add(IdentidadResource.class);
//		resources.add(com.wordnik.swagger.jaxrs.listing.ApiListingResource.class);
//		resources.add(com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider.class);
//		resources.add(com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON.class);
//		resources.add(com.wordnik.swagger.jaxrs.listing.ResourceListingProvider.class);
//		resources.add(ProviderExceptionMapper.class);
//
//		return resources;
//	}

//	@Override
//	public Map<String, Object> getProperties(){
//		String nombrePropertieExterno = Constantes.PROPERTIESEXTERNOS;
//		Map<String, Object> dataProperties = new HashMap<>();
//		dataProperties.putAll(readProperties(nombrePropertieExterno, false));
//		return dataProperties;
//	}
//
//	private Map<String, Object> readProperties(String fileInClasspath, Boolean interno)  {
//		InputStream is = null;
//		try {
//			if (interno) {
//				is = this.getClass().getClassLoader().getResourceAsStream(fileInClasspath);
//			} else {
//				is = new FileInputStream(System.getProperty(Constantes.PROPERTIESKEY) + Constantes.NOMBRESERVICIOREST
//						+ File.separator + fileInClasspath);
//			}
//			Map<String, Object> map = new HashMap<>();
//			Properties properties = new Properties();
//			properties.load(is);
//			map.putAll(properties.entrySet().stream()
//					.collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue())));
//			return map;
//		} catch (Exception e) {
//			throw new RuntimeException("No se puede leer el archivo " + fileInClasspath);
//		}
//	}

}
