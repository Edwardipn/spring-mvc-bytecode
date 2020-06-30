package com.spring.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
En Spring Boot, es muy común que se apliquen múltiples anotaciones sobre la clase principal (main). Pero comúnmente, la mayoría de desarrolladores, aplican principalmente 3 anotaciones.

@Configuration: Disponible a partir de la versión 3 de Spring, nos ofrece la posibilidad de realizar una notación que será la encargada de definir a la clase que lo posea como una clase de configuración. Esta configuración para el framework de Spring, estará basada en anotaciones. Y no como en sus orígenes, que estaba basada en XML, lo que lo hacía más complejo. La finalidad de dicha anotación también será el permitir realizar la inyección de dependencias.
@EnableAutoConfiguration: La configuración automática de Spring Boot, intenta configurar automáticamente su aplicación Spring en función de las dependencias jar que haya agregado. Si por ejemplo, si HSQLDB (sistema gestor de bases de datos) está en su ruta de clase y no ha configurado manualmente ningún bean de conexión de base de datos, Spring Boot configura automáticamente una base de datos en memoria.
@ComponentScan: Se utiliza junto a @Configuration para indicar a Spring donde debe buscar los componentes y será dentro del package que tenemos anotado. Por solo tener que anotarla una vez, poder hacer que todos los packages sean hijos del package de la clase padre (el que contenga el main).
Es podría ser un ejemplo de la clase principal (main) de nuestro proyecto con las 3 anotaciones:
*/

/*
La gran mayoría de desarrolladores de Spring Boot, suelen tener en su clase principal (main) anotada con las anotaciones @Configuration, @EnableAutoConfiguration y @ComponentScan. Dado que estas anotaciones se combinan con tanta frecuencia, Spring Boot ofrece el substituir tener que declarar constantemente este tridente de anotaciones, por declarar únicamente una sola @SpringBootApplication que englobará a las 3 anteriores.

Lo más destacado aquí es la anotación @SpringBootApplication . Esto internamente es una combinación de las siguientes 3 anotaciones. Y en forma de resumen más simplificado realiza:

@Configuración: Necesaria para configuraciones de resorte manual. La adición de esta anotación garantiza que la configuración se puede realizar en una clase Java en lugar de usar un archivo xml separado.
@EnableAutoConfiguration: Spring necesita mucha configuración por hacer. Esta anotación asegura que gran parte de la configuración se realiza automáticamente.
@ComponentScan: Esto le dice a Spring, donde todos deben buscar componentes.
Los siguientes son los parámetros aceptados en la anotación @SpringBootApplication:

excluir: excluye la lista de clases de la configuración automática.
excludeNames: excluye la lista de nombres de clase totalmente calificados de la configuración automática. Este parámetro agregado desde Spring Boot 1.3.0.
scanBasePackageClasses: proporcione la lista de clases que se deben aplicar para @ComponentScan.
scanBasePackages: Proporciona la lista de paquetes que se deben aplicar para @ComponentScan. Este parámetro agregado desde el arranque de primavera 1.3.0.
Actualmente, al realizar un proyecto este es el que nos viene por defecto, y por tanto, es el que nosotros tenemos en nuestro proyecto. Está podría ser un ejemplo de la clase principal (main) de nuestro proyecto con la anotación que engloba a las 3 anotaciones anteriores:
*/	
	
@SpringBootApplication
public class SpringMvcPiTestApplication {

	public static void main(String[] args) {
		/*
		 * Static helper that can be used to run a SpringApplication from thespecified
		 * source using default settings. Parameters:primarySource the primary source to
		 * loadargs the application arguments (usually passed from a Java main
		 * method)Returns:the running ApplicationContext
		 */
		SpringApplication.run(SpringMvcPiTestApplication.class, args);
	}

}
