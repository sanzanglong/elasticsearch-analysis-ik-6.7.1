package org.elasticsearch.demo;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 项目名称：elasticsearch-analysis-ik
 * 类 名 称：DicDispose
 * 类 描 述：TODO
 * 创建时间：2020/7/16 3:27 下午
 * 创 建 人：xu.long
 */
public class DicDispose {

    public String toCNNuber(String str){
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer(10);
        for(char c : chars){
            sb.append(toCNNuber(c));
        }
        return sb.toString();
    }

    public String toCNNuber(char c) {
        switch (c) {
            case 48:
                return "零";
            case 49:
                return "一";
            case 50:
                return "二";
            case 51:
                return "三";
            case 52:
                return "四";
            case 53:
                return "五";
            case 54:
                return "六";
            case 55:
                return "七";
            case 56:
                return "八";
            case 57:
                return "九";
            //你可以有任意数量的case语句
            default: //可选
                return String.valueOf(c);
        }
    }

    public void buildXiaoQu(String inPath, String outPath) throws IOException {
        FileWriter writer = new FileWriter(outPath);

        try {
            FileInputStream fileInputStream = new FileInputStream(inPath);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            int runc = 0;
            String text = null;
            while ((text = bufferedReader.readLine()) != null) {
                char[] chars = text.toCharArray();
                StringBuffer sb = new StringBuffer(10);
                for (char c : chars) {
                    sb.append(toCNNuber(c));
                }
                System.out.println(text + "_" + sb.toString());
                writer.write(text + "\n");
                if (!text.equals(sb.toString())) {
                    writer.write(sb.toString() + "\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buildSynonym(String inPath, String outPath) throws IOException {
    FileWriter writer = new FileWriter(outPath);

        try {
            FileInputStream fileInputStream = new FileInputStream(inPath);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            int runc = 0;
            String text = null;
            String p = null;
            Set<String> set = new HashSet<String>(10);
            while ((text = bufferedReader.readLine()) != null) {
                String[] texts = text.replace("\"", "").split(",", -1);
                if("".equals(texts[0]) || "".equals(texts[1])){
                    continue;
                }
                String mainDic = toCNNuber(texts[0]);
                if (p != null && !p.equals(mainDic)) {
                    StringBuffer sb = new StringBuffer(30);
                    for (String syno : set) {
                        sb.append(syno).append(",");
                    }
                    sb.delete(sb.length()-1, sb.length());
                    sb.append(" => ").append(p);
                    writer.write(sb.toString()+"\n");
                    set.clear();
                }
                set.add(texts[1]);
                String textNb = toCNNuber(texts[1]);
                if(!texts[1].equals(textNb)){
                    set.add(textNb);
                }
                p = mainDic;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
//        DicDispose dd = new DicDispose();
//        String inPath = "/Users/edz/Documents/data/search/nlp/district/小区词库.dic";
//        String outPath = "/Users/edz/Documents/data/search/nlp/district/小区词库2.dic";
//        dd.buildXiaoQu(inPath, outPath);


        DicDispose dd = new DicDispose();
        String inPath = "/Users/edz/Documents/data/search/nlp/district/小区别名数据.csv";
        String outPath = "/Users/edz/Documents/data/search/nlp/district/小区别名数据2.csv";
        dd.buildSynonym(inPath, outPath);
    }
}
