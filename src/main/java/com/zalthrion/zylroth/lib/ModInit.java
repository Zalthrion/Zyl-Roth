package com.zalthrion.zylroth.lib;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.BiomeProperties;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.zalthrion.zylroth.Zylroth;
import com.zalthrion.zylroth.block.AshBlock;
import com.zalthrion.zylroth.block.ChiseledTenebrae;
import com.zalthrion.zylroth.block.EmpoweredTenebraeCore;
import com.zalthrion.zylroth.block.InfusedTenebrae;
import com.zalthrion.zylroth.block.TenebraeBlock;
import com.zalthrion.zylroth.block.TenebraeCore;
import com.zalthrion.zylroth.block.ore.EndiriteOre;
import com.zalthrion.zylroth.block.ore.InferniumOre;
import com.zalthrion.zylroth.block.ore.TenebraeOre;
import com.zalthrion.zylroth.block.ore.VoidiumOre;
import com.zalthrion.zylroth.block.spawner.SpawnerVoidDragon;
import com.zalthrion.zylroth.block.tile.GoldBag;
import com.zalthrion.zylroth.block.tile.InfuserMachine;
import com.zalthrion.zylroth.block.tile.InfuserType;
import com.zalthrion.zylroth.block.tree.IridisLeafBlock;
import com.zalthrion.zylroth.block.tree.IridisSaplingBlock;
import com.zalthrion.zylroth.block.tree.RainbowLeafBlock;
import com.zalthrion.zylroth.block.tree.RainbowLeafBlock2;
import com.zalthrion.zylroth.block.tree.RainbowSaplingBlock;
import com.zalthrion.zylroth.entity.EntityFancyBadger;
import com.zalthrion.zylroth.entity.mount.MountDeathcharger;
import com.zalthrion.zylroth.entity.mount.MountPlaguedHorse;
import com.zalthrion.zylroth.entity.mount.MountSavageBadger;
import com.zalthrion.zylroth.entity.mount.MountSwiftUnicorn;
import com.zalthrion.zylroth.entity.mount.MountWarTortoise;
import com.zalthrion.zylroth.handler.ConfigurationHandler;
import com.zalthrion.zylroth.handler.KeyHandler;
import com.zalthrion.zylroth.handler.recipe.InfusionFuels;
import com.zalthrion.zylroth.handler.recipe.InfusionRecipeHandler;
import com.zalthrion.zylroth.item.CursedSoulEssence;
import com.zalthrion.zylroth.item.DarkShard;
import com.zalthrion.zylroth.item.SoulEssence;
import com.zalthrion.zylroth.item.UnstableTenebraeCore;
import com.zalthrion.zylroth.item.VoidEssence;
import com.zalthrion.zylroth.item.VoidGem;
import com.zalthrion.zylroth.item.armor.RainbowGlasses;
import com.zalthrion.zylroth.item.armor.TenebraeArmor;
import com.zalthrion.zylroth.item.armor.VoidLordArmor;
import com.zalthrion.zylroth.item.block.IridisLeafItemBlock;
import com.zalthrion.zylroth.item.block.IridisSaplingItemBlock;
import com.zalthrion.zylroth.item.block.RainbowLeafItemBlock;
import com.zalthrion.zylroth.item.block.RainbowSaplingItemBlock;
import com.zalthrion.zylroth.item.mount.EmptySC;
import com.zalthrion.zylroth.item.mount.SCDeathcharger;
import com.zalthrion.zylroth.item.mount.SCPlaguedHorse;
import com.zalthrion.zylroth.item.mount.SCSavageBadger;
import com.zalthrion.zylroth.item.mount.SCSwiftUnicorn;
import com.zalthrion.zylroth.item.mount.SCWarTortoise;
import com.zalthrion.zylroth.item.ore.*;
import com.zalthrion.zylroth.item.talisman.AutumnTalisman;
import com.zalthrion.zylroth.item.talisman.GoldTalisman;
import com.zalthrion.zylroth.item.talisman.IceTalisman;
import com.zalthrion.zylroth.item.talisman.VoidTalisman;
import com.zalthrion.zylroth.item.tools.*;
import com.zalthrion.zylroth.packet.PacketHandler;
import com.zalthrion.zylroth.tile.TileEntityInfuser;
import com.zalthrion.zylroth.tile.TileEntitySpawnerVoidDragon;
import com.zalthrion.zylroth.world.biome.BiomeGenAshBarrens;
import com.zalthrion.zylroth.world.biome.BiomeGenDreadWastes;
import com.zalthrion.zylroth.world.biome.BiomeGenHauntedForest;
import com.zalthrion.zylroth.world.biome.BiomeGenJadePlains;
import com.zalthrion.zylroth.world.biome.BiomeGenVoidMountains;
import com.zalthrion.zylroth.world.provider.WorldProviderGlaciem;
import com.zalthrion.zylroth.world.provider.WorldProviderIridis;
import com.zalthrion.zylroth.world.provider.WorldProviderKyrul;

