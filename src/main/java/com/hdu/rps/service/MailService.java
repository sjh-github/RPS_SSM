package com.hdu.rps.service;

/**
 * Created by SJH on 2017/11/16.
 */
public interface MailService {
    /**
     * 发送邮件
     * @param to 发送目的用户
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    void sendSimpleMail(String to, String subject, String content);
}
