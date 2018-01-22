package org.mag.subscribe;

import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Persistence.generateSchema("publication_app", null);
    }
}
