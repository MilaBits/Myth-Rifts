package milly.mythrifts.common.init;

import com.google.common.base.Preconditions;
import milly.mythrifts.MythRifts;
import milly.mythrifts.common.item.ItemTestItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.HashSet;
import java.util.Set;

@GameRegistry.ObjectHolder(MythRifts.MODID)
public class ModItems {

    public static final ItemTestItem TestItem = new ItemTestItem();

    @Mod.EventBusSubscriber(modid = MythRifts.MODID)
    public static class RegistrationHandler {
        public static final Set<Item> ITEMS = new HashSet<>();

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {

            final Item[] items = {
                    TestItem
            };

            final IForgeRegistry<Item> registry = event.getRegistry();
            for (Item item : items) {
                final ResourceLocation registryName = Preconditions.checkNotNull(item.getRegistryName(), "Block %s has null registry name", item);
                registry.register(item);

                //TODO: Move this to a ModelRegistryEvent handler
                ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(registryName, "inventory"));

                ITEMS.add(item);
            }
        }
    }
}