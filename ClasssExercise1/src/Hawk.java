
class Bird {
	{
		System.out.print(" b1 ");
	}

	public Bird() {
		System.out.print(" b2 ");

	}
	
	static {
		System.out.print(" b1 ");

	}

}

class Raptor extends Bird {
	static {
		System.out.print(" r1 ");

	}

	static {
		System.out.print(" r4 ");

	}

	public Raptor() {
		System.out.print(" r2 ");
	}

	{
		System.out.print(" r3 ");
	}
}

public class Hawk extends Raptor {

	public static void main(String[] args) {
		System.out.print(" pre ");
		new Hawk();
		System.out.println(" hawk ");

	}

}
