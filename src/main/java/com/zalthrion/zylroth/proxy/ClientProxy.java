package com.zalthrion.zylroth.proxy;

import java.util.HashMap;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.zalthrion.zylroth.block.tree.RainbowLeafBlock;
import com.zalthrion.zylroth.block.tree.RainbowLeafBlock2;
import com.zalthrion.zylroth.block.tree.RainbowSaplingBlock;
import com.zalthrion.zylroth.entity.*;
import com.zalthrion.zylroth.entity.boss.EntityTenebraeGuardian;
import com.zalthrion.zylroth.entity.boss.EntityVoidLordBoss;
import com.zalthrion.zylroth.entity.dev.EntitySixOneThree;
import com.zalthrion.zylroth.entity.dev.EntityZalthrion;
import com.zalthrion.zylroth.entity.mount.MountDeathcharger;
import com.zalthrion.zylroth.entity.mount.MountPlaguedHorse;
import com.zalthrion.zylroth.entity.mount.MountSavageBadger;
import com.zalthrion.zylroth.entity.mount.MountSwiftUnicorn;
import com.zalthrion.zylroth.entity.mount.MountWarTortoise;
import com.zalthrion.zylroth.event.KeyInputEvent;
import com.zalthrion.zylroth.handler.ModelHelper;
import com.zalthrion.zylroth.itemblock.tree.RainbowLeafItemBlock;
import com.zalthrion.zylroth.itemblock.tree.RainbowSaplingItemBlock;
import com.zalthrion.zylroth.lib.ModArmors;
import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.lib.ModTools;
import com.zalthrion.zylroth.model.armor.ModelVoidLordArmor;
import com.zalthrion.zylroth.render.ModeledBlockInventoryRenderer;
import com.zalthrion.zylroth.render.entity.RenderBoar;
import com.zalthrion.zylroth.render.factory.*;
import com.zalthrion.zylroth.render.tile.RenderTileEntityGoldBag;
import com.zalthrion.zylroth.render.tile.RenderTileEntityInfuser;
import com.zalthrion.zylroth.tile.TileEntityGoldBag;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

public class ClientProxy extends ServerProxy {
	
	public static final HashMap<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();
	
