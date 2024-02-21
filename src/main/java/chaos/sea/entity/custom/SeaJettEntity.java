package chaos.sea.entity.custom;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.Tameable;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;

import java.util.UUID;

public class SeaJettEntity extends MobEntity implements Tameable {
    private UUID ownerUuid;
    public float BodyYaw = 0;
    public SeaJettEntity(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }
    public static DefaultAttributeContainer.Builder createAntAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5);
    }
    @Override
    public UUID getOwnerUuid() {
        return this.ownerUuid;
    }

    @Override
    public EntityView method_48926() {
        return null;
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        if (this.getOwnerUuid() != null) {
            nbt.putUuid("owneruuid", this.getOwnerUuid());
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("owneruuid")) {
            this.ownerUuid = nbt.getUuid("owneruuid");
        }
    }
    protected void putPlayerOnBack(PlayerEntity player) {
        if (!this.getWorld().isClient) {
            player.setYaw(this.getYaw());
            player.setPitch(this.getPitch());
            player.startRiding(this);
        }

    }
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (!this.hasPassengers() && !this.isBaby()) {
            this.putPlayerOnBack(player);
            return ActionResult.success(this.getWorld().isClient);
        } else {
            return super.interactMob(player, hand);
        }
    }

    @Override
    public void tick() {
        BodyYaw += 1;
        super.tick();
    }
}
