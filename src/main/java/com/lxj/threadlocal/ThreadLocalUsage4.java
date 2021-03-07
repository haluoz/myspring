package com.lxj.threadlocal;

/**
 * ThreadLocal用法，避免传递参数的麻烦
 * @author Administrator
 */
public class ThreadLocalUsage4 {
    public static void main(String[] args) {
        new Service1().process();////////////////////////////////////////////
    }
}

class Service1{
    public  void  process(){
        User user = new User("aaa");
        UserContextHolder.holder.set(user);
        new Service2().process();
    }
}

class Service2{
    public  void  process(){
        User user = UserContextHolder.holder.get();
        System.out.println("2 get:"+user.name);
        new Service3().process();
    }
}

class Service3{
    public  void  process(){
        User user = UserContextHolder.holder.get();
        System.out.println("3 get:"+user.name);
        // 避免内存泄露
        UserContextHolder.holder.remove();
    }
}

class UserContextHolder{
    public static ThreadLocal<User> holder = new ThreadLocal<>();
}

class User{
    String name;

    public User(String name) {
        this.name = name;
    }
}
