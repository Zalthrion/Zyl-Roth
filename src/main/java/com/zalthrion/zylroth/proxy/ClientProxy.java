package com.zalthrion.zylroth.proxy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.zalthrion.zylroth.block.tree.IridisLeafBlock;
import com.zalthrion.zylroth.block.tree.IridisSaplingBlock;
import com.zalthrion.zylroth.block.tree.KyrulLeafBlock;
import com.zalthrion.zylroth.block.tree.KyrulSaplingBlock;
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
import com.zalthrion.zylroth.item.block.IridisLeafItemBlock;
import com.zalthrion.zylroth.item.block.IridisSaplingItemBlock;
import com.zalthrion.zylroth.item.block.KyrulLeafItemBlock;
import com.zalthrion.zylroth.item.block.KyrulSaplingItemBlock;
import com.zalthrion.zylroth.item.block.RainbowLeafItemBlock;
import com.zalthrion.zylroth.item.block.RainbowSaplingItemBlock;
import com.zalthrion.zylroth.lib.ModInit.BlockInit;
import com.zalthrion.zylroth.lib.ModInit.ItemInit;
import com.zalthrion.zylroth.model.armor.ModelVoidLordArmor;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.render.ZylrothRenderer;
import com.zalthrion.zylroth.render.entity.*;
import com.zalthrion.zylroth.render.entity.dev.RenderSixOneThree;
import com.zalthrion.zylroth.render.entity.dev.RenderZalthrion;
import com.zalthrion.zylroth.render.entity.mount.RenderDeathcharger;
import com.zalthrion.zylroth.render.entity.mount.RenderPlaguedHorse;
import com.zalthrion.zylroth.render.entity.mount.RenderSavageBadger;
import com.zalthrion.zylroth.render.entity.mount.RenderSwiftUnicorn;
import com.zalthrion.zylroth.render.entity.mount.RenderWarTortoise;
import com.zalthrion.zylroth.render.item.CustomItemModelFactory;
import com.zalthrion.zylroth.utility.ModelHelper;

public class ClientProxy extends CommonProxy {
	public static final HashMap<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();
	public static Map<String, ModelResourceLocation> itemResources = new HashMap<String, ModelResourceLocation>();
	
	public static final String[] CUSTOM_RENDERS = new String[] {"woodenCrossbow"};
	
