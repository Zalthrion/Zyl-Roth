package com.zalthrion.zylroth.proxy;

import java.util.HashMap;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
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
import com.zalthrion.zylroth.entity.projectile.RepulsorBolt;
import com.zalthrion.zylroth.entity.projectile.RepulsorCannonBolt;
import com.zalthrion.zylroth.event.KeyInputEventListener;
import com.zalthrion.zylroth.item.block.RainbowLeafItemBlock;
import com.zalthrion.zylroth.item.block.RainbowSaplingItemBlock;
import com.zalthrion.zylroth.lib.ModInit.BlockInit;
import com.zalthrion.zylroth.lib.ModInit.ItemInit;
import com.zalthrion.zylroth.model.armor.ModelVoidLordArmor;
import com.zalthrion.zylroth.render.entity.*;
import com.zalthrion.zylroth.render.entity.dev.RenderSixOneThree;
import com.zalthrion.zylroth.render.entity.dev.RenderZalthrion;
import com.zalthrion.zylroth.render.entity.mount.RenderDeathcharger;
import com.zalthrion.zylroth.render.entity.mount.RenderPlaguedHorse;
import com.zalthrion.zylroth.render.entity.mount.RenderSavageBadger;
import com.zalthrion.zylroth.render.entity.mount.RenderSwiftUnicorn;
import com.zalthrion.zylroth.render.entity.mount.RenderWarTortoise;
import com.zalthrion.zylroth.utility.ModelHelper;

public class ClientProxy extends CommonProxy {
	public static final HashMap<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();
	
	@Override public void preInit() {
		super.preInit();
		this.registerEntityRenderers();
	}
	
	@Override public void init() {
		super.init();
		MinecraftForge.EVENT_BUS.register(new KeyInputEventListener());
		this.registerArmorModels();
		this.registerItemModels();
	}
	
	@Override public void postInit() {
		super.postInit();
	}
	
	public void registerArmorModels() {
		/* Void Lord Armor */
		ModelVoidLordArmor voidLordArmor = new ModelVoidLordArmor();
		armorModels.put(ItemInit.voidLordHelmet, voidLordArmor);
		armorModels.put(ItemInit.voidLordChestplate, voidLordArmor);
		armorModels.put(ItemInit.voidLordLeggings, voidLordArmor);
		armorModels.put(ItemInit.voidLordBoots, voidLordArmor);
	}
	
	public void registerEntityRenderers() {
		/* Animals */
		RenderingRegistry.registerEntityRenderingHandler(EntityBird.class, new RenderBird.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityRainbowPig.class, new RenderRainbowPig.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityBadger.class, new RenderBadger.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityFancyBadger.class, new RenderFancyBadger.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityBoar.class, new RenderBoar.Factory());
		/* Mobs */
		RenderingRegistry.registerEntityRenderingHandler(EntityTenebraeGuardian.class, new RenderTenebraeGuardian.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityVoidLordBoss.class, new RenderVoidLordBoss.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityUndeadWarrior.class, new RenderUndeadWarrior.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityUndeadMinion.class, new RenderUndeadMinion.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityTenebraeProtector.class, new RenderTenebraeProtector.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityVoidDragon.class, new RenderVoidDragon.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntitySkeletalHorse.class, new RenderSkeletalHorse.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityUnicorn.class, new RenderUnicorn.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityDeer.class, new RenderDeer.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityStag.class, new RenderStag.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityTuskarr.class, new RenderTuskarr.Factory());
		/* Mounts */
		RenderingRegistry.registerEntityRenderingHandler(MountDeathcharger.class, new RenderDeathcharger.Factory());
		RenderingRegistry.registerEntityRenderingHandler(MountPlaguedHorse.class, new RenderPlaguedHorse.Factory());
		RenderingRegistry.registerEntityRenderingHandler(MountWarTortoise.class, new RenderWarTortoise.Factory());
		RenderingRegistry.registerEntityRenderingHandler(MountSavageBadger.class, new RenderSavageBadger.Factory());
		RenderingRegistry.registerEntityRenderingHandler(MountSwiftUnicorn.class, new RenderSwiftUnicorn.Factory());
		/* Developers */
		RenderingRegistry.registerEntityRenderingHandler(EntityZalthrion.class, new RenderZalthrion.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntitySixOneThree.class, new RenderSixOneThree.Factory());
		/* Projectiles */
		RenderingRegistry.registerEntityRenderingHandler(RepulsorBolt.class, new RenderRepulsorBolt.Factory());
		RenderingRegistry.registerEntityRenderingHandler(RepulsorCannonBolt.class, new RenderRepulsorCannonBolt.Factory());
	}
	
