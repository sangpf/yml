package com.youchu.product.pythontool;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * java 调用 python
 */
public class HelloPython {

    private static void runPython(){
        String[] arguments = new String[] {"python", "D://hello.py"};
        try {
            Process process = Runtime.getRuntime().exec(arguments);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            //java代码中的process.waitFor()返回值为0表示我们调用python脚本成功，
            //返回值为1表示调用python脚本失败，这和我们通常意义上见到的0与1定义正好相反
            int re = process.waitFor();
            System.out.println(re);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void runPython(String s1, String s2){
        String[] arguments = new String[] {"python", "D://hello.py", s1, s2};
        try {
            Process process = Runtime.getRuntime().exec(arguments);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            //java代码中的process.waitFor()返回值为0表示我们调用python脚本成功，
            //返回值为1表示调用python脚本失败，这和我们通常意义上见到的0与1定义正好相反
            int re = process.waitFor();
            System.out.println(re);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        runPython("D:\\tempFile\\word\\100000012.docx", "D:\\tempFile\\word\\10001.pdf");

        // 生成pdf后添加水印


    }

}
