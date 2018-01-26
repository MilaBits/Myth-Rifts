package milly.mythrifts;

import milly.mythrifts.proxy.CommonProxy;
import milly.mythrifts.worldgen.MythRiftsWorldGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid=MythRifts.MODID, name = MythRifts.NAME, version = MythRifts.VERSION)
public class MythRifts {
    public static final String MODID = "mythrifts";
    public static final String NAME = "Myth Rifts";
    public static final String VERSION = "@VERSION@";
    public static final String SERVER_PROXY_CLASS ="milly.mythrifts.proxy.CommonProxy";
    public static final String CLIENT_PROXY_CLASS ="milly.mythrifts.proxy.ClientProxy";

    //TODO: creative tab, example: https://github.com/Choonster-Minecraft-Mods/TestMod3/blob/1.12/src/main/java/choonster/testmod3/TestMod3.java
    //public static final CreativeTabTestMod3 creativeTab = new CreativeTabTestMod3();

    @Mod.Instance(MODID)
    public static MythRifts instance;

    @SidedProxy(serverSide = SERVER_PROXY_CLASS, clientSide = CLIENT_PROXY_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){

    }

    @EventHandler
    public void init (FMLInitializationEvent event){

        //Add Worldgen
        GameRegistry.registerWorldGenerator(new MythRiftsWorldGenerator(), 5);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
}
