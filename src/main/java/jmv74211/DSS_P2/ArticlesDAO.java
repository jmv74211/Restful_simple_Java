package jmv74211.DSS_P2;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.Map;

/**
 *  Clase singleton que representa la estructura de datos que almacena y gestiona 
 *  el conjunto de artículos de fútbol
 *  
 * @author jmv74211
 * @version 1.0
 */

public enum ArticlesDAO {
	
	instance;   // Instancia de la clase singleton
	private Map<Integer,Article> contentData = new HashMap<Integer, Article>(); // Contenedor de datos
	private int numArticles; // Número de artículos en el contenedor de datos.
	
/////////////////////////////////////////////////////////////////////////////
	
/**
 * Constructor de la clase. Inicializa variables y crea dos artículos por defecto.
 * 
 *  @author jmv74211
 *  @version 1.0
 */
	private ArticlesDAO(){
		
		ArrayList<String>imagesList = new ArrayList<String>();
		ArrayList<String>commentList = new ArrayList<String>();
		this.numArticles = 1;
		
		Article object1 = new Article();
		
		object1.setId(1);
		object1.setTitle("Athletic Garitano pierde a Raúl García y Yeray");
		object1.setHeader("Cumplirán sanción por acumulación de amonestaciones ante el Celta");
		
		imagesList.add("https://e00-marca.uecdn.es/assets/multimedia/imagenes/2018/12/22/15455145208452.jpg");
		commentList.add("A ver si Raúl García estando un partido fuera se le aclara la sesera un poco");
		commentList.add("Raul es ejemplo de darlo todo cada partido, pero esto es fútbol,no una maratón y tiene que dar bastante más que lo que está dando");
		
		object1.setImages(imagesList);
		object1.setComments(commentList);
		object1.setDate("2018-12-22");
		object1.setTextDescription("Las vacaciones de Navidad serán largas para Raúl García y Yeray. "
				+ "Ninguno de los dos estará en condición de alinearse en el regreso de la competición (7 de enero) "
				+ "contra el Celta. Centrocampista y central cumplieron ciclo de amonestaciones y se perderán la primera "
				+ "jornada de 2019. Garitano estará en condiciones de recuperarlos para el doble compromiso contra el Sevilla, "
				+ "primero en Copa y tres días después en Liga.\n"
				+ "El Athletic abrió el partido con cinco futbolistas apercibidos de sanción ya que además de Raúl García y Yeray también Beñat,"
				+ "De Marcos y Núñez estaban a una amarilla del castigo.Solo Beñat tuvo minutos y libró la amarilla. "
				+ "Núñez será el sustituto de Yeray en Balaídos mientras que Garitano tendrá que buscar sustituto a Raúl García: "
				+ "Muniain, Guruzeta e incluso De Marcos podrían jugar en esa posición.");
		
		this.contentData.put(this.numArticles,object1);
		this.numArticles++;

		ArrayList<String>imagesList2 = new ArrayList<String>();
		ArrayList<String>commentList2 = new ArrayList<String>();
		
		Article object2 = new Article();
		
		object2.setId(2);
		object2.setTitle("Dembélé se acerca a su mejor versión goleadora");
		object2.setHeader("Suma diez goles y su récord está en doce");
		
		imagesList2.add("https://e00-marca.uecdn.es/assets/multimedia/imagenes/2018/12/22/15455024370656.jpg");
		imagesList2.add("https://www.youtube.com/embed/vgGp_mx_pjE");
		commentList2.add("Dembélé es un crack ,no como el ficticius que necesita a un rival para el rebote y la carambola");
		commentList2.add("Esta última semana ha jugado muy bien, va progresando!");
		object2.setImages(imagesList2);
		object2.setComments(commentList2);
		object2.setDate("2018-12-22");
		
		object2.setTextDescription("Ousmane Dembélé está creciendo a un ritmo meteórico. "
				+ "El futbolista francés ha marcado esta tarde contra el Celta de Vigo en el Camp Nou y ya atesora diez goles en su cuenta personal. "
				+ "El galo ha sumado siete en LaLiga y tres en el resto de competiciones.\n"
				+ "Dembéle va camino de sellar su mejor año como goleador. Su máximo registro llegó en el curso 2015-16, "
				+ "cuando militaba en el Rennes francés. El jugador consiguió esta docena de tantos en 26 partidos. "
				+ "Salvo sorpresa, el culé batirá su récord.");
		
		this.contentData.put(this.numArticles,object2);
		this.numArticles++;
	}
	
/////////////////////////////////////////////////////////////////////////////
	
