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
       // System.out.println( "Hello World!" );
    	Morphia morphia = new Morphia();	
    	Mongo mongo = new Mongo();
    	morphia.map(Person.class).map(Address.class);
    	Datastore ds = morphia.createDatastore(mongo, "my_database");
    	
    	Person p = new Person();
    	p.setName("Tonton");

    	Address address = new Address();
    	address.setStreet("123 Some street");
    	address.setCity("Some city");
    	address.setPostCode("123 456");
    	address.setCountry("Some country");
    	//set address
    	p.setAddress(address);
    	// Save the POJO
    	ds.save(p);
    	for (Person e : ds.find(Person.class)){
    		 System.err.println(e);
    		 System.err.println(e.getName());
    		 System.err.println(e.getAddress().getCity());
    	}
    }
}
