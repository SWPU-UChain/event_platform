package com.dataht.event.service;

public interface EventAnalyseService {

    String getEventTag(String sentence) throws Exception;

    String getEventEmotion(String sentence) throws Exception;

    String getEventAbstract(String sentence) throws Exception;

    String getEventKeyword(String sentence) throws Exception;
}
