package exercise;

public abstract class DomainObject {
    protected String name = "no name";

	public String getName()	{
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}
