package top.sw.things.item.tools;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyItem;

import java.util.List;

public class PortableSolarGenerator extends Item implements SimpleEnergyItem {
    public PortableSolarGenerator (Settings settings) {
        super (settings.maxCount(1).maxDamage(100000));
    }

    @Override
    public long getEnergyCapacity (ItemStack stack) {
        return this.getMaxDamage();
    }

    @Override
    public long getEnergyMaxInput (ItemStack stack) {
        return 0;
    }

    @Override
    public long getEnergyMaxOutput (ItemStack stack) {
        return 1000;
    }

    @Override
    public void inventoryTick (ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        stack.setDamage((int) (this.getEnergyCapacity(stack) - this.getStoredEnergy(stack)));
        if (world.getLightLevel(entity.getBlockPos()) > 8) {
            long added = this.getStoredEnergy(stack) + Math.abs(world.getLightLevel(entity.getBlockPos()) - 8);
            if (added < this.getEnergyCapacity(stack)) this.setStoredEnergy(stack, added);
            else this.setStoredEnergy(stack, this.getEnergyCapacity(stack));
        }
    }

    @Override
    public void appendTooltip (ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.of(""));
        tooltip.add(Text.translatable("item.things.portable_solar_generator.tooltip"));
        tooltip.add(Text.of(""));
        tooltip.add(Text.translatable("gui.things.energy_storage", this.getStoredEnergy(stack), this.getEnergyCapacity(stack)));
        tooltip.add(Text.of(""));
    }

}
