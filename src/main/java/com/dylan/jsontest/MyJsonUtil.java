package com.dylan.jsontest;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import java.util.Arrays;
import java.util.List;

public class MyJsonUtil {
    public static JSON toJson(Object o, String... excludeKeys) {
        List<String> excludes = Arrays.asList(excludeKeys);
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
        filter.getExcludes().addAll(excludes);    //重点！！！
        return JSON.parseObject(JSON.toJSONString(o, filter));
    }
}
