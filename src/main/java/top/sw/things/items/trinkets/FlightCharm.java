package top.sw.things.items.trinkets;

import dev.emi.trinkets.api.SlotReference;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;

import java.util.List;

import top.sw.things.utils.item.SwitchableTrinket;

public class FlightCharm extends SwitchableTrinket {

    public FlightCharm (Settings settings) {
        super(settings.rarity(Rarity.RARE));
    }

    @Override
    public void tick (ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.tick(stack, slot, entity);
        if (!entity.isPlayer()) return;
        PlayerEntity player = (PlayerEntity) entity;
        PlayerAbilities abilities = player.getAbilities();
        if (abilities.creativeMode) {
            abilities.allowFlying = true;
            player.sendAbilitiesUpdate();
            return;
        }
        int nextExp = player.getNextLevelExperience();
        if (abilities.flying && (entity.world.getTime() % 20 == 0)) {
            if (player.experienceProgress == 0) {
                player.addExperienceLevels(-1);
                player.addExperience(nextExp - 1);
            } else if (player.experienceLevel != 0) player.addExperience(-1);

        }
        if (player.experienceLevel <= 0 && player.experienceProgress < 1) abilities.flying = false;
        else abilities.allowFlying = true;
        player.sendAbilitiesUpdate();
    }

    @Override
    public void appendDescription (ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendDescription(stack, world, tooltip, context);
        tooltip.add(Text.translatable("item.things.flight_charm.tooltip"));
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
        super.onDisable(entity, status, stack);
        PlayerEntity player = (PlayerEntity) entity;
        PlayerAbilities abilities = player.getAbilities();
        if (!abilities.creativeMode) {
            abilities.allowFlying = false;
            abilities.flying = false;
            player.sendAbilitiesUpdate();
        }
    }
}
