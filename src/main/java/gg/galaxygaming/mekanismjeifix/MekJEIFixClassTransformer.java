package gg.galaxygaming.mekanismjeifix;

import net.minecraft.launchwrapper.IClassTransformer;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class MekJEIFixClassTransformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (name.equals("mekanism.client.jei.gas.GasStackRenderer")) {
            try (ZipFile zip = new ZipFile(MekanismJEIFix.location)) {
                //Find it in the zip
                ZipEntry entry = zip.getEntry(name.replace('.', '/') + ".class");
                if (entry != null) {
                    byte[] bytes = new byte[(int) entry.getSize()];
                    //serialize the class file into the bytes array
                    InputStream zin = zip.getInputStream(entry);
                    zin.read(bytes);
                    zin.close();
                    return bytes;
                }
            } catch (IOException e) {
                throw new RuntimeException("Error overriding " + name, e);
            }
        }
        return basicClass;
    }
}