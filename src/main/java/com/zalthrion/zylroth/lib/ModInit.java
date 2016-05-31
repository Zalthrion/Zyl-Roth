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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.zalthrion.zylroth.Zylroth;
import com.zalthrion.zylroth.block.*;
import com.zalthrion.zylroth.block.ore.EndiriteOre;
import com.zalthrion.zylroth.block.ore.InferniumOre;
import com.zalthrion.zylroth.block.ore.TenebraeOre;
import com.zalthrion.zylroth.block.ore.VoidiumOre;
import com.zalthrion.zylroth.block.spawner.SpawnerVoidDragon;
import com.zalthrion.zylroth.block.tile.InfuserMachine;
import com.zalthrion.zylroth.block.tile.InfuserType;
import com.zalthrion.zylroth.block.tree.IridisLeafBlock;
import com.zalthrion.zylroth.block.tree.IridisSaplingBlock;
import com.zalthrion.zylroth.block.tree.KyrulLeafBlock;
import com.zalthrion.zylroth.block.tree.KyrulLogBlock;
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
import com.zalthrion.zylroth.handler.ConfigurationHandler;
import com.zalthrion.zylroth.handler.KeyHandler;
import com.zalthrion.zylroth.handler.recipe.InfusionFuels;
import com.zalthrion.zylroth.handler.recipe.InfusionRecipeHandler;
import com.zalthrion.zylroth.item.CelestialCore;
import com.zalthrion.zylroth.item.CursedSoulEssence;
import com.zalthrion.zylroth.item.DarkShard;
import com.zalthrion.zylroth.item.SoulEssence;
import com.zalthrion.zylroth.item.VoidEssence;
import com.zalthrion.zylroth.item.VoidGem;
import com.zalthrion.zylroth.item.VoidiriteIngot;
import com.zalthrion.zylroth.item.armor.EmeraldArmor;
import com.zalthrion.zylroth.item.armor.RainbowGlasses;
import com.zalthrion.zylroth.item.armor.TenebraeArmor;
import com.zalthrion.zylroth.item.armor.VoidLordArmor;
import com.zalthrion.zylroth.item.block.IridisLeafItemBlock;
import com.zalthrion.zylroth.item.block.IridisSaplingItemBlock;
import com.zalthrion.zylroth.item.block.KyrulLeafItemBlock;
import com.zalthrion.zylroth.item.block.KyrulSaplingItemBlock;
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
import com.zalthrion.zylroth.item.tools.others.RepulsorCannon;
import com.zalthrion.zylroth.item.tools.others.TenebraeLeafCutter;
import com.zalthrion.zylroth.item.tools.others.WoodenCrossbow;
import com.zalthrion.zylroth.item.tools.shields.VoidiriteShield;
import com.zalthrion.zylroth.packet.PacketHandler;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.tile.TileEntityInfuser;
import com.zalthrion.zylroth.tile.TileEntitySpawnerVoidDragon;
import com.zalthrion.zylroth.world.biome.*;
import com.zalthrion.zylroth.world.provider.WorldProviderGlaciem;
import com.zalthrion.zylroth.world.provider.WorldProviderIridis;
import com.zalthrion.zylroth.world.provider.WorldProviderKyrul;

public class ModInit {
	public static String[] sortOrder = new String[] { "ashBlock", "chiseledTenebrae", "empoweredTenebraeCore", "infusedTenebrae", "tenebraeBlock", "tenebraeCore",
		"endiriteOre", "inferniumOre", "tenebraeOre", "voidiumOre", "spawnerVoidDragon", "goldBag", "infuserIdle", "infuser", "oreInfuserIdle", "oreInfuser",
		"iridisLeafBlock", "iridisSaplingBlock", "rainbowLeafBlock", "rainbowLeafBlock2", "rainbowSaplingBlock", "kyrulLeafBlock", "kyrulSaplingBlock", "tenebraeHelmet", "tenebraeChestplate",
		"tenebraeLeggings", "tenebraeBoots", "voidLordHelmet", "voidLordChestplate", "voidLordLeggings", "voidLordBoots", "emeraldHelmet", "emeraldChestplate", "emeraldLeggings", "emeraldBoots", "rainbowGlasses", "tenebraeChunk",
		"tenebraeIOre", "tenebraeIngot", "rawInfernium", "inferniumIngot", "endiriteChunk", "endiriteIOre", "endiriteIngot", "tenebriumIngot", "voidiumChunk",
		"voidiumIOre", "voidiumIngot", "voidiriteIngot", "celestialCore", "emptySC", "SC_Deathcharger", "SC_PlaguedHorse", "SC_WarTortoise", "SC_SavageBadger", "SC_SwiftUnicorn",
		"goldTalisman", "voidTalisman", "autumnTalisman", "iceTalisman", "darkShard", "soulEssence", "cursedSoulEssence", "voidGem", "voidEssence", "tenebraeSword",
		"tenebraePickaxe", "tenebraeAxe", "tenebraeShovel", "tenebraeHoe", "creativeSword", "creativePickaxe", "creativeAxe", "creativeShovel", "creativeHoe",
		"voidiumSword", "voidiriteSword", "repulsorCannon", "voidiriteShield", "tenebraeLeafCutter", "woodenCrossbow", "iridisLeafBlockIB", "iridisSaplingBlockIB", "rainbowLeafBlockIB",
		"rainbowLeafBlock2IB", "rainbowSaplingBlockIB", "kyrulSaplingBlockIB", "benzenn", "benzennStatue", "lamp", "voidStone", "voidPlanks" };
	
	public static class BiomeInit {
		public static final Biome DREAD_WASTES = new BiomeGenDreadWastes(new BiomeProperties("Dread Wastes").setBaseHeight(0.2F).setWaterColor(14953751).setRainDisabled());
		public static final Biome HAUNTED_FOREST = new BiomeGenHauntedForest(new BiomeProperties("Haunted Forest").setBaseHeight(0.1F).setHeightVariation(0.1F).setWaterColor(14953751).setRainDisabled());
		public static final Biome ASH_BARRENS = new BiomeGenAshBarrens(new BiomeProperties("Ash Barrens").setWaterColor(14953751).setRainDisabled());
		public static final Biome VOID_MOUNTAINS = new BiomeGenVoidMountains(new BiomeProperties("Void Mountains").setBaseHeight(1.5F).setHeightVariation(-1.475F).setWaterColor(14953751).setRainDisabled());
		
