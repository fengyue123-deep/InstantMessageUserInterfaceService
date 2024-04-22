package cn.liuzhengquan.instantmessageuserinterfaceservice.entity;

import com.alibaba.fastjson2.JSON;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Messages {
    /**
     * 消息类型
     */
    private String type;
    /**
     * 发送好友昵称
     */
    private String sendNickname;
    /**
     * 接收好友昵称
     */
    private String receiveNickname;
    /**
     * 消息内容
     */
    private Object messages;
    public static void main(String[]args){
        Messages messages=new Messages();
        messages.setMessages(1);
        messages.setType("1");
        messages.setReceiveNickname("feng");
        messages.setSendNickname("Nihao");
        System.out.println(JSON.toJSON(messages));
    }
}
