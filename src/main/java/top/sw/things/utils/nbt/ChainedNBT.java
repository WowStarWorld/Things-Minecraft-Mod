package top.sw.things.utils.nbt;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;

import java.util.List;
import java.util.UUID;

public class ChainedNBT extends NbtCompound {

    public static ItemStack itemStackWithNBT (ItemConvertible item, int count, NbtCompound nbt) {
        ItemStack stack = new ItemStack(item, count);
        stack.setNbt(nbt);
        return stack;
    }

    public ChainedNBT set (String key, NbtElement element) {
        this.put(key, element);
        return this;
    }

    public ChainedNBT setBoolean (String key, boolean value) {
        this.putBoolean(key, value);
        return this;
    }

    public ChainedNBT setByte (String key, byte value) {
        this.putByte(key, value);
        return this;
    }

    public ChainedNBT setByteArray (String key, byte[] value) {
        this.putByteArray(key, value);
        return this;
    }
    public ChainedNBT setByteArray (String key, List<Byte> value) {
        this.putByteArray(key, value);
        return this;
    }

    public ChainedNBT setShort (String key, short value) {
        this.putShort(key, value);
        return this;
    }

    public ChainedNBT setDouble (String key, double value) {
        this.putDouble(key, value);
        return this;
    }
    public ChainedNBT setShort (String key, float value) {
        this.putFloat(key, value);
        return this;
    }

    public ChainedNBT setInt (String key, int value) {
        this.putInt(key, value);
        return this;
    }

    public ChainedNBT setIntArray (String key, int[] value) {
        this.putIntArray(key, value);
        return this;
    }

    public ChainedNBT setIntArray (String key, List<Integer> value) {
        this.putIntArray(key, value);
        return this;
    }

    public ChainedNBT setLong (String key, long value) {
        this.putLong(key, value);
        return this;
    }

    public ChainedNBT setLongArray (String key, long[] value) {
        this.putLongArray(key, value);
        return this;
    }

    public ChainedNBT setLongArray (String key, List<Long> value) {
        this.putLongArray(key, value);
        return this;
    }

    public ChainedNBT setString (String key, String value) {
        this.putString(key, value);
        return this;
    }

    public ChainedNBT setUuid (String key, UUID value) {
        this.putUuid(key, value);
        return this;
    }

}
