package com.xuxue.spider.topology.spider;


import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xuxue on 2017/2/5.
 */
public class Spider {
    private static final Logger LOG= LoggerFactory.getLogger(Spider.class);

    private ScriptEngine jsEngine;
    public Spider(){
        NashornScriptEngineFactory scriptEngineFactory = new NashornScriptEngineFactory();
        this.jsEngine = scriptEngineFactory.getScriptEngine();
    }

    private void include(String name)throws IOException{
        try(InputStream in= new FileInputStream(name)){
            String js= IOUtils.toString(in);
           try{
               jsEngine.eval(js);
           }catch (ScriptException e){
               LOG.warn("Failed include");
           }
        }
    }


}