	public void registerItemModels() {
		/* Blocks */
		ModelHelper.registerBlock(BlockInit.tenebraeOre);
		ModelHelper.registerBlock(BlockInit.tenebraeBlock);
		ModelHelper.registerBlock(BlockInit.tenebraeCore);
		ModelHelper.registerBlock(BlockInit.chiseledTenebrae);
		ModelHelper.registerBlock(BlockInit.infusedTenebrae);
		ModelHelper.registerBlock(BlockInit.infuser);
		ModelHelper.registerBlock(BlockInit.infuserIdle);
		ModelHelper.registerBlock(BlockInit.oreInfuser);
		ModelHelper.registerBlock(BlockInit.oreInfuserIdle);
		ModelHelper.registerBlock(BlockInit.ashBlock);
		ModelHelper.registerBlock(BlockInit.empoweredTenebraeCore);
		ModelHelper.registerBlock(BlockInit.voidiumOre);
		ModelHelper.registerBlock(BlockInit.inferniumOre);
		ModelHelper.registerBlock(BlockInit.endiriteOre);
		ModelHelper.registerBlock(BlockInit.rainbowSaplingBlock, (new StateMap.Builder()).withName(RainbowSaplingBlock.COLOR).withSuffix("_sapling").ignore(RainbowSaplingBlock.STAGE).build(), RainbowSaplingItemBlock.getVariants(), new int[] {0, 1, 2, 3, 4, 5});
		ModelHelper.registerBlock(BlockInit.rainbowLeafBlock, (new StateMap.Builder()).withName(RainbowLeafBlock.COLOR).withSuffix("_leaves").ignore(RainbowLeafBlock.CHECK_DECAY).ignore(RainbowLeafBlock.DECAYABLE).build(), RainbowLeafItemBlock.getVariants(0), new int[] {0, 1, 2, 3});
		ModelHelper.registerBlock(BlockInit.rainbowLeafBlock2, (new StateMap.Builder()).withName(RainbowLeafBlock2.COLOR).withSuffix("_leaves").ignore(RainbowLeafBlock2.CHECK_DECAY).ignore(RainbowLeafBlock2.DECAYABLE).build(), RainbowLeafItemBlock.getVariants(1), new int[] {4, 5});
		/* Items */
		/* Armors */
		ModelHelper.registerItem(ItemInit.tenebraeHelmet);
		ModelHelper.registerItem(ItemInit.tenebraeChestplate);
		ModelHelper.registerItem(ItemInit.tenebraeLeggings);
		ModelHelper.registerItem(ItemInit.tenebraeBoots);
		ModelHelper.registerItem(ItemInit.voidLordHelmet);
		ModelHelper.registerItem(ItemInit.voidLordChestplate);
		ModelHelper.registerItem(ItemInit.voidLordLeggings);
		ModelHelper.registerItem(ItemInit.voidLordBoots);
		ModelHelper.registerItem(ItemInit.rainbowGlasses);
		/* Tools */
		ModelHelper.registerItem(ItemInit.creativePickaxe);
		ModelHelper.registerItem(ItemInit.creativeShovel);
		ModelHelper.registerItem(ItemInit.creativeSword);
		ModelHelper.registerItem(ItemInit.creativeHoe);
		ModelHelper.registerItem(ItemInit.creativeAxe);
		
		ModelHelper.registerItem(ItemInit.tenebraePickaxe);
		ModelHelper.registerItem(ItemInit.tenebraeShovel);
		ModelHelper.registerItem(ItemInit.tenebraeSword);
		ModelHelper.registerItem(ItemInit.tenebraeHoe);
		ModelHelper.registerItem(ItemInit.tenebraeAxe);
		/* Tenebrae */
		ModelHelper.registerItem(ItemInit.tenebraeIOre);
		ModelHelper.registerItem(ItemInit.tenebraeIngot);
		ModelHelper.registerItem(ItemInit.tenebraeChunk);
		ModelHelper.registerItem(ItemInit.celestialCore);
		/* Infernium */
		ModelHelper.registerItem(ItemInit.rawInfernium);
		ModelHelper.registerItem(ItemInit.inferniumIngot);
		/* Endirite */
		ModelHelper.registerItem(ItemInit.endiriteChunk);
		ModelHelper.registerItem(ItemInit.endiriteIOre);
		ModelHelper.registerItem(ItemInit.endiriteIngot);
		/* Voidium */
		ModelHelper.registerItem(ItemInit.voidiumChunk);
		ModelHelper.registerItem(ItemInit.voidiumIOre);
		ModelHelper.registerItem(ItemInit.voidiumIngot);
		/* Mounts */
		ModelHelper.registerItem(ItemInit.Empty_SC);
		ModelHelper.registerItem(ItemInit.SC_Deathcharger);
		ModelHelper.registerItem(ItemInit.SC_PlaguedHorse);
		ModelHelper.registerItem(ItemInit.SC_WarTortoise);
		/* Portals */
		ModelHelper.registerItem(ItemInit.goldTalisman);
		ModelHelper.registerItem(ItemInit.voidTalisman);
		ModelHelper.registerItem(ItemInit.autumnTalisman);
		ModelHelper.registerItem(ItemInit.iceTalisman);
		/* Others */
		ModelHelper.registerItem(ItemInit.darkShard);
		ModelHelper.registerItem(ItemInit.soulEssence);
		ModelHelper.registerItem(ItemInit.cursedSoulEssence);
		ModelHelper.registerItem(ItemInit.voidGem);
		ModelHelper.registerItem(ItemInit.voidEssence);
		ModelHelper.registerItem(ItemInit.tenebriumIngot);
	}
}