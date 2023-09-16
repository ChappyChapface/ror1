package net.mcreator.tnunlimited.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.tnunlimited.TnunlimitedMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TnunlimitedModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		TnunlimitedMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		TnunlimitedMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.slashStrengthIncrease = original.slashStrengthIncrease;
			clone.bluntStrengthIncrease = original.bluntStrengthIncrease;
			clone.gunStrengthIncrease = original.gunStrengthIncrease;
			clone.swimSpeedIncrease = original.swimSpeedIncrease;
			clone.movementSpeedIncrease = original.movementSpeedIncrease;
			clone.familiarStrengthIncrease = original.familiarStrengthIncrease;
			clone.Acc01 = original.Acc01;
			clone.Acc02 = original.Acc02;
			clone.Acc00 = original.Acc00;
			clone.OmniStrengthIncrease = original.OmniStrengthIncrease;
			clone.ArmorIncrease = original.ArmorIncrease;
			clone.HPDisplay = original.HPDisplay;
			clone.STR = original.STR;
			clone.ArmorDisplay = original.ArmorDisplay;
			clone.gunSTR = original.gunSTR;
			clone.movementSPD = original.movementSPD;
			clone.slashSTR = original.slashSTR;
			clone.familiarSTR = original.familiarSTR;
			clone.armorMultDisplay = original.armorMultDisplay;
			clone.swimSPD = original.swimSPD;
			clone.SatDisplay = original.SatDisplay;
			clone.bluntSTR = original.bluntSTR;
			clone.hpMult = original.hpMult;
			clone.familiarArmor = original.familiarArmor;
			clone.familiarSPD = original.familiarSPD;
			clone.familiarArmorDisplay = original.familiarArmorDisplay;
			clone.familiarSPDIncrease = original.familiarSPDIncrease;
			clone.mana = original.mana;
			clone.maxMana = original.maxMana;
			clone.manaRegenDelay = original.manaRegenDelay;
			clone.hpAdd = original.hpAdd;
			clone.gravityChange = original.gravityChange;
			clone.armorRawIncrease = original.armorRawIncrease;
			clone.kbChange = original.kbChange;
			clone.tempSTR = original.tempSTR;
			clone.fistSTR = original.fistSTR;
			clone.piercingSTR = original.piercingSTR;
			clone.tempPierce = original.tempPierce;
			clone.reachChange = original.reachChange;
			clone.AtkSpd = original.AtkSpd;
			clone.AtkSpdIncrease = original.AtkSpdIncrease;
			clone.nitroclaymorecharge = original.nitroclaymorecharge;
			clone.nitroknifecharge = original.nitroknifecharge;
			clone.piercingDMG = original.piercingDMG;
			clone.LuckIncrease = original.LuckIncrease;
			clone.KnockbackIncrease = original.KnockbackIncrease;
			clone.damegetype = original.damegetype;
			clone.rpgClass = original.rpgClass;
			clone.reachDisplay = original.reachDisplay;
			clone.magicSTR = original.magicSTR;
			clone.magicSTRIncrease = original.magicSTRIncrease;
			clone.rangedSTR = original.rangedSTR;
			clone.kbrDisplay = original.kbrDisplay;
			clone.totalDamage = original.totalDamage;
			clone.sampleRecieved = original.sampleRecieved;
			clone.tankClassUnlock = original.tankClassUnlock;
			clone.PlayerItem = original.PlayerItem;
			clone.playerYaw = original.playerYaw;
			clone.playerPitch = original.playerPitch;
			if (!event.isWasDeath()) {
				clone.doubleJumps = original.doubleJumps;
				clone.page = original.page;
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level);
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (mapdata != null)
					TnunlimitedMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					TnunlimitedMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (worlddata != null)
					TnunlimitedMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "tnunlimited_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				TnunlimitedMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "tnunlimited_mapvars";
		public boolean dragon_killed = false;
		public double SessionLength = 0;
		public double NetherTowerLimitedCount = 0;
		public double energybladecharge = 0.0;
		public double worldAge = 0;
		public boolean stageSpawn = false;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			dragon_killed = nbt.getBoolean("dragon_killed");
			SessionLength = nbt.getDouble("SessionLength");
			NetherTowerLimitedCount = nbt.getDouble("NetherTowerLimitedCount");
			energybladecharge = nbt.getDouble("energybladecharge");
			worldAge = nbt.getDouble("worldAge");
			stageSpawn = nbt.getBoolean("stageSpawn");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putBoolean("dragon_killed", dragon_killed);
			nbt.putDouble("SessionLength", SessionLength);
			nbt.putDouble("NetherTowerLimitedCount", NetherTowerLimitedCount);
			nbt.putDouble("energybladecharge", energybladecharge);
			nbt.putDouble("worldAge", worldAge);
			nbt.putBoolean("stageSpawn", stageSpawn);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				TnunlimitedMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		public int type;
		public SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			if (this.data instanceof MapVariables _mapvars)
				_mapvars.read(buffer.readNbt());
			else if (this.data instanceof WorldVariables _worldvars)
				_worldvars.read(buffer.readNbt());
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("tnunlimited", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double slashStrengthIncrease = 0.0;
		public double bluntStrengthIncrease = 0;
		public double gunStrengthIncrease = 0.0;
		public double swimSpeedIncrease = 0;
		public double movementSpeedIncrease = 0;
		public double familiarStrengthIncrease = 0;
		public ItemStack Acc01 = ItemStack.EMPTY;
		public ItemStack Acc02 = ItemStack.EMPTY;
		public ItemStack Acc00 = ItemStack.EMPTY;
		public double OmniStrengthIncrease = 0;
		public double ArmorIncrease = 0;
		public double HPDisplay = 0;
		public double STR = 0;
		public double ArmorDisplay = 0;
		public double gunSTR = 0;
		public double movementSPD = 0;
		public double slashSTR = 0;
		public double familiarSTR = 0;
		public double armorMultDisplay = 0;
		public double swimSPD = 0;
		public double SatDisplay = 0;
		public double bluntSTR = 0;
		public double hpMult = 0;
		public double familiarArmor = 0;
		public double familiarSPD = 0;
		public double familiarArmorDisplay = 0;
		public double familiarSPDIncrease = 0;
		public double mana = 0;
		public double maxMana = 10.0;
		public double manaRegenDelay = 0;
		public double hpAdd = 0;
		public double gravityChange = 0;
		public double armorRawIncrease = 0;
		public double kbChange = 0;
		public double tempSTR = 0;
		public double doubleJumps = 0;
		public double fistSTR = 0;
		public double piercingSTR = 0;
		public double tempPierce = 0;
		public double reachChange = 0;
		public double AtkSpd = 0;
		public double AtkSpdIncrease = 0;
		public double nitroclaymorecharge = 0;
		public double nitroknifecharge = 0;
		public double piercingDMG = 0;
		public double LuckIncrease = 0;
		public double KnockbackIncrease = 0;
		public double damegetype = 0;
		public double rpgClass = 0;
		public double page = 0;
		public double reachDisplay = 0;
		public double magicSTR = 0;
		public double magicSTRIncrease = 0;
		public double rangedSTR = 0;
		public double kbrDisplay = 0;
		public double totalDamage = 0;
		public boolean sampleRecieved = false;
		public boolean tankClassUnlock = false;
		public ItemStack PlayerItem = ItemStack.EMPTY;
		public double playerYaw = 0;
		public double playerPitch = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				TnunlimitedMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("slashStrengthIncrease", slashStrengthIncrease);
			nbt.putDouble("bluntStrengthIncrease", bluntStrengthIncrease);
			nbt.putDouble("gunStrengthIncrease", gunStrengthIncrease);
			nbt.putDouble("swimSpeedIncrease", swimSpeedIncrease);
			nbt.putDouble("movementSpeedIncrease", movementSpeedIncrease);
			nbt.putDouble("familiarStrengthIncrease", familiarStrengthIncrease);
			nbt.put("Acc01", Acc01.save(new CompoundTag()));
			nbt.put("Acc02", Acc02.save(new CompoundTag()));
			nbt.put("Acc00", Acc00.save(new CompoundTag()));
			nbt.putDouble("OmniStrengthIncrease", OmniStrengthIncrease);
			nbt.putDouble("ArmorIncrease", ArmorIncrease);
			nbt.putDouble("HPDisplay", HPDisplay);
			nbt.putDouble("STR", STR);
			nbt.putDouble("ArmorDisplay", ArmorDisplay);
			nbt.putDouble("gunSTR", gunSTR);
			nbt.putDouble("movementSPD", movementSPD);
			nbt.putDouble("slashSTR", slashSTR);
			nbt.putDouble("familiarSTR", familiarSTR);
			nbt.putDouble("armorMultDisplay", armorMultDisplay);
			nbt.putDouble("swimSPD", swimSPD);
			nbt.putDouble("SatDisplay", SatDisplay);
			nbt.putDouble("bluntSTR", bluntSTR);
			nbt.putDouble("hpMult", hpMult);
			nbt.putDouble("familiarArmor", familiarArmor);
			nbt.putDouble("familiarSPD", familiarSPD);
			nbt.putDouble("familiarArmorDisplay", familiarArmorDisplay);
			nbt.putDouble("familiarSPDIncrease", familiarSPDIncrease);
			nbt.putDouble("mana", mana);
			nbt.putDouble("maxMana", maxMana);
			nbt.putDouble("manaRegenDelay", manaRegenDelay);
			nbt.putDouble("hpAdd", hpAdd);
			nbt.putDouble("gravityChange", gravityChange);
			nbt.putDouble("armorRawIncrease", armorRawIncrease);
			nbt.putDouble("kbChange", kbChange);
			nbt.putDouble("tempSTR", tempSTR);
			nbt.putDouble("doubleJumps", doubleJumps);
			nbt.putDouble("fistSTR", fistSTR);
			nbt.putDouble("piercingSTR", piercingSTR);
			nbt.putDouble("tempPierce", tempPierce);
			nbt.putDouble("reachChange", reachChange);
			nbt.putDouble("AtkSpd", AtkSpd);
			nbt.putDouble("AtkSpdIncrease", AtkSpdIncrease);
			nbt.putDouble("nitroclaymorecharge", nitroclaymorecharge);
			nbt.putDouble("nitroknifecharge", nitroknifecharge);
			nbt.putDouble("piercingDMG", piercingDMG);
			nbt.putDouble("LuckIncrease", LuckIncrease);
			nbt.putDouble("KnockbackIncrease", KnockbackIncrease);
			nbt.putDouble("damegetype", damegetype);
			nbt.putDouble("rpgClass", rpgClass);
			nbt.putDouble("page", page);
			nbt.putDouble("reachDisplay", reachDisplay);
			nbt.putDouble("magicSTR", magicSTR);
			nbt.putDouble("magicSTRIncrease", magicSTRIncrease);
			nbt.putDouble("rangedSTR", rangedSTR);
			nbt.putDouble("kbrDisplay", kbrDisplay);
			nbt.putDouble("totalDamage", totalDamage);
			nbt.putBoolean("sampleRecieved", sampleRecieved);
			nbt.putBoolean("tankClassUnlock", tankClassUnlock);
			nbt.put("PlayerItem", PlayerItem.save(new CompoundTag()));
			nbt.putDouble("playerYaw", playerYaw);
			nbt.putDouble("playerPitch", playerPitch);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			slashStrengthIncrease = nbt.getDouble("slashStrengthIncrease");
			bluntStrengthIncrease = nbt.getDouble("bluntStrengthIncrease");
			gunStrengthIncrease = nbt.getDouble("gunStrengthIncrease");
			swimSpeedIncrease = nbt.getDouble("swimSpeedIncrease");
			movementSpeedIncrease = nbt.getDouble("movementSpeedIncrease");
			familiarStrengthIncrease = nbt.getDouble("familiarStrengthIncrease");
			Acc01 = ItemStack.of(nbt.getCompound("Acc01"));
			Acc02 = ItemStack.of(nbt.getCompound("Acc02"));
			Acc00 = ItemStack.of(nbt.getCompound("Acc00"));
			OmniStrengthIncrease = nbt.getDouble("OmniStrengthIncrease");
			ArmorIncrease = nbt.getDouble("ArmorIncrease");
			HPDisplay = nbt.getDouble("HPDisplay");
			STR = nbt.getDouble("STR");
			ArmorDisplay = nbt.getDouble("ArmorDisplay");
			gunSTR = nbt.getDouble("gunSTR");
			movementSPD = nbt.getDouble("movementSPD");
			slashSTR = nbt.getDouble("slashSTR");
			familiarSTR = nbt.getDouble("familiarSTR");
			armorMultDisplay = nbt.getDouble("armorMultDisplay");
			swimSPD = nbt.getDouble("swimSPD");
			SatDisplay = nbt.getDouble("SatDisplay");
			bluntSTR = nbt.getDouble("bluntSTR");
			hpMult = nbt.getDouble("hpMult");
			familiarArmor = nbt.getDouble("familiarArmor");
			familiarSPD = nbt.getDouble("familiarSPD");
			familiarArmorDisplay = nbt.getDouble("familiarArmorDisplay");
			familiarSPDIncrease = nbt.getDouble("familiarSPDIncrease");
			mana = nbt.getDouble("mana");
			maxMana = nbt.getDouble("maxMana");
			manaRegenDelay = nbt.getDouble("manaRegenDelay");
			hpAdd = nbt.getDouble("hpAdd");
			gravityChange = nbt.getDouble("gravityChange");
			armorRawIncrease = nbt.getDouble("armorRawIncrease");
			kbChange = nbt.getDouble("kbChange");
			tempSTR = nbt.getDouble("tempSTR");
			doubleJumps = nbt.getDouble("doubleJumps");
			fistSTR = nbt.getDouble("fistSTR");
			piercingSTR = nbt.getDouble("piercingSTR");
			tempPierce = nbt.getDouble("tempPierce");
			reachChange = nbt.getDouble("reachChange");
			AtkSpd = nbt.getDouble("AtkSpd");
			AtkSpdIncrease = nbt.getDouble("AtkSpdIncrease");
			nitroclaymorecharge = nbt.getDouble("nitroclaymorecharge");
			nitroknifecharge = nbt.getDouble("nitroknifecharge");
			piercingDMG = nbt.getDouble("piercingDMG");
			LuckIncrease = nbt.getDouble("LuckIncrease");
			KnockbackIncrease = nbt.getDouble("KnockbackIncrease");
			damegetype = nbt.getDouble("damegetype");
			rpgClass = nbt.getDouble("rpgClass");
			page = nbt.getDouble("page");
			reachDisplay = nbt.getDouble("reachDisplay");
			magicSTR = nbt.getDouble("magicSTR");
			magicSTRIncrease = nbt.getDouble("magicSTRIncrease");
			rangedSTR = nbt.getDouble("rangedSTR");
			kbrDisplay = nbt.getDouble("kbrDisplay");
			totalDamage = nbt.getDouble("totalDamage");
			sampleRecieved = nbt.getBoolean("sampleRecieved");
			tankClassUnlock = nbt.getBoolean("tankClassUnlock");
			PlayerItem = ItemStack.of(nbt.getCompound("PlayerItem"));
			playerYaw = nbt.getDouble("playerYaw");
			playerPitch = nbt.getDouble("playerPitch");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.slashStrengthIncrease = message.data.slashStrengthIncrease;
					variables.bluntStrengthIncrease = message.data.bluntStrengthIncrease;
					variables.gunStrengthIncrease = message.data.gunStrengthIncrease;
					variables.swimSpeedIncrease = message.data.swimSpeedIncrease;
					variables.movementSpeedIncrease = message.data.movementSpeedIncrease;
					variables.familiarStrengthIncrease = message.data.familiarStrengthIncrease;
					variables.Acc01 = message.data.Acc01;
					variables.Acc02 = message.data.Acc02;
					variables.Acc00 = message.data.Acc00;
					variables.OmniStrengthIncrease = message.data.OmniStrengthIncrease;
					variables.ArmorIncrease = message.data.ArmorIncrease;
					variables.HPDisplay = message.data.HPDisplay;
					variables.STR = message.data.STR;
					variables.ArmorDisplay = message.data.ArmorDisplay;
					variables.gunSTR = message.data.gunSTR;
					variables.movementSPD = message.data.movementSPD;
					variables.slashSTR = message.data.slashSTR;
					variables.familiarSTR = message.data.familiarSTR;
					variables.armorMultDisplay = message.data.armorMultDisplay;
					variables.swimSPD = message.data.swimSPD;
					variables.SatDisplay = message.data.SatDisplay;
					variables.bluntSTR = message.data.bluntSTR;
					variables.hpMult = message.data.hpMult;
					variables.familiarArmor = message.data.familiarArmor;
					variables.familiarSPD = message.data.familiarSPD;
					variables.familiarArmorDisplay = message.data.familiarArmorDisplay;
					variables.familiarSPDIncrease = message.data.familiarSPDIncrease;
					variables.mana = message.data.mana;
					variables.maxMana = message.data.maxMana;
					variables.manaRegenDelay = message.data.manaRegenDelay;
					variables.hpAdd = message.data.hpAdd;
					variables.gravityChange = message.data.gravityChange;
					variables.armorRawIncrease = message.data.armorRawIncrease;
					variables.kbChange = message.data.kbChange;
					variables.tempSTR = message.data.tempSTR;
					variables.doubleJumps = message.data.doubleJumps;
					variables.fistSTR = message.data.fistSTR;
					variables.piercingSTR = message.data.piercingSTR;
					variables.tempPierce = message.data.tempPierce;
					variables.reachChange = message.data.reachChange;
					variables.AtkSpd = message.data.AtkSpd;
					variables.AtkSpdIncrease = message.data.AtkSpdIncrease;
					variables.nitroclaymorecharge = message.data.nitroclaymorecharge;
					variables.nitroknifecharge = message.data.nitroknifecharge;
					variables.piercingDMG = message.data.piercingDMG;
					variables.LuckIncrease = message.data.LuckIncrease;
					variables.KnockbackIncrease = message.data.KnockbackIncrease;
					variables.damegetype = message.data.damegetype;
					variables.rpgClass = message.data.rpgClass;
					variables.page = message.data.page;
					variables.reachDisplay = message.data.reachDisplay;
					variables.magicSTR = message.data.magicSTR;
					variables.magicSTRIncrease = message.data.magicSTRIncrease;
					variables.rangedSTR = message.data.rangedSTR;
					variables.kbrDisplay = message.data.kbrDisplay;
					variables.totalDamage = message.data.totalDamage;
					variables.sampleRecieved = message.data.sampleRecieved;
					variables.tankClassUnlock = message.data.tankClassUnlock;
					variables.PlayerItem = message.data.PlayerItem;
					variables.playerYaw = message.data.playerYaw;
					variables.playerPitch = message.data.playerPitch;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