		public static final Biome JADE_PLAINS = new BiomeGenJadePlains(new BiomeProperties("Jade Plains").setBaseHeight(0.125F).setHeightVariation(-0.75F).setWaterColor(3721952));
		public static final Biome AUTUMN_FOREST = new BiomeGenAutumnForest(new BiomeProperties("Autumn Forest").setBaseHeight(0.2F).setWaterColor(14953751));
		public static final Biome SAPPHIRE_OCEAN = new BiomeGenSapphireOcean(new BiomeProperties("Sapphire Ocean").setBaseHeight(-1.0F).setHeightVariation(1.1F).setWaterColor(3721952));
		public static final Biome RAINBOW_FOREST = new BiomeGenRainbowForest(new BiomeProperties("Rainbow Forest").setBaseHeight(0.2F).setHeightVariation(0.1F).setWaterColor(3721952));
		public static final Biome SNOW_MOUNTAINS = new BiomeGenSnowMountains(new BiomeProperties("Snow Mountains").setBaseHeight(1.0F).setHeightVariation(-0.5F).setRainDisabled().setSnowEnabled().setTemperature(0.0F).setWaterColor(3721952));
		public static final Biome STONE_QUARRY = new BiomeGenStoneQuarry(new BiomeProperties("Stone Quarry").setBaseHeight(1.0F).setHeightVariation(-0.5F).setWaterColor(3721952));
		public static final Biome DRY_DESERT = new BiomeGenDryDesert(new BiomeProperties("Dry Desert").setWaterColor(3721952));
		public static final Biome SAKURA_FOREST = new BiomeGenSakuraForest(new BiomeProperties("Sakura Forest").setBaseHeight(0.2F).setHeightVariation(0.0F).setWaterColor(3721952));
		
		public static final Biome FROZEN_SEA = new BiomeGenFrozenSea(new BiomeProperties("Frozen Sea").setBaseHeight(-1.0F).setHeightVariation(1.1F).setWaterColor(3975093).setRainDisabled().setSnowEnabled().setTemperature(0.0F));
		public static final Biome COLD_OCEAN = new BiomeGenColdOcean(new BiomeProperties("Cold Ocean").setBaseHeight(-1.0F).setHeightVariation(1.1F).setWaterColor(3721952).setRainDisabled().setSnowEnabled().setTemperature(0.3F));
		public static final Biome FROZEN_WASTES = new BiomeGenFrozenWastes(new BiomeProperties("Frozen Wastes").setBaseHeight(0.125F).setHeightVariation(-0.75F).setWaterColor(3721952).setRainDisabled().setSnowEnabled().setTemperature(0.0F));
		public static final Biome SNOW_PLATEAU = new BiomeGenSnowPlateau(new BiomeProperties("Snow Plateau").setBaseHeight(1.5F).setHeightVariation(1.475F).setRainDisabled().setSnowEnabled().setTemperature(0.0F).setWaterColor(3721952));
		
		public static void preInit() {
			BiomeDictionary.registerBiomeType(DREAD_WASTES, Type.PLAINS);
			BiomeDictionary.registerBiomeType(HAUNTED_FOREST, Type.FOREST, Type.SPOOKY);
			BiomeDictionary.registerBiomeType(ASH_BARRENS, Type.DRY);
			BiomeDictionary.registerBiomeType(VOID_MOUNTAINS, Type.HILLS);
			
			BiomeDictionary.registerBiomeType(JADE_PLAINS, Type.PLAINS);
			BiomeDictionary.registerBiomeType(AUTUMN_FOREST, Type.FOREST);
			BiomeDictionary.registerBiomeType(SAPPHIRE_OCEAN, Type.OCEAN);
			BiomeDictionary.registerBiomeType(RAINBOW_FOREST, Type.MAGICAL, Type.FOREST);
			BiomeDictionary.registerBiomeType(SNOW_MOUNTAINS, Type.COLD, Type.SNOWY);
			BiomeDictionary.registerBiomeType(STONE_QUARRY, Type.MOUNTAIN);
			BiomeDictionary.registerBiomeType(DRY_DESERT, Type.HOT, Type.SANDY, Type.DRY);
			BiomeDictionary.registerBiomeType(SAKURA_FOREST, Type.FOREST, Type.MAGICAL);
			
			BiomeDictionary.registerBiomeType(FROZEN_SEA, Type.COLD, Type.OCEAN, Type.SNOWY);
			BiomeDictionary.registerBiomeType(COLD_OCEAN, Type.OCEAN);
			BiomeDictionary.registerBiomeType(FROZEN_WASTES, Type.COLD, Type.PLAINS, Type.SNOWY);
			BiomeDictionary.registerBiomeType(SNOW_PLATEAU, Type.COLD, Type.MOUNTAIN, Type.SNOWY);
		}
	}
	
	public static class BlockInit {
		public static final Block ASH_BLOCK = new AshBlock();
		public static final Block CHISELED_TENEBRAE = new ChiseledTenebrae();
		public static final Block EMPOWERED_TENEBRAE_CORE = new EmpoweredTenebraeCore();
		public static final Block INFUSED_TENEBRAE = new InfusedTenebrae();
		public static final Block TENEBRAE_BLOCK = new TenebraeBlock();
		public static final Block TENEBRAE_CORE = new TenebraeCore();
		
		public static final Block ENDIRITE_ORE = new EndiriteOre();
		public static final Block INFERNIUM_ORE = new InferniumOre();
		public static final Block TENEBRAE_ORE = new TenebraeOre();
		public static final Block VOIDIUM_ORE = new VoidiumOre();

		public static final Block SPAWNER_VOID_DRAGON = new SpawnerVoidDragon();
		
		public static final Block GOLD_BAG = new GoldBag();
		public static final Block INFUSER_IDLE = new InfuserMachine(false, InfuserType.NORMAL);
		public static final Block INFUSER = new InfuserMachine(true, InfuserType.NORMAL);
		public static final Block ORE_INFUSER_IDLE = new InfuserMachine(false, InfuserType.ORE);
		public static final Block ORE_INFUSER = new InfuserMachine(true, InfuserType.ORE);
		public static final Block BENZENN = new Benzenn();
		public static final Block BENZENN_STATUE = new BenzennStatue();
		public static final Block LAMP = new Lamp();
		public static final Block VOID_STONE = new VoidStone();
		public static final Block VOID_PLANKS = new VoidPlanks();
		
