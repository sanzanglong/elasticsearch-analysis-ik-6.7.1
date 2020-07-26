package org.elasticsearch.plugin.analysis.ik;

import org.apache.lucene.analysis.Analyzer;
import org.elasticsearch.index.analysis.*;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import java.util.HashMap;
import java.util.Map;


public class AnalysisIkPlugin extends Plugin implements AnalysisPlugin {

    public static String PLUGIN_NAME = "analysis-ik";

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> getTokenizers() {
        Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> extra = new HashMap<>();

        extra.put("ik_smart", IkTokenizerFactory::getIkSmartTokenizerFactory);
        extra.put("ik_max_word", IkTokenizerFactory::getIkTokenizerFactory);
        extra.put("ik_smart_ext", IkTokenizerFactoryXL::getIkSmartTokenizerFactory);
        extra.put("ik_max_word_ext", IkTokenizerFactoryXL::getIkTokenizerFactory);
        extra.put("ik_smart_all", IkTokenizerFactoryXL::getIkSmartTokenizerFactory_all);
        extra.put("ik_max_word_all", IkTokenizerFactoryXL::getIkTokenizerFactory_all);
        extra.put("ik_smart_norm", IkTokenizerFactoryXL::getIkSmartTokenizerFactory_norm);
        extra.put("ik_max_word_norm", IkTokenizerFactoryXL::getIkTokenizerFactory_norm);
        extra.put("ik_smart_524287", IkTokenizerFactoryXL::getIkSmartTokenizerFactory_524287);
        extra.put("ik_max_word_524287", IkTokenizerFactoryXL::getIkTokenizerFactory_524287);
        extra.put("ik_smart_2", IkTokenizerFactoryXL::getIkSmartTokenizerFactory_2);
        extra.put("ik_max_word_2", IkTokenizerFactoryXL::getIkTokenizerFactory_2);
        extra.put("ik_smart_4", IkTokenizerFactoryXL::getIkSmartTokenizerFactory_4);
        extra.put("ik_max_word_4", IkTokenizerFactoryXL::getIkTokenizerFactory_4);
        extra.put("ik_smart_8", IkTokenizerFactoryXL::getIkSmartTokenizerFactory_8);
        extra.put("ik_max_word_8", IkTokenizerFactoryXL::getIkTokenizerFactory_8);
        extra.put("ik_smart_16", IkTokenizerFactoryXL::getIkSmartTokenizerFactory_16);
        extra.put("ik_max_word_16", IkTokenizerFactoryXL::getIkTokenizerFactory_16);
        extra.put("ik_smart_32", IkTokenizerFactoryXL::getIkSmartTokenizerFactory_32);
        extra.put("ik_max_word_32", IkTokenizerFactoryXL::getIkTokenizerFactory_32);
        extra.put("ik_smart_64", IkTokenizerFactoryXL::getIkSmartTokenizerFactory_64);
        extra.put("ik_max_word_64", IkTokenizerFactoryXL::getIkTokenizerFactory_64);
        extra.put("ik_smart_128", IkTokenizerFactoryXL::getIkSmartTokenizerFactory_128);
        extra.put("ik_max_word_128", IkTokenizerFactoryXL::getIkTokenizerFactory_128);
        extra.put("ik_smart_256", IkTokenizerFactoryXL::getIkSmartTokenizerFactory_256);
        extra.put("ik_max_word_256", IkTokenizerFactoryXL::getIkTokenizerFactory_256);
        extra.put("ik_smart_512", IkTokenizerFactoryXL::getIkSmartTokenizerFactory_512);
        extra.put("ik_max_word_512", IkTokenizerFactoryXL::getIkTokenizerFactory_512);
        extra.put("ik_smart_1024", IkTokenizerFactoryXL::getIkSmartTokenizerFactory_1024);
        extra.put("ik_max_word_1024", IkTokenizerFactoryXL::getIkTokenizerFactory_1024);
        extra.put("ik_smart_2048", IkTokenizerFactoryXL::getIkSmartTokenizerFactory_2048);
        extra.put("ik_max_word_2048", IkTokenizerFactoryXL::getIkTokenizerFactory_2048);
        extra.put("ik_smart_4096", IkTokenizerFactoryXL::getIkSmartTokenizerFactory_4096);
        extra.put("ik_max_word_4096", IkTokenizerFactoryXL::getIkTokenizerFactory_4096);
        extra.put("ik_smart_8192", IkTokenizerFactoryXL::getIkSmartTokenizerFactory_8192);
        extra.put("ik_max_word_8192", IkTokenizerFactoryXL::getIkTokenizerFactory_8192);
        extra.put("ik_smart_16384", IkTokenizerFactoryXL::getIkSmartTokenizerFactory_16384);
        extra.put("ik_max_word_16384", IkTokenizerFactoryXL::getIkTokenizerFactory_16384);
        extra.put("ik_smart_32768", IkTokenizerFactoryXL::getIkSmartTokenizerFactory_32768);
        extra.put("ik_max_word_32768", IkTokenizerFactoryXL::getIkTokenizerFactory_32768);
        extra.put("ik_smart_65536", IkTokenizerFactoryXL::getIkSmartTokenizerFactory_65536);
        extra.put("ik_max_word_65536", IkTokenizerFactoryXL::getIkTokenizerFactory_65536);
        extra.put("ik_smart_131072", IkTokenizerFactoryXL::getIkSmartTokenizerFactory_131072);
        extra.put("ik_max_word_131072", IkTokenizerFactoryXL::getIkTokenizerFactory_131072);
        extra.put("ik_smart_262144", IkTokenizerFactoryXL::getIkSmartTokenizerFactory_262144);
        extra.put("ik_max_word_262144", IkTokenizerFactoryXL::getIkTokenizerFactory_262144);
        return extra;
    }

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> extra = new HashMap<>();

