
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

import org.wltea.analyzer.dic.Dictionary;
import org.wltea.analyzer.dic.Hit;

import java.util.LinkedList;
import java.util.List;


/**
 *  中文-单字分词器
 */
class CNCHARSegmenter implements ISegmenter {

    //子分词器标签
    static final String SEGMENTER_NAME = "CNCHAR_SEGMENTER";
    //待处理的分词hit队列
    private List<Hit> tmpHits;


    CNCHARSegmenter() {
        this.tmpHits = new LinkedList<Hit>();
    }

    /* (non-Javadoc)
     * @see org.wltea.analyzer.core.ISegmenter#analyze(org.wltea.analyzer.core.AnalyzeContext)
     */
    public void analyze(AnalyzeContext context) {
        if (CharacterUtil.CHAR_USELESS != context.getCurrentCharType()) {
            Lexeme newLexeme = new Lexeme(context.getBufferOffset(), context.getCursor(), 1, Lexeme.TYPE_CNCHAR_EXT);
            context.addLexeme(newLexeme);
        } else {
            //遇到CHAR_USELESS字符
            //清空队列
            this.tmpHits.clear();
        }

        //判断缓冲区是否已经读完
        if (context.isBufferConsumed()) {
            //清空队列
            this.tmpHits.clear();
        }

        //判断是否锁定缓冲区
        if (this.tmpHits.size() == 0) {
            context.unlockBuffer(SEGMENTER_NAME);

        } else {
            context.lockBuffer(SEGMENTER_NAME);
        }
    }

    /* (non-Javadoc)
     * @see org.wltea.analyzer.core.ISegmenter#reset()
     */
    public void reset() {
        //清空队列
        this.tmpHits.clear();
    }

}