		public static final Block IRIDIS_LEAF_BLOCK = new IridisLeafBlock();
		public static final Block IRIDIS_SAPLING_BLOCK = new IridisSaplingBlock();
		public static final Block RAINBOW_LEAF_BLOCK = new RainbowLeafBlock();
		public static final Block RAINBOW_LEAF_BLOCK_2 = new RainbowLeafBlock2();
		public static final Block RAINBOW_SAPLING_BLOCK = new RainbowSaplingBlock();
		public static final Block KYRUL_LOG_BLOCK = new KyrulLogBlock();
		public static final Block KYRUL_LEAF_BLOCK = new KyrulLeafBlock();
		public static final Block KYRUL_SAPLING_BLOCK = new KyrulSaplingBlock();
		
		public static final ItemBlock IRIDIS_LEAF_ITEMBLOCK = new IridisLeafItemBlock(BlockInit.IRIDIS_LEAF_BLOCK);
		public static final ItemBlock IRIDIS_SAPLING_ITEMBLOCK = new IridisSaplingItemBlock(BlockInit.IRIDIS_SAPLING_BLOCK);
		public static final ItemBlock RAINBOW_LEAF_ITEMBLOCK = new RainbowLeafItemBlock(BlockInit.RAINBOW_LEAF_BLOCK);
		public static final ItemBlock RAINBOW_LEAF_ITEMBLOCK_2 = new RainbowLeafItemBlock(BlockInit.RAINBOW_LEAF_BLOCK_2);
		public static final ItemBlock RAINBOW_SAPLING_ITEMBLOCK = new RainbowSaplingItemBlock(BlockInit.RAINBOW_SAPLING_BLOCK);
		public static final ItemBlock KYRUL_LEAF_ITEMBLOCK = new KyrulLeafItemBlock(BlockInit.KYRUL_LEAF_BLOCK);
		public static final ItemBlock KYRUL_SAPLING_ITEMBLOCK = new KyrulSaplingItemBlock(BlockInit.KYRUL_SAPLING_BLOCK);
		
		public static void preInit() {
			GameRegistry.registerTileEntity(TileEntitySpawnerVoidDragon.class, "spawnerVoidDragon");
			GameRegistry.registerTileEntity(TileEntityInfuser.class, "infuser");
			
			ModRegistry.addRegister(ASH_BLOCK, "ashBlock");
			ModRegistry.addRegister(CHISELED_TENEBRAE, "chiseledTenebrae");
			ModRegistry.addRegister(EMPOWERED_TENEBRAE_CORE, "empoweredTenebraeCore");
			ModRegistry.addRegister(INFUSED_TENEBRAE, "infusedTenebrae");
			ModRegistry.addRegister(TENEBRAE_BLOCK, "tenebraeBlock");
			ModRegistry.addRegister(TENEBRAE_CORE, "tenebraeCore");
			
			ModRegistry.addRegister(ENDIRITE_ORE, "endiriteOre");
			ModRegistry.addRegister(INFERNIUM_ORE, "inferniumOre");
			ModRegistry.addRegister(TENEBRAE_ORE, "tenebraeOre");
			ModRegistry.addRegister(VOIDIUM_ORE, "voidiumOre");
			
			ModRegistry.addRegister(SPAWNER_VOID_DRAGON, "spawnerVoidDragon");
			
			ModRegistry.addRegister(GOLD_BAG, "goldBag");
			ModRegistry.addRegister(INFUSER_IDLE, "infuserIdle");
			ModRegistry.addRegister(INFUSER, "infuser");
			ModRegistry.addRegister(ORE_INFUSER_IDLE, "oreInfuserIdle");
			ModRegistry.addRegister(ORE_INFUSER, "oreInfuser");
			ModRegistry.addRegister(BENZENN, "benzenn");
			ModRegistry.addRegister(BENZENN_STATUE, "benzennStatue");
			ModRegistry.addRegister(LAMP, "lamp");
			ModRegistry.addRegister(VOID_STONE, "voidStone");
			ModRegistry.addRegister(VOID_PLANKS, "voidPlanks");
			
			ModRegistry.addRegister(IRIDIS_LEAF_BLOCK, IRIDIS_LEAF_ITEMBLOCK, "iridisLeafBlock");
			ModRegistry.addRegister(IRIDIS_SAPLING_BLOCK, IRIDIS_SAPLING_ITEMBLOCK, "iridisSaplingBlock");
			ModRegistry.addRegister(RAINBOW_LEAF_BLOCK, RAINBOW_LEAF_ITEMBLOCK, "rainbowLeafBlock");
			ModRegistry.addRegister(RAINBOW_LEAF_BLOCK_2, RAINBOW_LEAF_ITEMBLOCK_2, "rainbowLeafBlock2");
			ModRegistry.addRegister(RAINBOW_SAPLING_BLOCK, RAINBOW_SAPLING_ITEMBLOCK, "rainbowSaplingBlock");
			ModRegistry.addRegister(KYRUL_LEAF_BLOCK, KYRUL_LEAF_ITEMBLOCK, "kyrulLeafBlock");
			ModRegistry.addRegister(KYRUL_SAPLING_BLOCK, KYRUL_SAPLING_ITEMBLOCK, "kyrulSaplingBlock");
		}
	}
	
	public static class DimensionInit {
		public static final DimensionType GLACIEM = DimensionType.register("Glaciem", "_glaciem", ConfigurationHandler.getGlaciemId(), WorldProviderGlaciem.class, false);
		public static final DimensionType IRIDIS = DimensionType.register("Iridis", "_iridis", ConfigurationHandler.getIridisId(), WorldProviderIridis.class, false);
		public static final DimensionType KYRUL = DimensionType.register("Kyrul", "_kyrul", ConfigurationHandler.getKyrulId(), WorldProviderKyrul.class, false);
		
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
		
