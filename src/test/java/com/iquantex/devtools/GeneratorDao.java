package com.iquantex.devtools;

import com.iquantex.generator.MybatisBeanDaoGenerator;
import org.junit.Test;

/**
 * Created by hutx on 15:18 2018/11/21
 */
public class GeneratorDao {

    @Test
    public void generator() {
        try {
            MybatisBeanDaoGenerator.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
