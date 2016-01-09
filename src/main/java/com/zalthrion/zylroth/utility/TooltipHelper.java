package com.zalthrion.zylroth.utility;

import java.util.ArrayList;

import net.minecraft.util.StatCollector;

import com.zalthrion.zylroth.reference.Reference;

public class TooltipHelper {
	public static ArrayList<String> add(String unlocalized) {
		ArrayList<String> ret = new ArrayList<String>();
		if (StatCollector.canTranslate(unlocalized)) {
			String translated = StatCollector.translateToLocal(unlocalized);
			if (translated.contains("\\n")) {
				String[] split = translated.split("\\\\n");
				for (int i = 0; i < split.length; i ++) {
					ret.add(split[i]);
				}
				return ret;
			} else {
				ret.add(StatCollector.translateToLocal(unlocalized));
				return ret;
			}
		}
		ret.add(unlocalized);
		return ret;
	}
	
	public static ArrayList<String> addAll(String unlocalized) {
		return add("tooltip." + Reference.RESOURCE_PREFIX + unlocalized);
	}
}