package jmv74211.DSS_P2;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("articles")
public class ArticleResource{
	
/////////////////////////////////////////////////////////////////////////////
	
	@GET
	@Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
	@Consumes( {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON} )
	public ArrayList<Article> getAllArticles(){
		
		ArrayList<Article> articles = new ArrayList<Article>();
		System.out.println("called getAllArticles()");
		
		articles.addAll(ArticlesDAO.instance.getModel().values());
		
		return articles;
	}
	

/////////////////////////////////////////////////////////////////////////////
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getAllArticlesHTML(){
	
		ArrayList<Article> articles = new ArrayList<Article>();
		System.out.println("called getAllArticlesHTML()");
		
		articles.addAll(ArticlesDAO.instance.getModel().values());
		
		String output = ""
				+ "<!DOCTYPE html>"
				+ "<html>"
				+ "		<head>"
				+ "			<meta charset='"+"UTF-8"+"'>"
				+ "			<title>Artículos de fútbol</title>"
				+ "		</head>"
				+ "		<body>"
				+ "			<div style='width:100%'>"
				+ "         <h1 style='text-align:center;color:red;margin-bottom:50px'>Artículos deportivos</h1>";
		
		for(Article a: articles){
			
			output += ""
					+ "<div style='width:40%;margin:0 auto;background-color:lightGrey;border: solid black 1px;padding-bottom:8px;margin-bottom:35px'>"
					+ "		<h4 style='text-align:center'>" + a.getTitle() + "</h4>"
					+ "		<h5 style='text-align:center'>" + a.getHeader() + "</h5>";
					
					
					for(String url: a.getImages()){
						if(url.contains("youtube")){
							output += ""
									+ "<div style='text-align:center'>"
									+ "		<iframe width='560' height='315' src='"+ url +"'>"
									+ "		</iframe>"
									+ "	</div>";	
						}
						else{
							output += ""
									+ "<div style='text-align:center'>"
									+ "			<img src='"+ url +"' style='width:60%'/>"
									+ "	</div>";
						}
					}
					
			output += "</div>";
		}
		
		output += ""
				+ "			</div>"
				+ "		</body>"
				+ "</html>";
				
		return output;
	}
	
/////////////////////////////////////////////////////////////////////////////
	
	@PUT
	@Consumes( {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON} )
	public void createArticle(Article newArticle){
		System.out.println("called createArticle()");
		System.out.println("Added: " + newArticle);
		
		ArticlesDAO.instance.createArticle(newArticle);
		
	}
	

/////////////////////////////////////////////////////////////////////////////
	
	@GET
	@Path("/{id}")
	@Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON} )
	public Article getArticle(@PathParam("id") int id){
		System.out.println("called getArticle(" + id + ")");
		return ArticlesDAO.instance.getArticle(id);
	}
	
/////////////////////////////////////////////////////////////////////////////
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.TEXT_HTML)
	public String getArticleHTML(@PathParam("id") int id){
		System.out.println("called getArticleHTML(" + id + ")");
		boolean exist = false;
		
		Article article = new Article();
		
		for(Article obj: ArticlesDAO.instance.getModel().values()){
			if(obj.getId() == id){
				article = obj;
				exist = true;
			}
		}
		
		System.out.println(exist);
		if(exist){
			String output = ""
					+ "<!DOCTYPE html>"
					+ "<html>"
					+ "		<head>"
					+ "			<meta charset='"+"UTF-8"+"'>"
					+ "			<title>Artículos de fútbol</title>"
					+ "		</head>"
					+ "		<body>"
					+ "			<div style='width:60%;margin:0 auto;background-color:lightGrey;padding:20px'>"
					+ "         <h1 style='text-align:center;color:red;margin-bottom:50px'>"+ article.getTitle() +"</h1>"
					+ "			<h3 style='text-align:center'>" + article.getHeader() + "</h3>";
			
	
			for(String url: article.getImages()){
				if(url.contains("youtube")){
					output += ""
							+ "<div style='text-align:center'>"
							+ "		<iframe width='560' height='315' src='"+ url +"'>"
							+ "		</iframe>"
							+ "	</div>";	
				}
				else{
					output += ""
							+ "<div style='text-align:center'>"
							+ "			<img src='"+ url +"' style='width:60%'/>"
							+ "	</div>";
				}
			}
			
			output += "<p style='text-align:justify'>" + article.getTextDescription() + "</p>";
			
			output += "<h3> Comentarios </h3>";
			
			for(String comm: article.getComments() ){
				
				output += "<p style='background-color:#ececec;padding:4px'>" + comm + "</p>";
			}
			
			
			output += ""
					+ "			</div>"
					+ "		</body>"
					+ "</html>";
					
			return output;
		}
		
		return null;
		
	}

/////////////////////////////////////////////////////////////////////////////
	
	@POST
	@Path("/{id}")
	@Consumes( {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON} )
	public void updateArticle(@PathParam("id") int id, Article newDataArticle){
	
		System.out.println("called updateArticle("+ id + ")");
		ArticlesDAO.instance.updateArticle(id, newDataArticle);
	}
	
/////////////////////////////////////////////////////////////////////////////
	
	@DELETE
	@Path("/{id}")
	@Consumes( {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON} )
	public boolean deleteArticle(@PathParam("id") int id){
	
		System.out.println("called deleteArticle("+ id + ")");
		
		return ArticlesDAO.instance.deleteArticle(id);
		
		
	}
	
/////////////////////////////////////////////////////////////////////////////
	
} // FIN CLASE
