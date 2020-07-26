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

/**
 * IK词元对象
 */
public class Lexeme implements Comparable<Lexeme> {
    // 是否允许相同位置词源 重复不同类型
    private boolean lexemeBitBoot = false;
    //lexemeType常量
    //未知
    public static final int TYPE_UNKNOWN = 0;
    //英文
    public static final int TYPE_ENGLISH = 101;
    //数字
    public static final int TYPE_ARABIC = 102;
    //英文数字混合
    public static final int TYPE_LETTER = 103;
    //中文词元
    public static final int TYPE_CNWORD = 104;
    //中文单字
    public static final int TYPE_CNCHAR = 164;
    //日韩文字
    public static final int TYPE_OTHER_CJK = 108;
    //中文数词
    public static final int TYPE_CNUM = 116;
    //中文量词
    public static final int TYPE_COUNT = 132;
    //中文数量词
    public static final int TYPE_CQUAN = 148;

    public static final int TYPE_PROVINCE = 2;
    public static final int TYPE_CITY = 4;
    public static final int TYPE_AREA = 8;
    public static final int TYPE_COUNTY = 16;
    public static final int TYPE_XIAOQU = 32;
    public static final int TYPE_OFFICE_PARK = 64;
    public static final int TYPE_OFFICE_BUILDING = 128;
    public static final int TYPE_HOSPITAL = 256;
    public static final int TYPE_PARK = 512;
    public static final int TYPE_SHOPPINGMALL = 1024;
    public static final int TYPE_SUPERMARKET = 2048;
    public static final int TYPE_SUBWAY_LINE = 4096;
    public static final int TYPE_SUBWAY_NAME = 8192;
    public static final int TYPE_UNIVERSITY = 16384;
    public static final int TYPE_MIDDLE_SCHOOL = 32768;
    public static final int TYPE_PRIMARY_SCHOOL = 65536;
    public static final int TYPE_ROOM_FEATURE = 131072;
    public static final int TYPE_ROOM_STYLE = 262144;
    public static final int TYPE_CNCHAR_EXT= 524288;

// ======================================================

    public static final int TYPE_BANK = -1;
    public static final int TYPE_BUS_LINE = -2;
    public static final int TYPE_BUS_NAME = -3;
    public static final int TYPE_CINEMA = -4;
    public static final int TYPE_COMPANY = -5;
    public static final int TYPE_CREMATORIUM = -6;
    public static final int TYPE_DISTRICT = -7;
    public static final int TYPE_FITNESS_CENTRE = -8;
    public static final int TYPE_FOOD_BEVERAGE = -9;
    public static final int TYPE_FOOD_MARKET = -10;
    public static final int TYPE_GAS_STATION = -11;
    public static final int TYPE_GYM = -12;
    public static final int TYPE_LANDFILL = -13;
    public static final int TYPE_LIBRARY = -14;
    public static final int TYPE_NATATORIUM = -15;
    public static final int TYPE_PHARMAC = -16;
    public static final int TYPE_PUBLIC_SECURITY = -17;
    public static final int TYPE_REAL_ESTATE_AGENCY = -18;
    public static final int TYPE_ROOM_FACE = -19;
    public static final int TYPE_ROOM_STATUS = -20;
    public static final int TYPE_BEDROOM_NUM = -22;
    public static final int TYPE_ROOM_RENT_TYPE = -23;
    public static final int TYPE_BEDROOM_TYPE = -24;
    public static final int TYPE_SCENIC_SPOT = -25;
    public static final int TYPE_BAR = -26;


    //词元的起始位移
    private int offset;
    //词元的相对起始位置
    private int begin;
    //词元的长度
    private int length;
    //词元文本
    private String lexemeText;
    //词元类型
    private int lexemeType;


    public Lexeme(int offset, int begin, int length, int lexemeType) {
        this.offset = offset;
        this.begin = begin;
        if (length < 0) {
            throw new IllegalArgumentException("length < 0");
        }
        this.length = length;
        this.lexemeType = lexemeType;
    }

    public Lexeme(int offset, int begin, int length, int lexemeType, boolean lexemeBitBoot) {
        this.offset = offset;
        this.begin = begin;
        if (length < 0) {
            throw new IllegalArgumentException("length < 0");
        }
        this.length = length;
        this.lexemeType = lexemeType;
        this.lexemeBitBoot = lexemeBitBoot;
    }

