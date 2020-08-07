package thread;

import ASM.MyclassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ThreadManagerClassVisitor extends ClassVisitor {
    private String owner;
    private boolean isInterface;
    public ThreadManagerClassVisitor(int api, ClassVisitor cv) {
        super(api, cv);
    }


    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        cv.visit(version, access, name, signature, superName, interfaces);
        owner = name;
        isInterface = (access & Opcodes.ACC_INTERFACE) != 0;
        MyclassAdapter myclassAdapter=new MyclassAdapter(cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        if(!name.equals("<init>") && !isInterface && mv!=null) {
            //为方法添加计时功能
            if (name.equals("test4")) {
                mv = new ThreadManagerMethodAdapter(Opcodes.ASM5, mv);
            }
        }
        return mv;
    }


    class ThreadManagerMethodAdapter extends MethodVisitor {
        public ThreadManagerMethodAdapter(int api, MethodVisitor mv) {
            super(api, mv);
        }

        @Override
        public void visitCode() {
            mv.visitCode();
        }

        @Override
        public void visitInsn(int opcode) {

                if (opcode==Opcodes.INVOKESPECIAL){

                }

            mv.visitInsn(opcode);
        }

        @Override
        public void visitEnd() {
            super.visitEnd();
        }

        @Override
        public void visitMaxs(int maxStack, int maxLocals) {
            super.visitMaxs(maxStack, maxLocals);
        }
    }
}
