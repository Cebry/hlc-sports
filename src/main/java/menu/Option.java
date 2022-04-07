package menu;

public class Option {
	private String name = null;
	private Runnable method = null;

	public Option(String name, Runnable method) {
		super();
		this.name = name;
		this.method = method;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Runnable getMethod() {
		return method;
	}

	public void setMethod(Runnable method) {
		this.method = method;
	}

}
