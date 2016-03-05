package com.zalthrion.zylroth.reference;

import com.zalthrion.zylroth.gui.GuiSummon;
import com.zalthrion.zylroth.packet.SummonMessage;

/**
 * This class is for referencing IDs related to mounts/pets for use in packets/GUIs.<br>
 * Whenever an ID is added include it in:<br>
 * {@link SummonMessage.Handler}<br>
 * {@link GuiSummon}
 */
public class MountIDs {
	public static final int deathcharger = 0;
	public static final int plaguedHorse = 1;
	public static final int savageBadger = 2;
	public static final int swiftUnicorn = 3;
	public static final int warTortoise = 4;
}