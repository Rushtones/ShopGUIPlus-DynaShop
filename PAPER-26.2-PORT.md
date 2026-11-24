# Paper 26.2 compatibility port (experimental)

This fork retains the original AGPL-3.0 license and attribution to Tylwen. Modified source is available in this repository. Version 1.8.1-alpha.1 is not approved for production.

## Build
Java 25 and Maven: `mvn -B -ntp clean verify`.
The branch targets Paper API 26.2.build.120-stable and NBT-API 2.16.0. ShopGUI+ API 3.0.0 is intentionally retained until compile/runtime compatibility is verified against the installed ShopGUI+ release. Vault and NBTAPI are required at runtime. PlaceholderAPI and DiscordSRV remain optional.

Item names use the existing Bukkit fallback rather than legacy NMS reflection; vanilla names may appear as English material names instead of localized names.

## Test gates before deployment
- CI must compile/package successfully; inspect compile warnings and shaded JAR contents.
- Start an isolated Paper 26.2 server with Java 25, compatible ShopGUI+, Vault, an economy provider and NBTAPI 2.16.0. Record exact builds and startup logs.
- Back up shop YAML, economy balances and plugin data. Use a separate test economy; do not connect production database credentials. Keep web dashboard, Discord integration and inflation disabled initially.
- Test one dynamic shop item and one static item; verify correct prices and balance changes for buy, sell, bulk buy/sell, canceled transactions and insufficient funds.
- Check rounding, min/max boundaries, buy/sell spread, reversible crafting (ingots/blocks), permission discounts, concurrent sales, restart persistence, custom item matching and no duplication or unintended balance creation.
- Repeat via Geyser/Bedrock; test reload and restart with persisted price/stock data.
- No production merge or release until these gates pass.
