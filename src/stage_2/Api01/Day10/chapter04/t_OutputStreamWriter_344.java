package Api01.Day10.chapter04;

/*
    java.io.OutputStreamWriter extends Writer
    OutputStreamWriter：字符通向字节的桥梁，可以用指定的charset将要写入流中的字符编码成字节（编码：把能看懂的变成看不懂的）

    继承自父类的共性成员方法：
        void write(int c) 写入单个字符。
        void write(char[] cbuf) 写入字符数组。
        abstract void write(char[] cbuf, int off, int len) 写入字符数组的某一部分,off数组的开始索引,len写的字符个数。
        void write(String str) 写入字符串。
        void write(String str, int off, int len) 写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
        void flush() 刷新该流的缓冲。
        void close() 关闭此流,但要先刷新它。
    构造方法：
        OutputStreamWriter(OutputStream out)创建使用默认字符编码的OutputStreamWriter
        OutputStreamWriter(OutputStream out, String charsetName)创建使用指定字符编码的OutputStreamWriter
        参数：
            OutputStream out ：字节输出流，可以用来写转换之后的字节到文件中
            String charsetName：指定的编码表名称，不区分大小写，可以是utf-8/UTF-8/GBK/gbk等...不指定默认使用utf-8
    使用步骤：
        1、创建一个outputStreamWriter对象，构造方法中传递字节输出流和指定的编码表名称
        2、使用outputStreamWriter对象中的方法write，把字符转换为字节存储到缓冲区中（编码）
        3、使用OutputStreamWriter对象中的方法flush，把内存缓冲区中的字节刷新到文件中（使用字节流写字节的过程）
        4、释放资源
 */

import java.io.*;

public class t_OutputStreamWriter_344 {
    public static void main(String[] args) throws IOException {
        write_utf_8();
        write_gbk();
    }

    /*
        使用转换流OutputStreamWriter写gbk格式的文件
     */
    private static void write_gbk() throws IOException {
        // 1、创建一个outputStreamWriter对象，构造方法中传递字节输出流和指定的编码表名称
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("/home/jeffrey/IdeaProjects/JavaLearn/src/stage_2/Api01/Day10/chapter04/GBK.txt"), "GBK"); // 不指定默认使用utf-8编码
        // 2、使用outputStreamWriter对象中的方法write，把字符转换为字节存储到缓冲区中（编码）
        osw.write("你好");
        // 3、使用OutputStreamWriter对象中的方法flush，把内存缓冲区中的字节刷新到文件中（使用字节流写字节的过程）
        osw.flush();
        // 4、关闭流
        osw.close();
    }

    /*
        使用转换流OutputStreamWriter写utf-8格式的文件
     */
    private static void write_utf_8() throws IOException {
        // 1、创建一个outputStreamWriter对象，构造方法中传递字节输出流和指定的编码表名称
//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("/home/jeffrey/IdeaProjects/JavaLearn/src/stage_2/Api01/Day10/chapter04/utf_8.txt"), "utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("/home/jeffrey/IdeaProjects/JavaLearn/src/stage_2/Api01/Day10/chapter04/utf_8.txt")); // 不指定默认使用utf-8编码
        // 2、使用outputStreamWriter对象中的方法write，把字符转换为字节存储到缓冲区中（编码）
        osw.write("你好");
        // 3、使用OutputStreamWriter对象中的方法flush，把内存缓冲区中的字节刷新到文件中（使用字节流写字节的过程）
        osw.flush();
        // 4、关闭流
        osw.close();

    }

}
