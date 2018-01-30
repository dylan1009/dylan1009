package com.dylan.learn;

import cn.hutool.core.util.ObjectUtil;
import com.dylan.bean.Cat;
import com.dylan.bean.MainPerson;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MainPerson mainPerson = new MainPerson();
        mainPerson.setName("danfeng");
        Cat cat = new Cat();
        cat.setMainPerson(mainPerson);
        Cat cloneCat = ObjectUtil.cloneByStream(cat);
        cloneCat.setName("dylan");
        cloneCat.getMainPerson().setName("xxxx");
        

        System.out.println(cat.getMainPerson().getName());
        System.out.println(cloneCat.getMainPerson().getName());
    }



}
