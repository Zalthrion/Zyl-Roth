package com.zalthrion.zylroth.utility;

import java.util.ArrayList;

import net.minecraft.client.resources.I18n;

import com.zalthrion.zylroth.reference.Reference;

public class TooltipHelper {
	public static ArrayList<String> add(String unlocalized) {
		ArrayList<String> ret = new ArrayList<String>();
		if (I18n.hasKey(unlocalized)) {
			String translated = I18n.format(unlocalized);
			if (translated.contains("\\n")) {
				String[] split = translated.split("\\\\n");
				for (int i = 0; i < split.length; i ++) {
					ret.add(split[i]);
				}
				return ret;
			} else {
				ret.add(I18n.format(unlocalized));
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