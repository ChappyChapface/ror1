
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tnunlimited.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.tnunlimited.block.entity.StrawberryBushstage4BlockEntity;
import net.mcreator.tnunlimited.block.entity.StrawberryBushstage3BlockEntity;
import net.mcreator.tnunlimited.block.entity.StrawberryBushstage2BlockEntity;
import net.mcreator.tnunlimited.block.entity.StrawberryBushstage1BlockEntity;
import net.mcreator.tnunlimited.block.entity.StrawberryBushstage0BlockEntity;
import net.mcreator.tnunlimited.block.entity.SpawningEyeBlockEntity;
import net.mcreator.tnunlimited.block.entity.BlenderBlockEntity;
import net.mcreator.tnunlimited.TnunlimitedMod;

public class TnunlimitedModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TnunlimitedMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> SPAWNING_EYE = register("spawning_eye", TnunlimitedModBlocks.SPAWNING_EYE, SpawningEyeBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> STRAWBERRY_BUSHSTAGE_4 = register("strawberry_bushstage_4", TnunlimitedModBlocks.STRAWBERRY_BUSHSTAGE_4, StrawberryBushstage4BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> STRAWBERRY_BUSHSTAGE_3 = register("strawberry_bushstage_3", TnunlimitedModBlocks.STRAWBERRY_BUSHSTAGE_3, StrawberryBushstage3BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> STRAWBERRY_BUSHSTAGE_0 = register("strawberry_bushstage_0", TnunlimitedModBlocks.STRAWBERRY_BUSHSTAGE_0, StrawberryBushstage0BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> STRAWBERRY_BUSHSTAGE_2 = register("strawberry_bushstage_2", TnunlimitedModBlocks.STRAWBERRY_BUSHSTAGE_2, StrawberryBushstage2BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> STRAWBERRY_BUSHSTAGE_1 = register("strawberry_bushstage_1", TnunlimitedModBlocks.STRAWBERRY_BUSHSTAGE_1, StrawberryBushstage1BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLENDER = register("blender", TnunlimitedModBlocks.BLENDER, BlenderBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
