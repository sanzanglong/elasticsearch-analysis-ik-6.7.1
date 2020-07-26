package org.elasticsearch.demo;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SearchKeyWordIK {

    public static void main(String[] args) throws IOException {
        String filePath = "/Users/edz/Downloads/ods_log_roomfinder_service_202001091833.csv";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath)),
                "UTF-8"));

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
                .setUseSmart(true).setUseDict(1).setLexemeBitBoot(false);
        int count = 0;
        String lineTxt = null;
        while ((lineTxt = br.readLine()) != null) {
//            System.out.println(lineTxt);
            IKAnalyzer analyzer = new IKAnalyzer(configuration);
            String[] terms = lineTxt.split(",");
            if(terms.length >=2){
                if (IKDemo.displayAllTokenBoolean(terms[1], analyzer)) {
                    count++;
                }
            }

        }
        System.out.println(count);
    }

}
