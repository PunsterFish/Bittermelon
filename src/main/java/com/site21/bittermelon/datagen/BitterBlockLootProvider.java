package com.site21.bittermelon.datagen;

import com.site21.bittermelon.init.neoforge.BitterBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

import static com.site21.bittermelon.init.neoforge.BitterBlocks.*;

public class BitterBlockLootProvider extends BlockLootSubProvider {
    public BitterBlockLootProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS, registries);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BitterBlocks.BLOCKS.getEntries()
                .stream()
                .map(e -> (Block) e.value())
                .toList();
    }

    @Override
    protected void generate() {
        dropSelf(BitterBlocks.SMALL_CARDBOARD_BOX.get());
        dropSelf(BitterBlocks.ATM.get());
        dropSelf(BitterBlocks.CONTAINMENT_PANEL.get());
        dropSelf(BitterBlocks.THERMOMETER.get());
        dropSelf(BitterBlocks.INTERCOM.get());
        dropSelf(BitterBlocks.ENVIRONMENT_SENSOR.get());
        dropSelf(BitterBlocks.CONTAINMENT_ALARM.get());
        dropSelf(BitterBlocks.DETONATOR.get());
        dropSelf(BitterBlocks.SPEAKER.get());
        add(SECURE_DOOR.get(), createDoorTable(SECURE_DOOR.get()));
        add(KEYCARD_READER_SECURE_DOOR.get(), createDoorTable(KEYCARD_READER_SECURE_DOOR.get()));
        dropSelf(BitterBlocks.LARGE_SLIDING_DOOR.get()); // may drop multiple
        dropSelf(BitterBlocks.YELLOW_INSPECTION_POSTER.get());
        dropSelf(BitterBlocks.DISTRIBUTION_BOARD.get());
        dropSelf(BitterBlocks.SCP_151.get());
        dropSelf(BitterBlocks.PERSONNEL_TERMINAL.get());
        dropSelf(BitterBlocks.KEYCARD_PRINTER.get());
        add(WINDOWED_SLIDING_DOOR.get(), createDoorTable(WINDOWED_SLIDING_DOOR.get()));
        dropSelf(BitterBlocks.STICKY_NOTE.get());
        dropSelf(BitterBlocks.KEYCARD_READER.get());
        dropSelf(BitterBlocks.REDSTONE_DEVICE.get());
        dropSelf(BitterBlocks.EMERGENCY_EXIT_LAMP.get());

        dropSelf(BitterBlocks.RED_CAGE_LAMP.get());
        dropSelf(BitterBlocks.BLUE_CAGE_LAMP.get());
        dropSelf(BitterBlocks.GREEN_CAGE_LAMP.get());
        dropSelf(BitterBlocks.ORANGE_CAGE_LAMP.get());
        dropSelf(BitterBlocks.YELLOW_CAGE_LAMP.get());
        dropSelf(BitterBlocks.PURPLE_CAGE_LAMP.get());
        dropSelf(BitterBlocks.LIME_CAGE_LAMP.get());
        dropSelf(BitterBlocks.PINK_CAGE_LAMP.get());
        dropSelf(BitterBlocks.MAGENTA_CAGE_LAMP.get());
        dropSelf(BitterBlocks.CYAN_CAGE_LAMP.get());
        dropSelf(BitterBlocks.LIGHT_BLUE_CAGE_LAMP.get());
        dropSelf(BitterBlocks.CAGE_LAMP.get());

        dropSelf(BitterBlocks.LIGHT_GRAY_TELEVISION.get());
        dropSelf(BitterBlocks.LIGHT_GRAY_WALL_TELEVISION.get());
        dropSelf(BitterBlocks.PLASTIC_FLAMINGO.get());
        dropSelf(BitterBlocks.SCP_330.get());
        dropSelf(BitterBlocks.CAGE.get());
        dropSelf(BitterBlocks.EYEBALL_BLISTER.get());
        dropSelf(BitterBlocks.BLACK_WOODEN_SEAT.get());
        dropSelf(BitterBlocks.METAL_DRUM.get());
    }
}
