
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tnunlimited.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.tnunlimited.client.model.Modelwitch_hat;
import net.mcreator.tnunlimited.client.model.Modelwarcaster;
import net.mcreator.tnunlimited.client.model.Modelsteve;
import net.mcreator.tnunlimited.client.model.Modelsporcerer;
import net.mcreator.tnunlimited.client.model.Modelspike_projectile;
import net.mcreator.tnunlimited.client.model.Modelsomethingsomething;
import net.mcreator.tnunlimited.client.model.Modelslash2;
import net.mcreator.tnunlimited.client.model.Modelslash;
import net.mcreator.tnunlimited.client.model.Modelseraph_wings;
import net.mcreator.tnunlimited.client.model.Modelrose_gold_disk;
import net.mcreator.tnunlimited.client.model.Modelrose_gold;
import net.mcreator.tnunlimited.client.model.Modelnubrium_helmet;
import net.mcreator.tnunlimited.client.model.Modelmodel;
import net.mcreator.tnunlimited.client.model.Modelgranitehelmet;
import net.mcreator.tnunlimited.client.model.Modelgranitechestplate;
import net.mcreator.tnunlimited.client.model.Modelfrostburnt;
import net.mcreator.tnunlimited.client.model.Modelfrost_larva;
import net.mcreator.tnunlimited.client.model.Modelfrost_ant_queen;
import net.mcreator.tnunlimited.client.model.Modelfrost_ant;
import net.mcreator.tnunlimited.client.model.Modelender_protector;
import net.mcreator.tnunlimited.client.model.Modeldioritehelmet;
import net.mcreator.tnunlimited.client.model.ModeldioriteChestplate;
import net.mcreator.tnunlimited.client.model.Modeldeceased;
import net.mcreator.tnunlimited.client.model.Modelcustom_model;
import net.mcreator.tnunlimited.client.model.Modelcrow;
import net.mcreator.tnunlimited.client.model.Modelbloodrip_shoot;
import net.mcreator.tnunlimited.client.model.Modelblood_spheres;
import net.mcreator.tnunlimited.client.model.ModelWastelandish_Hopper;
import net.mcreator.tnunlimited.client.model.ModelRoachHelmet;
import net.mcreator.tnunlimited.client.model.ModelRoachChestplate;
import net.mcreator.tnunlimited.client.model.ModelRedstoneTreadling;
import net.mcreator.tnunlimited.client.model.ModelQueenLadyBugModel;
import net.mcreator.tnunlimited.client.model.ModelProphetHelmet;
import net.mcreator.tnunlimited.client.model.ModelPiranha;
import net.mcreator.tnunlimited.client.model.ModelPinacateBeetle;
import net.mcreator.tnunlimited.client.model.ModelPartyHat;
import net.mcreator.tnunlimited.client.model.ModelLapisTreadling;
import net.mcreator.tnunlimited.client.model.ModelLadybugmodele;
import net.mcreator.tnunlimited.client.model.ModelKkoreul;
import net.mcreator.tnunlimited.client.model.ModelJermaHelmetLayer2;
import net.mcreator.tnunlimited.client.model.ModelJermaHelmetLayer1;
import net.mcreator.tnunlimited.client.model.ModelJermaHelmet;
import net.mcreator.tnunlimited.client.model.ModelIceShootSword;
import net.mcreator.tnunlimited.client.model.ModelGildedBug;
import net.mcreator.tnunlimited.client.model.ModelGalvanizedHarpoon;
import net.mcreator.tnunlimited.client.model.ModelDuneSpider;
import net.mcreator.tnunlimited.client.model.ModelDart;
import net.mcreator.tnunlimited.client.model.ModelCoffeePotBug1;
import net.mcreator.tnunlimited.client.model.ModelCoalTreadling;
import net.mcreator.tnunlimited.client.model.ModelCaptainHat;
import net.mcreator.tnunlimited.client.model.ModelBirthdayBlockBoy;
import net.mcreator.tnunlimited.client.model.ModelBedrockAndy;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TnunlimitedModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelfrost_ant.LAYER_LOCATION, Modelfrost_ant::createBodyLayer);
		event.registerLayerDefinition(ModelCoalTreadling.LAYER_LOCATION, ModelCoalTreadling::createBodyLayer);
		event.registerLayerDefinition(Modelsomethingsomething.LAYER_LOCATION, Modelsomethingsomething::createBodyLayer);
		event.registerLayerDefinition(Modelspike_projectile.LAYER_LOCATION, Modelspike_projectile::createBodyLayer);
		event.registerLayerDefinition(Modelslash.LAYER_LOCATION, Modelslash::createBodyLayer);
		event.registerLayerDefinition(ModelLadybugmodele.LAYER_LOCATION, ModelLadybugmodele::createBodyLayer);
		event.registerLayerDefinition(Modelwarcaster.LAYER_LOCATION, Modelwarcaster::createBodyLayer);
		event.registerLayerDefinition(Modeldeceased.LAYER_LOCATION, Modeldeceased::createBodyLayer);
		event.registerLayerDefinition(ModelKkoreul.LAYER_LOCATION, ModelKkoreul::createBodyLayer);
		event.registerLayerDefinition(Modelcrow.LAYER_LOCATION, Modelcrow::createBodyLayer);
		event.registerLayerDefinition(Modelfrost_larva.LAYER_LOCATION, Modelfrost_larva::createBodyLayer);
		event.registerLayerDefinition(ModelJermaHelmetLayer2.LAYER_LOCATION, ModelJermaHelmetLayer2::createBodyLayer);
		event.registerLayerDefinition(ModelCaptainHat.LAYER_LOCATION, ModelCaptainHat::createBodyLayer);
		event.registerLayerDefinition(ModelRoachHelmet.LAYER_LOCATION, ModelRoachHelmet::createBodyLayer);
		event.registerLayerDefinition(Modelsporcerer.LAYER_LOCATION, Modelsporcerer::createBodyLayer);
		event.registerLayerDefinition(ModelQueenLadyBugModel.LAYER_LOCATION, ModelQueenLadyBugModel::createBodyLayer);
		event.registerLayerDefinition(ModelGildedBug.LAYER_LOCATION, ModelGildedBug::createBodyLayer);
		event.registerLayerDefinition(Modelgranitehelmet.LAYER_LOCATION, Modelgranitehelmet::createBodyLayer);
		event.registerLayerDefinition(Modelslash2.LAYER_LOCATION, Modelslash2::createBodyLayer);
		event.registerLayerDefinition(ModelCoffeePotBug1.LAYER_LOCATION, ModelCoffeePotBug1::createBodyLayer);
		event.registerLayerDefinition(Modelmodel.LAYER_LOCATION, Modelmodel::createBodyLayer);
		event.registerLayerDefinition(ModelJermaHelmet.LAYER_LOCATION, ModelJermaHelmet::createBodyLayer);
		event.registerLayerDefinition(ModelJermaHelmetLayer1.LAYER_LOCATION, ModelJermaHelmetLayer1::createBodyLayer);
		event.registerLayerDefinition(ModelRedstoneTreadling.LAYER_LOCATION, ModelRedstoneTreadling::createBodyLayer);
		event.registerLayerDefinition(Modelgranitechestplate.LAYER_LOCATION, Modelgranitechestplate::createBodyLayer);
		event.registerLayerDefinition(ModelWastelandish_Hopper.LAYER_LOCATION, ModelWastelandish_Hopper::createBodyLayer);
		event.registerLayerDefinition(ModelDuneSpider.LAYER_LOCATION, ModelDuneSpider::createBodyLayer);
		event.registerLayerDefinition(Modelfrostburnt.LAYER_LOCATION, Modelfrostburnt::createBodyLayer);
		event.registerLayerDefinition(Modelwitch_hat.LAYER_LOCATION, Modelwitch_hat::createBodyLayer);
		event.registerLayerDefinition(ModelProphetHelmet.LAYER_LOCATION, ModelProphetHelmet::createBodyLayer);
		event.registerLayerDefinition(Modelbloodrip_shoot.LAYER_LOCATION, Modelbloodrip_shoot::createBodyLayer);
		event.registerLayerDefinition(Modelseraph_wings.LAYER_LOCATION, Modelseraph_wings::createBodyLayer);
		event.registerLayerDefinition(ModelIceShootSword.LAYER_LOCATION, ModelIceShootSword::createBodyLayer);
		event.registerLayerDefinition(Modelsteve.LAYER_LOCATION, Modelsteve::createBodyLayer);
		event.registerLayerDefinition(ModelGalvanizedHarpoon.LAYER_LOCATION, ModelGalvanizedHarpoon::createBodyLayer);
		event.registerLayerDefinition(ModelBedrockAndy.LAYER_LOCATION, ModelBedrockAndy::createBodyLayer);
		event.registerLayerDefinition(Modelrose_gold_disk.LAYER_LOCATION, Modelrose_gold_disk::createBodyLayer);
		event.registerLayerDefinition(ModelPartyHat.LAYER_LOCATION, ModelPartyHat::createBodyLayer);
		event.registerLayerDefinition(ModelPiranha.LAYER_LOCATION, ModelPiranha::createBodyLayer);
		event.registerLayerDefinition(ModelRoachChestplate.LAYER_LOCATION, ModelRoachChestplate::createBodyLayer);
		event.registerLayerDefinition(ModelLapisTreadling.LAYER_LOCATION, ModelLapisTreadling::createBodyLayer);
		event.registerLayerDefinition(Modeldioritehelmet.LAYER_LOCATION, Modeldioritehelmet::createBodyLayer);
		event.registerLayerDefinition(Modelfrost_ant_queen.LAYER_LOCATION, Modelfrost_ant_queen::createBodyLayer);
		event.registerLayerDefinition(Modelblood_spheres.LAYER_LOCATION, Modelblood_spheres::createBodyLayer);
		event.registerLayerDefinition(ModeldioriteChestplate.LAYER_LOCATION, ModeldioriteChestplate::createBodyLayer);
		event.registerLayerDefinition(Modelcustom_model.LAYER_LOCATION, Modelcustom_model::createBodyLayer);
		event.registerLayerDefinition(ModelDart.LAYER_LOCATION, ModelDart::createBodyLayer);
		event.registerLayerDefinition(Modelrose_gold.LAYER_LOCATION, Modelrose_gold::createBodyLayer);
		event.registerLayerDefinition(Modelender_protector.LAYER_LOCATION, Modelender_protector::createBodyLayer);
		event.registerLayerDefinition(Modelnubrium_helmet.LAYER_LOCATION, Modelnubrium_helmet::createBodyLayer);
		event.registerLayerDefinition(ModelBirthdayBlockBoy.LAYER_LOCATION, ModelBirthdayBlockBoy::createBodyLayer);
		event.registerLayerDefinition(ModelPinacateBeetle.LAYER_LOCATION, ModelPinacateBeetle::createBodyLayer);
	}
}