		public void addSpawn(Class<? extends EntityLiving> entityClass, int spawnProb, int min, int max, Biome[] biomes) {
			if (spawnProb > 0) EntityRegistry.addSpawn(entityClass, spawnProb, min, max, EnumCreatureType.CREATURE, biomes);
		}

		public static void preInit() {
			
			// Animals
			
			registerEntity(EntityBird.class, "bird", true, 0xeaeae9, 0xc99a03);
			registerEntity(EntityRainbowPig.class, "rainbowPig", true, 0xFF9999, 0x9933FF);
			registerEntity(EntityBadger.class, "badger", true, 0x202020, 0xE0E0E0);
			registerEntity(EntityFancyBadger.class, "fancyBadger", false, 0, 0);
			registerEntity(EntityBoar.class, "boar", true, 0x663300, 0xFFFFFF);
			registerEntity(EntityUnicorn.class, "unicorn", true, 0xE0E0E0, 0xC0C0C0);
			registerEntity(EntityDeer.class, "deer", true, 0xFF9933, 0xE0E0E0);
			registerEntity(EntityStag.class, "stag", true, 0xFF8000, 0xE0E0E0);
			
			// Mobs

			registerEntity(EntityTenebraeGuardian.class, "tenebraeGuardian", true, 0x190033, 0x660000);
			registerEntity(EntitySkeletalHorse.class, "skeletalHorse", true, 0xE0E0E0, 0xC0C0C0);
			registerEntity(EntityVoidLordBoss.class, "voidLord", true, 0x404040, 0xC0C0C0);
			registerEntity(EntityTenebraeProtector.class, "tenebraeProtector", true, 0x190033, 0x000033);
			registerEntity(EntityUndeadMinion.class, "undeadMinion", true, 0xA0A0A0, 0x808080);
			registerEntity(EntityUndeadWarrior.class, "undeadWarrior", true, 0x808080, 0xFFFFFF);
			registerEntity(EntityVoidDragon.class, "voidDragon", true, 0x000000, 0xCCCCFF);
			
			// Others
			
			registerEntity(EntityTuskarr.class, "tuskarr", true, 0x000000, 0xCCCCFF);
			
			// Mounts
			
			registerEntity(MountDeathcharger.class, "Deathcharger", false, 0, 0);
			registerEntity(MountPlaguedHorse.class, "PlaguedHorse", false, 0, 0);
			registerEntity(MountWarTortoise.class, "WarTortoise", false, 0, 0);
			registerEntity(MountSavageBadger.class, "SavageBadger", false, 0, 0);
			registerEntity(MountSwiftUnicorn.class, "SwiftUnicorn", false, 0, 0);
			
			// Developers
			
			registerEntity(EntityZalthrion.class, "Zalthrion", true, 0x202020, 0x663300);
			registerEntity(EntitySixOneThree.class, "Six-One-Three", true, 0x000000, 0x00CCCC);
			
			// Projectiles
			
			registerEntity(RepulsorBolt.class, "repulsorBolt", false, 0, 0);
			registerEntity(RepulsorCannonBolt.class, "repulsorCannonBolt", false, 0, 0);
		}
	}
	
