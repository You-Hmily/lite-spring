package com.hmily.litespring.aop;

public interface Pointcut {

    MethodMatcher getMethodMatcher();

    String getExpression();
}
