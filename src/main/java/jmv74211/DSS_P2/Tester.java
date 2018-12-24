package jmv74211.DSS_P2;


import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Tester {
	
	
	private static ArrayList<Article> parseJsonToObject(String text) throws JsonParseException, JsonMappingException, IOException{
		
		ArrayList<Article> objectList = new ArrayList<Article>();
		
		 String[] parts = text.split("}");
		 ObjectMapper mapper = new ObjectMapper();
		 
		 for(int i = 0; i<parts.length-1; i++){
			 String jsonString= parts[i].substring(1, parts[i].length()) + "}";  
			 Article obj = mapper.readValue(jsonString, Article.class);
			 objectList.add(obj);
		 }
		
		return objectList;
		
	}
	
	private static String parseObjectToJson(ArrayList<Article> articles) throws JsonProcessingException{
		
		String jsonText="";
		ObjectMapper mapper = new ObjectMapper();
		
		for(Article a: articles){
			jsonText += mapper.writeValueAsString(articles) + ",";
		}
		
		jsonText = jsonText.substring(0, jsonText.length()-1);
		
		return jsonText;
		
	}
	
	private static String parseObjectToJson(Article article) throws JsonProcessingException{
		
		String jsonText="";
		ObjectMapper mapper = new ObjectMapper();
		
		jsonText += mapper.writeValueAsString(article);
		
		
		return jsonText;
		
	}
	
	private static void printListArticles() throws JsonParseException, JsonMappingException, IOException{
		
		ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget service = client.target("http://localhost:8080/DSS_P2/webapi");
		
		  // Se realiza una petición GET para listar los artículos
        String response = service.path("articles").request().accept(MediaType.APPLICATION_JSON).get(String.class);
        
        // Se parsea el JSON devuelto y se convierte en objetos
        ArrayList<Article> articles = Tester.parseJsonToObject(response);
		
		System.out.println("////////////////////////////////////////");
		System.out.println(" La lista de artículos es la siguiente  ");
		System.out.println("////////////////////////////////////////");
        for(Article a: articles){
        	System.out.println(a);
        }
        
	}

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		
		// Referencia de https://howtodoinjava.com/jersey/jersey-restful-client-examples/
		
		ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget service = client.target("http://localhost:8080/DSS_P2/webapi");
        
        // Se realiza una petición GET para listar los artículos
        String response = service.path("articles").request().accept(MediaType.APPLICATION_JSON).get(String.class);
        
        // Se parsea el JSON devuelto y se convierte en objetos
        ArrayList<Article> objectList = Tester.parseJsonToObject(response);
      
        // Se imprime la lista
        Tester.printListArticles();
        
        // Se crea un nuevo objeto que vamos a insertar posteriormente mediante PUT
        
        ArrayList<String>imagesList = new ArrayList<String>();
		ArrayList<String>commentList = new ArrayList<String>();
		
		Article object4 = new Article();
		
		object4.setId(4);
		object4.setTitle("Mundial de Clubes 2018 Modric: Todos me dicen que tire más, pero me gusta más dar pases a mis compañeros");
		object4.setHeader("Otro golazo de 'francotirador' de Modric: lleva 12 de 14 goles desde fuera del área");
		
		imagesList.add("https://e00-marca.uecdn.es/assets/multimedia/imagenes/2018/12/22/15455154056641.jpg");
		commentList.add("Es un jugador fantástico");
		commentList.add("Haz lo que quieras Modric. Como si te quieres venir al Betis");
		
		object4.setImages(imagesList);
		object4.setComments(commentList);
		object4.setDate("2018-12-22");
		object4.setTextDescription("Luka Modric habló tras levantar otro título en los micrófonos de Realmadrid Televisión. \n"
				+ "El croata explicó su gol y recordó que acaba un año que nunca olvidará.La final: Hemos hecho un partido muy serio desde el"
				+ "primer minuto y estoy muy contento. Hemos ganado el tercer Mundial consecutivo, nos va a dar confianza para el futuro.");   
		
		
		System.out.println("\n\n\n////////////////////////////////////////");
		System.out.println("       Añadimos un nuevo artículo       ");
		System.out.println("////////////////////////////////////////\n\n\n");
		
		// REALIZAMOS PUT PARA CREAR UN NUEVO ARTÍCULO
		// Referencia https://howtodoinjava.com/jersey/jersey-restful-client-examples/
		Response putRequest = service.path("/articles").request().accept(MediaType.APPLICATION_JSON)
				.put(Entity.entity(object4, MediaType.APPLICATION_JSON));

		
		// Se realiza una petición GET para listar los artículos
        response = service.path("articles").request().accept(MediaType.APPLICATION_JSON).get(String.class);
        
        // Se parsea el JSON devuelto y se convierte en objetos
        objectList = Tester.parseJsonToObject(response);
      
        // Se imprime la lista
        Tester.printListArticles();
        
        
        
        // REALIZAMOS POST PARA MODIFICAR UN NUEVO ARTÍCULO
        System.out.println("\n\n\n////////////////////////////////////////");
		System.out.println("        Modificamos el artículo #4            ");
		System.out.println("////////////////////////////////////////\n\n\n");
		
        String articleId = "4"; // Identificador del artículo que queremos mostrar
        
        object4.setTitle("ESTE ES EL TÍTULO MODIFICADO");
        object4.setHeader("Esta es la cabecera modificada");
        object4.setDate("2018-12-25");
        
        Response postRequest = service.path("articles").path(articleId).request().accept(MediaType.APPLICATION_JSON)
        		.post(Entity.entity(Tester.parseObjectToJson(object4), MediaType.APPLICATION_JSON));
        
        System.out.println(postRequest.getStatus());
        // Se imprime la lista
        Tester.printListArticles();	
       
        
        // REALIZAMOS DELETE PARA ELIMINAR UN NUEVO ARTÍCULO
        System.out.println("\n\n\n////////////////////////////////////////");
		System.out.println("        Eliminamos el artículo #4            ");
		System.out.println("////////////////////////////////////////\n\n\n");
		
		
		Response deleteRequest = service.path("articles").path(articleId).request().accept(MediaType.APPLICATION_JSON)
        		.delete();
        // Se imprime la lista
        Tester.printListArticles();
        
	}
}
