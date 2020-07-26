package org.elasticsearch.index.analysis;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class IkAnalyzerProviderXL extends AbstractIndexAnalyzerProvider<IKAnalyzer> {
    private final IKAnalyzer analyzer;

    public IkAnalyzerProviderXL(IndexSettings indexSettings, Environment env, String name, Settings settings, boolean useSmart) {
        super(indexSettings, name, settings);

        Configuration configuration = new Configuration(env, settings)
                .setUseSmart(useSmart).setUseDict(1).setLexemeBitBoot(true);
        analyzer = new IKAnalyzer(configuration);
    }

    public IkAnalyzerProviderXL(IndexSettings indexSettings, Environment env, String name, Settings settings, boolean useSmart, int useDict) {
        super(indexSettings, name, settings);

        Configuration configuration = new Configuration(env, settings)
                .setUseSmart(useSmart).setUseDict(useDict).setLexemeBitBoot(true);
        analyzer = new IKAnalyzer(configuration);
    }

    public static IkAnalyzerProviderXL getIkSmartAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, true);
    }

    public static IkAnalyzerProviderXL getIkAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, false);
    }

    public static IkAnalyzerProviderXL getIkSmartAnalyzerProvider_all(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, true, 1048575);
    }

    public static IkAnalyzerProviderXL getIkAnalyzerProvider_all(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, false, 1048575);
    }

    public static IkAnalyzerProviderXL getIkSmartAnalyzerProvider_norm(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, true, 524286);
    }

    public static IkAnalyzerProviderXL getIkAnalyzerProvider_norm(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, false, 524286);
    }

    public static IkAnalyzerProviderXL getIkSmartAnalyzerProvider_524287(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, true, 524287);
    }

    public static IkAnalyzerProviderXL getIkAnalyzerProvider_524287(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, false, 524287);
    }


    public static IkAnalyzerProviderXL getIkSmartAnalyzerProvider_2(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, true, 2);
    }

    public static IkAnalyzerProviderXL getIkAnalyzerProvider_2(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, false, 2);
    }

    public static IkAnalyzerProviderXL getIkSmartAnalyzerProvider_4(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, true, 4);
    }

    public static IkAnalyzerProviderXL getIkAnalyzerProvider_4(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, false, 4);
    }

    public static IkAnalyzerProviderXL getIkSmartAnalyzerProvider_8(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, true, 8);
    }

    public static IkAnalyzerProviderXL getIkAnalyzerProvider_8(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, false, 8);
    }

    public static IkAnalyzerProviderXL getIkSmartAnalyzerProvider_16(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, true, 16);
    }

    public static IkAnalyzerProviderXL getIkAnalyzerProvider_16(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, false, 16);
    }

    public static IkAnalyzerProviderXL getIkSmartAnalyzerProvider_32(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, true, 32);
    }

    public static IkAnalyzerProviderXL getIkAnalyzerProvider_32(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, false, 32);
    }

    public static IkAnalyzerProviderXL getIkSmartAnalyzerProvider_64(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, true, 64);
    }

    public static IkAnalyzerProviderXL getIkAnalyzerProvider_64(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, false, 64);
    }

    public static IkAnalyzerProviderXL getIkSmartAnalyzerProvider_128(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, true, 128);
    }

    public static IkAnalyzerProviderXL getIkAnalyzerProvider_128(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, false, 128);
    }

    public static IkAnalyzerProviderXL getIkSmartAnalyzerProvider_256(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, true, 256);
    }

    public static IkAnalyzerProviderXL getIkAnalyzerProvider_256(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, false, 256);
    }

    public static IkAnalyzerProviderXL getIkSmartAnalyzerProvider_512(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, true, 512);
    }

    public static IkAnalyzerProviderXL getIkAnalyzerProvider_512(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, false, 512);
    }

    public static IkAnalyzerProviderXL getIkSmartAnalyzerProvider_1024(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, true, 1024);
    }

    public static IkAnalyzerProviderXL getIkAnalyzerProvider_1024(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, false, 1024);
    }

    public static IkAnalyzerProviderXL getIkSmartAnalyzerProvider_2048(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, true, 2048);
    }

    public static IkAnalyzerProviderXL getIkAnalyzerProvider_2048(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, false, 2048);
    }

    public static IkAnalyzerProviderXL getIkSmartAnalyzerProvider_4096(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, true, 4096);
    }

    public static IkAnalyzerProviderXL getIkAnalyzerProvider_4096(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, false, 4096);
    }

    public static IkAnalyzerProviderXL getIkSmartAnalyzerProvider_8192(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, true, 8192);
    }

    public static IkAnalyzerProviderXL getIkAnalyzerProvider_8192(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, false, 8192);
    }

    public static IkAnalyzerProviderXL getIkSmartAnalyzerProvider_16384(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, true, 16384);
    }

    public static IkAnalyzerProviderXL getIkAnalyzerProvider_16384(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, false, 16384);
    }

    public static IkAnalyzerProviderXL getIkSmartAnalyzerProvider_32768(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, true, 32768);
    }

    public static IkAnalyzerProviderXL getIkAnalyzerProvider_32768(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, false, 32768);
    }

    public static IkAnalyzerProviderXL getIkSmartAnalyzerProvider_65536(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, true, 65536);
    }

    public static IkAnalyzerProviderXL getIkAnalyzerProvider_65536(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, false, 65536);
    }

    public static IkAnalyzerProviderXL getIkSmartAnalyzerProvider_131072(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, true, 131072);
    }

    public static IkAnalyzerProviderXL getIkAnalyzerProvider_131072(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, false, 131072);
    }

    public static IkAnalyzerProviderXL getIkSmartAnalyzerProvider_262144(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, true, 262144);
    }

    public static IkAnalyzerProviderXL getIkAnalyzerProvider_262144(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, false, 262144);
    }


    public static IkAnalyzerProviderXL getIkSmartAnalyzerProvider_524288(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, true, 524288);
    }

    public static IkAnalyzerProviderXL getIkAnalyzerProvider_524288(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkAnalyzerProviderXL(indexSettings, env, name, settings, false, 524288);
    }

    @Override
    public IKAnalyzer get() {
        return this.analyzer;
    }
}