	@Override public void preInit() {
		/* Animals */
		RenderingRegistry.registerEntityRenderingHandler(EntityBird.class, new EntityBirdRenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityRainbowPig.class, new EntityRainbowPigRenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityBadger.class, new EntityBadgerRenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityFancyBadger.class, new EntityFancyBadgerRenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityBoar.class, new RenderBoar.EntityBoarRenderFactory());
		/* Mobs */
		RenderingRegistry.registerEntityRenderingHandler(EntityTenebraeGuardian.class, new EntityTenebraeGuardianRenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityVoidLordBoss.class, new EntityVoidLordBossRenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityUndeadWarrior.class, new EntityUndeadWarriorRenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityUndeadMinion.class, new EntityUndeadMinionRenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityTenebraeProtector.class, new EntityTenebraeProtectorRenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityVoidDragon.class, new EntityVoidDragonRenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntitySkeletalHorse.class, new EntitySkeletalHorseRenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityUnicorn.class, new EntityUnicornRenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityDeer.class, new EntityDeerRenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityStag.class, new EntityStagRenderFactory());
		/* Mounts */
		RenderingRegistry.registerEntityRenderingHandler(MountDeathcharger.class, new MountDeathchargerRenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(MountPlaguedHorse.class, new MountPlaguedHorseRenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(MountWarTortoise.class, new MountWarTortoiseRenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(MountSavageBadger.class, new MountSavageBadgerRenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(MountSwiftUnicorn.class, new MountSwiftUnicornRenderFactory());
		/* Developers */
		RenderingRegistry.registerEntityRenderingHandler(EntityZalthrion.class, new EntityZalthrionRenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntitySixOneThree.class, new EntitySixOneThreeRenderFactory());
	}
	
	@Override
	public void init() {
		super.init();
		MinecraftForge.EVENT_BUS.register(new KeyInputEvent());
		this.registerRenderers();
		this.bindTileEntitySpecialRenderers();
		this.registerRenderInformation();
		this.registerItemRenderers();
	}
	
	public void bindTileEntitySpecialRenderers() {
/*		ModelHelper.removeBlockState(ModBlocks.infuser);
		ModelHelper.removeBlockState(ModBlocks.infuserIdle);
		ModelHelper.removeBlockState(ModBlocks.oreInfuser);
		ModelHelper.removeBlockState(ModBlocks.oreInfuserIdle);*/ // FIXME
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityInfuser.class, new RenderTileEntityInfuser());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGoldBag.class, new RenderTileEntityGoldBag());
	}
	
	public void registerRenderInformation() {
		TileEntityItemStackRenderer.instance = new ModeledBlockInventoryRenderer(TileEntityItemStackRenderer.instance);
	}
	
	public void registerItemRenderers() {
		/* Blocks */
		ModelHelper.registerBlock(ModBlocks.tenebraeOre);
		ModelHelper.registerBlock(ModBlocks.tenebraeBlock);
		ModelHelper.registerBlock(ModBlocks.tenebraeCore);
		ModelHelper.registerBlock(ModBlocks.chiseledTenebrae);
		ModelHelper.registerBlock(ModBlocks.infusedTenebrae);
/*		ModelHelper.registerBlock(ModBlocks.infuser);
		ModelHelper.registerBlock(ModBlocks.infuserIdle);
		ModelHelper.registerBlock(ModBlocks.oreInfuser);
		ModelHelper.registerBlock(ModBlocks.oreInfuserIdle);*/ // FIXME
		ModelHelper.registerBlock(ModBlocks.ashBlock);
		ModelHelper.registerBlock(ModBlocks.empoweredTenebraeCore);
		ModelHelper.registerBlock(ModBlocks.voidiumOre);
		ModelHelper.registerBlock(ModBlocks.inferniumOre);
		ModelHelper.registerBlock(ModBlocks.endiriteOre);
		ModelHelper.registerBlock(ModBlocks.rainbowSaplingBlock, (new StateMap.Builder()).withName(RainbowSaplingBlock.TYPE).withSuffix("_sapling").ignore(RainbowSaplingBlock.STAGE).build(), RainbowSaplingItemBlock.getVariants(), new int[] {0, 1, 2, 3, 4, 5});
		ModelHelper.registerBlock(ModBlocks.rainbowLeafBlock, (new StateMap.Builder()).withName(RainbowLeafBlock.TYPE).withSuffix("_leaves").ignore(RainbowLeafBlock.CHECK_DECAY).ignore(RainbowLeafBlock.DECAYABLE).build(), RainbowLeafItemBlock.getVariants(0), new int[] {0, 1, 2, 3});
		ModelHelper.registerBlock(ModBlocks.rainbowLeafBlock2, (new StateMap.Builder()).withName(RainbowLeafBlock2.TYPE).withSuffix("_leaves").ignore(RainbowLeafBlock2.CHECK_DECAY).ignore(RainbowLeafBlock2.DECAYABLE).build(), RainbowLeafItemBlock.getVariants(1), new int[] {4, 5});
		/* Items */
		/* Armors */
		ModelHelper.registerItem(ModArmors.tenebraeHelmet);
		ModelHelper.registerItem(ModArmors.tenebraeChestplate);
		ModelHelper.registerItem(ModArmors.tenebraeLeggings);
		ModelHelper.registerItem(ModArmors.tenebraeBoots);
		ModelHelper.registerItem(ModArmors.voidLordHelmet);
		ModelHelper.registerItem(ModArmors.voidLordChestplate);
		ModelHelper.registerItem(ModArmors.voidLordLeggings);
		ModelHelper.registerItem(ModArmors.voidLordBoots);
		ModelHelper.registerItem(ModArmors.rainbowGlasses);
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
		ModelHelper.registerItem(ModItems.tenebraeOre);
		ModelHelper.registerItem(ModItems.tenebraeIngot);
		ModelHelper.registerItem(ModItems.tenebraeChunk);
		ModelHelper.registerItem(ModItems.unstableTenebraeCore);
		/* Infernium */
		ModelHelper.registerItem(ModItems.rawInfernium);
		ModelHelper.registerItem(ModItems.inferniumIngot);
		/* Endirite */
		ModelHelper.registerItem(ModItems.endiriteChunk);
		ModelHelper.registerItem(ModItems.endiriteOre);
		ModelHelper.registerItem(ModItems.endiriteIngot);
		/* Voidium */
		ModelHelper.registerItem(ModItems.voidiumChunk);
		ModelHelper.registerItem(ModItems.voidiumOre);
		ModelHelper.registerItem(ModItems.voidiumIngot);
		/* Mounts */
		ModelHelper.registerItem(ModItems.Empty_SC);
		ModelHelper.registerItem(ModItems.SC_Deathcharger);
		ModelHelper.registerItem(ModItems.SC_PlaguedHorse);
		ModelHelper.registerItem(ModItems.SC_WarTortoise);
		/* Portals */
		ModelHelper.registerItem(ModItems.goldTalisman);
		ModelHelper.registerItem(ModItems.voidTalisman);
		ModelHelper.registerItem(ModItems.autumnTalisman);
		ModelHelper.registerItem(ModItems.iceTalisman);
		/* Others */
		ModelHelper.registerItem(ModItems.darkShard);
		ModelHelper.registerItem(ModItems.soulEssence);
		ModelHelper.registerItem(ModItems.cursedSoulEssence);
		ModelHelper.registerItem(ModItems.voidGem);
		ModelHelper.registerItem(ModItems.voidEssence);
		ModelHelper.registerItem(ModItems.tenebriumIngot);
	}
	
	public void registerRenderers() {
		/* Void Lord Armor */
		ModelVoidLordArmor voidLordArmor = new ModelVoidLordArmor();
		armorModels.put(ModArmors.voidLordHelmet, voidLordArmor);
		armorModels.put(ModArmors.voidLordChestplate, voidLordArmor);
		armorModels.put(ModArmors.voidLordLeggings, voidLordArmor);
		armorModels.put(ModArmors.voidLordBoots, voidLordArmor);
	}
}