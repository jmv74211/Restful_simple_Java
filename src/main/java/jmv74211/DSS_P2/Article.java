package jmv74211.DSS_P2;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement // Indica el elemento raíz necesario para contruir el archivo XML de salida
public class Article{
	
	private int id;

	private String title;
	private String header;
	private String date;

	private ArrayList<String> images;
	
	private String textDescription;
	private ArrayList<String> comments;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getHeader() {
		return header;
	}
	
	public void setHeader(String header) {
		this.header = header;
	}
	
	public ArrayList<String> getImages() {
		return images;
	}
	
	public void setImages(ArrayList<String> images) {
		this.images = images;
	}
	
	public String getTextDescription() {
		return textDescription;
	}
	
	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}
	
	public ArrayList<String> getComments() {
		return comments;
	}
	
	public void setComments(ArrayList<String> comments) {
		this.comments = comments;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
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
	

}
