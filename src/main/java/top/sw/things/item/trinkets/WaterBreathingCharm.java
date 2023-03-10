package top.sw.things.item.trinkets;

import dev.emi.trinkets.api.SlotReference;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import top.sw.things.utils.item.SwitchableTrinket;

import java.util.List;


public class WaterBreathingCharm extends SwitchableTrinket {

    public WaterBreathingCharm (Settings settings) {
        super(settings.rarity(Rarity.RARE));
    }

    @Override
    public void tick (ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.tick(stack, slot, entity);
        entity.setAir(entity.getMaxAir());
    }

    @Override
    public void appendDescription (ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendDescription(stack, world, tooltip, context);
        tooltip.add(Text.translatable("item.things.water_breathing_charm.tooltip"));
    }

    @Override
    public void onEnable (Entity entity, boolean status, ItemStack stack) {
        super.onEnable(entity, status, stack);
        entity.playSound(SoundEvents.BLOCK_AMETHYST_BLOCK_PLACE, 1, 0);
    }

    @Override
    public void onDisable (Entity entity, boolean status, ItemStack stack) {
        super.onDisable(entity, status, stack);
        entity.playSound(SoundEvents.BLOCK_AMETHYST_BLOCK_BREAK, 1, 0);
    }
}
