package cn.zyuanyuan.beans;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mail {

    /*邮件主题*/
    private String subject;

    /*邮件信息*/
    private String message;

    /*邮箱*/
     private Set<String> receivers;

    /*  private String receivers;*/
}
