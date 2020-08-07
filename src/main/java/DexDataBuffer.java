import util.ByteInput;
import util.ByteOutput;
import util.Leb128;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class DexDataBuffer implements ByteInput, ByteOutput {
    private ByteBuffer data;
    private int dataBound;
    private boolean isResizeAllowed;
    public DexDataBuffer(ByteBuffer data) {
        this.data = data;
        this.data.order(ByteOrder.LITTLE_ENDIAN);
        this.dataBound = data.limit();
        this.isResizeAllowed = false;
    }
    @Override
    public byte readByte() {
        return data.get();
    }

    @Override
    public void writeByte(int i) {

    }
    public int readInt() {
        return data.getInt();
    }

    public short readShort() {
        return data.getShort();
    }

    public byte[] readByteArray(int length) {
        byte[] result = new byte[length];
        data.get(result);
        return result;
    }
    public void position(int pos) {
        data.position(pos);
    }


    public int readSleb128() {
        return Leb128.readSignedLeb128(this);
    }

    public int readUleb128() {
        return Leb128.readUnsignedLeb128(this);
    }
}