    /*
     * 判断词元相等算法
     * 起始位置偏移、起始位置、终止位置相同
     * @see java.lang.Object#equals(Object o)
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (this == o) {
            return true;
        }

        if (o instanceof Lexeme) {
            Lexeme other = (Lexeme) o;
            if (this.offset == other.getOffset()
                    && this.begin == other.getBegin()
                    && this.length == other.getLength()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /*
     * 词元哈希编码算法
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        int absBegin = getBeginPosition();
        int absEnd = getEndPosition();
        return (absBegin * 37) + (absEnd * 31) + ((absBegin * absEnd) % getLength()) * 11;
    }

    /*
     * 词元在排序集合中的比较算法
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Lexeme other) {
        //起始位置优先
        if (this.begin < other.getBegin()) {
            return -1;
        } else if (this.begin == other.getBegin()) {
            //词元长度优先
            if (this.length > other.getLength()) {
                return -1;
            } else if (this.length == other.getLength()) {
                return 0;
            } else {//this.length < other.getLength()
                return 1;
            }

        } else {//this.begin > other.getBegin()
            return 1;
        }
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getBegin() {
        return begin;
    }

    /**
     * 获取词元在文本中的起始位置
     *
     * @return int
     */
    public int getBeginPosition() {
        return offset + begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    /**
     * 获取词元在文本中的结束位置
     *
     * @return int
     */
    public int getEndPosition() {
        return offset + begin + length;
    }

    /**
     * 获取词元的字符长度
     *
     * @return int
     */
    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        if (this.length < 0) {
            throw new IllegalArgumentException("length < 0");
        }
        this.length = length;
    }

    /**
     * 获取词元的文本内容
     *
     * @return String
     */
    public String getLexemeText() {
        if (lexemeText == null) {
            return "";
        }
        return lexemeText;
    }

    public void setLexemeText(String lexemeText) {
        if (lexemeText == null) {
            this.lexemeText = "";
            this.length = 0;
        } else {
            this.lexemeText = lexemeText;
            this.length = lexemeText.length();
        }
    }

    /**
     * 获取词元类型
     *
     * @return int
     */
    public int getLexemeType() {
        return lexemeType;
    }

