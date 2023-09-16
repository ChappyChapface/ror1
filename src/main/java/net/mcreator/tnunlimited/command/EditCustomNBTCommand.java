
package net.mcreator.tnunlimited.command;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import net.mcreator.tnunlimited.procedures.NBTCommandStaticPotionsProcedure;
import net.mcreator.tnunlimited.procedures.NBTCommandStaticEnchantsProcedure;
import net.mcreator.tnunlimited.procedures.NBTCommandStaicLoadoutProcedure;

import com.mojang.brigadier.arguments.BoolArgumentType;

@Mod.EventBusSubscriber
public class EditCustomNBTCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("editCustomNbt").requires(s -> s.hasPermission(2))
				.then(Commands.literal("entity").then(Commands.argument("target", EntityArgument.entity()).then(Commands.literal("staticLoadout").then(Commands.argument("logic", BoolArgumentType.bool()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					NBTCommandStaicLoadoutProcedure.execute(arguments);
					return 0;
				}))).then(Commands.literal("staticEnchants").then(Commands.argument("logic", BoolArgumentType.bool()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					NBTCommandStaticEnchantsProcedure.execute(arguments);
					return 0;
				}))).then(Commands.literal("staticPotions").then(Commands.argument("logic", BoolArgumentType.bool()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					NBTCommandStaticPotionsProcedure.execute(arguments);
					return 0;
				}))))));
	}
}
