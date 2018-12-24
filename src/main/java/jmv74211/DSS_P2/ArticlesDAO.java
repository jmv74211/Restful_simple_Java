package jmv74211.DSS_P2;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.Map;

public enum ArticlesDAO {
	
	instance; 
	private Map<Integer,Article> contentData = new HashMap<Integer, Article>();
	private int numArticles;
	
/////////////////////////////////////////////////////////////////////////////
	
	private ArticlesDAO(){
		
		ArrayList<String>imagesList = new ArrayList<String>();
		ArrayList<String>commentList = new ArrayList<String>();
		this.numArticles = 1;
		
		Article object1 = new Article();
		
		object1.setId(1);
		object1.setTitle("Athletic Garitano pierde a Raúl García y Yeray");
		object1.setHeader("Cumplirán sanción por acumulación de amonestaciones ante el Celta");
		
		imagesList.add("/images/1.jpg");
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
		
		imagesList2.add("/images/2.jpg");
		imagesList2.add("https://www.youtube.com/watch?v=BCFnTPzmbDo");
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
	
	public Map<Integer, Article> getModel(){

		return this.contentData;

	}
	
/////////////////////////////////////////////////////////////////////////////
	
	public ArrayList<Article> getAllArticles(){
		
		ArrayList<Article> articlesData = new ArrayList<Article>();
		
		for(Article a: this.getModel().values()){
			System.out.println(a);
			articlesData.add(a);
		}
		
		return articlesData;
	}

/////////////////////////////////////////////////////////////////////////////
	
	public Article getArticle(int id){
		
		for(Article a: this.getModel().values()){
			if(a.getId()==id)
				return a;
		}

		return null;
	}
	
/////////////////////////////////////////////////////////////////////////////
	
	public int countArticles(){
		return this.contentData.size();
	}
	
/////////////////////////////////////////////////////////////////////////////

	public void createArticle(Article newArticle){
		this.contentData.put(this.numArticles,newArticle);
		this.numArticles++;
		
	}
	
/////////////////////////////////////////////////////////////////////////////
	

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
}
