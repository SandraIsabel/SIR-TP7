package sir.tp7;

import java.net.UnknownHostException;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws UnknownHostException
    {
    	Morphia morphia = new Morphia();	
    	Mongo mongo = new Mongo();
    	morphia.map(Person.class).map(Address.class);
    	Datastore ds = morphia.createDatastore(mongo, "my_database");
    	
    	/*
    	 * Creation personne Tintin
    	 */
    	Person p = new Person();
    	p.setName("Tintin");

    	Address address = new Address();
    	address.setStreet("123 Some street");
    	address.setCity("Some city");
    	address.setPostCode("123 456");
    	address.setCountry("Some country");
    	//set address
    	p.setAddress(address);
    	// Save the POJO
    	ds.save(p);
    	
    	/*
    	 * Creation personne toto
    	 */
    	Person t = new Person();
    	t.setName("Toto");

    	Address addressT = new Address();
    	addressT.setStreet("123 Other street");
    	addressT.setCity("Other city");
    	addressT.setPostCode("123 456");
    	addressT.setCountry("Other country");
    	//set address
    	t.setAddress(addressT);
    	// Save the POJO
    	ds.save(t);
    	
    	/*
    	 * Creation d'un article achete par Tintin et Toto :)
    	 */
    	Article a = new Article();
    	a.setName("Some article");
    	a.setStarts(10);
    	a.setBuyers(p);
    	a.setBuyers(t);
    	ds.save(a);
    	
    	/*
    	 * Creation d'un article achete just par Toto
    	 */
    	Article aT = new Article();
    	aT.setName("Some article");
    	aT.setStarts(10);
    	aT.setBuyers(t);
    	ds.save(aT);
    	
    	//Afficher les personnes
    	for (Person e : ds.find(Person.class)){
    		System.err.println("**************************");
    		System.err.println(e);
    		System.err.println("Name: "+e.getName());
    		System.err.println(e.addressString());
    	}
    	
    	//Afficher les articles
    	System.err.println("************Articles**************");
    	for (Article ar : ds.find(Article.class)) {
			System.err.println("Article name: "+ar.getName());
			System.err.println("Buyers: ");
			for (Person per : ar.getBuyers()) {
				System.err.println(per.getName());
			}   
		}
    }
}
