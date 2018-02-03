package com.dylan.IO;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 *你不能利用管道与不同的JVM中的线程通信(不同的进程)。
 * 在概念上，Java的管道不同于Unix/Linux系统中的管道。在Unix/Linux中，运行在不同地址空间的两个进程可以通过管道通信。
 * 在Java中，通信的双方应该是运行在同一进程中的不同线程。
 *
 *可以通过Java IO中的PipedOutputStream和PipedInputStream创建管道。一个PipedInputStream流应该和一个PipedOutputStream流相关联。
 * 一个线程通过PipedOutputStream写入的数据可以被另一个线程通过相关联的PipedInputStream读取出来。
 *
 * 请记得，当使用两个相关联的管道流时，务必将它们分配给不同的线程。read()方法和write()方法调用时会导致流阻塞，
 * 这意味着如果你尝试在一个线程中同时进行读和写，可能会导致线程死锁。
 *
 * 注：本例忽略了流的关闭。请在处理流的过程中，务必保证关闭流，或者使用jdk7引入的try-resources代替显示地调用close方法的方式。
 */
public class PipeExample {
    public static void main(String[] args) throws IOException {
        final PipedOutputStream outputStream = new PipedOutputStream();
        final PipedInputStream inputStream = new PipedInputStream(outputStream);

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    outputStream.write("Hello world ! Pipe !".getBytes("UTF-8"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                try {
                    int data = inputStream.read();

                    while (data != -1){
                        System.out.print((char)data);
                        data = inputStream.read();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        thread1.start();
        thread2.start();

    }
}
