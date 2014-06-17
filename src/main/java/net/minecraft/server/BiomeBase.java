package net.minecraft.server;

import net.minecraft.util.com.google.common.collect.Sets;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public abstract class BiomeBase {
    public static final BiomeBase[] biomes = new BiomeBase['Ā'];
    public static final Set n = Sets.newHashSet();
    public static final BiomeBase PLAINS = new BiomePlains(1).b(9286496).a("Plains");
    public static final BiomeBase EXTREME_HILLS = new BiomeBigHills(3, false).b(6316128).a("Extreme Hills").a(i).a(0.2F, 0.3F);
    public static final BiomeBase FOREST = new BiomeForest(4, 0).b(353825).a("Forest");
    public static final BiomeBase SWAMPLAND = new BiomeSwamp(6).b(522674).a("Swampland").a(9154376).a(m).a(0.8F, 0.9F);
    public static final BiomeBase HELL = new BiomeHell(8).b(16711680).a("Hell").b().a(2.0F, 0.0F);
    public static final BiomeBase SKY = new BiomeTheEnd(9).b(8421631).a("Sky").b();
    public static final BiomeBase FROZEN_OCEAN = new BiomeOcean(10).b(9474208).a("FrozenOcean").c().a(c).a(0.0F, 0.5F);
    public static final BiomeBase FROZEN_RIVER = new BiomeRiver(11).b(10526975).a("FrozenRiver").c().a(b).a(0.0F, 0.5F);
    public static final BiomeBase ICE_MOUNTAINS = new BiomeIcePlains(13, false).b(10526880).a("Ice Mountains").c().a(g).a(0.0F, 0.5F);
    public static final BiomeBase SMALL_MOUNTAINS = new BiomeBigHills(20, true).b(7501978).a("Extreme Hills Edge").a(i.a()).a(0.2F, 0.3F);
    public static final BiomeBase JUNGLE = new BiomeJungle(21, false).b(5470985).a("Jungle").a(5470985).a(0.95F, 0.9F);
    public static final BiomeBase JUNGLE_EDGE = new BiomeJungle(23, true).b(6458135).a("JungleEdge").a(5470985).a(0.95F, 0.8F);
    public static final BiomeBase COLD_BEACH = new BiomeBeach(26).b(16445632).a("Cold Beach").a(0.05F, 0.3F).a(j).c();
    public static final BiomeBase BIRCH_FOREST = new BiomeForest(27, 2).a("Birch Forest").b(3175492);
    public static final BiomeBase ROOFED_FOREST = new BiomeForest(29, 3).b(4215066).a("Roofed Forest");
    public static final BiomeBase COLD_TAIGA = new BiomeTaiga(30, 0).b(3233098).a("Cold Taiga").a(5159473).c().a(-0.5F, 0.4F).a(f).c(16777215);
    public static final BiomeBase COLD_TAIGA_HILLS = new BiomeTaiga(31, 0).b(2375478).a("Cold Taiga Hills").a(5159473).c().a(-0.5F, 0.4F).a(g).c(16777215);
    public static final BiomeBase EXTREME_HILLS_PLUS = new BiomeBigHills(34, true).b(5271632).a("Extreme Hills+").a(i).a(0.2F, 0.3F);
    public static final BiomeBase MESA = new BiomeMesa(37, false, false).b(14238997).a("Mesa");
    protected static final BiomeTemperature a = new BiomeTemperature(0.1F, 0.2F);
    protected static final BiomeTemperature b = new BiomeTemperature(-0.5F, 0.0F);
    public static final BiomeBase RIVER = new BiomeRiver(7).b(255).a("River").a(b);
    protected static final BiomeTemperature c = new BiomeTemperature(-1.0F, 0.1F);
    public static final BiomeBase OCEAN = new BiomeOcean(0).b(112).a("Ocean").a(c);
    protected static final BiomeTemperature d = new BiomeTemperature(-1.8F, 0.1F);
    public static final BiomeBase DEEP_OCEAN = new BiomeOcean(24).b(48).a("Deep Ocean").a(d);
    protected static final BiomeTemperature e = new BiomeTemperature(0.125F, 0.05F);
    public static final BiomeBase DESERT = new BiomeDesert(2).b(16421912).a("Desert").b().a(2.0F, 0.0F).a(e);
    public static final BiomeBase ICE_PLAINS = new BiomeIcePlains(12, false).b(16777215).a("Ice Plains").c().a(0.0F, 0.5F).a(e);
    public static final BiomeBase SAVANNA = new BiomeSavanna(35).b(12431967).a("Savanna").a(1.2F, 0.0F).b().a(e);
    protected static final BiomeTemperature f = new BiomeTemperature(0.2F, 0.2F);
    public static final BiomeBase TAIGA = new BiomeTaiga(5, 0).b(747097).a("Taiga").a(5159473).a(0.25F, 0.8F).a(f);
    public static final BiomeBase MEGA_TAIGA = new BiomeTaiga(32, 1).b(5858897).a("Mega Taiga").a(5159473).a(0.3F, 0.8F).a(f);
    protected static final BiomeTemperature g = new BiomeTemperature(0.45F, 0.3F);
    public static final BiomeBase DESERT_HILLS = new BiomeDesert(17).b(13786898).a("DesertHills").b().a(2.0F, 0.0F).a(g);
    public static final BiomeBase FOREST_HILLS = new BiomeForest(18, 0).b(2250012).a("ForestHills").a(g);
    public static final BiomeBase TAIGA_HILLS = new BiomeTaiga(19, 0).b(1456435).a("TaigaHills").a(5159473).a(0.25F, 0.8F).a(g);
    public static final BiomeBase JUNGLE_HILLS = new BiomeJungle(22, false).b(2900485).a("JungleHills").a(5470985).a(0.95F, 0.9F).a(g);
    public static final BiomeBase BIRCH_FOREST_HILLS = new BiomeForest(28, 2).a("Birch Forest Hills").b(2055986).a(g);
    public static final BiomeBase MEGA_TAIGA_HILLS = new BiomeTaiga(33, 1).b(4542270).a("Mega Taiga Hills").a(5159473).a(0.3F, 0.8F).a(g);
    protected static final BiomeTemperature h = new BiomeTemperature(1.5F, 0.025F);
    public static final BiomeBase SAVANNA_PLATEAU = new BiomeSavanna(36).b(10984804).a("Savanna Plateau").a(1.0F, 0.0F).b().a(h);
    public static final BiomeBase MESA_PLATEAU_F = new BiomeMesa(38, false, true).b(11573093).a("Mesa Plateau F").a(h);
    public static final BiomeBase MESA_PLATEAU = new BiomeMesa(39, false, false).b(13274213).a("Mesa Plateau").a(h);

    static {
        PLAINS.k();
        DESERT.k();
        FOREST.k();
        TAIGA.k();
        SWAMPLAND.k();
        ICE_PLAINS.k();
        JUNGLE.k();
        JUNGLE_EDGE.k();
        COLD_TAIGA.k();
        SAVANNA.k();
        SAVANNA_PLATEAU.k();
        MESA.k();
        MESA_PLATEAU_F.k();
        MESA_PLATEAU.k();
        BIRCH_FOREST.k();
        BIRCH_FOREST_HILLS.k();
        ROOFED_FOREST.k();
        MEGA_TAIGA.k();
        EXTREME_HILLS.k();
        EXTREME_HILLS_PLUS.k();


        biomes[(MEGA_TAIGA_HILLS.id + 128)] = biomes[(MEGA_TAIGA.id + 128)];
        for (BiomeBase localBiomeBase : biomes) {
            if ((localBiomeBase != null) && (localBiomeBase.id < 128)) {
                n.add(localBiomeBase);
            }
        }
        n.remove(HELL);
        n.remove(SKY);
        n.remove(FROZEN_OCEAN);
        n.remove(SMALL_MOUNTAINS);
    }

    protected static final BiomeTemperature i = new BiomeTemperature(1.0F, 0.5F);
    protected static final BiomeTemperature j = new BiomeTemperature(0.0F, 0.025F);
    public static final BiomeBase MUSHROOM_SHORE = new BiomeMushrooms(15).b(10486015).a("MushroomIslandShore").a(0.9F, 1.0F).a(j);
    public static final BiomeBase BEACH = new BiomeBeach(16).b(16440917).a("Beach").a(0.8F, 0.4F).a(j);
    protected static final BiomeTemperature k = new BiomeTemperature(0.1F, 0.8F);
    public static final BiomeBase STONE_BEACH = new BiomeStoneBeach(25).b(10658436).a("Stone Beach").a(0.2F, 0.3F).a(k);
    protected static final BiomeTemperature l = new BiomeTemperature(0.2F, 0.3F);
    public static final BiomeBase MUSHROOM_ISLAND = new BiomeMushrooms(14).b(16711935).a("MushroomIsland").a(0.9F, 1.0F).a(l);
    protected static final BiomeTemperature m = new BiomeTemperature(-0.2F, 0.1F);
    protected static final NoiseGenerator3 ac = new NoiseGenerator3(new Random(1234L), 1);
    protected static final NoiseGenerator3 ad = new NoiseGenerator3(new Random(2345L), 1);
    protected static final WorldGenTallPlant ae = new WorldGenTallPlant();
    private static final Logger aC = MinecraftServer.getLogger();
    public final int id;
    public String af;
    public int ag;
    public int ah;
    public Block ai = Blocks.GRASS;
    public int aj = 0;
    public Block ak = Blocks.DIRT;
    public int al = 5169201;
    public float am = a.a;
    public float an = a.b;
    public float temperature = 0.5F;
    public float humidity = 0.5F;
    public int aq = 16777215;
    public BiomeDecorator ar;
    protected List as = new ArrayList();
    protected List at = new ArrayList();
    protected List au = new ArrayList();
    protected List av = new ArrayList();
    protected boolean aw;
    protected boolean ax = true;
    protected WorldGenTrees az = new WorldGenTrees(false);
    protected WorldGenBigTree aA = new WorldGenBigTree(false);
    protected WorldGenSwampTree aB = new WorldGenSwampTree();

    protected BiomeBase(int paramInt) {
        this.id = paramInt;
        biomes[paramInt] = this;
        this.ar = a();

        this.at.add(new BiomeMeta(EntitySheep.class, 12, 4, 4));
        this.at.add(new BiomeMeta(EntityPig.class, 10, 4, 4));
        this.at.add(new BiomeMeta(EntityChicken.class, 10, 4, 4));
        this.at.add(new BiomeMeta(EntityCow.class, 8, 4, 4));

        this.as.add(new BiomeMeta(EntitySpider.class, 100, 4, 4));
        this.as.add(new BiomeMeta(EntityZombie.class, 100, 4, 4));
        this.as.add(new BiomeMeta(EntitySkeleton.class, 100, 4, 4));
        this.as.add(new BiomeMeta(EntityCreeper.class, 100, 4, 4));
        this.as.add(new BiomeMeta(EntitySlime.class, 100, 4, 4));
        this.as.add(new BiomeMeta(EntityEnderman.class, 10, 1, 4));
        this.as.add(new BiomeMeta(EntityWitch.class, 5, 1, 1));


        this.au.add(new BiomeMeta(EntitySquid.class, 10, 4, 4));

        this.av.add(new BiomeMeta(EntityBat.class, 10, 8, 8));
    }

    public static BiomeBase[] n() {
        return biomes;
    }

    public static BiomeBase getBiome(int paramInt) {
        paramInt &= 0xFF;
        if ((paramInt < 0) || (paramInt > biomes.length) || biomes[paramInt] == null) {
            if (paramInt >= 128 && biomes[paramInt & 0x7F] != null)
                return biomes[paramInt & 0x7F];
            aC.warn("Biome ID is out of bounds: " + paramInt + ", defaulting to 0 (Ocean)");
            return OCEAN;
        }
        return biomes[paramInt];
    }

    protected BiomeDecorator a() {
        return new BiomeDecorator();
    }

    protected BiomeBase a(float paramFloat1, float paramFloat2) {
        if ((paramFloat1 > 0.1F) && (paramFloat1 < 0.2F)) {
            throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
        }
        this.temperature = paramFloat1;
        this.humidity = paramFloat2;
        return this;
    }

    protected final BiomeBase a(BiomeTemperature paramBiomeTemperature) {
        this.am = paramBiomeTemperature.a;
        this.an = paramBiomeTemperature.b;
        return this;
    }

    protected BiomeBase b() {
        this.ax = false;
        return this;
    }

    public WorldGenTreeAbstract a(Random paramRandom) {
        if (paramRandom.nextInt(10) == 0) {
            return this.aA;
        }
        return this.az;
    }

    public WorldGenerator b(Random paramRandom) {
        return new WorldGenGrass(Blocks.LONG_GRASS, 1);
    }

    public String a(Random paramRandom, int paramInt1, int paramInt2, int paramInt3) {
        if (paramRandom.nextInt(3) > 0) {
            return BlockFlowers.b[0];
        }
        return BlockFlowers.a[0];
    }

    protected BiomeBase c() {
        this.aw = true;
        return this;
    }

    protected BiomeBase a(String paramString) {
        this.af = paramString;
        return this;
    }

    protected BiomeBase a(int paramInt) {
        this.al = paramInt;
        return this;
    }

    protected BiomeBase b(int paramInt) {
        a(paramInt, false);
        return this;
    }

    protected BiomeBase c(int paramInt) {
        this.ah = paramInt;
        return this;
    }

    protected BiomeBase a(int paramInt, boolean paramBoolean) {
        this.ag = paramInt;
        if (paramBoolean) {
            this.ah = ((paramInt & 0xFEFEFE) >> 1);
        } else {
            this.ah = paramInt;
        }
        return this;
    }

    public List getMobs(EnumCreatureType paramEnumCreatureType) {
        if (paramEnumCreatureType == EnumCreatureType.MONSTER) {
            return this.as;
        }
        if (paramEnumCreatureType == EnumCreatureType.CREATURE) {
            return this.at;
        }
        if (paramEnumCreatureType == EnumCreatureType.WATER_CREATURE) {
            return this.au;
        }
        if (paramEnumCreatureType == EnumCreatureType.AMBIENT) {
            return this.av;
        }
        return null;
    }

    public boolean d() {
        return j();
    }

    public boolean e() {
        if (j()) {
            return false;
        }
        return this.ax;
    }

    public boolean f() {
        return this.humidity > 0.85F;
    }

    public float g() {
        return 0.1F;
    }

    public final int h() {
        return (int) (this.humidity * 65536.0F);
    }

    public final float a(int paramInt1, int paramInt2, int paramInt3) {
        if (paramInt2 > 64) {
            float f1 = (float) ac.a(paramInt1 * 1.0D / 8.0D, paramInt3 * 1.0D / 8.0D) * 4.0F;
            return this.temperature - (f1 + paramInt2 - 64.0F) * 0.05F / 30.0F;
        }
        return this.temperature;
    }

    public void a(World paramWorld, Random paramRandom, int paramInt1, int paramInt2) {
        this.ar.a(paramWorld, paramRandom, this, paramInt1, paramInt2);
    }

    public boolean j() {
        return this.aw;
    }

    public void a(World paramWorld, Random paramRandom, Block[] paramArrayOfBlock, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble) {
        b(paramWorld, paramRandom, paramArrayOfBlock, paramArrayOfByte, paramInt1, paramInt2, paramDouble);
    }

    public final void b(World paramWorld, Random paramRandom, Block[] paramArrayOfBlock, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble) {
        int i1 = 63;
        Block localBlock1 = this.ai;
        byte i2 = (byte) (this.aj & 0xFF);
        Block localBlock2 = this.ak;
        int i3 = -1;
        int i4 = (int) (paramDouble / 3.0D + 3.0D + paramRandom.nextDouble() * 0.25D);

        int i5 = paramInt1 & 0xF;
        int i6 = paramInt2 & 0xF;
        int i7 = paramArrayOfBlock.length / 256;
        for (int i8 = 255; i8 >= 0; i8--) {
            int i9 = (i6 * 16 + i5) * i7 + i8;
            if (i8 <= 0 + paramRandom.nextInt(5)) {
                paramArrayOfBlock[i9] = Blocks.BEDROCK;
            } else {
                Block localBlock3 = paramArrayOfBlock[i9];
                if ((localBlock3 == null) || (localBlock3.getMaterial() == Material.AIR)) {
                    i3 = -1;
                } else if (localBlock3 == Blocks.STONE) {
                    if (i3 == -1) {
                        if (i4 <= 0) {
                            localBlock1 = null;
                            i2 = 0;
                            localBlock2 = Blocks.STONE;
                        } else if ((i8 >= 59) && (i8 <= 64)) {
                            localBlock1 = this.ai;
                            i2 = (byte) (this.aj & 0xFF);
                            localBlock2 = this.ak;
                        }
                        if ((i8 < 63) && ((localBlock1 == null) || (localBlock1.getMaterial() == Material.AIR))) {
                            if (a(paramInt1, i8, paramInt2) < 0.15F) {
                                localBlock1 = Blocks.ICE;
                                i2 = 0;
                            } else {
                                localBlock1 = Blocks.STATIONARY_WATER;
                                i2 = 0;
                            }
                        }
                        i3 = i4;
                        if (i8 >= 62) {
                            paramArrayOfBlock[i9] = localBlock1;
                            paramArrayOfByte[i9] = i2;
                        } else if (i8 < 56 - i4) {
                            localBlock1 = null;
                            localBlock2 = Blocks.STONE;
                            paramArrayOfBlock[i9] = Blocks.GRAVEL;
                        } else {
                            paramArrayOfBlock[i9] = localBlock2;
                        }
                    } else if (i3 > 0) {
                        i3--;
                        paramArrayOfBlock[i9] = localBlock2;
                        if ((i3 == 0) && (localBlock2 == Blocks.SAND)) {
                            i3 = paramRandom.nextInt(4) + Math.max(0, i8 - 63);
                            localBlock2 = Blocks.SANDSTONE;
                        }
                    }
                }
            }
        }
    }

    protected BiomeBase k() {
        return new BiomeBaseSub(this.id + 128, this);
    }

    public Class l() {
        return getClass();
    }

    public boolean a(BiomeBase paramBiomeBase) {
        if (paramBiomeBase == this) {
            return true;
        }
        if (paramBiomeBase == null) {
            return false;
        }
        return l() == paramBiomeBase.l();
    }

    public EnumTemperature m() {
        if (this.temperature < 0.2D) {
            return EnumTemperature.COLD;
        }
        if (this.temperature < 1.0D) {
            return EnumTemperature.MEDIUM;
        }
        return EnumTemperature.WARM;
    }
}
