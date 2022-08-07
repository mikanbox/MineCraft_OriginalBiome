package net.fabricmc.example;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class InitSurfaceRulesObject {
    private static final MaterialRules.MaterialRule SAND = makeStateRule(Blocks.SAND);

    public static MaterialRules.MaterialRule build() {
        MaterialRules.MaterialRule biomeSurface = MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.biome(InitBiomeObject.BrokenCityKey), SAND)
        );

        return MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, biomeSurface),
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, biomeSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
