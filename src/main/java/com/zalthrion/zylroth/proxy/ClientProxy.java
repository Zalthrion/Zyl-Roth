package com.zalthrion.zylroth.proxy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.zalthrion.zylroth.block.statemap.StateMapLeaves;
import com.zalthrion.zylroth.block.statemap.StateMapSapling;
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
import com.zalthrion.zylroth.lib.ModInit.BlockInit;
import com.zalthrion.zylroth.lib.ModInit.ItemInit;
import com.zalthrion.zylroth.model.armor.ModelVoidLordArmor;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.render.entity.*;
import com.zalthrion.zylroth.render.entity.dev.RenderSixOneThree;
import com.zalthrion.zylroth.render.entity.dev.RenderZalthrion;
import com.zalthrion.zylroth.render.entity.mount.RenderDeathcharger;
import com.zalthrion.zylroth.render.entity.mount.RenderPlaguedHorse;
import com.zalthrion.zylroth.render.entity.mount.RenderSavageBadger;
import com.zalthrion.zylroth.render.entity.mount.RenderSwiftUnicorn;
import com.zalthrion.zylroth.render.entity.mount.RenderWarTortoise;
import com.zalthrion.zylroth.render.item.CustomItemModelFactory;

public class ClientProxy extends CommonProxy {
	public static final HashMap<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();
	public static Map<String, ModelResourceLocation> itemResources = new HashMap<String, ModelResourceLocation>();
	
	public static final String[] CUSTOM_RENDERS = new String[] {"woodenCrossbow"};
	
	@Override public void preInit() {
		super.preInit();
		MinecraftForge.EVENT_BUS.register(this);
		this.registerEntityRenderers();
		this.registerModels();
	}
	
