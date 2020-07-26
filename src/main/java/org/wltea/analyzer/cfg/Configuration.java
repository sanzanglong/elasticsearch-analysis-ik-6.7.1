/**
 *
 */
package org.wltea.analyzer.cfg;

import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.io.PathUtils;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.plugin.analysis.ik.AnalysisIkPlugin;
import org.wltea.analyzer.dic.Dictionary;

import java.io.File;
import java.nio.file.Path;

public class Configuration<boole> {

    private Environment environment;
    private Settings settings;

    //是否启用智能分词
    private boolean useSmart;

    //是否启用远程词典加载
    private boolean enableRemoteDict = false;

    //是否启用小写处理
    private boolean enableLowercase = true;

    //是否加载基础字典
    private int useDict = 1;

    // 是否过滤相同位置词源 重复不同类型
    private boolean lexemeBitBoot = true;

    @Inject
    public Configuration(Environment env, Settings settings) {
        this.environment = env;
        this.settings = settings;

        this.useSmart = settings.get("use_smart", "false").equals("true");
        this.enableLowercase = settings.get("enable_lowercase", "true").equals("true");
        this.enableRemoteDict = settings.get("enable_remote_dict", "true").equals("true");

        Dictionary.initial(this);

    }

    public Path getConfigInPluginDir() {
        return PathUtils
                .get(new File(AnalysisIkPlugin.class.getProtectionDomain().getCodeSource().getLocation().getPath())
                        .getParent(), "config")
                .toAbsolutePath();
    }

    public boolean isUseSmart() {
        return useSmart;
    }

    public Configuration setUseSmart(boolean useSmart) {
        this.useSmart = useSmart;
        return this;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public Settings getSettings() {
        return settings;
    }

    public boolean isEnableRemoteDict() {
        return enableRemoteDict;
    }

    public boolean isEnableLowercase() {
        return enableLowercase;
    }

    public int getUseDict() {
        return useDict;
    }

    public Configuration setUseDict(int useDict) {
        this.useDict = useDict;
        return this;
    }

    public boolean isLexemeBitBoot(){
        return this.lexemeBitBoot;
    }

    public Configuration setLexemeBitBoot(boolean lexemeBitBoot){
        this.lexemeBitBoot = lexemeBitBoot;
        return this;
    }
}
