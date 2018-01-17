package com.xxx.common.compile;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.concurrent.Callable;

/**
 * Created by admin on 2018/1/18 0018.
 */
public class DynamicJavaCompilerTest {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {

        String codeFile = "E:/code/DynamicJavaCompiler/src/main/resources/TestCode.txt";

        File file = new File(codeFile);
        String code = FileUtils.readFileToString(file, "UTF-8");

        DynamicJavaCompiler dynamicJdkCompiler = new DynamicJavaCompiler();

        Class<?> clazz1 = dynamicJdkCompiler.compile(code);
        Callable<String> obj = (Callable<String>) clazz1.newInstance();
        System.out.println(obj.call());
        clazz1 = null;
        obj = null;

        System.gc();

        Thread.sleep(1000);
    }
}
