package chaos.sea.renderer;

import chaos.sea.entity.ModEntities;
import chaos.sea.models.AntEntityModel;
import chaos.sea.renderer.custom.AntRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class ModEntityRenderers {

    public static void registerModEntityRenderers() {
        EntityRendererRegistry.register(ModEntities.SEAJETT, AntRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(AntRenderer.MODEL_ANT_LAYER, AntEntityModel::getTexturedModelData);
    }
}