public class ModInit {
	public static String[] sortOrder = new String[] { "ashBlock", "chiseledTenebrae", "empoweredTenebraeCore", "infusedTenebrae", "tenebraeBlock", "tenebraeCore",
		"endiriteOre", "inferniumOre", "tenebraeOre", "voidiumOre", "spawnerVoidDragon", "goldBag", "infuserIdle", "infuser", "oreInfuserIdle", "oreInfuser",
		"iridisLeafBlock", "iridisSaplingBlock", "rainbowLeafBlock", "rainbowLeafBlock2", "rainbowSaplingBlock", "tenebraeHelmet", "tenebraeChestplate",
		"tenebraeLeggings", "tenebraeBoots", "voidLordHelmet", "voidLordChestplate", "voidLordLeggings", "voidLordBoots", "rainbowGlasses", "tenebraeChunk",
		"tenebraeIOre", "tenebraeIngot", "rawInfernium", "inferniumIngot", "endiriteChunk", "endiriteIOre", "endiriteIngot", "tenebriumIngot", "voidiumChunk",
		"voidiumIOre", "voidiumIngot", "unstableTenebraeCore", "emptySC", "SC_Deathcharger", "SC_PlaguedHorse", "SC_WarTortoise", "SC_SavageBadger", "SC_SwiftUnicorn",
		"goldTalisman", "voidTalisman", "autumnTalisman", "iceTalisman", "darkShard", "soulEssence", "cursedSoulEssence", "voidGem", "voidEssence", "tenebraeSword",
		"tenebraePickaxe", "tenebraeAxe", "tenebraeShovel", "tenebraeHoe", "creativeSword", "creativePickaxe", "creativeAxe", "creativeShovel", "creativeHoe",
		"tenebraeLeafCutter", "woodenCrossbow", "iridisLeafBlockIB", "iridisSaplingBlockIB", "rainbowLeafBlockIB", "rainbowLeafBlock2IB", "rainbowSaplingBlockIB" };
	
	public static class BiomeInit {
		public static BiomeGenBase dreadWastes = new BiomeGenDreadWastes(new BiomeProperties("Dread Wastes").setBaseHeight(0.2F).setWaterColor(14953751).setRainDisabled());
		public static BiomeGenBase hauntedForest = new BiomeGenHauntedForest(new BiomeProperties("Haunted Forest").setBaseHeight(0.1F).setHeightVariation(0.1F).setWaterColor(14953751).setRainDisabled());
		public static BiomeGenBase ashBarrens = new BiomeGenAshBarrens(new BiomeProperties("Ash Barrens").setWaterColor(14953751).setRainDisabled());
		public static BiomeGenBase voidMountains = new BiomeGenVoidMountains(new BiomeProperties("Void Mountains").setBaseHeight(1.5F).setHeightVariation(-1.475F).setWaterColor(14953751).setRainDisabled());
		
		public static BiomeGenBase jadePlains = new BiomeGenJadePlains(new BiomeProperties("Jade Plains").setBaseHeight(0.125F).setHeightVariation(-0.75F).setWaterColor(3721952));
		public static BiomeGenBase autumnForest = new BiomeGenJadePlains(new BiomeProperties("Jade Plains").setBaseHeight(0.2F).setWaterColor(14953751));
		public static BiomeGenBase sapphireOcean = new BiomeGenJadePlains(new BiomeProperties("Jade Plains").setBaseHeight(-1.0F).setHeightVariation(1.1F).setWaterColor(3721952));
		public static BiomeGenBase rainbowForest = new BiomeGenJadePlains(new BiomeProperties("Jade Plains").setBaseHeight(0.2F).setHeightVariation(0.1F).setWaterColor(3721952));
		
		public static BiomeGenBase frozenSea = new BiomeGenJadePlains(new BiomeProperties("Jade Plains").setBaseHeight(-1.0F).setHeightVariation(1.1F).setWaterColor(3975093).setRainDisabled().setSnowEnabled().setTemperature(0.0F));
		public static BiomeGenBase coldOcean = new BiomeGenJadePlains(new BiomeProperties("Jade Plains").setBaseHeight(-1.0F).setHeightVariation(1.1F).setWaterColor(3721952).setRainDisabled().setSnowEnabled().setTemperature(0.3F));
		public static BiomeGenBase frozenWastes = new BiomeGenJadePlains(new BiomeProperties("Jade Plains").setBaseHeight(0.125F).setHeightVariation(-0.75F).setWaterColor(3721952).setRainDisabled().setSnowEnabled().setTemperature(0.0F));
		
