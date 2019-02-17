package com.example.persist.code;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;

/**
 * 代码生成器
 */
public class CodeGenerate {
    @Test
    public void generateCod() throws Exception {
        String packageName = "com.example";
        String moduleName = "user";
        generateByTables(packageName, moduleName, "employee");
    }

    private void generateByTables(String packageName, String moduleName, String...tableNames) {
        AutoGenerator generator = new AutoGenerator();
        generator.setTemplateEngine(getTemplateEngine()) // 选择 freemarker 引擎，默认 Veloctiy
                .setPackageInfo(getPackageConfig(packageName, moduleName))
                .setDataSource(getDataSourceConfig())
                .setStrategy(getStrategyConfig(tableNames))
                .setGlobalConfig(getGlobalConfig());
        generator.execute();
    }

    //模板配置
    private FreemarkerTemplateEngine getTemplateEngine() {
        return new FreemarkerTemplateEngine();
    }

    //全局配置
    private GlobalConfig getGlobalConfig() {
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setAuthor("qmt")
                .setOutputDir("F:\\mybatis_plus_code")
                .setFileOverride(true)
                .setIdType(AUTO);
        config.setServiceName("%sService");
        return config;
    }

    //策略配置
    private StrategyConfig getStrategyConfig(String[] tableNames) {
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)
                .setEntityLombokModel(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setEntityColumnConstant(true)
                .setInclude(tableNames);
        return strategyConfig;
    }

    //数据库配置
    private DataSourceConfig getDataSourceConfig() {
        String dbUrl = "jdbc:mysql://localhost:3306/crm?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("admin")
                .setDriverName("com.mysql.cj.jdbc.Driver");
        return dataSourceConfig;
    }

    //包配置
    private PackageConfig getPackageConfig(String packageName, String moduleName) {
        return new PackageConfig().setParent(packageName)
                .setController("admin.web." + moduleName + ".controller")
                .setEntity("persist.entity." + moduleName)
                .setMapper("persist.mapper." + moduleName)
                .setService("core.service." + moduleName)
                .setServiceImpl("core.service." + moduleName + ".impl")
                .setXml("persist.mapper." + moduleName);
    }

    class CustomMySqlTypeConvert implements ITypeConvert {

        @Override
        public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
            String t = fieldType.toLowerCase();
            if (t.contains("char") || t.contains("text")) {
                return DbColumnType.STRING;
            } else if (t.contains("bigint")) {
                return DbColumnType.LONG;
            } else if (t.contains("tinyint(1)")) {
                return DbColumnType.BOOLEAN;
            } else if (t.contains("tinyint(4)")) {
                return DbColumnType.BYTE;
            } else if (t.contains("int")) {
                return DbColumnType.INTEGER;
            } else if (t.contains("text")) {
                return DbColumnType.STRING;
            } else if (t.contains("bit")) {
                return DbColumnType.BASE_BOOLEAN;
            } else if (t.contains("decimal")) {
                return DbColumnType.BIG_DECIMAL;
            } else if (t.contains("clob")) {
                return DbColumnType.CLOB;
            } else if (t.contains("blob")) {
                return DbColumnType.BLOB;
            } else if (t.contains("binary")) {
                return DbColumnType.BYTE_ARRAY;
            } else if (t.contains("float")) {
                return DbColumnType.FLOAT;
            } else if (t.contains("double")) {
                return DbColumnType.DOUBLE;
            } else if (t.contains("json") || t.contains("enum")) {
                return DbColumnType.STRING;
            } else if (t.contains("date") || t.contains("time") || t.contains("year")) {
                switch (globalConfig.getDateType()) {
                    case ONLY_DATE:
                        return DbColumnType.DATE;
                    case SQL_PACK:
                        switch (t) {
                            case "date":
                                return DbColumnType.DATE_SQL;
                            case "time":
                                return DbColumnType.TIME;
                            case "year"://todo 这个year可能有bug
                                return DbColumnType.DATE_SQL;
                            default:
                                return DbColumnType.TIMESTAMP;
                        }
                    case TIME_PACK:
                        switch (t) {
                            case "date":
                                return DbColumnType.LOCAL_DATE;
                            case "time":
                                return DbColumnType.LOCAL_TIME;
                            case "year":
                                return DbColumnType.YEAR;
                            default:
                                return DbColumnType.LOCAL_DATE_TIME;
                        }
                }
            }
            return DbColumnType.STRING;
        }
    }


}
