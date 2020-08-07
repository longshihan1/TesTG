package ASM;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodNode;

public class  MyclassAdapter extends ClassVisitor {
    ClassVisitor next;
    public MyclassAdapter(ClassVisitor cv) {
        super(Opcodes.ASM5,new ClassNode());
        next= cv;
    }
    @Override public void visitEnd() {
     ClassNode cn= (ClassNode) cv;
        cn.accept(next);
        for (int i = 0; i < cn.methods.size(); i++) {
            MethodNode methodNode= (MethodNode) cn.methods.get(i);
            if (methodNode.name.equals("m")){
                methodNode.exceptions.clear();
                InsnList insnList= methodNode.instructions;
                LdcInsnNode ldcInsnNode= (LdcInsnNode) insnList.getFirst();
                if (ldcInsnNode.cst instanceof Long){
                    ldcInsnNode.cst=120;
                }else if (ldcInsnNode.cst instanceof String){
                    ldcInsnNode.cst="er";
                }
            }
        }


     int i=-1;
    }
}
