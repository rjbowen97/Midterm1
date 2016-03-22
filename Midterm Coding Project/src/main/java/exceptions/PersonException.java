package exceptions;

import com.cisc181.core.Person;

public class PersonException extends Exception
{
	//the amount of years in milliseconds
	public static final long oneHundredYearsMilliSeconds = (long)31536000000.0*100;

	private Person person;
	
	public PersonException(Person personParam)
	{
		this.person = personParam;
		System.out.println("Person Exception thrown");
	}
}