		public static void preInit() {
			BiomeDictionary.registerBiomeType(dreadWastes, Type.PLAINS);
			BiomeDictionary.registerBiomeType(hauntedForest, Type.FOREST);
			BiomeDictionary.registerBiomeType(ashBarrens, Type.DRY);
			BiomeDictionary.registerBiomeType(voidMountains, Type.HILLS);
			
			BiomeDictionary.registerBiomeType(jadePlains, Type.PLAINS);
			BiomeDictionary.registerBiomeType(autumnForest, Type.FOREST);
			BiomeDictionary.registerBiomeType(sapphireOcean, Type.OCEAN);
			BiomeDictionary.registerBiomeType(rainbowForest, Type.MAGICAL);
			
			BiomeDictionary.registerBiomeType(frozenSea, Type.COLD);
			BiomeDictionary.registerBiomeType(coldOcean, Type.OCEAN);
			BiomeDictionary.registerBiomeType(frozenWastes, Type.COLD);
		}
	}
	
	public static class BlockInit {
		public static Block ashBlock = new AshBlock();
		public static Block chiseledTenebrae = new ChiseledTenebrae();
		public static Block empoweredTenebraeCore = new EmpoweredTenebraeCore();
		public static Block infusedTenebrae = new InfusedTenebrae();
		public static Block tenebraeBlock = new TenebraeBlock();
		public static Block tenebraeCore = new TenebraeCore();
		
		public static Block endiriteOre = new EndiriteOre();
		public static Block inferniumOre = new InferniumOre();
		public static Block tenebraeOre = new TenebraeOre();
		public static Block voidiumOre = new VoidiumOre();

		public static Block spawnerVoidDragon = new SpawnerVoidDragon();
		
		public static Block goldBag = new GoldBag();
		public static Block infuserIdle = new InfuserMachine(false, InfuserType.NORMAL);
		public static Block infuser = new InfuserMachine(true, InfuserType.NORMAL);
		public static Block oreInfuserIdle = new InfuserMachine(false, InfuserType.ORE);
		public static Block oreInfuser = new InfuserMachine(true, InfuserType.ORE);
		
		public static Block iridisLeafBlock = new IridisLeafBlock();
		public static Block iridisSaplingBlock = new IridisSaplingBlock();
		public static Block rainbowLeafBlock = new RainbowLeafBlock();
		public static Block rainbowLeafBlock2 = new RainbowLeafBlock2();
		public static Block rainbowSaplingBlock = new RainbowSaplingBlock();
		
		public static void preInit() {
			GameRegistry.registerTileEntity(TileEntitySpawnerVoidDragon.class, "spawnerVoidDragon");
			GameRegistry.registerTileEntity(TileEntityInfuser.class, "infuser");
			
			ModRegistry.addRegister(ashBlock, "ashBlock");
			ModRegistry.addRegister(chiseledTenebrae, "chiseledTenebrae");
			ModRegistry.addRegister(empoweredTenebraeCore, "empoweredTenebraeCore");
			ModRegistry.addRegister(infusedTenebrae, "infusedTenebrae");
			ModRegistry.addRegister(tenebraeBlock, "tenebraeBlock");
			ModRegistry.addRegister(tenebraeCore, "tenebraeCore");
			
			ModRegistry.addRegister(endiriteOre, "endiriteOre");
			ModRegistry.addRegister(inferniumOre, "inferniumOre");
			ModRegistry.addRegister(tenebraeOre, "tenebraeOre");
			ModRegistry.addRegister(voidiumOre, "voidiumOre");
			
			ModRegistry.addRegister(spawnerVoidDragon, "spawnerVoidDragon");
			
			ModRegistry.addRegister(goldBag, "goldBag");
			ModRegistry.addRegister(infuserIdle, "infuserIdle");
			ModRegistry.addRegister(infuser, "infuser");
			ModRegistry.addRegister(oreInfuserIdle, "oreInfuserIdle");
			ModRegistry.addRegister(oreInfuser, "oreInfuser");
			
			ModRegistry.addRegister(iridisLeafBlock, "iridisLeafBlock");
			ModRegistry.addRegister(iridisSaplingBlock, "iridisSaplingBlock");
			ModRegistry.addRegister(rainbowLeafBlock, "rainbowLeafBlock");
			ModRegistry.addRegister(rainbowLeafBlock2, "rainbowLeafBlock2");
			ModRegistry.addRegister(rainbowSaplingBlock, "rainbowSaplingBlock");
		}
	}
	