	public static class ItemInit {
		/* Armors */
		public static final ArmorMaterial TENEBRAE_ARMOR = EnumHelper.addArmorMaterial("Tenebrae", "Tenebrae", 42, new int[] {3, 8, 6, 3}, 16, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.5F);
		public static final ArmorMaterial VOID_LORD_ARMOR = EnumHelper.addArmorMaterial("VoidLord", "VoidLord", 42, new int[] {3, 8, 6, 3}, 16, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.5F);
		public static final ArmorMaterial EMERALD_ARMOR = EnumHelper.addArmorMaterial("Emerald", "Emerald", 42, new int[] {3, 8, 6, 3}, 16, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.5F);
		public static final ArmorMaterial GLASSES_ARMOR = EnumHelper.addArmorMaterial("Glasses", "Glasses", 0, new int[] {0, 0, 0, 0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.5F);
		public static final Item TENEBRAE_HELMET = new TenebraeArmor(TENEBRAE_ARMOR, "tenebrae", EntityEquipmentSlot.HEAD).setUnlocalizedName("tenebraeHelmet");
		public static final Item TENEBRAE_CHESTPLATE = new TenebraeArmor(TENEBRAE_ARMOR, "tenebrae", EntityEquipmentSlot.CHEST).setUnlocalizedName("tenebraeChestplate");
		public static final Item TENEBRAE_LEGGINGS = new TenebraeArmor(TENEBRAE_ARMOR, "tenebrae", EntityEquipmentSlot.LEGS).setUnlocalizedName("tenebraeLeggings");
		public static final Item TENEBRAE_BOOTS = new TenebraeArmor(TENEBRAE_ARMOR, "tenebrae", EntityEquipmentSlot.FEET).setUnlocalizedName("tenebraeBoots");
		public static final Item VOID_LORD_HELMET = new VoidLordArmor(VOID_LORD_ARMOR, "voidlord", EntityEquipmentSlot.HEAD).setUnlocalizedName("voidLordHelmet");
		public static final Item VOID_LORD_CHESTPLATE = new VoidLordArmor(VOID_LORD_ARMOR, "voidlord", EntityEquipmentSlot.CHEST).setUnlocalizedName("voidLordChestplate");
		public static final Item VOID_LORD_LEGGINGS = new VoidLordArmor(VOID_LORD_ARMOR, "voidlord", EntityEquipmentSlot.LEGS).setUnlocalizedName("voidLordLeggings");
		public static final Item VOID_LORD_BOOTS = new VoidLordArmor(VOID_LORD_ARMOR, "voidlord", EntityEquipmentSlot.FEET).setUnlocalizedName("voidLordBoots");
		public static final Item EMERALD_HELMET = new EmeraldArmor(EMERALD_ARMOR, "emerald", EntityEquipmentSlot.HEAD).setUnlocalizedName("emeraldHelmet");
		public static final Item EMERALD_CHESTPLATE = new EmeraldArmor(EMERALD_ARMOR, "emerald", EntityEquipmentSlot.CHEST).setUnlocalizedName("emeraldChestplate");
		public static final Item EMERALD_LEGGINGS = new EmeraldArmor(EMERALD_ARMOR, "emerald", EntityEquipmentSlot.LEGS).setUnlocalizedName("emeraldLeggings");
		public static final Item EMERALD_BOOTS = new EmeraldArmor(EMERALD_ARMOR, "emerald", EntityEquipmentSlot.FEET).setUnlocalizedName("emeraldBoots");
		public static final Item RAINBOW_GLASSES = new RainbowGlasses();
		/* General Items */
		public static final Item TENEBRAE_CHUNK = new TenebraeChunk();
		public static final Item TENEBRAE_ORE_ITEM = new TenebraeIOre();
		public static final Item TENEBRAE_INGOT = new TenebraeIngot();
		public static final Item RAW_INFERNIUM = new RawInfernium();
		public static final Item INFERIUM_INGOT = new InferniumIngot();
		public static final Item ENDIRITE_CHUNK = new EndiriteChunk();
		public static final Item ENDIRITE_ORE_ITEM = new EndiriteIOre();
		public static final Item ENDIRITE_INGOT = new EndiriteIngot();
		public static final Item TENEBRIUM_INGOT = new TenebriumIngot();
		public static final Item VOIDIUM_CHUNK = new VoidiumChunk();
		public static final Item VOIDIUM_ORE_ITEM = new VoidiumIOre();
		public static final Item VOIDIUM_INGOT = new VoidiumIngot();
		public static final Item VOIDIRITE_INGOT = new VoidiriteIngot();
		public static final Item CELESTIAL_CORE = new CelestialCore();
		public static final Item EMPTY_SC = new EmptySC();
		public static final Item SC_DEATHCHARGER = new SCDeathcharger();
		public static final Item SC_PLAGUED_HORSE = new SCPlaguedHorse();
		public static final Item SC_WAR_TORTOISE = new SCWarTortoise();
		public static final Item SC_SAVAGE_BADGER = new SCSavageBadger();
		public static final Item SC_SWIFT_UNICORN = new SCSwiftUnicorn();
		public static final Item GOLD_TALISMAN = new GoldTalisman();
		public static final Item VOID_TALISMAN = new VoidTalisman();
		public static final Item AUTUMN_TALISMAN = new AutumnTalisman();
		public static final Item ICE_TALISMAN = new IceTalisman();
		public static final Item DARK_SHARD = new DarkShard();
		public static final Item SOUL_ESSENCE = new SoulEssence();
		public static final Item CURSED_SOUL_ESSENCE = new CursedSoulEssence();
		public static final Item VOID_GEM = new VoidGem();
		public static final Item VOID_ESSENCE = new VoidEssence();
		/* Tools */
		private static final ToolMaterial CREATIVE_SWORD_MATERIAL = EnumHelper.addToolMaterial("CreativeSword", 3, 12250, 10, 996, 50);
		private static final ToolMaterial CREATIVE_DAMAGE_TOOLS = EnumHelper.addToolMaterial("creativeDamageTools", 3, 12250, 10, 500.0F, 50);
		private static final ToolMaterial CREATIVE_TOOLS = EnumHelper.addToolMaterial("creativeTools", 3, 12250, 10, 250.0F, 50);
		private static final ToolMaterial TENEBRAE_DAMAGE_TOOLS = EnumHelper.addToolMaterial("tenebraeDamageTools", 3, 2250, 10, 6.5F, 15);
		private static final ToolMaterial TENEBRAE_TOOLS = EnumHelper.addToolMaterial("tenebraeTools", 3, 2250, 10, 4.5F, 15);
		private static final ToolMaterial VOIDIUM_DAMAGE_TOOLS = EnumHelper.addToolMaterial("VoidiumDamageTools", 3, 4250, 10, 8.5F, 16);
		private static final ToolMaterial VOIDIRITE_DAMAGE_TOOLS = EnumHelper.addToolMaterial("VoidiriteDamageTools", 3, 5250, 10, 11.0F, 17);
		public static final Item TENEBRAE_SWORD = new TenebraeSword(TENEBRAE_DAMAGE_TOOLS);
		public static final Item TENEBRAE_PICKAXE = new TenebraePickaxe(TENEBRAE_DAMAGE_TOOLS);
		public static final Item TENEBRAE_AXE = new TenebraeAxe(TENEBRAE_DAMAGE_TOOLS);
		public static final Item TENEBRAE_SHOVEL = new TenebraeShovel(TENEBRAE_TOOLS);
		public static final Item TENEBRAE_HOE = new TenebraeHoe(TENEBRAE_TOOLS);
		public static final Item CREATIVE_SWORD = new CreativeSword(CREATIVE_SWORD_MATERIAL);
		public static final Item CREATIVE_PICKAXE = new CreativePickaxe(CREATIVE_DAMAGE_TOOLS);
		public static final Item CREATIVE_AXE = new CreativeAxe(CREATIVE_DAMAGE_TOOLS);
		public static final Item CREATIVE_SHOVEL = new CreativeShovel(CREATIVE_TOOLS);
		public static final Item CREATIVE_HOE = new CreativeHoe(CREATIVE_TOOLS);
		public static final Item TENEBRAE_LEAF_CUTTER = new TenebraeLeafCutter();
		public static final Item WOODEN_CROSSBOW = new WoodenCrossbow(2500);
		public static final Item VOIDIUM_SWORD = new VoidiumSword(VOIDIUM_DAMAGE_TOOLS);
		public static final Item VOIDIRITE_SWORD = new VoidiriteSword(VOIDIRITE_DAMAGE_TOOLS);
		public static final Item REPULSOR_CANNON = new RepulsorCannon(5500);
		public static final Item VOIDIRITE_SHIELD = new VoidiriteShield();
		
		public static void preInit() {
			/* Armors */
			ModRegistry.addRegister(TENEBRAE_HELMET, "tenebraeHelmet");
			ModRegistry.addRegister(TENEBRAE_CHESTPLATE, "tenebraeChestplate");
			ModRegistry.addRegister(TENEBRAE_LEGGINGS, "tenebraeLeggings");
			ModRegistry.addRegister(TENEBRAE_BOOTS, "tenebraeBoots");
			ModRegistry.addRegister(VOID_LORD_HELMET, "voidLordHelmet");
			ModRegistry.addRegister(VOID_LORD_CHESTPLATE, "voidLordChestplate");
			ModRegistry.addRegister(VOID_LORD_LEGGINGS, "voidLordLeggings");
			ModRegistry.addRegister(VOID_LORD_BOOTS, "voidLordBoots");
			ModRegistry.addRegister(EMERALD_HELMET, "emeraldHelmet");
			ModRegistry.addRegister(EMERALD_CHESTPLATE, "emeraldChestplate");
			ModRegistry.addRegister(EMERALD_LEGGINGS, "emeraldLeggings");
			ModRegistry.addRegister(EMERALD_BOOTS, "emeraldBoots");
			ModRegistry.addRegister(RAINBOW_GLASSES, "rainbowGlasses");
			/* General Items */
			ModRegistry.addRegister(TENEBRAE_CHUNK, "tenebraeChunk");
			ModRegistry.addRegister(TENEBRAE_ORE_ITEM, "tenebraeIOre");
			ModRegistry.addRegister(TENEBRAE_INGOT, "tenebraeIngot");
			ModRegistry.addRegister(RAW_INFERNIUM, "rawInfernium");
			ModRegistry.addRegister(INFERIUM_INGOT, "inferniumIngot");
			ModRegistry.addRegister(ENDIRITE_CHUNK, "endiriteChunk");
			ModRegistry.addRegister(ENDIRITE_ORE_ITEM, "endiriteIOre");
			ModRegistry.addRegister(ENDIRITE_INGOT, "endiriteIngot");
			ModRegistry.addRegister(TENEBRIUM_INGOT, "tenebriumIngot");
			ModRegistry.addRegister(VOIDIUM_CHUNK, "voidiumChunk");
			ModRegistry.addRegister(VOIDIUM_ORE_ITEM, "voidiumIOre");
			ModRegistry.addRegister(VOIDIUM_INGOT, "voidiumIngot");
			ModRegistry.addRegister(VOIDIRITE_INGOT, "voidiriteIngot");
			ModRegistry.addRegister(CELESTIAL_CORE, "celestialCore");
			ModRegistry.addRegister(EMPTY_SC, "emptySC");
			ModRegistry.addRegister(SC_DEATHCHARGER, "SC_Deathcharger");
			ModRegistry.addRegister(SC_PLAGUED_HORSE, "SC_PlaguedHorse");
			ModRegistry.addRegister(SC_WAR_TORTOISE, "SC_WarTortoise");
			ModRegistry.addRegister(SC_SAVAGE_BADGER, "SC_SavageBadger");
			ModRegistry.addRegister(SC_SWIFT_UNICORN, "SC_SwiftUnicorn");
			ModRegistry.addRegister(GOLD_TALISMAN, "goldTalisman");
			ModRegistry.addRegister(VOID_TALISMAN, "voidTalisman");
			ModRegistry.addRegister(AUTUMN_TALISMAN, "autumnTalisman");
			ModRegistry.addRegister(ICE_TALISMAN, "iceTalisman");
			ModRegistry.addRegister(DARK_SHARD, "darkShard");
			ModRegistry.addRegister(SOUL_ESSENCE, "soulEssence");
			ModRegistry.addRegister(CURSED_SOUL_ESSENCE, "cursedSoulEssence");
			ModRegistry.addRegister(VOID_GEM, "voidGem");
			ModRegistry.addRegister(VOID_ESSENCE, "voidEssence");
			/* Tools */
			ModRegistry.addRegister(TENEBRAE_PICKAXE, "tenebraePickaxe");
			ModRegistry.addRegister(TENEBRAE_SHOVEL, "tenebraeShovel");
			ModRegistry.addRegister(TENEBRAE_SWORD, "tenebraeSword");
			ModRegistry.addRegister(TENEBRAE_AXE, "tenebraeAxe");
			ModRegistry.addRegister(TENEBRAE_HOE, "tenebraeHoe");
			ModRegistry.addRegister(TENEBRAE_LEAF_CUTTER, "tenebraeLeafCutter");
			ModRegistry.addRegister(CREATIVE_PICKAXE, "creativePickaxe");
			ModRegistry.addRegister(CREATIVE_SHOVEL, "creativeShovel");
			ModRegistry.addRegister(CREATIVE_SWORD, "creativeSword");
			ModRegistry.addRegister(CREATIVE_AXE, "creativeAxe");
			ModRegistry.addRegister(CREATIVE_HOE, "creativeHoe");
			ModRegistry.addRegister(WOODEN_CROSSBOW, "woodenCrossbow");
			ModRegistry.addRegister(VOIDIUM_SWORD, "voidiumSword");
			ModRegistry.addRegister(VOIDIRITE_SWORD, "voidiriteSword");
			ModRegistry.addRegister(REPULSOR_CANNON, "repulsorCannon");
			ModRegistry.addRegister(VOIDIRITE_SHIELD, "voidiriteShield");
		}
	}
	