    /**
     * 获取词元类型标示字符串
     *
     * @return String
     */
    public String getLexemeTypeString() {
        switch (lexemeType) {

            case TYPE_ENGLISH:
                return "ENGLISH";

            case TYPE_ARABIC:
                return "ARABIC";

            case TYPE_LETTER:
                return "LETTER";

            case TYPE_CNWORD:
                return "CN_WORD";

            case TYPE_CNCHAR:
                return "CN_CHAR";

            case TYPE_OTHER_CJK:
                return "OTHER_CJK";

            case TYPE_COUNT:
                return "COUNT";

            case TYPE_CNUM:
                return "TYPE_CNUM";

            case TYPE_CQUAN:
                return "TYPE_CQUAN";

            case TYPE_CITY:
                return String.valueOf(TYPE_CITY);
            case TYPE_PROVINCE:
                return String.valueOf(TYPE_PROVINCE);
            case TYPE_COUNTY:
                return String.valueOf(TYPE_COUNTY);
            case TYPE_AREA:
                return String.valueOf(TYPE_AREA);
            case TYPE_BANK:
                return String.valueOf(TYPE_BANK);
            case TYPE_BUS_LINE:
                return String.valueOf(TYPE_BUS_LINE);
            case TYPE_BUS_NAME:
                return String.valueOf(TYPE_BUS_NAME);
            case TYPE_CINEMA:
                return String.valueOf(TYPE_CINEMA);
            case TYPE_COMPANY:
                return String.valueOf(TYPE_COMPANY);
            case TYPE_CREMATORIUM:
                return String.valueOf(TYPE_CREMATORIUM);
            case TYPE_DISTRICT:
                return String.valueOf(TYPE_DISTRICT);
            case TYPE_FITNESS_CENTRE:
                return String.valueOf(TYPE_FITNESS_CENTRE);
            case TYPE_FOOD_BEVERAGE:
                return String.valueOf(TYPE_FOOD_BEVERAGE);
            case TYPE_FOOD_MARKET:
                return String.valueOf(TYPE_FOOD_MARKET);
            case TYPE_GAS_STATION:
                return String.valueOf(TYPE_GAS_STATION);
            case TYPE_GYM:
                return String.valueOf(TYPE_GYM);
            case TYPE_HOSPITAL:
                return String.valueOf(TYPE_HOSPITAL);
            case TYPE_LIBRARY:
                return String.valueOf(TYPE_LIBRARY);
            case TYPE_MIDDLE_SCHOOL:
                return String.valueOf(TYPE_MIDDLE_SCHOOL);
            case TYPE_NATATORIUM:
                return String.valueOf(TYPE_NATATORIUM);
            case TYPE_OFFICE_BUILDING:
                return String.valueOf(TYPE_OFFICE_BUILDING);
            case TYPE_OFFICE_PARK:
                return String.valueOf(TYPE_OFFICE_PARK);
            case TYPE_PARK:
                return String.valueOf(TYPE_PARK);
            case TYPE_PHARMAC:
                return String.valueOf(TYPE_PHARMAC);
            case TYPE_PRIMARY_SCHOOL:
                return String.valueOf(TYPE_PRIMARY_SCHOOL);
            case TYPE_PUBLIC_SECURITY:
                return String.valueOf(TYPE_PUBLIC_SECURITY);
            case TYPE_REAL_ESTATE_AGENCY:
                return String.valueOf(TYPE_REAL_ESTATE_AGENCY);
            case TYPE_ROOM_FACE:
                return String.valueOf(TYPE_ROOM_FACE);
            case TYPE_ROOM_FEATURE:
                return String.valueOf(TYPE_ROOM_FEATURE);
            case TYPE_ROOM_STATUS:
                return String.valueOf(TYPE_ROOM_STATUS);
            case TYPE_ROOM_STYLE:
                return String.valueOf(TYPE_ROOM_STYLE);
            case TYPE_BEDROOM_NUM:
                return String.valueOf(TYPE_BEDROOM_NUM);
            case TYPE_SCENIC_SPOT:
                return String.valueOf(TYPE_SCENIC_SPOT);
            case TYPE_SHOPPINGMALL:
                return String.valueOf(TYPE_SHOPPINGMALL);
            case TYPE_SUBWAY_LINE:
                return String.valueOf(TYPE_SUBWAY_LINE);
            case TYPE_SUBWAY_NAME:
                return String.valueOf(TYPE_SUBWAY_NAME);
            case TYPE_SUPERMARKET:
                return String.valueOf(TYPE_SUPERMARKET);
            case TYPE_UNIVERSITY:
                return String.valueOf(TYPE_UNIVERSITY);
            case TYPE_XIAOQU:
                return String.valueOf(TYPE_XIAOQU);
            case TYPE_BAR:
                return String.valueOf(TYPE_BAR);
            case TYPE_ROOM_RENT_TYPE:
                return String.valueOf(TYPE_ROOM_RENT_TYPE);
            case TYPE_BEDROOM_TYPE:
                return String.valueOf(TYPE_BEDROOM_TYPE);
            case TYPE_CNCHAR_EXT:
                return String.valueOf(TYPE_CNCHAR_EXT);
            default:
                return "UNKONW";
        }
    }


    public void setLexemeType(int lexemeType) {
        this.lexemeType = lexemeType;
    }

    /**
     * 合并两个相邻的词元
     *
     * @param l
     * @param lexemeType
     * @return boolean 词元是否成功合并
     */
    public boolean append(Lexeme l, int lexemeType) {
        if (l != null && this.getEndPosition() == l.getBeginPosition()) {
            this.length += l.getLength();
            this.lexemeType = lexemeType;
            return true;
        } else {
            return false;
        }
    }

    public boolean isLexemeBitBoot() {
        return lexemeBitBoot;
    }

    public void setLexemeBitBoot(Boolean bool) {
        this.lexemeBitBoot = bool;
    }

    /**
     *
     */
    public String toString() {
        StringBuffer strbuf = new StringBuffer();
        strbuf.append(this.getBeginPosition()).append("-").append(this.getEndPosition());
        strbuf.append(" : ").append(this.lexemeText).append(" : \t");
        strbuf.append(this.getLexemeTypeString());
        return strbuf.toString();
    }


}
