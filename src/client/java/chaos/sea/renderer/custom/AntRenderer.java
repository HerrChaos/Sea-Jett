package chaos.sea.renderer.custom;

import chaos.sea.Seajett;
import chaos.sea.entity.custom.SeaJettEntity;
import chaos.sea.models.AntEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class AntRenderer extends MobEntityRenderer<SeaJettEntity, AntEntityModel<SeaJettEntity>> {
    public static final EntityModelLayer MODEL_ANT_LAYER = new EntityModelLayer(new Identifier(Seajett.MOD_ID, "ant"), "main");
    private AntEntityModel<SeaJettEntity> Model;
    public AntRenderer(EntityRendererFactory.Context context) {
        super(context, new AntEntityModel<>(context.getPart(MODEL_ANT_LAYER)), 0.3f);
        Model = new AntEntityModel<>(context.getPart(MODEL_ANT_LAYER));
    }

    @Override
    public Identifier getTexture(SeaJettEntity entity) {
        Identifier originalTexture = new Identifier("ant", "textures/entity/ant/worker_ant.png");
        return originalTexture;
    }
    @Override
    public void render(SeaJettEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g ,matrixStack, vertexConsumerProvider, i);
    }
}

