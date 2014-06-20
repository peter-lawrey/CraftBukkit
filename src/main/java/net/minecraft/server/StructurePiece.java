package net.minecraft.server;

import java.util.List;
import java.util.Random;

public abstract class StructurePiece {
    protected StructureBoundingBox f; // box
    protected int g; // orientation.
    protected int h;

    public StructurePiece() {
    }

    protected StructurePiece(int paramInt) {
        this.h = paramInt;
        this.g = -1;
    }

    public static StructurePiece a(List<StructurePiece> paramList, StructureBoundingBox paramStructureBoundingBox) {
        for (StructurePiece localStructurePiece : paramList) {
            if ((localStructurePiece.c() != null) && (localStructurePiece.c().a(paramStructureBoundingBox))) {
                return localStructurePiece;
            }
        }
        return null;
    }

    public NBTTagCompound b() {
        NBTTagCompound localNBTTagCompound = new NBTTagCompound();

        localNBTTagCompound.setString("id", WorldGenFactory.a(this));
        localNBTTagCompound.set("BB", this.f.h());
        localNBTTagCompound.setInt("O", this.g);
        localNBTTagCompound.setInt("GD", this.h);

        a(localNBTTagCompound);

        return localNBTTagCompound;
    }

    protected abstract void a(NBTTagCompound paramNBTTagCompound);

    public void a(World world, NBTTagCompound compound) {
        if (compound.hasKey("BB")) {
            this.f = new StructureBoundingBox(compound.getIntArray("BB"));
        }
        this.g = compound.getInt("O");
        this.h = compound.getInt("GD");

        b(compound);
    }

    protected abstract void b(NBTTagCompound paramNBTTagCompound);

    public void a(StructurePiece paramStructurePiece, List paramList, Random paramRandom) {
    }

    public abstract boolean a(World paramWorld, Random paramRandom, StructureBoundingBox paramStructureBoundingBox);

    public StructureBoundingBox c() {
        return this.f;
    }

    public int d() {
        return this.h;
    }

    public ChunkPosition a() {
        return new ChunkPosition(this.f.e(), this.f.f(), this.f.g());
    }

    protected boolean a(World paramWorld, StructureBoundingBox box) {
        int i = Math.max(this.f.a - 1, box.a);
        int j = Math.max(this.f.b - 1, box.b);
        int k = Math.max(this.f.c - 1, box.c);
        int m = Math.min(this.f.d + 1, box.d);
        int n = Math.min(this.f.e + 1, box.e);
        int i1 = Math.min(this.f.f + 1, box.f);
        int i3;
        for (int i2 = i; i2 <= m; i2++) {
            for (i3 = k; i3 <= i1; i3++) {
                if (paramWorld.getType(i2, j, i3).getMaterial().isLiquid()) {
                    return true;
                }
                if (paramWorld.getType(i2, n, i3).getMaterial().isLiquid()) {
                    return true;
                }
            }
        }
        for (int i2 = i; i2 <= m; i2++) {
            for (i3 = j; i3 <= n; i3++) {
                if (paramWorld.getType(i2, i3, k).getMaterial().isLiquid()) {
                    return true;
                }
                if (paramWorld.getType(i2, i3, i1).getMaterial().isLiquid()) {
                    return true;
                }
            }
        }
        for (int i2 = k; i2 <= i1; i2++) {
            for (i3 = j; i3 <= n; i3++) {
                if (paramWorld.getType(i, i3, i2).getMaterial().isLiquid()) {
                    return true;
                }
                if (paramWorld.getType(m, i3, i2).getMaterial().isLiquid()) {
                    return true;
                }
            }
        }
        return false;
    }

    protected int a(int paramInt1, int paramInt2) {
        switch (this.g) {
            case 0:
            case 2:
                return this.f.a + paramInt1;
            case 1:
                return this.f.d - paramInt2;
            case 3:
                return this.f.a + paramInt2;
        }
        return paramInt1;
    }

    protected int a(int paramInt) {
        if (this.g == -1) {
            return paramInt;
        }
        return paramInt + this.f.b;
    }

    protected int b(int paramInt1, int paramInt2) {
        switch (this.g) {
            case 2:
                return this.f.f - paramInt2;
            case 0:
                return this.f.c + paramInt2;
            case 1:
            case 3:
                return this.f.c + paramInt1;
        }
        return paramInt2;
    }

