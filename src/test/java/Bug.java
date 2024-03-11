/**
 * @author Xingjing.Li
 * @since 12/20/2023
 */
public abstract class Bug {
    private Integer number = 0;

    public abstract void throwBug();

    public void findBug() {
        System.out.println("find a bug");
    }
}