	/**
	 *  Método para devolver la instancia de la clase
	 * 
	 *  @author jmv74211
	 *  @version 1.0
	 *  @return instancia DAO
	 */
	
	public Map<Integer, Article> getModel(){

		return this.contentData;

	}
	
/////////////////////////////////////////////////////////////////////////////
	
	/**
	 *  Método para devolver una lista con todos los artículos almacenados
	 * 
	 *  @author jmv74211
	 *  @version 1.0
	 *  @return Artículos almacenados en DAO.
	 */
	
	public ArrayList<Article> getAllArticles(){
		
		ArrayList<Article> articlesData = new ArrayList<Article>();
		
		for(Article a: this.getModel().values()){
			System.out.println(a);
			articlesData.add(a);
		}
		
		return articlesData;
	}

/////////////////////////////////////////////////////////////////////////////
	
	/**
	 *  Método para devolver un artículo identificado
	 * 
	 *  @author jmv74211
	 *  @version 1.0
	 *  @param id Identificador del artículo
	 *  @return Artículo identificado por id
	 */
	
	public Article getArticle(int id){
		
		for(Article a: this.getModel().values()){
			if(a.getId()==id)
				return a;
		}

		return null;
	}
	
/////////////////////////////////////////////////////////////////////////////
	
	/**
	 *  Método para contar el número de artículos almacenados
	 * 
	 *  @author jmv74211
	 *  @version 1.0
	 *  @return Número de artículos almacenados
	 */
	
	public int countArticles(){
		return this.contentData.size();
	}
	
/////////////////////////////////////////////////////////////////////////////
	
	/**
	 *  Método para almacenar un nuevo artículo
	 * 
	 *  @author jmv74211
	 *  @version 1.0
	 *  @param newArticle Artículo que se desea almacenar
	 *  @return Número de artículos almacenados
	 */
	
	public void createArticle(Article newArticle){
		this.contentData.put(this.numArticles,newArticle);
		this.numArticles++;
		
	}
	
/////////////////////////////////////////////////////////////////////////////
	
	/**
	 *  Método para eliminar un artículo identificado
	 * 
	 *  @author jmv74211
	 *  @version 1.0
	 *  @param id Identificador del artículo
	 *  @return true si se ha eliminado, false en caso contrario
	 */

	public boolean deleteArticle(int id){
		
		for (Map.Entry<Integer, Article> i : this.getModel().entrySet()) {
			
			if(i.getValue().getId() == id){
				this.getModel().remove(i.getKey());
				System.out.println("The article has been deleted");
				return true;
			}
		}
		
		return false;
	}

/////////////////////////////////////////////////////////////////////////////
	
	/**
	 *  Método para actualizar un artículo identificado
	 * 
	 *  @author jmv74211
	 *  @version 1.0
	 *  @param id Identificador del artículo
	 *  @param newDataArticle Objeto artículo cuyos datos sobreescriben al actual.
	 *  @return true si se ha eliminado, false en caso contrario
	 */

	public boolean updateArticle(int id, Article newDataArticle){
	
		for (Map.Entry<Integer, Article> i : this.getModel().entrySet()) {
			if(i.getValue().getId() == id){
				this.getModel().replace(i.getKey(), newDataArticle);
				System.out.println("The article has been updated");
				return true;
			}
		}
		
		return false;
	}

/////////////////////////////////////////////////////////////////////////////
	
} // FIN CLASE
