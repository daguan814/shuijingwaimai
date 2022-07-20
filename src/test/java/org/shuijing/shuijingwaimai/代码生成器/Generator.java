package org.shuijing.shuijingwaimai.代码生成器;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @ClassName: Generator
 * @Description: TODO
 * @author: 达观
 * @date: 2022/7/18  0:00
 */
public class Generator {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/shuijing", "root", "Lhf@2001.")
                .globalConfig(builder -> {
                    builder.author("baomidou") // 设置作者
                            .enableSwagger()
                            .outputDir("C://") // 指定输出目录
                            .fileOverride() // 覆盖已生成文件
                            .build();

                })
                .packageConfig(builder -> {
                    builder.parent("com.baomidou.mybatisplus") // 设置父包名
                            .entity("pojo")
                            .mapper("dao");


                })
                .strategyConfig(builder -> {
                    builder.enableCapitalMode()

                            .entityBuilder().enableLombok()
                            .enableTableFieldAnnotation()
                            .versionColumnName("version")
                            .versionPropertyName("version")
                            .logicDeleteColumnName("deleted")
                            .logicDeletePropertyName("deleteFlag")

                            .controllerBuilder().enableRestStyle()



                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImp")
                            .build()

                            .mapperBuilder().enableMapperAnnotation()
                            .formatMapperFileName("%sdao");









                })

                .execute();


    }
}