    protected int a(Block block, int x) {
        if (block == Blocks.RAILS) {
            if ((this.g == 1) || (this.g == 3)) {
                if (x == 1) {
                    return 0;
                }
                return 1;
            }
        } else if ((block == Blocks.WOODEN_DOOR) || (block == Blocks.IRON_DOOR_BLOCK)) {
            if (this.g == 0) {
                if (x == 0) {
                    return 2;
                }
                if (x == 2) {
                    return 0;
                }
            } else {
                if (this.g == 1) {
                    return x + 1 & 0x3;
                }
                if (this.g == 3) {
                    return x + 3 & 0x3;
                }
            }
        } else if ((block == Blocks.COBBLESTONE_STAIRS) || (block == Blocks.WOOD_STAIRS)
                || (block == Blocks.NETHER_BRICK_STAIRS) || (block == Blocks.STONE_STAIRS)
                || (block == Blocks.SANDSTONE_STAIRS)) {
            if (this.g == 0) {
                if (x == 2) {
                    return 3;
                }
                if (x == 3) {
                    return 2;
                }
            } else if (this.g == 1) {
                if (x == 0) {
                    return 2;
                }
                if (x == 1) {
                    return 3;
                }
                if (x == 2) {
                    return 0;
                }
                if (x == 3) {
                    return 1;
                }
            } else if (this.g == 3) {
                if (x == 0) {
                    return 2;
                }
                if (x == 1) {
                    return 3;
                }
                if (x == 2) {
                    return 1;
                }
                if (x == 3) {
                    return 0;
                }
            }
        } else if (block == Blocks.LADDER) {
            if (this.g == 0) {
                if (x == 2) {
                    return 3;
                }
                if (x == 3) {
                    return 2;
                }
            } else if (this.g == 1) {
                if (x == 2) {
                    return 4;
                }
                if (x == 3) {
                    return 5;
                }
                if (x == 4) {
                    return 2;
                }
                if (x == 5) {
                    return 3;
                }
            } else if (this.g == 3) {
                if (x == 2) {
                    return 5;
                }
                if (x == 3) {
                    return 4;
                }
                if (x == 4) {
                    return 2;
                }
                if (x == 5) {
                    return 3;
                }
            }
        } else if (block == Blocks.STONE_BUTTON) {
            if (this.g == 0) {
                if (x == 3) {
                    return 4;
                }
                if (x == 4) {
                    return 3;
                }
            } else if (this.g == 1) {
                if (x == 3) {
                    return 1;
                }
                if (x == 4) {
                    return 2;
                }
                if (x == 2) {
                    return 3;
                }
                if (x == 1) {
                    return 4;
                }
            } else if (this.g == 3) {
                if (x == 3) {
                    return 2;
                }
                if (x == 4) {
                    return 1;
                }
                if (x == 2) {
                    return 3;
                }
                if (x == 1) {
                    return 4;
                }
            }
        } else if ((block == Blocks.TRIPWIRE_SOURCE) || ((block instanceof BlockDirectional))) {
            if (this.g == 0) {
                if ((x == 0) || (x == 2)) {
                    return Direction.f[x];
                }
            } else if (this.g == 1) {
                if (x == 2) {
                    return 1;
                }
                if (x == 0) {
                    return 3;
                }
                if (x == 1) {
                    return 2;
                }
                if (x == 3) {
                    return 0;
                }
            } else if (this.g == 3) {
                if (x == 2) {
                    return 3;
                }
                if (x == 0) {
                    return 1;
                }
                if (x == 1) {
                    return 2;
                }
                if (x == 3) {
                    return 0;
                }
            }
        } else if ((block == Blocks.PISTON) || (block == Blocks.PISTON_STICKY) || (block == Blocks.LEVER) || (block == Blocks.DISPENSER)) {
            if (this.g == 0) {
                if ((x == 2) || (x == 3)) {
                    return Facing.OPPOSITE_FACING[x];
                }
            } else if (this.g == 1) {
                if (x == 2) {
                    return 4;
                }
                if (x == 3) {
                    return 5;
                }
                if (x == 4) {
                    return 2;
                }
                if (x == 5) {
                    return 3;
                }
            } else if (this.g == 3) {
                if (x == 2) {
                    return 5;
                }
                if (x == 3) {
                    return 4;
                }
                if (x == 4) {
                    return 2;
                }
                if (x == 5) {
                    return 3;
                }
            }
        }
        return x;
    }

    protected void a(World world, Block paramBlock, int o, int paramInt2, int paramInt3, int paramInt4, StructureBoundingBox box) {
        int x = a(paramInt2, paramInt4);
        int y = a(paramInt3);
        int z = b(paramInt2, paramInt4);
        if (!box.b(x, y, z)) {
            return;
        }
        world.setTypeAndData(x, y, z, paramBlock, o, 2);
    }

    protected Block a(World paramWorld, int paramInt1, int paramInt2, int paramInt3, StructureBoundingBox paramStructureBoundingBox) {
        int i = a(paramInt1, paramInt3);
        int j = a(paramInt2);
        int k = b(paramInt1, paramInt3);
        if (!paramStructureBoundingBox.b(i, j, k)) {
            return Blocks.AIR;
        }
        return paramWorld.getType(i, j, k);
    }

