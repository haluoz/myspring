/**
 * @author Xingjing.Li
 * @since 2/20/2024
 */
public class DetailBug extends Bug implements Fault{

	@Override
	public void throwBug() {
		System.out.println("throw a bug");
	}

	@Override
	public void findBug() {
		super.findBug();
	}

	public static void main(String[] args) {
		DetailBug detailBug = new DetailBug();
		detailBug.findFault1();
		detailBug.findFault();
		detailBug.findBug();
		detailBug.throwBug();
		boolean b = Fault.faultNumber == 1;
	}

	@Override
	public void findFault() {
		System.out.println("findFault");
	}
}
