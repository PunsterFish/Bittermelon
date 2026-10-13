package com.site21.bittermelon.common.content.items;

import com.site21.bittermelon.common.content.blocks.electronics.intercom.IntercomBlockEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import static com.site21.bittermelon.init.neoforge.BitterDataComponents.CORD_CONNECTION;

public class IntercomPhoneItem extends Item {
    public IntercomPhoneItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, EquipmentSlot slot) {
        BlockPos pos = stack.get(CORD_CONNECTION.get());

        if (pos == null) return;
        if (!(entity instanceof ServerPlayer player)) return;

        if (level.getBlockEntity(pos) instanceof IntercomBlockEntity intercom) {
            if (slot != EquipmentSlot.MAINHAND && slot != EquipmentSlot.OFFHAND) {
                disconnectPhone(stack, level, pos, intercom);
                player.sendSystemMessage(Component.literal("You must hold the phone.").withStyle(ChatFormatting.RED));
            } else if (entity.distanceToSqr(pos.getX(), pos.getY(), pos.getZ()) > 4) {
                disconnectPhone(stack, level, pos, intercom);
                player.sendSystemMessage(Component.literal("You must stay within range.").withStyle(ChatFormatting.RED));
            }

            return;
        }

        stack.remove(CORD_CONNECTION.get());
    }

    private void disconnectPhone(ItemStack stack, ServerLevel level, BlockPos pos, IntercomBlockEntity intercom) {
            stack.setCount(0);
            intercom.setPhonePickedUp(false);
            intercom.setPhoneUser(null);
            level.playSound(null, pos, SoundEvents.HEAVY_CORE_HIT, SoundSource.PLAYERS);
    }
}
