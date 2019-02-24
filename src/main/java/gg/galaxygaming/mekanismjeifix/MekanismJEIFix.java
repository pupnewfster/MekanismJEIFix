package gg.galaxygaming.mekanismjeifix;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import javax.annotation.Nullable;
import java.io.File;
import java.util.Map;

@IFMLLoadingPlugin.MCVersion(value = "1.12.2")
@Mod(clientSideOnly = true, modid = Constants.MOD_ID, name = Constants.MOD_NAME, version = Constants.VERSION,
        dependencies = Constants.DEPENDENCIES, acceptedMinecraftVersions = Constants.MC_VERSION)
public class MekanismJEIFix implements IFMLLoadingPlugin {
    static File location;

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{MekJEIFixClassTransformer.class.getName()};
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
        location = (File) data.get("coremodLocation");
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}