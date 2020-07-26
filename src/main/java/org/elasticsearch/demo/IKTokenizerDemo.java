package org.elasticsearch.demo;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.lucene.IKAnalyzer;
import org.wltea.analyzer.lucene.IKTokenizer;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IKTokenizerDemo {

    public static void main(String[] agre) {

        Settings.Builder setting = Settings.builder();
        setting.put("index.creation_date", "1578116189294");
        setting.put("index.number_of_shards", "5");
        setting.put("index.number_of_replicas", "1");
        setting.put("index.uuid", "WN99cse0SIC-4Hw6hBbeOw");
        setting.put("index.version.created", "5050299");
        setting.put("index.provided_name", "subway_traffic");
        setting.put("path.home", "");
        Settings settings = setting.build();
        String esConfPath = "";
        Path configPath = Paths.get(esConfPath);
        Environment env = new Environment(settings, configPath);
        Configuration configuration = new Configuration(env, settings)
                .setUseSmart(false).setUseDict(1).setLexemeBitBoot(true);
        IKTokenizer ikTokenizer = new IKTokenizer(configuration);
        String text = "北京华夏未来城市中心";
        displayAllToken(text, ikTokenizer);
    }


    /**
     * 输出字符分词信息
     *
     * @param str
     * @param ikTokenizer
     */
    public static void displayAllToken(String str, IKTokenizer ikTokenizer) {
        try {
            // 所有的分词器都必须含有分词流
            ikTokenizer.setReader(new StringReader(str));
            ikTokenizer.reset();
            /**
             * 创建一个属性，这个属性会添加到流里，随着这个TokenStream流增加
             * 这个属性中保存中所有的分词信息
             */
            CharTermAttribute cta = ikTokenizer.addAttribute(CharTermAttribute.class);
            //位置增量的属性，存储词之间的距离
            PositionIncrementAttribute pia = ikTokenizer.addAttribute(PositionIncrementAttribute.class);
            //储存每个词直接的偏移量
            OffsetAttribute oa = ikTokenizer.addAttribute(OffsetAttribute.class);
            //使用的每个分词器直接的类型信息
            TypeAttribute ta = ikTokenizer.addAttribute(TypeAttribute.class);
            for (; ikTokenizer.incrementToken(); ) {
                System.out.print(pia.getPositionIncrement() + ":");
                System.out.print(cta + ":[" + oa.startOffset() + "-" + oa.endOffset() + "]-->" + ta.type() + "\n");

            }
            System.out.println();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 输出字符分词信息
     *
     * @param str
     * @param a
     */
    public static boolean displayAllTokenBoolean(String str, Analyzer a) {
        StringBuffer sb = new StringBuffer(str);
        try {
            // 所有的分词器都必须含有分词流
            TokenStream stream = a.tokenStream("content", new StringReader(str));// 放回一个TokenStream;
            stream.reset();
            /**
             * 创建一个属性，这个属性会添加到流里，随着这个TokenStream流增加
             * 这个属性中保存中所有的分词信息
             */
            CharTermAttribute cta = stream.addAttribute(CharTermAttribute.class);
            //位置增量的属性，存储词之间的距离
            PositionIncrementAttribute pia = stream.addAttribute(PositionIncrementAttribute.class);
            //储存每个词直接的偏移量
            OffsetAttribute oa = stream.addAttribute(OffsetAttribute.class);
            //使用的每个分词器直接的类型信息
            TypeAttribute ta = stream.addAttribute(TypeAttribute.class);
            for (; stream.incrementToken(); ) {
                if ("CN_CHAR".equals(ta.type())) {
                    System.err.println(str + "___" + cta + ":[" + oa.startOffset() + "-" + oa.endOffset() + "]-->" + ta.type());
                    return false;
                }
                sb.append(" ：" + cta + "_" + ta.type()).append("_");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(sb.toString());
        return true;
    }

}
