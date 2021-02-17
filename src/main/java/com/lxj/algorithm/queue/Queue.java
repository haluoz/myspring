package com.lxj.algorithm.queue;

 interface Queue<E>{
     void enqueue(E e);

     E dequeue();

     E getFront();

     int getSize();

     boolean isEmpty();
}
