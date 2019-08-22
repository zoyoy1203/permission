package cn.zyuanyuan.beans;

import lombok.Getter;

@Getter
public enum CacheKeyConstants {

    /*缓存系统级别*/
    SYSTEM_ACLS,

    /*缓存用户级别，需要绑定用户id*/
    USER_ACLS;

}