	public static class DimensionInit {
		public static DimensionType GLACIEM = DimensionType.register("Glaciem", "_glaciem", ConfigurationHandler.getGlaciemId(), WorldProviderGlaciem.class, false);
		public static DimensionType IRIDIS = DimensionType.register("Iridis", "_iridis", ConfigurationHandler.getIridisId(), WorldProviderIridis.class, false);
		public static DimensionType KYRUL = DimensionType.register("Kyrul", "_kyrul", ConfigurationHandler.getKyrulId(), WorldProviderKyrul.class, false);
		
		public static void preInit() {
			if (ConfigurationHandler.getGlaciemEnabled()) DimensionManager.registerDimension(ConfigurationHandler.getGlaciemId(), GLACIEM);
			if (ConfigurationHandler.getIridisEnabled()) DimensionManager.registerDimension(ConfigurationHandler.getIridisId(), IRIDIS);
			if (ConfigurationHandler.getKyrulEnabled()) DimensionManager.registerDimension(ConfigurationHandler.getKyrulId(), KYRUL);
		}
	}
	
	public static class EntityInit {
		private static int nextEntityID = 0;
		
		private static int getNextEntityID() {
			nextEntityID ++;
			return nextEntityID;
		}
		
		public static void registerEntity(Class<? extends Entity> entityClass, String entityName, boolean hasEgg, int bgEggColor, int fgEggColor) {
			if (hasEgg) {
				EntityRegistry.registerModEntity(entityClass, entityName, getNextEntityID(), Zylroth.instance, 80, 4, true, bgEggColor, fgEggColor);
			} else {
				EntityRegistry.registerModEntity(entityClass, entityName, getNextEntityID(), Zylroth.instance, 80, 4, true);
			}
		}
		
		public void addSpawn(Class<? extends EntityLiving> entityClass, int spawnProb, int min, int max, BiomeGenBase[] biomes) {
			if (spawnProb > 0) EntityRegistry.addSpawn(entityClass, spawnProb, min, max, EnumCreatureType.CREATURE, biomes);
		}

		public static void init() {
			
			// Animals
			
			// registerEntity(EntityBird.class, "bird", true, 0xeaeae9, 0xc99a03); // TODO Duplicate stat ID error
			// registerEntity(EntityRainbowPig.class, "rainbowPig", true, 0xeaeae9, 0xc99a03);
			// registerEntity(EntityBadger.class, "badger", true, 0xeaeae9, 0xc99a03);
			registerEntity(EntityFancyBadger.class, "fancyBadger", false, 0, 0);
			// registerEntity(EntityBoar.class, "boar", true, 0xeaeae9, 0xc99a03);
			// registerEntity(EntityUnicorn.class, "unicorn", true, 0xeaeae9, 0xc99a03);
			// registerEntity(EntityDeer.class, "deer", true, 0xeaeae9, 0xc99a03);
			// registerEntity(EntityStag.class, "stag", true, 0xeaeae9, 0xc99a03);
			
			// Mobs

			// registerEntity(EntityTenebraeGuardian.class, "tenebraeGuardian", true, 0xeaeae9, 0xc99a03);
			// registerEntity(EntitySkeletalHorse.class, "skeletalHorse", true, 0xeaeae9, 0xc99a03);
			// registerEntity(EntityVoidLordBoss.class, "voidLord", true, 0xeaeae9, 0xc99a03);
			// registerEntity(EntityTenebraeProtector.class, "tenebraeProtector", true, 0xeaeae9, 0xc99a03);
			// registerEntity(EntityUndeadMinion.class, "undeadMinion", true, 0xeaeae9, 0xc99a03);
			// registerEntity(EntityUndeadWarrior.class, "undeadWarrior", true, 0xeaeae9, 0xc99a03);
			// registerEntity(EntityVoidDragon.class, "voidDragon", true, 0xeaeae9, 0xc99a03);
			
			// Mounts
			
			registerEntity(MountDeathcharger.class, "Deathcharger", false, 0, 0);
			registerEntity(MountPlaguedHorse.class, "PlaguedHorse", false, 0, 0);
			registerEntity(MountWarTortoise.class, "WarTortoise", false, 0, 0);
			registerEntity(MountSavageBadger.class, "SavageBadger", false, 0, 0);
			registerEntity(MountSwiftUnicorn.class, "SwiftUnicorn", false, 0, 0);
			
			// Developers
			
			// registerEntity(EntityZalthrion.class, "Zalthrion", true, 0xeaeae9, 0xc99a03);
			// registerEntity(EntitySixOneThree.class, "Six-One-Three", true, 0xeaeae9, 0xc99a03);
		}
	}
	
