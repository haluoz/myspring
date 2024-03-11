/**
 * @author Xingjing.Li
 * @since 2/20/2024
 */
public interface Fault {
	Integer faultNumber = 0;

	void findFault();

	default void findFault1(){
		System.out.println("findFault1");
	}
}
