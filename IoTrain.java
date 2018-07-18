package ipanelTrain;

import org.junit.Test;

import java.io.*;

/*分别使用字节流和字符流完成以下程序：

        1. 在指定的路径(不存在的一个多级目录地址，如:d:/java/train/io/)下新建一个 .txt 文件 "test.txt"，利用程序在文件中写入如下内容：

        "Java是一种可以撰写跨平台应用软件的面向对象的程序设计语言，是由Sun Microsystems公司于
        1995年5月推出的Java程序设计语言和Java平台（即JavaSE, JavaEE, JavaME）的总称。Java 技术具有
        卓越的通用性、高效性、平台移植性和安全性，广泛应用于个人PC、数据中心、游戏控制台、科学超级
        计算机、移动电话和互联网，同时拥有全球最大的开发者专业社群。在全球云计算和移动互联网的产业
        环境下，Java更具备了显著优势和广阔前景。"

        2. 利用程序读取 test.txt 文件的内容, 并在控制台打印

        3. 利用程序复制 test.txt 为 test1.txt
*/
public class IoTrain {
    static String path = "d:\\java\\train\\io\\test.txt";
    static String str="Java是一种可以撰写跨平台应用软件的面向对象的程序设计语言，是由Sun Microsystems公司于" +
            "1995年5月推出的Java程序设计语言和Java平台（即JavaSE, JavaEE, JavaME）的总称。Java 技术具有" +
            "卓越的通用性、高效性、平台移植性和安全性，广泛应用于个人PC、数据中心、游戏控制台、科学超级" +
            "计算机、移动电话和互联网，同时拥有全球最大的开发者专业社群。在全球云计算和移动互联网的产业" +
            "环境下，Java更具备了显著优势和广阔前景。";
    public static void main(String[] args) throws IOException {
        IoTrain ioTrain = new IoTrain();
        ioTrain.writeFile();
        ioTrain.getFile();
        ioTrain.copyFile();
    }

    //写入文件
    @Test
    public void writeFile(){
        try {
            File file = new File(path);
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            boolean b = file.createNewFile();
            final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getPath()));
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //读取文件
    @Test
    public void getFile() throws IOException {
        File file = new File(path);
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file.getPath()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String str = "";
        StringBuffer sb = new StringBuffer();
        while ((str=bufferedReader.readLine()) != null) {
            sb.append(str);
        }
        System.out.println(sb.toString());
        bufferedReader.close();
    }

    //复制文件
    @Test
    public void copyFile() throws IOException {
        File file = new File(path);
        BufferedReader bufferedReader = null;
        String str;
        try {
            bufferedReader = new BufferedReader(new FileReader(file.getPath()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getParentFile()+"/test1.txt"));
        while ((str=bufferedReader.readLine()) != null) {
            bufferedWriter.write(str);
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
