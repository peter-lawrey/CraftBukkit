package net.minecraft.server;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public abstract class StructureStart {
    protected LinkedList<StructurePiece> a = new LinkedList();
    protected StructureBoundingBox b;
    private int c;
    private int d;

    public StructureStart() {
    }

    public StructureStart(int paramInt1, int paramInt2) {
        this.c = paramInt1;
        this.d = paramInt2;
    }

    public StructureBoundingBox a() {
        return this.b;
    }

    public LinkedList b() {
        return this.a;
    }

    public void a(World paramWorld, Random paramRandom, StructureBoundingBox paramStructureBoundingBox) {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
            StructurePiece localStructurePiece = (StructurePiece) localIterator.next();
            if ((localStructurePiece.c().a(paramStructureBoundingBox)) &&
                    (!localStructurePiece.a(paramWorld, paramRandom, paramStructureBoundingBox))) {
                localIterator.remove();
            }
        }
    }

    protected void c() {
        this.b = StructureBoundingBox.a();
        for (StructurePiece localStructurePiece : this.a) {
            this.b.b(localStructurePiece.c());
        }
    }

    public NBTTagCompound a(int paramInt1, int paramInt2) {
        NBTTagCompound localNBTTagCompound = new NBTTagCompound();

        localNBTTagCompound.setString("id", WorldGenFactory.a(this));
        localNBTTagCompound.setInt("ChunkX", paramInt1);
        localNBTTagCompound.setInt("ChunkZ", paramInt2);
        localNBTTagCompound.set("BB", this.b.h());

        NBTTagList localNBTTagList = new NBTTagList();
        for (StructurePiece localStructurePiece : this.a) {
            localNBTTagList.add(localStructurePiece.b());
        }
        localNBTTagCompound.set("Children", localNBTTagList);

        a(localNBTTagCompound);

        return localNBTTagCompound;
    }

    public void a(NBTTagCompound paramNBTTagCompound) {
    }

    public void a(World paramWorld, NBTTagCompound paramNBTTagCompound) {
        this.c = paramNBTTagCompound.getInt("ChunkX");
        this.d = paramNBTTagCompound.getInt("ChunkZ");
        if (paramNBTTagCompound.hasKey("BB")) {
            this.b = new StructureBoundingBox(paramNBTTagCompound.getIntArray("BB"));
        }
        NBTTagList localNBTTagList = paramNBTTagCompound.getList("Children", 10);
        for (int i = 0; i < localNBTTagList.size(); i++) {
            this.a.add(WorldGenFactory.b(localNBTTagList.get(i), paramWorld));
        }
        b(paramNBTTagCompound);
    }

    public void b(NBTTagCompound paramNBTTagCompound) {
    }

    protected void a(World paramWorld, Random paramRandom, int paramInt) {
        int i = 63 - paramInt;


        int j = this.b.c() + 1;
        if (j < i) {
            j += paramRandom.nextInt(i - j);
        }
        int k = j - this.b.e;
        this.b.a(0, k, 0);
        for (StructurePiece localStructurePiece : this.a) {
            localStructurePiece.c().a(0, k, 0);
        }
    }

    protected void a(World paramWorld, Random paramRandom, int paramInt1, int paramInt2) {
        int i = paramInt2 - paramInt1 + 1 - this.b.c();
        int j = 1;
        if (i > 1) {
            j = paramInt1 + paramRandom.nextInt(i);
        } else {
            j = paramInt1;
        }
        int k = j - this.b.b;
        this.b.a(0, k, 0);
        for (StructurePiece localStructurePiece : this.a) {
            localStructurePiece.c().a(0, k, 0);
        }
    }

    public boolean d() {
        return true;
    }

    public int e() {
        return this.c;
    }

    public int f() {
        return this.d;
    }
}
