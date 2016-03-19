package com.zalthrion.zylroth.world.dimension;

import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraftforge.event.terraingen.InitNoiseGensEvent.Context;

public class ContextZylroth extends Context {
	private NoiseGeneratorOctaves noiseGenOctave1;
	private NoiseGeneratorOctaves noiseGenOctave2;
	private NoiseGeneratorOctaves noiseGenOctave3;
	private NoiseGeneratorOctaves noiseGenOctave4;
	private NoiseGeneratorOctaves noiseGenOctave5;
	private NoiseGeneratorOctaves noiseGenOctave6;
	private NoiseGeneratorPerlin noiseGenPerlin1;
	
	public ContextZylroth(NoiseGeneratorOctaves _1, NoiseGeneratorOctaves _2, NoiseGeneratorOctaves _3, NoiseGeneratorPerlin _4, NoiseGeneratorOctaves _5, NoiseGeneratorOctaves _6, NoiseGeneratorOctaves _7) {
		super(_1, _2, _3, _7, _5);
		this.noiseGenOctave1 = _1;
		this.noiseGenOctave2 = _2;
		this.noiseGenOctave3 = _3;
		this.noiseGenOctave4 = _5;
		this.noiseGenOctave5 = _6;
		this.noiseGenOctave6 = _7;
		this.noiseGenPerlin1 = _4;
	}
	
	public NoiseGeneratorOctaves getNoiseGenOctave1() { return noiseGenOctave1; }
	public NoiseGeneratorOctaves getNoiseGenOctave2() { return noiseGenOctave2; }
	public NoiseGeneratorOctaves getNoiseGenOctave3() { return noiseGenOctave3; }
	public NoiseGeneratorOctaves getNoiseGenOctave4() { return noiseGenOctave4; }
	public NoiseGeneratorOctaves getNoiseGenOctave5() { return noiseGenOctave5; }
	public NoiseGeneratorOctaves getNoiseGenOctave6() { return noiseGenOctave6; }
	public NoiseGeneratorPerlin getNoiseGenPerlin1() { return noiseGenPerlin1; }
}