package org.myspring.core.aop;

import org.junit.Test;
import org.myspring.core.aop.aspect.AspectInfo;

import java.util.ArrayList;
import java.util.List;

public class AspectListExecutorTest {
    @Test
    public void sortTest(){
        ArrayList<AspectInfo> aspectInfos = new ArrayList<>();
        aspectInfos.add(new AspectInfo(3, new Mock1()));
        aspectInfos.add(new AspectInfo(5, new Mock2()));
        aspectInfos.add(new AspectInfo(2, new Mock3()));
        aspectInfos.add(new AspectInfo(4, new Mock4()));
        aspectInfos.add(new AspectInfo(1, new Mock5()));
        AspectListExecutor aspectListExecutor = new AspectListExecutor(AspectListExecutorTest.class, aspectInfos);
        List<AspectInfo> executorAspectInfoList = aspectListExecutor.getAspectInfoList();
        for (AspectInfo aspectInfo:executorAspectInfoList ) {
            System.out.println(aspectInfo.getAspectObject().getClass().getName());
        }
    }
}
