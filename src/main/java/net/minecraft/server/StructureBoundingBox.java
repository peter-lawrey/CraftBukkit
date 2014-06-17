package net.minecraft.server;

public class StructureBoundingBox {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;

    public StructureBoundingBox() {
    }

    public StructureBoundingBox(int[] paramArrayOfInt) {
        if (paramArrayOfInt.length == 6) {
            this.a = paramArrayOfInt[0];
            this.b = paramArrayOfInt[1];
            this.c = paramArrayOfInt[2];
            this.d = paramArrayOfInt[3];
            this.e = paramArrayOfInt[4];
            this.f = paramArrayOfInt[5];
        }
    }

    public StructureBoundingBox(StructureBoundingBox paramStructureBoundingBox) {
        this.a = paramStructureBoundingBox.a;
        this.b = paramStructureBoundingBox.b;
        this.c = paramStructureBoundingBox.c;
        this.d = paramStructureBoundingBox.d;
        this.e = paramStructureBoundingBox.e;
        this.f = paramStructureBoundingBox.f;
    }

    public StructureBoundingBox(int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
        this.a = minX;
        this.b = minY;
        this.c = minZ;
        this.d = maxX;
        this.e = maxY;
        this.f = maxZ;
    }

    public StructureBoundingBox(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.a = paramInt1;
        this.c = paramInt2;
        this.d = paramInt3;
        this.f = paramInt4;


        this.b = 1;
        this.e = 512;
    }

    public static StructureBoundingBox a() {
        return new StructureBoundingBox(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public static StructureBoundingBox a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10) {
        switch (paramInt10) {
            default:
                return new StructureBoundingBox(paramInt1 + paramInt4, paramInt2 + paramInt5, paramInt3 + paramInt6, paramInt1 + paramInt7 - 1 + paramInt4, paramInt2 + paramInt8 - 1 + paramInt5, paramInt3 + paramInt9 - 1 + paramInt6);
            case 2:
                return new StructureBoundingBox(paramInt1 + paramInt4, paramInt2 + paramInt5, paramInt3 - paramInt9 + 1 + paramInt6, paramInt1 + paramInt7 - 1 + paramInt4, paramInt2 + paramInt8 - 1 + paramInt5, paramInt3 + paramInt6);
            case 0:
                return new StructureBoundingBox(paramInt1 + paramInt4, paramInt2 + paramInt5, paramInt3 + paramInt6, paramInt1 + paramInt7 - 1 + paramInt4, paramInt2 + paramInt8 - 1 + paramInt5, paramInt3 + paramInt9 - 1 + paramInt6);
            case 1:
                return new StructureBoundingBox(paramInt1 - paramInt9 + 1 + paramInt6, paramInt2 + paramInt5, paramInt3 + paramInt4, paramInt1 + paramInt6, paramInt2 + paramInt8 - 1 + paramInt5, paramInt3 + paramInt7 - 1 + paramInt4);
        }
//        return new StructureBoundingBox(paramInt1 + paramInt6, paramInt2 + paramInt5, paramInt3 + paramInt4, paramInt1 + paramInt9 - 1 + paramInt6, paramInt2 + paramInt8 - 1 + paramInt5, paramInt3 + paramInt7 - 1 + paramInt4);
    }

    public boolean a(StructureBoundingBox paramStructureBoundingBox) {
        return (this.d >= paramStructureBoundingBox.a) && (this.a <= paramStructureBoundingBox.d) && (this.f >= paramStructureBoundingBox.c) && (this.c <= paramStructureBoundingBox.f) && (this.e >= paramStructureBoundingBox.b) && (this.b <= paramStructureBoundingBox.e);
    }

    public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        return (this.d >= paramInt1) && (this.a <= paramInt3) && (this.f >= paramInt2) && (this.c <= paramInt4);
    }

    public void b(StructureBoundingBox paramStructureBoundingBox) {
        this.a = Math.min(this.a, paramStructureBoundingBox.a);
        this.b = Math.min(this.b, paramStructureBoundingBox.b);
        this.c = Math.min(this.c, paramStructureBoundingBox.c);
        this.d = Math.max(this.d, paramStructureBoundingBox.d);
        this.e = Math.max(this.e, paramStructureBoundingBox.e);
        this.f = Math.max(this.f, paramStructureBoundingBox.f);
    }

    public void a(int paramInt1, int paramInt2, int paramInt3) {
        this.a += paramInt1;
        this.b += paramInt2;
        this.c += paramInt3;
        this.d += paramInt1;
        this.e += paramInt2;
        this.f += paramInt3;
    }

    public boolean b(int x, int y, int z) {
        return (x >= this.a) && (x <= this.d) && (z >= this.c) && (z <= this.f) && (y >= this.b) && (y <= this.e);
    }

    public int b() {
        return this.d - this.a + 1;
    }

    public int c() {
        return this.e - this.b + 1;
    }

    public int d() {
        return this.f - this.c + 1;
    }

    public int e() {
        return this.a + (this.d - this.a + 1) / 2;
    }

    public int f() {
        return this.b + (this.e - this.b + 1) / 2;
    }

    public int g() {
        return this.c + (this.f - this.c + 1) / 2;
    }

    public String toString() {
        return "(" + this.a + ", " + this.b + ", " + this.c + "; " + this.d + ", " + this.e + ", " + this.f + ")";
    }

    public NBTTagIntArray h() {
        return new NBTTagIntArray(new int[]{this.a, this.b, this.c, this.d, this.e, this.f});
    }
}
