package com.zalthrion.zylroth.proxy;

import java.util.HashMap;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelHorse;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.zalthrion.zylroth.entity.*;
import com.zalthrion.zylroth.entity.boss.EntityEmpoweredTenebraeGolem;
import com.zalthrion.zylroth.entity.boss.EntityPyroKnight;
import com.zalthrion.zylroth.entity.mount.MountDeathcharger;
import com.zalthrion.zylroth.entity.mount.MountPlaguedHorse;
import com.zalthrion.zylroth.entity.mount.MountSavageBadger;
import com.zalthrion.zylroth.entity.mount.MountSwiftUnicorn;
import com.zalthrion.zylroth.entity.mount.MountWarTortoise;
import com.zalthrion.zylroth.handler.ModelHelper;
import com.zalthrion.zylroth.lib.ModArmors;
import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.lib.ModTools;
import com.zalthrion.zylroth.model.armor.ModelVoidLordArmor;
import com.zalthrion.zylroth.model.entity.*;
import com.zalthrion.zylroth.model.entity.mount.ModelDeathcharger;
import com.zalthrion.zylroth.model.entity.mount.ModelPlaguedHorse;
import com.zalthrion.zylroth.model.entity.mount.ModelWarTortoise;
import com.zalthrion.zylroth.render.ModeledBlockInventoryRenderer;
import com.zalthrion.zylroth.render.entity.*;
import com.zalthrion.zylroth.render.entity.mount.RenderDeathcharger;
import com.zalthrion.zylroth.render.entity.mount.RenderPlaguedHorse;
import com.zalthrion.zylroth.render.entity.mount.RenderSavageBadger;
import com.zalthrion.zylroth.render.entity.mount.RenderSwiftUnicorn;
import com.zalthrion.zylroth.render.entity.mount.RenderWarTortoise;
import com.zalthrion.zylroth.render.tile.RenderTileEntityInfuser;
import com.zalthrion.zylroth.render.tile.RenderTileEntityOreInfuser;
import com.zalthrion.zylroth.tile.TileEntityInfuser;
import com.zalthrion.zylroth.tile.TileEntityOreInfuser;

public class ClientProxy extends CommonProxy {
	
	public static final HashMap<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();
	
	@Override
	public void init() {
		super.init();
		this.registerRenderers();
	}
	
