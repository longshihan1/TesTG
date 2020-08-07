package thread;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import ASM.MyclassAdapter;
import ASM.TRYClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

public class Generator {
    public static void main(String[] args){
        try {
            ClassReader cr = new ClassReader("thread/C");
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
//            ClassVisitor classAdapter = new AddTimeClassAdapter(Opcodes.ASM5,cw);
            ClassVisitor classAdapter = new TRYClassAdapter(cw);
            //使给定的访问者访问Java类的ClassReader
            cr.accept(classAdapter, ClassReader.EXPAND_FRAMES);
            byte[] data = cw.toByteArray();
            File file = new File(
                    System.getProperty("user.dir") + "//build//classes//java//main//thread//C.class");
            System.out.println(file.getPath());
            FileOutputStream fout = new FileOutputStream(file);
            fout.write(data);
            fout.close();
            System.out.println("success!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
