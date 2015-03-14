package com.zalthrion.zylroth.lib;

import net.minecraft.block.Block;

import com.zalthrion.zylroth.block.*;
import com.zalthrion.zylroth.block.machine.InfuserMachine;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

public final class ModBlocks {
	
	public static Block Tenebrae_Ore;
	
	public static Block Tenebrae_Block;
	
	public static Block Tenebrae_Core;
	
	public static Block Chiseled_Tenebrae;
	
	public static Block Infused_Tenebrae;
	
	
	public static Block Infuser;
	
	public static Block Infuser_Idle;
 
    public static void init(){
    	registerBlocks();
    }
    
    public static void registerBlocks(){
    	
        Tenebrae_Ore = new TenebraeOre();
        
        Tenebrae_Block = new TenebraeBlock();
        
        Tenebrae_Core = new TenebraeCore();
        
        Chiseled_Tenebrae = new ChiseledTenebrae();
        
        Infused_Tenebrae = new InfusedTenebrae();
        
        
        //Infuser
        
        Infuser = new InfuserMachine(true);
        Infuser_Idle = new InfuserMachine(false);
        
        Infuser.setBlockName(Reference.MOD_ID + "_" + "Infuser Machine Active");
        Infuser_Idle.setBlockName(Reference.MOD_ID + "_" + "Infuser Machine");
        
		GameRegistry.registerBlock(ModBlocks.Infuser, "Infuser Machine Active");
		GameRegistry.registerBlock(ModBlocks.Infuser_Idle, "Infuser Machine");
		
		Infuser.setLightLevel(0.9F);
		Infuser_Idle.setLightLevel(0.2F);
		
		Infuser.setBlockTextureName(Reference.MOD_ID + ":" + "Infuser Machine Active");
		Infuser_Idle.setBlockTextureName(Reference.MOD_ID + ":" + "Infuser Machine");
        
    }
}
