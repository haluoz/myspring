public class Cat extends Animal {
    @Override
    public void move() {
        System.out.println("cat is moving");
    }

    public void move(int a){
        this.move();
    }

    public void miao(){
        System.out.println("cat is saying");
    }

    public void miao(String a){

    }

    public double miao(int a){
        return 0;
    }

}