	@Override public void bindTileEntitySpecialRenderers() {
		ModelHelper.removeblockstate(ModBlocks.infuser);
		ModelHelper.removeblockstate(ModBlocks.infuserIdle);
		ModelHelper.removeblockstate(ModBlocks.oreInfuser);
		ModelHelper.removeblockstate(ModBlocks.oreInfuserIdle);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityInfuser.class, new RenderTileEntityInfuser());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOreInfuser.class, new RenderTileEntityOreInfuser());
	}
	
	@Override public void registerRenderInformation() {
		TileEntityItemStackRenderer.instance = new ModeledBlockInventoryRenderer(TileEntityItemStackRenderer.instance);
	}
	
	@Override
	public void registerItemRenderers() {
		/* Blocks */
		ModelHelper.registerBlock(ModBlocks.tenebraeOre);
		ModelHelper.registerBlock(ModBlocks.tenebraeBlock);
		ModelHelper.registerBlock(ModBlocks.tenebraeCore);
		ModelHelper.registerBlock(ModBlocks.chiseledTenebrae);
		ModelHelper.registerBlock(ModBlocks.infusedTenebrae);
		ModelHelper.registerBlock(ModBlocks.infuser);
		ModelHelper.registerBlock(ModBlocks.infuserIdle);
		ModelHelper.registerBlock(ModBlocks.ashBlock);
		ModelHelper.registerBlock(ModBlocks.empoweredTenebraeCore);
		ModelHelper.registerBlock(ModBlocks.voidiumOre);
		/* Items */
		/* Armors */
		ModelHelper.registerItem(ModArmors.tenebraeHelmet);
		ModelHelper.registerItem(ModArmors.tenebraeChestplate);
		ModelHelper.registerItem(ModArmors.tenebraeLeggings);
		ModelHelper.registerItem(ModArmors.tenebraeBoots);
		/* Tools */
		ModelHelper.registerItem(ModTools.creativePickaxe);
		ModelHelper.registerItem(ModTools.creativeShovel);
		ModelHelper.registerItem(ModTools.creativeSword);
		ModelHelper.registerItem(ModTools.creativeHoe);
		ModelHelper.registerItem(ModTools.creativeAxe);
		
		ModelHelper.registerItem(ModTools.tenebraePickaxe);
		ModelHelper.registerItem(ModTools.tenebraeShovel);
		ModelHelper.registerItem(ModTools.tenebraeSword);
		ModelHelper.registerItem(ModTools.tenebraeHoe);
		ModelHelper.registerItem(ModTools.tenebraeAxe);
		/* Tenebrae */
		ModelHelper.registerItem(ModItems.tenebraeIngot);
		ModelHelper.registerItem(ModItems.unstableTenebraeCore);
		/* Mounts */
		ModelHelper.registerItem(ModItems.Empty_SC);
		ModelHelper.registerItem(ModItems.SC_Deathcharger);
		ModelHelper.registerItem(ModItems.SC_PlaguedHorse);
		ModelHelper.registerItem(ModItems.SC_WarTortoise);
		/* Portals */
		ModelHelper.registerItem(ModItems.goldTalisman);
		ModelHelper.registerItem(ModItems.voidTalisman);
		ModelHelper.registerItem(ModItems.rainbowTalisman);
		/* Others */
		ModelHelper.registerItem(ModItems.darkShard);
		ModelHelper.registerItem(ModItems.soulEssence);
		ModelHelper.registerItem(ModItems.cursedSoulEssence);
		ModelHelper.registerItem(ModItems.voidGem);
		ModelHelper.registerItem(ModItems.voidEssence);
	}
	
	@Override
	public void registerRenderers() {
		RenderManager rm = Minecraft.getMinecraft().getRenderManager();
		float shadowSize = 0.5F;
		/* Animals */
		RenderingRegistry.registerEntityRenderingHandler(EntityBird.class, new RenderBird(rm, new ModelBird(), shadowSize));
		RenderingRegistry.registerEntityRenderingHandler(EntityRainbowPig.class, new RenderRainbowPig(rm, new ModelRainbowPig(), shadowSize));
		RenderingRegistry.registerEntityRenderingHandler(EntityBadger.class, new RenderBadger(rm, new ModelBadger(), shadowSize));
		RenderingRegistry.registerEntityRenderingHandler(EntityFancyBadger.class, new RenderFancyBadger(rm, new ModelBadger(), shadowSize));
		/* Mobs */
		RenderingRegistry.registerEntityRenderingHandler(EntityEmpoweredTenebraeGolem.class, new RenderEmpoweredTenebraeGolem(rm, new ModelEmpoweredTenebraeGolem(), shadowSize));
		RenderingRegistry.registerEntityRenderingHandler(EntityPyroKnight.class, new RenderPyroKnight(rm, new ModelUndead(), shadowSize, shadowSize));
		RenderingRegistry.registerEntityRenderingHandler(EntityUndeadWarrior.class, new RenderUndeadWarrior(rm, new ModelUndead(), shadowSize, shadowSize));
		RenderingRegistry.registerEntityRenderingHandler(EntityUndeadMinion.class, new RenderUndeadMinion(rm, new ModelUndead(), shadowSize, shadowSize));
		RenderingRegistry.registerEntityRenderingHandler(EntityTenebraeGolem.class, new RenderTenebraeGolem(rm, new ModelTenebraeGolem(), shadowSize));
		RenderingRegistry.registerEntityRenderingHandler(EntityVoidDragon.class, new RenderVoidDragon(rm));
		RenderingRegistry.registerEntityRenderingHandler(EntitySkeletalHorse.class, new RenderSkeletalHorse(rm, new ModelHorse(), new ModelSkeletalHorse(), shadowSize));
		RenderingRegistry.registerEntityRenderingHandler(EntityUnicorn.class, new RenderUnicorn(rm, new ModelUnicorn(), shadowSize));
		/* Mounts */
		RenderingRegistry.registerEntityRenderingHandler(MountDeathcharger.class, new RenderDeathcharger(rm, new ModelHorse(), new ModelDeathcharger(), shadowSize));
		RenderingRegistry.registerEntityRenderingHandler(MountPlaguedHorse.class, new RenderPlaguedHorse(rm, new ModelHorse(), new ModelPlaguedHorse(), shadowSize));
		RenderingRegistry.registerEntityRenderingHandler(MountWarTortoise.class, new RenderWarTortoise(rm, new ModelWarTortoise(), shadowSize));
		RenderingRegistry.registerEntityRenderingHandler(MountSavageBadger.class, new RenderSavageBadger(rm, new ModelSavageBadger(), shadowSize));
		RenderingRegistry.registerEntityRenderingHandler(MountSwiftUnicorn.class, new RenderSwiftUnicorn(rm, new ModelSwiftUnicorn(), shadowSize));
		
		/* Void Lord Armor */
		
		ModelVoidLordArmor voidLordArmor = new ModelVoidLordArmor();
		
		armorModels.put(ModArmors.voidLordHelmet, voidLordArmor);
		armorModels.put(ModArmors.voidLordChestplate, voidLordArmor);
		armorModels.put(ModArmors.voidLordLeggings, voidLordArmor);
		armorModels.put(ModArmors.voidLordBoots, voidLordArmor);
	}
}