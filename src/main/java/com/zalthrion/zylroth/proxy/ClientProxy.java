package com.zalthrion.zylroth.proxy;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.zalthrion.zylroth.entity.*;
import com.zalthrion.zylroth.entity.boss.*;
import com.zalthrion.zylroth.entity.dev.*;
import com.zalthrion.zylroth.entity.mount.*;
import com.zalthrion.zylroth.event.KeyInputEvent;
import com.zalthrion.zylroth.handler.KeyHandler;
import com.zalthrion.zylroth.lib.ModArmors;
import com.zalthrion.zylroth.lib.ModTools;
import com.zalthrion.zylroth.model.armor.ModelVoidLordArmor;
import com.zalthrion.zylroth.model.entity.*;
import com.zalthrion.zylroth.model.entity.mount.*;
import com.zalthrion.zylroth.reference.RenderIDs;
import com.zalthrion.zylroth.render.BlockTESRRenderer;
import com.zalthrion.zylroth.render.entity.*;
import com.zalthrion.zylroth.render.entity.dev.*;
import com.zalthrion.zylroth.render.entity.mount.*;
import com.zalthrion.zylroth.render.item.RenderWoodenCrossbow;
import com.zalthrion.zylroth.render.tile.RenderTileEntityGoldBag;
import com.zalthrion.zylroth.render.tile.RenderTileEntityInfuser;
import com.zalthrion.zylroth.tile.TileEntityGoldBag;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

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
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBird.class, new RenderBird(new ModelBird(), shadowSize, shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityRainbowPig.class, new RenderRainbowPig(new ModelRainbowPig(), new ModelRainbowPig(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBadger.class, new RenderBadger(new ModelBadger(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityFancyBadger.class, new RenderFancyBadger(new ModelBadger(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBoar.class, new RenderBoar(new ModelBoar(), shadowSize));
		
		/** Mobs */
		
		RenderingRegistry.registerEntityRenderingHandler(EntityTenebraeGuardian.class, new RenderTenebraeGuardian(new ModelEmpoweredTenebraeGolem(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityVoidLordBoss.class, new RenderVoidLordBoss(new ModelUndead(), shadowSize, shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityUndeadWarrior.class, new RenderUndeadWarrior(new ModelUndead(), shadowSize, shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityUndeadMinion.class, new RenderUndeadMinion(new ModelUndead(), shadowSize, shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityTenebraeProtector.class, new RenderTenebraeProtector(new ModelTenebraeGolem(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityVoidDragon.class, new RenderVoidDragon());
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySkeletalHorse.class, new RenderSkeletalHorse(new ModelSkeletalHorse(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityUnicorn.class, new RenderUnicorn(new ModelUnicorn(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityDeer.class, new RenderDeer(new ModelDeer(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityStag.class, new RenderStag(new ModelStag(), shadowSize));
		
		/** Mounts */
		
		RenderingRegistry.registerEntityRenderingHandler(MountDeathcharger.class, new RenderDeathcharger(new ModelDeathcharger(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(MountPlaguedHorse.class, new RenderPlaguedHorse(new ModelPlaguedHorse(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(MountWarTortoise.class, new RenderWarTortoise(new ModelWarTortoise(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(MountSavageBadger.class, new RenderSavageBadger(new ModelSavageBadger(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(MountSwiftUnicorn.class, new RenderSwiftUnicorn(new ModelSwiftUnicorn(), shadowSize));
		
		/** Developers */
		
		RenderingRegistry.registerEntityRenderingHandler(EntityZalthrion.class, new RenderZalthrion(new ModelBiped(), shadowSize));
		RenderingRegistry.registerEntityRenderingHandler(EntitySixOneThree.class, new RenderSixOneThree(new ModelBiped(), shadowSize));
		
		/** Void Lord Armor */
		
		ModelVoidLordArmor voidLordArmor = new ModelVoidLordArmor();
		
		armorModels.put(ModArmors.VoidLord_Helmet, voidLordArmor);
		armorModels.put(ModArmors.VoidLord_Chestplate, voidLordArmor);
		armorModels.put(ModArmors.VoidLord_Leggings, voidLordArmor);
		armorModels.put(ModArmors.VoidLord_Boots, voidLordArmor);
		
		
		/** Item Rendering */
		
		MinecraftForgeClient.registerItemRenderer(ModTools.woodenCrossbow, new RenderWoodenCrossbow());
	}
	
	@Override public void registerBlocks() {
		RenderIDs.setIDs();

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityInfuser.class, new RenderTileEntityInfuser());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGoldBag.class, new RenderTileEntityGoldBag());
		RenderingRegistry.registerBlockHandler(new BlockTESRRenderer(RenderIDs.blockInfuserRI));
	}
}