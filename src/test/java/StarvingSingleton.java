public class StarvingSingleton {
    private StarvingSingleton(){}
    public static StarvingSingleton getInstance(){
        System.out.println(ContainerHolder.INSTACE.errMsg);
        return ContainerHolder.HOLDER.instance;
    }
    private enum ContainerHolder{
        INSTACE,
        HOLDER;
        private StarvingSingleton instance;
        private int errCode;
        private String errMsg;
        ContainerHolder(){
            instance = new StarvingSingleton();
        }
    }
}
