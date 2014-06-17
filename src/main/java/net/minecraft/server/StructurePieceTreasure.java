package net.minecraft.server;

import java.util.Random;

public class StructurePieceTreasure
        extends WeightedRandomChoice {
    private ItemStack item;
    private int min;
    private int max;

    public StructurePieceTreasure(Item paramItem, int min, int max, int paramInt3, int weight) {
        super(weight);
        this.item = new ItemStack(paramItem, 1, min);
        this.min = max;
        this.max = paramInt3;
    }

    public StructurePieceTreasure(ItemStack paramItemStack, int min, int max, int weight) {
        super(weight);
        this.item = paramItemStack;
        this.min = min;
        this.max = max;
    }

    public static void a(Random paramRandom, StructurePieceTreasure[] paramArrayOfStructurePieceTreasure, IInventory paramIInventory, int paramInt) {
        for (int i = 0; i < paramInt; i++) {
            StructurePieceTreasure localStructurePieceTreasure = (StructurePieceTreasure) WeightedRandom.a(paramRandom, paramArrayOfStructurePieceTreasure);
            int j = localStructurePieceTreasure.min + paramRandom.nextInt(localStructurePieceTreasure.max - localStructurePieceTreasure.min + 1);
            if (localStructurePieceTreasure.item.getMaxStackSize() >= j) {
                ItemStack localItemStack1 = localStructurePieceTreasure.item.cloneItemStack();
                localItemStack1.count = j;
                paramIInventory.setItem(paramRandom.nextInt(paramIInventory.getSize()), localItemStack1);
            } else {
                for (int k = 0; k < j; k++) {
                    ItemStack localItemStack2 = localStructurePieceTreasure.item.cloneItemStack();
                    localItemStack2.count = 1;
                    paramIInventory.setItem(paramRandom.nextInt(paramIInventory.getSize()), localItemStack2);
                }
            }
        }
    }

    public static void a(Random paramRandom, StructurePieceTreasure[] paramArrayOfStructurePieceTreasure, TileEntityDispenser paramTileEntityDispenser, int paramInt) {
        for (int i = 0; i < paramInt; i++) {
            StructurePieceTreasure localStructurePieceTreasure = (StructurePieceTreasure) WeightedRandom.a(paramRandom, paramArrayOfStructurePieceTreasure);
            int j = localStructurePieceTreasure.min + paramRandom.nextInt(localStructurePieceTreasure.max - localStructurePieceTreasure.min + 1);
            if (localStructurePieceTreasure.item.getMaxStackSize() >= j) {
                ItemStack localItemStack1 = localStructurePieceTreasure.item.cloneItemStack();
                localItemStack1.count = j;
                paramTileEntityDispenser.setItem(paramRandom.nextInt(paramTileEntityDispenser.getSize()), localItemStack1);
            } else {
                for (int k = 0; k < j; k++) {
                    ItemStack localItemStack2 = localStructurePieceTreasure.item.cloneItemStack();
                    localItemStack2.count = 1;
                    paramTileEntityDispenser.setItem(paramRandom.nextInt(paramTileEntityDispenser.getSize()), localItemStack2);
                }
            }
        }
    }

    public static StructurePieceTreasure[] a(StructurePieceTreasure[] paramArrayOfStructurePieceTreasure1, StructurePieceTreasure... paramVarArgs) {
        StructurePieceTreasure[] arrayOfStructurePieceTreasure1 = new StructurePieceTreasure[paramArrayOfStructurePieceTreasure1.length + paramVarArgs.length];
        int i = 0;
        for (int j = 0; j < paramArrayOfStructurePieceTreasure1.length; j++) {
            arrayOfStructurePieceTreasure1[(i++)] = paramArrayOfStructurePieceTreasure1[j];
        }
        for (StructurePieceTreasure localStructurePieceTreasure : paramVarArgs) {
            arrayOfStructurePieceTreasure1[(i++)] = localStructurePieceTreasure;
        }
        return arrayOfStructurePieceTreasure1;
    }
}