	public static class OreDictionaryInit {
		public static void init() {
			/* Tenebrae */
			OreDictionary.registerOre("oreTenebrae", BlockInit.TENEBRAE_ORE);
			OreDictionary.registerOre("iOreTenebrae", ItemInit.TENEBRAE_ORE_ITEM);
			OreDictionary.registerOre("ingotTenebrae", ItemInit.TENEBRAE_INGOT);
			OreDictionary.registerOre("blockTenebrae", BlockInit.TENEBRAE_BLOCK);
			
			/*Infernium */
			OreDictionary.registerOre("oreInfernium", BlockInit.INFERNIUM_ORE);
			OreDictionary.registerOre("iOreInfernium", ItemInit.RAW_INFERNIUM);
			OreDictionary.registerOre("ingotInfernium", ItemInit.INFERIUM_INGOT);
			
			/* Tenebrium */
			OreDictionary.registerOre("ingotTenebrium", ItemInit.TENEBRIUM_INGOT);
			
			/* Endirite */
			OreDictionary.registerOre("oreEndirite", BlockInit.ENDIRITE_ORE);
			OreDictionary.registerOre("iOreEndirite", ItemInit.ENDIRITE_ORE_ITEM);
			OreDictionary.registerOre("ingotEndirite", ItemInit.ENDIRITE_INGOT);
			
			/* Voidium */
			OreDictionary.registerOre("oreVoidium", BlockInit.VOIDIUM_ORE);
			OreDictionary.registerOre("iOreVoidium", ItemInit.VOIDIUM_ORE_ITEM);
			OreDictionary.registerOre("ingotVoidium", ItemInit.VOIDIUM_INGOT);
			
			/* Voidirite */
			OreDictionary.registerOre("ingotVoidirite", ItemInit.VOIDIRITE_INGOT);
			
			/* Others */
			OreDictionary.registerOre("stone", BlockInit.VOID_STONE);
			OreDictionary.registerOre("logWood", BlockInit.KYRUL_LOG_BLOCK);
			OreDictionary.registerOre("plankWood", BlockInit.VOID_PLANKS);
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
			// GameRegistry.addSmelting(BlockInit.tenebraeOre, new ItemStack(ItemInit.tenebraeChunk), 0.5F);
		}
		