	@Override public void init() {
		super.init();
		MinecraftForge.EVENT_BUS.register(new KeyInputEventListener());
		this.registerArmorModels();
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
	
	/**
	 * Note models not registered here are the INFUSER variants.
	 */
	private void registerModels() {
		/* Quite usual blocks. */
		this.registerBlock(BlockInit.TENEBRAE_ORE);
		this.registerBlock(BlockInit.TENEBRAE_CORE);
		this.registerBlock(BlockInit.TENEBRAE_BLOCK);
		this.registerBlock(BlockInit.CHISELED_TENEBRAE);
		this.registerBlock(BlockInit.INFUSED_TENEBRAE);
		this.registerBlock(BlockInit.ASH_BLOCK);
		this.registerBlock(BlockInit.EMPOWERED_TENEBRAE_CORE);
		this.registerBlock(BlockInit.VOIDIUM_ORE);
		this.registerBlock(BlockInit.INFERNIUM_ORE);
		this.registerBlock(BlockInit.ENDIRITE_ORE);
		this.registerBlock(BlockInit.KYRUL_LOG_BLOCK);
		this.registerBlock(BlockInit.VOID_STONE);
		this.registerBlock(BlockInit.VOID_PLANKS);
		/**
		 * Step 1: State Maps
		 * Step 2: Set State Maps
		 * Step 3: Register Blocks
		 */
		StateMapLeaves rainbowLeafStateMap = new StateMapLeaves(RainbowLeafBlock.VARIANT, RainbowLeafBlock.CHECK_DECAY, RainbowLeafBlock.DECAYABLE);
		StateMapLeaves rainbowLeaf2StateMap = new StateMapLeaves(RainbowLeafBlock2.VARIANT, RainbowLeafBlock2.CHECK_DECAY, RainbowLeafBlock2.DECAYABLE);
		StateMapLeaves iridisLeafStateMap = new StateMapLeaves(IridisLeafBlock.VARIANT, IridisLeafBlock.CHECK_DECAY, IridisLeafBlock.DECAYABLE);
		StateMapLeaves kyrulLeafStateMap = new StateMapLeaves(KyrulLeafBlock.VARIANT, KyrulLeafBlock.CHECK_DECAY, KyrulLeafBlock.DECAYABLE);
		StateMapSapling rainbowSaplingStateMap = new StateMapSapling(RainbowSaplingBlock.VARIANT, RainbowSaplingBlock.STAGE);
		StateMapSapling iridisSaplingStateMap = new StateMapSapling(IridisSaplingBlock.VARIANT, IridisSaplingBlock.STAGE);
		StateMapSapling kyrulSaplingStateMap = new StateMapSapling(KyrulSaplingBlock.VARIANT, KyrulSaplingBlock.STAGE);
		
		ModelLoader.setCustomStateMapper(BlockInit.RAINBOW_LEAF_BLOCK, rainbowLeafStateMap.build());
		ModelLoader.setCustomStateMapper(BlockInit.RAINBOW_LEAF_BLOCK_2, rainbowLeaf2StateMap.build());
		ModelLoader.setCustomStateMapper(BlockInit.IRIDIS_LEAF_BLOCK, iridisLeafStateMap.build());
		ModelLoader.setCustomStateMapper(BlockInit.KYRUL_LEAF_BLOCK, kyrulLeafStateMap.build());
		ModelLoader.setCustomStateMapper(BlockInit.RAINBOW_SAPLING_BLOCK, rainbowSaplingStateMap.build());
		ModelLoader.setCustomStateMapper(BlockInit.IRIDIS_SAPLING_BLOCK, iridisSaplingStateMap.build());
		ModelLoader.setCustomStateMapper(BlockInit.KYRUL_SAPLING_BLOCK, kyrulSaplingStateMap.build());
		
		this.registerBlock(BlockInit.RAINBOW_LEAF_BLOCK, 0, new ModelResourceLocation(Reference.RESOURCE_PREFIX + "red_leaves", "inventory"));
		this.registerBlock(BlockInit.RAINBOW_LEAF_BLOCK, 1, new ModelResourceLocation(Reference.RESOURCE_PREFIX + "orange_leaves", "inventory"));
		this.registerBlock(BlockInit.RAINBOW_LEAF_BLOCK, 2, new ModelResourceLocation(Reference.RESOURCE_PREFIX + "yellow_leaves", "inventory"));
		this.registerBlock(BlockInit.RAINBOW_LEAF_BLOCK, 3, new ModelResourceLocation(Reference.RESOURCE_PREFIX + "green_leaves", "inventory"));
		this.registerBlock(BlockInit.RAINBOW_LEAF_BLOCK_2, 0, new ModelResourceLocation(Reference.RESOURCE_PREFIX + "blue_leaves", "inventory"));
		this.registerBlock(BlockInit.RAINBOW_LEAF_BLOCK_2, 1, new ModelResourceLocation(Reference.RESOURCE_PREFIX + "purple_leaves", "inventory"));
		this.registerBlock(BlockInit.RAINBOW_SAPLING_BLOCK, 0, new ModelResourceLocation(Reference.RESOURCE_PREFIX + "red_sapling", "inventory"));
		this.registerBlock(BlockInit.RAINBOW_SAPLING_BLOCK, 1, new ModelResourceLocation(Reference.RESOURCE_PREFIX + "orange_sapling", "inventory"));
		this.registerBlock(BlockInit.RAINBOW_SAPLING_BLOCK, 2, new ModelResourceLocation(Reference.RESOURCE_PREFIX + "yellow_sapling", "inventory"));
		this.registerBlock(BlockInit.RAINBOW_SAPLING_BLOCK, 3, new ModelResourceLocation(Reference.RESOURCE_PREFIX + "green_sapling", "inventory"));
		this.registerBlock(BlockInit.RAINBOW_SAPLING_BLOCK, 4, new ModelResourceLocation(Reference.RESOURCE_PREFIX + "blue_sapling", "inventory"));
		this.registerBlock(BlockInit.RAINBOW_SAPLING_BLOCK, 5, new ModelResourceLocation(Reference.RESOURCE_PREFIX + "purple_sapling", "inventory"));
		
		this.registerBlock(BlockInit.IRIDIS_LEAF_BLOCK, 0, new ModelResourceLocation(Reference.RESOURCE_PREFIX + "autumn_leaves", "inventory"));
		this.registerBlock(BlockInit.IRIDIS_LEAF_BLOCK, 1, new ModelResourceLocation(Reference.RESOURCE_PREFIX + "sakura_leaves", "inventory"));
		this.registerBlock(BlockInit.IRIDIS_SAPLING_BLOCK, 0, new ModelResourceLocation(Reference.RESOURCE_PREFIX + "autumn_sapling", "inventory"));
		this.registerBlock(BlockInit.IRIDIS_SAPLING_BLOCK, 1, new ModelResourceLocation(Reference.RESOURCE_PREFIX + "sakura_sapling", "inventory"));
		
		this.registerBlock(BlockInit.KYRUL_LEAF_BLOCK, 0, new ModelResourceLocation(Reference.RESOURCE_PREFIX + "void_leaves", "inventory"));
		this.registerBlock(BlockInit.KYRUL_SAPLING_BLOCK, 0, new ModelResourceLocation(Reference.RESOURCE_PREFIX + "void_sapling", "inventory"));
		
		/* Items */
		
		/* Armors */
		this.registerItem(ItemInit.TENEBRAE_HELMET);
		this.registerItem(ItemInit.TENEBRAE_CHESTPLATE);
		this.registerItem(ItemInit.TENEBRAE_LEGGINGS);
		this.registerItem(ItemInit.TENEBRAE_BOOTS);
		this.registerItem(ItemInit.VOID_LORD_HELMET);
		this.registerItem(ItemInit.VOID_LORD_CHESTPLATE);
		this.registerItem(ItemInit.VOID_LORD_LEGGINGS);
		this.registerItem(ItemInit.VOID_LORD_BOOTS);
		this.registerItem(ItemInit.EMERALD_HELMET);
		this.registerItem(ItemInit.EMERALD_CHESTPLATE);
		this.registerItem(ItemInit.EMERALD_LEGGINGS);
		this.registerItem(ItemInit.EMERALD_BOOTS);
		this.registerItem(ItemInit.RAINBOW_GLASSES);
		/* Tools */
		this.registerItem(ItemInit.CREATIVE_PICKAXE);
		this.registerItem(ItemInit.CREATIVE_SHOVEL);
		this.registerItem(ItemInit.CREATIVE_SWORD);
		this.registerItem(ItemInit.CREATIVE_HOE);
		this.registerItem(ItemInit.CREATIVE_AXE);
		
		this.registerItem(ItemInit.TENEBRAE_PICKAXE);
		this.registerItem(ItemInit.TENEBRAE_SHOVEL);
		this.registerItem(ItemInit.TENEBRAE_SWORD);
		this.registerItem(ItemInit.TENEBRAE_HOE);
		this.registerItem(ItemInit.TENEBRAE_AXE);
		
		this.registerItem(ItemInit.VOIDIRITE_SWORD);
		this.registerItem(ItemInit.VOIDIUM_SWORD);
		
		this.registerItem(ItemInit.TENEBRAE_LEAF_CUTTER);
		/* Tenebrae */
		this.registerItem(ItemInit.TENEBRAE_ORE_ITEM);
		this.registerItem(ItemInit.TENEBRAE_INGOT);
		this.registerItem(ItemInit.TENEBRAE_CHUNK);
		this.registerItem(ItemInit.CELESTIAL_CORE);
		/* Infernium */
		this.registerItem(ItemInit.RAW_INFERNIUM);
		this.registerItem(ItemInit.INFERIUM_INGOT);
		/* Endirite */
		this.registerItem(ItemInit.ENDIRITE_CHUNK);
		this.registerItem(ItemInit.ENDIRITE_ORE_ITEM);
		this.registerItem(ItemInit.ENDIRITE_INGOT);
		/* Voidium */
		this.registerItem(ItemInit.VOIDIUM_CHUNK);
		this.registerItem(ItemInit.VOIDIUM_ORE_ITEM);
		this.registerItem(ItemInit.VOIDIUM_INGOT);
		/* Mounts */
		this.registerItem(ItemInit.EMPTY_SC);
		this.registerItem(ItemInit.SC_DEATHCHARGER);
		this.registerItem(ItemInit.SC_PLAGUED_HORSE);
		this.registerItem(ItemInit.SC_WAR_TORTOISE);
		/* Portals */
		this.registerItem(ItemInit.GOLD_TALISMAN);
		this.registerItem(ItemInit.VOID_TALISMAN);
		this.registerItem(ItemInit.AUTUMN_TALISMAN);
		this.registerItem(ItemInit.ICE_TALISMAN);
		/* Others */
		this.registerItem(ItemInit.DARK_SHARD);
		this.registerItem(ItemInit.SOUL_ESSENCE);
		this.registerItem(ItemInit.CURSED_SOUL_ESSENCE);
		this.registerItem(ItemInit.VOID_GEM);
		this.registerItem(ItemInit.VOID_ESSENCE);
		this.registerItem(ItemInit.TENEBRIUM_INGOT);
		/* Specials */
		this.registerItem(ItemInit.WOODEN_CROSSBOW);
	}
	
	private void registerBlock(Block block) {
		this.registerBlock(block, 0);
	}
	
	private void registerBlock(Block block, int meta) {
		this.registerBlock(block, meta, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
	
	private void registerBlock(Block block, int meta, ModelResourceLocation resource) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, resource);
	}
	
	private void registerItem(Item item) {
		this.registerItem(item, 0);
	}
	
	private void registerItem(Item item, int meta) {
		this.registerItem(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	private void registerItem(Item item, int meta, ModelResourceLocation resource) {
		ModelLoader.setCustomModelResourceLocation(item, meta, resource);
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