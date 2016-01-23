package com.zalthrion.zylroth.proxy;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.zalthrion.zylroth.entity.*;
import com.zalthrion.zylroth.entity.boss.EntityTenebraeGuardian;
import com.zalthrion.zylroth.entity.boss.EntityVoidLordBoss;
import com.zalthrion.zylroth.entity.mount.MountDeathcharger;
import com.zalthrion.zylroth.entity.mount.MountPlaguedHorse;
import com.zalthrion.zylroth.entity.mount.MountSavageBadger;
import com.zalthrion.zylroth.entity.mount.MountSwiftUnicorn;
import com.zalthrion.zylroth.entity.mount.MountWarTortoise;
import com.zalthrion.zylroth.event.KeyInputEvent;
import com.zalthrion.zylroth.lib.ModArmors;
import com.zalthrion.zylroth.lib.ModTools;
import com.zalthrion.zylroth.model.armor.ModelVoidLordArmor;
import com.zalthrion.zylroth.model.entity.ModelBadger;
import com.zalthrion.zylroth.model.entity.ModelBird;
import com.zalthrion.zylroth.model.entity.ModelEmpoweredTenebraeGolem;
import com.zalthrion.zylroth.model.entity.ModelRainbowPig;
import com.zalthrion.zylroth.model.entity.ModelSkeletalHorse;
import com.zalthrion.zylroth.model.entity.ModelTenebraeGolem;
import com.zalthrion.zylroth.model.entity.ModelUndead;
import com.zalthrion.zylroth.model.entity.ModelUnicorn;
import com.zalthrion.zylroth.model.entity.mount.ModelDeathcharger;
import com.zalthrion.zylroth.model.entity.mount.ModelPlaguedHorse;
import com.zalthrion.zylroth.model.entity.mount.ModelSavageBadger;
import com.zalthrion.zylroth.model.entity.mount.ModelSwiftUnicorn;
import com.zalthrion.zylroth.model.entity.mount.ModelWarTortoise;
import com.zalthrion.zylroth.reference.RenderIDs;
import com.zalthrion.zylroth.render.BlockTESRRenderer;
import com.zalthrion.zylroth.render.entity.*;
import com.zalthrion.zylroth.render.entity.mount.RenderDeathcharger;
import com.zalthrion.zylroth.render.entity.mount.RenderPlaguedHorse;
import com.zalthrion.zylroth.render.entity.mount.RenderSavageBadger;
import com.zalthrion.zylroth.render.entity.mount.RenderSwiftUnicorn;
import com.zalthrion.zylroth.render.entity.mount.RenderWarTortoise;
import com.zalthrion.zylroth.render.item.RenderWoodenCrossbow;
import com.zalthrion.zylroth.render.tile.RenderTileEntityInfuser;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy {
	
	public static final Map<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();
	
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
		
		/** Mobs */
		
		RenderingRegistry.registerEntityRenderingHandler(EntityTenebraeGuardian.class, new RenderTenebraeGuardian(new ModelEmpoweredTenebraeGolem(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityVoidLordBoss.class, new RenderVoidLordBoss(new ModelUndead(), shadowSize, shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityUndeadWarrior.class, new RenderUndeadWarrior(new ModelUndead(), shadowSize, shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityUndeadMinion.class, new RenderUndeadMinion(new ModelUndead(), shadowSize, shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityTenebraeProtector.class, new RenderTenebraeProtector(new ModelTenebraeGolem(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityVoidDragon.class, new RenderVoidDragon());
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySkeletalHorse.class, new RenderSkeletalHorse(new ModelSkeletalHorse(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityUnicorn.class, new RenderUnicorn(new ModelUnicorn(), shadowSize));
		
		/** Mounts */
		
		RenderingRegistry.registerEntityRenderingHandler(MountDeathcharger.class, new RenderDeathcharger(new ModelDeathcharger(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(MountPlaguedHorse.class, new RenderPlaguedHorse(new ModelPlaguedHorse(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(MountWarTortoise.class, new RenderWarTortoise(new ModelWarTortoise(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(MountSavageBadger.class, new RenderSavageBadger(new ModelSavageBadger(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(MountSwiftUnicorn.class, new RenderSwiftUnicorn(new ModelSwiftUnicorn(), shadowSize));
		
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
		RenderingRegistry.registerBlockHandler(new BlockTESRRenderer(RenderIDs.blockInfuserRI));
	}
}