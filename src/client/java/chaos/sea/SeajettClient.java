package chaos.sea;

import chaos.sea.renderer.ModEntityRenderers;
import net.fabricmc.api.ClientModInitializer;

public class SeajettClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModEntityRenderers.registerModEntityRenderers();
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
	}
}