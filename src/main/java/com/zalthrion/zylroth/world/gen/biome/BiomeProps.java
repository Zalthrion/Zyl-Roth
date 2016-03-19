package com.zalthrion.zylroth.world.gen.biome;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeProps extends BiomeGenBase.BiomeProperties {
	
	public static final HeightProps HEIGHT_MID_PLAINS = new HeightProps(0.2F, 0.2F);
	public static final HeightProps HEIGHT_OCEAN = new HeightProps(-1.0F, 0.1F);
	public static final HeightProps HEIGHT_LOW_PLAINS = new HeightProps(0.125F, 0.05F);
	public static final HeightProps HEIGHT_DEFAULT = new HeightProps(0.1F, 0.2F);
	public static final HeightProps HEIGHT_LOW_ISLANDS = new HeightProps(0.2F, 0.3F);
	public static final HeightProps HEIGHT_HIGH_PLATEAUS = new HeightProps(1.5F, 0.025F);
	
	public static class PropsBuilder {
		private final String biomeName;
		
		/** The colour of this biome as seen in guis **/
		private int guiColour = 0xffffff;
		private float baseHeight = 0.1F;
		private float heightVariation = 0.2F;
		private float temperature = 0.5F;
		private float rainfall = 0.5F;
		private int waterColor = 16777215;
		private boolean enableSnow = false;
		private boolean enableRain = true;
		private String baseBiomeRegName;
		
		public PropsBuilder(String name) {
			this.biomeName = name;
		}
		
		public PropsBuilder withGuiColour(Integer colour) {
			if (colour != null) this.guiColour = colour;
			return this;
		}
		
		public PropsBuilder withTemperature(Float temperature) {
			if (temperature != null) this.temperature = temperature;
			return this;
		}
		
		public PropsBuilder withRainfall(Float rainfall) {
			if (rainfall != null) this.rainfall = rainfall;
			return this;
		}
		
		public PropsBuilder withBaseHeight(Float baseHeight) {
			if (baseHeight != null) this.baseHeight = baseHeight;
			return this;
		}
		
		public PropsBuilder withHeightVariation(Float heightVariation) {
			if (heightVariation != null) this.heightVariation = heightVariation;
			return this;
		}
		
		public PropsBuilder withHeight(HeightProps heightProps) {
			if (heightProps != null) {
				this.baseHeight = heightProps.getBaseHeight();
				this.heightVariation = heightProps.getHeightVariation();
			}
			return this;
		}
		
		public PropsBuilder withRainDisabled() {
			this.enableRain = false;
			return this;
		}
		
		public PropsBuilder withSnowEnabled() {
			this.enableSnow = true;
			return this;
		}
		
		public PropsBuilder withWaterColor(Integer waterColor) {
			if (waterColor != null) this.waterColor = waterColor;
			return this;
		}
		
		public PropsBuilder withBaseBiome(String name) {
			if (name != null) this.baseBiomeRegName = name;
			return this;
		}
		
		public BiomeProps build() {
			return new BiomeProps(this.biomeName, this.temperature, this.rainfall, this.baseHeight, this.heightVariation, this.enableRain, this.enableSnow, this.waterColor, this.baseBiomeRegName, this.guiColour);
		}
	}
	
	public static class HeightProps {
		private float baseHeight;
		private float heightVariation;
		
		public HeightProps(float height, float variation) {
			this.baseHeight = height;
			this.heightVariation = variation;
		}
		
		public float getBaseHeight() { return this.baseHeight; }
		public float getHeightVariation() { return this.heightVariation; }
	}
	
	private BiomeProps(String name, float temperature, float rainfall, float baseHeight, float heightVariation, boolean enableRain, boolean enableSnow, int waterColor, String baseBiomeRegName, int guiColour) {
		super(name);
		
		this.setTemperature(temperature);
		this.setRainfall(rainfall);
		this.setBaseHeight(baseHeight);
		this.setHeightVariation(heightVariation);
		if (!enableRain) this.setRainDisabled();
		if (enableSnow) this.setSnowEnabled();
		this.setWaterColor(waterColor);
		this.setBaseBiome(baseBiomeRegName);
	}
}