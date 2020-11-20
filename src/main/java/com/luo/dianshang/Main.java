package com.luo.dianshang;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 南磊
 * @date 2020/5/18 11:47
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        AutoGenerator autoGenerator=new AutoGenerator();
        DataSourceConfig dataSourceConfig=new DataSourceConfig();
        //配置数据源
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("522133");
        dataSourceConfig.setUrl("jdbc:mysql://localhost/mmall?useUnicode=true&characterEncoding=UTF-8");
        autoGenerator.setDataSource(dataSourceConfig);

        //配置全局
        GlobalConfig globalConfig=new GlobalConfig();
        //输出到哪
        globalConfig.setOutputDir(System.getProperty("user.dir")+"/src/main/java");
        //作者
        globalConfig.setAuthor("花折");
        //创建成功是否打开
        globalConfig.setOpen(false);
        //设置Service的名字   默认前面有I    去掉I
        globalConfig.setServiceName("%sService");
        autoGenerator.setGlobalConfig(globalConfig);

        //配置包信息
        PackageConfig packageConfig=new PackageConfig();
        //根目录
        packageConfig.setParent("com.luo.dianshang");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setController("controller");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        autoGenerator.setPackageInfo(packageConfig);

        //配置生产策略
        StrategyConfig strategyConfig=new StrategyConfig();
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);

        //时间
        List<TableFill> list=new ArrayList<>();
        TableFill tableFill1=new TableFill("create_time", FieldFill.INSERT);
        TableFill tableFill2=new TableFill("create_time", FieldFill.INSERT);
        list.add(tableFill1);
        list.add(tableFill2);

        strategyConfig.setTableFillList(list);
        autoGenerator.setStrategy(strategyConfig);

        autoGenerator.execute();
    }
}
