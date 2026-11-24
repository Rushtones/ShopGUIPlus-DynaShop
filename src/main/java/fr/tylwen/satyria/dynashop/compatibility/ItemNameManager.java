/*
 * ShopGUI+ DynaShop - Dynamic Economy Addon for Minecraft
 * Copyright (C) 2025 Tylwen
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
// Modified 2026-11-24: use the public Bukkit API instead of NMS version detection.
package fr.tylwen.satyria.dynashop.compatibility;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public final class ItemNameManager {
    private static final ItemNameProvider PROVIDER = new ItemNameProviderFallback();

    private ItemNameManager() {}

    public static String getLocalizedName(ItemStack item, Player player) {
        if (item == null) return "Item inconnu";
        return PROVIDER.getLocalizedName(item, player);
    }
}
