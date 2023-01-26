package top.sw.things.utils.item;

import dev.emi.trinkets.api.SlotReference;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import dev.emi.trinkets.api.TrinketItem;
import java.util.List;


public class SwitchableTrinket extends TrinketItem {

    public SwitchableTrinket (Settings settings) {
        super(settings.maxDamage(Integer.MAX_VALUE));
    }

    public void appendDescription (ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {}

    @Override
    public void appendTooltip (ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.of(""));
        this.appendDescription(stack, world, tooltip, context);
        tooltip.add(Text.of(""));
    }

    public void setStatus (Entity user, boolean status, ItemStack stack) {
        NbtCompound nbt = stack.getOrCreateNbt();
        nbt.putBoolean("status", status);
        if (this.getStatus(stack)) this.onEnable(user, status, stack);
        else this.onDisable(user, status, stack);
        this.onSwitch(user, status, stack);
    }

    public void onEnable (Entity entity, boolean status, ItemStack stack) {}
    public void onDisable (Entity entity, boolean status, ItemStack stack) {}
    public void onSwitch (Entity entity, boolean status, ItemStack stack) {}

    public boolean getStatus (ItemStack stack) {
        NbtCompound nbt = stack.getOrCreateNbt();
        if (!nbt.contains("status")) nbt.putBoolean("status", true);
        boolean status = nbt.getBoolean("status");
        stack.setDamage(status ? 0 : (int) (stack.getMaxDamage() - (stack.getMaxDamage() * 0.2)));
        return status;
    }

    @Override
    public void onEquip (ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);
        this.setStatus(entity, true, stack);
        this.onEnable(entity, true, stack);
        this.onSwitch(entity, true, stack);
    }

    @Override
    public void onUnequip (ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onUnequip(stack, slot, entity);
        this.setStatus(entity, false, stack);
        this.onDisable(entity, false, stack);
        this.onSwitch(entity, false, stack);
    }
}
