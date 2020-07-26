/**
 * IK 中文分词  版本 5.0
 * IK Analyzer release 5.0
 * <p>
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * 源代码由林良益(linliangyi2005@gmail.com)提供
 * 版权声明 2012，乌龙茶工作室
 * provided by Linliangyi and copyright 2012 by Oolong studio
 */
package org.wltea.analyzer.core;

import org.wltea.analyzer.cfg.Configuration;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * IK分词器主类
 *
 */
public final class IKSegmenter {

    //字符窜reader
    private Reader input;
    //分词器上下文
    private AnalyzeContext context;
    //分词处理器列表
    private List<ISegmenter> segmenters;
    //分词歧义裁决器
    private IKArbitrator arbitrator;
    private Configuration configuration;


    /**
     * IK分词器构造函数
     * @param input
     */
    public IKSegmenter(Reader input, Configuration configuration) {
        this.input = input;
        this.configuration = configuration;
        this.init();
    }


    /**
     * 初始化
     */
    private void init() {
        //初始化分词上下文
        this.context = new AnalyzeContext(configuration);
        //加载子分词器
        this.segmenters = this.loadSegmenters();
        //加载歧义裁决器
        this.arbitrator = new IKArbitrator();
    }

    /**
     * 初始化词典，加载子分词器实现
     * @return List<ISegmenter>
     */
    private List<ISegmenter> loadSegmenters() {
        List<ISegmenter> segmenters = new ArrayList<ISegmenter>(20);
        //处理字母的子分词器
        segmenters.add(new LetterSegmenter());
//		//处理中文数量词的子分词器
        segmenters.add(new CN_QuantifierSegmenter());
        // 优先级 1
        if ((configuration.getUseDict() & 32) == 32) {
            segmenters.add(new XiaoquSegmenter()); // 小区
        }
        if ((configuration.getUseDict() & 64) == 64) {
            segmenters.add(new OfficeParkSegmenter()); // 办公园区
        }
        if ((configuration.getUseDict() & 128) == 128) {
            segmenters.add(new OfficeBuildingSegmenter()); // 办公楼
        }
        if ((configuration.getUseDict() & 4096) == 4096) {
            segmenters.add(new SubwayLineSegmenter()); // 地铁线
        }
        if ((configuration.getUseDict() & 8192) == 8192) {
            segmenters.add(new SubwayNameSegmenter()); // 地铁站
        }
        if ((configuration.getUseDict() & 131072) == 131072) {
            segmenters.add(new RoomFeatureSegmenter()); // 房源标签 tag
        }
        if ((configuration.getUseDict() & 262144) == 262144) {
            segmenters.add(new RoomStyleSegmenter()); // 装修风格
        }
        if ((configuration.getUseDict() & 2) == 2) {
            segmenters.add(new ProvinceSegmenter()); // 省
        }
        if ((configuration.getUseDict() & 4) == 4) {
            segmenters.add(new CitySegmenter()); // 市
        }
        if ((configuration.getUseDict() & 8) == 8) {
            segmenters.add(new AreaSegmenter()); // 区
        }
        if ((configuration.getUseDict() & 16) == 16) {
            segmenters.add(new CountySegmenter()); // 区县
        }
        if ((configuration.getUseDict() & 256) == 256) {
            segmenters.add(new HospitalSegmenter()); // 医院
        }
        if ((configuration.getUseDict() & 512) == 512) {
            segmenters.add(new ParkSegmenter()); // 公园
        }
        if ((configuration.getUseDict() & 1024) == 1024) {
            segmenters.add(new ShoppingmallSegmenter()); // 商场
        }
        if ((configuration.getUseDict() & 2048) == 2048) {
            segmenters.add(new SupermarketSegmenter()); // 超市
        }
        if ((configuration.getUseDict() & 16384) == 16384) {
            segmenters.add(new UniversitySegmenter()); // 大学
        }
        if ((configuration.getUseDict() & 32768) == 32768) {
            segmenters.add(new MiddleSchooLSegmenter()); // 中学
        }
        if ((configuration.getUseDict() & 65536) == 65536) {
            segmenters.add(new PrimarySchoolSegmenter()); // 小学
        }
        if ((configuration.getUseDict() & 1) == 1) {
            //处理中文词的子分词器
            segmenters.add(new CJKSegmenter());
        }
		if ((configuration.getUseDict() & 524288) == 524288) {
            segmenters.add(new CNCHARSegmenter()); // 单字分词
		}
        // segmenters.add(new DistrictSegmenter()); // 县/街道 比较乱
        // segmenters.add(new BedroomNumSegmenter()); // 居室
        // segmenters.add(new RoomRentTypeSegmenter()); // 出租类型
        // segmenters.add(new BedroomTypeSegmenter()); // 卧室类型


// ===========================================================================
//		segmenters.add(new BankSegmenter());
//		segmenters.add(new BusLineSegmenter());
//		segmenters.add(new CinemaSegmenter()); // 影院
//		segmenters.add(new CompanySegmenter());
//		segmenters.add(new CrematoriumSegmenter()); // 殡仪
//		segmenters.add(new FitnessCentreSegmenter()); // 健身房名
//		segmenters.add(new FoodBeverageSegmenter()); // 饭店名
//		segmenters.add(new FoodMarketSegmenter()); // 市场名
//		segmenters.add(new GasStationSegmenter()); // 加油站
//		segmenters.add(new GymSegmenter()); // 运动俱乐部
//		segmenters.add(new LandfillSegmenter()); // 垃圾站
//		segmenters.add(new LibrarySegmenter()); // 图书馆

//		segmenters.add(new NatatoriumSegmenter()); // 游泳馆
//		segmenters.add(new PharmacSegmenter()); // 药房
//		segmenters.add(new PublicSecuritySegmenter()); // 警务室
//		segmenters.add(new RealEstateAgencySegmenter()); // 地产中介
//		segmenters.add(new RoomFaceSegmenter()); // 房间朝向
//		segmenters.add(new RoomStatusSegmenter()); // 房源状态
//		segmenters.add(new ScenicSpotSegmenter()); // 风景区

        return segmenters;
    }

