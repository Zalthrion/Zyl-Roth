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
import com.zalthrion.zylroth.entity.EntityFancyBadger;
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
		public static Biome dreadWastes = new BiomeGenDreadWastes(new BiomeProperties("Dread Wastes").setBaseHeight(0.2F).setWaterColor(14953751).setRainDisabled());
		public static Biome hauntedForest = new BiomeGenHauntedForest(new BiomeProperties("Haunted Forest").setBaseHeight(0.1F).setHeightVariation(0.1F).setWaterColor(14953751).setRainDisabled());
		public static Biome ashBarrens = new BiomeGenAshBarrens(new BiomeProperties("Ash Barrens").setWaterColor(14953751).setRainDisabled());
		public static Biome voidMountains = new BiomeGenVoidMountains(new BiomeProperties("Void Mountains").setBaseHeight(1.5F).setHeightVariation(-1.475F).setWaterColor(14953751).setRainDisabled());
		
		public static Biome jadePlains = new BiomeGenJadePlains(new BiomeProperties("Jade Plains").setBaseHeight(0.125F).setHeightVariation(-0.75F).setWaterColor(3721952));
		public static Biome autumnForest = new BiomeGenAutumnForest(new BiomeProperties("Autumn Forest").setBaseHeight(0.2F).setWaterColor(14953751));
		public static Biome sapphireOcean = new BiomeGenSapphireOcean(new BiomeProperties("Sapphire Ocean").setBaseHeight(-1.0F).setHeightVariation(1.1F).setWaterColor(3721952));
		public static Biome rainbowForest = new BiomeGenRainbowForest(new BiomeProperties("Rainbow Forest").setBaseHeight(0.2F).setHeightVariation(0.1F).setWaterColor(3721952));
		public static Biome snowMountains = new BiomeGenSnowMountains(new BiomeProperties("Snow Mountains").setBaseHeight(1.0F).setHeightVariation(-0.5F).setRainDisabled().setSnowEnabled().setTemperature(0.0F).setWaterColor(3721952));
		public static Biome stoneQuarry = new BiomeGenStoneQuarry(new BiomeProperties("Stone Quarry").setBaseHeight(1.0F).setHeightVariation(-0.5F).setWaterColor(3721952));
		public static Biome dryDesert = new BiomeGenDryDesert(new BiomeProperties("Dry Desert").setWaterColor(3721952));
		public static Biome sakuraForest = new BiomeGenSakuraForest(new BiomeProperties("Sakura Forest").setBaseHeight(0.2F).setHeightVariation(0.0F).setWaterColor(3721952));
		
		public static Biome frozenSea = new BiomeGenFrozenSea(new BiomeProperties("Frozen Sea").setBaseHeight(-1.0F).setHeightVariation(1.1F).setWaterColor(3975093).setRainDisabled().setSnowEnabled().setTemperature(0.0F));
		public static Biome coldOcean = new BiomeGenColdOcean(new BiomeProperties("Cold Ocean").setBaseHeight(-1.0F).setHeightVariation(1.1F).setWaterColor(3721952).setRainDisabled().setSnowEnabled().setTemperature(0.3F));
		public static Biome frozenWastes = new BiomeGenFrozenWastes(new BiomeProperties("Frozen Wastes").setBaseHeight(0.125F).setHeightVariation(-0.75F).setWaterColor(3721952).setRainDisabled().setSnowEnabled().setTemperature(0.0F));
		public static Biome snowPlateau = new BiomeGenSnowPlateau(new BiomeProperties("Snow Plateau").setBaseHeight(1.5F).setHeightVariation(1.475F).setRainDisabled().setSnowEnabled().setTemperature(0.0F).setWaterColor(3721952));
		
		public static void preInit() {
			BiomeDictionary.registerBiomeType(dreadWastes, Type.PLAINS);
			BiomeDictionary.registerBiomeType(hauntedForest, Type.FOREST, Type.SPOOKY);
			BiomeDictionary.registerBiomeType(ashBarrens, Type.DRY);
			BiomeDictionary.registerBiomeType(voidMountains, Type.HILLS);
			
			BiomeDictionary.registerBiomeType(jadePlains, Type.PLAINS);
			BiomeDictionary.registerBiomeType(autumnForest, Type.FOREST);
			BiomeDictionary.registerBiomeType(sapphireOcean, Type.OCEAN);
			BiomeDictionary.registerBiomeType(rainbowForest, Type.MAGICAL, Type.FOREST);
			BiomeDictionary.registerBiomeType(snowMountains, Type.COLD, Type.SNOWY);
			BiomeDictionary.registerBiomeType(stoneQuarry, Type.MOUNTAIN);
			BiomeDictionary.registerBiomeType(dryDesert, Type.HOT, Type.SANDY, Type.DRY);
			BiomeDictionary.registerBiomeType(sakuraForest, Type.FOREST, Type.MAGICAL);
			
			BiomeDictionary.registerBiomeType(frozenSea, Type.COLD, Type.OCEAN, Type.SNOWY);
			BiomeDictionary.registerBiomeType(coldOcean, Type.OCEAN);
			BiomeDictionary.registerBiomeType(frozenWastes, Type.COLD, Type.PLAINS, Type.SNOWY);
			BiomeDictionary.registerBiomeType(snowPlateau, Type.COLD, Type.MOUNTAIN, Type.SNOWY);
		}
	}
	
	public static class BlockInit {
		public static final Block ashBlock = new AshBlock();
		public static final Block chiseledTenebrae = new ChiseledTenebrae();
		public static final Block empoweredTenebraeCore = new EmpoweredTenebraeCore();
		public static final Block infusedTenebrae = new InfusedTenebrae();
		public static final Block tenebraeBlock = new TenebraeBlock();
		public static final Block tenebraeCore = new TenebraeCore();
		
		public static final Block endiriteOre = new EndiriteOre();
		public static final Block inferniumOre = new InferniumOre();
		public static final Block tenebraeOre = new TenebraeOre();
		public static final Block voidiumOre = new VoidiumOre();

		public static final Block spawnerVoidDragon = new SpawnerVoidDragon();
		
		public static final Block goldBag = new GoldBag();
		public static final Block infuserIdle = new InfuserMachine(false, InfuserType.NORMAL);
		public static final Block infuser = new InfuserMachine(true, InfuserType.NORMAL);
		public static final Block oreInfuserIdle = new InfuserMachine(false, InfuserType.ORE);
		public static final Block oreInfuser = new InfuserMachine(true, InfuserType.ORE);
		public static final Block benzenn = new Benzenn();
		public static final Block benzennStatue = new BenzennStatue();
		public static final Block lamp = new Lamp();
		public static final Block voidStone = new VoidStone();
		public static final Block voidPlanks = new VoidPlanks();
		
		public static final Block iridisLeafBlock = new IridisLeafBlock();
		public static final Block iridisSaplingBlock = new IridisSaplingBlock();
		public static final Block rainbowLeafBlock = new RainbowLeafBlock();
		public static final Block rainbowLeafBlock2 = new RainbowLeafBlock2();
		public static final Block rainbowSaplingBlock = new RainbowSaplingBlock();
		public static final Block kyrulLogBlock = new KyrulLogBlock().setUnlocalizedName("kyrulLogBlock").setRegistryName("kyrulLogBlock");
		public static final Block kyrulLeafBlock = new KyrulLeafBlock();
		public static final Block kyrulSaplingBlock = new KyrulSaplingBlock();
		
		public static final ItemBlock iridisLeafBlockIB = new IridisLeafItemBlock(BlockInit.iridisLeafBlock);
		public static final ItemBlock iridisSaplingBlockIB = new IridisSaplingItemBlock(BlockInit.iridisSaplingBlock);
		public static final ItemBlock rainbowLeafBlockIB = new RainbowLeafItemBlock(BlockInit.rainbowLeafBlock);
		public static final ItemBlock rainbowLeafBlock2IB = new RainbowLeafItemBlock(BlockInit.rainbowLeafBlock2);
		public static final ItemBlock rainbowSaplingBlockIB = new RainbowSaplingItemBlock(BlockInit.rainbowSaplingBlock);
		public static final ItemBlock kyrulLeafBlockIB = new KyrulLeafItemBlock(BlockInit.kyrulLeafBlock);
		public static final ItemBlock kyrulSaplingBlockIB = new KyrulSaplingItemBlock(BlockInit.kyrulSaplingBlock);
		
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
			ModRegistry.addRegister(benzenn, "benzenn");
			ModRegistry.addRegister(benzennStatue, "benzennStatue");
			ModRegistry.addRegister(lamp, "lamp");
			ModRegistry.addRegister(voidStone, "voidStone");
			ModRegistry.addRegister(voidPlanks, "voidPlanks");
			
			ModRegistry.addRegister(iridisLeafBlock, iridisLeafBlockIB, "iridisLeafBlock");
			ModRegistry.addRegister(iridisSaplingBlock, iridisSaplingBlockIB, "iridisSaplingBlock");
			ModRegistry.addRegister(rainbowLeafBlock, rainbowLeafBlockIB, "rainbowLeafBlock");
			ModRegistry.addRegister(rainbowLeafBlock2, rainbowLeafBlock2IB, "rainbowLeafBlock2");
			ModRegistry.addRegister(rainbowSaplingBlock, rainbowSaplingBlockIB, "rainbowSaplingBlock");
			ModRegistry.addRegister(kyrulLeafBlock, kyrulLeafBlockIB, "kyrulLeafBlock");
			ModRegistry.addRegister(kyrulSaplingBlock, kyrulSaplingBlockIB, "kyrulSaplingBlock");
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
		
		public void addSpawn(Class<? extends EntityLiving> entityClass, int spawnProb, int min, int max, Biome[] biomes) {
			if (spawnProb > 0) EntityRegistry.addSpawn(entityClass, spawnProb, min, max, EnumCreatureType.CREATURE, biomes);
		}

		public static void init() {
			
			// Animals
			
			// registerEntity(EntityBird.class, "bird", true, 0xeaeae9, 0xc99a03); // TODO Duplicate stat ID error
			// registerEntity(EntityRainbowPig.class, "rainbowPig", true, 0xFF9999, 0x9933FF);
			// registerEntity(EntityBadger.class, "badger", true, 0x202020, 0xE0E0E0);
			registerEntity(EntityFancyBadger.class, "fancyBadger", false, 0, 0);
			// registerEntity(EntityBoar.class, "boar", true, 0x663300, 0xFFFFFF);
			// registerEntity(EntityUnicorn.class, "unicorn", true, 0xE0E0E0, 0xC0C0C0);
			// registerEntity(EntityDeer.class, "deer", true, 0xFF9933, 0xE0E0E0);
			// registerEntity(EntityStag.class, "stag", true, 0xFF8000, 0xE0E0E0);
			
			// Mobs

			// registerEntity(EntityTenebraeGuardian.class, "tenebraeGuardian", true, 0x190033, 0x660000);
			// registerEntity(EntitySkeletalHorse.class, "skeletalHorse", true, 0xE0E0E0, 0xC0C0C0);
			// registerEntity(EntityVoidLordBoss.class, "voidLord", true, 0x404040, 0xC0C0C0);
			// registerEntity(EntityTenebraeProtector.class, "tenebraeProtector", true, 0x190033, 0x000033);
			// registerEntity(EntityUndeadMinion.class, "undeadMinion", true, 0xA0A0A0, 0x808080);
			// registerEntity(EntityUndeadWarrior.class, "undeadWarrior", true, 0x808080, 0xFFFFFF);
			// registerEntity(EntityVoidDragon.class, "voidDragon", true, 0x000000, 0xCCCCFF);
			
			// Others
			
			// registerEntity(EntityTuskarr.class, "tuskarr", true, 0x000000, 0xCCCCFF);
			
			// Mounts
			
			registerEntity(MountDeathcharger.class, "Deathcharger", false, 0, 0);
			registerEntity(MountPlaguedHorse.class, "PlaguedHorse", false, 0, 0);
			registerEntity(MountWarTortoise.class, "WarTortoise", false, 0, 0);
			registerEntity(MountSavageBadger.class, "SavageBadger", false, 0, 0);
			registerEntity(MountSwiftUnicorn.class, "SwiftUnicorn", false, 0, 0);
			
			// Developers
			
			// registerEntity(EntityZalthrion.class, "Zalthrion", true, 0x202020, 0x663300);
			// registerEntity(EntitySixOneThree.class, "Six-One-Three", true, 0x000000, 0x00CCCC);
			
			// Projectiles
			
			registerEntity(RepulsorBolt.class, "repulsorBolt", false, 0, 0);
			registerEntity(RepulsorCannonBolt.class, "repulsorCannonBolt", false, 0, 0);
		}
	}
	
	public static class ItemInit {
		/* Armors */
		public static final ArmorMaterial tenebrae = EnumHelper.addArmorMaterial("Tenebrae", "Tenebrae", 42, new int[] {3, 8, 6, 3}, 16, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.5F);
		public static final ArmorMaterial voidLord = EnumHelper.addArmorMaterial("VoidLord", "VoidLord", 42, new int[] {3, 8, 6, 3}, 16, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.5F);
		public static final ArmorMaterial emerald = EnumHelper.addArmorMaterial("Emerald", "Emerald", 42, new int[] {3, 8, 6, 3}, 16, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.5F);
		public static final ArmorMaterial glasses = EnumHelper.addArmorMaterial("Glasses", "Glasses", 0, new int[] {0, 0, 0, 0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.5F);
		public static final Item tenebraeHelmet = new TenebraeArmor(tenebrae, "tenebrae", EntityEquipmentSlot.HEAD).setUnlocalizedName("tenebraeHelmet");
		public static final Item tenebraeChestplate = new TenebraeArmor(tenebrae, "tenebrae", EntityEquipmentSlot.CHEST).setUnlocalizedName("tenebraeChestplate");
		public static final Item tenebraeLeggings = new TenebraeArmor(tenebrae, "tenebrae", EntityEquipmentSlot.LEGS).setUnlocalizedName("tenebraeLeggings");
		public static final Item tenebraeBoots = new TenebraeArmor(tenebrae, "tenebrae", EntityEquipmentSlot.FEET).setUnlocalizedName("tenebraeBoots");
		public static final Item voidLordHelmet = new VoidLordArmor(voidLord, "voidlord", EntityEquipmentSlot.HEAD).setUnlocalizedName("voidLordHelmet");
		public static final Item voidLordChestplate = new VoidLordArmor(voidLord, "voidlord", EntityEquipmentSlot.CHEST).setUnlocalizedName("voidLordChestplate");
		public static final Item voidLordLeggings = new VoidLordArmor(voidLord, "voidlord", EntityEquipmentSlot.LEGS).setUnlocalizedName("voidLordLeggings");
		public static final Item voidLordBoots = new VoidLordArmor(voidLord, "voidlord", EntityEquipmentSlot.FEET).setUnlocalizedName("voidLordBoots");
		public static final Item emeraldHelmet = new EmeraldArmor(emerald, "emerald", EntityEquipmentSlot.HEAD).setUnlocalizedName("emeraldHelmet");
		public static final Item emeraldChestplate = new EmeraldArmor(emerald, "emerald", EntityEquipmentSlot.CHEST).setUnlocalizedName("emeraldChestplate");
		public static final Item emeraldLeggings = new EmeraldArmor(emerald, "emerald", EntityEquipmentSlot.LEGS).setUnlocalizedName("emeraldLeggings");
		public static final Item emeraldBoots = new EmeraldArmor(emerald, "emerald", EntityEquipmentSlot.FEET).setUnlocalizedName("emeraldBoots");
		public static final Item rainbowGlasses = new RainbowGlasses();
		/* General Items */
		public static final Item tenebraeChunk = new TenebraeChunk();
		public static final Item tenebraeIOre = new TenebraeIOre();
		public static final Item tenebraeIngot = new TenebraeIngot();
		public static final Item rawInfernium = new RawInfernium();
		public static final Item inferniumIngot = new InferniumIngot();
		public static final Item endiriteChunk = new EndiriteChunk();
		public static final Item endiriteIOre = new EndiriteIOre();
		public static final Item endiriteIngot = new EndiriteIngot();
		public static final Item tenebriumIngot = new TenebriumIngot();
		public static final Item voidiumChunk = new VoidiumChunk();
		public static final Item voidiumIOre = new VoidiumIOre();
		public static final Item voidiumIngot = new VoidiumIngot();
		public static final Item voidiriteIngot = new VoidiriteIngot();
		public static final Item celestialCore = new CelestialCore();
		public static final Item Empty_SC = new EmptySC();
		public static final Item SC_Deathcharger = new SCDeathcharger();
		public static final Item SC_PlaguedHorse = new SCPlaguedHorse();
		public static final Item SC_WarTortoise = new SCWarTortoise();
		public static final Item SC_SavageBadger = new SCSavageBadger();
		public static final Item SC_SwiftUnicorn = new SCSwiftUnicorn();
		public static final Item goldTalisman = new GoldTalisman();
		public static final Item voidTalisman = new VoidTalisman();
		public static final Item autumnTalisman = new AutumnTalisman();
		public static final Item iceTalisman = new IceTalisman();
		public static final Item darkShard = new DarkShard();
		public static final Item soulEssence = new SoulEssence();
		public static final Item cursedSoulEssence = new CursedSoulEssence();
		public static final Item voidGem = new VoidGem();
		public static final Item voidEssence = new VoidEssence();
		/* Tools */
		private static final ToolMaterial creativeSwordMaterial = EnumHelper.addToolMaterial("CreativeSword", 3, 12250, 10, 996, 50);
		private static final ToolMaterial creativeDamageTools = EnumHelper.addToolMaterial("creativeDamageTools", 3, 12250, 10, 500.0F, 50);
		private static final ToolMaterial creativeTools = EnumHelper.addToolMaterial("creativeTools", 3, 12250, 10, 250.0F, 50);
		private static final ToolMaterial tenebraeDamageTools = EnumHelper.addToolMaterial("tenebraeDamageTools", 3, 2250, 10, 6.5F, 15);
		private static final ToolMaterial tenebraeTools = EnumHelper.addToolMaterial("tenebraeTools", 3, 2250, 10, 4.5F, 15);
		private static final ToolMaterial voidiumDamageTools = EnumHelper.addToolMaterial("VoidiumDamageTools", 3, 4250, 10, 8.5F, 16);
		private static final ToolMaterial voidiriteDamageTools = EnumHelper.addToolMaterial("VoidiriteDamageTools", 3, 5250, 10, 11.0F, 17);
		public static final Item tenebraeSword = new TenebraeSword(tenebraeDamageTools);
		public static final Item tenebraePickaxe = new TenebraePickaxe(tenebraeDamageTools);
		public static final Item tenebraeAxe = new TenebraeAxe(tenebraeDamageTools);
		public static final Item tenebraeShovel = new TenebraeShovel(tenebraeTools);
		public static final Item tenebraeHoe = new TenebraeHoe(tenebraeTools);
		public static final Item creativeSword = new CreativeSword(creativeSwordMaterial);
		public static final Item creativePickaxe = new CreativePickaxe(creativeDamageTools);
		public static final Item creativeAxe = new CreativeAxe(creativeDamageTools);
		public static final Item creativeShovel = new CreativeShovel(creativeTools);
		public static final Item creativeHoe = new CreativeHoe(creativeTools);
		public static final Item tenebraeLeafCutter = new TenebraeLeafCutter();
		public static final Item woodenCrossbow = new WoodenCrossbow(2500);
		public static final Item voidiumSword = new VoidiumSword(voidiumDamageTools);
		public static final Item voidiriteSword = new VoidiriteSword(voidiriteDamageTools);
		public static final Item repulsorCannon = new RepulsorCannon(5500);
		public static final Item voidiriteShield = new VoidiriteShield();
		
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
			ModRegistry.addRegister(emeraldHelmet, "emeraldHelmet");
			ModRegistry.addRegister(emeraldChestplate, "emeraldChestplate");
			ModRegistry.addRegister(emeraldLeggings, "emeraldLeggings");
			ModRegistry.addRegister(emeraldBoots, "emeraldBoots");
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
			ModRegistry.addRegister(voidiriteIngot, "voidiriteIngot");
			ModRegistry.addRegister(celestialCore, "celestialCore");
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
			ModRegistry.addRegister(voidiumSword, "voidiumSword");
			ModRegistry.addRegister(voidiriteSword, "voidiriteSword");
			ModRegistry.addRegister(repulsorCannon, "repulsorCannon");
			ModRegistry.addRegister(voidiriteShield, "voidiriteShield");
		}
	}
	
	public static class OreDictionaryInit {
		public static void init() {
			/* Tenebrae */
			OreDictionary.registerOre("oreTenebrae", BlockInit.tenebraeOre);
			OreDictionary.registerOre("iOreTenebrae", ItemInit.tenebraeIOre);
			OreDictionary.registerOre("ingotTenebrae", ItemInit.tenebraeIngot);
			OreDictionary.registerOre("blockTenebrae", BlockInit.tenebraeBlock);
			
			/*Infernium */
			OreDictionary.registerOre("oreInfernium", BlockInit.inferniumOre);
			OreDictionary.registerOre("iOreInfernium", ItemInit.rawInfernium);
			OreDictionary.registerOre("ingotInfernium", ItemInit.inferniumIngot);
			
			/* Tenebrium */
			OreDictionary.registerOre("ingotTenebrium", ItemInit.tenebriumIngot);
			
			/* Endirite */
			OreDictionary.registerOre("oreEndirite", BlockInit.endiriteOre);
			OreDictionary.registerOre("iOreEndirite", ItemInit.endiriteIOre);
			OreDictionary.registerOre("ingotEndirite", ItemInit.endiriteIngot);
			
			/* Voidium */
			OreDictionary.registerOre("oreVoidium", BlockInit.voidiumOre);
			OreDictionary.registerOre("iOreVoidium", ItemInit.voidiumIOre);
			OreDictionary.registerOre("ingotVoidium", ItemInit.voidiumIngot);
			
			/* Voidirite */
			OreDictionary.registerOre("ingotVoidirite", ItemInit.voidiriteIngot);
			
			/* Others */
			OreDictionary.registerOre("stone", BlockInit.voidStone);
			OreDictionary.registerOre("logWood", BlockInit.kyrulLogBlock);
			OreDictionary.registerOre("plankWood", BlockInit.voidPlanks);
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
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.goldTalisman), "GEG", "EDE", "GEG", 'E', Items.ENDER_PEARL, 'G', Items.GOLD_INGOT, 'D', Items.DIAMOND);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraeIOre), "CC", "CC", 'C', ItemInit.tenebraeChunk);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.endiriteIOre), "CC", "CC", 'C', ItemInit.endiriteChunk);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.voidiumIOre), "CC", "CC", 'C', ItemInit.voidiumChunk);
			GameRegistry.addShapedRecipe(new ItemStack(BlockInit.chiseledTenebrae), "IRI", "RBR", "IRI", 'I', Items.IRON_INGOT, 'R', ItemInit.tenebraeChunk, 'B', BlockInit.tenebraeBlock);
			GameRegistry.addShapedRecipe(new ItemStack(BlockInit.tenebraeCore), "RTR", "TBT", "RTR", 'R', Blocks.REDSTONE_BLOCK, 'T', ItemInit.tenebraeIngot, 'B', BlockInit.tenebraeBlock);
			GameRegistry.addShapedRecipe(new ItemStack(BlockInit.empoweredTenebraeCore), "C", "B", 'C', ItemInit.celestialCore, 'B', BlockInit.tenebraeCore);
			GameRegistry.addShapedRecipe(new ItemStack(BlockInit.tenebraeBlock), "III", "III", "III", 'I', ItemInit.tenebraeIngot);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.voidGem), "NVN", "VDV", "NVN", 'V', ItemInit.voidEssence, 'D', Items.DIAMOND);
			GameRegistry.addShapedRecipe(new ItemStack(BlockInit.benzenn), "NSN", "SCS", "CCC", 'S', Blocks.STONE_SLAB, 'C', Blocks.COBBLESTONE);
			GameRegistry.addShapedRecipe(new ItemStack(BlockInit.benzennStatue), "NBN", "NSN", 'S', Blocks.STONE_SLAB, 'B', BlockInit.benzenn);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.celestialCore), "RDR", "DED", "RDR", 'R', Blocks.REDSTONE_BLOCK, 'D', Items.DIAMOND, 'E', Items.ENDER_PEARL);
			GameRegistry.addShapedRecipe(new ItemStack(BlockInit.infuserIdle), "RTR", "ICI", "RTR", 'R', Blocks.REDSTONE_BLOCK, 'I', Blocks.IRON_BLOCK, 'T', BlockInit.tenebraeBlock, 'C', ItemInit.celestialCore);
			GameRegistry.addShapedRecipe(new ItemStack(BlockInit.oreInfuserIdle), "IRI", "RER", "IRI", 'R', Blocks.REDSTONE_BLOCK, 'I', Blocks.IRON_BLOCK, 'E', Items.ENDER_PEARL);
		}
		
		public static void registerShapelessRecipes() {
			GameRegistry.addShapelessRecipe(new ItemStack(ItemInit.tenebraeIngot, 9), new ItemStack(BlockInit.tenebraeBlock));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockInit.tenebraeBlock, 1), new ItemStack(BlockInit.chiseledTenebrae));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockInit.voidPlanks, 4), new ItemStack(BlockInit.kyrulLogBlock, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 1, 1), new ItemStack(BlockInit.voidPlanks));
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.COBBLESTONE), new ItemStack(BlockInit.voidStone));
			if (ConfigurationHandler.getKyrulEnabled()) GameRegistry.addShapelessRecipe(new ItemStack(ItemInit.voidTalisman, 1), new ItemStack(ItemInit.goldTalisman), new ItemStack(ItemInit.voidGem));
		}
		
		public static void registerArmorRecipes() {
			/* Emerald Armor */
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.emeraldHelmet), "III", "IEI", 'I', Items.EMERALD);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.emeraldChestplate), "IEI", "III", "III", 'I', Items.EMERALD);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.emeraldLeggings), "III", "IEI", "IEI", 'I', Items.EMERALD);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.emeraldBoots), "IEI", "IEI", 'I', Items.EMERALD);
			
			/* Tenebrae Armor */
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraeHelmet), "III", "IEI", 'I', ItemInit.tenebraeIngot);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraeChestplate), "IEI", "III", "III", 'I', ItemInit.tenebraeIngot);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraeLeggings), "III", "IEI", "IEI", 'I', ItemInit.tenebraeIngot);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraeBoots), "IEI", "IEI", 'I', ItemInit.tenebraeIngot);
		}
		
		public static void registerToolRecipes() {
			/* Tenebrae Tools */
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraeSword), "NTN", "OTO", "NBN", 'T', ItemInit.tenebraeIngot, 'O', Blocks.OBSIDIAN, 'B', Items.BLAZE_ROD);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraePickaxe), "TTT", "NBN", "NON", 'T', ItemInit.tenebraeIngot, 'O', Blocks.OBSIDIAN, 'B', Items.BLAZE_ROD);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraeAxe), "TTN", "TBN", "NON", 'T', ItemInit.tenebraeIngot, 'O', Blocks.OBSIDIAN, 'B', Items.BLAZE_ROD);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraeAxe), "NTT", "NBT", "NON", 'T', ItemInit.tenebraeIngot, 'O', Blocks.OBSIDIAN, 'B', Items.BLAZE_ROD);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraeShovel), "NTN", "NBN", "NON", 'T', ItemInit.tenebraeIngot, 'O', Blocks.OBSIDIAN, 'B', Items.BLAZE_ROD);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraeHoe), "TTN", "NBN", "NON", 'T', ItemInit.tenebraeIngot, 'O', Blocks.OBSIDIAN, 'B', Items.BLAZE_ROD);
			GameRegistry.addShapedRecipe(new ItemStack(ItemInit.tenebraeHoe), "NTT", "NBN", "NON", 'T', ItemInit.tenebraeIngot, 'O', Blocks.OBSIDIAN, 'B', Items.BLAZE_ROD);
		}
		
		public static void registerInfusionRecipes() {
			/* Real Fuel Items */
			// InfusionFuels.registerFuel(new ItemStack(ItemInit.tenebraeIOre), 200);
			InfusionFuels.registerFuel(new ItemStack(Items.REDSTONE), 200);
			
			/* Real Recipes */
			InfusionRecipeHandler.instance().addInfusion(InfuserType.NORMAL, 1F, 100, new ItemStack(BlockInit.endiriteOre), new ItemStack(Blocks.END_STONE), new ItemStack(ItemInit.tenebraeIOre), new ItemStack(Items.ENDER_PEARL));
			InfusionRecipeHandler.instance().addInfusion(InfuserType.NORMAL, 1F, 100, new ItemStack(BlockInit.infusedTenebrae), new ItemStack(BlockInit.tenebraeBlock), new ItemStack(Items.DIAMOND), new ItemStack(Items.ENDER_PEARL));
			
			InfusionRecipeHandler.instance().addInfusion(InfuserType.ORE, 1F, 100, new ItemStack(ItemInit.tenebriumIngot), new ItemStack(ItemInit.tenebraeIngot), new ItemStack(Items.IRON_INGOT), new ItemStack(ItemInit.inferniumIngot));
			InfusionRecipeHandler.instance().addInfusion(InfuserType.ORE, 1F, 100, new ItemStack(ItemInit.voidiriteIngot), new ItemStack(ItemInit.voidiumIngot), new ItemStack(Items.IRON_INGOT), new ItemStack(ItemInit.inferniumIngot));
		
			/* Temporal Recipes (Ore Smelter) */
			
			InfusionRecipeHandler.instance().addInfusion(InfuserType.ORE, 1F, 100, new ItemStack(ItemInit.tenebraeIngot), new ItemStack(ItemInit.tenebraeIOre), new ItemStack(ItemInit.tenebraeIOre), new ItemStack(ItemInit.tenebraeIOre));
			InfusionRecipeHandler.instance().addInfusion(InfuserType.ORE, 1F, 100, new ItemStack(ItemInit.inferniumIngot), new ItemStack(ItemInit.rawInfernium), new ItemStack(ItemInit.rawInfernium), new ItemStack(ItemInit.rawInfernium));
			InfusionRecipeHandler.instance().addInfusion(InfuserType.ORE, 1F, 100, new ItemStack(ItemInit.endiriteIngot), new ItemStack(ItemInit.endiriteIOre), new ItemStack(ItemInit.endiriteIOre), new ItemStack(ItemInit.endiriteIOre));
			InfusionRecipeHandler.instance().addInfusion(InfuserType.ORE, 1F, 100, new ItemStack(ItemInit.voidiumIngot), new ItemStack(ItemInit.voidiumIOre), new ItemStack(ItemInit.voidiumIOre), new ItemStack(ItemInit.voidiumIOre));
		}
	}
	
	public static class SoundInit {
		public static final ResourceLocation repulsorCannonMineRL = new ResourceLocation(Reference.MOD_ID.toLowerCase() + "sounds.weapon.repulsorCannon.mine");
		public static final ResourceLocation repulsorCannonShootRL = new ResourceLocation(Reference.MOD_ID.toLowerCase() + "sounds.weapon.repulsorCannon.shoot");
		public static final SoundEvent repulsorCannonMine = new SoundEvent(repulsorCannonMineRL);
		public static final SoundEvent repulsorCannonShoot = new SoundEvent(repulsorCannonShootRL);
		
		public static void preInit() {
			SoundEvent.REGISTRY.register(SoundEvent.REGISTRY.getKeys().size() + 1, repulsorCannonMineRL, repulsorCannonMine);
			SoundEvent.REGISTRY.register(SoundEvent.REGISTRY.getKeys().size() + 1, repulsorCannonShootRL, repulsorCannonShoot);
		}
	}
	
	public static class ZylrothTab {
		public static CreativeTabs zylRoth = new CreativeTabs("Zyl'Roth") {
			@Override public Item getTabIconItem() {
				return ItemInit.celestialCore; 
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
		SoundInit.preInit();
	}
	
	public static void init() {
		EntityInit.init();
		OreDictionaryInit.init();
		RecipeInit.init();
	}
}