    protected void a(World paramWorld, StructureBoundingBox paramStructureBoundingBox, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
        for (int i = paramInt2; i <= paramInt5; i++) {
            for (int j = paramInt1; j <= paramInt4; j++) {
                for (int k = paramInt3; k <= paramInt6; k++) {
                    a(paramWorld, Blocks.AIR, 0, j, i, k, paramStructureBoundingBox);
                }
            }
        }
    }

    protected void a(World paramWorld, StructureBoundingBox paramStructureBoundingBox, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Block paramBlock1, Block paramBlock2, boolean paramBoolean) {
        for (int i = paramInt2; i <= paramInt5; i++) {
            for (int j = paramInt1; j <= paramInt4; j++) {
                for (int k = paramInt3; k <= paramInt6; k++) {
                    if ((!paramBoolean) || (a(paramWorld, j, i, k, paramStructureBoundingBox).getMaterial() != Material.AIR)) {
                        if ((i == paramInt2) || (i == paramInt5) || (j == paramInt1) || (j == paramInt4) || (k == paramInt3) || (k == paramInt6)) {
                            a(paramWorld, paramBlock1, 0, j, i, k, paramStructureBoundingBox);
                        } else {
                            a(paramWorld, paramBlock2, 0, j, i, k, paramStructureBoundingBox);
                        }
                    }
                }
            }
        }
    }

    protected void a(World world, StructureBoundingBox box, int x1, int y1, int z1, int x2, int y2, int z2, Block rim, int p1, Block inner, int p2, boolean flag) {
        for (int y = y1; y <= y2; y++) {
            for (int x = x1; x <= x2; x++) {
                for (int z = z1; z <= z2; z++) {
                    if ((!flag) || (a(world, x, y, z, box).getMaterial() != Material.AIR)) {
                        if ((y == y1) || (y == y2) || (x == x1) || (x == x2) || (z == z1) || (z == z2)) {
                            a(world, rim, p1, x, y, z, box);
                        } else {
                            a(world, inner, p2, x, y, z, box);
                        }
                    }
                }
            }
        }
    }

    protected void a(World paramWorld, StructureBoundingBox paramStructureBoundingBox, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, Random paramRandom, StructurePieceBlockSelector paramStructurePieceBlockSelector) {
        for (int i = paramInt2; i <= paramInt5; i++) {
            for (int j = paramInt1; j <= paramInt4; j++) {
                for (int k = paramInt3; k <= paramInt6; k++) {
                    if ((!paramBoolean) || (a(paramWorld, j, i, k, paramStructureBoundingBox).getMaterial() != Material.AIR)) {
                        paramStructurePieceBlockSelector.a(paramRandom, j, i, k, (i == paramInt2) || (i == paramInt5) || (j == paramInt1) || (j == paramInt4) || (k == paramInt3) || (k == paramInt6));
                        a(paramWorld, paramStructurePieceBlockSelector.a(), paramStructurePieceBlockSelector.b(), j, i, k, paramStructureBoundingBox);
                    }
                }
            }
        }
    }

    protected void a(World paramWorld, StructureBoundingBox paramStructureBoundingBox, Random paramRandom, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Block paramBlock1, Block paramBlock2, boolean paramBoolean) {
        for (int i = paramInt2; i <= paramInt5; i++) {
            for (int j = paramInt1; j <= paramInt4; j++) {
                for (int k = paramInt3; k <= paramInt6; k++) {
                    if (paramRandom.nextFloat() <= paramFloat) {
                        if ((!paramBoolean) || (a(paramWorld, j, i, k, paramStructureBoundingBox).getMaterial() != Material.AIR)) {
                            if ((i == paramInt2) || (i == paramInt5) || (j == paramInt1) || (j == paramInt4) || (k == paramInt3) || (k == paramInt6)) {
                                a(paramWorld, paramBlock1, 0, j, i, k, paramStructureBoundingBox);
                            } else {
                                a(paramWorld, paramBlock2, 0, j, i, k, paramStructureBoundingBox);
                            }
                        }
                    }
                }
            }
        }
    }

    protected void a(World paramWorld, StructureBoundingBox paramStructureBoundingBox, Random paramRandom, float paramFloat, int paramInt1, int paramInt2, int paramInt3, Block paramBlock, int paramInt4) {
        if (paramRandom.nextFloat() < paramFloat) {
            a(paramWorld, paramBlock, paramInt4, paramInt1, paramInt2, paramInt3, paramStructureBoundingBox);
        }
    }

