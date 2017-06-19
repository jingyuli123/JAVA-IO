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
     * ����BufferOutputStream �ཫFileOutputStream��Ϊ�����½�һ��������������ļ��Ķ�дЧ��
     */
    @Test
    public void testFileOutputStream() {
        try {
            File file = new File("D:/TT/ouput.txt");
//            OutputStream output = new FileOutputStream("D:/TT/ouput.txt");
            OutputStream output = new FileOutputStream(file);
            output.write("hello world,���".getBytes("UTF-8"));//����ָ����ʽ���ļ�,Ĭ��gbk
//            output.flush(); ����ȥ��
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
            bos.write("Hi!,������".getBytes("UTF-8"));//����ָ����ʽ�ļ���Ĭ��gbk
            bos.flush();//�����
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
        bos.write("Hi!,������".getBytes("UTF-8"));//����ָ����ʽ�ļ���Ĭ��gbk
        bos.flush();//�����
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
