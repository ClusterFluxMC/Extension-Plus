package com.github.olivermakescode.extension.plus;

import net.fabricmc.api.ModInitializer;

public class ExtensionPlus implements ModInitializer {
	public static final String modid = "extp";

	@Override
	public void onInitialize() {
		ExtGamerules.register();
		ExtBlocks.register();
		ExtItems.register();
	}
}
