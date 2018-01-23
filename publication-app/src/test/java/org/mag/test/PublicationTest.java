package org.mag.test;



import org.junit.Test;
import org.mag.Article;
import org.mag.pub.Address;
import org.mag.pub.Author;

public class PublicationTest extends BaseTest{

	public PublicationTest() {
		super("publication_app");
	}
	
	
	@Test
	public void testArticle(){
		beginTransaction();
		
		Article article = new Article();
		article.setTitle("Java 9 modularity");
		
		Article article1 = new Article();
		article1.setTitle("Effective Java");
		
		Author author1 = new Author();
		author1.setFirstName("Joshua");
		author1.setLastName("Blouch");
		
		Author author2 = new Author();
		author2.setFirstName("James ");
		author2.setLastName("Gosling");
		
		
		Author author3 = new Author();
		author3.setFirstName("Antonio ");
		author3.setLastName("Gaslov");
		
		Address address = new Address();
		address.setCity("San fransisco");
		address.setStreet("Wall Street");
		address.setState("NY");
		address.setZip("123455");
		author1.setAddress(address); 
		
		Address address2 = new Address();
		address2.setCity("Hills");
		address2.setStreet("Hill Street");
		address2.setState("California");
		address2.setZip("124564");
		author2.setAddress(address2); 
		
		Address address3 = new Address();
		address3.setCity("Beverlly  ");
		address3.setStreet("Beverlly Street");
		address3.setState("California");
		address3.setZip("12212313");
		author3.setAddress(address3); 
		
		article.addAuthors(author1);
		article.addAuthors(author2);
		
		article1.addAuthors(author2);
		article1.addAuthors(author3);
		
		entityManager().persist(article);
		entityManager().persist(article1);
		entityManager().persist(author1);
		entityManager().persist(author2);
		entityManager().persist(author3);
		
		commit();
	}
	
	@Test
	public void testAuthor(){
		beginTransaction();
		
		Author author = new Author();
		author.setFirstName("Joshua");
		author.setLastName("Blouch");
		
		Address address = new Address();
		address.setCity("San fransisco");
		address.setStreet("Wall Street");
		address.setState("NY");
		address.setZip("123455");
		author.setAddress(address);
		entityManager().persist(author);
		
		
		commit();
	}
	

}