    /**
     * 分词，获取下一个词元
     * @return Lexeme 词元对象
     * @throws java.io.IOException
     */
    public synchronized Lexeme next() throws IOException {
        Lexeme l = null;
        while ((l = context.getNextLexeme()) == null) {
            /*
             * 从reader中读取数据，填充buffer
             * 如果reader是分次读入buffer的，那么buffer要  进行移位处理
             * 移位处理上次读入的但未处理的数据
             */
            int available = context.fillBuffer(this.input);
            if (available <= 0) {
                //reader已经读完
                context.reset();
                return null;

            } else {
                //初始化指针
                context.initCursor();
                do {
                    //遍历子分词器
                    for (ISegmenter segmenter : segmenters) {
                        segmenter.analyze(context);
                    }
                    //字符缓冲区接近读完，需要读入新的字符
                    if (context.needRefillBuffer()) {
                        break;
                    }
                    //向前移动指针
                } while (context.moveCursor());
                //重置子分词器，为下轮循环进行初始化
                for (ISegmenter segmenter : segmenters) {
                    segmenter.reset();
                }
            }
            //对分词进行歧义处理
            this.arbitrator.process(context, configuration.isUseSmart());
            //将分词结果输出到结果集，并处理未切分的单个CJK字符
            context.outputToResult();
            //记录本次分词的缓冲区位移
            context.markBufferOffset();
        }
        return l;
    }

    /**
     * 重置分词器到初始状态
     * @param input
     */
    public synchronized void reset(Reader input) {
        this.input = input;
        context.reset();
        for (ISegmenter segmenter : segmenters) {
            segmenter.reset();
        }
    }
}
