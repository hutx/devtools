package cn.jsfund.devtools;


import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by hutx on 13:57 2018/12/27
 */
// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {
    private static String[] TABLES;
    private static String DRIVER;
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    private static String PROJECT_PATH;
    private static String MODEL_PATH;
    private static String ENTITY_PATH;
    private static String XML_PATH;

    private static String AUTHOR;


    public static void main(String[] args) {
        InputStream in = CodeGenerator.class.getResourceAsStream("/mybatis_plus.properties");
        Properties pro = new Properties();
        try {
            pro.load(in);
            TABLES = pro.getProperty("tables").split(",");//.toUpperCase()
            DRIVER = pro.getProperty("jdbc.driver");
            URL = pro.getProperty("jdbc.url");
            USER = pro.getProperty("jdbc.user");
            PASSWORD = pro.getProperty("jdbc.password");

            PROJECT_PATH = pro.getProperty("projectPath");
            MODEL_PATH = pro.getProperty("modelPath");
            ENTITY_PATH = pro.getProperty("javaPath");
            XML_PATH = pro.getProperty("xmlPath");
            AUTHOR = pro.getProperty("author");

        } catch (IOException e) {
            e.printStackTrace();
        }
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir") + "/" + PROJECT_PATH;
        gc.setOutputDir(projectPath);
        gc.setAuthor(StringUtils.isNotEmpty(AUTHOR) ? AUTHOR : System.getProperty("user"));
        gc.setOpen(false);
        gc.setFileOverride(true);
        gc.setDateType(DateType.ONLY_DATE);
        mpg.setGlobalConfig(gc);


        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
//               dsc.setDbType(DbType.MYSQL);
        dsc.setUrl(URL);
//        dsc.setSchemaName("ims");
        dsc.setDriverName(DRIVER);
        dsc.setUsername(USER);
        dsc.setPassword(PASSWORD);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName("rtcalc");
        pc.setParent("cn.jsfund.devtools");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.btl";


        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/" + XML_PATH.replaceAll("\\.", "/") + "/"  //"/src/main/java/cn/jsfund/eda/mapper/xml/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        // templateConfig.setEntity();
//        templateConfig.setService(null);
        templateConfig.setController(null);
//        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityColumnConstant(true);
        strategy.setSuperEntityClass("cn.jsfund.devtools.base.BaseEntity");
        strategy.setEntityLombokModel(false);
        strategy.setRestControllerStyle(true);
        strategy.setSuperControllerClass("cn.jsfund.devtools.base.controller.BaseWebController");
        strategy.setInclude(TABLES);
//        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        //strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new BeetlTemplateEngine());
        mpg.execute();
    }
}
