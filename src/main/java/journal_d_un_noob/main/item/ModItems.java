package journal_d_un_noob.main.item;

import journal_d_un_noob.main.JDN_ModMC;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static Item CUSTOM_STICK;


    public static void initialize() {
        registerModItems();

        // ajout des items dans leur catégories en créatif
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(CUSTOM_STICK);
        });
    }

    public static void registerModItems() {
        // ajout des items

        CUSTOM_STICK = registerItem("custom_stick", Item::new, new Item.Settings());
        JDN_ModMC.LOGGER.info("Enregistrement d'items pour " + JDN_ModMC.MOD_ID);
    }


    public static Item registerItem(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JDN_ModMC.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

}