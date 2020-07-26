package org.elasticsearch.demo;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 项目名称：elasticsearch-analysis-ik
 * 类 名 称：SpeedTest
 * 类 描 述：TODO
 * 创建时间：2020/7/16 11:02 上午
 * 创 建 人：xu.long
 */
public class SpeedTest {

    public static void main(String[] args) throws ParseException {
         run("/Users/edz/Documents/data/search/nlp/district/room_index_doc.txt");
    }


    public static void run(String input) {

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
                .setUseSmart(false).setUseDict(12543).setLexemeBitBoot(true);
        IKAnalyzer analyzer = new IKAnalyzer(configuration);


        try {
            FileInputStream fileInputStream = new FileInputStream(input);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            int runc = 0;
            String text = null;
            long time = System.currentTimeMillis();
            while ((text = bufferedReader.readLine()) != null) {
                try {
                    // 所有的分词器都必须含有分词流
                    TokenStream stream = analyzer.tokenStream("content", new StringReader(text));// 放回一个TokenStream;
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
                        pia.getPositionIncrement();
//                        System.out.print(pia.getPositionIncrement() + ":");
//                        System.out.print(cta + ":[" + oa.startOffset() + "-" + oa.endOffset() + "]-->" + ta.type() + "\n");

                    }
                    if (runc++ % 1000 == 0) {
                        System.out.println(runc + "_" + (System.currentTimeMillis() - time));
                    }
                    stream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println(System.currentTimeMillis() - time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
