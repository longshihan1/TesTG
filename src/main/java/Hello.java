import util.SizeOf;

import java.io.File;
import java.nio.ByteBuffer;

public class Hello {
    public static final byte[] MAGIC = {0x44, 0x58, 0x44, 0x49, 0x46, 0x46};
    static int patchedDexSize;
    static int firstChunkOffset;
    static int patchedStringIdSectionOffset;
    static int patchedTypeIdSectionOffset;
    static int patchedProtoIdSectionOffset;
    static int patchedFieldIdSectionOffset;
    static int patchedMethodIdSectionOffset;
    static int patchedClassDefSectionOffset;
    static int patchedMapListSectionOffset;
    static int patchedTypeListSectionOffset;
    static int patchedAnnotationSetRefListSectionOffset;
    static int patchedAnnotationSetSectionOffset;
    static int patchedClassDataSectionOffset;
    static int patchedCodeSectionOffset;
    static int patchedStringDataSectionOffset;
    static int patchedDebugInfoSectionOffset;
    static int patchedAnnotationSectionOffset;
    static int patchedEncodedArraySectionOffset;
    static int patchedAnnotationsDirectorySectionOffset;
    static byte[] oldDexSignature;
    static DexDataBuffer buffer;
    public static void main(String[] args) {

        try {
            File file=new File("/Users/longhe/java/classes.dex");
            ByteBuffer byteBuffer=ByteBuffer.wrap(FileUtils.readFile(file));
             buffer = new DexDataBuffer(byteBuffer);
            byte[] magic = buffer.readByteArray(MAGIC.length);
           short  version = buffer.readShort();
            patchedDexSize = buffer.readInt();
            firstChunkOffset = buffer.readInt();
            patchedStringIdSectionOffset = buffer.readInt();
            patchedTypeIdSectionOffset = buffer.readInt();
            patchedProtoIdSectionOffset = buffer.readInt();
            patchedFieldIdSectionOffset = buffer.readInt();
            patchedMethodIdSectionOffset = buffer.readInt();
            patchedClassDefSectionOffset = buffer.readInt();
            patchedMapListSectionOffset = buffer.readInt();
            patchedTypeListSectionOffset = buffer.readInt();
            patchedAnnotationSetRefListSectionOffset = buffer.readInt();
            patchedAnnotationSetSectionOffset = buffer.readInt();
            patchedClassDataSectionOffset = buffer.readInt();
            patchedCodeSectionOffset = buffer.readInt();
            patchedStringDataSectionOffset = buffer.readInt();
            patchedDebugInfoSectionOffset = buffer.readInt();
            patchedAnnotationSectionOffset = buffer.readInt();
            patchedEncodedArraySectionOffset = buffer.readInt();
            patchedAnnotationsDirectorySectionOffset = buffer.readInt();
            oldDexSignature = buffer.readByteArray(SizeOf.SIGNATURE);

            buffer.position(firstChunkOffset);
            //测试stringids
            final int deletedItemCount = buffer.readUleb128();
            final int[] deletedIndices = readDeltaIndiciesOrOffsets(deletedItemCount);

            final int addedItemCount = buffer.readUleb128();
            final int[] addedIndices = readDeltaIndiciesOrOffsets(addedItemCount);

            final int replacedItemCount = buffer.readUleb128();
            final int[] replacedIndices = readDeltaIndiciesOrOffsets(replacedItemCount);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

     static int[] readDeltaIndiciesOrOffsets(int count) {
        int[] result = new int[count];
        int lastVal = 0;
        for (int i = 0; i < count; ++i) {
            int delta = buffer.readSleb128();
            lastVal = lastVal + delta;
            result[i] = lastVal;
        }
        return result;
    }
}