	public static class ItemInit {
		/* Armors */
		public static ArmorMaterial tenebrae = EnumHelper.addArmorMaterial("Tenebrae", "Tenebrae", 42, new int[] {3, 8, 6, 3}, 16, SoundEvents.item_armor_equip_generic);
		public static ArmorMaterial voidLord = EnumHelper.addArmorMaterial("VoidLord", "VoidLord", 42, new int[] {3, 8, 6, 3}, 16, SoundEvents.item_armor_equip_generic);
		public static ArmorMaterial glasses = EnumHelper.addArmorMaterial("Glasses", "Glasses", 0, new int[] {0, 0, 0, 0}, 0, SoundEvents.item_armor_equip_generic);
		public static Item tenebraeHelmet = new TenebraeArmor(tenebrae, "tenebrae", EntityEquipmentSlot.HEAD).setUnlocalizedName("tenebraeHelmet");
		public static Item tenebraeChestplate = new TenebraeArmor(tenebrae, "tenebrae", EntityEquipmentSlot.CHEST).setUnlocalizedName("tenebraeChestplate");
		public static Item tenebraeLeggings = new TenebraeArmor(tenebrae, "tenebrae", EntityEquipmentSlot.LEGS).setUnlocalizedName("tenebraeLeggings");
		public static Item tenebraeBoots = new TenebraeArmor(tenebrae, "tenebrae", EntityEquipmentSlot.FEET).setUnlocalizedName("tenebraeBoots");
		public static Item voidLordHelmet = new VoidLordArmor(voidLord, "voidlord", EntityEquipmentSlot.HEAD).setUnlocalizedName("voidLordHelmet");
		public static Item voidLordChestplate = new VoidLordArmor(voidLord, "voidlord", EntityEquipmentSlot.CHEST).setUnlocalizedName("voidLordChestplate");
		public static Item voidLordLeggings = new VoidLordArmor(voidLord, "voidlord", EntityEquipmentSlot.LEGS).setUnlocalizedName("voidLordLeggings");
		public static Item voidLordBoots = new VoidLordArmor(voidLord, "voidlord", EntityEquipmentSlot.FEET).setUnlocalizedName("voidLordBoots");
		public static Item rainbowGlasses = new RainbowGlasses();
		/* General Items */
		public static Item tenebraeChunk = new TenebraeChunk();
		public static Item tenebraeIOre = new TenebraeIOre();
		public static Item tenebraeIngot = new TenebraeIngot();
		public static Item rawInfernium = new RawInfernium();
		public static Item inferniumIngot = new InferniumIngot();
		public static Item endiriteChunk = new EndiriteChunk();
		public static Item endiriteIOre = new EndiriteIOre();
		public static Item endiriteIngot = new EndiriteIngot();
		public static Item tenebriumIngot = new TenebriumIngot();
		public static Item voidiumChunk = new VoidiumChunk();
		public static Item voidiumIOre = new VoidiumIOre();
		public static Item voidiumIngot = new VoidiumIngot();
		public static Item unstableTenebraeCore = new UnstableTenebraeCore();
		public static Item Empty_SC = new EmptySC();
		public static Item SC_Deathcharger = new SCDeathcharger();
		public static Item SC_PlaguedHorse = new SCPlaguedHorse();
		public static Item SC_WarTortoise = new SCWarTortoise();
		public static Item SC_SavageBadger = new SCSavageBadger();
		public static Item SC_SwiftUnicorn = new SCSwiftUnicorn();
		public static Item goldTalisman = new GoldTalisman();
		public static Item voidTalisman = new VoidTalisman();
		public static Item autumnTalisman = new AutumnTalisman();
		public static Item iceTalisman = new IceTalisman();
		public static Item darkShard = new DarkShard();
		public static Item soulEssence = new SoulEssence();
		public static Item cursedSoulEssence = new CursedSoulEssence();
		public static Item voidGem = new VoidGem();
		public static Item voidEssence = new VoidEssence();
		/* Tools */
		private static final ToolMaterial creativeSwordMaterial = EnumHelper.addToolMaterial("CreativeSword", 3, 12250, 10, 996, 50);
		private static final ToolMaterial creativeDamageTools = EnumHelper.addToolMaterial("creativeDamageTools", 3, 12250, 10, 500.0F, 50);
		private static final ToolMaterial creativeTools = EnumHelper.addToolMaterial("creativeTools", 3, 12250, 10, 250.0F, 50);
		private static final ToolMaterial tenebraeDamageTools = EnumHelper.addToolMaterial("tenebraeDamageTools", 3, 2250, 10, 6.5F, 15);
		private static final ToolMaterial tenebraeTools = EnumHelper.addToolMaterial("tenebraeTools", 3, 2250, 10, 4.5F, 15);
		public static final Item tenebraeSword = new TenebraeSword(tenebraeDamageTools);
		public static final Item tenebraePickaxe = new TenebraePickaxe(tenebraeDamageTools);
		public static final Item tenebraeAxe = new TenebraeAxe(tenebraeDamageTools);
		public static final Item tenebraeShovel = new TenebraeShovel(tenebraeTools);
		public static final Item tenebraeHoe = new TenebraeHoe(tenebraeTools);
		public static Item creativeSword = new CreativeSword(creativeSwordMaterial);
		public static Item creativePickaxe = new CreativePickaxe(creativeDamageTools);
		public static Item creativeAxe = new CreativeAxe(creativeDamageTools);
		public static Item creativeShovel = new CreativeShovel(creativeTools);
		public static Item creativeHoe = new CreativeHoe(creativeTools);
		public static Item tenebraeLeafCutter = new TenebraeLeafCutter();
		public static Item woodenCrossbow = new WoodenCrossbow(2500);
		/* Item Blocks */
		public static ItemBlock iridisLeafBlockIB = new IridisLeafItemBlock(BlockInit.iridisLeafBlock);
		public static ItemBlock iridisSaplingBlockIB = new IridisSaplingItemBlock(BlockInit.iridisSaplingBlock);
		public static ItemBlock rainbowLeafBlockIB = new RainbowLeafItemBlock(BlockInit.rainbowLeafBlock);
		public static ItemBlock rainbowLeafBlock2IB = new RainbowLeafItemBlock(BlockInit.rainbowLeafBlock2); // TODO Make a new ItemBlock?
		public static ItemBlock rainbowSaplingBlockIB = new RainbowSaplingItemBlock(BlockInit.rainbowSaplingBlock);
		
