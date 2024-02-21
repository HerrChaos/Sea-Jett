package chaos.sea.entity;

import chaos.sea.Seajett;
import chaos.sea.entity.custom.SeaJettEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<SeaJettEntity> SEAJETT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Seajett.MOD_ID, "seajett"),
            FabricEntityTypeBuilder.<SeaJettEntity>create(SpawnGroup.MISC, SeaJettEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.25f)).build());
    public static void registerEntities(String modId) {
        FabricDefaultAttributeRegistry.register(SEAJETT, SeaJettEntity.createAntAttributes());
        Seajett.LOGGER.info("Registering Entities for " + modId);
    }
}