	@Override public void preInit() {
		super.preInit();
		ZylrothRenderer.init();
		MinecraftForge.EVENT_BUS.register(this);
		this.registerEntityRenderers();
		this.registerSpecialItemRenderers();
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
		armorModels.put(ItemInit.VOID_LORD_HELMET, voidLordArmor);
		armorModels.put(ItemInit.VOID_LORD_CHESTPLATE, voidLordArmor);
		armorModels.put(ItemInit.VOID_LORD_LEGGINGS, voidLordArmor);
		armorModels.put(ItemInit.VOID_LORD_BOOTS, voidLordArmor);
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
		ModelHelper.registerBlock(BlockInit.TENEBRAE_ORE);
		ModelHelper.registerBlock(BlockInit.TENEBRAE_BLOCK);
		ModelHelper.registerBlock(BlockInit.TENEBRAE_CORE);
		ModelHelper.registerBlock(BlockInit.CHISELED_TENEBRAE);
		ModelHelper.registerBlock(BlockInit.INFUSED_TENEBRAE);
		ModelHelper.registerBlock(BlockInit.INFUSER);
		ModelHelper.registerBlock(BlockInit.INFUSER_IDLE);
		ModelHelper.registerBlock(BlockInit.ORE_INFUSER);
		ModelHelper.registerBlock(BlockInit.ORE_INFUSER_IDLE);
		ModelHelper.registerBlock(BlockInit.ASH_BLOCK);
		ModelHelper.registerBlock(BlockInit.EMPOWERED_TENEBRAE_CORE);
		ModelHelper.registerBlock(BlockInit.VOIDIUM_ORE);
		ModelHelper.registerBlock(BlockInit.INFERNIUM_ORE);
		ModelHelper.registerBlock(BlockInit.ENDIRITE_ORE);
		ModelHelper.registerBlock(BlockInit.RAINBOW_SAPLING_BLOCK, (new StateMap.Builder()).withName(RainbowSaplingBlock.COLOR).withSuffix("_sapling").ignore(RainbowSaplingBlock.STAGE).build(), RainbowSaplingItemBlock.getVariants(), new int[] {0, 1, 2, 3, 4, 5});
		ModelHelper.registerBlock(BlockInit.RAINBOW_LEAF_BLOCK, (new StateMap.Builder()).withName(RainbowLeafBlock.COLOR).withSuffix("_leaves").ignore(RainbowLeafBlock.CHECK_DECAY).ignore(RainbowLeafBlock.DECAYABLE).build(), RainbowLeafItemBlock.getVariants(0), new int[] {0, 1, 2, 3});
		ModelHelper.registerBlock(BlockInit.RAINBOW_LEAF_BLOCK_2, (new StateMap.Builder()).withName(RainbowLeafBlock2.COLOR).withSuffix("_leaves").ignore(RainbowLeafBlock2.CHECK_DECAY).ignore(RainbowLeafBlock2.DECAYABLE).build(), RainbowLeafItemBlock.getVariants(1), new int[] {4, 5});
		ModelHelper.registerBlock(BlockInit.IRIDIS_LEAF_BLOCK, (new StateMap.Builder()).withName(IridisLeafBlock.LEAF_TYPE).withSuffix("_leaves").ignore(IridisLeafBlock.CHECK_DECAY).ignore(IridisLeafBlock.DECAYABLE).build(), IridisLeafItemBlock.getVariants(0), new int[] {0, 1});
		ModelHelper.registerBlock(BlockInit.IRIDIS_SAPLING_BLOCK, (new StateMap.Builder()).withName(IridisSaplingBlock.SAPLING_TYPE).withSuffix("_sapling").ignore(IridisSaplingBlock.STAGE).build(), IridisSaplingItemBlock.getVariants(), new int[] {0, 1});
		ModelHelper.registerBlock(BlockInit.KYRUL_LEAF_BLOCK, (new StateMap.Builder()).withName(KyrulLeafBlock.TYPE).withSuffix("_leaves").ignore(KyrulLeafBlock.CHECK_DECAY).ignore(KyrulLeafBlock.DECAYABLE).build(), KyrulLeafItemBlock.getVariants(0), new int[] {0});
		ModelHelper.registerBlock(BlockInit.KYRUL_SAPLING_BLOCK, (new StateMap.Builder()).withName(KyrulSaplingBlock.TYPE).withSuffix("_sapling").ignore(KyrulSaplingBlock.STAGE).build(), KyrulSaplingItemBlock.getVariants(), new int[] {0});
		ModelHelper.registerBlock(BlockInit.KYRUL_LOG_BLOCK);
		ModelHelper.registerBlock(BlockInit.VOID_STONE);
		ModelHelper.registerBlock(BlockInit.VOID_PLANKS);
		/* Items */
		/* Armors */
		ModelHelper.registerItem(ItemInit.TENEBRAE_HELMET);
		ModelHelper.registerItem(ItemInit.TENEBRAE_CHESTPLATE);
		ModelHelper.registerItem(ItemInit.TENEBRAE_LEGGINGS);
		ModelHelper.registerItem(ItemInit.TENEBRAE_BOOTS);
		ModelHelper.registerItem(ItemInit.VOID_LORD_HELMET);
		ModelHelper.registerItem(ItemInit.VOID_LORD_CHESTPLATE);
		ModelHelper.registerItem(ItemInit.VOID_LORD_LEGGINGS);
		ModelHelper.registerItem(ItemInit.VOID_LORD_BOOTS);
		ModelHelper.registerItem(ItemInit.EMERALD_HELMET);
		ModelHelper.registerItem(ItemInit.EMERALD_CHESTPLATE);
		ModelHelper.registerItem(ItemInit.EMERALD_LEGGINGS);
		ModelHelper.registerItem(ItemInit.EMERALD_BOOTS);
		ModelHelper.registerItem(ItemInit.RAINBOW_GLASSES);
		/* Tools */
		ModelHelper.registerItem(ItemInit.CREATIVE_PICKAXE);
		ModelHelper.registerItem(ItemInit.CREATIVE_SHOVEL);
		ModelHelper.registerItem(ItemInit.CREATIVE_SWORD);
		ModelHelper.registerItem(ItemInit.CREATIVE_HOE);
		ModelHelper.registerItem(ItemInit.CREATIVE_AXE);
		
		ModelHelper.registerItem(ItemInit.TENEBRAE_PICKAXE);
		ModelHelper.registerItem(ItemInit.TENEBRAE_SHOVEL);
		ModelHelper.registerItem(ItemInit.TENEBRAE_SWORD);
		ModelHelper.registerItem(ItemInit.TENEBRAE_HOE);
		ModelHelper.registerItem(ItemInit.TENEBRAE_AXE);
		
		ModelHelper.registerItem(ItemInit.TENEBRAE_LEAF_CUTTER);
		/* Tenebrae */
		ModelHelper.registerItem(ItemInit.TENEBRAE_ORE_ITEM);
		ModelHelper.registerItem(ItemInit.TENEBRAE_INGOT);
		ModelHelper.registerItem(ItemInit.TENEBRAE_CHUNK);
		ModelHelper.registerItem(ItemInit.CELESTIAL_CORE);
		/* Infernium */
		ModelHelper.registerItem(ItemInit.RAW_INFERNIUM);
		ModelHelper.registerItem(ItemInit.INFERIUM_INGOT);
		/* Endirite */
		ModelHelper.registerItem(ItemInit.ENDIRITE_CHUNK);
		ModelHelper.registerItem(ItemInit.ENDIRITE_ORE_ITEM);
		ModelHelper.registerItem(ItemInit.ENDIRITE_INGOT);
		/* Voidium */
		ModelHelper.registerItem(ItemInit.VOIDIUM_CHUNK);
		ModelHelper.registerItem(ItemInit.VOIDIUM_ORE_ITEM);
		ModelHelper.registerItem(ItemInit.VOIDIUM_INGOT);
		/* Mounts */
		ModelHelper.registerItem(ItemInit.EMPTY_SC);
		ModelHelper.registerItem(ItemInit.SC_DEATHCHARGER);
		ModelHelper.registerItem(ItemInit.SC_PLAGUED_HORSE);
		ModelHelper.registerItem(ItemInit.SC_WAR_TORTOISE);
		/* Portals */
		ModelHelper.registerItem(ItemInit.GOLD_TALISMAN);
		ModelHelper.registerItem(ItemInit.VOID_TALISMAN);
		ModelHelper.registerItem(ItemInit.AUTUMN_TALISMAN);
		ModelHelper.registerItem(ItemInit.ICE_TALISMAN);
		/* Others */
		ModelHelper.registerItem(ItemInit.DARK_SHARD);
		ModelHelper.registerItem(ItemInit.SOUL_ESSENCE);
		ModelHelper.registerItem(ItemInit.CURSED_SOUL_ESSENCE);
		ModelHelper.registerItem(ItemInit.VOID_GEM);
		ModelHelper.registerItem(ItemInit.VOID_ESSENCE);
		ModelHelper.registerItem(ItemInit.TENEBRIUM_INGOT);
	}
	
	private void registerSpecialItemRenderers() {
		registerItem(ItemInit.WOODEN_CROSSBOW);
	}
	
	private void registerItem(Item item) {
		ZylrothRenderer.registerItemRender(item);
	}
	
	@SubscribeEvent public void onModelBake(ModelBakeEvent event) throws IOException {
		for (String s : CUSTOM_RENDERS) {
			ModelResourceLocation model = new ModelResourceLocation(Reference.RESOURCE_PREFIX + s, "inventory");
			Object obj = event.getModelRegistry().getObject(model);
			
			if (obj instanceof IBakedModel) {
				event.getModelRegistry().putObject(model, new CustomItemModelFactory((IBakedModel) obj));
			}
		}
	}
}