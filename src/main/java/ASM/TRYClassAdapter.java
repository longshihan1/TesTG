package ASM;


import org.objectweb.asm.*;
import org.objectweb.asm.commons.AdviceAdapter;
import org.objectweb.asm.tree.TypeInsnNode;

import static org.objectweb.asm.Opcodes.ASM5;

public class TRYClassAdapter extends ClassVisitor {
    public TRYClassAdapter( ClassVisitor classVisitor) {
        super(ASM5, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        if (!"strToNumber".equals(name)){
            return super.visitMethod(access, name, descriptor, signature, exceptions);
        }
       MethodVisitor mv=super.visitMethod(access, name, descriptor, signature, exceptions);

        return new AdviceAdapter(ASM5, mv, access, name, descriptor) {
            private Label from = new Label(),
                    to = new Label(),
                    target = new Label();
            @Override
            protected void onMethodEnter() {
                //标志：try块开始位置
                visitLabel(from);
                visitTryCatchBlock(from, to, target, "java/lang/Exception");
            }
            // 访问局部变量和操作数栈
            @Override
            public void visitMaxs(int maxStack, int maxLocals) {
                //标志：try块结束
                mv.visitLabel(to);
                //标志：catch块开始位置
                mv.visitLabel(target);


                // 异常信息保存到局部变量
                int local = newLocal(Type.LONG_TYPE);
                mv.visitVarInsn(ASTORE, local);
                mv.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[]{"java/lang/Exception"});

//
//                // 输出信息
//                mv.visitLdcInsn(  "." + name);  // 类名.方法名
//                mv.visitVarInsn(ALOAD, local);
//                mv.visitMethodInsn(INVOKESTATIC, Type.getInternalName(MethodTest.class), "point", "(Ljava/lang/String;Ljava/lang/Throwable;)V", false);

                // 抛出异常
                mv.visitVarInsn(ALOAD, local);
                mv.visitInsn(ATHROW);
                super.visitMaxs(maxStack, maxLocals);
            }

            // 方法退出时修改字节码
            @Override
            protected void onMethodExit(int opcode) {
                if ((IRETURN <= opcode && opcode <= RETURN) || opcode == ATHROW) {
                    int nextLocal = this.nextLocal;
                    mv.visitVarInsn(ASTORE, nextLocal);// 将栈顶引用类型值保存到局部变量 indexbyte中。
                    mv.visitVarInsn(ALOAD, nextLocal); // 从局部变量indexbyte中装载引用类型 值入栈。

//
//                    mv.visitLdcInsn(className + "." + name);  // 类名.方法名
//                    mv.visitVarInsn(ALOAD, nextLocal);
//                    mv.visitMethodInsn(INVOKESTATIC, Type.getInternalName(MethodTest.class), "point", "(Ljava/lang/String;Ljava/lang/Object;)V", false);

                }
            }
        };
    }

}