    protected void a(World paramWorld, StructureBoundingBox paramStructureBoundingBox, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Block paramBlock, boolean paramBoolean) {
        float f1 = paramInt4 - paramInt1 + 1;
        float f2 = paramInt5 - paramInt2 + 1;
        float f3 = paramInt6 - paramInt3 + 1;
        float f4 = paramInt1 + f1 / 2.0F;
        float f5 = paramInt3 + f3 / 2.0F;
        for (int i = paramInt2; i <= paramInt5; i++) {
            float f6 = (i - paramInt2) / f2;
            for (int j = paramInt1; j <= paramInt4; j++) {
                float f7 = (j - f4) / (f1 * 0.5F);
                for (int k = paramInt3; k <= paramInt6; k++) {
                    float f8 = (k - f5) / (f3 * 0.5F);
                    if ((!paramBoolean) || (a(paramWorld, j, i, k, paramStructureBoundingBox).getMaterial() != Material.AIR)) {
                        float f9 = f7 * f7 + f6 * f6 + f8 * f8;
                        if (f9 <= 1.05F) {
                            a(paramWorld, paramBlock, 0, j, i, k, paramStructureBoundingBox);
                        }
                    }
                }
            }
        }
    }

    protected void b(World paramWorld, int paramInt1, int paramInt2, int paramInt3, StructureBoundingBox paramStructureBoundingBox) {
        int i = a(paramInt1, paramInt3);
        int j = a(paramInt2);
        int k = b(paramInt1, paramInt3);
        if (!paramStructureBoundingBox.b(i, j, k)) {
            return;
        }
        while ((!paramWorld.isEmpty(i, j, k)) && (j < 255)) {
            paramWorld.setTypeAndData(i, j, k, Blocks.AIR, 0, 2);
            j++;
        }
    }

    protected void b(World paramWorld, Block paramBlock, int paramInt1, int paramInt2, int paramInt3, int paramInt4, StructureBoundingBox paramStructureBoundingBox) {
        int i = a(paramInt2, paramInt4);
        int j = a(paramInt3);
        int k = b(paramInt2, paramInt4);
        if (!paramStructureBoundingBox.b(i, j, k)) {
            return;
        }
        while (((paramWorld.isEmpty(i, j, k)) || (paramWorld.getType(i, j, k).getMaterial().isLiquid())) && (j > 1)) {
            paramWorld.setTypeAndData(i, j, k, paramBlock, paramInt1, 2);
            j--;
        }
    }

    protected boolean a(World paramWorld, StructureBoundingBox box, Random rand, int x1, int y1, int z1, StructurePieceTreasure[] pieces, int paramInt4) {
        int x = a(x1, z1);
        int y = a(y1);
        int z = b(x1, z1);
        if ((box.b(x, y, z)) &&
                (paramWorld.getType(x, y, z) != Blocks.CHEST)) {
            paramWorld.setTypeAndData(x, y, z, Blocks.CHEST, 0, 2);
            TileEntityChest localTileEntityChest = (TileEntityChest) paramWorld.getTileEntity(x, y, z);
            if (localTileEntityChest != null) {
                StructurePieceTreasure.a(rand, pieces, localTileEntityChest, paramInt4);
            }
            return true;
        }
        return false;
    }

    protected boolean a(World paramWorld, StructureBoundingBox paramStructureBoundingBox, Random paramRandom, int paramInt1, int paramInt2, int paramInt3, int paramInt4, StructurePieceTreasure[] paramArrayOfStructurePieceTreasure, int paramInt5) {
        int i = a(paramInt1, paramInt3);
        int j = a(paramInt2);
        int k = b(paramInt1, paramInt3);
        if ((paramStructureBoundingBox.b(i, j, k)) &&
                (paramWorld.getType(i, j, k) != Blocks.DISPENSER)) {
            paramWorld.setTypeAndData(i, j, k, Blocks.DISPENSER, a(Blocks.DISPENSER, paramInt4), 2);
            TileEntityDispenser localTileEntityDispenser = (TileEntityDispenser) paramWorld.getTileEntity(i, j, k);
            if (localTileEntityDispenser != null) {
                StructurePieceTreasure.a(paramRandom, paramArrayOfStructurePieceTreasure, localTileEntityDispenser, paramInt5);
            }
            return true;
        }
        return false;
    }

    protected void a(World paramWorld, StructureBoundingBox paramStructureBoundingBox, Random paramRandom, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int i = a(paramInt1, paramInt3);
        int j = a(paramInt2);
        int k = b(paramInt1, paramInt3);
        if (paramStructureBoundingBox.b(i, j, k)) {
            ItemDoor.place(paramWorld, i, j, k, paramInt4, Blocks.WOODEN_DOOR);
        }
    }
}