		public static void preInit() {
			/* Armors */
			ModRegistry.addRegister(tenebraeHelmet, "tenebraeHelmet");
			ModRegistry.addRegister(tenebraeChestplate, "tenebraeChestplate");
			ModRegistry.addRegister(tenebraeLeggings, "tenebraeLeggings");
			ModRegistry.addRegister(tenebraeBoots, "tenebraeBoots");
			ModRegistry.addRegister(voidLordHelmet, "voidLordHelmet");
			ModRegistry.addRegister(voidLordChestplate, "voidLordChestplate");
			ModRegistry.addRegister(voidLordLeggings, "voidLordLeggings");
			ModRegistry.addRegister(voidLordBoots, "voidLordBoots");
			ModRegistry.addRegister(rainbowGlasses, "rainbowGlasses");
			/* General Items */
			ModRegistry.addRegister(tenebraeChunk, "tenebraeChunk");
			ModRegistry.addRegister(tenebraeIOre, "tenebraeIOre");
			ModRegistry.addRegister(tenebraeIngot, "tenebraeIngot");
			ModRegistry.addRegister(rawInfernium, "rawInfernium");
			ModRegistry.addRegister(inferniumIngot, "inferniumIngot");
			ModRegistry.addRegister(endiriteChunk, "endiriteChunk");
			ModRegistry.addRegister(endiriteIOre, "endiriteIOre");
			ModRegistry.addRegister(endiriteIngot, "endiriteIngot");
			ModRegistry.addRegister(tenebriumIngot, "tenebriumIngot");
			ModRegistry.addRegister(voidiumChunk, "voidiumChunk");
			ModRegistry.addRegister(voidiumIOre, "voidiumIOre");
			ModRegistry.addRegister(voidiumIngot, "voidiumIngot");
			ModRegistry.addRegister(unstableTenebraeCore, "unstableTenebraeCore");
			ModRegistry.addRegister(Empty_SC, "emptySC");
			ModRegistry.addRegister(SC_Deathcharger, "SC_Deathcharger");
			ModRegistry.addRegister(SC_PlaguedHorse, "SC_PlaguedHorse");
			ModRegistry.addRegister(SC_WarTortoise, "SC_WarTortoise");
			ModRegistry.addRegister(SC_SavageBadger, "SC_SavageBadger");
			ModRegistry.addRegister(SC_SwiftUnicorn, "SC_SwiftUnicorn");
			ModRegistry.addRegister(goldTalisman, "goldTalisman");
			ModRegistry.addRegister(voidTalisman, "voidTalisman");
			ModRegistry.addRegister(autumnTalisman, "autumnTalisman");
			ModRegistry.addRegister(iceTalisman, "iceTalisman");
			ModRegistry.addRegister(darkShard, "darkShard");
			ModRegistry.addRegister(soulEssence, "soulEssence");
			ModRegistry.addRegister(cursedSoulEssence, "cursedSoulEssence");
			ModRegistry.addRegister(voidGem, "voidGem");
			ModRegistry.addRegister(voidEssence, "voidEssence");
			/* Tools */
			ModRegistry.addRegister(tenebraePickaxe, "tenebraePickaxe");
			ModRegistry.addRegister(tenebraeShovel, "tenebraeShovel");
			ModRegistry.addRegister(tenebraeSword, "tenebraeSword");
			ModRegistry.addRegister(tenebraeAxe, "tenebraeAxe");
			ModRegistry.addRegister(tenebraeHoe, "tenebraeHoe");
			ModRegistry.addRegister(tenebraeLeafCutter, "tenebraeLeafCutter");
			ModRegistry.addRegister(creativePickaxe, "creativePickaxe");
			ModRegistry.addRegister(creativeShovel, "creativeShovel");
			ModRegistry.addRegister(creativeSword, "creativeSword");
			ModRegistry.addRegister(creativeAxe, "creativeAxe");
			ModRegistry.addRegister(creativeHoe, "creativeHoe");
			ModRegistry.addRegister(woodenCrossbow, "woodenCrossbow");
			/* Item Blocks */
			ModRegistry.addRegister(iridisLeafBlockIB, "iridisLeafBlockIB");
			ModRegistry.addRegister(iridisSaplingBlockIB, "iridisSaplingBlockIB");
			ModRegistry.addRegister(rainbowLeafBlockIB, "rainbowLeafBlockIB");
			ModRegistry.addRegister(rainbowLeafBlock2IB, "rainbowLeafBlock2IB");
			ModRegistry.addRegister(rainbowSaplingBlockIB, "rainbowSaplingBlockIB");
		}
	}
	
