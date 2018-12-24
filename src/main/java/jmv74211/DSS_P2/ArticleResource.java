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
	@Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN} )
	public ArrayList<Article> getAllArticles(){
		
		ArrayList<Article> articles = new ArrayList<Article>();
		System.out.println("called getAllArticles()");
		
		articles.addAll(ArticlesDAO.instance.getModel().values());
		
		return articles;
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
	
	@POST
	@Path("/{id}")
	@Consumes( {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON} )
	public Article updateArticle(@PathParam("id") int id, Article newDataArticle){
	
		System.out.println("called updateArticle("+ id + ")");
		ArticlesDAO.instance.updateArticle(id, newDataArticle);
		
		return null;
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
