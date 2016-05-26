package com.zalthrion.zylroth.proxy;

import java.util.HashMap;
import java.util.Map;

import com.zalthrion.zylroth.entity.EntityBadger;
import com.zalthrion.zylroth.entity.EntityBird;
import com.zalthrion.zylroth.entity.EntityBoar;
import com.zalthrion.zylroth.entity.EntityDeer;
import com.zalthrion.zylroth.entity.EntityFancyBadger;
import com.zalthrion.zylroth.entity.EntityRainbowPig;
import com.zalthrion.zylroth.entity.EntitySkeletalHorse;
import com.zalthrion.zylroth.entity.EntityStag;
import com.zalthrion.zylroth.entity.EntityTenebraeProtector;
import com.zalthrion.zylroth.entity.EntityTuskarr;
import com.zalthrion.zylroth.entity.EntityUndeadMinion;
import com.zalthrion.zylroth.entity.EntityUndeadWarrior;
import com.zalthrion.zylroth.entity.EntityUnicorn;
import com.zalthrion.zylroth.entity.EntityVoidDragon;
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
import com.zalthrion.zylroth.event.KeyInputEvent;
import com.zalthrion.zylroth.handler.KeyHandler;
import com.zalthrion.zylroth.lib.ModArmors;
import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.lib.ModTools;
import com.zalthrion.zylroth.model.armor.ModelVoidLordArmor;
import com.zalthrion.zylroth.model.entity.ModelBadger;
import com.zalthrion.zylroth.model.entity.ModelBird;
import com.zalthrion.zylroth.model.entity.ModelBoar;
import com.zalthrion.zylroth.model.entity.ModelDeer;
import com.zalthrion.zylroth.model.entity.ModelEmpoweredTenebraeGolem;
import com.zalthrion.zylroth.model.entity.ModelRainbowPig;
import com.zalthrion.zylroth.model.entity.ModelSkeletalHorse;
import com.zalthrion.zylroth.model.entity.ModelSpecialBiped;
import com.zalthrion.zylroth.model.entity.ModelStag;
import com.zalthrion.zylroth.model.entity.ModelTenebraeGolem;
import com.zalthrion.zylroth.model.entity.ModelTuskarr;
import com.zalthrion.zylroth.model.entity.ModelUndead;
import com.zalthrion.zylroth.model.entity.ModelUndead2;
import com.zalthrion.zylroth.model.entity.ModelUnicorn;
import com.zalthrion.zylroth.model.entity.mount.ModelDeathcharger;
import com.zalthrion.zylroth.model.entity.mount.ModelPlaguedHorse;
import com.zalthrion.zylroth.model.entity.mount.ModelSavageBadger;
import com.zalthrion.zylroth.model.entity.mount.ModelSwiftUnicorn;
import com.zalthrion.zylroth.model.entity.mount.ModelWarTortoise;
import com.zalthrion.zylroth.model.projectile.ModelRepulsorBolt;
import com.zalthrion.zylroth.reference.RenderIDs;
import com.zalthrion.zylroth.render.BlockTESRRenderer;
import com.zalthrion.zylroth.render.entity.RenderBadger;
import com.zalthrion.zylroth.render.entity.RenderBird;
import com.zalthrion.zylroth.render.entity.RenderBoar;
import com.zalthrion.zylroth.render.entity.RenderDeer;
import com.zalthrion.zylroth.render.entity.RenderFancyBadger;
import com.zalthrion.zylroth.render.entity.RenderRainbowPig;
import com.zalthrion.zylroth.render.entity.RenderSkeletalHorse;
import com.zalthrion.zylroth.render.entity.RenderStag;
import com.zalthrion.zylroth.render.entity.RenderTenebraeGuardian;
import com.zalthrion.zylroth.render.entity.RenderTenebraeProtector;
import com.zalthrion.zylroth.render.entity.RenderTuskarr;
import com.zalthrion.zylroth.render.entity.RenderUndeadMinion;
import com.zalthrion.zylroth.render.entity.RenderUndeadWarrior;
import com.zalthrion.zylroth.render.entity.RenderUnicorn;
import com.zalthrion.zylroth.render.entity.RenderVoidDragon;
import com.zalthrion.zylroth.render.entity.RenderVoidLordBoss;
import com.zalthrion.zylroth.render.entity.dev.RenderSixOneThree;
import com.zalthrion.zylroth.render.entity.dev.RenderZalthrion;
import com.zalthrion.zylroth.render.entity.mount.RenderDeathcharger;
import com.zalthrion.zylroth.render.entity.mount.RenderPlaguedHorse;
import com.zalthrion.zylroth.render.entity.mount.RenderSavageBadger;
import com.zalthrion.zylroth.render.entity.mount.RenderSwiftUnicorn;
import com.zalthrion.zylroth.render.entity.mount.RenderWarTortoise;
import com.zalthrion.zylroth.render.item.RenderRepulsorCannon;
import com.zalthrion.zylroth.render.item.RenderVoidiriteShield;
import com.zalthrion.zylroth.render.item.RenderWoodenCrossbow;
import com.zalthrion.zylroth.render.projectile.RenderRepulsorBolt;
import com.zalthrion.zylroth.render.projectile.RenderRepulsorCannonBolt;
import com.zalthrion.zylroth.render.tile.RenderTileEntityBenzenn;
import com.zalthrion.zylroth.render.tile.RenderTileEntityBenzennStatue;
import com.zalthrion.zylroth.render.tile.RenderTileEntityGoldBag;
import com.zalthrion.zylroth.render.tile.RenderTileEntityInfuser;
import com.zalthrion.zylroth.render.tile.RenderTileEntityLamp;
import com.zalthrion.zylroth.render.tile.item.RenderBenzenn;
import com.zalthrion.zylroth.render.tile.item.RenderBenzennStatue;
import com.zalthrion.zylroth.render.tile.item.RenderGoldBag;
import com.zalthrion.zylroth.render.tile.item.RenderLamp;
import com.zalthrion.zylroth.tile.TileEntityBenzenn;
import com.zalthrion.zylroth.tile.TileEntityBenzennStatue;
import com.zalthrion.zylroth.tile.TileEntityGoldBag;
import com.zalthrion.zylroth.tile.TileEntityInfuser;
import com.zalthrion.zylroth.tile.TileEntityLamp;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
	
	public static final Map<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();
	
	@Override
	public void preInit() {
		KeyHandler.init();
	}
	
	@Override
	public void init() {
		super.init();
		FMLCommonHandler.instance().bus().register(new KeyInputEvent());
		this.registerRenderers();
		this.registerBlocks();
	}
	
	@Override
	public void registerRenderInformation() {}
	
	@Override
	public void registerRenderers() {
		float shadowSize = 0.5F;
		
		/** Animals */
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBird.class, new RenderBird(new ModelBird(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityRainbowPig.class, new RenderRainbowPig(new ModelRainbowPig(), new ModelRainbowPig(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBadger.class, new RenderBadger(new ModelBadger(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityFancyBadger.class, new RenderFancyBadger(new ModelBadger(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBoar.class, new RenderBoar(new ModelBoar(), shadowSize));
		
		/** Mobs */
		
		RenderingRegistry.registerEntityRenderingHandler(EntityTenebraeGuardian.class, new RenderTenebraeGuardian(new ModelEmpoweredTenebraeGolem(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityVoidLordBoss.class, new RenderVoidLordBoss(new ModelUndead2(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityUndeadWarrior.class, new RenderUndeadWarrior(new ModelUndead(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityUndeadMinion.class, new RenderUndeadMinion(new ModelUndead(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityTenebraeProtector.class, new RenderTenebraeProtector(new ModelTenebraeGolem(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityVoidDragon.class, new RenderVoidDragon());
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySkeletalHorse.class, new RenderSkeletalHorse(new ModelSkeletalHorse(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityUnicorn.class, new RenderUnicorn(new ModelUnicorn(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityDeer.class, new RenderDeer(new ModelDeer(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityStag.class, new RenderStag(new ModelStag(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityTuskarr.class, new RenderTuskarr(new ModelTuskarr(), shadowSize));
		
		/** Mounts */
		
		RenderingRegistry.registerEntityRenderingHandler(MountDeathcharger.class, new RenderDeathcharger(new ModelDeathcharger(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(MountPlaguedHorse.class, new RenderPlaguedHorse(new ModelPlaguedHorse(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(MountWarTortoise.class, new RenderWarTortoise(new ModelWarTortoise(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(MountSavageBadger.class, new RenderSavageBadger(new ModelSavageBadger(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(MountSwiftUnicorn.class, new RenderSwiftUnicorn(new ModelSwiftUnicorn(), shadowSize));
		
		/** Developers */
		
		RenderingRegistry.registerEntityRenderingHandler(EntityZalthrion.class, new RenderZalthrion(new ModelBiped(), shadowSize));
		RenderingRegistry.registerEntityRenderingHandler(EntitySixOneThree.class, new RenderSixOneThree(new ModelSpecialBiped(), shadowSize));
		
		/** Projectiles */
		
		RenderingRegistry.registerEntityRenderingHandler(RepulsorBolt.class, new RenderRepulsorBolt(new ModelRepulsorBolt()));
		RenderingRegistry.registerEntityRenderingHandler(RepulsorCannonBolt.class, new RenderRepulsorCannonBolt(new ModelRepulsorBolt()));
		
		/** Void Lord Armor */
		
		ModelVoidLordArmor voidLordArmor = new ModelVoidLordArmor();
		
		armorModels.put(ModArmors.VoidLord_Helmet, voidLordArmor);
		armorModels.put(ModArmors.VoidLord_Chestplate, voidLordArmor);
		armorModels.put(ModArmors.VoidLord_Leggings, voidLordArmor);
		armorModels.put(ModArmors.VoidLord_Boots, voidLordArmor);
		
		
		/** Item Rendering */
		
		MinecraftForgeClient.registerItemRenderer(ModTools.woodenCrossbow, new RenderWoodenCrossbow());
		MinecraftForgeClient.registerItemRenderer(ModTools.repulsorCannon, new RenderRepulsorCannon());
		MinecraftForgeClient.registerItemRenderer(ModTools.voidiriteShield, new RenderVoidiriteShield());
		
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.benzenn), new RenderBenzenn());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.benzennStatue), new RenderBenzennStatue());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.goldBag), new RenderGoldBag());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.lamp), new RenderLamp());
	}
	
	@Override public void registerBlocks() {
		RenderIDs.setIDs();

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityInfuser.class, new RenderTileEntityInfuser());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGoldBag.class, new RenderTileEntityGoldBag());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBenzenn.class, new RenderTileEntityBenzenn());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBenzennStatue.class, new RenderTileEntityBenzennStatue());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLamp.class, new RenderTileEntityLamp());
		
		RenderingRegistry.registerBlockHandler(new BlockTESRRenderer(RenderIDs.blockInfuserRI));
//		RenderingRegistry.registerBlockHandler(new BlockTESRRenderer(RenderIDs.goldBag));
/*		RenderingRegistry.registerBlockHandler(new BlockTESRRenderer(RenderIDs.benzenn));
		RenderingRegistry.registerBlockHandler(new BlockTESRRenderer(RenderIDs.benzennStatue));*/
	}
}