	public static class OreDictionaryInit {
		public static void init() {
/*			OreDictionary.registerOre("oreTenebrae", BlockInit.tenebraeOre);
			OreDictionary.registerOre("ingotTenebrae", ItemInit.tenebraeIngot);
			OreDictionary.registerOre("blockTenebrae", BlockInit.tenebraeBlock);
			OreDictionary.registerOre("oreVoidium", BlockInit.voidiumOre);*/ // TODO Find out what makes this invalid
		}
	}
	
	public static class RecipeInit {
		public static void init() {
			registerSmeltingRecipes();
			registerShapedRecipes();
			registerShapelessRecipes();
			registerArmorRecipes();
			registerToolRecipes();
			registerInfusionRecipes();
		}
		
		public static void registerSmeltingRecipes() {
			GameRegistry.addSmelting(BlockInit.tenebraeOre, new ItemStack(ItemInit.tenebraeChunk), 0.5F);
			GameRegistry.addSmelting(ItemInit.tenebraeIOre, new ItemStack(ItemInit.tenebraeIngot), 0.1F);
		}
		
		public static void registerShapedRecipes() {
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.goldTalisman), "GEG", "EDE", "GEG", 'E', Items.ender_pearl, 'G', Items.gold_ingot, 'D', Items.diamond);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraeIOre), "CC", "CC", 'C', ItemInit.tenebraeChunk);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.endiriteIOre), "CC", "CC", 'C', ItemInit.endiriteChunk);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.voidiumIOre), "CC", "CC", 'C', ItemInit.voidiumChunk);
			GameRegistry.addShapedRecipe(new ItemStack(BlockInit.chiseledTenebrae), "IRI", "RBR", "IRI", 'I', Items.iron_ingot, 'R', ItemInit.tenebraeChunk, 'B', BlockInit.tenebraeBlock);
			GameRegistry.addShapedRecipe(new ItemStack(BlockInit.tenebraeCore), "RTR", "TBT", "RTR", 'R', Blocks.redstone_block, 'T', ItemInit.tenebraeIngot, 'B', BlockInit.tenebraeBlock);
			GameRegistry.addShapedRecipe(new ItemStack(BlockInit.tenebraeBlock), "III", "III", "III", 'I', ItemInit.tenebraeIngot);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.voidGem), "NVN", "VDV", "NVN", 'V', ItemInit.voidEssence, 'D', Items.diamond);
			GameRegistry.addShapedRecipe(new ItemStack(BlockInit.infuserIdle), "RTR", "ICI", "RTR", 'R', Blocks.redstone_block, 'I', Blocks.iron_block, 'T', BlockInit.tenebraeBlock, 'C', ItemInit.unstableTenebraeCore);
			GameRegistry.addShapedRecipe(new ItemStack(BlockInit.oreInfuserIdle), "IRI", "RER", "IRI", 'R', Blocks.redstone_block, 'I', Blocks.iron_block, 'E', Items.ender_pearl);
		}
		
		public static void registerShapelessRecipes() {
			GameRegistry.addShapelessRecipe(new ItemStack(ItemInit.tenebraeIngot, 9), new ItemStack(BlockInit.tenebraeBlock));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockInit.tenebraeBlock, 1), new ItemStack(BlockInit.chiseledTenebrae));
			if (ConfigurationHandler.getKyrulEnabled()) GameRegistry.addShapelessRecipe(new ItemStack(ItemInit.voidTalisman, 1), new ItemStack(ItemInit.goldTalisman), new ItemStack(ItemInit.voidGem));
		}
		
		public static void registerArmorRecipes() {
			/* Tenebrae Armor */
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraeHelmet), "III", "IEI", 'I', ItemInit.tenebraeIngot);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraeChestplate), "IEI", "III", "III", 'I', ItemInit.tenebraeIngot);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraeLeggings), "III", "IEI", "IEI", 'I', ItemInit.tenebraeIngot);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraeBoots), "IEI", "IEI", 'I', ItemInit.tenebraeIngot);
		}
		
		public static void registerToolRecipes() {
			/* Tenebrae Tools */
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraeSword), "NTN", "OTO", "NBN", 'T', ItemInit.tenebraeIngot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraePickaxe), "TTT", "NBN", "NON", 'T', ItemInit.tenebraeIngot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraeAxe), "TTN", "TBN", "NON", 'T', ItemInit.tenebraeIngot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraeAxe), "NTT", "NBT", "NON", 'T', ItemInit.tenebraeIngot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraeShovel), "NTN", "NBN", "NON", 'T', ItemInit.tenebraeIngot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraeHoe), "TTN", "NBN", "NON", 'T', ItemInit.tenebraeIngot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraeHoe), "NTT", "NBN", "NON", 'T', ItemInit.tenebraeIngot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
		}
		
		public static void registerInfusionRecipes() {
			/* Debug Recipes */
			
			/* InfusionFuels.registerFuel(new ItemStack(Items.coal), 200);
			InfusionRecipeHandler.instance().addInfusion(InfuserType.NORMAL, 1F, 100, new ItemStack(Items.emerald), new ItemStack(Items.diamond), new ItemStack(Blocks.dirt, 2), new ItemStack(Blocks.stone));
			InfusionRecipeHandler.instance().addInfusion(InfuserType.ORE, 1F, 100, new ItemStack(Blocks.diamond_ore), new ItemStack(Blocks.iron_ore), new ItemStack(Blocks.dirt), new ItemStack(Blocks.stone)); */
			
			/* Real Recipes */
			InfusionFuels.registerFuel(new ItemStack(ItemInit.tenebraeIOre), 200);
			
			InfusionRecipeHandler.instance().addInfusion(InfuserType.NORMAL, 1F, 100, new ItemStack(BlockInit.endiriteOre), new ItemStack(Blocks.end_stone), new ItemStack(ItemInit.tenebraeIOre), new ItemStack(Items.ender_pearl));
			InfusionRecipeHandler.instance().addInfusion(InfuserType.NORMAL, 1F, 100, new ItemStack(BlockInit.infusedTenebrae), new ItemStack(BlockInit.tenebraeBlock), new ItemStack(Items.diamond), new ItemStack(Items.ender_pearl));
			InfusionRecipeHandler.instance().addInfusion(InfuserType.ORE, 1F, 100, new ItemStack(ItemInit.tenebriumIngot), new ItemStack(ItemInit.tenebraeIngot), new ItemStack(Items.iron_ingot), new ItemStack(ItemInit.inferniumIngot));
		}
	}
	
	public static class ZylrothTab {
		public static CreativeTabs zylRoth = new CreativeTabs("Zyl'Roth") {
			@Override public Item getTabIconItem() {
				return ItemInit.unstableTenebraeCore; 
			}
		};
	}
	
	public static void preInit() {
		BlockInit.preInit();
		ItemInit.preInit();
		ModRegistry.sortThenRegister(sortOrder);
		DimensionInit.preInit();
		PacketHandler.preInit();
		KeyHandler.preInit();
	}
	
	public static void init() {
		EntityInit.init();
		OreDictionaryInit.init();
		RecipeInit.init();
	}
}