		public static void registerShapedRecipes() {
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.GOLD_TALISMAN), "GEG", "EDE", "GEG", 'E', Items.ENDER_PEARL, 'G', Items.GOLD_INGOT, 'D', Items.DIAMOND);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.TENEBRAE_ORE_ITEM), "CC", "CC", 'C', ItemInit.TENEBRAE_CHUNK);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.ENDIRITE_ORE_ITEM), "CC", "CC", 'C', ItemInit.ENDIRITE_CHUNK);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.VOIDIUM_ORE_ITEM), "CC", "CC", 'C', ItemInit.VOIDIUM_CHUNK);
			GameRegistry.addShapedRecipe(new ItemStack(BlockInit.CHISELED_TENEBRAE), "IRI", "RBR", "IRI", 'I', Items.IRON_INGOT, 'R', ItemInit.TENEBRAE_CHUNK, 'B', BlockInit.TENEBRAE_BLOCK);
			GameRegistry.addShapedRecipe(new ItemStack(BlockInit.TENEBRAE_CORE), "RTR", "TBT", "RTR", 'R', Blocks.REDSTONE_BLOCK, 'T', ItemInit.TENEBRAE_INGOT, 'B', BlockInit.TENEBRAE_BLOCK);
			GameRegistry.addShapedRecipe(new ItemStack(BlockInit.EMPOWERED_TENEBRAE_CORE), "C", "B", 'C', ItemInit.CELESTIAL_CORE, 'B', BlockInit.TENEBRAE_CORE);
			GameRegistry.addShapedRecipe(new ItemStack(BlockInit.TENEBRAE_BLOCK), "III", "III", "III", 'I', ItemInit.TENEBRAE_INGOT);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.VOID_GEM), "NVN", "VDV", "NVN", 'V', ItemInit.VOID_ESSENCE, 'D', Items.DIAMOND);
			GameRegistry.addShapedRecipe(new ItemStack(BlockInit.BENZENN), "NSN", "SCS", "CCC", 'S', Blocks.STONE_SLAB, 'C', Blocks.COBBLESTONE);
			GameRegistry.addShapedRecipe(new ItemStack(BlockInit.BENZENN_STATUE), "NBN", "NSN", 'S', Blocks.STONE_SLAB, 'B', BlockInit.BENZENN);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.CELESTIAL_CORE), "RDR", "DED", "RDR", 'R', Blocks.REDSTONE_BLOCK, 'D', Items.DIAMOND, 'E', Items.ENDER_PEARL);
			GameRegistry.addShapedRecipe(new ItemStack(BlockInit.INFUSER_IDLE), "RTR", "ICI", "RTR", 'R', Blocks.REDSTONE_BLOCK, 'I', Blocks.IRON_BLOCK, 'T', BlockInit.TENEBRAE_BLOCK, 'C', ItemInit.CELESTIAL_CORE);
			GameRegistry.addShapedRecipe(new ItemStack(BlockInit.ORE_INFUSER_IDLE), "IRI", "RER", "IRI", 'R', Blocks.REDSTONE_BLOCK, 'I', Blocks.IRON_BLOCK, 'E', Items.ENDER_PEARL);
		}
		
		public static void registerShapelessRecipes() {
			GameRegistry.addShapelessRecipe(new ItemStack(ItemInit.TENEBRAE_INGOT, 9), new ItemStack(BlockInit.TENEBRAE_BLOCK));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockInit.TENEBRAE_BLOCK, 1), new ItemStack(BlockInit.CHISELED_TENEBRAE));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockInit.VOID_PLANKS, 4), new ItemStack(BlockInit.KYRUL_LOG_BLOCK, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 1, 1), new ItemStack(BlockInit.VOID_PLANKS));
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.COBBLESTONE), new ItemStack(BlockInit.VOID_STONE));
			if (ConfigurationHandler.getKyrulEnabled()) GameRegistry.addShapelessRecipe(new ItemStack(ItemInit.VOID_TALISMAN, 1), new ItemStack(ItemInit.GOLD_TALISMAN), new ItemStack(ItemInit.VOID_GEM));
		}
		
		public static void registerArmorRecipes() {
			/* Emerald Armor */
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.EMERALD_HELMET), "III", "IEI", 'I', Items.EMERALD);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.EMERALD_CHESTPLATE), "IEI", "III", "III", 'I', Items.EMERALD);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.EMERALD_LEGGINGS), "III", "IEI", "IEI", 'I', Items.EMERALD);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.EMERALD_BOOTS), "IEI", "IEI", 'I', Items.EMERALD);
			
			/* Tenebrae Armor */
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.TENEBRAE_HELMET), "III", "IEI", 'I', ItemInit.TENEBRAE_INGOT);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.TENEBRAE_CHESTPLATE), "IEI", "III", "III", 'I', ItemInit.TENEBRAE_INGOT);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.TENEBRAE_LEGGINGS), "III", "IEI", "IEI", 'I', ItemInit.TENEBRAE_INGOT);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.TENEBRAE_BOOTS), "IEI", "IEI", 'I', ItemInit.TENEBRAE_INGOT);
		}
		
		public static void registerToolRecipes() {
			/* Tenebrae Tools */
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.TENEBRAE_SWORD), "NTN", "OTO", "NBN", 'T', ItemInit.TENEBRAE_INGOT, 'O', Blocks.OBSIDIAN, 'B', Items.BLAZE_ROD);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.TENEBRAE_PICKAXE), "TTT", "NBN", "NON", 'T', ItemInit.TENEBRAE_INGOT, 'O', Blocks.OBSIDIAN, 'B', Items.BLAZE_ROD);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.TENEBRAE_AXE), "TTN", "TBN", "NON", 'T', ItemInit.TENEBRAE_INGOT, 'O', Blocks.OBSIDIAN, 'B', Items.BLAZE_ROD);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.TENEBRAE_AXE), "NTT", "NBT", "NON", 'T', ItemInit.TENEBRAE_INGOT, 'O', Blocks.OBSIDIAN, 'B', Items.BLAZE_ROD);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.TENEBRAE_SHOVEL), "NTN", "NBN", "NON", 'T', ItemInit.TENEBRAE_INGOT, 'O', Blocks.OBSIDIAN, 'B', Items.BLAZE_ROD);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.TENEBRAE_HOE), "TTN", "NBN", "NON", 'T', ItemInit.TENEBRAE_INGOT, 'O', Blocks.OBSIDIAN, 'B', Items.BLAZE_ROD);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.TENEBRAE_HOE), "NTT", "NBN", "NON", 'T', ItemInit.TENEBRAE_INGOT, 'O', Blocks.OBSIDIAN, 'B', Items.BLAZE_ROD);
		}
		
		public static void registerInfusionRecipes() {
			/* Real Fuel Items */
			// InfusionFuels.registerFuel(new ItemStack(ItemInit.tenebraeIOre), 200);
			InfusionFuels.registerFuel(new ItemStack(Items.REDSTONE), 200);
			
			/* Real Recipes */
			InfusionRecipeHandler.instance().addInfusion(InfuserType.NORMAL, 1F, 100, new ItemStack(BlockInit.ENDIRITE_ORE), new ItemStack(Blocks.END_STONE), new ItemStack(ItemInit.TENEBRAE_ORE_ITEM), new ItemStack(Items.ENDER_PEARL));
			InfusionRecipeHandler.instance().addInfusion(InfuserType.NORMAL, 1F, 100, new ItemStack(BlockInit.INFUSED_TENEBRAE), new ItemStack(BlockInit.TENEBRAE_BLOCK), new ItemStack(Items.DIAMOND), new ItemStack(Items.ENDER_PEARL));
			
			InfusionRecipeHandler.instance().addInfusion(InfuserType.ORE, 1F, 100, new ItemStack(ItemInit.TENEBRIUM_INGOT), new ItemStack(ItemInit.TENEBRAE_INGOT), new ItemStack(Items.IRON_INGOT), new ItemStack(ItemInit.INFERIUM_INGOT));
			InfusionRecipeHandler.instance().addInfusion(InfuserType.ORE, 1F, 100, new ItemStack(ItemInit.VOIDIRITE_INGOT), new ItemStack(ItemInit.VOIDIUM_INGOT), new ItemStack(Items.IRON_INGOT), new ItemStack(ItemInit.INFERIUM_INGOT));
		
			/* Temporal Recipes (Ore Smelter) */
			
			InfusionRecipeHandler.instance().addInfusion(InfuserType.ORE, 1F, 100, new ItemStack(ItemInit.TENEBRAE_INGOT), new ItemStack(ItemInit.TENEBRAE_ORE_ITEM), new ItemStack(ItemInit.TENEBRAE_ORE_ITEM), new ItemStack(ItemInit.TENEBRAE_ORE_ITEM));
			InfusionRecipeHandler.instance().addInfusion(InfuserType.ORE, 1F, 100, new ItemStack(ItemInit.INFERIUM_INGOT), new ItemStack(ItemInit.RAW_INFERNIUM), new ItemStack(ItemInit.RAW_INFERNIUM), new ItemStack(ItemInit.RAW_INFERNIUM));
			InfusionRecipeHandler.instance().addInfusion(InfuserType.ORE, 1F, 100, new ItemStack(ItemInit.ENDIRITE_INGOT), new ItemStack(ItemInit.ENDIRITE_ORE_ITEM), new ItemStack(ItemInit.ENDIRITE_ORE_ITEM), new ItemStack(ItemInit.ENDIRITE_ORE_ITEM));
			InfusionRecipeHandler.instance().addInfusion(InfuserType.ORE, 1F, 100, new ItemStack(ItemInit.VOIDIUM_INGOT), new ItemStack(ItemInit.VOIDIUM_ORE_ITEM), new ItemStack(ItemInit.VOIDIUM_ORE_ITEM), new ItemStack(ItemInit.VOIDIUM_ORE_ITEM));
		}
	}
	
	public static class SoundInit {
		public static final ResourceLocation REPULSOR_CANNON_MINE_RL = new ResourceLocation(Reference.MOD_ID.toLowerCase(), "sounds.weapon.repulsorCannon.mine");
		public static final ResourceLocation REPULSOR_CANNON_SHOOT_RL = new ResourceLocation(Reference.MOD_ID.toLowerCase(), "sounds.weapon.repulsorCannon.shoot");
		public static final SoundEvent REPULSOR_CANNON_MINE = new SoundEvent(REPULSOR_CANNON_MINE_RL);
		public static final SoundEvent REPULSOR_CANNON_SHOOT = new SoundEvent(REPULSOR_CANNON_SHOOT_RL);
		
		public static void preInit() {
			SoundEvent.REGISTRY.register(SoundEvent.REGISTRY.getKeys().size() + 1, REPULSOR_CANNON_MINE_RL, REPULSOR_CANNON_MINE);
			SoundEvent.REGISTRY.register(SoundEvent.REGISTRY.getKeys().size() + 1, REPULSOR_CANNON_SHOOT_RL, REPULSOR_CANNON_SHOOT);
		}
	}
	
	public static class ZylrothTab {
		public static final CreativeTabs ZYLROTH = new CreativeTabs("Zyl'Roth") {
			@Override public Item getTabIconItem() {
				return ItemInit.CELESTIAL_CORE; 
			}
		};
	}
	
	public static void preInit() {
		BlockInit.preInit();
		ItemInit.preInit();
		ModRegistry.sortThenRegister(sortOrder);
		EntityInit.preInit();
		DimensionInit.preInit();
		PacketHandler.preInit();
		KeyHandler.preInit();
		SoundInit.preInit();
	}
	
	public static void init() {
		OreDictionaryInit.init();
		RecipeInit.init();
	}
}