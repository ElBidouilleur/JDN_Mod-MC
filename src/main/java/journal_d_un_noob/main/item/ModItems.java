package journal_d_un_noob.main.item;

import journal_d_un_noob.main.JDN_ModMC;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item CUSTOM_STICK;

    public static void registerModItems() {
        CUSTOM_STICK = registerItem("custom_stick", new Item(new Item.Settings()));
        JDN_ModMC.LOGGER.info("Enregistrement d'items pour " + JDN_ModMC.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(CUSTOM_STICK);
        });
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(JDN_ModMC.MOD_ID, name), item);
    }
}
