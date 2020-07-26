package org.elasticsearch.index.analysis;

import org.apache.lucene.analysis.Tokenizer;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.lucene.IKTokenizer;

public class IkTokenizerFactoryXL extends AbstractTokenizerFactory {
    private Configuration configuration;

    public IkTokenizerFactoryXL(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, name, settings);
//	  configuration=new Configuration(env,settings);
        configuration = new Configuration(env, settings)
                .setUseSmart(false).setUseDict(1).setLexemeBitBoot(true);
    }

    public IkTokenizerFactoryXL(IndexSettings indexSettings, Environment env, String name, Settings settings, int useDict) {
        super(indexSettings, name, settings);
//	  configuration=new Configuration(env,settings);
        configuration = new Configuration(env, settings)
                .setUseSmart(false).setUseDict(useDict).setLexemeBitBoot(true);
    }

    public static IkTokenizerFactoryXL getIkTokenizerFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings).setSmart(false, true, true);
    }

    public static IkTokenizerFactoryXL getIkSmartTokenizerFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings).setSmart(true, true, true);
    }

    public static IkTokenizerFactoryXL getIkTokenizerFactory_all(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 1048575).setSmart(false, true, true);
    }

    public static IkTokenizerFactoryXL getIkSmartTokenizerFactory_all(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 1048575).setSmart(true, true, true);
    }

    public static IkTokenizerFactoryXL getIkTokenizerFactory_norm(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 524286).setSmart(false, true, true);
    }

    public static IkTokenizerFactoryXL getIkSmartTokenizerFactory_norm(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 524286).setSmart(true, true, true);
    }

    public static IkTokenizerFactoryXL getIkTokenizerFactory_524287(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 524287).setSmart(false, true, true);
    }

    public static IkTokenizerFactoryXL getIkSmartTokenizerFactory_524287(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 524287).setSmart(true, true, true);
    }

    public static IkTokenizerFactoryXL getIkTokenizerFactory_2(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 2).setSmart(false, true, true);
    }

    public static IkTokenizerFactoryXL getIkSmartTokenizerFactory_2(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 2).setSmart(true, true, true);
    }

    public static IkTokenizerFactoryXL getIkTokenizerFactory_4(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 4).setSmart(false, true, true);
    }

    public static IkTokenizerFactoryXL getIkSmartTokenizerFactory_4(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 4).setSmart(true, true, true);
    }

    public static IkTokenizerFactoryXL getIkTokenizerFactory_8(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 8).setSmart(false, true, true);
    }

    public static IkTokenizerFactoryXL getIkSmartTokenizerFactory_8(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 8).setSmart(true, true, true);
    }

    public static IkTokenizerFactoryXL getIkTokenizerFactory_16(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 16).setSmart(false, true, true);
    }

    public static IkTokenizerFactoryXL getIkSmartTokenizerFactory_16(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 16).setSmart(true, true, true);
    }

    public static IkTokenizerFactoryXL getIkTokenizerFactory_32(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 32).setSmart(false, true, true);
    }

    public static IkTokenizerFactoryXL getIkSmartTokenizerFactory_32(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 32).setSmart(true, true, true);
    }

    public static IkTokenizerFactoryXL getIkTokenizerFactory_64(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 64).setSmart(false, true, true);
    }

    public static IkTokenizerFactoryXL getIkSmartTokenizerFactory_64(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 64).setSmart(true, true, true);
    }

    public static IkTokenizerFactoryXL getIkTokenizerFactory_128(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 128).setSmart(false, true, true);
    }

    public static IkTokenizerFactoryXL getIkSmartTokenizerFactory_128(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 128).setSmart(true, true, true);
    }

    public static IkTokenizerFactoryXL getIkTokenizerFactory_256(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 256).setSmart(false, true, true);
    }

    public static IkTokenizerFactoryXL getIkSmartTokenizerFactory_256(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 256).setSmart(true, true, true);
    }

    public static IkTokenizerFactoryXL getIkTokenizerFactory_512(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 512).setSmart(false, true, true);
    }

    public static IkTokenizerFactoryXL getIkSmartTokenizerFactory_512(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 512).setSmart(true, true, true);
    }

    public static IkTokenizerFactoryXL getIkTokenizerFactory_1024(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 1024).setSmart(false, true, true);
    }

    public static IkTokenizerFactoryXL getIkSmartTokenizerFactory_1024(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 1024).setSmart(true, true, true);
    }

    public static IkTokenizerFactoryXL getIkTokenizerFactory_2048(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 2048).setSmart(false, true, true);
    }

    public static IkTokenizerFactoryXL getIkSmartTokenizerFactory_2048(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 2048).setSmart(true, true, true);
    }

    public static IkTokenizerFactoryXL getIkTokenizerFactory_4096(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 4096).setSmart(false, true, true);
    }

    public static IkTokenizerFactoryXL getIkSmartTokenizerFactory_4096(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 4096).setSmart(true, true, true);
    }

    public static IkTokenizerFactoryXL getIkTokenizerFactory_8192(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 8192).setSmart(false, true, true);
    }

    public static IkTokenizerFactoryXL getIkSmartTokenizerFactory_8192(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 8192).setSmart(true, true, true);
    }

    public static IkTokenizerFactoryXL getIkTokenizerFactory_16384(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 16384).setSmart(false, true, true);
    }

    public static IkTokenizerFactoryXL getIkSmartTokenizerFactory_16384(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 16384).setSmart(true, true, true);
    }

    public static IkTokenizerFactoryXL getIkTokenizerFactory_32768(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 32768).setSmart(false, true, true);
    }

    public static IkTokenizerFactoryXL getIkSmartTokenizerFactory_32768(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 32768).setSmart(true, true, true);
    }

    public static IkTokenizerFactoryXL getIkTokenizerFactory_65536(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 65536).setSmart(false, true, true);
    }

    public static IkTokenizerFactoryXL getIkSmartTokenizerFactory_65536(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 65536).setSmart(true, true, true);
    }

    public static IkTokenizerFactoryXL getIkTokenizerFactory_131072(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 131072).setSmart(false, true, true);
    }

    public static IkTokenizerFactoryXL getIkSmartTokenizerFactory_131072(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 131072).setSmart(true, true, true);
    }

    public static IkTokenizerFactoryXL getIkTokenizerFactory_262144(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 262144).setSmart(false, true, true);
    }

    public static IkTokenizerFactoryXL getIkSmartTokenizerFactory_262144(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new IkTokenizerFactoryXL(indexSettings, env, name, settings, 262144).setSmart(true, true, true);
    }



    public IkTokenizerFactoryXL setSmart(boolean smart, boolean baseDict, boolean lexemeBitBoot) {
        this.configuration.setUseSmart(smart);
        this.configuration.setLexemeBitBoot(lexemeBitBoot);
        return this;
    }

    @Override
    public Tokenizer create() {
        return new IKTokenizer(configuration);
    }
}
