package com.dylan.jsontest;

import com.alibaba.fastjson.JSON;

public class FilterJsonAttr {
    public static void main(String[] args) {
        Person child = new Person("mike", "male", 10);
        Person father = new Person("jimmy", "male", 37);
        child.setFather(father);
        JSON json  = MyJsonUtil.toJson(child, "name");
        System.out.println(json);
        System.out.println("sdfijdfajefajcccccc");
    }
}
