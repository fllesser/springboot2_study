package io.random_access;

import java.io.*;


public class TestRandomAccessFile {

    public static void main(String[] args) {
        try (RandomAccessFile rw = new RandomAccessFile("out"  + File.separator +"input.txt","rw")) {
            System.out.println("读取之前的偏移量:" + rw.getFilePointer() + ", 当前读取到的字符: "
                    + (char) rw.read() + ", 读取之后的偏移量: " + rw.getFilePointer());
            rw.seek(6);
            System.out.println("读取之前的偏移量:" + rw.getFilePointer() + ", 当前读取到的字符: "
                    + (char) rw.read() + ", 读取之后的偏移量: " + rw.getFilePointer());
            rw.write(new byte[]{'H', 'I', 'J', 'K'});
            rw.seek(0);
            System.out.println("读取之前的偏移量:" + rw.getFilePointer() + ", 当前读取到的字符: "
                    + (char) rw.read() + ", 读取之后的偏移量: " + rw.getFilePointer());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
