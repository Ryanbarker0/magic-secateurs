package com.magicsecateurs;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class MagicSecateursPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(MagicSecateursPlugin.class);
		RuneLite.main(args);
	}
}