package com.lijy.file;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Lijingyu on 2017/6/19.
 */
public class FileOutputStreamTest {

    /**
     * 采用BufferOutputStream 类将FileOutputStream作为参数新建一个对象便可以提高文件的读写效率
     */
    @Test
    public void testFileOutputStream() {
        try {
            File file = new File("D:/TT/ouput.txt");
//            OutputStream output = new FileOutputStream("D:/TT/ouput.txt");
            OutputStream output = new FileOutputStream(file);
            output.write("hello world,你好".getBytes("UTF-8"));//生成指定格式的文件,默认gbk
//            output.flush(); 可以去掉
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBufferOutputStream(){
        File file = new File("D:/TT/ouput.txt");
        OutputStream output = null;
        BufferedOutputStream bos = null;
        try {
            output = new FileOutputStream(file);
            bos = new BufferedOutputStream(output);
            bos.write("Hi!,宝贝！".getBytes("UTF-8"));//生成指定格式文件，默认gbk
            bos.flush();//必须加
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null){
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void writeFile(String filePath) throws IOException {
        OutputStream output = new FileOutputStream(filePath);
        BufferedOutputStream bos= new BufferedOutputStream(output);
        bos.write("Hi!,宝贝！".getBytes("UTF-8"));//生成指定格式文件，默认gbk
        bos.flush();//必须加
        output.close();
        bos.close();
    }

    public static void main(String[] args) {
        try {
            writeFile("D:/TT/ouput.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
