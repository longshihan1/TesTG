package budy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Modifier;

public class Hi {
    public static void main(String[] args) {
        System.out.println("Byte-buddy Hi HelloWorld By 小傅哥(bugstack.cn)");

        DynamicType.Unloaded<?> dynamicType = new ByteBuddy() .subclass(Object.class)
                .name("thread.HelloWorld")
                .defineMethod("main",void.class, Modifier.PUBLIC + Modifier.STATIC)
                .withParameter(String[].class,"args")
                .intercept(MethodDelegation.to(Hi.class,"args"))
                .make();

        try {
            save(dynamicType.getBytes(), "HelloWorld");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void save(byte[] data,String name) throws Exception{
        File file = new File(
                System.getProperty("user.dir") + "//build//classes//java//main//thread//"+name+".class");
        System.out.println(file.getPath());
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(data);
        fout.close();
    }
}
