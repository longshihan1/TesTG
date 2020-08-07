package thread;

import ASM.MyclassAdapter;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.TypeInsnNode;

public class AddTimeClassAdapter extends ClassVisitor {
    private String owner;
    private boolean isInterface;
    public AddTimeClassAdapter(int api,ClassVisitor cv) {
        super(api,cv);
    }
    MyclassAdapter myclassAdapter;
    @Override
    public void visit(int version, int access, String name, String signature,
                      String superName, String[] interfaces) {
        cv.visit(version, access, name, signature, superName, interfaces);
        owner = name;

         myclassAdapter=new MyclassAdapter(cv);

        isInterface = (access & Opcodes.ACC_INTERFACE) != 0;
    }
    @Override
    public MethodVisitor visitMethod(int access, String name, String desc,
                                     String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        if(!name.equals("<init>") && !isInterface && mv!=null){
            //为方法添加计时功能
            mv = new AddTimeMethodAdapter(Opcodes.ASM5,mv);
        }
        return mv;
    }
    @Override
    public void visitEnd() {
        //添加字段
        if(!isInterface){
            FieldVisitor fv = cv.visitField(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "timer", "J", null, null);
            if(fv!=null){
                fv.visitEnd();
            }
        }
//        cv.visitEnd();
        myclassAdapter.visitEnd();
    }

    class AddTimeMethodAdapter extends MethodVisitor{
        public AddTimeMethodAdapter(int api,MethodVisitor mv) {
            super(api,mv);
        }
        @Override
        public void visitCode() {
//            mv.visitCode();
//            mv.visitFieldInsn(Opcodes.GETSTATIC, owner, "timer", "J");
//            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J");
//            mv.visitInsn(Opcodes.LSUB);
//            mv.visitFieldInsn(Opcodes.PUTSTATIC, owner, "timer", "J");
            super.visitCode();
        }
        @Override
        public void visitInsn(int opcode) {
            if (opcode== Opcodes.LDC){
                TypeInsnNode node=new TypeInsnNode(opcode,"");

            }else if((opcode>=Opcodes.IRETURN && opcode<=Opcodes.RETURN) || opcode==Opcodes.ATHROW){
                mv.visitFieldInsn(Opcodes.GETSTATIC, owner, "timer", "J");
                mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J");
                mv.visitInsn(Opcodes.LADD);
                mv.visitFieldInsn(Opcodes.PUTSTATIC, owner, "timer", "J");
            }
            mv.visitInsn(opcode);
        }
        @Override
        public void visitMaxs(int maxStack, int maxLocal) {
            mv.visitMaxs(maxStack+4, maxLocal);
        }
    }

}