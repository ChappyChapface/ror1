
package net.mcreator.tnunlimited.command;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.Commands;

import net.mcreator.tnunlimited.procedures.SpawnStructureUndergroundHomeProcedure;
import net.mcreator.tnunlimited.procedures.SpawnStructurePitProcedure;
import net.mcreator.tnunlimited.procedures.SpawnStructurePirateShipProcedure;
import net.mcreator.tnunlimited.procedures.SpawnStructurePillagerCastleProcedure;
import net.mcreator.tnunlimited.procedures.SpawnStructurePalmTreeProcedure;
import net.mcreator.tnunlimited.procedures.SpawnStructureNetherTowerProcedure;
import net.mcreator.tnunlimited.procedures.SpawnStructureEcoTreeProcedure;
import net.mcreator.tnunlimited.procedures.SpawnStructureBlueShroomProcedure;
import net.mcreator.tnunlimited.procedures.SpawnStructureAntlionStatueProcedure;
import net.mcreator.tnunlimited.procedures.SpawnStructureAncientRuinsProcedure;
import net.mcreator.tnunlimited.procedures.SinChestStructureRequirementsProcedure;

import com.mojang.brigadier.arguments.DoubleArgumentType;

@Mod.EventBusSubscriber
public class SpawnstructureCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("spawnStructure").requires(s -> s.hasPermission(2)).then(Commands.argument("pos", BlockPosArgument.blockPos()).then(Commands.argument("rotation", DoubleArgumentType.doubleArg(0, 3))
				.then(Commands.argument("mirror", DoubleArgumentType.doubleArg(0, 2)).then(Commands.literal("blueshroom").then(Commands.argument("variation", DoubleArgumentType.doubleArg(0, 2)).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					SpawnStructureBlueShroomProcedure.execute(world, arguments);
					return 0;
				}))).then(Commands.literal("ancient_ruins").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					SpawnStructureAncientRuinsProcedure.execute(world, arguments);
					return 0;
				})).then(Commands.literal("antlion_statue").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					SpawnStructureAntlionStatueProcedure.execute(world, arguments);
					return 0;
				})).then(Commands.literal("pirate_ship").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					SpawnStructurePirateShipProcedure.execute(world, arguments);
					return 0;
				})).then(Commands.literal("nether_tower").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					SpawnStructureNetherTowerProcedure.execute(world, arguments);
					return 0;
				})).then(Commands.literal("underground_home").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					SpawnStructureUndergroundHomeProcedure.execute(world, arguments);
					return 0;
				})).then(Commands.literal("pit").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					SpawnStructurePitProcedure.execute(world, arguments);
					return 0;
				})).then(Commands.literal("palm_tree").then(Commands.argument("variation", DoubleArgumentType.doubleArg(0, 1)).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					SpawnStructurePalmTreeProcedure.execute(world, arguments);
					return 0;
				}))).then(Commands.literal("sin_structure").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					SinChestStructureRequirementsProcedure.execute(y);
					return 0;
				})).then(Commands.literal("eco_tree").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					SpawnStructureEcoTreeProcedure.execute(world, arguments);
					return 0;
				})).then(Commands.literal("pillager_castle").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					SpawnStructurePillagerCastleProcedure.execute(world, arguments);
					return 0;
				}))))));
	}
}
