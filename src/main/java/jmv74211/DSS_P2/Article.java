package jmv74211.DSS_P2;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;


/**
 *  Clase que construye el modelo Artículo
 *  
 * @author jmv74211
 * @version 1.0
 */

@XmlRootElement // Indica el elemento raíz necesario para contruir el archivo XML de salida
public class Article{
	
	private int id;

	private String title;
	private String header;
	private String date;

	private ArrayList<String> images;
	
	private String textDescription;
	private ArrayList<String> comments;
	

	/**
	 * @author jmv74211
	 * @version 1.0
	 * @return Identificador del artículo
	 */
	
	public int getId() {
		return id;
	}

	/**
	 * @author jmv74211
	 * @version 1.0
	 * @param id Identificador del artículo
	 */
	
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @author jmv74211
	 * @version 1.0
	 * @return Título de la noticia
	 */
	
	public String getTitle() {
		return title;
	}
	
	/**
	 * @author jmv74211
	 * @version 1.0
	 * @param title Título de la noticia
	 */
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @author jmv74211
	 * @version 1.0
	 * @return Cabecera de la noticia
	 */
	
	public String getHeader() {
		return header;
	}
	
	/**
	 * @author jmv74211
	 * @version 1.0
	 * @param header Cabecera de la noticia
	 */
	
	public void setHeader(String header) {
		this.header = header;
	}
	
	/**
	 * @author jmv74211
	 * @version 1.0
	 * @return Lista de imágenes/vídeos de la noticia
	 */
	
	public ArrayList<String> getImages() {
		return images;
	}
	
	/**
	 * @author jmv74211
	 * @version 1.0
	 * @param images Lista de imágenes/vídeos
	 */
	
	public void setImages(ArrayList<String> images) {
		this.images = images;
	}
	
	/**
	 * @author jmv74211
	 * @version 1.0
	 * @return Texto de la noticia.
	 */
	
	public String getTextDescription() {
		return textDescription;
	}
	
	/**
	 * @author jmv74211
	 * @version 1.0
	 * @param textDescription Texto de la noticia.
	 */
	
	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}
	
	/**
	 * @author jmv74211
	 * @version 1.0
	 * @return Lista de comentarios de la noticia.
	 */
	
	public ArrayList<String> getComments() {
		return comments;
	}
	
	/**
	 * @author jmv74211
	 * @version 1.0
	 * @param comments Lista de comentarios de la noticia.
	 */
	
	public void setComments(ArrayList<String> comments) {
		this.comments = comments;
	}
	
	/**
	 * @author jmv74211
	 * @version 1.0
	 * @return Fecha de la noticia en formato YYYY-MM-DD
	 */
	
	public String getDate() {
		return date;
	}

	/**
	 * @author jmv74211
	 * @version 1.0
	 * @param date Fecha de la noticia en formato YYYY-MM-DD
	 */
	
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * @author jmv74211
	 * @version 1.0
	 * @return Datos de la noticia en formato String.
	 */
	
	@Override
	public String toString() {
		
		String output = "------------------ ARTICLE #" + id + "------------------------\n"
		+ "Title:      " + title + "\n"
		+ "Header:     " + header + "\n"
		+ "Date :      " + date + "\n"
		+ "Description " + textDescription + "\n"
		+ "Images: " + "\n";
		
		for(int i = 0; i< images.size(); i++){
			output = output + "       " + images.get(i) + "\n" ;
		}
		
		output = output + "Comments: " + "\n";
		
		for(int i = 0; i< comments.size(); i++){
			output = output + "       " + comments.get(i) + "\n" ;
		}
		
		return output;
	}
	

} // FIN CLASE