        extra.put("ik_smart", IkAnalyzerProvider::getIkSmartAnalyzerProvider);
        extra.put("ik_max_word", IkAnalyzerProvider::getIkAnalyzerProvider);
        extra.put("ik_smart_ext", IkAnalyzerProviderXL::getIkSmartAnalyzerProvider);
        extra.put("ik_max_word_ext", IkAnalyzerProviderXL::getIkAnalyzerProvider);
        extra.put("ik_smart_all", IkAnalyzerProviderXL::getIkSmartAnalyzerProvider_all);
        extra.put("ik_max_word_all", IkAnalyzerProviderXL::getIkAnalyzerProvider_all);
        extra.put("ik_smart_norm", IkAnalyzerProviderXL::getIkSmartAnalyzerProvider_norm);
        extra.put("ik_max_word_norm", IkAnalyzerProviderXL::getIkAnalyzerProvider_norm);
        extra.put("ik_smart_524287", IkAnalyzerProviderXL::getIkSmartAnalyzerProvider_524287);
        extra.put("ik_max_word_524287", IkAnalyzerProviderXL::getIkAnalyzerProvider_524287);
        extra.put("ik_smart_2", IkAnalyzerProviderXL::getIkSmartAnalyzerProvider_2);
        extra.put("ik_max_word_2", IkAnalyzerProviderXL::getIkAnalyzerProvider_2);
        extra.put("ik_smart_4", IkAnalyzerProviderXL::getIkSmartAnalyzerProvider_4);
        extra.put("ik_max_word_4", IkAnalyzerProviderXL::getIkAnalyzerProvider_4);
        extra.put("ik_smart_8", IkAnalyzerProviderXL::getIkSmartAnalyzerProvider_8);
        extra.put("ik_max_word_8", IkAnalyzerProviderXL::getIkAnalyzerProvider_8);
        extra.put("ik_smart_16", IkAnalyzerProviderXL::getIkSmartAnalyzerProvider_16);
        extra.put("ik_max_word_16", IkAnalyzerProviderXL::getIkAnalyzerProvider_16);
        extra.put("ik_smart_32", IkAnalyzerProviderXL::getIkSmartAnalyzerProvider_32);
        extra.put("ik_max_word_32", IkAnalyzerProviderXL::getIkAnalyzerProvider_32);
        extra.put("ik_smart_64", IkAnalyzerProviderXL::getIkSmartAnalyzerProvider_64);
        extra.put("ik_max_word_64", IkAnalyzerProviderXL::getIkAnalyzerProvider_64);
        extra.put("ik_smart_128", IkAnalyzerProviderXL::getIkSmartAnalyzerProvider_128);
        extra.put("ik_max_word_128", IkAnalyzerProviderXL::getIkAnalyzerProvider_128);
        extra.put("ik_smart_256", IkAnalyzerProviderXL::getIkSmartAnalyzerProvider_256);
        extra.put("ik_max_word_256", IkAnalyzerProviderXL::getIkAnalyzerProvider_256);
        extra.put("ik_smart_512", IkAnalyzerProviderXL::getIkSmartAnalyzerProvider_512);
        extra.put("ik_max_word_512", IkAnalyzerProviderXL::getIkAnalyzerProvider_512);
        extra.put("ik_smart_1024", IkAnalyzerProviderXL::getIkSmartAnalyzerProvider_1024);
        extra.put("ik_max_word_1024", IkAnalyzerProviderXL::getIkAnalyzerProvider_1024);
        extra.put("ik_smart_2048", IkAnalyzerProviderXL::getIkSmartAnalyzerProvider_2048);
        extra.put("ik_max_word_2048", IkAnalyzerProviderXL::getIkAnalyzerProvider_2048);
        extra.put("ik_smart_4096", IkAnalyzerProviderXL::getIkSmartAnalyzerProvider_4096);
        extra.put("ik_max_word_4096", IkAnalyzerProviderXL::getIkAnalyzerProvider_4096);
        extra.put("ik_smart_8192", IkAnalyzerProviderXL::getIkSmartAnalyzerProvider_8192);
        extra.put("ik_max_word_8192", IkAnalyzerProviderXL::getIkAnalyzerProvider_8192);
        extra.put("ik_smart_16384", IkAnalyzerProviderXL::getIkSmartAnalyzerProvider_16384);
        extra.put("ik_max_word_16384", IkAnalyzerProviderXL::getIkAnalyzerProvider_16384);
        extra.put("ik_smart_32768", IkAnalyzerProviderXL::getIkSmartAnalyzerProvider_32768);
        extra.put("ik_max_word_32768", IkAnalyzerProviderXL::getIkAnalyzerProvider_32768);
        extra.put("ik_smart_65536", IkAnalyzerProviderXL::getIkSmartAnalyzerProvider_65536);
        extra.put("ik_max_word_65536", IkAnalyzerProviderXL::getIkAnalyzerProvider_65536);
        extra.put("ik_smart_131072", IkAnalyzerProviderXL::getIkSmartAnalyzerProvider_131072);
        extra.put("ik_max_word_131072", IkAnalyzerProviderXL::getIkAnalyzerProvider_131072);
        extra.put("ik_smart_262144", IkAnalyzerProviderXL::getIkSmartAnalyzerProvider_262144);
        extra.put("ik_max_word_262144", IkAnalyzerProviderXL::getIkAnalyzerProvider_262144);
        return extra;
    }

}
